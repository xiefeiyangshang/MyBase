package com.xcz.baselib.weight.banner.adapter;

import android.annotation.TargetApi;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.xcz.baselib.weight.banner.BannerView;
import com.xcz.baselib.weight.banner.hint.BaseHintView;
import com.xcz.baselib.weight.banner.hint.HintViewDelegate;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * desc: AbsLoopPagerAdapter
 * Created by xcz
 * on 2018/5/18.
 */
public abstract class AbsLoopPagerAdapter extends PagerAdapter {

    private BannerView mViewPager;

    private ArrayList<View> mViewList = new ArrayList<>();

    private class LoopHintViewDelegate implements HintViewDelegate {
        @Override
        public void setCurrentPosition(int position, BaseHintView hintView) {
            if (hintView != null && getRealCount() > 0) {
                hintView.setCurrent(position % getRealCount());
            }
        }

        @Override
        public void initView(int length, int gravity, BaseHintView hintView) {
            if (hintView != null) {
                hintView.initView(getRealCount(), gravity);
            }
        }
    }

    @Override
    public void notifyDataSetChanged() {
        mViewList.clear();
        initPosition();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
        initPosition();
    }

    private void initPosition() {
        if (mViewPager.getViewPager().getCurrentItem() == 0 && getRealCount() > 0) {
            int half = Integer.MAX_VALUE / 2;
            int start = half - half % getRealCount();
            setCurrent(start);
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setCurrent(int index) {
        try {
            Field field = ViewPager.class.getDeclaredField("mCurItem");
            field.setAccessible(true);
            field.set(mViewPager.getViewPager(), index);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public AbsLoopPagerAdapter(BannerView viewPager) {
        this.mViewPager = viewPager;
        viewPager.setHintViewDelegate(new LoopHintViewDelegate());
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = position % getRealCount();
        View itemView = findViewByPosition(container, realPosition);
        container.addView(itemView);
        return itemView;
    }


    private View findViewByPosition(ViewGroup container, int position) {
        for (View view : mViewList) {
            if (((int) view.getTag()) == position && view.getParent() == null) {
                return view;
            }
        }
        View view = getView(container, position);
        view.setTag(position);
        mViewList.add(view);
        return view;
    }


    @Deprecated
    @Override
    public final int getCount() {
        return getRealCount() <= 0 ? getRealCount() : Integer.MAX_VALUE;
    }

    public abstract int getRealCount();

    public abstract View getView(ViewGroup container, int position);

}

