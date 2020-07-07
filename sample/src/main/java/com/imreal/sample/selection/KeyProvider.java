package com.imreal.sample.selection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;

import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.MutiAdapter;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/7 13:52
 * @Description:
 */
public class KeyProvider extends ItemKeyProvider<IItem> {

    private MutiAdapter adapter;

    public KeyProvider(int scope, MutiAdapter adapter) {
        super(scope);
        this.adapter = adapter;
    }

    /**
     * Creates a new provider with the given scope.
     *
     * @param scope Scope can't be changed at runtime.
     */
    public KeyProvider(int scope) {
        super(scope);
    }

    @Nullable
    @Override
    public IItem getKey(int position) {
        return adapter.getItem(position);
    }

    @Override
    public int getPosition(@NonNull IItem key) {
        return adapter.getPosition(key);
    }

}
