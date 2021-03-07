package com.imreal.mutiadapter.selection;

import java.util.List;

public class MutiSelectable<T> implements ISelectable<T> {

    @Override
    public int getPositionForKey(T key) {
        return 0;
    }

    @Override
    public T getSelectionKey(int position) {
        return null;
    }

    @Override
    public List<T> getSelectionKeys() {
        return null;
    }

}
