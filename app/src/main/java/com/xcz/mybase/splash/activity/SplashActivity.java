package com.xcz.mybase.splash.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xcz.baselib.activity.BaseActivity;
import com.xcz.baselib.utils.ActivityUtils;
import com.xcz.baselib.utils.SizeUtil;
import com.xcz.baselib.utils.bar.AppBar;
import com.xcz.baselib.utils.sp.SPUtils;
import com.xcz.baselib.weight.CountDownView;
import com.xcz.baselib.weight.banner.BannerView;
import com.xcz.baselib.weight.banner.OnPageListener;
import com.xcz.baselib.weight.banner.adapter.AbsDynamicPagerAdapter;
import com.xcz.mybase.MyConfigs;
import com.xcz.mybase.R;
import com.xcz.mybase.main.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * desc: 欢迎页面
 * Created by xcz
 * on 2018/5/18.
 */
public class SplashActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.banner)
    BannerView bannerView;
    @BindView(R.id.v_count_down)
    CountDownView countDown;

    private List<String> images;

    @Override
    public int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppBar.translucentStatusBar(this, true);
    }

    @Override
    public void initView() {
        if (SPUtils.getInstance(MyConfigs.SP_NAME).getBoolean(MyConfigs.FIRST_SPLASH, true)) {
            initImages(4);
        } else {
            initImages(1);
        }
        initBanner();
        initCountDownView();
    }

    /**
     * 初始化首次进入应用的图片
     */
    private void initImages(int number) {
        images = new ArrayList<>();
        String[] img = getResources().getStringArray(R.array.splash_image);
        for (String list : img) {
            images.add(list);
        }
        if (number == 1) {
            images.clear();
            images.add("1");
        }
        if (images.size() > 1) {
            countDown.setVisibility(View.GONE);
        } else {
            countDown.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 初始化banner
     */
    private void initBanner() {
        bannerView.setPlayDelay(0);
        bannerView.setHintGravity(Gravity.BOTTOM);
        bannerView.setHintPadding(SizeUtil.dip2px(this, 10), 0, 0, SizeUtil.dip2px(this, 10));
        bannerView.setOnPageListener(new OnPageListener() {
            @Override
            public void onPageChange(int position) {
                if (position == 3) {
                    SPUtils.getInstance(MyConfigs.SP_NAME).put(MyConfigs.FIRST_SPLASH, false);
                    toMainActivity();
                }
            }
        });
        bannerView.setAdapter(new ImageNormalAdapter());
    }

    @Override
    public void initListener() {
        countDown.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.v_count_down:
                countDown.stop();
                finish();
                break;
        }
    }

    private class ImageNormalAdapter extends AbsDynamicPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {
            TextView view = new TextView(container.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setGravity(Gravity.CENTER);
            view.setTextSize(SizeUtil.dip2px(container.getContext(), 40));
            view.setText(images.get(position));
            return view;
        }

        @Override
        public int getCount() {
            return images == null ? 0 : images.size();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDown != null && countDown.isShown()) {
            countDown.stop();
        }
    }

    private void initCountDownView() {
        countDown.setTime(5);
        countDown.start();
        countDown.setOnLoadingFinishListener(new CountDownView.OnLoadingFinishListener() {
            @Override
            public void finish() {
                if (countDown.isShown()) {
                    toMainActivity();
                }
            }
        });

    }

    /**
     * 跳转到主页
     */
    private void toMainActivity() {
        ActivityUtils.startActivity(MainActivity.class);
        finish();
    }

}
