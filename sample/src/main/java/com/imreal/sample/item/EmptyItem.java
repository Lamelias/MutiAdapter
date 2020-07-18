package com.imreal.sample.item;

import android.os.Parcel;

import com.imreal.mutiadapter.AbsItem;
import com.imreal.mutiadapter.IItem;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 11:13
 * @Description:
 */
public class EmptyItem extends AbsItem {

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public EmptyItem() {
    }

    protected EmptyItem(Parcel in) {
    }

    public static final Creator<EmptyItem> CREATOR = new Creator<EmptyItem>() {
        @Override
        public EmptyItem createFromParcel(Parcel source) {
            return new EmptyItem(source);
        }

        @Override
        public EmptyItem[] newArray(int size) {
            return new EmptyItem[size];
        }
    };

    @Override
    public boolean supportSelected() {
        return false;
    }
}
