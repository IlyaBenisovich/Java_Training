package com.practicalJava.lesson12.chapter22;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;


public class NewsReader extends SwingWorker<List<String>, String> {
	
	private  String 	  tableName;
	
	private  long  	      maxRowNumber;
	private  long  	      currentRowNumber;
	
	private  MyJTextArea  textArea;
	
	private  long 		  sleepTime;
	
	private long processStatusInPersents(){
		return (currentRowNumber * 100)/maxRowNumber;
	}
	
	public NewsReader(MyJTextArea textArea, long sleepTime, String tableName)throws NewsReaderExcepion{
		this.textArea  = textArea;
		this.sleepTime = sleepTime;
		this.tableName = tableName;
	}
	
	private List<String> readFile() throws NewsReaderExcepion{
		List<String>  returnableList = new ArrayList<>(10);
		String     newsFileData;
		
		String userName = "root";
		String password = "101079";
		String url 		= "jdbc:mysql://127.0.0.1:3306/Firm";
		String sqlQuery = "SELECT * from " + tableName; 
		
		try{
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		}catch(Exception e){
			throw new NewsReaderExcepion("Ошибка при попытке зарегистировать "
					+ "JDBC-driver",e);
		}
		
		try(Connection conn = DriverManager.getConnection (url, userName, password);
				Statement  stmt = conn.createStatement(); 	
				ResultSet  rs   = stmt.executeQuery(sqlQuery)){
				
				System.out.println ("Database connection established");
				
				//Get the size of the data returned
				rs.last();     
				maxRowNumber = rs.getRow();   
				rs.beforeFirst();
				
				
				String 				colName;
				String 				colType;
				ResultSetMetaData  	meta 		= rs.getMetaData();
				int                	colCount    = meta.getColumnCount(); 
				String 				cols[]		= new String[meta.getColumnCount()];

                // Find number of columns in EMP
				for (int i=1; i< (colCount+1); i++) {                                          
					colName = meta.getColumnName(i);   		// Get column name
					colType = meta.getColumnTypeName(i);	// Get column data type
					System.out.println("Column = " + colName + " is data type " + colType);	// Print the column parameters
					
					cols[i-1] = meta.getColumnLabel(i);           								
				}
				
			    while (rs.next()){ 
			         Object data[]			  = new Object[cols.length];
			         StringBuilder dataString = new StringBuilder(200);
			         for(int i=0;i< data.length;++i)
			         {
			              data[i]=rs.getObject(i+1);
			              dataString.append(data[i] + " ");
			         }
			         
			         currentRowNumber = rs.getRow();
				     publish(dataString + "\n");
				    
	     
				     synchronized (this) {
						wait(sleepTime);
					}
			    }
 
			} catch( SQLException se ) {
				throw new NewsReaderExcepion("Ошибка при выполнении "
						+ "SQL-запроса",se);
		    }catch (Exception e){
		    	throw new NewsReaderExcepion("Cannot connect to database server",e);
		    }finally{
				System.out.println ("Database connection terminated");		
		    }
		
		return returnableList;
	} 
	
	@Override 
	protected void done(){
		currentRowNumber =maxRowNumber;
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
		textArea.setTitle("Read " + tableName + " table "+ processStatusInPersents() + "%");
		
		for(String progressMessage : chunks){
			textArea.append(progressMessage);
		}	
	}
	
	
}
