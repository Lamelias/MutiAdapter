package com.imreal.mutiadapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;

import com.imreal.mutiadapter.utils.Logger;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 19:22
 * @Description:
 */
public class ItemListUpdateCallback implements ListUpdateCallback {

    public static final String TAG = ItemListUpdateCallback.class.getSimpleName();
    private RecyclerView.Adapter mAdapter;
    private Set<ListUpdateCallback> mCallbacks = new HashSet<>();


    public ItemListUpdateCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override
    public void onInserted(int position, int count) {
        Logger.d(TAG, "onInserted position: %d, count: %d", position, count);
        mAdapter.notifyItemRangeInserted(position, count);
        for (ListUpdateCallback callback : mCallbacks) {
            if (callback != null) {
                callback.onInserted(position, count);
            }
        }
    }

    @Override
    public void onRemoved(int position, int count) {
        Logger.d(TAG, "onRemoved position: %d, count: %d", position, count);
        mAdapter.notifyItemRangeRemoved(position, count);
        for (ListUpdateCallback callback : mCallbacks) {
            if (callback != null) {
                callback.onRemoved(position, count);
            }
        }
    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {
        Logger.d(TAG, "onMoved fromPosition: %d, toPosition: %d", fromPosition, toPosition);
        mAdapter.notifyItemMoved(fromPosition, toPosition);
        for (ListUpdateCallback callback : mCallbacks) {
            if (callback != null) {
                callback.onMoved(fromPosition, toPosition);
            }
        }
    }

    @Override
    public void onChanged(int position, int count, @Nullable Object payload) {
        Logger.d(TAG, "onChanged position: %d, count: %d", position, count);
        mAdapter.notifyItemRangeChanged(position, count, payload);
        for (ListUpdateCallback callback : mCallbacks) {
            if (callback != null) {
                callback.onChanged(position, count, payload);
            }
        }
    }

    public void addCallback(ListUpdateCallback callback) {
        this.mCallbacks.add(callback);
    }

    public void removeCallback(ListUpdateCallback callback) {
        if (callback == null) {
            this.mCallbacks.clear();
        } else {
            this.mCallbacks.remove(callback);
        }
    }

}
