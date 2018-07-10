package com.xcz.mybase.test.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.xcz.baselib.activity.BaseActivity;
import com.xcz.baselib.utils.ToastUtils;
import com.xcz.mybase.R;
import com.xcz.mybase.test.adapter.SimpleAdapter;
import com.xcz.mybase.test.bean.ResultBean;
import com.xcz.mybase.test.mvp.TestPresenter;
import com.xcz.mybase.test.mvp.TestView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public class TestActivity extends BaseActivity<TestPresenter> implements TestView {

    @BindView(R.id.tv_test)
    TextView text;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<ResultBean> data;
    private SimpleAdapter adapter;

    @Override
    public int getContentView() {
        return R.layout.test_activity;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        data = new ArrayList<>();
        adapter = new SimpleAdapter(data);
        adapter.setUpFetchEnable(true);
        adapter.setStartUpFetchPosition(4);
        adapter.disableLoadMoreIfNotFullPage(recyclerView);
    }

    @Override
    public void initListener() {
        recyclerView.setAdapter(adapter);
        adapter.setLoadMoreView(new SimpleLoadMoreView());
        adapter.setOnItemClickListener((adapter, view, position) -> ToastUtils.showShort(((ResultBean) adapter.getData().get(position)).getToday().getCity()));
        adapter.setUpFetchListener(() -> ToastUtils.showShort("加载"));

        adapter.setOnLoadMoreListener(() -> ToastUtils.showShort("更多"));
    }

    @Override
    public void initData() {
        mPresenter.getTQData("北京");
        mPresenter.getTQData("上海");
        mPresenter.getTQData("广州");
        mPresenter.getTQData("深圳");
        mPresenter.getTQData("万荣");
        mPresenter.getTQData("洛杉矶");
        mPresenter.getTQData("哈尔滨");
        mPresenter.getTQData("郑州");
        mPresenter.getTQData("乌鲁木齐");
        mPresenter.getTQData("海拉尔");
        mPresenter.getTQData("拉萨");
        mPresenter.getTQData("三亚");

        mPresenter.getTQData("三沙");

        mPresenter.getTQData("海口");

        mPresenter.getTQData("天津");

        mPresenter.getTQData("太原");
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void getDataSu(ResultBean weatherBean) {
        if (weatherBean != null) {
            text.setText("各地天气情况");
            data.add(weatherBean);
            adapter.notifyDataSetChanged();
        }
    }
}
