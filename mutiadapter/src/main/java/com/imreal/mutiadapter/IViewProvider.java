package com.imreal.mutiadapter;

import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 14:27
 * @Description: A bridge between ViewHolder & IItem
 */
public interface IViewProvider<V extends MutiViewHolder,I extends IItem> {
    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View
     * @return A new ViewHolder that holds a View of the given view type.
     */
    V createViewHolder(ViewGroup parent, @LayoutRes int viewType);

    /**
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param item   The specified item to bind
     * @param selectionTracker selection tracker to keep trace of selected items.
     */
    void bindViewHolder(V holder, I item, ISelectionTracker selectionTracker);

    /**
     * @return  supported view type
     */
    int getLayoutId();


    /**
     * @param viewType   Type to be verified
     * @return True if this view provider supports specified {@param viewType}
     */
    boolean supportViewType(int viewType);

    /**
     * @return  supported  view holder class
     */
    Class<? extends MutiViewHolder> getViewHolderClass();
}
