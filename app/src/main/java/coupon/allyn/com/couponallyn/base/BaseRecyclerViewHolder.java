package coupon.allyn.com.couponallyn.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public abstract class BaseRecyclerViewHolder<T, D extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private D mBinding;

    public BaseRecyclerViewHolder(ViewGroup viewGroup, int layoutId) {
        super(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), layoutId, viewGroup, false).getRoot());
        mBinding = DataBindingUtil.getBinding(this.itemView);
    }

    public abstract void onBindViewHolder(T object, final int position);

    void onBaseBindViewHolder(T object, final int position) {
        onBindViewHolder(object, position);
        mBinding.executePendingBindings();
    }

    public  D getBinding() {
        return mBinding;
    }
}
