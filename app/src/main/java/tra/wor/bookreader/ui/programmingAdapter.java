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

import java.util.List;

import tra.wor.bookreader.R;
import tra.wor.bookreader.pojo.items;

public class programmingAdapter extends RecyclerView.Adapter<programmingAdapter.viewholder> {
   List<items> programmings;
   Context context;

    public programmingAdapter(List<items> programmings, Context context) {
        this.programmings = programmings;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(context).inflate(R.layout.layout_rec_programming,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get().load(programmings.get(position).getVolumeInfo().getImageLinks().getThumbnail()).into(holder.imageView);
        holder.textView.setText(programmings.get(position).getVolumeInfo().getTitle());
        holder.title.setText(programmings.get(position).getVolumeInfo().getAuthors().get(0)+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,showbook.class);
                intent.putExtra("image",programmings.get(position).getVolumeInfo().getImageLinks().getThumbnail());
                intent.putExtra("title",programmings.get(position).getVolumeInfo().getTitle());
                intent.putExtra("author",programmings.get(position).getVolumeInfo().getAuthors());
                intent.putExtra("des",programmings.get(position).getVolumeInfo().getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return programmings.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView title;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_prog);
            textView=itemView.findViewById(R.id.name_prog);
            title=itemView.findViewById(R.id.title_prog);

        }
    }
}
