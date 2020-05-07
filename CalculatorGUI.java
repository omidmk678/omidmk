import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

/**
 * This is the frame of calculator.
 * This calculator represents in two model of
 * regular and engineering.
 */

public class CalculatorGUI extends JFrame{

    enum Operator{
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        REMAINING
    }
    enum MathKey{
        SIN,
        COS,
        TAN,
        COT,
        LOG,
        EXP,
        E,
        PI
    }
    enum State{
        INPUT_FIRST_NUM,
        INPUT_FIRST_NUM_FINISHED,
        INPUT_SECOND_NUM,
        INPUT_SECOND_NUM_FINISHED
    }

    private State state;
    private String firstNumber;
    private Operator operator;
    private String secondNumber;
    private JTextArea display;
    private JButton[] regButtons;
    private JButton[] engButtons;

    /**
     * Constructor for Calculator
     * @param title title of frame
     */
    public CalculatorGUI(String title) {
        super(title);

        state = State.INPUT_FIRST_NUM;
        firstNumber = "";
        operator = null;
        secondNumber = "";

        createDesign();
        setActionListeners();
        setKeyListeners();

        setFocusable(true);
        for (JButton button : engButtons)
            button.setFocusable(false);
        display.setFocusable(false);
        for(JButton button : regButtons)
            button.setFocusable(false);
    }

    /**
     * Creating design of calculator like buttons and
     * text field.
     */
    private void createDesign() {
        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Copy", 'c');
        JMenu applicationMenu = new JMenu("Application");
        JMenuItem exitItem = new JMenuItem("Exit",'x');
        setJMenuBar(menuBar);
        menuBar.add(editMenu);
        menuBar.add(applicationMenu);
        editMenu.add(copyItem);
        applicationMenu.add(exitItem);

        exitItem.addActionListener(e->System.exit(0));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        copyItem.addActionListener(e -> copyString(display.getText()));
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

        String buttonsString = "7894561230";
        regButtons = new JButton[18];
        engButtons = new JButton[25];

        display = new JTextArea("0",3,10);
        display.setEditable(false);
        add(new JScrollPane(display), BorderLayout.NORTH);

        regButtons[3] = new OperatorButton("/", Operator.DIVISION);
        regButtons[7] = new OperatorButton("*", Operator.MULTIPLICATION);
        regButtons[11] = new OperatorButton("-", Operator.SUBTRACTION);
        regButtons[12] = new OperatorButton("%", Operator.REMAINING);
        regButtons[14] = new JButton("=");
        regButtons[15] = new OperatorButton("+", Operator.ADDITION);
        regButtons[16] = new JButton("⬅");
        regButtons[16].setToolTipText("Backspace");
        regButtons[17] = new JButton("C");
        regButtons[17].setToolTipText("Clear Screen");

        JPanel regularKeyboard = new JPanel(new GridLayout(5, 4,5,5));
        int index = 0;
        for (int i = 0; i < regButtons.length; i++){
            if(regButtons[i] == null) regButtons[i] = new CharButton("" + buttonsString.charAt(index++));
            regularKeyboard.add(regButtons[i]);
        }

        engButtons[4] = new OperatorButton("/", Operator.DIVISION);
        engButtons[9] = new OperatorButton("*", Operator.MULTIPLICATION);
        engButtons[14] = new OperatorButton("-", Operator.SUBTRACTION);
        engButtons[16] = new OperatorButton("%", Operator.REMAINING);
        engButtons[18] = new JButton("=");
        engButtons[19] = new OperatorButton("+", Operator.ADDITION);

        engButtons[0] = new MathButton("sin", MathKey.SIN);
        engButtons[5] = new MathButton("tan", MathKey.TAN);
        engButtons[10] = new MathButton("log", MathKey.LOG);
        engButtons[15] = new MathButton("exp", MathKey.EXP);
        engButtons[20] = new JButton("shift");
        engButtons[21] = new MathButton("e",MathKey.E);
        engButtons[22] = new MathButton("PI",MathKey.PI);
        engButtons[23] = new JButton("C");
        engButtons[23].setToolTipText("Clear Screen");
        engButtons[24] = new JButton("⬅");
        engButtons[24].setToolTipText("Backspace");


        JPanel engineeringKeyboard = new JPanel(new GridLayout(5,5,5,5));
        index = 0;
        for (int i = 0; i < engButtons.length; i++){
            if(engButtons[i] == null) engButtons[i] = new CharButton("" + buttonsString.charAt(index++));
            engineeringKeyboard.add(engButtons[i]);
        }

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Regular",regularKeyboard);
        tabbedPane.add("Engineering",engineeringKeyboard);
        add(tabbedPane,BorderLayout.CENTER);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Set action listeners for buttons
     */
    private void setActionListeners() {
        //equal buttons action listeners
        regButtons[14].addActionListener(this::equalsProcess);
        engButtons[18].addActionListener(this::equalsProcess);

        //backspace buttons action listeners
        regButtons[16].addActionListener(this::backspaceProcess);
        engButtons[24].addActionListener(this::backspaceProcess);

        //clear screen buttons action listeners
        regButtons[17].addActionListener(this::clearButtonProcess);
        engButtons[23].addActionListener(this::clearButtonProcess);

        //shift button action listener
        engButtons[20].addActionListener(ActionListener -> {
            if(engButtons[0].getText().equals("sin")) {
                ((MathButton)engButtons[0]).setButtonMathKey(MathKey.COS);
                engButtons[0].setText("cos");
            }
            else{
                ((MathButton)engButtons[0]).setButtonMathKey(MathKey.SIN);
                engButtons[0].setText("sin");
            }
            if(engButtons[5].getText().equals("tan")){
                ((MathButton)engButtons[5]).setButtonMathKey(MathKey.COT);
                engButtons[5].setText("cot");
            }
            else{
                ((MathButton)engButtons[5]).setButtonMathKey(MathKey.TAN);
                engButtons[5].setText("tan");
            }
        });

    }

    /**
     * Set key listeners
     */
    private void setKeyListeners() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyTypedChar = e.getKeyChar();
                if(Character.isDigit(keyTypedChar)) ((CharButton)regButtons[0]).charButtonProcess("" + keyTypedChar);
                switch (keyTypedChar){
                    case '+':
                        ((OperatorButton)regButtons[15]).operatorButtonProcess();
                        break;
                    case '-':
                        ((OperatorButton)regButtons[11]).operatorButtonProcess();
                        break;
                     case '*':
                         ((OperatorButton)regButtons[9]).operatorButtonProcess();
                        break;
                     case '/':
                         ((OperatorButton)regButtons[4]).operatorButtonProcess();
                        break;
                     case '%':
                         ((OperatorButton)regButtons[16]).operatorButtonProcess();
                        break;
                    case '=':
                        equalsFunction();
                        break;
                }
                if(KeyEvent.VK_BACK_SPACE == e.getKeyChar()) backspaceFunction();
            }
        });
    }

    /**
     * method for action performed of backSpace button
     * @param event event of action event
     */
    private void backspaceProcess(ActionEvent event){
        backspaceFunction();
    }

    /**
     * function of backspace process.
     */
    private void backspaceFunction() {
        if(state.equals(State.INPUT_FIRST_NUM) && !firstNumber.equals("") && !firstNumber.equals("0")){
            firstNumber = firstNumber.substring(0,firstNumber.length()-1);
            if(firstNumber.length() == 0) firstNumber = "0";
            System.out.println("First number changed to : " + firstNumber);
            display.setText(firstNumber);
        }
        if(state.equals(State.INPUT_SECOND_NUM) && !secondNumber.equals("") && !secondNumber.equals("0")){
            secondNumber = secondNumber.substring(0,firstNumber.length()-1);
            if(secondNumber.length() == 0) secondNumber = "0";
            System.out.println("Second number changed to : " + secondNumber);
            display.setText(secondNumber);
        }
    }

    /**
     * method for action performed of clear button
     * @param event event of action event
     */
    private void clearButtonProcess(ActionEvent event) {
        state = State.INPUT_FIRST_NUM;
        firstNumber = "";
        secondNumber = "";
        operator = null;
        display.setText("0");
        System.out.println("Screen cleared.");
    }

    /**
     * method for action performed of equals button
     * @param event event of action event
     */
    private void equalsProcess(ActionEvent event){
        equalsFunction();
    }

    /**
     * function of equals process.
     */
    private void equalsFunction() {
        double result = Double.parseDouble(firstNumber);
        if(state.equals(State.INPUT_SECOND_NUM) && !secondNumber.equals("")){
            switch (operator) {
                case ADDITION:
                    result += Double.parseDouble(secondNumber);
                    break;
                case SUBTRACTION:
                    result -= Double.parseDouble(secondNumber);
                    break;
                case MULTIPLICATION:
                    result *= Double.parseDouble(secondNumber);
                    break;
                case DIVISION:
                    result /= Double.parseDouble(secondNumber);
                    break;
                case REMAINING:
                    result %= Double.parseDouble(secondNumber);
                    break;
            }
        }
        display.setText(Double.toString(result));
        state = State.INPUT_SECOND_NUM_FINISHED;
        System.out.println(operator.toString() + " of " + firstNumber  + " and "  + secondNumber + " equals : " + result);
        firstNumber = display.getText();
        secondNumber = "";
        operator = null;
    }

    /**
     * A method for copy string.
     * @param stringToCopy string that must be copied.
     */
    private void copyString(String stringToCopy) {
        StringSelection stringSelection = new StringSelection(stringToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
        System.out.println(stringToCopy + " successfully copied to clipboard.");
    }

    /**
     * A extended button for char button which includes
     * numbers.
     */
    private class CharButton extends JButton {
        private CharButton(String text) {
            super(text);
            setToolTipText(text);
            addActionListener(e -> charButtonProcess(text));
        }
        private void charButtonProcess(String value) {
            if(state.equals(State.INPUT_FIRST_NUM)){
                if(firstNumber.equals("0") || firstNumber.equals("")) firstNumber = value;
                else firstNumber += value;
                System.out.println("First number changed to : " + firstNumber);
                display.setText(firstNumber);
                return;
            }
            if(state.equals(State.INPUT_SECOND_NUM) || state.equals(State.INPUT_FIRST_NUM_FINISHED)) {
                if(secondNumber.equals("0") || secondNumber.equals("")) secondNumber = value;
                else secondNumber += value;
                System.out.println("Second number changed to : " + secondNumber);
                display.setText(secondNumber);
                state = State.INPUT_SECOND_NUM;
                return;
            }
            if(state.equals(State.INPUT_SECOND_NUM_FINISHED)) {
                state = State.INPUT_FIRST_NUM;
                firstNumber = "";
                charButtonProcess(value);
            }
        }
    }

    /**
     * A extended button for operator buttons which
     * includes +,-,*,/ and %.
     */
    private class OperatorButton extends JButton {
        Operator buttonOperator;
        private OperatorButton(String text, Operator operator) {
            super(text);
            setToolTipText(operator.toString());
            this.buttonOperator = operator;
            addActionListener(ActionEvent -> operatorButtonProcess());
        }
        private void operatorButtonProcess() {
            if(!state.equals(State.INPUT_SECOND_NUM) && !firstNumber.equals("")){
                operator = buttonOperator;
                System.out.println("Operator changed to " + operator + ".");
                state = State.INPUT_FIRST_NUM_FINISHED;
            }
        }
    }

    /**
     * A extended button for MathKey buttons like
     * Sin and Cos.
     */
    private class MathButton extends JButton {
        MathKey mathKey;
        private MathButton(String text, MathKey mathKey) {
            super(text);
            setToolTipText(mathKey.toString());
            this.mathKey = mathKey;
            addActionListener(ActionEvent -> mathButtonProcess());
        }
        private void mathButtonProcess() {
            if(!display.getText().equals("")){
                switch (mathKey){
                    case SIN:
                        firstNumber = "" + Math.sin(Double.parseDouble(display.getText()));
                        break;
                    case COS:
                        firstNumber = "" + Math.cos(Double.parseDouble(display.getText()));
                        break;
                    case TAN:
                        firstNumber = "" + Math.tan(Double.parseDouble(display.getText()));
                        break;
                    case COT:
                        firstNumber = "" + 1/Math.tan(Double.parseDouble(display.getText()));
                        break;
                    case LOG:
                        firstNumber = "" + Math.log10(Double.parseDouble(display.getText()));
                        break;
                    case EXP:
                        firstNumber = "" + Math.exp(Double.parseDouble(display.getText()));
                        break;
                    case E:
                        firstNumber = "" + Math.E;
                        break;
                    case PI:
                        firstNumber = "" + Math.PI;
                        break;
                }
                secondNumber = "";
                operator = null;
                state = State.INPUT_FIRST_NUM_FINISHED;
                display.setText(firstNumber);
                System.out.println(mathKey + " used.");
            }
        }
        private void setButtonMathKey(MathKey mathKeyToSet) {
            mathKey = mathKeyToSet;
            setToolTipText(mathKey.toString());
        }
    }
}