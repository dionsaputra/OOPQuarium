#include "Fish.hpp"
#include "Aquarium.hpp"
#include <cmath>
#define PI 3.14159265

//Abstract Base Class

//Berenang ke suatu titik (to_x,to_y) dengan kecepatan sebesar speed
void Fish :: swimto(Point x, int speed){
	Point temp = getPosisi();
	double rad = atan2(x.getOrdinat() - temp.getOrdinat() ,
					x.getAbsis() - temp.getAbsis());
	int deg = (rad * 180) /PI;
	swim(deg,speed);
}

void Fish :: swim(int degree, int speed){
	double rad = (double) degree * PI / 180.0;
	Point temp = getPosisi();
	double absis_new = temp.getAbsis()+(speed*cos(rad)*((MAX_MOVE_TIME)-getMoveTime())/15);
	double ordinat_new = temp.getOrdinat()+(speed*sin(rad)*(MAX_MOVE_TIME-getMoveTime())/15); 
	if(absis_new<temp.getAbsis()){
		right_direct=false;
	} else{
		right_direct=true;
	}
	double absis = absis_new;
	double ordinat = ordinat_new;

	if (absis <= 30) absis = 30;
	if (absis >= 870) absis = 870;
	if (ordinat <= 50) ordinat = 50;
	if (ordinat >= 600) ordinat = 600;

	temp.setAbsis(absis);
	temp.setOrdinat(ordinat);

	setPosisi(temp);
}

//Change Direction
void Fish :: change_direction(){
	right_direct = !right_direct;
}

//Cek lapar
bool Fish :: isStarving(){
	return starvation_period <= 0;
}

//Cek arah
bool Fish :: isFaceRight(){
	return right_direct;
}

//Setter Getter
int Fish :: getMoveTime(){
	return move_timer;
}
int Fish :: getID(){
	return id;
}
Point Fish :: getPosisi(){
	return posisi;
}
int Fish :: getStarvationPeriod(){
	return starvation_period;
}
int Fish :: getSpeed(){
	return speed;
}
int Fish :: getStarving(){
	return starving;
}
int Fish :: getDegree(){
	return degrees;
}
double Fish :: getRadius(){
	return radius;
}
string Fish :: getJenis(){
	return jenis;
}
int Fish :: getHarga(){
	return harga;
}
int Fish :: getMAXMOVE(){
	return MAX_MOVE_TIME;
}
void Fish :: setMoveTime(int move_time){
	move_timer = move_time;
}
void Fish :: setRadius(double x){
	radius = x;
}
void Fish :: setJenis(string s){
	jenis = s;
}
void Fish :: setPosisi(Point x){
	posisi = x;
}

void Fish::setStarvationPeriod(int newStarvationPeriod){
	starvation_period = newStarvationPeriod;
}

void Fish :: setStarving(int new_starving){
	starving = new_starving;
}

void Fish :: setHarga(int harga){
	this->harga = harga;
}
void Fish :: setDegree(int deg){
	degrees = deg;
}
