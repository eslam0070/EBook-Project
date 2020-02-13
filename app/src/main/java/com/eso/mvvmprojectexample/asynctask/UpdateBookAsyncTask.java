package com.eso.mvvmprojectexample.asynctask;

import android.os.AsyncTask;

import com.eso.mvvmprojectexample.model.Book;
import com.eso.mvvmprojectexample.room.dao.BookDAO;

public class UpdateBookAsyncTask extends AsyncTask<Book,Void,Void> {

    private BookDAO bookDAO;

    public UpdateBookAsyncTask(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    protected Void doInBackground(Book... books) {
        bookDAO.update(books[0]);
        return null;
    }
}
