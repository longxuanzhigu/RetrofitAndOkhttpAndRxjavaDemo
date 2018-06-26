package com.showly.retrofitandokhttpandrxjavademo.httpUtil.interfaceService;

import com.showly.retrofitandokhttpandrxjavademo.bean.movieTopReq;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieService {
    //获取豆瓣前20的榜单
    @GET("top250")
    Observable<movieTopReq> getMovicTop(@Query("start") int start, @Query("count") int count);
}