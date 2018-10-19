package controller;
import calculator.Calculator;

/**
 * controller class that determines what buttons are pushed
 * @author Zach Kunitsa
 * @version 1.0
 */
public class Controller {

    private Calculator model;


    /**
     *
     */
    public Controller(){
        model = new Calculator();
    }

    /**
     * button clicked
     * @param clickedButton button clicked
     */
    public void newNumber(String clickedButton) {

        if (isNumeric(clickedButton)) {
            model.saveNumber(clickedButton);
            model.displayCurrentNum();
        } else if (clickedButton.toLowerCase().equals("Enter")) {
            model.enterButton();
        } else {//if its anything else save as an operator
            model.saveOperator(clickedButton);
            model.displayCurrentNum();
        }
    }
    /**
     * receive the number
     * @return current button
     */
    public String receiveNumber(){

        return model.displayCurrentNum();
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }


    @Override
    public String toString() {
        return "Controller{" +
                "model=" + model +
                '}';
    }
}