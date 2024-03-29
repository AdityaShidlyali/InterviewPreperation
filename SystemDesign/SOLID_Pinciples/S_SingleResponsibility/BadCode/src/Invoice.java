import model.Product;

/**
 * This class has 2 responsibility to handle. So it doesn't have the single reason to change
 */
public class Invoice {

    // It shows Invoice "Has-A" Product dependency or object
    private final Product product;
    private final int quantity;

    public Invoice(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Responsibility 1
     * <p>
     * Let say if the shop owner wants to add discount and tax changes then this needs to be changed entirely
     * </p>
     */
    public float calculateTotal() {
        return (this.product.price * this.quantity);
    }

    /**
     * Responsibility 2
     * <p>
     * If in future if this class needs to save the invoice to DB as well as file then this responsibility needs to be changed
     * </p>
     */
    public void saveToDB() {
        // save to database
    }
}
