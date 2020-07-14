package com.example.azuga.Azugademo.service;


import com.example.azuga.Azugademo.helper.ItemHelper;
import com.example.azuga.Azugademo.model.Items;
import com.example.azuga.Azugademo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public String addItem(List<Items> items) {
        for (Items item : items) {
            float price = new ItemHelper().applyTax(item.getItemCategory(), item.getPrice(), item.getQuantity());
            item.setPrice((price == 0.0) ? (item.getPrice() * item.getQuantity()) : price);
            itemRepository.save(item);
        }
        return "saved";
    }
}
