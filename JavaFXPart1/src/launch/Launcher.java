package launch;

import javafx.application.Application;
import calculatorui.CalculatorUI;

/**
 * application launcher
 * @author Zach Kunitsa
 * @version 1.0
 */
public class Launcher {

    /**
     * Main method to launch calculator
     * @param args Array
     */
    public static void main(String[] args) {
        Application.launch(CalculatorUI.class, args);
    }
}
