package com.jsoft.ebooksdirectory.service;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by john on 20/03/17.
 */

public class LoadFirebaseData extends AsyncTask<Void, Void, Integer> {
    private ProgressDialog Dialog = null;//new ProgressDialog(LastPage.this);

    @Override
    protected void onPreExecute()
    {
        try {
            Dialog.setMessage("Doing something...");
            Dialog.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPostExecute(Integer result)
    {

        if(result==0)
        {
            //do some thing
        }
        // after completed finished the progressbar
        Dialog.dismiss();
    }

    @Override
    protected Integer doInBackground(Void... params) {



        return 0;
    }


}
