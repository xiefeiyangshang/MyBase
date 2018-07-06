package com.xcz.mybase.main.activity;

import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.xcz.baselib.activity.BaseActivity;
import com.xcz.baselib.mvp.BasePresenter;
import com.xcz.baselib.utils.SizeUtil;
import com.xcz.baselib.weight.banner.BannerView;
import com.xcz.baselib.weight.banner.OnBannerClickListener;
import com.xcz.baselib.weight.banner.OnPageListener;
import com.xcz.baselib.weight.banner.adapter.AbsDynamicPagerAdapter;
import com.xcz.mybase.R;
import com.xcz.mybase.test.activity.TestActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.panpf.sketch.SketchImageView;
import me.panpf.sketch.request.DisplayOptions;

public class MainActivity extends BaseActivity {

    @BindView(R.id.banner_main)
    BannerView bannerView;
    private List<String> imgs = new ArrayList<>();
    private ImageNormalAdapter adapter;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initBanner();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        imgs.add("http://p7darzh4d.bkt.clouddn.com/FvJRjuP1f95-1GcXnoFsUtiVMj2C");
        imgs.add("http://p7darzh4d.bkt.clouddn.com/Fiyc_vbW2uNO0W8xEfXcVQDDUbdC");
        bannerView.getViewPager().setCurrentItem(1);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initSketview(SketchImageView sketchImageView) {
        sketchImageView.displayResourceImage(R.mipmap.demo);
        DisplayOptions displayOptions = new DisplayOptions();
//        displayOptions.setLoadingImage(R.drawable.image_loading);
//        displayOptions.setErrorImage(R.drawable.image_error);
        sketchImageView.setOptions(displayOptions);
        sketchImageView.setZoomEnabled(true);
        sketchImageView.getZoomer().zoom(3f, true);
        sketchImageView.getZoomer().setZoomDuration(500);
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

            }
        });
        adapter = new ImageNormalAdapter();
        bannerView.setAdapter(adapter);
        bannerView.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onItemClick(int position) {
                finish();
            }

            @Override
            public void onItemDoubleClick(int position) {
            }
        });
    }


    private class ImageNormalAdapter extends AbsDynamicPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {
            SketchImageView view = new SketchImageView(container.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            initSketview(view);
            view.displayImage(imgs.get(position));
            return view;
        }

        @Override
        public int getCount() {
            return imgs == null ? 0 : imgs.size();
        }
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        boolean result = true;
        try {
            result = super.dispatchTouchEvent(ev);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return result;
    }

    @OnClick({R.id.to_web})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.to_web:
//                Bundle bundle = new Bundle();
//                bundle.putString("name", "百度");
//                bundle.putString("url", "http://awd.wyzwedu.com/bxxApis/download/free/BS18WL10ACQG/trialRead.html#/");
                startActivity(TestActivity.class, null);
                break;
        }
    }
}
