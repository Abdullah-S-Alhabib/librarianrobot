package sa.edu.cs.librarianrobot.gui.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import sa.edu.cs.librarianrobot.gui.io.DataSet;
import sa.edu.cs.librarianrobot.gui.io.LibraryReader;
import sa.edu.cs.librarianrobot.gui.io.LibraryWriter;
import sa.edu.cs.librarianrobot.modeling.librarypackage.Book;
import sa.edu.cs.librarianrobot.modeling.librarypackage.Library;
import sa.edu.cs.librarianrobot.modeling.librarypackage.Publication;
import sa.edu.cs.librarianrobot.optimization.GA_Settings;
import sa.edu.cs.librarianrobot.optimization.GeneticAlgorithm;
import sa.edu.cs.librarianrobot.optimization.MyNSGAII;
import jmetal.core.Algorithm;
import jmetal.core.SolutionSet;
import jmetal.util.JMException;

public class MainController {

	private static int maxEvaluations = 500;
	private static LibraryReader reader 	= LibraryReader.getInstance();
	private static LibraryWriter writer 	= LibraryWriter.getInstance();

	public static void prepare(int max, DataSet inputData) throws ClassNotFoundException, JMException {
		maxEvaluations = max;
		Library library = reader.loadLibraryFromXMI(inputData);
		List<Book> books = new ArrayList<>();

		for(Publication p:library.getResources()) {
			books.add((Book) p);
		}
		
		execute(books);
		
		//((Library) books).getResources().clear();

		//library.getResources().addAll(books);

		//writer.writeLibraryToXMI(library, "./models/latex.xmi");

	}
	public static void execute(List<Book> books) throws ClassNotFoundException, JMException {
		GeneticAlgorithm ga = new GeneticAlgorithm(books,maxEvaluations);
	    Algorithm algorithm = null;
	    GA_Settings nsgaiiSettings = new GA_Settings("GeneticProblem",ga,150);
		algorithm = nsgaiiSettings.configure();
		SolutionSet fin = algorithm.execute();
		File output = new File("./Output/data");
		output.mkdirs();
		fin.printObjectivesToFile(output.getPath() + File.separatorChar + "FUN_");
		fin.printVariablesToFile(output.getPath() + File.separatorChar + "VAR_");
//		fin.printFeasibleFUN(output.getPath() + File.separatorChar + "FFUN_");
//		fin.printFeasibleVAR(output.getPath() + File.separatorChar + "FVAR_");
		
	}

}
