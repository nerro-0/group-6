public class Cost {
    private double totalPrice;

    public Cost() {
        totalPrice = 0.0;
    }

    public void addItem(Item item) {
        totalPrice += item.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

