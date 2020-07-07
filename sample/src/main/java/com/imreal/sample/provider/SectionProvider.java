package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imreal.sample.R;
import com.imreal.sample.holder.SectionViewHolder;
import com.imreal.sample.item.SectionItem;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.mutiadapter.IViewProvider;
import com.imreal.mutiadapter.MutiViewHolder;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 19:40
 * @Description:
 */
public class SectionProvider implements IViewProvider<SectionViewHolder, SectionItem> {

    @Override
    public SectionViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new SectionViewHolder(inflate(parent));
    }

    @Override
    public void bindViewHolder(SectionViewHolder holder, SectionItem item, ISelectionTracker selectionTracker) {
        holder.bindItem(item, selectionTracker);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_section;
    }

    private View inflate(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
    }

    @Override
    public Class<? extends MutiViewHolder> getViewHolderClass() {
        return SectionViewHolder.class;
    }

}
