package com.example.azuga.Azugademo.controller;


import com.example.azuga.Azugademo.model.Items;
import com.example.azuga.Azugademo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(value = "/add")
    public String addItem(@RequestBody List<Items> item){
        return itemService.addItem(item);
    }
}
