import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Robert, Beerman, Lewis and Chase
 * @version 5.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
    	Position startPos = new Position();
    	Position endPos = new Position();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();
        
        Maze labyrinth = new Maze(filename);
        
        System.out.println(labyrinth);
        
        MazeSolver solver = new MazeSolver(labyrinth);
        
        System.out.println("Enter the starting position (two integers separated by a comma): ");
        
        // Get and validate start position input. Must be a position that's in bounds and contains a '1'
        boolean validStart = false;
        while (!validStart) {
        	String startPosInput = scan.nextLine();
        	String[] startPosPair = startPosInput.split(",\\s*");
        	
        	validStart = labyrinth.validPosition(Integer.parseInt(startPosPair[0]), Integer.parseInt(startPosPair[1]));
        	
        	if (validStart) {
        		startPos.setx(Integer.parseInt(startPosPair[0]));
        		startPos.sety(Integer.parseInt(startPosPair[1]));
        	} else {
        		System.out.println("Not a valid start position. Position must be within bounds and contain a '1'");
        	}
        }
                
        System.out.println("Enter the end position (two integers separated by a comma): ");
        
        // Get and validate end position input. Must be a position that's in bounds and contains a '1'
        boolean validEnd = false;
        while (!validEnd) {
        	String endPosInput = scan.nextLine();
        	String[] endPosPair = endPosInput.split(",\\s*");
        	
        	validEnd = labyrinth.validPosition(Integer.parseInt(endPosPair[0]), Integer.parseInt(endPosPair[1]));
        	
        	if (validEnd) {
        		endPos.setx(Integer.parseInt(endPosPair[0]));
        		endPos.sety(Integer.parseInt(endPosPair[1]));
        	} else {
        		System.out.println("Not a valid end position. Position must be within bounds and contain a '1'");
        	}
        	
        }
        
        scan.close();
        
        // Print the results to the screen. Only print the path if the maze could
        // be traversed successfully
        if (solver.traverse(startPos, endPos)) {
            System.out.println("The maze was successfully traversed!");
            System.out.println(labyrinth);
            solver.printPath();
        } else {
            System.out.println("There is no possible path.");
            System.out.println(labyrinth);
        }
    }
}
