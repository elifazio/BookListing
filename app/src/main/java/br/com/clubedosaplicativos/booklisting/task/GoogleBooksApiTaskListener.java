package br.com.clubedosaplicativos.booklisting.task;

import java.util.List;

import br.com.clubedosaplicativos.booklisting.model.Books;

/**
 * Created by elifa on 01/10/2016.
 */
public interface GoogleBooksApiTaskListener {
    void onGoogleBooksApiFetchBookResponse(List<Books> bookList);
}
