package coupon.allyn.com.couponallyn;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

import coupon.allyn.com.couponallyn.base.BaseDataBindingActivity;
import coupon.allyn.com.couponallyn.databinding.ActivityMainBinding;

public class MainActivity extends BaseDataBindingActivity<ActivityMainBinding> {

    CouponAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }
    private void setup() {
        getBinding().swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getBinding().swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getBinding().swipeRefreshLayout.setRefreshing(false);
                    }
                }, 500);
            }
        });
        mAdapter = new CouponAdapter();
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getBinding().recyclerView.setAdapter(mAdapter);
        List<Coupon> coulist = new ArrayList<>();
        Coupon c = new Coupon(123, 30, 0, "2017-12-12 12:12:12", "代缴服务费抵用券");
        Coupon c2 = new Coupon(123, 40, 1, "2017-12-12 12:12:12", "代缴服务费抵用券");
        Coupon c3 = new Coupon(123, 50, 2, "2017-12-12 12:12:12", "代缴服务费抵用券");
        Coupon c4 = new Coupon(123, 60, 0, "2017-12-12 12:12:12", "代缴服务费抵用券");
        Coupon c5 = new Coupon(123, 4000, 0, "2017-12-12 12:12:12", "代缴服务费抵用券");
        coulist.add(c);
        coulist.add(c2);
        coulist.add(c3);
        coulist.add(c4);
        coulist.add(c5);
        mAdapter.addAll(coulist);
    }

}
