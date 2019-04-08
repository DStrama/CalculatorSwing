import javax.swing.*;

public class mathFunction {

    String name;
    String comand;

    public mathFunction(String name, String comand) {
        this.name = name;
        this.comand = comand;
    }

    @Override
    public String toString() {
        return name;
    }
    public String getComand(){
        return comand;
    }

}