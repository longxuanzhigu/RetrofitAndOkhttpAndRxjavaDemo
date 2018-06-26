package com.showly.retrofitandokhttpandrxjavademo.httpUtil.retrofitHttp1;

import com.showly.retrofitandokhttpandrxjavademo.bean.movieTopReq;
import com.showly.retrofitandokhttpandrxjavademo.httpUtil.interfaceService.MovieService;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/25.
 */

public class HttpEngine {

    private static MovieService movieService = RetrofitServiceManager.getInstance().create(MovieService.class);

    /*
    * 获取豆瓣电影榜单
    * **/
    public static void getDuoBanTop(int start, int count, Observer<movieTopReq> observer) {
        setSubscribe(movieService.getMovicTop(start, count), observer);
    }

    private static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }
}
