import java.util.*;

/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Robert Beerman, Lewis and Chase
 * @version 5.0
 */
public class MazeSolver
{
    private Maze maze;
    // moves deque keeps track of all moves, bad moves will be removed
    private LinkedList<Position> moves = new LinkedList<Position>();
    
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(Position pos, Position endPos)
    {
        boolean done = false;
        LinkedList<Position> stack = new LinkedList<Position>();
        
        stack.push(pos);
        //moves.push(pos);
        
        while (!(done) && !stack.isEmpty())
        {
            pos = stack.pop();
            maze.tryPosition(pos.getx(),pos.gety());  // this cell has been tried
            
            // add the position to the running move tracker only if it's not already there
            boolean found = false;
            for (Position position : moves) {
            	if (position.getx() == pos.getx() && position.gety() == pos.gety()) {
            		System.out.println("Found " + position.getx() + ", " + position.gety() + ". Not adding to moves");
            		found = true;
            	}
            }
            if (!found) {
            	moves.push(pos); //add position to move tracker
            }
            
            // if we've reached the end position, we're done
            if (pos.getx() == endPos.getx() && pos.gety() == endPos.gety())
                done = true;  // the maze is solved
            else
            {
                moves = push_new_pos(pos.getx() - 1,pos.gety(), stack, moves); 
                moves = push_new_pos(pos.getx() + 1,pos.gety(), stack, moves);
                moves = push_new_pos(pos.getx(),pos.gety() - 1, stack, moves);
                moves = push_new_pos(pos.getx(),pos.gety() + 1, stack, moves);
            }
            
            if (!done) {
            	while ((stack.size() > 0 && moves.size() > 0) && (stack.peek().getx() != moves.peek().getx() || stack.peek().gety() != moves.peek().gety())) {
            		moves.pop();
            	}
            }
        }
        
        return done;
    }
    
    /**
     * Push a new attempted move onto the stack.
     * @param x represents x coordinate
     * @param y represents y coordinate
     * @param stack the working stack of moves within the grid
     * @return moves deque that tracks moves on the successful path
     */
    private LinkedList<Position> push_new_pos(int x, int y, LinkedList<Position> stack, LinkedList<Position> moves2)
    {
        Position npos = new Position();
        npos.setx(x);
        npos.sety(y);
        
        if (maze.validPosition(x,y)) {
            stack.push(npos);
          	moves2.push(npos);
       }
        
        return moves2;
    }
    
    /**
     * Prints the positions from the successful path
     */
    public void printPath() {
    	LinkedList<Position> finalPath = new LinkedList<Position>();
    	Iterator<Position> iter = moves.iterator();
    	
    	while (iter.hasNext()) {
    		Position pos = iter.next();
    		boolean found = false;
    		
    		for (Position pathPosition : finalPath) {
    			if (pathPosition.getx() == pos.getx() && pathPosition.gety() == pos.gety()) {
    				found = true;
    			}
    		}
    		
    		if (!found && maze.getElement(pos.getx(), pos.gety()) == 2) {
    			System.out.println(pos.getx() + ", " + pos.gety());
    			finalPath.push(pos);
    		}
    	}
    }
    
}
