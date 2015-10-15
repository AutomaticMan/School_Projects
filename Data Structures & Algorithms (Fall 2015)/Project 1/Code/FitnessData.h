/*
 * FitnessData.h
 *
 *  Created on: Aug 29, 2015
 *      Author: John Gardiner
 *      Header file for FitnessData class.  Contains data and actions pertaining to the fitness information of a particular
 *      individual.  Data is received from file input, then stored into arrays in free store.  Memory is deallocated by
 *      destructor.
 */
#include <string>
#include <iostream>
#include <fstream>
#include <chrono>
#include <omp.h>

using namespace std;

#ifndef FITNESSDATA_H_
#define FITNESSDATA_H_

struct Performance
{
	int nSwaps;
	int nComparisons;
	double time;
};

class FitnessData
{
	private:
		string name;
		int* originalData;
		int* data;
		int dataSize;
		bool sorted;
		void reloadData();
		void mergeSort(int, int);
		Performance pMergeSort(int, int, int);
		void pMerge(int, int, int, int&, int&);
		void merge(int, int, int);
	public:
		FitnessData(string);
		~FitnessData();
		Performance PerformanceInfo;
		string getName();
		int getSize();
		void insertionSort();
		void mergeSort();
		void pMergeSort();
		int select(string);
		double average();
		double pAverage();
};
#endif /* FITNESSDATA_H_ */
