#ifndef OBJEKMATI_HPP
#define OBJEKMATI_HPP
#include "Point.hpp"
class Aquarium;
class ObjekMati{
public:
	//ctor user define. set speed ObjekMati
	ObjekMati(double newSpeed);

	bool operator == (const ObjekMati& other);
	bool operator != (const ObjekMati& other);

	//getter
	int getId();
	string getJenis();
	Point getPosisi();
	double getSpeed();

	//setter
	void setId(int newId);
	void setJenis(string newJenis);
	void setPosisi(Point newPosisi);
	void setSpeed(double newSpeed);

	//cek apakah ObjekMati sudah berada di dasar.
	bool isDasar(Aquarium& aq);

	//turun sejauh 1 detik perjalanan ObjekMati. Jika belum sampai di dasar, turun sejauh 1 point
	//jika sudah sampai di dasar, ubah kecepatan menjadi 0. Status hilang di override kelas turunan
	void turun(Aquarium& aq);

protected:
	static int counter;
	int id;
	string jenis;
	Point posisi;
	double speed;
};

#endif
