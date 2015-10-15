// Name: John Gardiner
// Date: Sept 30 2014
// Assignment: Project 1 Part 2
//
// The segment class contains two Point objects that represent a 
// line segment on a Cartesian plane.  Included are methods for 
// finding length, midpoint, and slope.

public class Segment implements SegmentInterface
{
	// Constants for default constructor
	private static final int X1_DEFAULT = 0, Y1_DEFAULT = 0, 
			X2_DEFAULT = 4, Y2_DEFAULT = 4;
	
	/**
	 * Data Variables
	 * You should have two Points that hold endpoints of the segment.
	 * These must NOT be public!
	 */
	protected Point pointOne, pointTwo;

	// Default constructor
	public Segment()
	{
		this(X1_DEFAULT, Y1_DEFAULT, X2_DEFAULT, Y2_DEFAULT);
	}
	
	// Parameterized constructor that accepts four integers
	public Segment(int x1, int y1, int x2, int y2)
	{
		if(x1 == x2 && y1 == y2)
			invalid();
			
		pointOne = new Point(x1, y1);
		pointTwo = new Point(x2, y2);
	}
	
	// Parameterized constructor that accepts two points
	public Segment(Point p1, Point p2)
	{
		if(p1.equals(p2))
			invalid();
		
		pointOne = new Point(p1);
		pointTwo = new Point(p2);
	}
	
	// Copy constructor
	public Segment(Segment s)
	{
		// Pass on reference.  Let Segment(Point, Point) handle deep copy
		this(s.pointOne, s.pointTwo);
	}
	
	// invalid handles errors generated during input for the class
	protected void invalid()
	{
		throw new IllegalArgumentException("Error: Invalid "+ getClass().getName() +" Segment. ");
	}

    /**
	 * The length method returns the length of the Segment.
	 */
    public double length()
    {
    	return pointOne.distanceTo(pointTwo);
    }
    
    /**
	 * The translate method returns nothing and should translate, or shift,
	 * itself (the Segment) by the distances passed in.  So if a Segment s has Points
	 * (0,0)---(1,1), s.translate(5,2) will cause p to change to (5, 2)---(6, 3)
	 */
    public void translate( int xMove, int yMove )
    {
    	pointOne.translate(xMove, yMove);
    	pointTwo.translate(xMove, yMove);
    }
    
    /**
	 * The midpoint method calculates and returns the midpoint of the Segment as a new Point.
	 */
    public Point midpoint()
    {
    	return pointOne.halfwayTo(pointTwo);
    }
    
    /**
	 * The slope method returns the slope of the Segment as a double.   If the segment
	 * is vertical, the slope is undefined.  In that case, Java will return
	 * Double.POSITIVE_INFINITY or Double.NEGATIVE_INFINITY, depending on which way you
	 * subtract to calculate the slope.   You can either check for division by zero or
	 * let Java do the calculation.  However, your requirements are to ALWAYS return
	 * Double.POSITIVE_INFINITY if the slope is undefined.
	 *
	 * Also, strangely enough, Java may return 0 or -0 for a slope which is horizontal.
	 * Your requirements are to always return a slope of 0 for a horizontal line
	 * (don�t always just return the Java calculation).
	 */
    public double slope()
    {
    	int xDifference = pointTwo.xDistance(pointOne);
    	int yDifference = pointTwo.yDistance(pointOne);
    	
    	// If x1 = x2 then segment is vertical and slope is undefined, return Infinity
    	if(xDifference == 0)
    		return Double.POSITIVE_INFINITY;
    	// If y1 = y2 then segment is horizontal and slope is 0, return 0
    	if(yDifference == 0)
    		return 0;
    	// Else return slope
    	// Slope formula: m = (y2 - y1) / (x2 - x1)
    	return (double)yDifference / xDifference;
    }
    
    /**
	 * The isParallel method returns true/false depending on whether the current Segment
	 * is parallel to the Segment received.   Think about how you can tell if two segments
	 * are parallel.  Note: Two overlapping segments ARE parallel.
	 */
    public boolean isParallel( Segment s1 )
    {
    	// Two parallel lines will have the same slope
    	return this.slope() == s1.slope(); 
    }
    
    /**
	 * The shorten method changes its (the Segment's) endpoints so that they are both halfway
	 * to the midpoint. Example: The segment (0,0)---(12,16) has midpoint (6,8).  After
	 * calling the shorten method, the segment should be (3,4)---(9,12).  Each endpoint
	 * has moved in toward the midpoint (which stayed the same).  So (3,4) is halfway between
	 * (0,0) and (6,8) and (9,12) is halfway between (12,16) and (6,8).
	 */
    public void shorten()
    {
    	Point midpoint = new Point(pointOne.halfwayTo(pointTwo));
    	
    	// Find midpoint of each half segment
    	pointOne = pointOne.halfwayTo(midpoint);
    	pointTwo = midpoint.halfwayTo(pointTwo);
    	
    }
    
    /**
	 * The equals method should return true if the given object is equal to the
	 * the Object passed in.  Note that this method receives an Object; there is
	 * a particular way that this method should be implemented (see notes from class).
	 *
	 * Notice that two Segments are equal even if their endpoints are swapped
	 *	i.e.: (1, 2)---(3, 4) == (3, 4)---(1, 2)
	 */
    public boolean equals( Object otherObj )
    {
    	if(otherObj == null)
    		return false;
    	if(otherObj.getClass() != this.getClass()) 
    		return false;
    	
    	Segment s = (Segment)otherObj;
    	return pointOne.equals(s.pointOne) && pointTwo.equals(s.pointTwo) ||
    		pointOne.equals(s.pointTwo) && pointTwo.equals(s.pointOne);
    	
    }
    
    /**
	 * The toString() method returns a String representing the Segment.   This should be
	 * in the form: (x1, y1)---(x2, y2)
	 */
    public String toString()
    {
    	return pointOne + "---" + pointTwo;
    }
    
}
