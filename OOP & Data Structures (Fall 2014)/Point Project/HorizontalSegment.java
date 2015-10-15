// Name: John Gardiner
// Date: Sept 30 2014
// Assignment: Project 1 Part 2
//
// The Horizontal Segment class extends the Segment class and handles special cases of segments
// that have a slope of 0.

public class HorizontalSegment extends Segment implements HorizontalSegmentInterface
{
	private static final int X1_DEFAULT = 0, Y1_DEFAULT = 0, 
		X2_DEFAULT = 6, Y2_DEFAULT = 0;
	
    /**
	 * Constructors
	 * You should have at least four constructors:
	 *  1) A default constructor that will set the endpoints to new
	 *		Points with values (0,0) and (6,0)
	 *  2) A parameterized constructor that accepts (int x1, int y1, int x2, int y2)
	 *		and creates and sets the endpoints.  But first, check to see if x1 == x2
	 *		and y1== y2.  This would be a theoretical "Segment" of length 0 which
	 *		is not allowed, so throw a new IllegalArgumentException like this:
	 *			throw new IllegalArgumentException("whatever explanatory String you want");
	 *		Also, check to see if y1 != y2.  This would be a line segment that is not
	 *		horizontal, so throw a new IllegalArgumentException if this occurs.
	 *  3) A parameterized constructor that accepts (Point p1, Point p2) and sets both
	 *		the endpoints to a deep copy of the Points that are passed in.
	 *		Make sure to check to see if both Points are equal.  This would be a
	 *		theoretical "Segment" of length 0 which is not allowed, so throw a new
	 *		IllegalArgumentException.
	 * 		Also, check to see if the points form a horizontal segment.  If not, throw a
	 * 		new IllegalArgumentException if this occurs.
	 *  4) A copy constructor that accepts a HorizontalSegment and initializes the data
	 *		(of the new HorizontalSegment being created) to be the same as the
	 *		HorizontalSegment that was received. Make sure that it ends up being a deep
	 *		copy of the Segment that was passed in.
	 */

	// Default constructor
	public HorizontalSegment()
	{
		this(X1_DEFAULT, Y1_DEFAULT, X2_DEFAULT, Y2_DEFAULT);
	}
	
	// Parameterized constructor that accepts four integers.  Super() was not used here to prevent the creation of an invalid horizontal segment 
	// since we do not know how driver program will handle exception.
	public HorizontalSegment(int x1, int y1, int x2, int y2)
	{
		// Parenthesis added to clarify order of operations
		if((x1 == x2 && y1 == y2) || y1 != y2)
			invalid();
			
		pointOne = new Point(x1, y1);
		pointTwo = new Point(x2, y2);
	}
	
	// Parameterized constructor that accepts two points
	public HorizontalSegment(Point p1, Point p2)
	{
		if(p1.equals(p2) || p1.yDistance(p2) != 0)
			invalid();
		
		pointOne = new Point(p1);
		pointTwo = new Point(p2);
	}
	
	// Copy constructor
	public HorizontalSegment(Segment s)
	{
		// Pass on reference.  Segment(Point, Point) handle deep copy
		this(s.pointOne, s.pointTwo);
	}
}
