package com.SpringProject.Anydo.item;

import com.SpringProject.Anydo.model.AnydoItem;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;


    public AnydoItem getItem(Long id){
        return itemRepository.getItem(id);
    }

    public List<AnydoItem> getAllItems() {

        return itemRepository.findAll();
    }


    public AnydoItem addItem(JsonNode json) {

        AnydoItem anydoItem = new AnydoItem();

        String name = json.get("itemName").asText();
        anydoItem.setItemName(name);

        String day = json.get("dayName").asText();
        anydoItem.setDayName(day);

        long listId = json.get("listId").asLong();
        anydoItem.setListId(listId);

        return itemRepository.save(anydoItem);
    }

    public List<AnydoItem> deleteItem(String name) {
        itemRepository.delete(itemRepository.deleteOne(name));
        return itemRepository.findAll();
    }

    public AnydoItem updateItem(JsonNode json, String name) {
        AnydoItem anydoItem = itemRepository.getOne(name);

        String itemName = json.get("itemName").asText();
        anydoItem.setItemName(itemName);

        return itemRepository.save(anydoItem);
    }
}

