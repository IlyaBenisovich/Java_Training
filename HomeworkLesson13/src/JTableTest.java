import java.awt.Frame;

import com.practicalJava.lesson13.chapter23.MyJTableGUI;

public class JTableTest{
	
	public static void main(String[] args){
		Frame frame = new MyJTableGUI("UserDataRenderer");
		// ������ ������ ���� �����������
		// ��� ����, ����� �������� ��� ����������
		//frame.pack();
		frame.setSize(400,400);
		frame.setResizable(false);
		
		// �������, ���������� ����
		frame.setVisible(true);
	}
	
	

}
