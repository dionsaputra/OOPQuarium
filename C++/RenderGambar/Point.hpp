
#ifndef Point_HPP
#define Point_HPP
#include <iostream>
using namespace std;

class Point{
public:
	//ctor defult, absis = 0, ordinat = 0;
	Point(); 

	//ctor user define, absis = newAbsis, ordinat = newOrdinat
	Point(int newAbsis,int newOrdinat);

	//getter
	int getAbsis();
	int getOrdinat();

	//setter
	void setAbsis(int newAbsis);
	void setOrdinat(int newOrdinat);

	//geser titik arah horizontal deltaX dan arah vertikal deltaY
	void geser(int deltaX, int deltaY);

	//hitung jarak antara this point dengan other point
	int hitungJarak(const Point& other);
	
private:
	int absis;
	int ordinat;
};

#endif