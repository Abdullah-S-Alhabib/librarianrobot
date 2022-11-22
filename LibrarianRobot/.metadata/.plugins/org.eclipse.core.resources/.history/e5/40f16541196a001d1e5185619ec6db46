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
		
		numberOfVariables_  = books.size();
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
		
		//This takes the proposed index representations from the SolutionSet.
		int[] indexRep = ((Permutation)solution.getDecisionVariables()[0]).vector_;
		double currentWeight = problem.weightSum*0.01;
		
		// Holders for current and previous books
		Book prev = problem.parent.get(indexRep[0]);
		Book current = problem.parent.get(indexRep[1]);
		// Initiate cost with first gene cost.
		cost[0] = Math.abs((problem.parent.get(indexRep[0]).getXCoordinate() - 0) + (problem.parent.get(indexRep[0]).getYCoordinate() - 0));
		cost[1] = currentWeight;


		for (int i = 1; i < problem.parent.size();i++) {
				current = problem.parent.get(indexRep[i]);
				cost[0] += Math.abs((current.getXCoordinate() - prev.getXCoordinate()) + (current.getYCoordinate() - prev.getYCoordinate()));
				cost[1] += currentWeight;
				currentWeight -= current.getWeight()*0.01;
				prev = current;
				if (cost[1] < 0 )
					{
					System.out.println(indexRep[i]);
					cost[1] = 99999999;
					}
			}
		
		return cost;
	}


	@Override
	public void evaluate(Solution solution) throws JMException{

		double [] fx = new double[2] ; // function values
	    double [] fitness = new double[2];
	    double temp=0;
//	    Variable[] var = new Permutation[parent.size()];
	    
//	    for (int i = 0 ; i < parent.size(); i++)
//	    	{
	    	fitness = fitnessFunction((GeneticAlgorithm)solution.getProblem(), solution);
	    	fx[0] += fitness[0];
	    	fx[1] += fitness[1];
	    	temp += fx[0] + fx[1];
//	    	var[i] = new Permutation(10);
//	    	}
//	    //solution.setFitness(temp);
//	    solution.setDecisionVariables(var);
	    solution.setObjective(0,fx[0]);
	    solution.setObjective(1,fx[1]);


	}

}
