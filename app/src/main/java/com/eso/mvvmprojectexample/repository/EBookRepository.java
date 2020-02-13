package com.eso.mvvmprojectexample.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.eso.mvvmprojectexample.asynctask.DeleteBookAsyncTask;
import com.eso.mvvmprojectexample.asynctask.DeleteCategoryAsyncTask;
import com.eso.mvvmprojectexample.asynctask.InsertBookAsyncTask;
import com.eso.mvvmprojectexample.asynctask.InsertCategoryAsyncTask;
import com.eso.mvvmprojectexample.asynctask.UpdateBookAsyncTask;
import com.eso.mvvmprojectexample.asynctask.UpdateCategoryAsyncTask;
import com.eso.mvvmprojectexample.model.Book;
import com.eso.mvvmprojectexample.model.Category;
import com.eso.mvvmprojectexample.room.dao.BookDAO;
import com.eso.mvvmprojectexample.room.dao.CategoryDAO;
import com.eso.mvvmprojectexample.room.database.BooksDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EBookRepository {

    private CategoryDAO categoryDAO;
    private BookDAO bookDAO;
    private LiveData<List<Category>> categories;
    private LiveData<List<Book>> books;

    public EBookRepository(Application application) {
        BooksDatabase booksDatabase = BooksDatabase.getInstance(application);
        categoryDAO = booksDatabase.categoryDAO();
        bookDAO = booksDatabase.bookDAO();
    }

    public LiveData<List<Category>> getCategories() {
        return categoryDAO.getAllCategories();
    }

    public LiveData<List<Book>> getBooks(int category_id) {
        return bookDAO.getBook(category_id);
    }

    public void insertCategory(final Category category){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.insert(category);
            }
        });
    }

    public void deleteCategory(final Category category){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.delete(category);
            }
        });
    }

    public void updateCategory(final Category category){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.update(category);
            }
        });
    }

    public void insertBook(final Book book){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDAO.update(book);
            }
        });
    }

    public void deleteBook(final Book book){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDAO.update(book);
            }
        });
    }

    public void updateBook(final Book book){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDAO.update(book);
            }
        });
    }

}
