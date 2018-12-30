package com.example.clas.gym_club;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.clas.gym_club.Model.Video;
import com.example.clas.gym_club.adapter.VideoAdapter;
import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity
{

    private List<Video> videoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initList();
        final ListView listView = (ListView)findViewById(R.id.videoList);
        VideoAdapter videoAdapter = new VideoAdapter(PlayActivity.this,R.layout.video_item,videoList);
        listView.setAdapter(videoAdapter);

    }

    public void initList()
    {
        Video video1 = new Video("梁兴扬-意外","https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4");
        Video video2 = new Video("李宇-火箭少女101","https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4");
        videoList.add(video1);
        videoList.add(video2);
    }
}
