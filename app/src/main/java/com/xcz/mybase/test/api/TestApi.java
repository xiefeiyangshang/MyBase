package com.xcz.mybase.test.api;

import com.xcz.baselib.net.BaseResponse;
import com.xcz.mybase.test.bean.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public interface TestApi {
    @GET("weather/index")
    Observable<BaseResponse<WeatherBean>> getWeather(
            @Query("cityname") String cityName,
            @Query("dtype") String dtype,
            @Query("format") Integer fomart,
            @Query("key") String key
    );
}
