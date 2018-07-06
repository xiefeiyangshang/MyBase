package com.xcz.mybase.net;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.xcz.baselib.utils.InterceptorUtils;
import com.xcz.mybase.BuildConfig;
import com.xcz.mybase.config.Constans;
import com.xcz.mybase.test.api.TestApi;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * desc:RetrofitManager管理器
 * Created by xcz
 * on 2018/7/6.
 */
public class RetrofitManager {
    private volatile static RetrofitManager retrofitManager;
    private Retrofit retrofit;
    private OkHttpClient.Builder builder;

    //无参的单利模式
    public static RetrofitManager getSingleton() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }


    //无参的构造方法
    private RetrofitManager() {
        initRetrofitManager();
    }

    //构造方法创建Retrofit实例
    private void initRetrofitManager() {
        builder = new OkHttpClient.Builder();
        //拦截日志，依赖
        builder.addInterceptor(InterceptorUtils.getHttpLoggingInterceptor(BuildConfig.DEBUG));

        //拦截日志，自定义拦截日志
        //builder.addInterceptor(new LogInterceptor("YC"));

        //添加请求头拦截器
        builder.addInterceptor(InterceptorUtils.getRequestHeader());

        //添加统一请求拦截器
        builder.addInterceptor(InterceptorUtils.commonParamsInterceptor());

        //添加缓存拦截器
        //创建Cache
        //File httpCacheDirectory = new File(Utils.getContext().getExternalCacheDir(), "YCOkHttpCache");
        //ile httpCacheDirectory = new File("YCOkHttpCache");
        //Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        //builder.cache(cache);

        //设置缓存
        //builder.addNetworkInterceptor(InterceptorUtils.getCacheInterceptor());
        //builder.addInterceptor(InterceptorUtils.getCacheInterceptor());

        //添加自定义CookieJar
        InterceptorUtils.addCookie(builder);
        initSSL();
        initTimeOut();
        OkHttpClient build = builder.build();
        //获取实例
        retrofit = new Retrofit
                //设置OKHttpClient,如果不设置会提供一个默认的
                .Builder()
                //设置baseUrl
                .baseUrl(Constans.HOST_ONLINE)
                //添加转换器Converter(将json 转为JavaBean)，用来进行响应数据转化(反序列化)的ConvertFactory
                .addConverterFactory(GsonConverterFactory.create())
                //添加自定义转换器
                //添加rx转换器，用来生成对应"Call"的CallAdapter的CallAdapterFactory
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(build)
                .build();
    }

    /**
     * 初始化完全信任的信任管理器
     */
    @SuppressWarnings("deprecation")
    private void initSSL() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }};

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置读取超时时间，连接超时时间，写入超时时间值
     */
    private void initTimeOut() {
        builder.readTimeout(20000, TimeUnit.SECONDS);
        builder.connectTimeout(10000, TimeUnit.SECONDS);
        builder.writeTimeout(20000, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
    }

    private TestApi testApi;

    public TestApi getTestRetrofit() {
        if (testApi == null) {
            testApi = retrofit.create(TestApi.class);
        }
        return testApi;
    }
}
