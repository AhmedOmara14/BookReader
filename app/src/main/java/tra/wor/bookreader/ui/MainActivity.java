package tra.wor.bookreader.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import tra.wor.bookreader.R;
import tra.wor.bookreader.data.database;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.ch)
    ChipNavigationBar ch;
        database database=new database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new homefragment()).commit();

        ch.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                choice(i);
            }
        });
    }

    private void choice(int i) {
        Fragment fragment = null;
        if (i == R.id.home)
            fragment = new homefragment();
        else if (i == R.id.search)
            fragment = new searchFragment();
        else if (i == R.id.fav)
            fragment = new favoriteFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
    }


}