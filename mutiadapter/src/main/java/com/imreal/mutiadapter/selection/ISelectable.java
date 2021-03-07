package com.imreal.mutiadapter.selection;

import java.util.List;

/**
 * Author: Daihaitao
 * Date: 2020/7/7 15:34
 * Description:
 */
public interface ISelectable<T> {

    /**
     * Returns the adapter position of the item
     *
     * @param key The specified selection key to get position
     * @return the position of an item.
     */
    int getPositionForKey(T key);


    /**
     * @param position The specified position to get key
     * @return the selection key of an item.
     */
    T getSelectionKey(int position);


    /**
     * @return All keys which could be selected.
     */
    List<T> getSelectionKeys();

}
