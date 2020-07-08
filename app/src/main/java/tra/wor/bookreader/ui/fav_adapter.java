package tra.wor.bookreader.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tra.wor.bookreader.R;
import tra.wor.bookreader.pojo.info_favorite;

public class fav_adapter  extends RecyclerView.Adapter<fav_adapter.viewholder> {
    List<info_favorite> favoriteList=new ArrayList<>();
    Context context;

    public fav_adapter(List<info_favorite> favoriteList, Context context) {
        this.favoriteList = favoriteList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new fav_adapter.viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sports_name,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get().load(favoriteList.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(favoriteList.get(position).getTitle());
     //   ArrayList nam=favoriteList.get(position).getAuthor();
        if (favoriteList.get(position).getAuthor() ==null){
            holder.title.setText("No Author");
        }else {
            holder.title.setText(favoriteList.get(position).getTitle()+"");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,showbook.class);
                intent.putExtra("image",favoriteList.get(position).getImage());
                intent.putExtra("title",favoriteList.get(position).getTitle());
                intent.putExtra("author",favoriteList.get(position).getAuthor());
                intent.putExtra("des",favoriteList.get(position).getDes());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView title;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_prog2);
            textView=itemView.findViewById(R.id.name_prog2);
            title=itemView.findViewById(R.id.title_prog2);

        }
    }

}
