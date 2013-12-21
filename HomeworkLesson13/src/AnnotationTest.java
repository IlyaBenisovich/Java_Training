import com.practicalJava.lesson13.chapter24.annotation.DBParamProcessor;


public class AnnotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("Specify the name of the class with annotations  as a command line argument.");
			System.out.println("For example: java DBParamProcessor com.practicalJava.lesson13.chapter23.dao.UserDaoJdbc");
			System.exit(1);
		}else{
			System.out.println(args[0]);
		}
		
		DBParamProcessor.process(args[0]);
	}

}
