package com.example.arnol.kmusicplayer.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.example.arnol.kmusicplayer.ConstantValue;
import com.example.arnol.kmusicplayer.R;
import com.example.arnol.kmusicplayer.adapter.SoftcacheAdapter;
import com.example.arnol.kmusicplayer.bean.Hot;
import com.example.arnol.kmusicplayer.bean.Params;
import com.example.arnol.kmusicplayer.bean.Slice;
import com.example.arnol.kmusicplayer.util.NetWorkTask;
import com.example.arnol.kmusicplayer.util.PromptManager;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by arnol on 2015/7/6.
 */
public class BaseFragment extends BaseFra {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private GridView gridView;
    private SoftcacheAdapter adapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated");
    }

    @Override
    // container:LayoutParameter参数传递；attachToRoot：false不会挂载到root上
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.il_home,null);
        gridView = (GridView) view.findViewById(R.id.gridviewMovie);
        adapter = new SoftcacheAdapter(getActivity(),6);
        gridView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onGetResult(Object result, int iError) {
        if (iError == ConstantValue.SUCCESS && result != null) {
            String json = result.toString();

            try {
                JSONObject jsonObject = new JSONObject(json);
                List<Slice> parseArray = JSON.parseArray(
                        jsonObject.getString("slices"), Slice.class);
                Slice slice = parseArray.get(0);
                List<Hot> hot = slice.getHot();

                // 更新界面
                adapter.setHotList(hot);
                adapter.notifyDataSetChanged();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // getActivity() 当前系统仅有的Activity的引用
            PromptManager.showErrorDialog(getActivity(), "服务器忙……");
        }
        super.onGetResult(result, iError);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "onAttach");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart");
        // 发送请求，读取Json信息
        // 发送的参数：
        // ①OnResultListener实现类的对象
        // ②URL
        // ③Map<String,String> params;
        // ④是否弹出滚动条
        Params params = new Params();
        params.listener = this;
        params.url = ConstantValue.URI + ConstantValue.SLICE_URI;

        new NetWorkTask().executeProxy(params);

        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
    }
}
