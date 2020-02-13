package com.eso.mvvmprojectexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eso.mvvmprojectexample.databinding.ActivityAddAndEditBinding;
import com.eso.mvvmprojectexample.model.Book;

import static com.eso.mvvmprojectexample.utils.Base.BOOK_ID;
import static com.eso.mvvmprojectexample.utils.Base.BOOK_NAME;
import static com.eso.mvvmprojectexample.utils.Base.UNIT_PRICE;

public class AddAndEditActivity extends AppCompatActivity {

    Book book;

    ActivityAddAndEditBinding activityAddAndEditBinding;
    AddAndEditActivityClickHandlers handlers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_edit);
        book = new Book();
        handlers = new AddAndEditActivityClickHandlers(this);
        activityAddAndEditBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_and_edit);
        activityAddAndEditBinding.setBook(book);
        activityAddAndEditBinding.setClick(handlers);
        Intent intent = getIntent();
        if (intent.hasExtra(BOOK_ID)){
            setTitle("Edit Book");
            book.setBookName(intent.getStringExtra(BOOK_NAME));
            book.setUnitPrice(intent.getStringExtra(UNIT_PRICE));

        }
        else
            setTitle("Add New Book");
    }

    public class AddAndEditActivityClickHandlers {
        Context context;

        AddAndEditActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitButtonClicked(View view){
            if (book.getBookName() == null){
                Toast.makeText(context, "Name Field cannot be empty", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent();
                intent.putExtra(BOOK_NAME,book.getBookName());
                intent.putExtra(UNIT_PRICE,book.getUnitPrice());
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
}
