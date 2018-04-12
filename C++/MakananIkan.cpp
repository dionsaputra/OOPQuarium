#include <bits/stdc++.h>
#include "MakananIkan.hpp"
#include "Aquarium.hpp"

const int MISpeed = 1;       // kecepatan jatuh makanan ikan
const int minMIPrice = 20;   // harga minimum makanan ikan
const int maxMIPrice = 50;   // harga maksimum makanan ikan
const double topScreen = 100;

// ctor default
MakananIkan::MakananIkan() : ObjekMati(MISpeed){
    price = rand() % (maxMIPrice - minMIPrice + 1) + minMIPrice;    // random harga makanan ikan dari minMIPrice - maxMIPrice
    jenis = "Makanan Ikan";
}

// ctor user-define
MakananIkan::MakananIkan(double absis): ObjekMati(MISpeed){
    price = rand() % (maxMIPrice - minMIPrice + 1) + minMIPrice;    // random harga makanan ikan dari minMIPrice - maxMIPrice
    jenis = "Makanan Ikan";
    Point posisi(absis,topScreen);                                  // posisi akan mulai dijatuhkan makanan
    setPosisi(posisi);
}

// getter price
double MakananIkan::getPrice(){
    return price;
}

// setter price
void MakananIkan::setPrice(double newPrice){
    price = newPrice;
}
