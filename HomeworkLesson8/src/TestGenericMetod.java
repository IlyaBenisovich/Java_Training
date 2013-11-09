import java.util.LinkedList;
import java.util.List;

import com.practicalJava.lesson8.chapter15.Employee;
import com.practicalJava.lesson8.chapter15.RetiredEmployee;


public class TestGenericMetod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <RetiredEmployee> pensionersClub = new LinkedList<RetiredEmployee>();
		
		pensionersClub.add(new RetiredEmployee("James Gosling"));
		pensionersClub.add(new RetiredEmployee("Joshua Bloch"));
		pensionersClub.add(new RetiredEmployee("Cay S. Horstmann"));
		pensionersClub.add(new RetiredEmployee("Thomas H. Cormen"));
		 
		testGenericMetod(pensionersClub);
		 
	}

	private static List <Employee> testGenericMetod(List<? extends Employee> source) {
		List <Employee> arr= new LinkedList<>();
		
		for(Employee elem: source){
			System.out.println(elem.getName());
			arr.add(elem);
		}
		
		return arr;
	}
}
