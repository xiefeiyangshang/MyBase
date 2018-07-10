package com.xcz.mybase.test.api;

import com.xcz.baselib.net.BaseResponse;
import com.xcz.mybase.test.bean.ResultBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public interface TestApi {
    @POST("weather/index")
    Observable<BaseResponse<ResultBean>> getWeather(
            @Query("cityname") String cityName,
            @Query("dtype") String dtype,
            @Query("format") Integer fomart,
            @Query("key") String key
    );
}
