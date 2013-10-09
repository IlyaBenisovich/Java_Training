
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
//		System.out.printf("������ ���: ");
//		if(scanner.hasNextLine()){
//			name = scanner.nextLine();
//		}
//		
//		System.out.printf("������ �������: ");
//		if(scanner.hasNextLine()){
//			surname = scanner.nextLine();
//		}
//		
//		System.out.printf("\n������ ������: ");
//		if(scanner.hasNextLine()){
//			country = scanner.nextLine();
//		}
//		
//		System.out.printf("\n������ �������� ������: ");
//		if(scanner.hasNextLine()){
//			town = scanner.nextLine();
//		}
//		
//		System.out.printf("\n������ �������� �����: ");
//		if(scanner.hasNextLine()){
//			street = scanner.nextLine();
//		}
//		
//		
//		System.out.printf("\n������ ����� ����: ");
//		if(scanner.hasNextInt()){
//			house = scanner.nextInt();
//		}
//		
//		
//		System.out.printf("\n������ ����� ��������: ");
//		if(scanner.hasNextInt()){
//			room = scanner.nextInt();
//		}		
//		scanner.close();
//	}
	
	public void print (){
		System.out.println(
							country 							 + "\n" +
							town    							 + "\n" +
							"��."+street+" �."+house+" ��."+room + "\n" +
							name + " " +surname
						  ); 			
	}
	
	
	
	public static void main(String[] args) {
		int 		    length 		= 0;
		Scanner 		scanner 	= new Scanner(System.in);
		ArrayList<PersonalDataContainer> 		data_arr    = new ArrayList<PersonalDataContainer>();
		
				
		System.out.print("\n������ �������� ������� �� ������ ���������? : ");
		if(scanner.hasNextInt()){
			length = scanner.nextInt();
		}
		
		for(int i=1; i<(length+1); i++){
			PersonalDataContainer man = new PersonalDataContainer();
			
			System.out.printf("������ ����� %d-��� ��������\r\n", i);
			System.out.println("----------------------------------");
			
			System.out.printf("���: ");
			if(scanner.hasNextLine()){
				man.SetName(scanner.next());				
			}
			
			System.out.printf("�������: ");
			if(scanner.hasNextLine()){
				man.SetSurname(scanner.next());				
			}
			
			System.out.printf("�������� ������: ");
			if(scanner.hasNextLine()){
				man.SetCountry(scanner.next());				
			}
			
			System.out.printf("�������� ������: ");
			if(scanner.hasNextLine()){
				man.SetTown(scanner.next());				
			}
			
			System.out.printf("�������� �����: ");
			if(scanner.hasNextLine()){
				man.SetStreet(scanner.next());				
			}
			
			System.out.printf("����� ����: ");
			if(scanner.hasNextInt()){
				man.SetHouse(scanner.nextInt());				
			}
			
			System.out.printf("����� ��������: ");
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
