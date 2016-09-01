/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 * 
 * @author Robert Beerman, Ruben Acuna
 * @version 1.0
 */
public class BeermanMatrix implements Matrix {
	int[][] matrix;
		
    public BeermanMatrix(int[][] data) {
    	if (data.length > 0) {
    		matrix = new int[data.length][data[0].length];
    		
    		for (int r=0; r<data.length; r++) {
    			for (int c=0; c<data[0].length; c++) {
    				matrix[r][c] = data[r][c];
    			}
    		}
    	} else {
    		matrix = new int[0][0];
    	}
	}
	
	public int getElement(int y, int x) {
		return matrix[y][x];
	}
	
	public int getRows() {
		return matrix.length;
	}
	
	public int getColumns() {
		if (matrix.length > 0) {
			return matrix[0].length;
		} else {
			return 0;
		}
	}
	
	public Matrix scale(int scalar) {
		// Instantiate a new matrix to pass back, rather than changing the original
		Matrix scaledMatrix;
		int[][] scaledArray = new int[matrix.length][matrix[0].length];
		
		for (int r=0; r<scaledArray.length; r++ ) {
			for (int c=0; c<scaledArray[r].length; c++) {
				scaledArray[r][c] = scalar * matrix[r][c];
			}
		}
		
		scaledMatrix = new BeermanMatrix(scaledArray);
		
		return scaledMatrix;
	}
	
	public Matrix plus(Matrix other) {
		// Instantiate a new matrix to pass back, rather than changing the original
		Matrix sumMatrix;
		
		if (other.getRows() == matrix.length && other.getColumns() == matrix[0].length) {
			int[][] sumArrays = new int[matrix.length][matrix[0].length];
			for (int r=0; r<sumArrays.length; r++) {
				for (int c=0; c<sumArrays[0].length; c++) {
					sumArrays[r][c] = matrix[r][c] + other.getElement(r, c);
				}
			}
			
			sumMatrix = new BeermanMatrix(sumArrays);
		} else {
			throw new DimensionMismatchException();
		}
		
		return sumMatrix;
	}
	
	public Matrix minus(Matrix other) {
		// Instantiate a new matrix to pass back, rather than changing the original
		Matrix subMatrix;
		
		if (other.getRows() == matrix.length && other.getColumns() == matrix[0].length) {
			int[][] sumArrays = new int[matrix.length][matrix[0].length];
			for (int r=0; r<sumArrays.length; r++) {
				for (int c=0; c<sumArrays[0].length; c++) {
					sumArrays[r][c] = matrix[r][c] - other.getElement(r, c);
				}
			}
			
			subMatrix = new BeermanMatrix(sumArrays);
		} else {
			throw new DimensionMismatchException();
		}
		
		return subMatrix;
	}
	
	@Override
	public boolean equals(Object other) {
		Matrix newOther;
		// Have to cast the passed object to BeermanMatrix, if it is a BeermanMatrix
		if (other instanceof BeermanMatrix) {
			newOther = (BeermanMatrix)other;
		} else {
			return false;
		}

		// Compare each element in the matrices, only if they are of the same dimensions
		if (newOther.getRows() == matrix.length && newOther.getColumns() == matrix[0].length) {
			for (int r=0; r<matrix.length; r++) {
				for (int c=0; c<matrix[0].length; c++) {
					if (newOther.getElement(r, c) != matrix[r][c]) {
						return false;
					}
				}
			}
		} else {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		String output = "";
		
		for (int r=0; r<matrix.length; r++) {
			for (int c=0; c<matrix[0].length; c++) {
				output += matrix[r][c] + " ";
			}
			output += "\n";
		}
		
		return output;
	}
	
	/**
	 * Custom exception thrown when trying to add or subtract two matrices
	 * of differing dimension
	 */
	@SuppressWarnings("serial")
	public class DimensionMismatchException extends RuntimeException {
		public DimensionMismatchException() {
			super("Matrix dimensions must be identical.");
		}
	}
    
    /**
     * Entry point for matrix testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        
        Matrix m1 = new BeermanMatrix(data1);
        Matrix m2 = new BeermanMatrix(data2);
        Matrix m3 = new BeermanMatrix(data3);
        
        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());
        
        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        
        //test operations (valid)
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));
        
        //test operations (invalid)
        //System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }
}