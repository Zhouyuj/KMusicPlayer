package com.example.arnol.kmusicplayer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arnol.kmusicplayer.R;

/**
 * Created by arnol on 2015/7/6.
 */
public class MoreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.il_channel, container, false);

        return view;
    }
}
