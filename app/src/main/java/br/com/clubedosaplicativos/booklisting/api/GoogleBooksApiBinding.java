package br.com.clubedosaplicativos.booklisting.api;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.clubedosaplicativos.booklisting.model.Books;

/**
 * Created by elifa on 27/09/2016.
 */
public class GoogleBooksApiBinding extends ApiBindingBase {

    private static final String TAG = GoogleBooksApiBinding.class.getSimpleName();
    // https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1
    private String mUrl = "https://www.googleapis.com/books/v1/volumes";

    @Override
    protected URL createURL(String searchTerm) {
        try {
            Uri baseUrl = Uri.parse(this.mUrl);
            Uri.Builder urlBuilder = baseUrl.buildUpon();
            urlBuilder.appendQueryParameter("q", searchTerm);
            urlBuilder.appendQueryParameter("maxResults", "20");
            return super.createURL(urlBuilder.toString());
        } catch (Exception e) {
            Log.e(TAG, "There may be a problem building url", e);
        }
        return null;
    }

    public List<Books> fetchBooks(String searchTerm) {
        URL url = this.createURL(searchTerm);
        String json = this.makeGetHTTPRequest(url);

        return this.parseGoogleBooksJsonResponse(json);
    }

    private List<Books> parseGoogleBooksJsonResponse(String json) {
        List<Books> bookList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonItemsArray = jsonObject.getJSONArray("items");

            this.fillGoogleBooksItemsArray(bookList, jsonItemsArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    private void fillGoogleBooksItemsArray(List<Books> bookList, JSONArray jsonResultsArray) {
        try {
            for (int i = 0; i < jsonResultsArray.length(); i++) {
                JSONObject jsonBookItem = jsonResultsArray.getJSONObject(i);
                Books bookItem = new Books(jsonBookItem.getString("kind"),
                        jsonBookItem.getString("id"),
                        this.readVolumeInfoFromJson(jsonBookItem)
                );
                bookList.add(bookItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Books.VolumeInfoBean readVolumeInfoFromJson(JSONObject jsonBookItem) throws JSONException {
        JSONObject jsonVolumeInfo = jsonBookItem.getJSONObject("volumeInfo");
        Books.VolumeInfoBean volumeInfoBean = new Books.VolumeInfoBean(
                jsonVolumeInfo.getString("title"),
                jsonVolumeInfo.optString("subtitle"),
                jsonVolumeInfo.optString("description"),
                jsonVolumeInfo.optString("infoLink"),
                this.readArrayOfString(jsonVolumeInfo.optJSONArray("authors"))
        );
        return volumeInfoBean;
    }

    private List<String> readArrayOfString(JSONArray jsonArray) {
        List<String> stringList = new ArrayList<>();
        if (jsonArray != null) {
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    stringList.add(jsonArray.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
