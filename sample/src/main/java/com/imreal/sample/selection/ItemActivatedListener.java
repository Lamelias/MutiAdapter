package com.imreal.sample.selection;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.OnItemActivatedListener;

import com.imreal.mutiadapter.IItem;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 17:06
 * @Description:
 */
public class ItemActivatedListener implements OnItemActivatedListener<IItem> {

    private IDetailsProvider detailsProvider;

    public ItemActivatedListener(IDetailsProvider detailsProvider) {
        this.detailsProvider = detailsProvider;
    }

    @Override
    public boolean onItemActivated(@NonNull ItemDetailsLookup.ItemDetails<IItem> item, @NonNull MotionEvent e) {
        View view = detailsProvider.getRecyclerView().findChildViewUnder(e.getX(), e.getY());
        if (view != null) {
            view.setActivated(true);
        }
        return true;
    }


}
