public class IngredientStock {
    private String stockId;
    private String stockTimestamp;
    private String stockName;
    private String stockCategory;
    private int stockQuantity;
    private double stockPrice;
    private boolean stockAvailability;

    public IngredientStock(String stockId, String stockTimestamp, String stockName, String stockCategory, int stockQuantity, double stockPrice, boolean stockAvailability) {
        this.stockId = stockId;
        this.stockTimestamp = stockTimestamp;
        this.stockName = stockName;
        this.stockCategory = stockCategory;
        this.stockQuantity = stockQuantity;
        this.stockPrice = stockPrice;
        this.stockAvailability = stockAvailability;
    }

        public String getStockId() {
        return stockId;
    }

    public String getStockTimestamp() {
        return stockTimestamp;
    }

    public String getStockName() {
        return stockName;
    }

    public String getStockCategory() {
        return stockCategory;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public boolean isStockAvailable() {
        return stockAvailability;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public void setStockTimestamp(String stockTimestamp) {
        this.stockTimestamp = stockTimestamp;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setStockCategory(String stockCategory) {
        this.stockCategory = stockCategory;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public void setStockAvailability(boolean stockAvailability) {
        this.stockAvailability = stockAvailability;
    }

    public String toString() {
        return "Stock ID: " + stockId +
                "\nStock Timestamp: " + stockTimestamp +
                "\nStock Name: " + stockName +
                "\nStock Category: " + stockCategory +
                "\nStock Quantity: " + stockQuantity +
                "\nStock Price: RM" + stockPrice + 
                "\nStock Availability: " + (stockAvailability ? "Yes" : "No");
    }
}
