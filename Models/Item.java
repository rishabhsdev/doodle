package com.rishabhsingh.dev.search.Models;

public class Item {
    private String body;
    private String title;
    private String url;
    private String icon;
    private String query;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getIcon() {
        return icon;
    }

    public String getQuery() {
        return query;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
