package br.com.clubedosaplicativos.booklisting.task;

import android.os.AsyncTask;

import java.util.List;

import br.com.clubedosaplicativos.booklisting.api.GoogleBooksApiBinding;
import br.com.clubedosaplicativos.booklisting.model.Books;

/**
 * Created by elifa on 01/10/2016.
 */
public class GoogleBooksApiTask extends AsyncTask<String, Void, List<Books>> {

    private GoogleBooksApiTaskListener mListener;

    public GoogleBooksApiTask(GoogleBooksApiTaskListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<Books> doInBackground(String... strings) {
        GoogleBooksApiBinding googleBooksApiBinding = new GoogleBooksApiBinding();
        return googleBooksApiBinding.fetchBooks(strings[0]);
    }

    @Override
    protected void onPostExecute(List<Books> bookList) {
        super.onPostExecute(bookList);
        if (this.mListener != null) this.mListener.onGoogleBooksApiFetchBookResponse(bookList);
    }
}
