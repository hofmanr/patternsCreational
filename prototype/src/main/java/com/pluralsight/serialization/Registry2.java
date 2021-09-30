package com.pluralsight.serialization;

import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Registry2 {

    private Map<String, Item> items = new HashMap<String, Item>();

    public Registry2() {
        loadItems();
    }

    public Item createItem (String type) {
        // this is a deep copy
        return SerializationUtils.clone(items.get(type));
    }

    private void loadItems() {
        Movie2 movie = new Movie2();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRecord(new Record());
        movie.setActors(Arrays.asList("John Wayne", "Sudrey Hepburn"));
        items.put("Movie", movie);

        Book2 book = new Book2();
        book.setNumberOfPages(335);
        book.setPrice(19.99);
        book.setTitle("Basic Book");
        items.put("Book", book);
    }
}
