/**
 * @author James Milligan
 * This class is a work in progress right now for the rest of the code.
 */

import javax.swing.*;
import java.awt.*;

public class Main {
    //private Item item;
    //private Cost cost;

    public void order(){

    }
    public void displayMenu(){

    }

    /**
     * The main method that makes the GUI of a cash register. Just a start.
     * @param args the GUI.
     */
    public static void main(String [] args) {
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

        pButton.addActionListener(e -> receiptArea.append("Pizza selected\n"));
        sDButton.addActionListener(e -> receiptArea.append("Side Dish selected\n"));
        dButton.addActionListener(e -> receiptArea.append("Drinks selected\n"));
        nOrderButton.addActionListener(e -> receiptArea.setText(""));
        cOrderButton.addActionListener(e -> receiptArea.append("Order Completed!\n"));

        panel.add(pButton);
        panel.add(sDButton);
        panel.add(dButton);
        panel.add(nOrderButton);
        panel.add(cOrderButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

