import javax.swing.*;

public class Calculator {

    private static Frame calculator;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator = new Frame();
                new ListObject(calculator.getFunctionsList(),calculator.getFormulaInput());
                calculator.getFormulaInput().requestFocusInWindow();
            }
        });
    }
}

