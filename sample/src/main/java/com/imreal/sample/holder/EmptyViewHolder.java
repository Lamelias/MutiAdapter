package com.imreal.sample.holder;

import android.view.View;

import androidx.annotation.NonNull;

import com.imreal.sample.item.EmptyItem;
import com.imreal.mutiadapter.selection.ISelectionTracker;
import com.imreal.mutiadapter.MutiViewHolder;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 11:17
 * @Description:
 */
public class EmptyViewHolder extends MutiViewHolder<EmptyItem> {

    public EmptyViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindItem(EmptyItem item, ISelectionTracker selectionTracker) {

    }

}
