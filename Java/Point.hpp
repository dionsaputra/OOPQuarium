#ifndef Point_HPP
#define Point_HPP
#include <iostream>
using namespace std;

class Point{
public:
	//ctor defult, absis = 0, ordinat = 0;
	Point(); 

	//ctor user define, absis = newAbsis, ordinat = newOrdinat
	Point(double newAbsis,double newOrdinat);

	//getter
	double getAbsis();
	double getOrdinat();

	//setter
	void setAbsis(double newAbsis);
	void setOrdinat(double newOrdinat);

	//geser titik arah horizontal deltaX dan arah vertikal deltaY
	void geser(double deltaX, double deltaY);

	//hitung jarak antara this point dengan other point
	double hitungJarak(const Point& other);
	
	void PrintInfo();
private:
	double absis;
	double ordinat;
};

#endif