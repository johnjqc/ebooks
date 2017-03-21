package com.jsoft.ebooksdirectory;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jsoft.ebooksdirectory.holder.BookHolder;
import com.jsoft.ebooksdirectory.model.Book;

import java.net.URL;

/**
 *  @author JohnJQC
 */
public class MainActivity extends BaseActivity {

	private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private static String LOG_TAG = "eBooks-MainActivity";

    DatabaseReference conditionRef = null;
    private FirebaseRecyclerAdapter<Book, BookHolder> mAdapterFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        conditionRef = mRootRef.child("books");

        new LoadFirebaseData().execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Query postsQuery = conditionRef;
//        mAdapterFb = new FirebaseRecyclerAdapter<Book, BookHolder>(Book.class, R.layout.bookcard_view, BookHolder.class, postsQuery) {
//            @Override
//            protected void populateViewHolder(BookHolder viewHolder, Book model, int position) {
//                asyncTaskWrapper(viewHolder, model, position).execute();

//                viewHolder.name.setText(model.getName());
//                viewHolder.year.setText(String.valueOf(model.getYear()));
//
//                final DatabaseReference postRef = getRef(position);
//                final String postKey = postRef.getKey();
//                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // Launch PostDetailActivity
//
//                    }
//                });
//            }
//        };

    }


    public AsyncTask asyncTaskWrapper(final BookHolder viewHolder, final Book model, final int position) {
        AsyncTask task = new AsyncTask<URL, Integer, Long>() {
            @Override
            protected Long doInBackground(URL... params) {
                return null;
            }
            @Override
            protected void onProgressUpdate(Integer... progress) {
            }

            @Override
            protected void onPostExecute(Long result) {
                System.out.println("Finished executing public");
                viewHolder.name.setText(model.getName());
                viewHolder.year.setText(String.valueOf(model.getYear()));
            }
        };
        return task;
    }

    public class LoadFirebaseData extends AsyncTask<Void, Void, Integer> {
        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            try {
                Dialog.setMessage("Doing something...");
                Dialog.show();
                Log.d("task...", "mensaje show");
            }catch (Exception e) {
                Log.d("task...", "mensaje error.....");
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(Integer result) {
            if(result==0) {
                mRecyclerView.setAdapter(mAdapterFb);
            }
            Dialog.dismiss();
        }

        @Override
        protected Integer doInBackground(Void... params) {
            Query postsQuery = conditionRef;
            mAdapterFb = new FirebaseRecyclerAdapter<Book, BookHolder>(Book.class, R.layout.bookcard_view, BookHolder.class, postsQuery) {
                @Override
                protected void populateViewHolder(BookHolder viewHolder, Book model, int position) {

                viewHolder.name.setText(model.getName());
                viewHolder.year.setText(String.valueOf(model.getYear()));

//                final DatabaseReference postRef = getRef(position);
//                final String postKey = postRef.getKey();
//                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // Launch PostDetailActivity
//
//                    }
//                });
                }
            };

            return 0;
        }


    }

}
