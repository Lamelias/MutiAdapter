package com.imreal.sample.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.imreal.sample.R;
import com.imreal.sample.item.SectionItem;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.mutiadapter.MutiViewHolder;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 19:39
 * @Description:
 */
public class SectionViewHolder extends MutiViewHolder<SectionItem> {

    private TextView sectionTitle;

    public SectionViewHolder(@NonNull View itemView) {
        super(itemView);
        sectionTitle = itemView.findViewById(R.id.tv_section);
    }

    @Override
    public void bindItem(SectionItem item, ISelectionTracker selectionTracker) {
        sectionTitle.setText(item.sectionTitle);
    }

}
