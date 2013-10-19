package com.practicaljava.lesson5;
import java.awt.Color;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class CalculatorEngine implements ActionListener {
 
 private CalculatorView parent; // a reference to the Calculator
 
						// Когда этот флаг true на экран выводим "0,"
 
 enum States{
	 DontEnterTheFirstNumber,
	 IsEnteredTheFirstNumber,
	 TheFirstNumberWasTheFractional,
	 
	 DontEnterTheSecondNumber,
	 IsEnteredTheSecondNumber,
	 TheSecondNumberWasTheFractional,
	 
	 OutputTheAnswer
 }
 private States calculatorView_S;
 private States prev_calculatorView_S;		// Преведущее значение нужно для 
 											// организации машины состояний
 
 
 private double				firstValue;
 private double				secondValue;
 private double				result;
 
 private double				memory;
 
 private int				counterDigitsInRow;
 private static final int	MAXIMUM_DIGITS_IN_ROW = 36;
 
 enum Operation{
	 None,
	 Divide,
	 Multiply,
	 Diff,
	 Sum,
	 Persent
 }

 private Operation	 	operationType;	
	
 // Constructor stores the reference to the 
 // Calculator window in  the member variable parent
 CalculatorEngine(CalculatorView parent){
   this.parent 			   = parent;
   
   calculatorView_S  	   = States.DontEnterTheFirstNumber;
   operationType		   = Operation.None;
   firstValue			   = 0;
   result				   = 0;	
   counterDigitsInRow	   = 0;
   
 }
 
 private boolean hasFractionalPart(double val){
	return val - Math.floor(val) > 0 ;
 }
 
 private String convertResult (double val){
   if(Double.isInfinite(val))
	   return Double.toString(val);
   
   if(Double.isNaN(val))
	   return Double.toString(val); 
	
   if(val == Double.MAX_VALUE)
	   return "Too MAX value";
   
   if(val == Double.MIN_VALUE)
	   return "Too MIN value";
   if(val < Long.MAX_VALUE && val > Long.MIN_VALUE){
	   if(hasFractionalPart(val)== false)
		   return Long.toString((long)val);
   }
	   
   return Double.toString(val);
 }

 public void actionPerformed(ActionEvent e){
   // Get the source of this action
   JButton clickedButton =  (JButton) e.getSource();
   	
   // Get the existing text from the Calculator�s
   // display field. Reaching inside another object is bad.
   String dispFieldText = parent.getDisplayValue();

   // Get the button's label 
   String clickedButtonLabel = clickedButton.getText().trim();
   
   switch(clickedButtonLabel){
   case("+/-"):
	   int index = dispFieldText.lastIndexOf('-');
	   if( index == -1){
		   parent.setDisplayValue("-" + dispFieldText); 
	   }else{
		   parent.setDisplayValue(dispFieldText.substring(index+1));
	   }   
	   break;
   
   case "0":
   case "1":
   case "2":
   case "3":
   case "4":
   case "5":
   case "6":
   case "7":	   
   case "8":
   case "9":  
	   switch(calculatorView_S){  
	   	case DontEnterTheFirstNumber:
	   	case OutputTheAnswer:	
	   		parent.setDisplayValue(clickedButtonLabel);
	   		calculatorView_S = States.IsEnteredTheFirstNumber;
	   		break;
	   		
	   	case DontEnterTheSecondNumber:	
	   		parent.setDisplayValue(clickedButtonLabel);
	   		calculatorView_S = States.IsEnteredTheSecondNumber;
	   		break;
		   
	   	case IsEnteredTheSecondNumber:
	   	case IsEnteredTheFirstNumber:
	   	case TheFirstNumberWasTheFractional:
	   	case TheSecondNumberWasTheFractional:	
	   		// Вот такая проверка на то, что значение в поле
	 	    //  не превышает Double.MAX_VALUE
	   		if(counterDigitsInRow < MAXIMUM_DIGITS_IN_ROW){
		  		counterDigitsInRow++;
	  			parent.setDisplayValue(dispFieldText + clickedButtonLabel);
	  		}
	   		break;
	   }
	   break;
	   
   case ".": 
	   switch(calculatorView_S){  
	   	case DontEnterTheFirstNumber:
	   		calculatorView_S = States.TheFirstNumberWasTheFractional;
	   		break;
	   		
	  	case DontEnterTheSecondNumber:
	  		calculatorView_S = States.TheSecondNumberWasTheFractional;
	  		break;
		   
	  	case IsEnteredTheFirstNumber:	
	  		calculatorView_S = States.TheFirstNumberWasTheFractional;
	  		if(counterDigitsInRow < MAXIMUM_DIGITS_IN_ROW){
		  		counterDigitsInRow++;
	  			parent.setDisplayValue(dispFieldText + clickedButtonLabel);
	  		}
	  		break;
	  		
	  	case IsEnteredTheSecondNumber:
	  		calculatorView_S = States.TheSecondNumberWasTheFractional;
	  		if(counterDigitsInRow < MAXIMUM_DIGITS_IN_ROW){
	  			counterDigitsInRow++;
	  			parent.setDisplayValue(dispFieldText + clickedButtonLabel);
	  		}
	  		break;
	   }
  	   break;

   case "C":
	   parent.setDisplayValue("0.");
	   calculatorView_S = States.DontEnterTheFirstNumber;
	   break;
	   
   case "+":
	   firstValue 	 	= Double.parseDouble(dispFieldText);
	   operationType 	= Operation.Sum;
	   calculatorView_S = States.DontEnterTheSecondNumber;  
   	   break;
   	   
   case "-":
   	   firstValue 	 	= Double.parseDouble(dispFieldText);
   	   operationType 	= Operation.Diff;
   	   calculatorView_S = States.DontEnterTheSecondNumber;

   	   break;	   
	   
   case "/":
   	   firstValue 	 	= Double.parseDouble(dispFieldText);
   	   operationType 	= Operation.Divide;
   	   calculatorView_S = States.DontEnterTheSecondNumber;
   	   break;
   	   
   case "*":
   	   firstValue 	 	= Double.parseDouble(dispFieldText);
   	   operationType 	= Operation.Multiply;
   	   calculatorView_S = States.DontEnterTheSecondNumber;
   	   break;
   	   
   case "%":
	   firstValue 	 	= Double.parseDouble(dispFieldText);
   	   operationType 	= Operation.Persent;
   	   calculatorView_S = States.DontEnterTheSecondNumber;
   	   break;
   	   
   case "sqrt":
	   firstValue 	 	= Double.parseDouble(dispFieldText);
	   result			= Math.sqrt(firstValue);
	   parent.setDisplayValue(convertResult(result));
		  
	   firstValue 		= result;
	   calculatorView_S = States.OutputTheAnswer;
	   break;	
	   
   case "1/x":
	   firstValue 	 	= Double.parseDouble(dispFieldText);
	   if(firstValue == 0){
		   result = Double.parseDouble("Infinity");
	   }else{
		   result			= 1/firstValue;
	   }
	   
	   parent.setDisplayValue(convertResult(result));
		  
	   firstValue 		= result;
	   calculatorView_S = States.OutputTheAnswer;
	   break;
   	   
   case "=":
	   secondValue = Double.parseDouble(dispFieldText);	   
	   switch(operationType){
	   	case Sum:
	   		result = firstValue + secondValue;
	   		break;
	   		
	   	case Diff:
	   		result = firstValue - secondValue;
	   		break;
	   		
	   	case Multiply:
	   		result = firstValue * secondValue;
	   		break;
	   		
	   	case Divide:
	   		result = firstValue / secondValue;
	   		break;	
	   		
	   	case Persent:
	   		result = (firstValue/100) * secondValue;
	   		break;
	   }
	   parent.setDisplayValue(convertResult(result));
	  
	   firstValue = result;
	   calculatorView_S = States.OutputTheAnswer;	
	   break;
	   
//   case "M+":
//	   memory += Double.parseDouble(dispFieldText);	
//	   if(memory != 0d){
//		   parent.showThatTheMemoryContainsData();
//		   calculatorView_S = States.OutputTheAnswer;
//	   }
//	   break;
//	   
//   case "MC":
//	   memory = 0d;	
//	   parent.showThatTheMemoryEmpty();
//	   break;
//	   
//   case "MR":
//	   calculatorView_S = States.TheFirstNumberIsFullySpecified;
	   
   case "MR":  
   case "MC":  
   case "M+":

	   parent.setDisplayValue("Sorry but memory operation to realize "
	   							+ "I don't have time.");
   	   
   default:
	  ;   
   } 
   
   //Обрабатываю нужные переходы из состояния в состояние
   if(prev_calculatorView_S != calculatorView_S){
	   switch(calculatorView_S){
	   	case DontEnterTheFirstNumber:
	   	case DontEnterTheSecondNumber:
	   	case OutputTheAnswer:
	   		counterDigitsInRow  = 0;
	   		break;
		   
	   	case IsEnteredTheFirstNumber:
	   	case IsEnteredTheSecondNumber:	
	   		counterDigitsInRow = 1;
	   		break;
	   		
	   	case TheFirstNumberWasTheFractional:
	   	case TheSecondNumberWasTheFractional:	
	   		counterDigitsInRow = 2;
	   		break;
	   }
   }
   prev_calculatorView_S = calculatorView_S;
   
 }
}
