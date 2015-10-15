/*************************************************************************************************
* 
* Name: John Gardiner
* Date: Sept 16 2014
* Assignments:  Project 1- Part 1 (Point class) 
* 
* The Point class defines objects as Cartesian coordinates (x, y) on a plane.  Included in the 
* class are methods for working with Point objects to calculate distance and midpoint, translate
* coordinates, and compare this Point object to another. 
* 
*************************************************************************************************/


public class Point implements PointInterface
{
    //You write the class details up here
    
    //Parameters for default constructor 
	private static final int DEFAULT_X = 0;
	private static final int DEFAULT_Y = 0;
	
	// Instance variables (fields)
	private int xCoord;
	private int yCoord;
	
	// Default constructor initializes fields based off DEFAULT_X, DEFAULT_Y
	Point()
	{
		this(DEFAULT_X, DEFAULT_Y);
	}
	
	// Parameterized constructor receives two integer values and initializes fields
	Point(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	// Copy constructor initializes fields based off the data from another Point object
	Point(Point otherPoint)
	{
		
		xCoord = otherPoint.xCoord;
		yCoord = otherPoint.yCoord;
	}
	
	public int xDistance(Point p)
	{
		return xCoord - p.xCoord;
	}
		
	public int yDistance(Point p)
	{
		return yCoord - p.yCoord;
	}
    
	// distanceTo receives a Point object and returns the distance between this Point and the input 
	// Point as a double
	public double distanceTo(Point otherPoint)
	{
		return Math.hypot((otherPoint.xCoord - xCoord), (otherPoint.yCoord - yCoord));	
	}
	
	// halfwayTo receives a Point object and returns a new Point object with coordinates halfway between this 
	// Point and the input Point.  Should the midpoint not equal an integer, then the next greatest integer 
	// [x] will be used
	public Point halfwayTo(Point otherPoint)
	{
        
        // Divide by 2.0 to cast integer value as double
        // Math.ceil returns the smallest integer greater than or equal to some double
		double newX = Math.ceil((xCoord + otherPoint.xCoord) / 2.0); 
		double newY = Math.ceil((yCoord + otherPoint.yCoord) / 2.0);
		
		return new Point((int)newX, (int)newY);
	}
	
	// translate receives two integer values corresponding to the x and y coordinates of this Point and adds those
	// values to the appropriate fields effectively shifting this Point to another point on the plane
	public void translate(int xMove, int yMove)
	{
		xCoord += xMove;
		yCoord += yMove;
	}
	
	// equals receives any object and returns true if and only if the input object is a Point with the same
	// coordinates as this Point object
	public boolean equals(Object object)
	{
		
		if(object == null || this.getClass() != object.getClass())
			return false;
		
		Point p = (Point)object;	
		
		if(xCoord == p.xCoord && yCoord == p.yCoord)
			return true;
		else
			return false;
	}
	

	// Returns string representation of this Point's coordinates
	public String toString()
	{
		return "(" + xCoord + ", " + yCoord + ")";
		
	}

    //I'm including the driver that will be used to test your code
    //You should NOT modify the main method at all.
    public static void main(String[] args)
    {
    }
}
