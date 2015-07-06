package com.example.arnol.kmusicplayer;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;

import com.example.arnol.kmusicplayer.util.SoftValueMap;

/**
 * Created by arnol on 2015/7/6.
 */
public class GlobalParams {

    /**
     * Activity引用
     */
    public static FragmentActivity MAIN;
    /**
     * wap的ip信息
     */
    public static String PROXY_IP = "";
    /**
     * wap的端口信息
     */
    public static int PROXY_PORT = 0;
    /**
     * 少量图片的软引用的集合
     */
    public static SoftValueMap<Object, Bitmap> IMGCACHE = new SoftValueMap<Object, Bitmap>();
}
