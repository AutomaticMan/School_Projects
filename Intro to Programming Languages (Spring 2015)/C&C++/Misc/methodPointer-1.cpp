// John Gardiner
#include <iostream>
using namespace std;

// The four arithmetic operations ... one of these functions is selected 
// at runtime with a switch and a function pointer 
double plus1    (double a, double b) { return a+b; } 
double minus1   (double a, double b) { return a-b; } 
double multiply (double a, double b) { return a*b; } 
double divide   (double a, double b) { return a/b; }  

double calc(double a, double b, double (*op)(double, double)) 
{
	return (*op)(a, b);
}
		
int main() {
	double a;  
	double b;  
	char opCode;
	double result = 0;

	cout << "Enter a : ";  
	cin >> a;    
	cout << "Enter operator (+, -, *, / ) : ";    
	cin >> opCode;
	cout << "Enter b : ";  
	cin >> b;

	// execute the appropriate operation by calling calc()       
	switch(opCode)       
	{          
		case '+' : 
			result =  calc( a, b, plus1); 
			break;  
        case '-': 
			result = calc(a, b, minus1); 
			break;
		case '*': 
			result = calc(a, b, multiply); 
			break;
		case '/': 
			result = calc(a, b, divide); 
			break;
	}

	cout << a << opCode << b << " = " << result;
	system("pause");
}