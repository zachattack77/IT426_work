package calculator;

/**
 * Calculator application that can add, subtract, divide and multiply
 *
 * @author Zach Kunitsa
 * @version 1.0
 */
public class Calculator {

    private int numberPressed; //number to return
    private String operator; //current operator

    /**
     * check if a number has been pressed and saved
     * @param newNumber
     */
    public void saveNumber(String newNumber){

        int intNumber = Integer.parseInt(newNumber);
        //concatinate the numbers and save to numberPressed
        if(numberPressed != 0 && operator == null){
            numberPressed = Integer.parseInt(numberPressed + newNumber);
        }
        //save to numberPressed
        else if(numberPressed == 0){
            numberPressed = intNumber;
        }

        //do the math and save the result
        else if(numberPressed != 0 && (!operator.equals(""))){

            switch (operator){
                case "+":
                    numberPressed = numberPressed + intNumber;
                    break;
                case "-":
                    numberPressed = numberPressed - intNumber;
                    break;
                case "*":
                    numberPressed = numberPressed * intNumber;
                    break;
                case "/":
                    numberPressed = numberPressed / intNumber;
                    break;

            }
            operator = "";

        }
    }

    /**
     * save pressed operator
     * @param newOperator
     */
    public void saveOperator(String newOperator){
        if(numberPressed != 0) {
            operator = newOperator;
        }
    }

    /**
     *display current number in the textbox
     * @return
     */
    public String displayCurrentNum(){
        //return currentNumber + "";
        return numberPressed +"";
    }

    /**
     * enter button
     * @return
     */
    public String enterButton(){
        //reset the operator
        operator = "";
        return numberPressed + "";
    }


}