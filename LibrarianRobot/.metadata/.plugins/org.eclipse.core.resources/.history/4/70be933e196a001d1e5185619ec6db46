package sa.edu.cs.librarianrobot.optimization;

import java.util.HashMap;
import java.util.Properties;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.experiments.Settings;
import jmetal.metaheuristics.nsgaII.NSGAII;
import jmetal.operators.crossover.Crossover;
import jmetal.operators.crossover.CrossoverFactory;
import jmetal.operators.mutation.Mutation;
import jmetal.operators.mutation.MutationFactory;
import jmetal.operators.selection.Selection;
import jmetal.operators.selection.SelectionFactory;
import jmetal.problems.ProblemFactory;
import jmetal.util.JMException;


public class GA_Settings extends Settings{

	public int populationSize_                 ;
	public int maxEvaluations_                 ;
	public double mutationProbability_         ;
	public double crossoverProbability_        ;
	public double mutationDistributionIndex_   ;
	public double crossoverDistributionIndex_  ;


	/**
	 * Constructor
	 */
	public GA_Settings(String problemName, Problem problem, int popSize) {
		 super(problemName) ;
		 problem_ = problem;

	    Object problemParams[] = {" Permutation "};
	    // Default experiments.settings
	    populationSize_              = popSize;
	    maxEvaluations_              = 25000 ;
	    mutationProbability_         = 1.0/problem_.getNumberOfBits() ;
	    crossoverProbability_        = 0.9   ;
	    mutationDistributionIndex_   = 20.0  ;
	    crossoverDistributionIndex_  = 20.0  ;
		  } // NSGAII_Settings


		  /**
		   * Configure NSGAII with default parameter experiments.settings
		   * @return A NSGAII algorithm object
		   * @throws jmetal.util.JMException
		   */
		  @Override
		public Algorithm configure() throws JMException {
		    Algorithm algorithm ;
		    Selection  selection ;
		    Crossover  crossover ;
		    Mutation   mutation  ;

		    HashMap  parameters ; // Operator parameters

		    // Creating the algorithm. There are two choices: NSGAII and its steady-
		    // state variant ssNSGAII
		    algorithm = new MyNSGAII((GeneticAlgorithm) problem_) ;
		    //algorithm = new ssNSGAII(problem_) ;

		    // Algorithm parameters
		    algorithm.setInputParameter("populationSize",populationSize_);
		    algorithm.setInputParameter("maxEvaluations",maxEvaluations_);

		    // Mutation and Crossover for Permutation codification
		    parameters = new HashMap() ;
		    parameters.put("probability", crossoverProbability_) ;
		    parameters.put("distributionIndex", crossoverDistributionIndex_) ;
		    crossover = CrossoverFactory.getCrossoverOperator("TwoPointsCrossover",parameters);

		    parameters = new HashMap() ;
		    parameters.put("probability", mutationProbability_) ;
		    parameters.put("distributionIndex", mutationDistributionIndex_) ;
		    mutation = MutationFactory.getMutationOperator("SwapMutation", parameters);

		    // Selection Operator
		    parameters = null ;
		    selection = SelectionFactory.getSelectionOperator("BinaryTournament", parameters) ;

		    // Add the operators to the algorithm
		    algorithm.addOperator("crossover",crossover);
		    algorithm.addOperator("mutation",mutation);
		    algorithm.addOperator("selection",selection);

		    return algorithm ;
		  } // configure

		 /**
		  * Configure NSGAII with user-defined parameter experiments.settings
		  * @return A NSGAII algorithm object
		  */
		  @Override
		  public Algorithm configure(Properties configuration) throws JMException {
		    Algorithm algorithm ;
		    Selection  selection ;
		    Crossover  crossover ;
		    Mutation   mutation  ;

		    HashMap  parameters ; // Operator parameters

		    // Creating the algorithm. There are two choices: NSGAII and its steady-
		    // state variant ssNSGAII
		    algorithm = new MyNSGAII((GeneticAlgorithm) problem_) ;
		    //algorithm = new ssNSGAII(problem_) ;

		    // Algorithm parameters
		    populationSize_ = Integer.parseInt(configuration.getProperty("populationSize",String.valueOf(populationSize_)));
		    maxEvaluations_  = Integer.parseInt(configuration.getProperty("maxEvaluations",String.valueOf(maxEvaluations_)));
		    algorithm.setInputParameter("populationSize",populationSize_);
		    algorithm.setInputParameter("maxEvaluations",maxEvaluations_);

		    // Mutation and Crossover for Real codification
		    crossoverProbability_ = Double.parseDouble(configuration.getProperty("crossoverProbability",String.valueOf(crossoverProbability_)));
		    crossoverDistributionIndex_ = Double.parseDouble(configuration.getProperty("crossoverDistributionIndex",String.valueOf(crossoverDistributionIndex_)));
		    parameters = new HashMap() ;
		    parameters.put("probability", crossoverProbability_) ;
		    parameters.put("distributionIndex", crossoverDistributionIndex_) ;
		    crossover = CrossoverFactory.getCrossoverOperator("SBXCrossover", parameters);

		    mutationProbability_ = Double.parseDouble(configuration.getProperty("mutationProbability",String.valueOf(mutationProbability_)));
		    mutationDistributionIndex_ = Double.parseDouble(configuration.getProperty("mutationDistributionIndex",String.valueOf(mutationDistributionIndex_)));
		    parameters = new HashMap() ;
		    parameters.put("probability", mutationProbability_) ;
		    parameters.put("distributionIndex", mutationDistributionIndex_) ;
		    mutation = MutationFactory.getMutationOperator("PolynomialMutation", parameters);

		    // Selection Operator
		    parameters = null ;
		    selection = SelectionFactory.getSelectionOperator("BinaryTournament2", parameters) ;

		    // Add the operators to the algorithm
		    algorithm.addOperator("crossover",crossover);
		    algorithm.addOperator("mutation",mutation);
		    algorithm.addOperator("selection",selection);

		    return algorithm ;
		  }

}
