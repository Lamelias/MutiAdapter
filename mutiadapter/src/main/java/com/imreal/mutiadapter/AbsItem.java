package com.imreal.mutiadapter;

public abstract class AbsItem implements IItem {

    @Override
    public int getViewType() {
        return ViewTypePool.obtainType(getClass());
    }

}
