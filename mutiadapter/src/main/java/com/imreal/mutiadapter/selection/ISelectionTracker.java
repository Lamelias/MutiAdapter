package com.imreal.mutiadapter.selection;

import android.os.Bundle;

import com.imreal.mutiadapter.IItem;

import java.util.List;

/**
 * Author: Daihaitao
 * Date: 2020/7/7 17:43
 * Description: track item selection
 */
public interface ISelectionTracker<T> {
    /**
     * @param item item to test whether selected.
     * @return True if item was selected.
     */
    boolean isSelected(IItem item);

    /**
     * @return True if at least one item has been selected.
     */
    boolean hasSelection();

    /**
     * @return All selected items
     */
    List<T> getSelection();

    /**
     * Clear all selections.
     */
    void clearSelection();

    /**
     * @param selectableKeys Toggled some items's  selected state
     * @param selected whether select or not
     */
    void setItemsSelected(List<IItem> selectableKeys, boolean selected);

    /**
     * Preserves selection, if any. Call this method from Activity#onSaveInstanceState
     *
     * @param state Bundle instance supplied to onSaveInstanceState.
     */
    void onSaveInstanceState(Bundle state);

    /**
     * Restores selection from previously saved state. Call this method from
     * Activity#onCreate.
     *
     * @param state Bundle instance supplied to onCreate.
     */
    void onRestoreInstanceState(Bundle state);
}
