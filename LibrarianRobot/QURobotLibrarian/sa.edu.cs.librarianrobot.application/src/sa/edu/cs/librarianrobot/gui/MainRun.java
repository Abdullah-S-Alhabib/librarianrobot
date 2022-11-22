package sa.edu.cs.librarianrobot.gui;

import java.io.FileWriter;
import java.io.IOException;

import jmetal.util.JMException;
import sa.edu.cs.librarianrobot.gui.controllers.MainController;
import sa.edu.cs.librarianrobot.gui.io.DataSet;

public class MainRun {

	public static void main(String[] args) throws ClassNotFoundException, JMException, IOException {
	
		//output file
		FileWriter output = new FileWriter("./Output/Readable_output.txt");
		
		System.out.println("Number of books= 100");
		MainController.prepare(10000,DataSet.DS_100,output);
		
		System.out.println("\n------------\nNumber of books= 500");
		MainController.prepare(10000,DataSet.DS_500,output);
		
		System.out.println("\n------------\nNumber of books= 1000");
		MainController.prepare(10000,DataSet.DS_1000,output);
		
		System.out.println("\n------------\nNumber of books= 2500");
		MainController.prepare(10000,DataSet.DS_2500,output);
		
		System.out.println("\n------------\nNumber of books= 5000");
		MainController.prepare(10000,DataSet.DS_5000,output);
	    output.close();
	}

}
