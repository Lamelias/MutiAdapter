package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.imreal.mutiadapter.ViewTypePool;
import com.imreal.sample.R;
import com.imreal.sample.holder.EmptyViewHolder;
import com.imreal.sample.item.EmptyItem;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.mutiadapter.IViewProvider;
import com.imreal.mutiadapter.MutiViewHolder;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 11:16
 * @Description:
 */
public class EmptyProvider implements IViewProvider<EmptyViewHolder, EmptyItem> {


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

    @Override
    public boolean supportViewType(int viewType) {
        return ViewTypePool.obtainType(EmptyItem.class) == viewType;
    }

    @Override
    public Class<? extends MutiViewHolder> getViewHolderClass() {
        return EmptyViewHolder.class;
    }

}
