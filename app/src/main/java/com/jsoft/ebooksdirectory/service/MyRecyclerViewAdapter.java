package com.jsoft.ebooksdirectory.service;
 
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jsoft.ebooksdirectory.R;
import com.jsoft.ebooksdirectory.holder.BookHolder;
import com.jsoft.ebooksdirectory.model.Book;

import java.util.ArrayList;
 
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<BookHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Book> mDataset;
    private static MyClickListener myClickListener;

    public MyRecyclerViewAdapter(ArrayList<Book> myDataset) {
        mDataset = myDataset;
    }

//    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView label;
//        TextView dateTime;
//
//        public DataObjectHolder(View itemView) {
//            super(itemView);
//            label = (TextView) itemView.findViewById(R.id.person_name);
//            dateTime = (TextView) itemView.findViewById(R.id.person_age);
//            Log.i(LOG_TAG, "Adding Listener");
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            myClickListener.onItemClick(getAdapterPosition(), v);
//        }
//    }
 
//    public void setOnItemClickListener(MyClickListener myClickListener) {
//        this.myClickListener = myClickListener;
//    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookcard_view, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        BookHolder dataObjectHolder = new BookHolder(view);
        return dataObjectHolder;
    }
 
    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        holder.name.setText(mDataset.get(position).getName());
        holder.year.setText("" + mDataset.get(position).getYear());
    }
 
    public void addItem(Book dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }
 
    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }
 
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
 
    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}