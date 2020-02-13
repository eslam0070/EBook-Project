package com.eso.mvvmprojectexample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.eso.mvvmprojectexample.model.Book;
import com.eso.mvvmprojectexample.model.Category;
import com.eso.mvvmprojectexample.repository.EBookRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private EBookRepository eBookRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookRepository = new EBookRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = eBookRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int category_id) {
        booksOfASelectedCategory = eBookRepository.getBooks(category_id);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book){
        eBookRepository.insertBook(book);
    }

    public void deleteBook(Book book){
        eBookRepository.deleteBook(book);
    }

    public void updateBook(Book book){
        eBookRepository.updateBook(book);
    }
}
