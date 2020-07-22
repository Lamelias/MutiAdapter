package com.imreal.mutiadapter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbsViewProvider<V extends MutiViewHolder, I extends IItem> implements IViewProvider<V, I> {

    private Class<? extends IItem> itemClazz;
    private Class<? extends MutiViewHolder> holderClazz;

    public AbsViewProvider() {
        Type genericType = getClass().getGenericSuperclass();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) genericType;
            holderClazz = (Class<? extends MutiViewHolder>) type.getActualTypeArguments()[0];
            itemClazz = (Class<? extends IItem>) type.getActualTypeArguments()[1];
        } else {
            holderClazz = MutiViewHolder.class;
            itemClazz = IItem.class;
        }
    }

    @Override
    public boolean supportViewType(int viewType) {
        return viewType == ViewTypePool.obtainType(itemClazz);
    }

    @Override
    public boolean supportViewHolder(MutiViewHolder holder) {
        return holderClazz.isInstance(holder);
    }

}
