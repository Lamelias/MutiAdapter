package com.imreal.mutiadapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;

import com.imreal.mutiadapter.selection.ISelectable;
import com.imreal.mutiadapter.selection.ISelectionTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 14:24
 * @Description: A simple encapsulation to support special item and selection and diff
 */
public class MutiAdapter extends RecyclerView.Adapter<MutiViewHolder> implements AsyncListDiffer.ListListener<IItem>, ISelectable<IItem> {

    private List<IItem> mDataSet = new LinkedList<>();
    private List<IViewProvider> mProviders = new LinkedList<>();
    private final AsyncListDiffer<IItem> mDiff;
    private List<Filter> mFilters = new LinkedList<>();
    private ISelectionTracker mSelectionTracker;
    private ItemListUpdateCallback mItemListUpdateCallback;
    private Map<IItem, Integer> mSelectionKeyPositionMap = new HashMap<>();

    public MutiAdapter() {
        super();
        AsyncDifferConfig<IItem> config = new AsyncDifferConfig.Builder<>(new ItemDiffCallback()).build();
        mItemListUpdateCallback = new ItemListUpdateCallback(this);
        mDiff = new AsyncListDiffer<>(mItemListUpdateCallback, config);
        mDiff.addListListener(this);
    }

    @NonNull
    @Override
    public MutiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IViewProvider provider = findSuitableProvider(viewType);
        return provider.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MutiViewHolder holder, int position) {
        IViewProvider provider = findSuitableProvider(holder);
        provider.bindViewHolder(holder, getItem(position), getSelectionTracker());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        IItem item = getItem(position);
        if (item == null) {
            return IItem.NO_TYPE;
        }
        return item.getViewType();
    }

    @Override
    public long getItemId(int position) {
        IItem item = getItem(position);
        if (item == null) {
            return IItem.NO_ID;
        }
        return item.getItemId();
    }

    @Override
    public int getPositionForKey(IItem item) {
        Integer pos = mSelectionKeyPositionMap.get(item);
        if (pos == null) {
            return IItem.NO_POSITION;
        }
        return pos;
    }

    @Override
    @Nullable
    public IItem getSelectionKey(int position) {
        return getItem(position);
    }

    @Override
    @NonNull
    public List<IItem> getSelectionKeys() {
        List<IItem> selectableKeys = new ArrayList<>();
        for (IItem item : mDataSet) {
            if (item.supportSelected()) {
                selectableKeys.add(item);
            }
        }
        return selectableKeys;
    }

    /**
     * @param position adapter position
     * @return Item at specified position
     */
    @Nullable
    public IItem getItem(int position) {
        if (position < 0 || position >= mDataSet.size()) {
            return null;
        }
        return mDataSet.get(position);
    }

    /**
     * Register providers to support some certain view holder&view type
     *
     * @param providers To be registered
     */
    public void registerProviders(@NonNull IViewProvider... providers) {
        for (IViewProvider provider : providers) {
            if (!mProviders.contains(provider)) {
                mProviders.add(provider);
            }
        }
    }

    /**
     * Register filters to perform some transformation on original data source
     *
     * @param filters To be registered
     */
    public void registerFilters(@NonNull Filter... filters) {
        for (Filter filter : filters) {
            if (!mFilters.contains(filter)) {
                mFilters.add(filter);
            }
        }
    }

    /**
     * @param items Set up data sources
     */
    public void setUpDataSet(@NonNull List<IItem> items) {
        for (Filter filter : mFilters) {
            items = filter.filter(items);
        }
        for (int i = 0; i < items.size(); i++) {
            mSelectionKeyPositionMap.put(items.get(i), i);
        }
        mDiff.submitList(items);
    }

    /**
     * @return Data Set contains all Items
     */
    @NonNull
    public List<IItem> getDataSet() {
        return mDataSet;
    }

    /**
     * Add callback to listen data diff results
     *
     * @param callback To listen  diff results.
     */
    public void addListUpdateCallback(@NonNull ListUpdateCallback callback) {
        mItemListUpdateCallback.addCallback(callback);
    }

    /**
     * Remove previously registered callback, if callback is null, all callbacks will be removed
     *
     * @param callback Specified callback to remove, if null, remove all callbacks
     */
    public void removeListUpdateCallback(@Nullable ListUpdateCallback callback) {
        mItemListUpdateCallback.removeCallback(callback);
    }

    @Override
    public void onCurrentListChanged(@NonNull List<IItem> previousList, @NonNull List<IItem> currentList) {
        mDataSet = currentList;
    }

    /**
     * @param viewType Find view provider implementation  by specified viewType
     * @return Provider supports this viewType
     */
    @NonNull
    private IViewProvider findSuitableProvider(int viewType) {
        for (IViewProvider provider : mProviders) {
            if (provider.supportViewType(viewType)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("You must provide implementation of IViewProvider for viewType " + viewType);
    }

    /**
     * @param viewHolder Find view provider implementation  by specified viewHolder
     * @return Provider supports this viewType
     */
    @NonNull
    private IViewProvider findSuitableProvider(@NonNull MutiViewHolder viewHolder) {
        for (IViewProvider provider : mProviders) {
            if (provider.supportViewHolder(viewHolder)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("You must provide implementation of IViewProvider for viewHolder " + viewHolder.getClass().getName());
    }

    /**
     * @param selectionTracker Attach  selectionTracker for item selection
     */
    public void attachSelectionTracker(@NonNull ISelectionTracker selectionTracker) {
        this.mSelectionTracker = selectionTracker;
    }

    /**
     * @return SelectionTracker attached
     */
    @Nullable
    private ISelectionTracker getSelectionTracker() {
        return mSelectionTracker;
    }


    /**
     * Perform some operations on original data set to add some special item
     * Note: items added must be provided with corresponding
     * {@link IViewProvider} implementations
     */
    public interface Filter {
        /**
         * @param src list to perform some operations to add special items(sections/footer/header)
         * @return filtered list
         */
        List<IItem> filter(List<IItem> src);
    }

}
