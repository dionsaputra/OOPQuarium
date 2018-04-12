#ifndef PET_HPP
#define PET_HPP
#include "Point.hpp"

class Aquarium;

class Pet{
private:
		int totalMoney;
		bool face; 											// FALSE: left, TRUE: right
		Point posisi;
    double radius;
    double kecepatan;
    static int counter;				      // buat nomorin ikan
    int id; 						            // id ikan sekarang
public:
    Pet();                          // ctor default
    Pet(double,double,Point);       // ctor user-defined

		int getTotalMoney();
		void setTotalMoney(int money);

		bool getFace();
		void setFace(bool);

    Point getPosisi() const;        // getter posisi
    void setPosisi(const Point&);   // setter posisi

    double getRadius() const;       // getter radius
    void setRadius(double);         // setter radius

    double getKecepatan() const;    // getter kecepatan
    void setKecepatan(double);      // setter kecepatan

    int getID();                    // getter id

    void WalkTo(Point);

		void printInfo();

		void eat(Aquarium& aq);
};

#endif
