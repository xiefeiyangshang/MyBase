package com.xcz.mybase.test.bean;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public class WeatherBean {


    /**
     * resultcode : 200
     * reason : successed!
     * result : {"sk":{"temp":"34","wind_direction":"东南风","wind_strength":"4级","humidity":"40%","time":"17:34"},"today":{"temperature":"23℃~34℃","weather":"多云转阴","weather_id":{"fa":"01","fb":"02"},"wind":"东南风微风","week":"星期五","city":"北京","date_y":"2018年07月06日","dressing_index":"炎热","dressing_advice":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"较适宜","travel_index":"较适宜","exercise_index":"较适宜","drying_index":""},"future":{"day_20180706":{"temperature":"23℃~34℃","weather":"多云转阴","weather_id":{"fa":"01","fb":"02"},"wind":"东南风微风","week":"星期五","date":"20180706"},"day_20180707":{"temperature":"24℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"东南风微风","week":"星期六","date":"20180707"},"day_20180708":{"temperature":"22℃~27℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"南风微风","week":"星期日","date":"20180708"},"day_20180709":{"temperature":"22℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东风微风","week":"星期一","date":"20180709"},"day_20180710":{"temperature":"23℃~31℃","weather":"多云转阴","weather_id":{"fa":"01","fb":"02"},"wind":"东风微风","week":"星期二","date":"20180710"},"day_20180711":{"temperature":"22℃~27℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"南风微风","week":"星期三","date":"20180711"},"day_20180712":{"temperature":"22℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东风微风","week":"星期四","date":"20180712"}}}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

}
