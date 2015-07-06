package com.example.arnol.kmusicplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by arnol on 2015/7/6.
 */
public class UIManager {

    private UIManager() {
    }

    private static UIManager instance = new UIManager();

    public static UIManager getInstance() {
        return instance;
    }

    public void changeFragment(int id, Fragment fragment, String tag) {
        //同一个manager
        FragmentManager manager = GlobalParams.MAIN.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment, tag);
        transaction.commit();
    }

    public void change(Fragment fragment, boolean isAddToStack, Bundle bundle) {
        //存储数据
        if (bundle != null){
            fragment.getArguments();
        }
        FragmentManager manager = GlobalParams.MAIN.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.ii_middle,fragment);
        if(isAddToStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
