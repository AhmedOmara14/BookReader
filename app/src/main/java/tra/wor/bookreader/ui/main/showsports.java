package tra.wor.bookreader.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import tra.wor.bookreader.R;
import tra.wor.bookreader.data.Repositry;
import tra.wor.bookreader.pojo.items;
import tra.wor.bookreader.ui.CustomApplication;
import tra.wor.bookreader.ui.namesportsAdapter;

public class showsports extends AppCompatActivity {

    @BindView(R.id.back)
    ImageButton back;
    @BindView(R.id.sports_nam)
    TextView sportsNam;
    @BindView(R.id.rec_sports_name)
    RecyclerView recSportsName;
    Repositry repositry;
    @Inject
    Retrofit retrofit;
    tra.wor.bookreader.ui.namesportsAdapter namesportsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsports);
        ButterKnife.bind(this);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
        ((CustomApplication) getApplication()).getNetworkComponent().inject_show(showsports.this);
        repositry= ViewModelProviders.of(this).get(Repositry.class);
       String name=getIntent().getExtras().get("sport").toString();
       sportsNam.setText(name);
       recSportsName.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
       getsports(name);
    }

    private void getsports(String name) {

          repositry.getitems(name,retrofit).observe(this, new Observer<List<items>>() {
              @Override
              public void onChanged(List<items> items) {
              namesportsAdapter=new namesportsAdapter(items,getApplicationContext());
              recSportsName.setAdapter(namesportsAdapter);
              }
          });
    }
}