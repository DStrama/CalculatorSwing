import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListObject extends JList {

    public ListObject(final JList<mathFunction> funList,final JTextField formulaInput){

        mathFunction sinusFunction = new mathFunction("Sinus","sin()");
        mathFunction cosinusFunction = new mathFunction("Cosinus","cos()");
        mathFunction tangensFunction = new mathFunction("Tangens","tan()");
        mathFunction logarithmFunction = new mathFunction("Logarithm","log()");
        mathFunction moduloFunction = new mathFunction("Modulo","mod()");
        mathFunction eulerFunction = new mathFunction("Euler","Euler()");
        mathFunction goldenRatioFunction = new mathFunction("Golden ratio","phi");
        mathFunction eFunction = new mathFunction("e","e");
        mathFunction piFunction = new mathFunction("PI","pi");
        mathFunction lastResult = new mathFunction("Last Result", "last result");

        DefaultListModel<mathFunction> listModel = new DefaultListModel<>();

        listModel.addElement(sinusFunction);
        listModel.addElement(cosinusFunction);
        listModel.addElement(tangensFunction);
        listModel.addElement(logarithmFunction);
        listModel.addElement(moduloFunction);
        listModel.addElement(eulerFunction);
        listModel.addElement(goldenRatioFunction);
        listModel.addElement(eFunction);
        listModel.addElement(piFunction);
        listModel.addElement(lastResult);

        funList.setModel(listModel);
        funList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = funList.getSelectedIndex();
                super.mouseClicked(e);
                if(e.getClickCount() == 2){
                    if( index < 5 ){
                        formulaInput.setText(formulaInput.getText()+funList.getModel().getElementAt(index).getComand());
                        formulaInput.requestFocusInWindow();
                        formulaInput.setCaretPosition(formulaInput.getText().length() - 1);


                    }
                    else if( index > 5 && index <= 8){
                        formulaInput.setText(formulaInput.getText()+funList.getModel().getElementAt(index).getComand());
                        formulaInput.requestFocusInWindow();
                        formulaInput.setCaretPosition(formulaInput.getText().length());
                    }
                    else if( index == 9 ){
                        formulaInput.setText(String.valueOf(Frame.LastOperation()));
                    }

                }
            }
        });

    }
}
