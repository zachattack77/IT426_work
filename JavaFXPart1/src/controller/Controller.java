package controller;
import calculator.Calculator;

/**
 * controller class that determines what buttons are pushed
 * @author Zach Kunitsa
 * @version 1.0
 */
public class Controller {

    private Calculator model;
    private String currentNum;

    public Controller(){
        model = new Calculator();
    }

    /**
     * button clicks
     * @param clickedButton
     * @return
     */
    public String newNumber(String clickedButton) {

        if (clickedButton.toLowerCase().equals("Enter")) {
            return model.enterButton();
        } else if (isNumeric(clickedButton)) {
            model.saveNumber(clickedButton);
            return model.displayCurrentNum();
        } else {//if its anything else save as an operator
            model.saveOperator(clickedButton);
            return model.displayCurrentNum();
        }
    }
    /**
     * recieve the number
     * @return
     */
    public String receiveNumber(){

        return model.displayCurrentNum();
    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}