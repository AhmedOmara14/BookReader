package tra.wor.bookreader.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import tra.wor.bookreader.R;
import tra.wor.bookreader.data.Repositry;
import tra.wor.bookreader.pojo.info_favorite;

public class showbook extends AppCompatActivity {
    String img, des,title,author;
    @BindView(R.id.header_image)
    ImageView headerImage;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    Repositry repositry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbook);
        ButterKnife.bind(this);
        img = getIntent().getExtras().get("image").toString();
        title = getIntent().getExtras().get("title").toString();
        author = "No Author";

        String[] b = new String[1];
        String[] c = new String[1];

        b[0] = getIntent().getExtras().get("des") + "";
        c[0] = getIntent().getExtras().get("author") + "";

        repositry= ViewModelProviders.of(this).get(Repositry.class);
        textView.setText("No Description");
        if (!b[0].equals("null")) {
            des = getIntent().getExtras().get("des").toString();
            textView.setText(des);
        }
        if (!c[0].equals("null")) {
            author = getIntent().getExtras().get("author").toString();
        }
        Picasso.get().load(img).into(headerImage);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_favorite info_favorite=new info_favorite(img,title,author,des);
              repositry.insert(info_favorite);
            }
        });

    }
}