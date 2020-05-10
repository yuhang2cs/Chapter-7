package com.bytedance.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentVerti extends Fragment {
    public interface CurrentPosition{
        void setPosition(int position);
    }
    private VideoView videoView;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
//        CurrentPosition curPosition = (CurrentPosition) getActivity();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_verti,container,false);
        videoView=view.findViewById(R.id.vVideoView);
        videoView.setMediaController(new MediaController(getContext()));
        videoView.setVideoPath(getArguments().getString("videoPath"));
//        videoView.seekTo(0);
        Button btnPause=view.findViewById(R.id.vpauseBut);
        btnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                videoView.pause();
            }
        });
        Button btnPlay=view.findViewById(R.id.vplayBut);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();
            }
        });
        return view;
    }

}
