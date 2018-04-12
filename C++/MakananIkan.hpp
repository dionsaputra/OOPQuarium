#ifndef MAKANANIKAN_HPP
#define MAKANANIKAN_HPP
#include "ObjekMati.hpp"
#include "Point.hpp"

class Aquarium;

class MakananIkan: public ObjekMati {
public:

	MakananIkan();					//ctor default
	MakananIkan(double absis);		//ctor user define
	double getPrice();				//getter atribut price
	void setPrice(double newPrice);				//setter atribut price

private:
	double price;
};

#endif
