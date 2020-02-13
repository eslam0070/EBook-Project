package com.eso.mvvmprojectexample.asynctask;

import android.os.AsyncTask;

import com.eso.mvvmprojectexample.model.Category;
import com.eso.mvvmprojectexample.room.dao.CategoryDAO;

public class InsertCategoryAsyncTask extends AsyncTask<Category,Void,Void> {

    CategoryDAO categoryDAO;

    public InsertCategoryAsyncTask(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    protected Void doInBackground(Category... categories) {
        categoryDAO.insert(categories[0]);
        return null;
    }
}
