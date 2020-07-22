package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.imreal.mutiadapter.AbsViewProvider;
import com.imreal.sample.R;
import com.imreal.sample.holder.MessageViewHolder;
import com.imreal.sample.item.MessageItem;
import com.imreal.mutiadapter.selection.ISelectionTracker;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 14:40
 * @Description:
 */
public class MessageProvider extends AbsViewProvider<MessageViewHolder, MessageItem> {

    @Override
    public MessageViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false));
    }

    @Override
    public void bindViewHolder(MessageViewHolder holder, MessageItem item, ISelectionTracker selectionTracker) {
        holder.bindItem(item, selectionTracker);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_message;
    }

}
