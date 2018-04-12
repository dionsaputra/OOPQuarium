#ifndef KOIN_HPP
#define KOIN_HPP
#include "ObjekMati.hpp"

class Aquarium;

class Koin : public ObjekMati{
public:
	//ctor userdefine
	Koin(int newNilaiKoin, Point newPosisi);

	//getter
	int getNilaiKoin();

	//setter
	void setNilaiKoin(int newNilaiKoin);

private:
	int nilaiKoin;
};
#endif
