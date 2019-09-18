package com.emrhmrc.flexablercvtest.depoQr.recyclerview;

public interface OnItemClickListener<T> extends BaseRecyclerListener {

   // void onItemClicked(T item);

    void onItemClicked(T item, int positon);
}