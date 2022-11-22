package sa.edu.cs.librarianrobot.optimization;

import jmetal.core.Algorithm;
import jmetal.core.Operator;
import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.SolutionSet;
import jmetal.core.Variable;
import jmetal.encodings.variable.Permutation;
import jmetal.qualityIndicator.QualityIndicator;
import jmetal.util.Distance;
import jmetal.util.JMException;
import jmetal.util.Ranking;
import jmetal.util.comparators.CrowdingComparator;

public class MyNSGAII extends Algorithm{
	

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	   * Constructor
	   * @param problem Problem to solve
	   */
	public MyNSGAII(GeneticAlgorithm problem) {
		super(problem);


	}
	
	private Solution createDecisionVariable(GeneticAlgorithm problem) throws ClassNotFoundException {
		Solution newSolution;
		Permutation[] var = new Permutation[problem.parent.size()];
		newSolution = new Solution(problem);
		for (int i=0; i<(problem.parent.size());i++) {
			if (i==0)
			var[i] = new Permutation(problem.parent.size());
			else
				var[i] = new Permutation(1);
		}
		newSolution.setDecisionVariables(var);
		return newSolution;
	}

	  /**
	   * Runs the NSGA-II algorithm.
	   * @return a <code>SolutionSet</code> that is a set of non dominated solutions
	   * as a result of the algorithm execution
	   * @throws JMException
	   */
	@Override
	public SolutionSet execute() throws JMException, ClassNotFoundException {
		int populationSize;
	    int maxEvaluations;
		int evaluations ;
		
	    QualityIndicator indicators; 
	    int requiredEvaluations; 

	    SolutionSet population;
	    SolutionSet offspringPopulation;
	    SolutionSet union;

	    Operator mutationOperator;
	    Operator crossoverOperator;
	    Operator selectionOperator;

	    Distance distance = new Distance();

	    //Read the parameters
	    populationSize = ((Integer) getInputParameter("populationSize")).intValue();
	    maxEvaluations = ((Integer) getInputParameter("maxEvaluations")).intValue();
	    indicators =(QualityIndicator) getInputParameter("indicators");


	    //Initialize the variables
	    population = new SolutionSet(populationSize);
	    evaluations = 0;

	    requiredEvaluations = 0;

	    //Read the operators
	    mutationOperator = operators_.get("mutation");
	    crossoverOperator = operators_.get("crossover");
	    selectionOperator = operators_.get("selection");

	    // Create the initial solutionSet
	    Solution newSolution;
	    for (int i = 0; i < populationSize; i++) {
	      newSolution = createDecisionVariable((GeneticAlgorithm) problem_);
	      //newSolution = new Solution(problem_);
	      problem_.evaluate(newSolution);
	      problem_.evaluateConstraints(newSolution);
	      evaluations++;
	      population.add(newSolution);
	    } //for

	    // Generations
	    while (evaluations < maxEvaluations) {

	      // Create the offSpring solutionSet
	      offspringPopulation = new SolutionSet(populationSize);
	      Solution[] parents = new Solution[2];
	      
	      for (int i = 0; i < (populationSize / 2); i++) {
	        if (evaluations < maxEvaluations) {
	          //obtain parents
	          parents[0] = (Solution) selectionOperator.execute(population);
	          parents[1] = (Solution) selectionOperator.execute(population);
	          Solution[] offSpring = (Solution[]) crossoverOperator.execute(parents);
	          mutationOperator.execute(offSpring[0]);
	          mutationOperator.execute(offSpring[1]);
	          problem_.evaluate(offSpring[0]);
	          problem_.evaluateConstraints(offSpring[0]);
	          problem_.evaluate(offSpring[1]);
	          problem_.evaluateConstraints(offSpring[1]);
	          offspringPopulation.add(offSpring[0]);
	          offspringPopulation.add(offSpring[1]);
	          evaluations += 2;
	        } // if
	      } // for

	      // Create the solutionSet union of solutionSet and offSpring
	      union = population.union(offspringPopulation);

	      // Ranking the union
	      Ranking ranking = new Ranking(union);

	      int remain = populationSize;
	      int index = 0;
	      SolutionSet front = null;
	      population.clear();

	      // Obtain the next front
	      front = ranking.getSubfront(index);

	      while ((remain > 0) && (remain >= front.size())) {
	        //Assign crowding distance to individuals
	        distance.crowdingDistanceAssignment(front, problem_.getNumberOfObjectives());
	        //Add the individuals of this front
	        for (int k = 0; k < front.size(); k++) {
	          population.add(front.get(k));
	        } // for

	        //Decrement remain
	        remain = remain - front.size();

	        //Obtain the next front
	        index++;
	        if (remain > 0) {
	          front = ranking.getSubfront(index);
	        } // if
	      } // while

	      // Remain is less than front(index).size, insert only the best one
	      if (remain > 0) {  // front contains individuals to insert
	        distance.crowdingDistanceAssignment(front, problem_.getNumberOfObjectives());
	        front.sort(new CrowdingComparator());
	        for (int k = 0; k < remain; k++) {
	          population.add(front.get(k));
	        } // for

	        remain = 0;
	      } // if

	      // This piece of code shows how to use the indicator object into the code
	      // of NSGA-II. In particular, it finds the number of evaluations required
	      // by the algorithm to obtain a Pareto front with a hypervolume higher
	      // than the hypervolume of the true Pareto front.
	      if ((indicators != null) &&
	          (requiredEvaluations == 0)) {
	        double HV = indicators.getHypervolume(population);
	        if (HV >= (0.98 * indicators.getTrueParetoFrontHypervolume())) {
	          requiredEvaluations = evaluations;
	        } // if
	      } // if
	    } // while

	    // Return as output parameter the required evaluations
	    setOutputParameter("evaluations", requiredEvaluations);

	    // Return the first non-dominated front
	    Ranking ranking = new Ranking(population);
	    ranking.getSubfront(0).printFeasibleFUN("FUN_NSGAII") ;

	    return ranking.getSubfront(0);
	  } // execute
	
	} // NSGA-II
