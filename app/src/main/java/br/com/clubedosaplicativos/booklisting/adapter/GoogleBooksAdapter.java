package br.com.clubedosaplicativos.booklisting.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.clubedosaplicativos.booklisting.R;
import br.com.clubedosaplicativos.booklisting.model.Books;

/**
 * Created by elifa on 01/10/2016.
 */

public class GoogleBooksAdapter extends ArrayAdapter<Books> {

    private Collection<? extends Books>  mBookList;

    public GoogleBooksAdapter(Context context) {
        super(context, R.layout.book_list_item);
    }

    @Override
    public void addAll(Collection<? extends Books> collection) {
        super.addAll(collection);
        this.mBookList = collection;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.book_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvBookTitle = (TextView) convertView.findViewById(R.id.tvBookTitle);
            viewHolder.tvSubTitle = (TextView) convertView.findViewById(R.id.tvSubTitle);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvAuthors = (TextView) convertView.findViewById(R.id.tvAuthors);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Books book = this.getItem(position);
        viewHolder.tvBookTitle.setText(book.getVolumeInfo().getTitle());
        if (book.getVolumeInfo().getSubTitle().isEmpty()) {
            viewHolder.tvSubTitle.setVisibility(View.GONE);
        } else {
            viewHolder.tvSubTitle.setText(book.getVolumeInfo().getSubTitle());
            viewHolder.tvSubTitle.setVisibility(View.VISIBLE);
        }
        if (book.getVolumeInfo().getDescription().isEmpty()) {
            viewHolder.tvDescription.setVisibility(View.GONE);
        } else {
            viewHolder.tvDescription.setText(book.getVolumeInfo().getDescription());
            viewHolder.tvDescription.setVisibility(View.VISIBLE);
        }
        String authors = "";
        for (String author : book.getVolumeInfo().getAuthors()) {
            authors = (authors.isEmpty()) ? author : authors + ", " + author;
        }
        viewHolder.tvAuthors.setText(authors);

        return convertView;
    }

    public ArrayList<Books> getBookList() {
        return (ArrayList<Books>) mBookList;
    }

    static class ViewHolder {
        TextView tvBookTitle;
        TextView tvSubTitle;
        TextView tvDescription;
        TextView tvAuthors;
    }
}
