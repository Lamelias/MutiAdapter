package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.imreal.mutiadapter.AbsViewProvider;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.sample.R;
import com.imreal.sample.holder.SectionViewHolder;
import com.imreal.sample.item.SectionItem;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 19:40
 * @Description:
 */
public class SectionProvider extends AbsViewProvider<SectionViewHolder, SectionItem> {

    @Override
    public SectionViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new SectionViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false));
    }

    @Override
    public void bindViewHolder(SectionViewHolder holder, SectionItem item, ISelectionTracker selectionTracker) {
        holder.bindItem(item, selectionTracker);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_section;
    }

}
