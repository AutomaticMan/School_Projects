/**********************************************************************************************************************
 * Programmer: John Gardiner
 * main.cpp is the driver program for project 1.  A new FitnessData object is created, then used to complete various
 * searching and sorting operations using FitnessData's member functions.  A state machine, which is controlled by
 * commands issued through standard input, handles task management for the program.
 *********************************************************************************************************************/
#include <sstream>
#include "FitnessData.h"

enum State {
	WAITING, START, END, INSERTION_SORT, MERGE_SORT, P_MERGE_SORT, SELECT, AVERAGE, P_AVERAGE, EXIT, PRINT, INVALID };

//parseState converts string input into a state enum.  If input is invalid, then the state is returned as INVALID.
//Parameters: string
//Returns: State
State parseState(string input){
	State state = INVALID;
	if(input == "Start")
		state = START;
	else if(input == "End")
		state = END;
	else if(input == "InsertionSort")
		state = INSERTION_SORT;
	else if(input == "MergeSort")
		state = MERGE_SORT;
	else if(input == "ParallelMergeSort")
		state = P_MERGE_SORT;
	else if(input == "Select")
		state = SELECT;
	else if(input == "Average")
		state = AVERAGE;
	else if(input == "ParallelAverage")
		state = P_AVERAGE;
	else if(input == "Exit")
		state = EXIT;
	else if(input == "Print")
		state = PRINT;
	return state;
}

//Launching point for program.  A loop and switch statement make up the implementation of the state machine, which
//manages operations performed by the program through user input.  All standard I/O is handled in main.
int main() {
	//Local variables to control state machine and store program data
	State state = WAITING;
	string inputParameter;
	FitnessData* data = NULL;
	bool running = true;
	//Loop will run as long as running is set to true
	while(running){
		switch(state) {
		    //Wait for user input the change state to execute user request.  If an is argument included with user input, then
		    //store it in inputParameter
			case WAITING:{
				string line;
				getline(cin, line);
				//User input read into string, then stringstream splits string into component parts.  This is done to ensure
				//program transitions smoothly in both input cases (instruction only and instruction and argument).
				stringstream ss(line);
				ss >> line;
				ss >> inputParameter;
				state = parseState(line);
				break;
			}
			//Initialize new data object based off user's input.  If file fails to open, then an error message is
			//displayed (not part of requirements).
			case START:
				try {
					data = new FitnessData(inputParameter);
					cout << "Processing fitness data of: " << data->getName() << '\n';
				}
				catch (const char* msg) {
					cout << msg << '\n';
				}
				state = WAITING;
				break;
			//When finished with data, deallocate memory, then set data pointer to NULL.
			case END:
				cout << "End of processing fitness data for: " << data->getName() << '\n';
				delete data;
				data = NULL;
				state = WAITING;
				break;
			//Perform insertion sort on current data, then display the performance statistics that are read from data object
			case INSERTION_SORT:
				data->insertionSort();
				cout << "Number of comparisons made by insertion sort: " << data->PerformanceInfo.nComparisons << '\n';
				cout << "Number of swaps made by insertion sort: " << data->PerformanceInfo.nSwaps << '\n';
				cout << "Time to run insertion sort (ms): " << data->PerformanceInfo.time << '\n';
				state = WAITING;
				break;
			//Merge sort to be implemented
			case MERGE_SORT:
				data->mergeSort();
				cout << "Number of comparisons made by merge sort: " << data->PerformanceInfo.nComparisons << '\n';
				cout << "Number of swaps made by merge sort: " << data->PerformanceInfo.nSwaps << '\n';
				cout << "Time to run merge sort (ms): " << data->PerformanceInfo.time << '\n';
				state = WAITING;
				break;
			//Parallel merge sort to be implemented
			case P_MERGE_SORT:
				data->pMergeSort();
				cout << "Number of comparisons made by parallel merge sort: " << data->PerformanceInfo.nComparisons << '\n';
				cout << "Number of swaps made by parallel merge sort: " << data->PerformanceInfo.nSwaps << '\n';
				cout << "Time to run parallel merge sort (ms): " << data->PerformanceInfo.time << '\n';
				state = WAITING;
				break;
			//Select data from a sorted array and display performance statistics.  If array is unsorted, display error
			//message.
			case SELECT:
				try {
					cout << "Selecting item: " <<  data->select(inputParameter) << '\n';
					cout << "Time to run selection (ms): " << data->PerformanceInfo.time << '\n';
				}
				catch (const char* msg) {
					cout << msg << '\n';
				}
				state = WAITING;
				break;
			//Determine average value of data and display performance statistics.
			case AVERAGE:
				cout << "Average number of steps: " << data->average() << '\n';
				cout << "Time to run the average (ms): " << data->PerformanceInfo.time << '\n';
				state = WAITING;
				break;
			//Parallel average to be implemented
			case P_AVERAGE:
				cout << "Average number of steps: " << data->pAverage() << '\n';
				cout << "Time to run the parallel average (ms): " << data->PerformanceInfo.time << '\n';
				state = WAITING;
				break;
			//Prints all data in array.  Not in specifications, used for testing.
			case PRINT:
				//data->pAverage();
				//cout << data->PerformanceInfo.time << '\n';
				//state = WAITING;
				for(int i = 1; i <= data->getSize(); i++) {
					cout << data->select(to_string(i)) << "\n";
				}
				state = WAITING;
				break;
			//Terminate state machine by setting running = false
			case EXIT:
				cout << "Program terminating. \n";
				running = false;
				break;
			//Should input ever be invalid, just wait for another command
			default:
				state = WAITING;
				break;
		}
	}
}
