package tra.wor.bookreader.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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


public class searchFragment extends Fragment {


    @BindView(R.id.search_title)
    EditText searchTitle;
    @BindView(R.id.btn_author)
    Button btnAuthor;
    @BindView(R.id.btn_title)
    Button btnTitle;
    @BindView(R.id.rec_search)
    RecyclerView recSearch;
    View view;
    Repositry repositry;
    namesportsAdapter namesportsAdapter;
    @BindView(R.id.notfounded_)
    TextView fo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        repositry = ViewModelProviders.of(this).get(Repositry.class);
        recSearch.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAuthor.setBackgroundResource(R.drawable.active);
                btnTitle.setBackgroundResource(R.drawable.back_btn);
                repositry.getitems("programming").observe((LifecycleOwner) getContext(), new Observer<List<items>>() {
                    @Override
                    public void onChanged(List<items> items) {
                        List<items> list = new ArrayList();
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).getVolumeInfo().getAuthors().get(0).toString().contains(searchTitle.getText().toString().toLowerCase())) {
                                recSearch.setVisibility(View.VISIBLE);
                                fo.setVisibility(View.INVISIBLE);
                                list.add(items.get(i));
                                namesportsAdapter = new namesportsAdapter(list, getContext());
                                recSearch.setAdapter(namesportsAdapter);
                            }

                        }
                    }
                });
            }
        });
        btnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTitle.setBackgroundResource(R.drawable.active);
                btnAuthor.setBackgroundResource(R.drawable.back_btn);
                repositry.getitems("programming").observe((LifecycleOwner) getContext(), new Observer<List<items>>() {
                    @Override
                    public void onChanged(List<items> items) {
                        List<items> list = new ArrayList();
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).getVolumeInfo().getTitle().toString().contains(searchTitle.getText().toString().toLowerCase())) {
                                recSearch.setVisibility(View.VISIBLE);
                                fo.setVisibility(View.INVISIBLE);
                                list.add(items.get(i));
                                namesportsAdapter = new namesportsAdapter(list, getContext());
                                recSearch.setAdapter(namesportsAdapter);
                            }

                        }
                    }
                });
            }
        });
        return view;
    }
}