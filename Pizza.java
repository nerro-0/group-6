import java.util.ArrayList;
import java.util.List;

public class Pizza extends Item {
    private List<Topping> toppings;
    //private double price;

    public Pizza() {
        super("Pizza", 12.00);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String toppingName) {
        Topping topping1 = new Topping(toppingName);
        toppings.add(topping1);
        price += topping1.getExtraCost();
    }

    public double getPrice() {
        double base = 12.00;
        double toppingTotal = 0.0;

        for (Topping t : toppings) {
            String name = t.getName().toLowerCase();
            // Only charge for certain toppings
            if (!(name.equals("cheese") || name.equals("pepperoni"))) {
                toppingTotal += 0.50;
            }
        }

        return base + toppingTotal;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
}
