
public class Assignment2 {


	public static void Print(int[][] cnf) {
		// Print Function

		for (int k = 0; k < cnf.length; k++) {
			for (int m = 0; m < cnf[k].length; m = m + 1) {
				System.out.print(cnf[k][m] + " ");
			}
			System.out.println();
		}
	}

	// Task 1
	public static boolean isSquareMatrix(boolean[][] matrix) {
		// Checks if the matrix is a square matrix

		boolean isSquare = true;

		if (matrix == null) {
			isSquare = false;
		}

		for (int i = 0; isSquare && i < matrix.length; i = i + 1) {
			if (matrix[i] == null || matrix[i].length != matrix.length) {
				isSquare = false;
			}
		}

		return isSquare;
	}

	// Task 2	
	public static boolean isSymmetricMatrix(boolean[][] matrix) {
		// Checks if the matrix is a symmetric matrix

		boolean isSymmetric = true;

		for (int i = 0; i < matrix.length & isSymmetric; i = i + 1) {
			for (int j = 0; j < matrix[i].length & isSymmetric; j = j + 1) {
				if (matrix[i][j] != matrix[j][i]) {
					isSymmetric = false;
				}
			}
		}

		return isSymmetric;
	}

	// Task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
		// Checks if the matrix is a anti reflexive matrix

		boolean isAntiReflexive = true;

		for (int i = 0; i < matrix.length & isAntiReflexive; i = i + 1) {
			if (matrix[i][i] == true) {
				isAntiReflexive = false;
			}
		}

		return isAntiReflexive;
	}

	// Task 4
	public static boolean isLegalInstance(boolean[][] matrix) {
		// Checks if the matrix is a square, symmetric and anti reflexive

		boolean isLegal = false;

		if (isSquareMatrix(matrix) && (isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix))) {
			isLegal = true;
		}

		return isLegal;
	}

	// Task 5
	public static boolean isPermutation(int[] array) {
		// Checks if all numbers repeat only once and are between 0 and the matrix's length

		boolean isPermutation = true;
		int[] visitCount = new int[array.length];

		for (int i = 0; i < array.length & isPermutation; i = i + 1) {
			if (array[i] >= array.length | array[i] < 0) {
				isPermutation = false;
			} else {
				visitCount[array[i]] = visitCount[array[i]] + 1;
			}
		}
		for (int i = 0; i < array.length & isPermutation; i = i + 1) {
			if (visitCount[i] != 1) {
				isPermutation = false;
			}
		}

		return isPermutation;
	}

	// Task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {
		// Check if the given tour is possible by the given flights matrix

		boolean isLegal = true;

		for (int i = 0; i < tour.length - 1 & isLegal; i = i + 1) {
			if (flights[tour[tour.length - 1]][tour[0]] == false) {
				isLegal = false;
			}
			if (flights[tour[i]][tour[i + 1]] == false) {
				isLegal = false;
			}
		}

		return isLegal;
	}

	// Task 7
	public static boolean isSolution(boolean[][] flights, int[] tour) {
		// Check if the matrix is a possible solution

		boolean isSolution = true;

		if (tour == null) {
			throw new IllegalArgumentException("Tour value can't be null");
		}
		if (flights.length != tour.length) {
			throw new IllegalArgumentException("Tour and flights lengths don't match");
		}

		if (tour[0] != 0 | !isPermutation(tour) || !hasLegalSteps(flights, tour)) {
			isSolution = false;
		}

		return isSolution;
	}

	// Task 8
	public static int[][] atLeastOne(int[] vars) {
		// Insert The vars Variables Into CNF Array

		int[][] cnf = new int[1][vars.length];
		for (int i = 0; i < vars.length; i = i + 1) {
			cnf[0][i] = vars[i];
		}

		//Print(cnf);

		return cnf;
	}

	// Task 9
	public static int[][] atMostOne(int[] vars) {

		int NumOfClauses = (vars.length) * (vars.length - 1) / 2; // Count The Number Of Clauses
		int[][] cnf = new int[NumOfClauses][2];

		int row = 0; // Clause's Row Number

		for (int i = 0; i < vars.length - 1; i = i + 1) { // Row Consist Two Variables {-var1, -var2}
			for (int j = i + 1; j < vars.length; j = j + 1) {
				cnf[row][0] = (-1) * vars[i]; // Insert To The Clauses Not Var
				cnf[row][1] = (-1) * vars[j]; // Insert To The Clauses Not Var

				row = row + 1;
			}
		}

		//Print(cnf);

		return cnf;
	}

	// Task 10
	public static int[][] exactlyOne(int[] vars) {

		int NumOfClauses = ((vars.length) * (vars.length - 1) / 2) + 1; // Count The Number Of Clauses
		int[][] cnf = new int[NumOfClauses][];
		int[][] tmpClauses = atLeastOne(vars); // Create Matrix That Contain The Clause Of atLeastOne
		cnf[0] = tmpClauses[0]; // Insert The Clauses To The CNF Matrix

		tmpClauses = atMostOne(vars); // Create Matrix That Contain The Clause Of atMostOne
		for (int i = 0; i < tmpClauses.length; i = i + 1) { // Insert All The Clauses To CNF Matrix
			cnf[i + 1] = tmpClauses[i];
		}

		//Print(cnf);

		return cnf;
	}

	// Task 11
	public static boolean[] solveExactlyOneForEachSet(int[][] varSets) {

		int maxIndex = 0;
		for (int i = 0; i < varSets.length; i = i + 1) { // Find The Maximum Index
			for (int j = 0; j < varSets[i].length; j = j + 1) {
				if (maxIndex < varSets[i][j]) {
					maxIndex = varSets[i][j];
				}
			}
		}

		SATSolver.init(maxIndex);
		for (int i = 0; i < varSets.length; i = i + 1) { // Go Through All Sets Of vars
			int[][] cnf = exactlyOne(varSets[i]);
			SATSolver.addClauses(cnf);
		}

		boolean[] assignment = SATSolver.getSolution();
		if (assignment == null)
			System.out.println("TIMEOUT");
		else if (assignment.length == maxIndex + 1)
			System.out.println("SAT");
		else
			System.out.println("UNSAT");

		return assignment;
	}

	// Task 12
	public static int[][] createVarsMap(int n) {
		// Create Matrix And Insert To Each Cell Number With Ascending Order

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i = i + 1) {
			for (int j = 0; j < n; j = j + 1) {
				map[i][j] = i * n + j + 1;
			}
		}

		return map;
	}

	// Task 13
	public static int[][] oneCityInEachStep(int[][] map) {

		int numOfClauses = map.length * ((map.length * (map.length - 1) / 2) + 1); // Count The Number Of Clauses
		int[][] cnf = new int[numOfClauses][];
		int row = 0; // Clause's Row Number

		for (int i = 0; i < map.length; i = i + 1) {
			int[][] tmpClauses = exactlyOne(map[i]); // Insert The Clauses Of Every Map Set
			for (int j = 0; j < tmpClauses.length; j = j + 1) { // Insert All The Clauses To The CNF Matrix
				cnf[row] = tmpClauses[j];
				row = row + 1;
			}
		}

		return cnf;
	}

	// Task 14
	public static int[][] fixSourceCity(int[][] map) {
		// Return The Clauses Of Origin City Is 0,0

		int[][] cnf = new int[1][1];
		cnf[0][0] = map[0][0];

		return cnf;
	}

	// Task 15
	public static int[][] eachCityIsVisitedOnce(int[][] map) {

		int[][] cnf = new int[map.length * (((map.length) * (map.length - 1) / 2) + 1)][];
		int row = 0;
		for (int i = 0; i < map.length; i = i + 1) { // Go Through All Sets Of vars
			int[] mapColumn = new int[map.length];
			for (int j = 0; j < map.length; j = j + 1) { // Insert All The Literals Of The City
				mapColumn[j] = map[j][i];
			}
			int[][] tmpCnf = exactlyOne(mapColumn);
			for (int j = 0; j < tmpCnf.length; j = j + 1) { // Insert All The Clauses To The CNF Matrix
				cnf[row] = tmpCnf[j];
				row = row + 1;
			}
		}

		return cnf;
	}

	// Task 16
	public static int[][] noIllegalSteps(boolean[][] flights, int[][] map) {

		int falseCount = 0;
		for (int i = 0; i < map.length; i = i + 1) { // Count The Falses In The Matrix Above The Diagonal
			for (int j = i + 1; j < map.length; j = j + 1) {
				if (!flights[i][j]) {
					falseCount = falseCount + 1;
				}
			}
		}

		int[][] cnf = new int[falseCount * ((map.length - 1) * 2 + 1)][];
		int cnfRow = 0;

		for (int i = 0; i < map.length; i = i + 1) {
			for (int j = i + 1; j < map.length; j = j + 1) {
				if (!flights[i][j]) {
					for (int k = 0; k < map.length - 1; k = k + 1) {
						cnf[cnfRow] = new int[]{(-1) * (map[k][i]), (-1) * (map[k + 1][j])}; // Insert Clause For Origin City i To Destination City j
						cnf[cnfRow + 1] = new int[]{(-1) * map[k][j], (-1) * (map[k + 1][i])}; // Insert Clause For Origin City j To Destination City i
						cnfRow = cnfRow + 2;
					}
					cnf[cnfRow] = new int[]{(-1) * map[map.length - 1][j]}; // Insert Clause Of Return To Origin City From Destination City
					cnfRow = cnfRow + 1;
				}
			}
		}

		return cnf;
	}

	// Task 17
	public static void encode(boolean[][] flights, int[][] map) {

		if (!isLegalInstance(flights)) {
			throw new IllegalArgumentException("flights Is Illegal Instance");
		} else if (map == null) {
			throw new NullPointerException("map Is null Instance");
		} else if (flights.length != map.length) {
			throw new IllegalArgumentException("flights And map Lengths Don't Match");
		}

		boolean isLegalMap = true;
		int mapIndexCounter = 1;

		for (int i = 0; i < map.length & isLegalMap; i = i + 1) { // Check If map Is Legal
			if (map[i] == null) {
				throw new NullPointerException("map's Sub Array Is null Instance");
			} else if (map.length != map[i].length) {
				throw new IllegalArgumentException("map Isn't Square Matrix");
			}
			for (int j = 0; j < map[i].length & isLegalMap; j = j + 1) {
				if (map[i][j] != mapIndexCounter) {
					isLegalMap = false;
				}
				mapIndexCounter = mapIndexCounter + 1;
			}
		}
		if (!isLegalMap) {
			throw new IllegalArgumentException("maps Is Illegal Instance");
		}

		SATSolver.addClauses(oneCityInEachStep(map));
		SATSolver.addClauses(eachCityIsVisitedOnce(map));
		SATSolver.addClauses(fixSourceCity(map));
		SATSolver.addClauses(noIllegalSteps(flights, map));
	}

	// Task 18
	public static int[] decode(boolean[] assignment, int[][] map) {

		if (assignment.length != ((map.length * map.length) + 1) & assignment.length != 0) { // Check If assignment Is Right
			throw new IllegalArgumentException("assignment Is Wrong Solution");
		}

		int[] decoded = new int[map.length];
		int tourLocationNum = 0;

		if (assignment.length == 0) { //Check If assignment Is Empty
			decoded = null;
		} else {
			for (int i = 1; i < assignment.length; i = i + 1) {
				if (assignment[i]) {
					decoded[tourLocationNum] = (i - 1) % map.length;
					tourLocationNum = tourLocationNum + 1;
				}
			}
		}

		return decoded;
	}

	// Task 19
	public static int[] solve(boolean[][] flights) {

		if (!isLegalInstance(flights)) {
			throw new IllegalArgumentException("flights Is Illegal Instance");
		}

		int[][] map = createVarsMap(flights.length);
		SATSolver.init(flights.length * flights.length);
		encode(flights, map);

		boolean[] assignment = SATSolver.getSolution();
		if (assignment == null) {
			throw new RuntimeException("timeout exception");
		}

		int[] s = null;
		if (assignment.length > 0) {
			s = decode(assignment, map);
			if (assignment.length == flights.length * flights.length + 1) { //Check If SATSolver Return A Solution
				if (s == null || !isSolution(flights, s)) {
					throw new RuntimeException("Wrong Solution");
				}
			}
		}

		return s;
	}


	// Task 20
	public static boolean solve2(boolean[][] flights) {

		boolean isSolve2 = false;
		int[] firstTour = solve(flights); // Getting The Solution Tour Of The First Tour
		int[] notTourClause = new int[firstTour.length];
		for (int i = 0; i < firstTour.length; i = i + 1) {
			notTourClause[i] = (-1) * (i * flights.length + firstTour[i] + 1); // Insert Clause That Disqualify The First Tour
		}

		int[] equalTour = new int[firstTour.length]; // Create Array That Equal Tour To The First Tour
		equalTour[0] = 0;
		for (int i = 1; i < firstTour.length; i = i + 1) {
			equalTour[i] = firstTour[firstTour.length - i];
		}

		int[] notEqualTourClause = new int[firstTour.length];
		for (int i = 0; i < firstTour.length; i = i + 1) {
			notEqualTourClause[i] = (-1) * (i * flights.length + equalTour[i] + 1); // Create Array That Disqualify The Equal Tour
		}

		int[][] map = createVarsMap(flights.length);
		SATSolver.init(flights.length * flights.length);
		encode(flights, map);
		SATSolver.addClause(notTourClause);
		SATSolver.addClause(notEqualTourClause);

		boolean[] assignment = SATSolver.getSolution();
		if (assignment == null) {
			throw new RuntimeException("timeout exception");
		}
		if (assignment.length > 0) {
			int[] secondTour = decode(assignment, map);
			if (secondTour != null) {
				if (!isSolution(flights, secondTour))// Check If The Secont Tour Solution Is Legal
					throw new RuntimeException("iligale second solution");
				if (secondTour.length != 0)
					isSolve2 = true;
			}
		}

		return isSolve2;
	}
}