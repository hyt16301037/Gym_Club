package com.example.clas.gym_club;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.clas.gym_club.Model.Trainer;
import com.example.clas.gym_club.adapter.TrainerAdapter;
import android.content.Context;
import android.content.ContentProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Coach_PlanFragment extends ListFragment {
    //Searching String , when == 'ALL' list all
    String searchingString = "ALL";

    private List<Trainer> trainerList = new ArrayList<>();
    private RecyclerView recyclerView;

    private void initTrainer(){
        /*Trainer trainers[] = {
                new Trainer("Wang Mo",
                        "Perfection is not attainable, but if we chase perfection we can catch excellence",
                        "Students(11)", R.drawable.trainer1)};*/
        //没有找到Trainer类，很奇怪
        Uri uri = Uri.parse("content://com.example.clas.gym_club.database.provider/private_coach");
        Cursor cursor = this.getContext().getContentResolver().query(uri, null, null, null, null);
        if(cursor.moveToFirst())//游标查询，在循环中构建教练对象，并插入trainerList
        {
            do
            {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String des = cursor.getString(cursor.getColumnIndex("des"));//教练描述
                String res = cursor.getString(cursor.getColumnIndex("res"));//图片资源名
                String count = cursor.getString(cursor.getColumnIndex("count"));//学生数
                String str[] = res.split("\\.");
                Context ctx= this.getContext();
                int resId = getResources().getIdentifier(str[2], "drawable", ctx.getPackageName());
                trainerList.add(new Trainer(name, des, count, resId));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        /*for(int i = 0; i < trainers.length; i++){
            trainerList.add(trainers[i]);
        }*/
    }

    public Coach_PlanFragment() {
        // Required empty public constructor
        Log.e("e_myPlanFra_cons","#1");
    }

    public Coach_PlanFragment(String searchingString){
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

