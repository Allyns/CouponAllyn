package coupon.allyn.com.couponallyn;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import coupon.allyn.com.couponallyn.base.BaseRecyclerViewAdapter;
import coupon.allyn.com.couponallyn.base.BaseRecyclerViewHolder;
import coupon.allyn.com.couponallyn.databinding.ItemCouponLayoutBinding;


/**
 * 优惠券 on 2017/4/5.
 */

public class CouponAdapter extends BaseRecyclerViewAdapter<Coupon> {

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CouponHolder(parent, R.layout.item_coupon_layout);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    class CouponHolder extends BaseRecyclerViewHolder<Coupon, ItemCouponLayoutBinding> {

        CouponHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(Coupon data, int position) {

            Context context = itemView.getContext();
            ItemCouponLayoutBinding binding = getBinding();
            binding.tvCouponMsg.setText(data.getName());
            binding.tvMoney.setText(String.valueOf(data.getJe()));
            binding.tvTime.setText("最后使用日期：" + data.getLastday());

            //     Status:状态 0=可使用 1=已使用 2=已过期

            if (data.getStatus() == 0 || data.getStatus() == 1) {
                binding.tvMoneyText.setTextColor(ContextCompat.getColor(context, R.color.gallery_red));
                binding.tvMoney.setTextColor(ContextCompat.getColor(context, R.color.gallery_red));
                if (data.getStatus() == 0) {
                    binding.displayview.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    binding.tvStatus.setText("可使用");
                    binding.tvStatus.setTextColor(ContextCompat.getColor(context, R.color.button_agency_nm));
                } else if (data.getStatus() == 1) {
                    binding.displayview.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    binding.tvStatus.setText("已使用");
                    binding.tvStatus.setTextColor(ContextCompat.getColor(context, R.color.divider_color));
                }
            } else {
                binding.tvStatus.setText("已过期");
                binding.tvStatus.setTextColor(ContextCompat.getColor(context, R.color.divider_color));
                binding.tvMoneyText.setTextColor(ContextCompat.getColor(context, R.color.divider_color));
                binding.tvMoney.setTextColor(ContextCompat.getColor(context, R.color.divider_color));
                binding.displayview.setColor(ContextCompat.getColor(context, R.color.divider_color));
            }
        }
    }
}
