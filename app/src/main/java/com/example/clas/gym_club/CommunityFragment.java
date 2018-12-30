package com.example.clas.gym_club;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.clas.gym_club.Model.Video;
import com.example.clas.gym_club.adapter.VideoAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {

    private List<Video> videoList = new ArrayList<>();
    private ListView listView;
    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initList();
        listView = (ListView)getActivity().findViewById(R.id.videoList);
        VideoAdapter videoAdapter = new VideoAdapter(this.getActivity(),R.layout.video_item,videoList);
        listView.setAdapter(videoAdapter);

        return inflater.inflate(R.layout.activity_play, container, false);
    }
    public void initList()
    {
        Video video1 = new Video("梁兴扬-意外","https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4");
        Video video2 = new Video("李宇-火箭少女101","https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4");
        videoList.add(video1);
        videoList.add(video2);
    }
}
