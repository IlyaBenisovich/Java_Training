
public class TestTax {

	public static void main(String[] args){
		if (args.length != 3){
			System.out.println("Sample usage of the program:" +
			" java TestTax 50000 NJ 2");
			System.exit(0);
		}
		
		double 	grossIncome = Double.parseDouble(args[0]); // local variables
		String	state       = args[1];
		int 	dependents  = Integer.parseInt(args[2]);

		Tax t = new Tax(grossIncome, state, dependents);
		double yourTax = t.calcTax(); //calculating tax
		
		Tax t2 = new Tax(65000, "TX", 4 );
		double hisTax  = t2.calcTax();
		
		// Printing the result
		System.out.println("Your tax is = $" + yourTax);
		Tax.convertTaxInEuros(yourTax);
		
		System.out.println("His tax is = $" + hisTax);
		Tax.convertTaxInEuros(hisTax);
		}

}
