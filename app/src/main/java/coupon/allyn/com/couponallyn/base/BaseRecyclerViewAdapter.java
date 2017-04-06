package coupon.allyn.com.couponallyn.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected List<T> mDataList = new ArrayList<>();
    protected OnItemClickListener<T> listener;

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, final int position) {
        holder.onBaseBindViewHolder(mDataList.get(position), position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(mDataList.get(position), position);
                }
            }
        });

    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void remove(T object) {
        mDataList.remove(object);
    }

    public void removeAll(List<T> data) {
        this.mDataList.retainAll(data);
    }

    public T getItem(int position) {
        return mDataList.get(position);
    }

    public List<T> getDataList() {
        return mDataList;
    }

    public void refresh(List<T> dataList) {
        mDataList.clear();
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void add(int position, T date) {
        mDataList.add(position, date);
        notifyItemInserted(position);
    }

    public void add(T data) {
        add(mDataList.size(), data);
    }

    public void addAll(int positionStart, List<T> dataList) {
        mDataList.addAll(positionStart, dataList);
        notifyItemRangeInserted(positionStart, dataList.size());
    }

    public void addAll(List<T> dataList) {
        addAll(mDataList.size(), dataList);
    }

    public void move(int fromPosition, int toPosition) {
        T remove = mDataList.remove(fromPosition);
        mDataList.add(toPosition, remove);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void change(int position, T data) {
        mDataList.remove(position);
        mDataList.add(position, data);
        notifyItemChanged(position);
    }

    public void remove(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }
}
