import java.util.Arrays;
import java.util.Comparator;
public class ProductSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();
            if (midId == targetId) {
                return products[mid];
            } else if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create sample products
        Product[] products = {
                new Product(305, "Water Bottle", "Kitchen"),
                new Product(101, "Keyboard", "Electronics"),
                new Product(203, "Desk Lamp", "Home"),
                new Product(409, "Wireless Mouse", "Electronics"),
                new Product(287, "Coffee Mug", "Kitchen")
        };

        System.out.println("=== Original Products (Unsorted) ===");
        for (Product p : products) System.out.println(p);

        // Linear Search
        System.out.println("\n=== Linear Search Execution ===");
        Product linearResult = linearSearch(products, 203);
        System.out.println("Searching for ID 203: " +
                (linearResult != null ? "FOUND - " + linearResult : "Not Found"));

        // Sort for binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\n=== Sorted Products (for Binary Search) ===");
        for (Product p : products) System.out.println(p);

        // Binary Search
        System.out.println("\n=== Binary Search Execution ===");
        Product binaryResult = binarySearch(products, 305);
        System.out.println("Searching for ID 305: " +
                (binaryResult != null ? "FOUND - " + binaryResult : "Not Found"));

        // Performance Analysis
        System.out.println("\n=== Algorithm Analysis ===");
        System.out.println("Linear Search Complexity:");
        System.out.println("- Best-case: O(1) (target is first element)");
        System.out.println("- Average-case: O(n)");
        System.out.println("- Worst-case: O(n) (target is last or missing)");

        System.out.println("\nBinary Search Complexity:");
        System.out.println("- Best-case: O(1) (target is middle element)");
        System.out.println("- Average-case: O(log n)");
        System.out.println("- Worst-case: O(log n)");

        System.out.println("\n=== E-commerce Platform Recommendation ===");
        System.out.println("For large catalogs (>1000 products):");
        System.out.println("- Binary search is significantly faster (O(log n) vs O(n))");
        System.out.println("- Requires initial sorting (O(n log n) one-time cost)");
        System.out.println("- Ideal when search operations outnumber product updates");

        System.out.println("\nFor small catalogs or dynamic data:");
        System.out.println("- Linear search is simpler and doesn't require sorting");
        System.out.println("- Better for frequently updated inventories");

        System.out.println("\nOptimal Strategy:");
        System.out.println("- Use binary search for product ID lookups with cached sorted indices");
        System.out.println("- Combine with hash tables for O(1) lookups when possible");
        System.out.println("- Use linear search for non-indexed attributes (name, category)");
    }
}