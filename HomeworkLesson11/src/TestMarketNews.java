import com.practicalJava.lesson11.chapter21.GUI;

public class TestMarketNews {
	
	public static void main(String[] args){
		GUI frame = new GUI("MarketNewsReader");
		// ������ ������ ���� �����������
		// ��� ����, ����� �������� ��� ����������
		frame.pack();
		//frame.setSize(400,400);
		frame.setResizable(false);
		
		// �������, ���������� ����
		frame.setVisible(true);
	}
	
	

}
