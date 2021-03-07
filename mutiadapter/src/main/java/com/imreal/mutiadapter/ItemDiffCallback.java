package com.imreal.mutiadapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;


/**
 * Author: Daihaitao
 * Date: 2020/7/6 18:44
 * Description: callback for diff
 */
public class ItemDiffCallback extends DiffUtil.ItemCallback<IItem> {

    @Override
    public boolean areItemsTheSame(@NonNull IItem oldItem, @NonNull IItem newItem) {
        return oldItem.areItemsTheSame(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull IItem oldItem, @NonNull IItem newItem) {
        return oldItem.areContentsTheSame(newItem);
    }

}
