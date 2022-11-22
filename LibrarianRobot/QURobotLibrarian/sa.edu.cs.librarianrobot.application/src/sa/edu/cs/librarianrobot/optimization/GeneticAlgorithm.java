package sa.edu.cs.librarianrobot.optimization;


import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.util.JMException;

import java.util.HashMap;
import java.util.List;

import jmetal.encodings.solutionType.PermutationSolutionType;
import jmetal.encodings.variable.Permutation;
import jmetal.encodings.variable.Real;
import sa.edu.cs.librarianrobot.modeling.librarypackage.Book;


public class GeneticAlgorithm extends Problem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//The original parent
	public List<Book> parent;
	private double weightSum;
 

//	public GeneticAlgorithm() throws ClassNotFoundException, JMException {
//		problemGenerator(books);
//		GeneticAlgorithm.chromosome = books;
//	}

	public  GeneticAlgorithm(List<Book> books, int maxEval) throws ClassNotFoundException, JMException {
		
		numberOfVariables_  = 1;
	    numberOfObjectives_ = 2;
	    numberOfConstraints_= 0;
	    
	    problemName_        = "GeneticProblem";
	    solutionType_ = new PermutationSolutionType(this) ;
	    

	    //variableType_ = new Class[numberOfVariables_] ;
	    length_       = new int[numberOfVariables_];
	    parent = books;
	    weightSum = 0;
	    for (Book i:parent) {
	    	weightSum += i.getWeight(); 
	    }
	    
	    
//	    Variable[] var = new Variable[2];
//	    var[0]= new Real();
//	    var[1]= new Int();
	    
	    
	    
	}

	private static double[] fitnessFunction( GeneticAlgorithm problem, Solution solution) {
		//cost[0] is the distance cost, whilst cost[1] is the weight cost.
		double []cost = new double[2];
		
		//This takes the proposed index representations from the SolutionSet, I.E. permutations of book IDs.
		int[] indexRep = ((Permutation)solution.getDecisionVariables()[0]).vector_;
		// Divided by 1000 to calculate the weight from G to KG for readability.
		double currentWeight = problem.weightSum/1000;
		
		// Holders for current and previous books
		Book prev = problem.parent.get(indexRep[0]);
		Book current = problem.parent.get(indexRep[1]);
		
		double dist=Math.abs((problem.parent.get(indexRep[0]).getXCoordinate() - 0) + (problem.parent.get(indexRep[0]).getYCoordinate() - 0));;
		// Initiate cost with first gene cost.
		cost[0] = dist;
		cost[1] = 0.1*dist*currentWeight;
		
		
		//Evaluate fitness for each gene.
		for (int i = 1; i < problem.parent.size();i++) {
				current = problem.parent.get(indexRep[i]);
				dist =  Math.abs((current.getXCoordinate() - prev.getXCoordinate()) + (current.getYCoordinate() - prev.getYCoordinate()));
				//Distance cost of moving from the previous book to the current one.
				cost[0] += dist;
				//Energy cost= the current weight for each unit of distance traveled.
				cost[1] += 0.1*currentWeight* dist;
				//Take off the weight of the dropped book out of the total weight carried now.
				currentWeight -= current.getWeight()/1000;
				prev = current;
			}
		
		return cost;
	}


	@Override
	public void evaluate(Solution solution) throws JMException{

	    double [] fitness = new double[2];

	    fitness = fitnessFunction((GeneticAlgorithm)solution.getProblem(), solution);

	    solution.setObjective(0,fitness[0]);
	    solution.setObjective(1,fitness[1]);


	}

}
