package com.example.arnol.kmusicplayer;

/**
 * 处理结果的监听
 * Created by arnol on 2015/7/6.
 */
public interface OnResultListener {
    /**
     * 结果处理
     *
     * @param result
     * @param iError
     *            :结果的状态码
     */
    void onGetResult(Object result, int iError);
}
