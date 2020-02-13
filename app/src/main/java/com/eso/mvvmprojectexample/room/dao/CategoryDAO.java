package com.eso.mvvmprojectexample.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eso.mvvmprojectexample.model.Category;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    void insert (Category category);

    @Update
    void update (Category category);

    @Delete
    void delete (Category category);

    @Query("SELECT * FROM CATEGORIES_TABLE")
    LiveData<List<Category>> getAllCategories();
}
