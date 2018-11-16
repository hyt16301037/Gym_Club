package com.example.clas.gym_club;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManageFragment extends Fragment {


    public ManageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage, container, false);
    }

    public void onStart() {
        super.onStart();

        Button button1 = (Button) getActivity().findViewById(R.id.mem_training_btn);
        Button button2 = (Button) getActivity().findViewById(R.id.coach_training_btn);
        Button button3 = (Button) getActivity().findViewById(R.id.coach_trainee_btn);
        Button button4 = (Button) getActivity().findViewById(R.id.coach_add_btn);
        Button button5 = (Button) getActivity().findViewById(R.id.coach_publish_btn);

        // Button1: training btn for member
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem="会员您好，这里是您的训练训练清单。";
                Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content_frame, new TrainingFragment().newInstance(1)).commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainer_content,new Mem_PlanFragment("ALL")).commit();
            }
        });

        // Button2: training btn for coach
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem="教练您好，这里是您的训练课程清单。";
                Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content_frame, new TrainingFragment().newInstance(2)).commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainer_content,new Coach_PlanFragment("ALL")).commit();
            }
        });

        // Button3: trainee btn for coach
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem="教练您好，这里是您的学员清单。";
                Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content_frame, new TraineeFragment()).commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainee_content,new Coach_TraineeFragment("ALL")).commit();
            }
        });

        // Button4: add btn for coach
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem="教练您好，您可在此进行添加操作。";
                Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content_frame, new AddFragment()).commit();
            }
        });

        // Button5: public btn for coach
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem="教练您好，您可在此发布消息。";
                Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content_frame, new PublishFragment()).commit();
            }
        });
    }
}
