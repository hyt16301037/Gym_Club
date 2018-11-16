package com.example.clas.gym_club.adapter;
import com.example.clas.gym_club.R;
import com.example.clas.gym_club.Model.Trainee;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class TraineeAdapter extends RecyclerView.Adapter<TraineeAdapter.ViewHolder>{
    private List<Trainee> traineeList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1;
        TextView nameTxt;
        TextView infoTxt;
        public ViewHolder(View view){
            super(view);
            imageView1 = (ImageView)view.findViewById(R.id.imageView1);
            nameTxt = (TextView)view.findViewById(R.id.nameTxt);
            infoTxt = (TextView)view.findViewById(R.id.infoTxt);
        }

    }

    public TraineeAdapter(List<Trainee> traineeList){
        this.traineeList = traineeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainee_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Trainee trainer = traineeList.get(position);
        holder.imageView1.setImageResource(trainer.getImageId());
        holder.nameTxt.setText(trainer.getName());
        holder.infoTxt.setText(trainer.getInfo());
    }
    @Override
    public int getItemCount(){
        return traineeList == null? 0 : traineeList.size();
    }
}
