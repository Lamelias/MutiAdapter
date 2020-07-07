package com.imreal.mutiadapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;


/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 19:22
 * @Description:
 */
public class ItemListUpdateCallback implements ListUpdateCallback {

    public static final String TAG = ItemListUpdateCallback.class.getSimpleName();
    private RecyclerView.Adapter mAdapter;


    public ItemListUpdateCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override
    public void onInserted(int position, int count) {
        Utils.d(TAG, "onInserted position: %d, count: %d", position, count);
        mAdapter.notifyItemRangeInserted(position, count);
    }

    @Override
    public void onRemoved(int position, int count) {
        Utils.d(TAG, "onRemoved position: %d, count: %d", position, count);
        mAdapter.notifyItemRangeRemoved(position, count);
    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {
        Utils.d(TAG, "onMoved fromPosition: %d, toPosition: %d", fromPosition, toPosition);
        mAdapter.notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onChanged(int position, int count, @Nullable Object payload) {
        Utils.d(TAG, "onChanged position: %d, count: %d", position, count);
        mAdapter.notifyItemRangeChanged(position, count,payload);
    }

}
