package com.example.clas.gym_club;
import com.example.clas.gym_club.Model.Trainee;
import com.example.clas.gym_club.adapter.TraineeAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Coach_TraineeFragment extends ListFragment {
    //Searching String , when == 'ALL' list all
    String searchingString = "ALL";

    private List<Trainee> traineeList = new ArrayList<>();
    private RecyclerView recyclerView;

    private void initTrainee(){

        Trainee trainees[] = {
                new Trainee("Han yutong",
                        "Running is my life! Wanna be stronger!!",
                        R.drawable.trainee1),
                new Trainee("zzHyt",
                        "A little bit stupid? Nothing!",
                        R.drawable.trainee2),
                new Trainee("toto",
                        "It never too late to learn.",
                         R.drawable.trainee3),
                new Trainee("Yoann",
                        "Read the f**king manual.",
                        R.drawable.trainee4),
                new Trainee("LuV",
                        "Software doesn't change live, People do.",
                        R.drawable.trainee5),
                new Trainee("Bat",
                        "Every beautiful girls love Bat!",
                        R.drawable.trainee6),
                new Trainee("Urara",
                        "Divining and running, occasionally learning",
                        R.drawable.trainee7),
                new Trainee("lt",
                        "Badminton racket is my life!!",
                        R.drawable.trainee8),
                new Trainee("Wu Qiang",
                        "The student of an international vocalist secluded from the world.",
                        R.drawable.trainee10),
                new Trainee("Que Sera",
                        "I love learning!",
                        R.drawable.trainee9),
        };
        for(int i = 0; i < trainees.length; i++){
            traineeList.add(trainees[i]);
        }

    }

    public Coach_TraineeFragment() {
        // Required empty public constructor
        Log.e("e_myPlanFra_cons","#1");
    }

    public Coach_TraineeFragment(String searchingString){
        this.searchingString = searchingString;
        Log.e("e_myPlanFra_cons", "#1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initTrainee();
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.trainee_recycler) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        TraineeAdapter adapter = new TraineeAdapter(traineeList);
        recyclerView.setAdapter(adapter);



        //FILL
        Log.e("e_Plan_ALL ","searchingString#"+searchingString+"#"+searchingString.length());
        if("ALL".equals(searchingString))
        {
            Log.e("e_Plan_ALL ","#1"+searchingString);
            adapter = new TraineeAdapter(traineeList);
            recyclerView.setAdapter(adapter);
        }
        else {
            Log.e("e_Plan_ALL ","#2"+searchingString);
            List<Trainee> temp = new ArrayList<>();
            for (int i = 0; i < traineeList.size(); i++) {
                if (traineeList.get(i).getName() .equals( searchingString)) {
                    Log.e("e_Plan_searching ", "Found#" + traineeList.get(i));
                    temp.add(traineeList.get(i));
                    break;
                }
            }
            adapter = new TraineeAdapter(temp);
            recyclerView.setAdapter(adapter);

        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}

