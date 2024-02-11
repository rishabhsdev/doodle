package com.rishabhsingh.dev.search.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;

import com.example.learn.database.entity.Item;
import com.example.learn.database.entity.R_Item;
import com.example.learn.database.entity.StackItem;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Item> fetchDataFromApi(String query) {

        String stackApiUrl = "https://api.stackexchange.com/2.3/search/excerpts?order=desc&sort=relevance&q="
                + query + "&accepted=True&site=stackoverflow";

        String redditApiUrl = "https://www.reddit.com/search.json?q=" + query + "&limit=3";

        ResponseEntity<StackItem[]> stackResponseEntity = restTemplate.getForEntity(stackApiUrl, StackItem[].class);
        ResponseEntity<R_Item[]> redditResponseEntity = restTemplate.getForEntity(redditApiUrl, R_Item[].class);

        StackItem[] stackItems = stackResponseEntity.getBody();
        R_Item[] redditItems = redditResponseEntity.getBody();

        List<Item> items = new ArrayList<>();

        for (R_Item r_item : redditItems) {
            Item item = new Item();
            item.setTitle(r_item.getTitle());
            item.setBody(r_item.getBody());
            item.setUrl(r_item.getUrl());
            item.setIcon("Reddit");
            item.setQuery(query);

            items.add(item);

        }

        for (StackItem stackItem : stackItems) {
            Item item = new Item();
            item.setTitle(stackItem.getTitle());
            item.setBody(stackItem.getBody());
            item.setUrl("https://stackoverflow.com");
            item.setIcon("StackOverflow");
            item.setQuery(query);

            items.add(item);

        }

        return items;

    }
}
