package com.practicalJava.lesson8.chapter16;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class MyZipReader {
	public MyZipReader(String fileName)throws MyZipReaderException{
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ZipInputStream 	zis = new ZipInputStream(new BufferedInputStream(fis))){
			ZipEntry entry;
			
			while ((entry = zis.getNextEntry()) != null)
			      System.out.println(entry.getName());
		}catch(ZipException e){
			throw  new MyZipReaderException("Ошибка формата ZIP-файла ", e);
		}catch(FileNotFoundException e){
			throw  new MyZipReaderException("Проверьте, существует ли файл " + 
					fileName + " в директории проекта", e);
		}catch(IOException e){	
			throw  new MyZipReaderException("", e);
		}
	}
}
