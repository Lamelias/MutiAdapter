package com.imreal.mutiadapter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/9 11:34
 * @Description: An utility class for view type generation
 */
public class ViewTypePool {

    private static final String TAG = "ViewTypePool";
    private static final Map<Class, Integer> sTypeCache = new HashMap<>();
    private static final AtomicInteger sTypeCounter = new AtomicInteger(0);

    /**
     * @param cls cls to obtain viewType
     * @return viewType used in Adapter
     */
    public static int obtainType(Class<? extends IItem> cls) {
        Integer value = sTypeCache.get(cls);
        if (value != null) {
            return value;
        }
        synchronized (sTypeCache) {
            value = sTypeCounter.addAndGet(1);
            sTypeCache.put(cls, value);
        }
        return value;
    }

}
