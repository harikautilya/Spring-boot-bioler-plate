package com.starter.plate.model;

import java.util.List;

public class SearchRequest {

    private List<String> searchWords;

    public SearchRequest() {
    }

    public List<String> getSearchWords() {
        return searchWords;
    }

    public void setSearchWords(List<String> searchWords) {
        this.searchWords = searchWords;
    }
}
