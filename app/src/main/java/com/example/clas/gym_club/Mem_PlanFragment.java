package com.example.clas.gym_club;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;

import com.example.clas.gym_club.Model.Trainer;
import com.example.clas.gym_club.adapter.TrainerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mem_PlanFragment extends ListFragment {
    //Searching String , when == 'ALL' list all
    String searchingString = "ALL";

    private List<Trainer> trainerList = new ArrayList<>();
    private RecyclerView recyclerView;

    private void initTrainer(){
        Trainer trainers[] = {
                new Trainer("Wang Mo",
                        "Perfection is not attainable, but if we chase perfection we can catch excellence",
                        "Students(11)", R.drawable.trainer1),
                new Trainer("赵武 教练",
                        "An accomplished fitness trainer with seven years of experience n hand",
                        "Students(15)", R.drawable.trainer5),
                new Trainer("Oscar",
                        "Gym doesn't change live, People do.",
                        "Students(1000)", R.drawable.trainer7)
        };
        for(int i = 0; i < trainers.length; i++){
            trainerList.add(trainers[i]);
        }

    }

    public Mem_PlanFragment() {
        // Required empty public constructor
        Log.e("e_myPlanFra_cons","#1");
    }

    public Mem_PlanFragment(String searchingString){
        this.searchingString = searchingString;
        Log.e("e_myPlanFra_cons", "#1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initTrainer();
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.trainer_recycler) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        TrainerAdapter adapter = new TrainerAdapter(trainerList);
        recyclerView.setAdapter(adapter);



        //FILL
        Log.e("e_Plan_ALL ","searchingString#"+searchingString+"#"+searchingString.length());
        if("ALL".equals(searchingString))
        {
            Log.e("e_Plan_ALL ","#1"+searchingString);
            adapter = new TrainerAdapter(trainerList);
            recyclerView.setAdapter(adapter);
        }
        else {
            Log.e("e_Plan_ALL ","#2"+searchingString);
            List<Trainer> temp = new ArrayList<>();
            for (int i = 0; i < trainerList.size(); i++) {
                if (trainerList.get(i).getName() .equals( searchingString)) {
                    Log.e("e_Plan_searching ", "Found#" + trainerList.get(i));
                    temp.add(trainerList.get(i));
                    break;
                }
            }
            adapter = new TrainerAdapter(temp);
            recyclerView.setAdapter(adapter);

        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }


   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

            }
        });
    }*/
}

