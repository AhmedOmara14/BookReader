package tra.wor.bookreader.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tra.wor.bookreader.R;
import tra.wor.bookreader.data.Repositry;
import tra.wor.bookreader.pojo.info_favorite;

public class favoriteFragment extends Fragment {

    View view;
    @BindView(R.id.rec_fav)
    RecyclerView recFav;
    fav_adapter namesportsAdapter;
    private static final String TAG = "favoriteFragment";
    Repositry repositry;
    List<info_favorite> favoriteList=new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorite_fragment, container, false);
        ButterKnife.bind(this, view);
        repositry = ViewModelProviders.of((FragmentActivity) getContext()).get(Repositry.class);
        recFav.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        repositry.getallrecord().observe((LifecycleOwner) getContext(), new Observer<List<info_favorite>>() {
            @Override
            public void onChanged(List<info_favorite> info_favorites) {
                favoriteList=info_favorites;
                namesportsAdapter = new fav_adapter(info_favorites, getContext());
                recFav.setAdapter(namesportsAdapter);
                new ItemTouchHelper(simpleCallback).attachToRecyclerView(recFav);
            }
        });

        return view;
    }

    ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            info_favorite info_favorite=new info_favorite(favoriteList.get(viewHolder.getAdapterPosition()).getImage(),
                    favoriteList.get(viewHolder.getAdapterPosition()).getTitle(),
                    favoriteList.get(viewHolder.getAdapterPosition()).getAuthor(),
                    favoriteList.get(viewHolder.getAdapterPosition()).getDes());
            info_favorite.setId(favoriteList.get(viewHolder.getAdapterPosition()).getId());
            repositry.delete(info_favorite);
            namesportsAdapter.notifyDataSetChanged();

        }
    };

}