package com.imreal.sample;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imreal.sample.filter.EmptyFilter;
import com.imreal.sample.filter.HeaderFooterFilter;
import com.imreal.sample.filter.SectionFilter;
import com.imreal.sample.item.MessageItem;
import com.imreal.sample.provider.EmptyProvider;
import com.imreal.sample.provider.MessageProvider;
import com.imreal.sample.provider.SectionProvider;
import com.imreal.sample.selection.DetailsLookup;
import com.imreal.sample.selection.IDetailsProvider;
import com.imreal.sample.selection.ItemSelectionPredicate;
import com.imreal.sample.selection.ItemSelectionTracker;
import com.imreal.sample.selection.KeyProvider;
import com.imreal.mutiadapter.IItem;
import com.imreal.mutiadapter.MutiAdapter;
import com.imreal.mutiadapter.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements IDetailsProvider {

    private RecyclerView recyclerView;
    private MutiAdapter mutiAdapter;
    private SelectionTracker<IItem> selectionTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {

        mutiAdapter = new MutiAdapter();
        mutiAdapter.registerProviders(new MessageProvider(), new SectionProvider(), new EmptyProvider());
        mutiAdapter.registerFilter(new SectionFilter(), new HeaderFooterFilter(), new EmptyFilter());
        mutiAdapter.setUpDataSet(new ArrayList<IItem>());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mutiAdapter);

        fakeData();

        initSelection();

        mutiAdapter.attachSelectionTracker(new ItemSelectionTracker(selectionTracker));

        setTitle("");

    }

    @Override
    public boolean isEditMode() {
        return isEditMode;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    private void initSelection() {
        ItemKeyProvider<IItem> keyProvider = new KeyProvider(ItemKeyProvider.SCOPE_MAPPED, mutiAdapter);
        ItemDetailsLookup<IItem> detailsLookUp = new DetailsLookup(this);
        StorageStrategy<IItem> storage = StorageStrategy.createParcelableStorage(IItem.class);
        SelectionTracker.SelectionPredicate<IItem> predicate = new ItemSelectionPredicate(keyProvider);
        selectionTracker = new SelectionTracker.Builder<>("message-selection", recyclerView, keyProvider, detailsLookUp, storage)
                .withSelectionPredicate(predicate)
                .build();
        selectionTracker.addObserver(new SelectionTracker.SelectionObserver() {
            @Override
            public void onSelectionChanged() {
                super.onSelectionChanged();
                if (selectionTracker.hasSelection() && !isEditMode) {
                    enterEditMode();
                } else {

                }
                updateTitle();
            }
        });
    }

    private void updateTitle() {
        if (isEditMode) {
            setTitle(String.format(Locale.US, " %d selected", selectionTracker.getSelection().size()));
        } else {
            setTitle("");
        }
    }

    private void enterEditMode() {
        isEditMode = true;
        invalidateOptionsMenu();
        updateTitle();
    }

    private void exitEditMode() {
        isEditMode = false;
        selectionTracker.clearSelection();
        invalidateOptionsMenu();
        updateTitle();
    }

    private boolean isEditMode;

    private void fakeData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<MessageItem> items = new ArrayList<>();
                items.add(new MessageItem(Utils.getTimestamp("2020-03-04 12:00:00")));
                items.add(new MessageItem(Utils.getTimestamp("2020-03-03 12:00:00")));
                items.add(new MessageItem(Utils.getTimestamp("2020-03-02 12:00:00")));
                items.add(new MessageItem(Utils.getTimestamp("2020-07-04 12:00:00")));
                items.add(new MessageItem(Utils.getTimestamp("2020-07-06 12:00:00")));
                items.add(new MessageItem(Utils.getTimestamp("2020-06-29 12:00:00")));
                items.add(new MessageItem(Utils.getTimestamp("2020-06-25 12:00:00")));
                Collections.sort(items);
                mutiAdapter.setUpDataSet(new ArrayList<IItem>(items));
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_cancel).setVisible(isEditMode);
        menu.findItem(R.id.action_select_all).setVisible(isEditMode);
        menu.findItem(R.id.action_edit).setVisible(!isEditMode);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_cancel) {
            exitEditMode();
        } else if (item.getItemId() == R.id.action_edit) {
            enterEditMode();
        } else if (item.getItemId() == R.id.action_select_all) {
            selectionTracker.setItemsSelected(mutiAdapter.getSelectableKeys(), true);
        }
        return super.onOptionsItemSelected(item);
    }


}
