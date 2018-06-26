package com.showly.retrofitandokhttpandrxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.showly.retrofitandokhttpandrxjavademo.bean.movieTopReq;
import com.showly.retrofitandokhttpandrxjavademo.httpUtil.retrofitHttp1.HttpEngine;

import rx.Observer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {

    }

    private void initData() {
        HttpEngine.getDuoBanTop(0, 20, new Observer<movieTopReq>() {
            @Override
            public void onCompleted() {
                //完成
            }

            @Override
            public void onError(Throwable e) {
                //失败
                Log.i("retrofit==111=", "请求错误："+e.getMessage());
            }

            @Override
            public void onNext(movieTopReq movieTopReq) {
                //成功
                Log.i("retrofit==222=", movieTopReq.getTitle()+"---"+movieTopReq.getCount()
                        +"---"+movieTopReq.getStart()+"---"+movieTopReq.getTotal()+"---"+movieTopReq.getSubjects());
            }
        });
    }

    private void initListener() {

    }
}
