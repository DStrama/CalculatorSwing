import org.mariuszgromada.math.mxparser.Expression;

import javax.lang.model.util.Elements;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.server.ExportException;
import java.text.MessageFormat;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    private JPanel mainPanel;
    private JScrollPane scrollContainerPane;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JList functionsList;
    private JButton evalButton;
    private String lastone;
    private javax.swing.JPanel JPanel;

    Frame(){
        this.Elements();

        historyTextArea.setEditable(false);

        evalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = formulaInput.getText();
                addText(formulaInput.getText());
                lastone = formulaInput.getText();
                formulaInput.setText("");
            }
        });

        formulaInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() ==  KeyEvent.VK_UP){
                    formulaInput.setText(lastone);
                }
                else if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    addText(formulaInput.getText());
                    lastone = formulaInput.getText();
                    formulaInput.setText("");
                }



            }
        });


    }
    public static double last=0;

    public static double LastOperation(){
        return last;
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JScrollPane getScrollContainerPane() {
        return scrollContainerPane;
    }

    public JList getFunctionsList() {
        return functionsList;
    }

    public JButton getEvalButton() {
        return evalButton;
    }


    public void addText(String expression) {

        Expression e = new Expression(expression);
        if (e.checkSyntax()) {
            last = e.calculate();
            historyTextArea.setText(historyTextArea.getText() +
                    MessageFormat.format("{0}={1,number}\n", expression, last));
        } else {
            JOptionPane.showMessageDialog(null, e.getErrorMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Elements() {

        JMenuBar menubar = new JMenuBar();

        JMenu options = new JMenu("options");
        JMenuItem exit = new JMenuItem("exit");
        JMenuItem reset = new JMenuItem("reset");

        options.add(reset);
        options.add(exit);
        menubar.add(options);

        final JFrame myFrame = new JFrame();
        myFrame.setTitle("My GUI Calculator");
        myFrame.setContentPane(mainPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 500);
        myFrame.setJMenuBar(menubar);
        myFrame.setVisible(true);


        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHistoryTextArea().setText("");
                getFormulaInput().setText("");
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }


    public JTextArea getHistoryTextArea() {
        return historyTextArea;
    }

    public JTextField getFormulaInput() {
        return formulaInput;
    }



}
