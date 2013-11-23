import com.practicaljava.lesson19.Mailer;
import com.practicaljava.lesson19.MailerException;



public class MailerTest {

    public static void main(String[] args){	 
    	if (args.length!=2){
    	      System.out.println(
    	        "Proper Usage: java AddressBookFileName Charset");
    	      System.exit(0);
    	 }

    	
        Mailer mm = new Mailer();
        try {
               mm.readBirthdayFile(args[0],args[1]);
               mm.iterateThroughBirthdays();
         } catch (MailerException e) {
             e.printStackTrace();
         }
        System.out.println("From main():   Buy!");
     }
}
