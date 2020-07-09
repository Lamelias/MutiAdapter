package com.imreal.sample.provider;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.imreal.mutiadapter.ViewTypePool;
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

    @Override
    public boolean supportViewType(int viewType) {
        return ViewTypePool.obtainType(MessageItem.class) == viewType;
    }

    @Override
    public Class<? extends MutiViewHolder> getViewHolderClass() {
        return MessageViewHolder.class;
    }

}
