package com.practicaljava.lesson19;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


class MyMailAuthenticator extends Authenticator implements EmailConstrants{ 
    protected PasswordAuthentication getPasswordAuthentication() {
       return new PasswordAuthentication (emailSenderAddress,emailSenderPassword);
    }
}
