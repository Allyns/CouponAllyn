package coupon.allyn.com.couponallyn.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/3/20.
 */

public abstract class BaseDataBindingActivity<VB extends ViewDataBinding> extends AppCompatActivity {

    private VB mBinding;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        setContentView(mBinding.getRoot());
    }

    public  VB getBinding() {
        return mBinding;
    }
}
