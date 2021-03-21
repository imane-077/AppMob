package com.openclassrooms.connexion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends FirebaseRecyclerAdapter<Model, Adapter.ViewHolder> {
    public Adapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model model) {

        holder.pays.setText(model.getPays());
        holder.lieu.setText(model.getLieu());
        holder.env.setText(model.getEnv());
        Glide.with(holder.img.getContext()).load(model.getImage()).into(holder.img);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(view);

    }


    class  ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView pays, lieu, env;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=(CircleImageView)itemView.findViewById(R.id.img1);
            pays=(TextView)itemView.findViewById(R.id.lieutext);
            lieu=(TextView)itemView.findViewById(R.id.paystext);
            env=(TextView)itemView.findViewById(R.id.envtext);

        }
    }
}
