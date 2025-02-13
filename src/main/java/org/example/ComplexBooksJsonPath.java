package org.example;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ComplexBooksJsonPath {
    public static void main(String[] args) throws IOException {
        // Read JSON content from file
        String jsonFilePath = "src/main/resources/ComplexBooks.json";
        String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

        // Extract the color of the bicycle
        String bicycleColor = JsonPath.read(json, "$.store.bicycle.color");
        System.out.println("Bicycle color: " + bicycleColor); // Output: "red"

        // Extract all book titles
        List<String> bookTitles = JsonPath.read(json, "$.store.book[*].title");
        System.out.println("Book titles: " + bookTitles); // Output: ["The Great Gatsby", "1984", "Brave New World", "Sapiens", "Homo Deus"]

        // Extract all books with price greater than 15
        List<Map<String, Object>> expensiveBooks = JsonPath.read(json, "$.store.book[?(@.price > 15)]");
        System.out.println("Expensive books: " + expensiveBooks);

        // Extract all fiction books
        List<Map<String, Object>> fictionBooks = JsonPath.read(json, "$.store.book[?(@.category == 'fiction')]");
        System.out.println("Fiction books: " + fictionBooks);

        // Extract all books published before 1950
        List<Map<String, Object>> oldBooks = JsonPath.read(json, "$.store.book[?(@.published < 1950)]");
        System.out.println("Books published before 1950: " + oldBooks);

        // Extract the most expensive book
        List<Map<String, Object>> mostExpensiveBooks = JsonPath.read(json, "$.store.book[?(@.price == $.expensive)]");
        System.out.println("Most expensive book: " + mostExpensiveBooks);
    }
}