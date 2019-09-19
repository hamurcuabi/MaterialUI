package com.emrhmrc.hateksdepoqr.depoQr.recyclerview;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Base ViewHolder to be used with the generic adapter.
 * {@link GenericAdapter}
 *
 * @param <T> type of objects, which will be used in the adapter's data set
 * @param <L> click listener {@link BaseRecyclerListener}
 */
public abstract class BaseViewHolder<T, L extends BaseRecyclerListener> extends RecyclerView.ViewHolder {

    private L listener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(T item, @Nullable L listener);

    public void onBind(T item, List<Object> payloads) {
        onBind(item, listener);
    }

    protected L getListener() {
        return listener;
    }

}