import model.Product;

public class Invoice {
    private Product product;
    private int quantity;

    public Invoice(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public float calculateTotal() {
        return (this.product.price * this.quantity);
    }

    public void printInvoice() {
        // print invoice
    }

    public void saveToDB() {
        // save to database
    }
}
