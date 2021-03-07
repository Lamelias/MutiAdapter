package com.imreal.mutiadapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.imreal.mutiadapter.selection.ISelectionTracker;

/**
 * Author: Daihaitao
 * Date: 2020/7/6 14:43
 * Description: Base view holder class for item extends IItem
 */
public abstract class MutiViewHolder<I extends IItem> extends RecyclerView.ViewHolder {

    public MutiViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    /**
     * @param item  item to bind to this holder.
     * @param selectionTracker selection to track selections.
     */
    public abstract void bindItem(I item, @Nullable ISelectionTracker selectionTracker);

}
