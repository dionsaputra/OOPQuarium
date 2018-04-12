#include "Pet.hpp"
#include "Point.hpp"
#include <bits/stdc++.h>
using namespace std;

int main(){
    // test ctor default
    Pet pet1;                 

    // test ctor user-define
    Point posisiPet2(5,5);      
    double radiusPet2 = 1;
    double kecepatanPet2 = 2;
    Pet pet2(radiusPet2,kecepatanPet2,posisiPet2);      

    // test getter posisi
    cout<<"Posisi pet 1 = ("<<pet1.getPosisi().getAbsis()<<","<<pet1.getPosisi().getOrdinat()<<")\n";

    // test setter posisi
    Point newPosisiPet1(3,3);
    pet1.setPosisi(newPosisiPet1);
    cout<<"Posisi pet 1 = ("<<pet1.getPosisi().getAbsis()<<","<<pet1.getPosisi().getOrdinat()<<")\n";

    // test getter radius
    cout<<"Radius pet 2 = "<<pet2.getRadius()<<endl;

    // test setter radius
    pet2.setRadius(2);
    cout<<"Radius pet 2 = "<<pet2.getRadius()<<endl;

    // test getter kecepatan
    cout<<"Kecepatan pet 2 = "<<pet2.getKecepatan()<<endl;

    // test setter kecepatan
    pet2.setKecepatan(3);
    cout<<"Kecepatan pet 2 = "<<pet2.getKecepatan()<<endl;

    // test getter id
    cout<<"ID pet 1 = "<<pet1.getID()<<endl;
    cout<<"ID pet 2 = "<<pet2.getID()<<endl;

    
}