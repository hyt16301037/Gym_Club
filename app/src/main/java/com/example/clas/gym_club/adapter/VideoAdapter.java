package com.example.clas.gym_club.adapter;

import com.example.clas.gym_club.Model.Video;
import com.example.clas.gym_club.CustomVideoView;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.example.clas.gym_club.R;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/12/1.
 */

public class VideoAdapter extends ArrayAdapter<Video>
{
    private int resourceId;
    public VideoAdapter(Context context, int textViewResoyrceId, List<Video> objects)
    {
        super(context, textViewResoyrceId, objects);
        resourceId  = textViewResoyrceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Video video = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        final CustomVideoView videoView = (CustomVideoView) view.findViewById(R.id.player);
        final TextView textView = (TextView) view.findViewById(R.id.title);
        final ImageView imageView = (ImageView) view.findViewById(R.id.bitImage);
        final String videoUrl = video.getUrl();
        final Uri uri = Uri.parse( videoUrl);
        //final String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526158872907&di=410c4c0fdc85f768e6b4fb8a8b6cf208&imgtype=0&src=http%3A%2F%2F09.imgmini.eastday.com%2Fmobile%2F20180506%2F20180506234300_a1330efaec84d2361efd72e3976ee181_2.jpeg";
        final String imageUrl = "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690";

        //网络请求耗时，必须放在新线程
        new Thread()
        {
            @Override
            public void run()
            {
                //initImage(videoUrl, imageView);//这种方法比较man
                Bitmap bitmap = getHttpBitmap(imageUrl);
                imageView.setImageBitmap(bitmap);
            }
        }.start();

        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(getContext()));
        videoView.requestFocus();
        videoView.setVisibility(View.VISIBLE);
        //videoView.start();
        textView.setText(video.getTitle());

        return view;
    }

    //获取第一帧作为封面
    public void initImage(String url, ImageView imageView)
    {
        imageView.setVisibility(View.VISIBLE);
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try
        {
            //根据url获取缩略图
            retriever.setDataSource(url, new HashMap());
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
            imageView.setImageBitmap(bitmap);
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        finally
        {
            retriever.release();
        }
    }

    public static Bitmap getHttpBitmap(String url)
    {
        URL myFileURL;
        Bitmap bitmap=null;
        try{
            myFileURL = new URL(url);
            //获得连接
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
            conn.setConnectTimeout(6000);
            //连接设置获得数据流
            conn.setDoInput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //这句可有可无，没有影响
            //conn.connect();
            //得到数据流
            InputStream is = conn.getInputStream();
            //解析得到图片
            bitmap = BitmapFactory.decodeStream(is);
            //关闭数据流
            is.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bitmap;
    }
}
