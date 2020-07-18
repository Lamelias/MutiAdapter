package com.imreal.sample.item;

import android.os.Parcel;

import com.imreal.mutiadapter.AbsItem;
import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.ViewTypePool;

import java.util.Objects;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 19:38
 * @Description:
 */
public class SectionItem extends AbsItem {

    public String sectionTitle;
    public int section;

    private static String[] sections = new String[]{
            "", "昨天", "本周", "上周", "本月", "上月", "更早"
    };

    public SectionItem(int section) {
        this.section = section;
        this.sectionTitle = sections[section];
    }


    public SectionItem(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @Override
    public int getViewType() {
        return ViewTypePool.obtainType(SectionItem.class);
    }

    @Override
    public long getItemId() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(IItem newItem) {
        return newItem instanceof SectionItem && section == (((SectionItem) newItem).section);
    }

    @Override
    public boolean areContentsTheSame(IItem newItem) {
        return true;
    }

    @Override
    public boolean supportSelected() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionItem that = (SectionItem) o;
        return section == that.section;
    }

    @Override
    public int hashCode() {
        return Objects.hash(section);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sectionTitle);
        dest.writeInt(this.section);
    }

    protected SectionItem(Parcel in) {
        this.sectionTitle = in.readString();
        this.section = in.readInt();
    }

    public static final Creator<SectionItem> CREATOR = new Creator<SectionItem>() {
        @Override
        public SectionItem createFromParcel(Parcel source) {
            return new SectionItem(source);
        }

        @Override
        public SectionItem[] newArray(int size) {
            return new SectionItem[size];
        }
    };
}
