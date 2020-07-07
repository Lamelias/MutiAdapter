package com.imreal.sample.filter;

import com.imreal.sample.item.EmptyItem;
import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.MutiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 11:11
 * @Description:
 */
public class EmptyFilter implements MutiAdapter.Filter {

    @Override
    public List<IItem> filter(List<IItem> src) {
        List<IItem> dest = new ArrayList<>();
        if (src.isEmpty()) {
            dest.add(new EmptyItem());
        }else {
            dest.addAll(src);
        }
        return dest;
    }

}
