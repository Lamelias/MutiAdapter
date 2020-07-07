package com.imreal.sample.selection;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 15:59
 * @Description:
 */
public interface IDetailsProvider {

    /**
     * @return RecyclerView  on which item details are looking for
     */
    RecyclerView getRecyclerView();

    /**
     * @return True if currently in edit mode.
     */
    boolean isEditMode();
}
