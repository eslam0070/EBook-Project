package com.eso.mvvmprojectexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.Callback;
import androidx.recyclerview.widget.RecyclerView;

import com.eso.mvvmprojectexample.DiffUtil.BooksDiffCallback;
import com.eso.mvvmprojectexample.R;
import com.eso.mvvmprojectexample.databinding.BookTitleListBinding;
import com.eso.mvvmprojectexample.model.Book;

import java.util.ArrayList;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private ArrayList<Book> bookArrayList = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BookTitleListBinding bookTitleListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.book_title_list,parent,false);
        return new ViewHolder(bookTitleListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = bookArrayList.get(position);
        holder.bookTitleListBinding.setBook(book);
    }

    @Override
    public int getItemCount() {
        if (bookArrayList==null)return 0;
            return bookArrayList.size();
    }

    public void setBookArrayList(ArrayList<Book> newBooks) {
        /*this.bookArrayList = bookArrayList;
        notifyDataSetChanged();*/
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new BooksDiffCallback(bookArrayList,newBooks),false);
        bookArrayList = newBooks;
        result.dispatchUpdatesTo(BooksAdapter.this);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
       private BookTitleListBinding bookTitleListBinding;

       public ViewHolder(@NonNull BookTitleListBinding bookTitleListBinding) {
           super(bookTitleListBinding.getRoot());
           this.bookTitleListBinding = bookTitleListBinding;
           bookTitleListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int clikedPosition = getAdapterPosition();
                   if (mOnItemClickListener != null && clikedPosition != RecyclerView.NO_POSITION){
                       mOnItemClickListener.onItemClick(bookArrayList.get(clikedPosition));
                   }
               }
           });
       }
   }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(Book book);
   }
}
