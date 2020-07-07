package com.imreal.sample.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.imreal.sample.R;
import com.imreal.sample.item.MessageItem;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.mutiadapter.MutiViewHolder;
import com.imreal.mutiadapter.Utils;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 18:18
 * @Description:
 */
public class MessageViewHolder extends MutiViewHolder<MessageItem> {
    private TextView timestamp;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindItem(MessageItem item, ISelectionTracker selectionTracker) {
        itemView.setActivated(selectionTracker != null && selectionTracker.isSelected(item));
        timestamp = itemView.findViewById(R.id.tv_timestamp);
        timestamp.setText(Utils.getDateFormat(item.timeStamp));
    }

}
