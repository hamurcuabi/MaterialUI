package com.example.hp.studentregister;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
abstract class StudentDao implements BaseDao<Student> {


    @Query("SELECT * FROM student_table")
    abstract List<Student> getAll();

}
