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
import br.com.clubedosaplicativos.booklisting.model.GoogleBooksResponse;

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

    public GoogleBooksResponse fetchBooks(String searchTerm) {
        URL url = this.createURL(searchTerm);
        String json = this.makeGetHTTPRequest(url);

        return this.parseGoogleBooksJsonResponse(json);
    }

    private GoogleBooksResponse parseGoogleBooksJsonResponse(String json) {
        GoogleBooksResponse response = new GoogleBooksResponse();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonItemsArray = jsonObject.getJSONArray("items");

            this.fillGoogleBooksObject(response, jsonObject);
            this.fillGoogleBooksItemsArray(response, jsonItemsArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response;
    }

    private void fillGoogleBooksObject(GoogleBooksResponse response, JSONObject jsonResponseObject) {
        try {
            response.setKind(jsonResponseObject.getString("kind"));
            response.setTotalItems(jsonResponseObject.getInt("totalItems"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void fillGoogleBooksItemsArray(GoogleBooksResponse response, JSONArray jsonResultsArray) {
        try {
            List<Books> newsList = new ArrayList<>();
            for (int i = 0; i < jsonResultsArray.length(); i++) {
                JSONObject jsonBookItem = jsonResultsArray.getJSONObject(i);
                Books newsItem = new Books(jsonBookItem.getString("kind"),
                        jsonBookItem.getString("id"),
                        jsonBookItem.getString("etag"),
                        jsonBookItem.getString("selfLink"),
                        this.readVolumeInfoFromJson(jsonBookItem),
                        this.readSaleInfoFromJson(jsonBookItem),
                        this.readAccessInfoFromJson(jsonBookItem),
                        this.readSearchInfoFromJson(jsonBookItem)
                );
                newsList.add(newsItem);
            }
            response.setItems(newsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Books.VolumeInfoBean readVolumeInfoFromJson(JSONObject jsonBookItem) throws JSONException {
        JSONObject jsonVolumeInfo = jsonBookItem.getJSONObject("volumeInfo");
        Books.VolumeInfoBean volumeInfoBean = new Books.VolumeInfoBean(
                jsonVolumeInfo.getString("title"),
                jsonVolumeInfo.optString("subtitle"),
                jsonVolumeInfo.optString("publisher"),
                jsonVolumeInfo.optString("description"),
                this.readReadingModesFromJson(jsonVolumeInfo),
                jsonVolumeInfo.optInt("pageCount"),
                jsonVolumeInfo.optString("printType"),
                jsonVolumeInfo.optDouble("averageRating"),
                jsonVolumeInfo.optInt("ratingsCount"),
                jsonVolumeInfo.optString("maturityRating"),
                jsonVolumeInfo.optBoolean("allowAnonLogging"),
                jsonVolumeInfo.optString("contentVersion"),
                this.readImageLinksFromJson(jsonVolumeInfo),
                jsonVolumeInfo.optString("language"),
                jsonVolumeInfo.optString("previewLink"),
                jsonVolumeInfo.optString("infoLink"),
                jsonVolumeInfo.optString("canonicalVolumeLink"),
                this.readArrayOfString(jsonVolumeInfo.optJSONArray("authors")),
                this.readIndustryIdentifiersFromJson(jsonVolumeInfo)
        );
        return volumeInfoBean;
    }

    private Books.VolumeInfoBean.ReadingModesBean readReadingModesFromJson(JSONObject jsonVolumeInfo) {
        Books.VolumeInfoBean.ReadingModesBean readingModesBean = null;
        try {
            JSONObject jsonReadingModes = jsonVolumeInfo.getJSONObject("readingModes");
            readingModesBean = new Books.VolumeInfoBean.ReadingModesBean(
                    jsonReadingModes.getBoolean("text"),
                    jsonReadingModes.getBoolean("image")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return readingModesBean;
    }

    private Books.VolumeInfoBean.ImageLinksBean readImageLinksFromJson(JSONObject jsonVolumeInfo) {
        Books.VolumeInfoBean.ImageLinksBean imageLinksBean = null;
        try {
            JSONObject jsonImagesLinks = jsonVolumeInfo.getJSONObject("imageLinks");
            imageLinksBean = new Books.VolumeInfoBean.ImageLinksBean(
                    jsonImagesLinks.getString("smallThumbnail"),
                    jsonImagesLinks.getString("thumbnail")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return imageLinksBean;
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

    private List<Books.VolumeInfoBean.IndustryIdentifiersBean> readIndustryIdentifiersFromJson(JSONObject jsonVolumeInfo) {
        List<Books.VolumeInfoBean.IndustryIdentifiersBean> industryIdentifiersBeanList = new ArrayList<>();
        try {
            JSONArray jsonIndustryIdentifiersArray = jsonIndustryIdentifiersArray = jsonVolumeInfo.getJSONArray("industryIdentifiers");
            for (int i = 0; i < jsonIndustryIdentifiersArray.length(); i++) {
                JSONObject jsonIndustryIdentifierItem = jsonIndustryIdentifiersArray.getJSONObject(i);
                Books.VolumeInfoBean.IndustryIdentifiersBean industryIdentifiersBean = new Books.VolumeInfoBean.IndustryIdentifiersBean(
                        jsonIndustryIdentifierItem.getString("type"),
                        jsonIndustryIdentifierItem.getString("identifier")
                );
                industryIdentifiersBeanList.add(industryIdentifiersBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return industryIdentifiersBeanList;
    }

    private Books.SaleInfoBean readSaleInfoFromJson(JSONObject jsonBookItem) {
        Books.SaleInfoBean saleInfoBean = null;
        try {
            JSONObject jsonSaleInfo = jsonBookItem.getJSONObject("saleInfo");
            saleInfoBean = new Books.SaleInfoBean(
                    jsonSaleInfo.getString("country"),
                    jsonSaleInfo.getString("saleability"),
                    jsonSaleInfo.getBoolean("isEbook")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return saleInfoBean;
    }

    private Books.AccessInfoBean readAccessInfoFromJson(JSONObject jsonBookItem) {
        Books.AccessInfoBean saleInfoBean = null;
        try {
            JSONObject jsonAccessInfo = jsonBookItem.getJSONObject("accessInfo");
            saleInfoBean = new Books.AccessInfoBean(
                    jsonAccessInfo.getString("country"),
                    jsonAccessInfo.getString("viewability"),
                    jsonAccessInfo.getBoolean("embeddable"),
                    jsonAccessInfo.getBoolean("publicDomain"),
                    jsonAccessInfo.getString("textToSpeechPermission"),
                    this.readEpubFromJson(jsonAccessInfo),
                    this.readPdfFromJson(jsonAccessInfo),
                    jsonAccessInfo.getString("webReaderLink"),
                    jsonAccessInfo.getString("accessViewStatus"),
                    jsonAccessInfo.getBoolean("quoteSharingAllowed")

            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return saleInfoBean;
    }

    private Books.AccessInfoBean.EpubBean readEpubFromJson(JSONObject jsonAccessInfo) {
        Books.AccessInfoBean.EpubBean epubBean = null;
        try {
            JSONObject jsonEpub = jsonAccessInfo.getJSONObject("epub");
            epubBean = new Books.AccessInfoBean.EpubBean(jsonEpub.getBoolean("isAvailable"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return epubBean;
    }

    private Books.AccessInfoBean.PdfBean readPdfFromJson(JSONObject jsonAccessInfo) {
        Books.AccessInfoBean.PdfBean pdfBean = null;
        try {
            JSONObject jsonPdf = jsonAccessInfo.getJSONObject("pdf");
            pdfBean = new Books.AccessInfoBean.PdfBean(jsonPdf.getBoolean("isAvailable"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return pdfBean;
    }

    private Books.SearchInfoBean readSearchInfoFromJson(JSONObject jsonBookItem) {
        Books.SearchInfoBean searchInfoBean = null;
        try {
            JSONObject jsonSearchInfo = jsonBookItem.getJSONObject("searchInfo");
            searchInfoBean = new Books.SearchInfoBean(jsonSearchInfo.getString("textSnippet"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return searchInfoBean;
    }
}
