package com.imreal.sample.selection;

import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;

import com.imreal.mutiadapter.IItem;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 14:14
 * @Description:
 */
public class Details extends ItemDetailsLookup.ItemDetails<IItem> {

    private int position;
    private IItem item;
    private IDetailsProvider detailsProvider;

    public Details(int position, IItem item, IDetailsProvider detailsProvider) {
        this.position = position;
        this.item = item;
        this.detailsProvider = detailsProvider;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Nullable
    @Override
    public IItem getSelectionKey() {
        return this.item;
    }

    @Override
    public boolean inSelectionHotspot(@NonNull MotionEvent e) {
        return detailsProvider.isEditMode();
    }

}
