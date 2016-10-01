package br.com.clubedosaplicativos.booklisting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.clubedosaplicativos.booklisting.adapter.GoogleBooksAdapter;
import br.com.clubedosaplicativos.booklisting.model.Books;
import br.com.clubedosaplicativos.booklisting.model.GoogleBooksResponse;
import br.com.clubedosaplicativos.booklisting.task.GoogleBooksApiTask;
import br.com.clubedosaplicativos.booklisting.task.GoogleBooksApiTaskListener;

public class MainActivity extends AppCompatActivity {

    GoogleBooksAdapter mGoogleBooksAdapter;
    private EditText etSearchTerm;
    private Button btnSearch;
    private ListView lvBookList;
    private TextView tvNoData;
    private ContentLoadingProgressBar clpWidget;
    private GoogleBooksApiTaskListener mGoogleBooksApiTaskListener = new GoogleBooksApiTaskListener() {
        @Override
        public void onGoogleBooksApiFetchBookResponse(GoogleBooksResponse response) {
            MainActivity.this.loadBookList(response);
        }
    };
    private View.OnClickListener mButtonSearchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivity.this.performBookSearch(MainActivity.this.etSearchTerm.getText().toString());
        }
    };
    private AdapterView.OnItemClickListener mBookListItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Books bookItem = (Books) adapterView.getAdapter().getItem(i);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(bookItem.getVolumeInfo().getInfoLink()));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvNoData = (TextView) this.findViewById(R.id.tvNoData);
        this.lvBookList = (ListView) this.findViewById(R.id.lvBookList);
        this.btnSearch = (Button) this.findViewById(R.id.btnSearch);
        this.etSearchTerm = (EditText) this.findViewById(R.id.etSearchTerm);
        this.clpWidget = (ContentLoadingProgressBar) this.findViewById(R.id.clpWidget);
        this.lvBookList.setEmptyView(this.tvNoData);
        this.btnSearch.setOnClickListener(this.mButtonSearchClickListener);
        this.mGoogleBooksAdapter = new GoogleBooksAdapter(this);
        this.lvBookList.setAdapter(this.mGoogleBooksAdapter);
        this.lvBookList.setOnItemClickListener(this.mBookListItemClickListener);
    }

    private void performBookSearch(String searchTerm) {
        if (searchTerm.isEmpty()) {
            Toast.makeText(this, "You must type in a term to search for books.", Toast.LENGTH_SHORT).show();
            return;
        }
        this.clpWidget.show();
        GoogleBooksApiTask task = new GoogleBooksApiTask(this.mGoogleBooksApiTaskListener);
        task.execute(searchTerm);
    }

    private void loadBookList(GoogleBooksResponse response) {
        this.mGoogleBooksAdapter.clear();
        if (response.getItems() != null) {
            this.mGoogleBooksAdapter.addAll(response.getItems());
        } else {
            this.mGoogleBooksAdapter.clear();
        }
        this.clpWidget.hide();
    }
}
