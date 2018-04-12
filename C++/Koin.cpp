#include "Koin.hpp"

const double KSpeed = 1;        // kecepatan koin
const int minNilaiKoin = 15;   // harga minimum koin
const int maxNilaiKoin = 30;   // harga maksimum koin

Koin::Koin(int newNilaiKoin, Point newPosisi) : ObjekMati(KSpeed){
  nilaiKoin = newNilaiKoin;
  jenis = "Koin";
  ObjekMati::setPosisi(newPosisi);
}

//getter
int Koin::getNilaiKoin(){
  return nilaiKoin;
}

void Koin::setNilaiKoin(int newNilaiKoin){
  nilaiKoin = newNilaiKoin;
}
