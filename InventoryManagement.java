import java.text.DecimalFormat;

public class InventoryManagement {
    // set variables name, count, price, total and tax
    String name;
    int count;
    double price;
    double total;
    double tax = 0.05;

    // InventoryManagement constructor
    public InventoryManagement(String name, int count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    // print method prints inventory levels
    public void print() {
        System.out.println(this.count + " " + this.name + "(s) in stock for a price of $" + this.price + " each");
    }

    public void buy(int purchaseQuantity) {
        double subTotal = purchaseQuantity * this.price;
        double taxAmount = subTotal * tax;
        this.total = subTotal + taxAmount;
        this.count -= purchaseQuantity;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedSubTotal = decimalFormat.format(subTotal);
        String formattedTaxTotal = decimalFormat.format(taxAmount);
        String formattedTotal = decimalFormat.format(this.total);
        System.out.println(purchaseQuantity + " " + this.name + "(s) purchased, subtotal: $" + formattedSubTotal + " tax: $" + formattedTaxTotal + " " + "Total: $" + formattedTotal);
    }

    // updatePrice allows user to update price
    public void updatePrice(double updatedPrice) {
        this.price = updatedPrice;
    }

    // updateQuantity updates count
    public void updateQuantity(int updatedQuantity) {
        this.count = updatedQuantity;
    }

    public static void main(String[] args) {
        // Set new instances of InventoryManagement to small and medium shirts
        InventoryManagement smallShirt = new InventoryManagement("Small Shirt", 10, 9.99);
        InventoryManagement mediumShirt = new InventoryManagement("Medium Shirt", 15, 10.99);
        smallShirt.buy(5);
        smallShirt.updatePrice(4.99);
        smallShirt.updateQuantity(50);
        smallShirt.print();
        mediumShirt.buy(10);
        mediumShirt.print();
    }
}
