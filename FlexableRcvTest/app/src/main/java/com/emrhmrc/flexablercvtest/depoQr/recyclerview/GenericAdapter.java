package com.emrhmrc.flexablercvtest.depoQr.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public abstract class GenericAdapter<T, L extends BaseRecyclerListener, VH extends BaseViewHolder<T, L>> extends RecyclerView.Adapter<VH> {

    private List<T> items;
    private List<T> itemsFilter;
    private L listener;
    private LayoutInflater layoutInflater;
    private Context context;


    @Deprecated
    public GenericAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        items = new ArrayList<>();

    }

    public Context getContext() {
        return context;
    }

    public GenericAdapter(Context context, L listener) {
        this.listener = listener;
        this.items = new ArrayList<>();
        this.itemsFilter = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (items.size() <= position) {
            return;
        }
        T item = items.get(position);
        holder.onBind(item, listener);

    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }


    public void setItems(List<T> items, boolean notifyChanges) throws IllegalArgumentException {
        if (items == null) {
            throw new IllegalArgumentException("Cannot set `null` item to the Recycler adapter");
        }
        this.items.clear();
        this.items.addAll(items);
        if (notifyChanges) {
            notifyDataSetChanged();
        }
    }


    public void updateItems(List<T> newItems) {
        setItems(newItems, false);
    }


    public void updateItems(List<T> newItems, DiffUtil.Callback diffCallback) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffCallback, false);
        setItems(newItems, false);
        result.dispatchUpdatesTo(this);
    }

    public List<T> getItemsFilter() {
        return itemsFilter;
    }

    public void setItemsFilter(List<T> itemsFilter) {
        this.itemsFilter = itemsFilter;
    }


    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {

        setItems(items, true);

    }


    /**
     * Returns an items from the data set at a certain position.
     *
     * @return All of items in this adapter.
     */
    public T getItem(int position) {
        return items.get(position);
    }

    /**
     * Adds item to the end of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     */
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to the Recycler adapter");
        }
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    /**
     * Adds item to the beginning of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     */
    public void addToBeginning(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to the Recycler adapter");
        }
        items.add(0, item);
        notifyItemInserted(0);
    }

    /**
     * Adds list of items to the end of the adapter's data set.
     * Notifies that item has been inserted.
     *
     * @param items items which has to be added to the adapter.
     */
    public void addAll(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot add `null` items to the Recycler adapter");
        }
        this.items.addAll(items);
        notifyItemRangeInserted(this.items.size() - items.size(), items.size());
    }

    /**
     * Clears all the items in the adapter.
     *
     * @since 1.0.0
     */
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    /**
     * Removes an item from the adapter.
     * Notifies that item has been removed.
     *
     * @param item to be removed
     */
    public void remove(T item) {
        int position = items.indexOf(item);
        if (position > -1) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void remove(int position) {
        if (position > -1) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * Returns whether adapter is empty or not.
     *
     * @return `true` if adapter is empty or `false` otherwise
     */
    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    /**
     * Indicates whether each item in the data set can be represented with a unique identifier
     * of type {@link Long}.
     *
     * @param hasStableIds Whether items in data set have unique identifiers or not.
     * @see #hasStableIds()
     * @see #getItemId(int)
     */
    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    /**
     * Get listener {@link BaseRecyclerListener}
     *
     * @return click listener
     */
    public L getListener() {
        return listener;
    }

    /**
     * Set click listener, which must extend {@link BaseRecyclerListener}
     *
     * @param listener click listener
     */
    public void setListener(L listener) {
        this.listener = listener;
    }

    /**
     * Inflates a view.
     *
     * @param layout       layout to me inflater
     * @param parent       container where to inflate
     * @param attachToRoot whether to attach to root or not
     * @return inflated View
     */
    @NonNull
    protected View inflate(@LayoutRes final int layout, @Nullable final ViewGroup parent, final boolean attachToRoot) {
        return layoutInflater.inflate(layout, parent, attachToRoot);
    }

    /**
     * Inflates a view.
     *
     * @param layout layout to me inflater
     * @param parent container where to inflate
     * @return inflated View
     */
    @NonNull
    protected View inflate(@LayoutRes final int layout, final @Nullable ViewGroup parent) {
        return inflate(layout, parent, false);
    }
}
