import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {

    JFrame frame;
    private static final int WIDTH = 350;
    private static final int HEIGHT = 530;


    public CalculatorGUI() {
        JTextArea display;
        String regBTNStrings = "789/456*123-%0=+";
        JButton[] regButtons = new JButton[16];
        JButton[] engButtons = new JButton[24];

        frame = new JFrame("My Calculator");
        frame.setBounds(508,134,WIDTH,HEIGHT);
        frame.setResizable(false);

        display = new JTextArea();
        display.setRows(3);
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        JPanel regularKeyboard = new JPanel(new GridLayout(4, 4,5,5));
        for (int i = 0; i < regBTNStrings.length(); i++){
            regButtons[i] = new JButton("" + regBTNStrings.charAt(i));
            regularKeyboard.add(regButtons[i]);
        }

        engButtons[0] = new JButton("sin");
        engButtons[5] = new JButton("tan");
        engButtons[10] = new JButton("log");
        engButtons[15] = new JButton("exp");
        engButtons[20] = new JButton("shift");
        engButtons[21] = new JButton("e");
        engButtons[22] = new JButton("PI");

        engButtons[23] = new JButton(".");

        engButtons[20].addActionListener(ActionListener -> {
            if(engButtons[0].getText().equals("sin")) engButtons[0].setText("cos");
            else engButtons[0].setText("sin");
            if(engButtons[5].getText().equals("tan")) engButtons[5].setText("cot");
            else engButtons[5].setText("tan");
                }
        );
        int index = 0;
        for (int i = 0; i < engButtons.length; i++)
            if(engButtons[i] == null) engButtons[i] = new JButton("" + regBTNStrings.charAt(index++));

        JPanel engineeringKeyboard = new JPanel(new GridLayout(5,5,5,5));
        for (JButton engineeringButton : engButtons) engineeringKeyboard.add(engineeringButton);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Regular",regularKeyboard);
        tabbedPane.add("Engineering",engineeringKeyboard);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

//        JScrollPane scrollPane = new JScrollPane(display);
//        scrollPane.setPreferredSize(new Dimension(200, 100));
//        scrollPane.setLocation(50,20);
//        frame.getContentPane().add(scrollPane);

        frame.add(tabbedPane,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
