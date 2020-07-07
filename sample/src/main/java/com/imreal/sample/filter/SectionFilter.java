package com.imreal.sample.filter;

import com.imreal.sample.item.MessageItem;
import com.imreal.sample.item.SectionItem;
import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.MutiAdapter;
import com.imreal.mutiadapter.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 11:21
 * @Description:
 */
public class SectionFilter implements MutiAdapter.Filter {

    @Override
    public List<IItem> filter(List<IItem> src) {
        List<IItem> dest = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            IItem item = src.get(i);
            if (item instanceof MessageItem) {
                MessageItem mi = (MessageItem) item;
                int section = Utils.getCategory(mi.timeStamp, false);
                SectionItem sectionItem = new SectionItem(section);
                if (!dest.contains(sectionItem)) {
                    dest.add(sectionItem);
                }
            }
            dest.add(item);
        }
        return dest;
    }

}
