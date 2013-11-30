package com.practicalJava.lesson11.chapter21;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<List<String>, String> {
	
	private  File 	    newsFile;
	private  String 	fileName;
	private  String 	charset;
	
	private  long  	    currentLengh;
	
	private  MyJTextArea  textArea;
	
	private  long 		sleepTime;
	
	private long processStatusInPersents(){
		return (currentLengh * 100)/newsFile.length();
	}
	
	public NewsReader(String fileName,String charset, MyJTextArea textArea, 
			long sleepTime)throws NewsReaderExcepion{
		
		try{
			newsFile = new File(fileName);
		}catch(NullPointerException e){
			throw new NewsReaderExcepion("Empty filename passed to the constructor"
					+ " NewsReader(...)", e);
		}
		
		if(newsFile.exists()){
			this.fileName       = fileName;
			this.charset   		= charset;
			this.textArea  		= textArea;
			this.sleepTime 		= sleepTime;
			this.currentLengh	= 0;
		}
		else
			throw new NewsReaderExcepion("File: " + fileName +" not found", null);
	}
	
	private List<String> readFile() throws NewsReaderExcepion{
		List<String>  returnableList = new ArrayList<>(10);
		String     newsFileData;
		
		try(FileReader fr = new FileReader(newsFile);
	        BufferedReader newsFileReader = new BufferedReader(fr)){
        	  	
        	
        	
        	//publish("hello");
	        while ((newsFileData = newsFileReader.readLine()) != null){
	        	try{
	        		Thread.sleep(sleepTime);
	        	}catch(InterruptedException e){/* NOP */}
	        	returnableList.add(newsFileData);
	        	currentLengh += newsFileData.getBytes(charset).length;
	        	publish(newsFileData + "\n");
	        }
	        newsFileReader.close();	
	        
        }catch(FileNotFoundException e){
        	throw new NewsReaderExcepion("File: " + fileName +" not found",e);
        }catch(UnsupportedEncodingException e){
        	throw new NewsReaderExcepion("Incorrect coding file " + fileName,e);  
        }catch(IOException e){
        	throw new NewsReaderExcepion("Error reading of closing file: "+ fileName,e);
        }
		return returnableList;
	} 
	
	@Override 
	protected void done(){
		currentLengh  = newsFile.length();
		publish("  ");
	}
	
	@Override 
	public List<String> doInBackground(){
		List<String> returnableData = null;
		
		try{
			returnableData = readFile();
		}catch(NewsReaderExcepion e){
			e.printStackTrace();
		}
		return returnableData;
	}
	
	
	@Override
	protected void process(List<String> chunks){
		textArea.setTitle("Read " + fileName + "  " + processStatusInPersents() + "%");
		
		for(String progressMessage : chunks){
			textArea.append(progressMessage);
		}	
	}
	
	
}
