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
     * @param newNumber next number pressed
     */
    public void saveNumber(String newNumber){

        int intNumber = Integer.parseInt(newNumber);
        //concatenate the numbers and save to numberPressed
        if(numberPressed != 0 && operator == null){
            numberPressed = Integer.parseInt(numberPressed + newNumber);
        }
        //save to numberPressed
        else if(numberPressed == 0){
            numberPressed = intNumber;
        }

        //do the math and save the result
        else if(!operator.equals("")){

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
     * @param newOperator next operator pressed
     */
    public void saveOperator(String newOperator){
        if(numberPressed != 0) {
            operator = newOperator;
        }
    }

    /**
     *display current number in the textbox
     * @return current number
     */
    public String displayCurrentNum(){
        //return currentNumber + "";
        return numberPressed +"";
    }

    /**
     * enter button
     *
     */
    public void enterButton(){
        //reset the operator
        operator = "";
    }


    @Override
    public String toString() {
        return "Calculator{" +
                "numberPressed=" + numberPressed +
                ", operator='" + operator + '\'' +
                '}';
    }
}