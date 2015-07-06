package com.example.arnol.kmusicplayer;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.arnol.kmusicplayer.fragment.BaseFragment;
import com.example.arnol.kmusicplayer.fragment.MoreFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout ii_middle;
    private BaseFragment fragment;
    private MoreFragment moreFragment;
    private ImageView home;
    private ImageView channel;
    private ImageView search;
    private ImageView myself;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.il_main);
        init();
    }

    private void init() {
        GlobalParams.MAIN = this;
        addHome();
        initBottom();
        setListener();
        //addMore();
    }

    private void setListener() {
        home.setOnClickListener(this);
        channel.setOnClickListener(this);
        search.setOnClickListener(this);
        myself.setOnClickListener(this);
    }

    private void initBottom() {
        home = (ImageView) findViewById(R.id.ii_bottom_home);
        channel = (ImageView) findViewById(R.id.ii_bottom_channel);
        search = (ImageView) findViewById(R.id.ii_bottom_search);
        myself = (ImageView) findViewById(R.id.ii_bottom_lottery_myself);
        title = (TextView) findViewById(R.id.ii_title_content);

        title.setText("首页");
    }

    private void addHome() {
        fragment = new BaseFragment();
        UIManager.getInstance().changeFragment(R.id.ii_middle, fragment, "homefragment");
    }

    private void addHome1() {
        fragment = new BaseFragment();
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.ii_middle, fragment, "basefragment");
        //界面加入到堆栈中
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void addMore1() {
        moreFragment = new MoreFragment();
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.ii_middle, moreFragment, "morefragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onClick(View v) {
        home.setImageResource(getImageId(0, false));
        channel.setImageResource(getImageId(1, false));
        search.setImageResource(getImageId(2, false));
        myself.setImageResource(getImageId(3, false));

        switch (v.getId()) {
            case R.id.ii_bottom_home:
                title.setText("首页");
                home.setImageResource(getImageId(0, true));
                addHome();
                break;
            case R.id.ii_bottom_channel:
                title.setText("频道");
                channel.setImageResource(getImageId(1, true));
                //addMore();
                break;
            case R.id.ii_bottom_search:
                title.setText("本地视频");
                search.setImageResource(getImageId(2, true));
                break;
            case R.id.ii_bottom_lottery_myself:
                title.setText("我的影视大全");
                myself.setImageResource(getImageId(3, true));
                break;
        }
    }

    private int getImageId(int paramInt, boolean paramBoolean) {
        switch (paramInt) {
            default:
                return -1;
            case 0:
                if (paramBoolean)
                    return R.drawable.ic_tab_home_press;
                return R.drawable.ic_tab_home;
            case 1:
                if (paramBoolean)
                    return R.drawable.ic_tab_channel_press;
                return R.drawable.ic_tab_channel;
            case 2:
                if (paramBoolean)
                    return R.drawable.ic_tab_search_press;
                return R.drawable.ic_tab_search;
            case 3:
                if (paramBoolean)
                    return R.drawable.ic_tab_my_press;
                return R.drawable.ic_tab_my;
        }
    }


}
