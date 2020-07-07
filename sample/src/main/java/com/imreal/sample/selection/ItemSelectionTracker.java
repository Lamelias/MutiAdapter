package com.imreal.sample.selection;

import androidx.recyclerview.selection.SelectionTracker;

import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.ISelectionTracker;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 18:15
 * @Description:
 */
public class ItemSelectionTracker implements ISelectionTracker {

    private SelectionTracker<IItem> selectionTracker;

    public ItemSelectionTracker(SelectionTracker<IItem> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

    @Override
    public boolean isSelected(IItem item) {
        return selectionTracker != null && selectionTracker.isSelected(item);
    }

}
