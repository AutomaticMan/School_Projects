OBJS = main.o FitnessData.o
CC = g++
CFLAGS = -std=c++11 -fopenmp -Wall -c
LFLAGS = -fopenmp -Wall

all : p1 clean

p1 : $(OBJS)
	$(CC) $(LFLAGS) $(OBJS) -o p1

main.o : main.cpp FitnessData.h
	$(CC) $(CFLAGS) main.cpp

FitnessData.o : FitnessData.h FitnessData.cpp
	$(CC) $(CFLAGS) FitnessData.cpp

clean:
	rm -f *o