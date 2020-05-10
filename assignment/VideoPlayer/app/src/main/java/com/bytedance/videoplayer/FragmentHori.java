package com.bytedance.videoplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class FragmentHori extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_horizontal,container,false);
        CustomView videoView=view.findViewById(R.id.hVideoView);
        videoView.setMediaController(new MediaController(getContext()));
        videoView.setVideoPath(getArguments().getString("videoPath"));
        videoView.seekTo(0);
        return view;
    }
}
