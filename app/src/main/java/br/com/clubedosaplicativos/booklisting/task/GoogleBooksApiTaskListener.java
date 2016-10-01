package br.com.clubedosaplicativos.booklisting.task;

import br.com.clubedosaplicativos.booklisting.model.GoogleBooksResponse;

/**
 * Created by elifa on 01/10/2016.
 */
public interface GoogleBooksApiTaskListener {
    void onGoogleBooksApiFetchBookResponse(GoogleBooksResponse response);
}
