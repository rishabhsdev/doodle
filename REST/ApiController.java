package com.rishabhsingh.dev.search.REST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.learn.database.dao.ApiService;
import com.example.learn.database.entity.Item;

@Controller
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/doodle")
    public String index(Model model) {
        return "index"; 
    }

    @GetMapping("/doodle/search")
    public String index(@RequestParam(name = "query", required = false, defaultValue = "") String query, Model model) {
        List<Item> items = apiService.fetchDataFromApi(query);
        model.addAttribute("items", items);
        return "search"; 
    }
}
