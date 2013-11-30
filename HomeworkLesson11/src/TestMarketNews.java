import com.practicalJava.lesson11.chapter21.GUI;

public class TestMarketNews {
	
	public static void main(String[] args){
		GUI frame = new GUI("MarketNewsReader");
		// делаем размер окна достаточным
		// для того, чтобы вместить все компоненты
		frame.pack();
		//frame.setSize(400,400);
		frame.setResizable(false);
		
		// Наконец, отображаем окно
		frame.setVisible(true);
	}
	
	

}
