package com.example.demo.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;


@Service
public class PersonService {
	
	private static int rowCount = 1;
	private String filePath = "persons.xlsx";
	private ArrayList<Person> personList = new ArrayList<>();
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public void addPerson(Person person) throws IOException
	{
		personList.add(person);
		saveExcel();
	}
	
	public File getExcel() throws IOException
	{
		return new File(filePath);
	}
	
	private void saveExcel() throws IOException
	{
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Persons");
		
		XSSFRow rowHeader = sheet.createRow(0);
		rowHeader.createCell(0).setCellValue("ID");
		rowHeader.createCell(1).setCellValue("Name");
		rowHeader.createCell(2).setCellValue("Phone Number");
		
		for (int i = 0; i < personList.size(); i++) 
		{
			Person person = personList.get(i);
			XSSFRow row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(person.getId());
			row.createCell(1).setCellValue(person.getName());
			row.createCell(2).setCellValue(person.getPhone());
		}
		
		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut);
		workbook.close();
	}
	
}
