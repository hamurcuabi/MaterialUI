package com.example.hp.studentregister;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

public interface BaseDao<T> {

    @Insert
    void insert(T obj);

    @Insert
    void insert(T... obj);

    @Update
    void update(T obj);

    @Delete
    void delete(T obj);
}
