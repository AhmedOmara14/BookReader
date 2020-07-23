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
import tra.wor.bookreader.pojo.sports;
import tra.wor.bookreader.ui.main.showsports;

public class sportsAdapter extends RecyclerView.Adapter<sportsAdapter.viewholder> {

    Context context;
    List<sports> sports;

    public sportsAdapter(Context context, List<tra.wor.bookreader.pojo.sports> sports) {
        this.context = context;
        this.sports = sports;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(context).inflate(R.layout.layout_rec_sports,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get().load(sports.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(sports.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, showsports.class);
                intent.putExtra("sport",sports.get(position).getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_sports);
            textView=itemView.findViewById(R.id.name_sports);

        }
    }
}
