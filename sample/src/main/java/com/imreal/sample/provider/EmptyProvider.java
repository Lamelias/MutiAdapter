package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.imreal.mutiadapter.AbsViewProvider;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.sample.R;
import com.imreal.sample.holder.EmptyViewHolder;
import com.imreal.sample.item.EmptyItem;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 11:16
 * @Description:
 */
public class EmptyProvider extends AbsViewProvider<EmptyViewHolder, EmptyItem> {

    @Override
    public EmptyViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false));
    }

    @Override
    public void bindViewHolder(EmptyViewHolder holder, EmptyItem item, ISelectionTracker selectionTracker) {
        holder.bindItem(item, selectionTracker);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_empty;
    }

}
