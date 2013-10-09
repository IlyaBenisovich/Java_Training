
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
		System.out.printf("���: ");
		if(scanner.hasNextLine()){
			name = scanner.next();				
		}
		
		System.out.printf("�������: ");
		if(scanner.hasNextLine()){
			surname=scanner.next();				
		}
		
		System.out.printf("�������� ������: ");
		if(scanner.hasNextLine()){
			country=scanner.next();				
		}
		
		System.out.printf("�������� ������: ");
		if(scanner.hasNextLine()){
			town=scanner.next();				
		}
		
		System.out.printf("�������� �����: ");
		if(scanner.hasNextLine()){
			street=scanner.next();				
		}
		
		System.out.printf("����� ����: ");
		if(scanner.hasNextInt()){
			house=scanner.nextInt();				
		}
		
		System.out.printf("����� ��������: ");
		if(scanner.hasNextInt()){
			room=scanner.nextInt();				
		}
		//scanner.close();
		
		//--------------------���� ��� ������ �������� � �����---------------------
		// ���� �������������� ������ 82, �� ��������� ��������� ��������: �����������
		// ��������� ����������� ������ ��� ������� ��������. 
		// ����� �� ���� �� ������� ����� ���������� ����� ������ �� �����������....?
		// �� ��� ���� ������� �����, �� ��������� ��������. � ���� ����� �� ���������
		// �� ��������.
		//-------------------------------------------------------------------------
	}
	
	public String toString (){
		return(
				country 							 + "\n" +
				town    							 + "\n" +
				"��."+street+" �."+house+" ��."+room + "\n" +
				name + " " +surname
			   ); 			
	}
}
