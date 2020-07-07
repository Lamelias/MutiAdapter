package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imreal.sample.R;
import com.imreal.sample.holder.MessageViewHolder;
import com.imreal.sample.item.MessageItem;
import com.imreal.mutiadapter.ISelectionTracker;
import com.imreal.mutiadapter.IViewProvider;
import com.imreal.mutiadapter.MutiViewHolder;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 14:40
 * @Description:
 */
public class MessageProvider implements IViewProvider<MessageViewHolder, MessageItem> {

    @Override
    public MessageViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(inflate(parent));
    }

    @Override
    public void bindViewHolder(MessageViewHolder holder, MessageItem item, ISelectionTracker selectionTracker) {
        holder.bindItem(item, selectionTracker);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_message;
    }

    private View inflate(ViewGroup parent){
        return LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
    }

    @Override
    public Class<? extends MutiViewHolder> getViewHolderClass() {
        return MessageViewHolder.class;
    }

}
