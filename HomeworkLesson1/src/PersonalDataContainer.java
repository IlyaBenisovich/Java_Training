
import 	java.util.ArrayList;
import	java.util.Scanner;

public class PersonalDataContainer {
	private String country;
	private String town;
	private String street;
	private String name;
	private String surname;
	private int    house;
	private int    room; 
	
	
	
	void SetCountry(String country){
		this.country = country;
	}
	
	void SetTown(String town){
		this.town = town;
	}
	
	void SetStreet(String street){
		this.street = street;
	}
	
	void SetName(String name){
		this.name = name;
	}
	
	void SetSurname(String surname){
		this.surname = surname;
	}
	
	void SetHouse(int house){
		this.house = house;
	}
	
	void SetRoom(int room){
		this.room = room;
	}
	
	
	
//	PersonalDataContainer(){
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.printf("Ведите имя: ");
//		if(scanner.hasNextLine()){
//			name = scanner.nextLine();
//		}
//		
//		System.out.printf("Ведите фамилию: ");
//		if(scanner.hasNextLine()){
//			surname = scanner.nextLine();
//		}
//		
//		System.out.printf("\nВедите страну: ");
//		if(scanner.hasNextLine()){
//			country = scanner.nextLine();
//		}
//		
//		System.out.printf("\nВедите название города: ");
//		if(scanner.hasNextLine()){
//			town = scanner.nextLine();
//		}
//		
//		System.out.printf("\nВедите название улицы: ");
//		if(scanner.hasNextLine()){
//			street = scanner.nextLine();
//		}
//		
//		
//		System.out.printf("\nВедите номер дома: ");
//		if(scanner.hasNextInt()){
//			house = scanner.nextInt();
//		}
//		
//		
//		System.out.printf("\nВедите номер квартиры: ");
//		if(scanner.hasNextInt()){
//			room = scanner.nextInt();
//		}		
//		scanner.close();
//	}
	
	public void print (){
		System.out.println(
							country 							 + "\n" +
							town    							 + "\n" +
							"Ул."+street+" д."+house+" кв."+room + "\n" +
							name + " " +surname
						  ); 			
	}
	
	
	
	public static void main(String[] args) {
		int 		    length 		= 0;
		Scanner 		scanner 	= new Scanner(System.in);
		ArrayList<PersonalDataContainer> 		data_arr    = new ArrayList<PersonalDataContainer>();
		
				
		System.out.print("\nДанные скольких человек вы хотите сохранить? : ");
		if(scanner.hasNextInt()){
			length = scanner.nextInt();
		}
		
		for(int i=1; i<(length+1); i++){
			PersonalDataContainer man = new PersonalDataContainer();
			
			System.out.printf("Ведите даные %d-ого человека\r\n", i);
			System.out.println("----------------------------------");
			
			System.out.printf("Имя: ");
			if(scanner.hasNextLine()){
				man.SetName(scanner.next());				
			}
			
			System.out.printf("Фамилия: ");
			if(scanner.hasNextLine()){
				man.SetSurname(scanner.next());				
			}
			
			System.out.printf("Название страны: ");
			if(scanner.hasNextLine()){
				man.SetCountry(scanner.next());				
			}
			
			System.out.printf("Название города: ");
			if(scanner.hasNextLine()){
				man.SetTown(scanner.next());				
			}
			
			System.out.printf("Название улицы: ");
			if(scanner.hasNextLine()){
				man.SetStreet(scanner.next());				
			}
			
			System.out.printf("Номер дома: ");
			if(scanner.hasNextInt()){
				man.SetHouse(scanner.nextInt());				
			}
			
			System.out.printf("Номер квартиры: ");
			if(scanner.hasNextInt()){
				man.SetRoom(scanner.nextInt());				
			}
			
			data_arr.add(man);
			System.out.println("----------------------------------\r\n\n");
			
		}
		scanner.close();
		
		for(int i=0; i<length; i++)
			((PersonalDataContainer)data_arr.get(i)).print();
		
	}
}
