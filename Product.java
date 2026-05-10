import java.util.Scanner;
public class Product {

    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    Product(String name, double price) {
        this.name     = name;
        this.price    = price;
        this.quantity = 1;
    }

    double getTotal() {
        return price * quantity;
    }

    void display() {
        System.out.println(name + " | Qty: " + quantity + " | Price: " + price + " | Subtotal: " + getTotal());
    }

    public static void main(String[] arg) {

        Scanner reader = new Scanner(System.in);

        // ── predefined ──
        Product p1 = new Product("Laptop", 45000, 1);
        Product p2 = new Product("Pen",       10, 22);

        // ── array and count BEFORE the loop ──
        Product[] cart = new Product[10];
        cart[0] = p1;
        cart[1] = p2;
        int count = 2;

        // ── ask how many extra ──
	System.out.println(" 2 products already in cart.");
        System.out.print("How many products to add: ");
        int extra = reader.nextInt();
        reader.nextLine();          // clear buffer

        // ── loop to add extra products ──
        for (int i = 0; i < extra; i++) {
            System.out.print("Enter product name: ");
            String name = reader.nextLine();
            System.out.print("Enter price: ");
            double price = reader.nextDouble();
            System.out.print("Enter quantity: ");
            int qty = reader.nextInt();
            reader.nextLine();      // clear buffer

            if (qty == 1)
                cart[count] = new Product(name, price);
            else
                cart[count] = new Product(name, price, qty);

            count++;
        }

        // ── compute total using count ──
        double total = 0;
        for (int i = 0; i < count; i++)
            total += cart[i].getTotal();

        // ── discount ──
        double discount = 0;
        if (total >= 50000)
            discount = 20;
        else if (total >= 20000)
            discount = 10;
        else if (total >= 5000)
            discount = 5;

        double discountAmt = (discount / 100) * total;
        double finalTotal  = total - discountAmt;
        double tax         = finalTotal * 0.18;
        double grandTotal  = finalTotal + tax;

        // ── invoice ──
        System.out.println("\n=========== INVOICE ==========");
        for (int i = 0; i < count; i++)
            cart[i].display();
        System.out.println("---------------------------------");
        System.out.println("Order Total  : " + total);
        System.out.println("Discount     : " + discount + "%");
        System.out.println("Discount Amt : " + discountAmt);
        System.out.println("GST (18%)    : " + tax);
        System.out.println("=================================");
        System.out.println("GRAND TOTAL  : " + grandTotal);
        System.out.println("=================================");
        System.out.println("    Thank you for shopping!");
        System.out.println("=================================");

        reader.close();
    }
}