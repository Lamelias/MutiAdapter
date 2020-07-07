package com.imreal.sample.selection;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;

import com.imreal.mutiadapter.IItem;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 15:16
 * @Description:
 */
public class ItemSelectionPredicate extends SelectionTracker.SelectionPredicate<IItem> {

    private ItemKeyProvider<IItem> keyProvider;

    public ItemSelectionPredicate(ItemKeyProvider<IItem> keyProvider) {
        this.keyProvider = keyProvider;
    }

    @Override
    public boolean canSetStateForKey(@NonNull IItem key, boolean nextState) {
        return key.supportSelected();
    }

    @Override
    public boolean canSetStateAtPosition(int position, boolean nextState) {
        IItem item = keyProvider.getKey(position);
        return item != null && canSetStateForKey(item,nextState);
    }

    @Override
    public boolean canSelectMultiple() {
        return true;
    }

}
