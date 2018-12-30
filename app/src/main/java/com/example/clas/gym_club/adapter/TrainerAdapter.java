package com.example.clas.gym_club.adapter;
import com.example.clas.gym_club.R;
import com.example.clas.gym_club.Model.Trainer;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.ViewHolder>{
    private List<Trainer> trainerList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1;
        TextView nameTxt;
        TextView learnerTxt;
        TextView infoTxt;

        public ViewHolder(View view){
            super(view);
            imageView1 = (ImageView)view.findViewById(R.id.imageView1);
            nameTxt = (TextView)view.findViewById(R.id.nameTxt);
            learnerTxt = (TextView)view.findViewById(R.id.lernerTxt);
            infoTxt = (TextView)view.findViewById(R.id.infoTxt);
        }

    }

    public TrainerAdapter(List<Trainer> trainerList){
        this.trainerList = trainerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Trainer trainer = trainerList.get(position);
        holder.imageView1.setImageResource(trainer.getImageId());
        holder.nameTxt.setText(trainer.getName());
        holder.learnerTxt.setText(trainer.getLearnerNum());
        holder.infoTxt.setText(trainer.getInfo());
    }
    @Override
    public int getItemCount(){
        return trainerList == null? 0 : trainerList.size();
    }
}
