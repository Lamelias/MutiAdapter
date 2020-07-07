package com.imreal.mutiadapter;

import java.util.List;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 15:34
 * @Description:
 */
public interface ISelectable<T> {

    /**
     * @param position The specified position to get key
     * @return the selection key of an item.
     */
    T getKey(int position);

    /**
     * Returns the adapter position of the item
     *
     * @param item The specified item to get position
     * @return the position of an item.
     */
    int getPosition(T item);

    /**
     * @return All keys which could be selected.
     */
    List<T> getSelectableKeys();

}
