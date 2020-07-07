package com.imreal.mutiadapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Daihaitao
 * @Date: 2020/7/6 14:24
 * @Description: A simple encapsulation to support add special item and cooperate with selection & diff
 */
public class MutiAdapter extends RecyclerView.Adapter<MutiViewHolder> implements AsyncListDiffer.ListListener<IItem>, ISelectable<IItem> {

    private List<IItem> mDataSet = new LinkedList<>();
    private List<IViewProvider> mProviders = new LinkedList<>();
    private final AsyncListDiffer<IItem> mDiff;
    private List<Filter> mFilters = new LinkedList<>();
    private ISelectionTracker selectionTracker;

    public MutiAdapter() {
        super();
        AsyncDifferConfig<IItem> config = new AsyncDifferConfig.Builder<>(new ItemDiffCallback()).build();
        mDiff = new AsyncListDiffer<>(new ItemListUpdateCallback(this), config);
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
        return getItem(position).getViewType();
    }


    @Override
    public long getItemId(int position) {
        return getItem(position).getItemId();
    }


    @Override
    public IItem getKey(int position) {
        return getItem(position);
    }

    @Override
    public List<IItem> getSelectableKeys() {
        List<IItem> selectableKeys = new ArrayList<>();
        for (IItem item : mDataSet) {
            if (item.supportSelected()) {
                selectableKeys.add(item);
            }
        }
        return selectableKeys;
    }

    @Override
    public int getPosition(IItem item) {
        return mDataSet.indexOf(item);
    }

    public IItem getItem(int position) {
        return mDataSet.get(position);
    }


    public void registerProviders(IViewProvider... providers) {
        for (IViewProvider provider : providers) {
            if (!mProviders.contains(provider)) {
                mProviders.add(provider);
            }
        }
    }

    public void registerFilter(Filter... filters) {
        for (Filter filter : filters) {
            if (!mFilters.contains(filter)) {
                mFilters.add(filter);
            }
        }
    }

    public void setUpDataSet(List<IItem> items) {
        for (Filter filter : mFilters) {
            items = filter.filter(items);
        }
        mDiff.submitList(items);
    }

    @Override
    public void onCurrentListChanged(@NonNull List<IItem> previousList, @NonNull List<IItem> currentList) {
        mDataSet = currentList;
    }

    IViewProvider findSuitableProvider(int viewType) {
        for (IViewProvider provider : mProviders) {
            if (provider.getLayoutId() == viewType) {
                return provider;
            }
        }
        return null;
    }

    IViewProvider findSuitableProvider(MutiViewHolder viewHolder) {
        for (IViewProvider provider : mProviders) {
            if (provider.getViewHolderClass().isInstance(viewHolder)) {
                return provider;
            }
        }
        return null;
    }

    public void attachSelectionTracker(ISelectionTracker selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

    private ISelectionTracker getSelectionTracker() {
        return selectionTracker;
    }


    /**
     * Perform some operations on original data set to add some special item
     * Note: items added must be provided with corresponding {@link IViewProvider} implementations
     */
    public interface Filter {
        /**
         * @param src list to perform some operations, such as, add sections/footer/header.
         * @return filtered list
         */
        List<IItem> filter(List<IItem> src);
    }

}
