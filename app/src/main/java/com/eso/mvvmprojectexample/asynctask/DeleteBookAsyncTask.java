package com.eso.mvvmprojectexample.asynctask;

import android.os.AsyncTask;

import com.eso.mvvmprojectexample.model.Book;
import com.eso.mvvmprojectexample.room.dao.BookDAO;

public class DeleteBookAsyncTask extends AsyncTask<Book,Void,Void> {

    private BookDAO bookDAO;

    public DeleteBookAsyncTask(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    protected Void doInBackground(Book... books) {
        bookDAO.delete(books[0]);
        return null;
    }
}
