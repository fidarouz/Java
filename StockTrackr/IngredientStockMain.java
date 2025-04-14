import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IngredientStockMain {
    public static void main(String[] args) {
        File inputFile = new File("p.txt");
        LinkedList stockList = new LinkedList();

        try {
            Scanner inFile = new Scanner(inputFile);
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
                stockList.insertAtBack(stock);
            }
            inFile.close(); // Close the scanner after use
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display all ingredient stocks read from the file
        System.out.println("Ingredient Stocks file: \n");
        Object obj = stockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            System.out.println(stock.toString() + "\n");
            obj = stockList.getNext();
        }

        // Remove stock item with name "Flour"
        String typeToRemove = "Flour";
        stockList.removeNode1(typeToRemove);

        // Display updated ingredient stocks after removal
        System.out.println("Updated Ingredient Stocks file after removing '" + typeToRemove + "': \n");
        obj = stockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            System.out.println(stock.toString() + "\n");
            obj = stockList.getNext();
        }

        // Search for a stock item by name
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the stock name to search: ");
        String searchName = scanner.nextLine().trim();

        obj = stockList.getFirst();
        boolean found = false;
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            if (stock.getStockName().equalsIgnoreCase(searchName)) {
                System.out.println("\nStock found:");
                System.out.println(stock.toString() + "\n");
                found = true;
                break;
            }
            obj = stockList.getNext();
        }
        if (!found) {
            System.out.println("\nStock not found with name: " + searchName);
        }

        scanner = new Scanner(System.in);
        System.out.print("\nEnter the stock name to update availability: ");
        String updateName = scanner.nextLine().trim();

        obj = stockList.getFirst();
        boolean updated = false;
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            if (stock.getStockName().equalsIgnoreCase(updateName)) {
                if (!stock.isStockAvailable()) {
                    stock.setStockAvailability(true);
                    System.out.println("\nAvailability status updated for stock item: " + stock.getStockName());
                    updated = true;
                } else {
                    System.out.println("\nStock item '" + stock.getStockName() + "' is already In Stock.");
                }
                break;
            }
            obj = stockList.getNext();
        }

        if (!updated) {
            System.out.println("\nStock not found with name: " + updateName);
        }

        // Display all ingredient stocks after potential update
        System.out.println("\nUpdated Ingredient Stocks file: \n");
        obj = stockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            System.out.println(stock.toString() + "\n");
            obj = stockList.getNext();
        }

        LinkedList inStockList = new LinkedList();
        LinkedList outOfStockList = new LinkedList();
        obj = stockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            if (stock.isStockAvailable()) {
                inStockList.insertAtBack(stock);
            } else {
                outOfStockList.insertAtBack(stock);
            }
            obj = stockList.getNext(); 
        }

        System.out.println("In Stock Ingredient Stocks: \n");
        obj = inStockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            System.out.println(stock.toString() + "\n");
            obj = inStockList.getNext();
        }

        System.out.println("Out of Stock Ingredient Stocks: \n");
        obj = outOfStockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            System.out.println(stock.toString() + "\n");
            obj = outOfStockList.getNext();
        }
        double totalPrice = 0.0;
        
        System.out.print("\nEnter the stock name to know total price: ");
        String stockName = scanner.nextLine().trim();
        obj = stockList.getFirst();
        while (obj != null) {
            IngredientStock stock = (IngredientStock) obj;
            if (stock.getStockName().equalsIgnoreCase(stockName)) {
                totalPrice = stock.getStockQuantity() * stock.getStockPrice();
                System.out.println("\nTotal price for " + stockName + ": " + totalPrice);
                break;
            }
            obj = stockList.getNext();
        }
    }
}
