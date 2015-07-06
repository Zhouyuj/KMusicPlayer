package com.example.arnol.kmusicplayer.fragment;

import android.support.v4.app.Fragment;

import com.example.arnol.kmusicplayer.OnResultListener;

/**
 * Created by arnol on 2015/7/6.
 */
public abstract  class BaseFra  extends Fragment implements OnResultListener{
    @Override
    public void onGetResult(Object result, int iError) {
    }
}
