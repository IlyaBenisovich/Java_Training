
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
	
	
	
	PersonalDataContainer(){
		Scanner 		scanner 	= new Scanner(System.in);
		System.out.printf("Имя: ");
		if(scanner.hasNextLine()){
			name = scanner.next();				
		}
		
		System.out.printf("Фамилия: ");
		if(scanner.hasNextLine()){
			surname=scanner.next();				
		}
		
		System.out.printf("Название страны: ");
		if(scanner.hasNextLine()){
			country=scanner.next();				
		}
		
		System.out.printf("Название города: ");
		if(scanner.hasNextLine()){
			town=scanner.next();				
		}
		
		System.out.printf("Название улицы: ");
		if(scanner.hasNextLine()){
			street=scanner.next();				
		}
		
		System.out.printf("Номер дома: ");
		if(scanner.hasNextInt()){
			house=scanner.nextInt();				
		}
		
		System.out.printf("Номер квартиры: ");
		if(scanner.hasNextInt()){
			room=scanner.nextInt();				
		}
		//scanner.close();
		
		//--------------------Надо при случае спросить у Якова---------------------
		// Если раскомментирую строку 82, то перестает нормально работать: конструктор
		// правильно отрабатыват только для первого человека. 
		// Вроде бы надо бы закрвит поток считывания после выхода из коструктора....?
		// Но вот если закрыть поток, то возникают проблемы. А если поток не заркывать
		// то работает.
		//-------------------------------------------------------------------------
	}
	
	public String toString (){
		return(
				country 							 + "\n" +
				town    							 + "\n" +
				"Ул."+street+" д."+house+" кв."+room + "\n" +
				name + " " +surname
			   ); 			
	}
}
