import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - " + category;
    }
}

public class Part_C {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1000, "Electronics"),
            new Product("Smartphone", 700, "Electronics"),
            new Product("Desk", 200, "Furniture"),
            new Product("Chair", 150, "Furniture"),
            new Product("Monitor", 300, "Electronics")
        );

        // Group products by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Grouped by category: " + grouped);

        // Find most expensive product in each category
        Map<String, Optional<Product>> maxPriceProduct = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("Most expensive product per category: " + maxPriceProduct);

        // Calculate average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("Average price of products: $" + avgPrice);
    }
}