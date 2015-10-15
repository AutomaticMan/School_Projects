/*
 * FitnessData.cpp
 *
 *  Created on: Aug 29, 2015
 *      Author: John Gardiner
 *      Code for FitnessData class.  Contains data and actions pertaining to the fitness information of a particular
 *      individual.  Data is received from file input, then stored into arrays in free store.  Memory is deallocated by
 *      the destructor.
 *      Updated: Sept 12, 2015
 *      Implemented mergeSort.  Implemented parallelMergeSort and parallelAverage
 */
#include "FitnessData.h"

//Initialize private fields and read data from input file into arrays.  One array will store input data in its original
//state so that it can be reloaded before certain operations.  If filename is invalid, then throw I/O exception.
//Parameters: string- name of individual whose fitness data should be loaded
FitnessData::FitnessData(string n) {
	sorted = false;
	name = n;
	ifstream infile((name + ".txt").c_str());
	if (infile.is_open()) {
		//The first value is the file is equal to the number of data items in the file
		infile >> dataSize;
		data = new int[dataSize];
		originalData = new int[dataSize];
		//All other data in the file will be stored into the arrays
		for(int i = 0; i < dataSize; i++) {
			infile >> originalData[i];
			data[i] = originalData[i];
		}
		//Close file
		infile.close();
	}
	else {
		//This should never happen!
		throw "Error reading file. ";
	}
}

//Accessor for private field name
string FitnessData::getName() {
	return name;
}

//Accessor for private field dataSize
int FitnessData::getSize() {
	return dataSize;
}

//Private helper method that will reset the original state of the object including performance data.
void FitnessData::reloadData() {
	PerformanceInfo.nSwaps = PerformanceInfo.nComparisons = PerformanceInfo.time = 0;
	for(int i = 0; i < dataSize; i++) {
		data[i] = originalData[i];
	}
	//Data is no longer sorted
	sorted = false;
}

//Serial merge sort implemented according to the algorithm presented in class.
//Receives: int p- index of first element, int r- index of last element, int threads- number of threads
void FitnessData::mergeSort(int p, int r){
	if(p < r) {
		int q = (p + r) / 2;
		mergeSort(p, q);
		mergeSort(q+1, r);
		merge(p,q,r);
	}
}

//Parallel merge sort uses OpenMP and sections to reduce the overall running time of merge sort.  In order
//to consistently log the correct number of swaps and comparisons (while operating in parallel), these values
//must be returned through the recursion as opposed to logged directly like in the serial version.
//Receives: int p- index of first element, int r- index of last element, int threads- number of threads
//			to execute on
//Returns: A struct containing the number of comparisons and swaps made during sorting.
Performance FitnessData::pMergeSort(int p, int r, int threads = 4) {
	Performance s1, s2;
	if(p < r) {
		int q = (p + r) / 2;
		//In order to improve running time, only a specific number of threads are created.
		if(threads > 1) {
			#pragma omp parallel num_threads(2)
			{
				#pragma omp sections
				{
					#pragma omp section
						s1 = pMergeSort(p, q, threads / 2);
					#pragma omp section
						s2 = pMergeSort(q+1, r, threads / 2);
				} //End of sections block
			} //End of parallel block
		}
		else {
			s1 = pMergeSort(p, q, 0);
			s2 = pMergeSort(q+1, r, 0);
		}
		//Combine performance data from the two recursive calls
		s1.nSwaps += s2.nSwaps;
		s1.nComparisons += s2.nComparisons;
		pMerge(p, q, r, s1.nSwaps, s1.nComparisons);
		//Return results
		return s1;
	}
	else {
		s1.nComparisons = 0;
		s1.nSwaps = 0;
		return s1;
	}
}

//Helper method for pMergeSort.  Should be called with an array who's elements are sorted into two
//subarrays where the partition of these two subarrays is indicated by q.  Differs from merge() in the
//way it logs swaps and comparisons.
//Receives: int p- index of first element, int q- index of middle element
//          int r- index of last element, int& swaps- a variable that stores swaps
//          int& comparisons- a variable that stores comparisons
void FitnessData::pMerge(int p, int q, int r, int& swaps, int& comparisons) {
	int a[r - p];
	int w = 0;
	for(int i = p; i <= r; i++) {
		a[w++] = data[i];
	}
	int i = 0, z = p, j = q - p + 1;
	while(i <= q - p && j <= r - p) {
		if(a[i] < a[j]) {
			data[z++] = a[i++];
			swaps++;
		}
		else {
			data[z++] = a[j++];
			swaps++;
		}
		comparisons++;
	}
    while (i <= q - p) {
        data[z++] = a[i++];
        swaps++;
    }
    while (j <= r - p) {
        data[z++] = a[j++];
        swaps++;
    }
}

//Helper method for mergeSort.  Should be called with an array who's elements are sorted into two
//subarrays; where the partition of these two subarrays is indicated by q.
//Receives: int p- index of first element, int q- index of middle element
//          int r- index of last element
void FitnessData::merge(int p, int q, int r) {
	int a[r - p];
	int w = 0;
	for(int i = p; i <= r; i++) {
		a[w++] = data[i];
	}
	int i = 0, z = p, j = q - p + 1;
	while(i <= q - p && j <= r - p) {
		if(a[i] < a[j]) {
			data[z++] = a[i++];
			PerformanceInfo.nSwaps++;
		}
		else {
			data[z++] = a[j++];
			PerformanceInfo.nSwaps++;
		}
		PerformanceInfo.nComparisons++;
	}
    while (i <= q - p) {
        data[z++] = a[i++];
        PerformanceInfo.nSwaps++;
    }
    while (j <= r - p) {
        data[z++] = a[j++];
        PerformanceInfo.nSwaps++;
    }
}

//Perform insertion sort according to algorithm from lecture.  Performance data such as number of swaps, number
//of comparisons, and running time are logged.
void FitnessData::insertionSort() {
	//Reset data before performing sort
	reloadData();
	int key;
	chrono::time_point<chrono::high_resolution_clock> start, end;
	start = chrono::high_resolution_clock::now();
	for(int i = 1; i < dataSize; i++) {
		key = data[i];
		int j = i - 1;
		while(j >= 0 && data[j] > key) {
			PerformanceInfo.nComparisons++;
			data[j + 1] = data[j];
			PerformanceInfo.nSwaps++;
			j--;
		}
		//Add 1 comparison for last comparison!
		PerformanceInfo.nComparisons++;
		data[j+1] = key;
	}
	end = chrono::high_resolution_clock::now();
	PerformanceInfo.time = (double)chrono::duration_cast<std::chrono::microseconds> (end-start).count() / 1000;
	//Array is now sorted
	sorted = true;
}

//Public version of parallel merge sort.  Calls private mergeSort() to do work.  Performance data such as number
//of number of swaps, number of comparisons, and running time are logged.
void FitnessData::mergeSort() {
	//Reset data before performing sort
	reloadData();
	chrono::time_point<chrono::high_resolution_clock> start, end;
	start = chrono::high_resolution_clock::now();
	mergeSort(0, dataSize - 1);
	end = chrono::high_resolution_clock::now();
	PerformanceInfo.time = (double)chrono::duration_cast<std::chrono::microseconds> (end-start).count() / 1000;
	//Array is now sorted
	sorted = true;
}

//Public version of parallel merge sort.  Calls private version to do work.  Performance data such as number of
//number of swaps, number of comparisons, and running time are logged.
void FitnessData::pMergeSort() {
	//Reset data before performing sort
	reloadData();
	chrono::time_point<chrono::high_resolution_clock> start, end;
	start = chrono::high_resolution_clock::now();
	PerformanceInfo = pMergeSort(0, dataSize - 1);
	end = chrono::high_resolution_clock::now();
	PerformanceInfo.time = (double)chrono::duration_cast<std::chrono::microseconds> (end-start).count() / 1000;
	//Array is now sorted
	sorted = true;
}

//Select will return the requested data item to the calling function.  Only a sorted array can be selected from, so
//an exception will be thrown if array is unsorted.  If k is out of bounds, throw exception.
//Parameters: string- data to be selected (min, max, median, k)
//Returns: int- selected data item
int FitnessData::select(string input) {
	//Reset performance data
	PerformanceInfo.nSwaps = PerformanceInfo.nComparisons = PerformanceInfo.time = 0;
	if(sorted) {
		chrono::time_point<chrono::high_resolution_clock> start, end;
		start = chrono::high_resolution_clock::now();
		if(input == "max") {
			return data[dataSize - 1];
		}
		else if(input == "min") {
			return data[0];
		}
		else if(input == "median") {
			if(dataSize % 2 == 0) {
				//Compute index of median value if data size is even.
				int dif = data[dataSize / 2] - data[dataSize / 2 - 1];
				return data[dataSize / 2 - 1] + dif / 2;
			}
			else {
				return data[dataSize / 2];
			}
		}
		else {
			//stoi() is an available function starting in c++11.  As a result, this program must be compiled using c++11.
			int index = stoi(input);
			if(index > 0 && index <= dataSize) {
				return data[index - 1];
			}
			else {
				throw "Index out of range. ";
			}
		}
		end = chrono::high_resolution_clock::now();
		PerformanceInfo.time = (double)chrono::duration_cast<chrono::microseconds> (end-start).count() / 1000;
	}
	else {
		throw "Unable to select from an unsorted array. ";
	}
}

//Computes average sequentially, and logs the running time.
//Return: double- mean value for all elements in the data array
double FitnessData::average() {
	//Reset performance data
	PerformanceInfo.nSwaps = PerformanceInfo.nComparisons = PerformanceInfo.time = 0;
	double avg = 0;
	chrono::time_point<chrono::high_resolution_clock> start, end;
	start = std::chrono::high_resolution_clock::now();
	for(int i = 0; i < dataSize; i++) {
		avg += (double)data[i] / dataSize;
	}
	end = chrono::high_resolution_clock::now();
	PerformanceInfo.time = (double)chrono::duration_cast<chrono::microseconds> (end-start).count() / 1000;
	return avg;
}

//Compute parallel average using OpenMP for and reduction.  Logs running time.
//Return: double- mean value for all elements in the data array
double FitnessData::pAverage() {
	//Reset performance data
	PerformanceInfo.nSwaps = PerformanceInfo.nComparisons = PerformanceInfo.time = 0;
	double avg = 0;
	int i;
	chrono::time_point<chrono::high_resolution_clock> start, end;
	start = std::chrono::high_resolution_clock::now();
	//Parallel reduction
	#pragma omp parallel for reduction(+:avg) num_threads(4)
	for( i = 0; i < dataSize; i++ ) {
		avg += (double)data[i] / dataSize;
	} //End of parallel reduction
	end = chrono::high_resolution_clock::now();
	PerformanceInfo.time = (double)chrono::duration_cast<chrono::microseconds> (end-start).count() / 1000;
	return avg;
}

//Destructor deallocates the two free-store arrays created in the constructor.
FitnessData::~FitnessData() {
	delete[] data;
	delete[] originalData;
}
