/**************************************************************************************************
John  Gardiner
Pointers and arrays lab.
CSC240
**************************************************************************************************/
#include <iostream>
using namespace std;

const int SIZE = 10;
const int data[SIZE * SIZE] = 
	{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 
	  0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 
	  1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 
	  1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 
	  1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 
	  1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 
	  1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 
	  1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 
	  0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 
	  0, 0, 1, 1, 1, 1, 1, 0, 0, 0 };

void printRowIndex(const int **grid);
void printRowPtr(const int **grid);
void invertColors(int* grid);
void slideRight(int* grid);
void flipHorizontal(int* grid);
void applyTransformation(int **grid, void(*trans)(int*));
void fillGrid(int **grid);
void deleteGrid(int **grid);

// Testing code
int main(){

	int **grid = new int*[SIZE];

	fillGrid(grid);

	// Print the picture
	cout << "Original using indices:" << endl;
	printRowIndex((const int**)grid);
	cout << endl;

	// Print the picture
	cout << "Original using a pointer:" << endl;
	printRowPtr((const int**)grid);
	cout << endl;

	// Apply invertColors & display
	// using the applyTransformation() function
	cout << "After inverting colors:" << endl;
	applyTransformation(grid, invertColors);
	printRowPtr((const int**)grid);
	cout << endl;

	// Apply slideRight & display
	// using the applyTransformation() function
	cout << "After sliding right:" << endl;
	applyTransformation(grid, slideRight);
	printRowPtr((const int**)grid);
	cout << endl;

	// Apply horizontalFlip & display
	// using the applyTransformation() function
	cout << "After horizontal flip:" << endl;
	applyTransformation(grid, flipHorizontal);
	printRowPtr((const int**)grid);
	cout << endl;

	deleteGrid(grid);

	system("pause");
}

// REQUIRES: there are at least size elements in row[]
// EFFECTS:  For each element of row (in sequence):
//             if that element is a 0, prints out "  " to cout
//             if that element is a 1, prints out "# " to cout
//             (note the extra space after each)
//           DOES NOT print any newlines
void printRowIndex(const int **grid)
{
	int i, j;
	for (i = 0; i < SIZE; i++)
	{
		for (j = 0; j < SIZE; j++)
			if (grid[i][j] == 1)
				cout << "# ";
			else
				cout << "  ";
		cout << endl;
	}
}

// REQUIRES: row points to an array with at least size elements
// EFFECTS:  For each element of row (in sequence):
//             if that element is a 0, prints out "  " to cout
//             if that element is a 1, prints out "# " to cout
//             (note the extra space after each)
//           DOES NOT print any newlines
void printRowPtr(const int **grid)
{
	const int **i;
	int *j;
	for (i = grid; i < grid + SIZE; i++)
	{
		for (j = (int*)*i; j < *i + SIZE; j++)
			if (*j == 1)
				cout << "# ";
			else
				cout << "  ";
		cout << endl;
	}
}

/***** TASK 2 *****/

// REQUIRES: row points to an array with at least size elements
// EFFECTS: all elements in row that are 1 are switched to 0
//          all elements in; row that are 0 are switched to 1
void invertColors(int *row)
{
	int *i;
	for (i = row; i < row + SIZE; i++)
		*i = !*i;
}

// REQUIRES: row points to an array with at least size elements
// EFFECTS: all elements are "shifted" right by one unit
//          for example, [0,1,1,0,1,1,1,1,0,1]
//          would become [1,0,1,1,0,1,1,1,1,0]
void slideRight(int* row)
{
	int *i, temp = *(row + SIZE - 1);
	for (i = row + SIZE - 1; i > row; i--)
		*i = *(i - 1);
	*row = temp;
}

// REQUIRES: row points to an array with at least size elements
// EFFECTS: the order of elements in row is reversed
//          for example, [0,1,1,0,1,1,1,1,0,1]
//          would become [1,0,1,1,1,1,0,1,1,0]
void flipHorizontal(int* row)
{
	int temp, *i;
	for (i = row; i < row + (SIZE / 2); i++)
	{
		temp = *i;
		*i = *(row + SIZE - (i - row) - 1);
		*(row + SIZE - (i - row) - 1) = temp;
	}

}

// REQUIRES: grid is a pointer to the start of a "2D array"
//
// EFFECTS:  Applies the transformation specified by trans()
//           to each row in the grid
void applyTransformation(int **grid, void(*trans)(int*))
{
	int **i;
	for (i = grid; i < grid + SIZE; i++)
		(*trans)(*i);
}

void fillGrid(int **grid)
{
	int **i, *j;
	for (i = grid; i < grid + SIZE; i++)
	{
		*i = new int[SIZE];
		for (j = (int*)*i; j < *i + SIZE; j++)
			*j = data[(i - grid) * 10 + j - *i];
	}
}

void deleteGrid(int **grid)
{
	int **i;
	for (i = grid; i < grid + SIZE; i++)
		delete *i;

	delete grid;
}