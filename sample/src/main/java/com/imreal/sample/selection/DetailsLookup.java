package com.imreal.sample.selection;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.selection.ISelectable;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 13:54
 * @Description:
 */
public class DetailsLookup extends ItemDetailsLookup<IItem> {

    private IDetailsProvider mDetailsProvider;

    public DetailsLookup(IDetailsProvider detailsProvider) {
        this.mDetailsProvider = detailsProvider;
    }

    @Nullable
    @Override
    public ItemDetails<IItem> getItemDetails(@NonNull MotionEvent e) {
        RecyclerView recyclerView = mDetailsProvider.getRecyclerView();
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null) {
            RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(child);
            int adapterPosition = holder.getAdapterPosition();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if(adapter instanceof ISelectable){
                return  new Details(adapterPosition, (IItem) ((ISelectable) adapter).getSelectionKey(adapterPosition), mDetailsProvider);
            }
        }
        return null;
    }


}
