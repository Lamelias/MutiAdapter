package com.imreal.mutiadapter;

import android.os.Parcelable;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 14:33
 * @Description:
 */
public interface IItem extends Parcelable {
    /**
     * @return The view type of this item
     */
    int getViewType();

    /**
     * @return the stable ID of the item
     */
    long getItemId();

    /**
     * @param newItem The item in the new list.
     * @return True if the two items represent the same object or false if they are different.
     */
    boolean areItemsTheSame(IItem newItem);

    /**
     * @param newItem The item in the new list.
     * @return True if the contents of the items are the same or false if they are different.
     */
    boolean areContentsTheSame(IItem newItem);

    /**
     * @return  True if can be selected in edit mode
     */
    boolean supportSelected();
}
