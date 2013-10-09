import java.util.ArrayList;
import java.util.Scanner;


public class PersonalDataContainerList {
	
	private ArrayList 		data_arr;
	
	PersonalDataContainerList(){
		int 		    length 		= 0;
		Scanner 		scanner 	= new Scanner(System.in);
		
		
		data_arr = new ArrayList();
		
		System.out.printf("\nДанные скольких человек вы хотите сохранить?: ");
		
		while(length == 0){
			if(scanner.hasNextInt()){
				length = scanner.nextInt();			
				if(length == 0){
					System.out.printf("\nСледует ввести ненулевое значение: ");
				}	
			}else if(scanner.hasNextLine()){
				scanner.next();									//очищаем строку ввода
				System.out.print("\nСледует ввести число: ");
			}
				
		}
		
		
		
		for(int i=0; i<length; i++){				
			System.out.printf("\nВедите даные %d-ого человека\r\n", i+1);
			System.out.println("----------------------------------");
			
			PersonalDataContainer man = new PersonalDataContainer();
			this.data_arr.add(man);
			System.out.println("----------------------------------\n");			
		}
		
		scanner.close();	
	}
	
	public void print (){
		for(int i=0; i<data_arr.size(); i++)
		{
			System.out.println("----------------------------------");
			System.out.printf ("Запись №%d:\r\n", i+1);
			System.out.println((PersonalDataContainer)data_arr.get(i));
			System.out.println("----------------------------------");	
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonalDataContainerList pdcl_unit = new PersonalDataContainerList();
		
		System.out.print("\nВ базу данных были добавленны следующие записи:\r\n");
		pdcl_unit.print();
		
	}

}
