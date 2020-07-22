package com.imreal.sample.selection;

import android.os.Bundle;

import androidx.recyclerview.selection.SelectionTracker;

import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.selection.ISelectionTracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 18:15
 * @Description:
 */
public class ItemSelectionTracker implements ISelectionTracker<IItem> {

    private SelectionTracker<IItem> selectionTracker;

    public ItemSelectionTracker(SelectionTracker<IItem> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

    @Override
    public boolean isSelected(IItem item) {
        return selectionTracker != null && selectionTracker.isSelected(item);
    }

    @Override
    public boolean hasSelection() {
        return selectionTracker.hasSelection();
    }

    @Override
    public List<IItem> getSelection() {
        List<IItem> iItems = new ArrayList<>();
        Iterator<IItem> iterator = selectionTracker.getSelection().iterator();
        while (iterator.hasNext()) {
            iItems.add(iterator.next());
        }
        return iItems;
    }

    @Override
    public void clearSelection() {
        selectionTracker.clearSelection();
    }

    @Override
    public void setItemsSelected(List<IItem> selectableKeys, boolean selected) {
        selectionTracker.setItemsSelected(selectableKeys, selected);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        selectionTracker.onSaveInstanceState(state);
    }

    @Override
    public void onRestoreInstanceState(Bundle state) {
        selectionTracker.onRestoreInstanceState(state);
    }

}
