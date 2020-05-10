package com.bytedance.videoplayer;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle=new Bundle();
        View container=findViewById(R.id.vertContainer);
        String externVideo=null;
        String videoPath=null;
        if(getIntent().getDataString()!=null)
            externVideo=getIntent().getDataString().toString();
        if(externVideo==null)
            videoPath=Uri.parse("android.resource://"+getPackageName()+"/raw/"+R.raw.bytedance).toString();
        else
            videoPath=externVideo;
        bundle.putString("videoPath",videoPath);
        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {//竖屏
            WindowManager.LayoutParams layoutParams1=getWindow().getAttributes();
            layoutParams1.flags&=(~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(layoutParams1);
            if(getSupportActionBar()!=null)
                getSupportActionBar().show();
            FragmentVerti fragmentVerti=new FragmentVerti();
            fragmentVerti.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.vertContainer,fragmentVerti)
                    .commit();
        }else {
            WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
            layoutParams.flags|=WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(layoutParams);
            if(getSupportActionBar()!=null)
                getSupportActionBar().hide();
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            FragmentHori fragmentHori=new FragmentHori();
            fragmentHori.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.vertContainer,fragmentHori)
                    .commit();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        Bundle bundle=new Bundle();
        View container=findViewById(R.id.vertContainer);
        String externVideo=null;
        String videoPath=null;
        if(getIntent().getDataString()!=null)
            externVideo=getIntent().getDataString().toString();
        if(externVideo==null)
            videoPath=Uri.parse("android.resource://"+getPackageName()+"/raw/"+R.raw.bytedance).toString();
        else
            videoPath=externVideo;
        bundle.putString("videoPath",videoPath);
        Log.d("yuhang",bundle.getString("videoPath"));
        if(newConfig.orientation== Configuration.ORIENTATION_PORTRAIT)
        {//竖屏
            Log.d("yuhang","竖屏");
            WindowManager.LayoutParams layoutParams1=getWindow().getAttributes();
            layoutParams1.flags&=(~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(layoutParams1);
            if(getSupportActionBar()!=null)
                getSupportActionBar().show();
            FragmentVerti fragmentVerti=new FragmentVerti();
            fragmentVerti.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.vertContainer,fragmentVerti)
                    .commit();
        }else {
            Log.d("yuhang","横屏");
            WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
            layoutParams.flags|=WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(layoutParams);
            if(getSupportActionBar()!=null)
                getSupportActionBar().hide();
            FragmentHori fragmentHori=new FragmentHori();
            fragmentHori.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.vertContainer,fragmentHori)
                    .commit();
        }
    }
}
