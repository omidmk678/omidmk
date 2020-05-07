import javax.swing.*;

/**
 * Calculator Project
 *
 * @author Omid Mohkamkar
 * @version 7/5/2020
 */

public class Main {
    public static void main(String[] args) {
        CalculatorGUI calculatorGUI = new CalculatorGUI("My Calculator");
        calculatorGUI.setBounds(508,134,350,530);
        calculatorGUI.setResizable(false);
        calculatorGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorGUI.setVisible(true);
    }
}
