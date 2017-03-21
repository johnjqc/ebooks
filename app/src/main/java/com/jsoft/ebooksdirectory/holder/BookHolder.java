package com.jsoft.ebooksdirectory.holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jsoft.ebooksdirectory.R;
import com.jsoft.ebooksdirectory.model.Book;

/**
 * Created by john on 20/03/17.
 */

public class BookHolder extends RecyclerView.ViewHolder {
    private static String TAG = "BookHolder";

    public TextView name;
    public TextView year;

    public BookHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.person_name);
        year = (TextView) itemView.findViewById(R.id.person_age);
    }

    public void bindToPost(Book book, View.OnClickListener starClickListener) {
        name.setText(book.getName());
        year.setText(String.valueOf(book.getYear()));
//        starView.setOnClickListener(starClickListener);
    }
}
