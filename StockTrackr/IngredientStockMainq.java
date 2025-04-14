import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IngredientStockMainq {

    public static void main(String[] args) {
        File inputFile = new File("p.txt");
        Queue stockQueue = new Queue();

        try (Scanner inFile = new Scanner(inputFile)) {
            while (inFile.hasNextLine()) {
                String s = inFile.nextLine().trim(); // Read and trim the line to remove extra spaces

                StringTokenizer st = new StringTokenizer(s, ";");

                String stockId = st.nextToken().trim();
                String stockTimestamp = st.nextToken().trim();
                String stockName = st.nextToken().trim();
                String stockCategory = st.nextToken().trim();
                int stockQuantity = Integer.parseInt(st.nextToken().trim());
                double stockPrice = Double.parseDouble(st.nextToken().trim());
                boolean stockAvailability = st.nextToken().trim().equalsIgnoreCase("Yes");
                IngredientStock stock = new IngredientStock(stockId, stockTimestamp, stockName, stockCategory, stockQuantity, stockPrice, stockAvailability);
                stockQueue.enqueue(stock);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display all ingredient stocks read from the file
        System.out.println("Ingredient Stocks file: \n");
        Queue tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            System.out.println(stock.toString() + "\n");
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }

        // Remove stock item with name "Flour"
        String typeToRemove = "Flour";
        Queue newQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            if (!stock.getStockName().equalsIgnoreCase(typeToRemove)) {
                newQueue.enqueue(stock);
            }
        }
        stockQueue = newQueue;

        // Display updated ingredient stocks after removal
        System.out.println("Updated Ingredient Stocks file after removing '" + typeToRemove + "': \n");
        tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            System.out.println(stock.toString() + "\n");
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }

        // Search for a stock item by name
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the stock name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;
        tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            if (stock.getStockName().equalsIgnoreCase(searchName) && !found) {
                System.out.println("\nStock found:");
                System.out.println(stock.toString() + "\n");
                found = true;
            }
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }
        if (!found) {
            System.out.println("\nStock not found with name: " + searchName);
        }

        // Update availability status of a stock item
        System.out.print("\nEnter the stock name to update availability: ");
        String updateName = scanner.nextLine().trim();

        boolean updated = false;
        tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            if (stock.getStockName().equalsIgnoreCase(updateName) && !updated) {
                if (!stock.isStockAvailable()) {
                    stock.setStockAvailability(true);
                    System.out.println("\nAvailability status updated for stock item: " + stock.getStockName());
                    updated = true;
                } else {
                    System.out.println("\nStock item '" + stock.getStockName() + "' is already In Stock.");
                }
            }
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }
        if (!updated) {
            System.out.println("\nStock not found with name: " + updateName);
        }

        // Display all ingredient stocks after potential update
        System.out.println("\nUpdated Ingredient Stocks file: \n");
        tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            System.out.println(stock.toString() + "\n");
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }

        // Separate in-stock and out-of-stock lists
        Queue inStockQueue = new Queue();
        Queue outOfStockQueue = new Queue();
        tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            if (stock.isStockAvailable()) {
                inStockQueue.enqueue(stock);
            } else {
                outOfStockQueue.enqueue(stock);
            }
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }

        // Display in-stock ingredient stocks
        System.out.println("In Stock Ingredient Stocks: \n");
        tempQueue = new Queue();
        while (!inStockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) inStockQueue.dequeue();
            System.out.println(stock.toString() + "\n");
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            inStockQueue.enqueue(tempQueue.dequeue());
        }

        // Display out-of-stock ingredient stocks
        System.out.println("Out of Stock Ingredient Stocks: \n");
        tempQueue = new Queue();
        while (!outOfStockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) outOfStockQueue.dequeue();
            System.out.println(stock.toString() + "\n");
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            outOfStockQueue.enqueue(tempQueue.dequeue());
        }

        // Calculate total price of a specific stock item
        System.out.print("\nEnter the stock name to know total price: ");
        String totalPriceName = scanner.nextLine().trim();

        boolean foundTotalPrice = false;
        tempQueue = new Queue();
        while (!stockQueue.isEmpty()) {
            IngredientStock stock = (IngredientStock) stockQueue.dequeue();
            if (stock.getStockName().equalsIgnoreCase(totalPriceName) && !foundTotalPrice) {
                double totalPrice = stock.getStockQuantity() * stock.getStockPrice();
                System.out.println("\nTotal price for " + totalPriceName + ": " + totalPrice);
                foundTotalPrice = true;
            }
            tempQueue.enqueue(stock);
        }
        while (!tempQueue.isEmpty()) {
            stockQueue.enqueue(tempQueue.dequeue());
        }
        if (!foundTotalPrice) {
            System.out.println("\nStock not found with name: " + totalPriceName);
        }

        scanner.close();
    }
}
