package com.example.test.Presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Data.PostModel;
import com.example.test.R;

import java.util.ArrayList;

public class RecPosts extends RecyclerView.Adapter<RecPosts.Holder> {

    ArrayList<PostModel>list=new ArrayList<>();

   public RecPosts(ArrayList<PostModel>list){

       this.list=list;

   }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.id.setText(String.valueOf(list.get(position).getId()));
        holder.Post.setText(list.get(position).getBody());
        holder.title.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView Post;
        TextView id;

        TextView title;
        public Holder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.Tv_id);
            Post=itemView.findViewById(R.id.Tv_Text);
            title=itemView.findViewById(R.id.Tv_Title);

        }
    }
}
