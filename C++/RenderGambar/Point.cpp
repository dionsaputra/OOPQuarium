#include "Point.hpp"
#include <bits/stdc++.h>
using namespace std;
	
Point::Point(){             //ctor defult, absis = 0, ordinat = 0;
    absis = 0; 
    ordinat = 0;
}

//ctor user define
Point::Point(int newAbsis,int newOrdinat){
    absis = newAbsis;
    ordinat = newOrdinat;
}

//getter
int Point::getAbsis(){
    return absis;
}
int Point::getOrdinat(){
    return ordinat;
}

//setter
void Point::setAbsis(int newAbsis){
    absis = newAbsis;
}
void Point::setOrdinat(int newOrdinat){
    ordinat = newOrdinat;
}

void Point::geser(int deltaX, int deltaY){
    absis += deltaX;
    ordinat += deltaY;
}

int Point::hitungJarak(const Point& other){
    int dx = other.absis - absis;
    int dy = other.ordinat - ordinat;
    return sqrt(dx*dx + dy*dy);
}