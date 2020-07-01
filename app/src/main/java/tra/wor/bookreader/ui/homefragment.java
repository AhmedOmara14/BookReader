package tra.wor.bookreader.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tra.wor.bookreader.R;
import tra.wor.bookreader.data.Repositry;
import tra.wor.bookreader.pojo.items;
import tra.wor.bookreader.pojo.sports;

public class homefragment extends Fragment {

    View view;
    @BindView(R.id.search_items)
    TextView searchItems;
    @BindView(R.id.rec_programming)
    RecyclerView recProgramming;
    @BindView(R.id.rec_sports)
    RecyclerView recSports;
    sportsAdapter sportsAdapter;
    programmingAdapter programmingAdapter;
    Repositry repositry;
    ArrayList<sports> sports=new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        view= inflater.inflate(R.layout.homefragment_fragment, container, false);
        ButterKnife.bind(this, view);
        repositry= ViewModelProviders.of(this).get(Repositry.class);
        searchItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
               fragment= new searchFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
            }
        });

        getdataofsports();
        getdataofprograming();
        return view;
    }

    private void getdataofsports() {
        sports.add(new sports(R.drawable.tennis,"tennis"));
        sports.add(new sports(R.drawable.volleyball,"volleyball"));
        sports.add(new sports(R.drawable.soccer,"Football"));
        sports.add(new sports(R.drawable.basketball,"basketball"));
        recSports.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        sportsAdapter=new sportsAdapter(getContext(),sports);
        recSports.setAdapter(sportsAdapter);
    }
    private void getdataofprograming() {
        recProgramming.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        repositry.getitems("programming").observe((LifecycleOwner) getContext(), new Observer<List<items>>() {
            @Override
            public void onChanged(List<items> items) {
                programmingAdapter=new programmingAdapter(items, getContext());
                recProgramming.setAdapter(programmingAdapter);
            }
        });

    }



}