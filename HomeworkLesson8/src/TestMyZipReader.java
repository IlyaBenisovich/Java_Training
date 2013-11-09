import com.practicalJava.lesson8.chapter16.*;
public class TestMyZipReader {

	public static void main(String[] args){
		try{
			MyZipReader reader = new MyZipReader("Lesson16.zip");
		
		}catch(MyZipReaderException ex){
			ex.printStackTrace();

			//for(Throwable suppressed : ex.getSuppressed()){
			//	System.err.println(suppressed);
			//}
		}
	}

}
