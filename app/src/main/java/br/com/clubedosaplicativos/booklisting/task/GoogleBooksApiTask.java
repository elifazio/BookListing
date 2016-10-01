package br.com.clubedosaplicativos.booklisting.task;

import android.os.AsyncTask;

import br.com.clubedosaplicativos.booklisting.api.GoogleBooksApiBinding;
import br.com.clubedosaplicativos.booklisting.model.GoogleBooksResponse;

/**
 * Created by elifa on 01/10/2016.
 */
public class GoogleBooksApiTask extends AsyncTask<String, Void, GoogleBooksResponse> {

    private GoogleBooksApiTaskListener mListener;

    public GoogleBooksApiTask(GoogleBooksApiTaskListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected GoogleBooksResponse doInBackground(String... strings) {
        GoogleBooksApiBinding googleBooksApiBinding = new GoogleBooksApiBinding();
        return googleBooksApiBinding.fetchBooks(strings[0]);
    }

    @Override
    protected void onPostExecute(GoogleBooksResponse googleBooksResponse) {
        super.onPostExecute(googleBooksResponse);
        if (this.mListener != null) this.mListener.onGoogleBooksApiFetchBookResponse(googleBooksResponse);
    }
}
