#include "Point.hpp"
#include <bits/stdc++.h>
using namespace std;
	
Point::Point(){             //ctor defult, absis = 0, ordinat = 0;
    absis = 0; 
    ordinat = 0;
}

//ctor user define
Point::Point(double newAbsis,double newOrdinat){
    absis = newAbsis;
    ordinat = newOrdinat;
}

//getter
double Point::getAbsis(){
    return absis;
}
double Point::getOrdinat(){
    return ordinat;
}

//setter
void Point::setAbsis(double newAbsis){
    absis = newAbsis;
}
void Point::setOrdinat(double newOrdinat){
    ordinat = newOrdinat;
}

void Point::geser(double deltaX, double deltaY){
    absis += deltaX;
    ordinat += deltaY;
}

double Point::hitungJarak(const Point& other){
    double dx = other.absis - absis;
    double dy = other.ordinat - ordinat;
    return sqrt(dx*dx + dy*dy);
}

void Point::PrintInfo(){
    cout<<"Absis = "<<absis<<" "<<"Ordinat = "<<ordinat<<endl;
}