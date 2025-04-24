public class SideDish extends Item{
    private String name;

    public SideDish(String name, double price) {
        super(name, price);
        this.name = name;
        //this.quantity = quantity;
    }

    public double getPrice() {
        double pricePerItem;
        switch (name.toLowerCase()) {
            case "bread sticks": pricePerItem = 4.00; break;
            case "10pc wings": pricePerItem = 10.00; break;
            case "lava cake": pricePerItem = 5.00; break;
            case "mozzarella sticks": pricePerItem = 4.00; break;
            case "salad": pricePerItem = 11.00; break;
            default: pricePerItem = 0.00; break;
        }
        return pricePerItem;
    }
}
