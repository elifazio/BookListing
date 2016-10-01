package br.com.clubedosaplicativos.booklisting.model;

import java.util.List;

/**
 * Created by elifa on 27/09/2016.
 */
public class GoogleBooksResponse {

    private String kind;
    private int totalItems;
    private List<Books> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Books> getItems() {
        return items;
    }

    public void setItems(List<Books> items) {
        this.items = items;
    }

    public static class ItemsBean {

    }
}
