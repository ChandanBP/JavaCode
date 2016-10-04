package whatfix;

 /* Author - Chandan Parameswaraiah*/
public class RobotMovement {

	// Number of rows
	static int m;

	// Number of columns
	static int n;

	// Grid of 4*4 matrix
	static int grid[][];

	public static int getNumPaths(int i, int j) {

		// If row is less than 0 or max number of rows return 0;
		if (i < 0 || i >= m) {
			return 0;
		}

		// If column is less than 0 or max number of columns return 0;
		if (j < 0 || j >= n) {
			return 0;
		}

		// If the cell in the grid is already visited then return 0;
		if (grid[i][j] == 1) {
			return 0;
		}

		// If destination cell then path is found and return 1
		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		int val = 0;

		// Mark the current as visited
		grid[i][j] = 1;

		// Get all path from its surrounding cells
		val += getNumPaths(i - 1, j);
		val += getNumPaths(i + 1, j);
		val += getNumPaths(i, j - 1);
		val += getNumPaths(i, j + 1);

		// Unmark the current cell so that it is selected again in another path
		grid[i][j] = 0;

		return val;
	}

	public static void main(String[] args) {

		m = 4;
		n = 4;
		grid = new int[m][n];
		int numPaths = getNumPaths(0, 0);
		System.out.println(numPaths);
	}
}
