package com.eso.mvvmprojectexample.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eso.mvvmprojectexample.model.Book;
import com.eso.mvvmprojectexample.model.Category;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM BOOKS_TABLE")
    LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM BOOKS_TABLE WHERE category_id ==:categoryId")
    LiveData<List<Book>> getBook(int categoryId);
}
