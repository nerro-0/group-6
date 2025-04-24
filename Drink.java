public class Drink extends Item{
    private String name;

    public Drink(String name, double price) {
        super (name, 2.50);
    }

    public double getPrice() {
        return 2.50;
    }
}
