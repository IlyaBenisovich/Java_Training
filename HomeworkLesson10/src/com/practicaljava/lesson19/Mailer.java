package com.practicaljava.lesson19;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Mailer	implements EmailConstrants{
	
    private Session 			session = null;
    		ArrayList<String>	friends = new ArrayList<String>();

    public Mailer() {
        Properties 			sessionProperties 		  = new Properties();
        MyMailAuthenticator authentificatorForMessage = new MyMailAuthenticator();
        
        setSessionProperties(sessionProperties);
        session = Session.getInstance(sessionProperties, authentificatorForMessage);
    }

	private void setSessionProperties(Properties sessionProperties) {
		sessionProperties.put("mail.smtp.host", emailHost);
        sessionProperties.put("mail.smtp.user", emailSenderAddress);
        sessionProperties.put("mail.smtp.port", emailPort);
        sessionProperties.put("mail.smtp.auth", emailAuth);
	}

    private void setPropsAndSendEmail(String emailRecipient, 
    				String emailText) throws MailerException{
        
        Message emailMessage = new MimeMessage(session);
            
        updateEmailParameters(emailMessage,emailRecipient,emailText);
        sendEmail(emailMessage);
        System.out.println("Your email to " + emailRecipient + " has been sent successfully");
    }

	private void sendEmail(Message emailMessage)
			throws MailerException {
		try{    
        	Transport.send(emailMessage);
            
        }catch(MessagingException e){
        	throw new MailerException("There was a problem when sending an email", e);
        }
	}

	private void updateEmailParameters(Message target, String Recipient, 
			String Text) throws MailerException{
		try{
			target.setFrom      (new InternetAddress(emailSenderAddress));	
			target.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Recipient, false));
			target.setSubject   (emailSubject);
			target.setSentDate  (new Date());
			target.setText      (Text);	
		}catch(AddressException e){
			throw new MailerException("Wrong one of e-mail addresses", e);
		}catch(MessagingException e){
			throw new MailerException("Error setting e-mail data", e);
		}
		
	}
 
    public void readBirthdayFile(String fileName,String charset) throws MailerException{
    	
        try(FileInputStream birthdayFile      = new FileInputStream(fileName);
	        BufferedReader birthdayFileReader = new BufferedReader(
	        		new InputStreamReader(birthdayFile, charset))){
        	
        	String friendInfo;
	        while ((friendInfo = birthdayFileReader.readLine()) != null){
	            friends.add(friendInfo);
	        }
	        birthdayFileReader.close();	
        }catch(FileNotFoundException e){
        	throw new MailerException("File: " + fileName +
        							  " not found",e);
        }catch(UnsupportedEncodingException e){
        	throw new MailerException("Incorrect coding file " 
        								+ fileName,e);  
        }catch(IOException e){
        	throw new MailerException("Error reading of closing file: "
        							  + fileName,e);
        }
        
        System.out.println("From readBirthdayFile: " + friends);
    }

 
    public void iterateThroughBirthdays()throws MailerException{
        Iterator<String> iterator = friends.iterator(); 
        while (iterator.hasNext()){
            scanForManInfoAndSendEmail(iterator.next());
        }
    }
	
    private void scanForManInfoAndSendEmail(String stringFromArray)throws MailerException{
        Scanner scannerOfLines = new Scanner(stringFromArray).useDelimiter("[,\n]");
        if (scannerOfLines.next().equals(getCurrentDateMMMd())) {
            String emailAddressee = scannerOfLines.next();
            String emailAddress   = scannerOfLines.next();
            
            setPropsAndSendEmail(emailAddress, String.format(emailText, emailAddressee));
        }
        scannerOfLines.close();
    }
	
    private static String getCurrentDateMMMd(){
        return new SimpleDateFormat("MMM-d", Locale.US).format(new GregorianCalendar().getTime());
    }
}
