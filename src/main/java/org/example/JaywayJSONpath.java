package org.example;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JaywayJSONpath {
    public static void main(String[] args) throws IOException {

        // Read JSON content from file
        String jsonFilePath = "src/main/resources/JaywayJSON.json";
        String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        // Extract the location
        String location = JsonPath.read(json, "$.store.location");
        System.out.println(location); // Output: "New York"

        // Extract all book prices
        List<Integer> prices = JsonPath.read(json, "$.store.book[*].price");
        System.out.println(prices); // Output: [10, 15]

        // Filter books with price > 12
        List<Object> expensiveBooks = JsonPath.read(json, "$.store.book[?(@.price > 12)]");
        System.out.println(expensiveBooks); // Output: [{ "title": "1984", "price": 15 }]
    }
}