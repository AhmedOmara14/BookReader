package tra.wor.bookreader.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tra.wor.bookreader.R;
import tra.wor.bookreader.data.database;

public class favoriteFragment extends Fragment {

    View view;
    @BindView(R.id.rec_fav)
    RecyclerView recFav;
    namesportsAdapter namesportsAdapter;
    tra.wor.bookreader.data.database database1;
    private static final String TAG = "favoriteFragment";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorite_fragment, container, false);
        ButterKnife.bind(this, view);
         recFav.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        database1=new database(getContext());
        if ( database1.getAllElements().size()<=0 ){
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        }
        else if ( database1.getAllElements().size()>0){
             namesportsAdapter=new namesportsAdapter(database1.getAllElements(),getContext());
            recFav.setAdapter(namesportsAdapter);


        }
        return view;
    }

}