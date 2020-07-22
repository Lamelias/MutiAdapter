package com.imreal.sample.item;

import android.os.Parcel;

import com.imreal.mutiadapter.AbsItem;
import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.ViewTypePool;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 18:19
 * @Description:
 */
public class MessageItem extends AbsItem implements Comparable<MessageItem> {

    public long timeStamp;

    public MessageItem(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int getViewType() {
        return ViewTypePool.obtainType(MessageItem.class);
    }

    @Override
    public long getItemId() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(IItem newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(IItem newItem) {
        return false;
    }

    @Override
    public boolean supportSelected() {
        return true;
    }

    @Override
    public int compareTo(MessageItem o) {
        long rs = o.timeStamp - timeStamp;
        if (rs > 0) {
            return 1;
        } else if (rs < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.timeStamp);
    }

    protected MessageItem(Parcel in) {
        this.timeStamp = in.readLong();
    }

    public static final Creator<MessageItem> CREATOR = new Creator<MessageItem>() {
        @Override
        public MessageItem createFromParcel(Parcel source) {
            return new MessageItem(source);
        }

        @Override
        public MessageItem[] newArray(int size) {
            return new MessageItem[size];
        }
    };
}
