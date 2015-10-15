% Programmer: John Gardiner
% Date: 2/16/2015
% Assignment: Lab 2

% Database for Part 3.
trans(unus,one).    
trans(duo,two).    
trans(tres,three).    
trans(quattuor,four).    
trans(quinque,five).    
trans(sex,six).    
trans(septem,seven).    
trans(octo,eight).    
trans(novem,nine).    
trans(decem,ten).

% Part 1- inc/2 holds when its second arguement is one larger than its first.
inc(X, Y) :- Z is (X + 1), Y = Z.

% Part 2- addone/2 receives a list of numbers and returns another list of numbers
% the same as the first, but with 1 added to each number.
addone([], []).
addone([Head|Tail], [Z|TailReturned]) :- Z is Head + 1, addone(Tail, TailReturned). 

% Part 3- Receive a list of numbers from Latin to english.  Returns englist numbers
% is a list.
translate([],[]).
translate([Head|Tail], [Z|TailReturned]) :- trans(Head, Z), translate(Tail, TailReturned).
