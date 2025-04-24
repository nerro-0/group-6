/**
 * @author James Milligan
 * This class is a work in progress right now for the rest of the code.
 */

import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame mainFrame;
    private static Cost orderCost;

    public Main() {
        orderCost = new Cost();
        JFrame frame = new JFrame("Pizza Restaurant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JButton pButton = new JButton("Pizza");
        JButton sDButton = new JButton("Sides");
        JButton dButton = new JButton("Drinks");
        JButton nOrderButton = new JButton("New Order");
        JButton cOrderButton = new JButton("Finish Order");

        JTextArea receiptArea = new JTextArea(6, 40);
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        pButton.addActionListener(e -> openPizzaWindow());
        sDButton.addActionListener(e -> openSideDishWindow());
        dButton.addActionListener(e -> openDrinksWindow());
        nOrderButton.addActionListener(e -> resetOrder());
        cOrderButton.addActionListener(e -> receiptArea.append("Order Completed!\n"));

        panel.add(pButton);
        panel.add(sDButton);
        panel.add(dButton);
        panel.add(nOrderButton);
        panel.add(cOrderButton);

        JLabel totalLabel = new JLabel("Total: $0.00");
        frame.add(totalLabel);

        cOrderButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Total Order Cost: $" + orderCost.getTotalPrice()));

        frame.add(panel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void openPizzaWindow() {
        JFrame pizzaFrame = new JFrame("Choose your Pizza Toppings");
        pizzaFrame.setSize(400, 300);
        pizzaFrame.setLayout(new GridLayout(9, 2));

        JLabel meatLabel = new JLabel("Meats");
        JLabel veggieLabel = new JLabel("Veggies");

        pizzaFrame.add(meatLabel);
        pizzaFrame.add(veggieLabel);

        Pizza pizza = new Pizza();
        String[] allToppings = {"Pepperoni", "Extra Cheese", "Sausage", "Onion", "Bacon", "Pineapple", "Ham", "Green Peppers", "Meatballs", "Mushrooms", "Beef", "Olives", "Chicken", "Tomatoes"};

        for (String topping : allToppings) {
            JButton button = new JButton(topping);
            button.addActionListener(e -> {
                pizza.addTopping(topping);
                orderCost.addItem(pizza);
            });
            pizzaFrame.add(button);
        }
        JLabel message = new JLabel("One topping per Pizza.");
        pizzaFrame.add(message);

        pizzaFrame.setVisible(true);
    }

    private void openSideDishWindow(){
        JFrame sideFrame = new JFrame("Choose your Sides");
        sideFrame.setSize(300, 200);
        sideFrame.setLayout(new GridLayout(5, 1));

        String [] sideDish = {"Bread Sticks", "10 pc Wings", "Lava Cake", "Mozzarella Sticks", "Salad"};

        /*String qtyStr = JOptionPane.showInputDialog("Enter Quantity:");
        int quantity = Integer.parseInt(qtyStr);*/

        for (String dish : sideDish) {
            JButton button = new JButton(dish);
            button.addActionListener(e -> {
                SideDish sideD = new SideDish(dish, 0.00);
                orderCost.addItem(sideD);
                JOptionPane.showMessageDialog(sideFrame, "Side: " + dish + " - $" + sideD.getPrice());
            });
            sideFrame.add(button);
        }
        sideFrame.setVisible(true);
    }

    private void openDrinksWindow(){
        JFrame drinkFrame = new JFrame("Choose your Drink");
        drinkFrame.setSize(300, 200);
        drinkFrame.setLayout(new GridLayout(8, 1));

        String[] drinks = {"Sprite", "Coca-Cola", "Dr.Pepper", "Diet Coke", "Fanta", "Water", "Fruit Punch", "Mountain Dew"};

        for (String d : drinks){
            JButton button = new JButton(d);
            button.addActionListener(e -> {
                Drink drinkE = new Drink(d, 2.50);
                orderCost.addItem(drinkE);
                JOptionPane.showMessageDialog(drinkFrame, "Drink: " + d + " - $" + drinkE.getPrice() + "\n");
            });
            drinkFrame.add(button);
        }
        drinkFrame.setVisible(true);
    }
    private void resetOrder(){
        orderCost = new Cost();
        JOptionPane.showMessageDialog(mainFrame, "Order reset.");
    }
    public static void main(String[] args){
        new Main();
    }
}