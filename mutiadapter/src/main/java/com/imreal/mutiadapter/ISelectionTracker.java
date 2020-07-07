package com.imreal.mutiadapter;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 17:43
 * @Description: track item selection
 */
public interface ISelectionTracker {
    /**
     * @param item item to test whether selected.
     * @return True if item was selected.
     */
    boolean isSelected(IItem item);
}
