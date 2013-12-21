import java.awt.Frame;

import com.practicalJava.lesson13.chapter23.MyJTableGUI;

public class JTableTest{
	
	public static void main(String[] args){
		Frame frame = new MyJTableGUI("UserDataRenderer");
		// делаем размер окна достаточным
		// для того, чтобы вместить все компоненты
		//frame.pack();
		frame.setSize(400,400);
		frame.setResizable(false);
		
		// Наконец, отображаем окно
		frame.setVisible(true);
	}
	
	

}
