import java.util.Arrays;
import java.util.Comparator;
 
public class Product {
    int productId;
    String productName;
    String category;
 
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
 
    public int getProductId() {
        return productId;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public String getCategory() {
        return category;
    }
 
    // Linear search
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }
 
    // Binary search
    public static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return mid;
            } else if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }
 
    public static void main(String[] args) {
        Product[] products = new Product[] {
            new Product(5, "Product E", "Category 1"),
            new Product(2, "Product B", "Category 2"),
            new Product(8, "Product H", "Category 1"),
            new Product(1, "Product A", "Category 3"),
            new Product(9, "Product I", "Category 2")
        };
 
        // For binary search, products array needs to be sorted
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));
 
        int targetId = 8;
 
        // Linear search
        int linearIndex = Product.linearSearch(products, targetId);
        if (linearIndex != -1) {
            System.out.println("Product found at index " + linearIndex + " using linear search");
            System.out.println("Product Name: " + products[linearIndex].getProductName());
            System.out.println("Product Category: " + products[linearIndex].getCategory());
        } else {
            System.out.println("Product not found using linear search");
        }
 
        // Binary search
        int binaryIndex = Product.binarySearch(sortedProducts, targetId);
        if (binaryIndex != -1) {
            System.out.println("Product found at index " + binaryIndex + " using binary search");
            System.out.println("Product Name: " + sortedProducts[binaryIndex].getProductName());
            System.out.println("Product Category: " + sortedProducts[binaryIndex].getCategory());
        } else {
            System.out.println("Product not found using binary search");
        }
    }
}
 