public class Topping {
    private String name;
    private double extraCost;

    public Topping(String name) {
        this.name = name;
        this.extraCost = (name.equalsIgnoreCase("Cheese") || name.equalsIgnoreCase("Pepperoni")) ? 0.0 : 0.50;
    }

    public String getName() {
        return name;
    }
    public double getExtraCost(){
        return extraCost;
    }
}
