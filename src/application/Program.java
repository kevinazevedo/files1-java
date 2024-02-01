package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {
   
	public static void main(String[] args) {
			
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV LED", 1290.99,1));
		list.add(new Product("Video Game Chair", 350.50,3));
		list.add(new Product("Iphone X", 900.00,2));
		list.add(new Product("Samsung Galaxy 9", 850.00,2));
	
		// Source File
		String[] linesSource = new String[list.size()];
		for(int i=0; i<linesSource.length; i++) {
			linesSource[i] = list.get(i).toString();
		}
			
		File path = new File("c:\\KevDev\\sourcefile.csv");			
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for(String line : linesSource) {
				bw.write(line);
				bw.newLine();
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		// Output File
		boolean createFolder = new File (path.getParent()+"\\out").mkdir();
		System.out.println("Folder created: " + createFolder);
		
		String[] linesOut = new String[list.size()];
		for(int i=0; i<linesOut.length; i++) {
			linesOut[i] = list.get(i).getName() + "," + String.format("%.2f", list.get(i).totalValue());
		}		
		
		String pathOut = "c:\\KevDev\\out\\summary.csv";	
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
			for(String line : linesOut) {
				bw.write(line);
				bw.newLine();
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}	
	}
}
