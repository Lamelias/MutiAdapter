package com.imreal.sample.filter;

import com.imreal.sample.item.SectionItem;
import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.MutiAdapter;

import java.util.List;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 16:29
 * @Description:
 */
public class HeaderFooterFilter implements MutiAdapter.Filter {

    @Override
    public List<IItem> filter(List<IItem> src) {
        if (!src.isEmpty()) {
            src.add(0, new SectionItem("HEADER"));
            src.add(src.size(), new SectionItem("FOOTER"));
        }
        return src;
    }

}
