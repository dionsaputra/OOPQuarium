#include <bits/stdc++.h>
#include "ObjekMati.hpp"
using namespace std;

const int speed = 10;

int main(){

    // check ctor user-define
    ObjekMati objekMati1(speed);
    ObjekMati objekMati2(speed);
    
    // check operator overloading
    if (objekMati1 == objekMati2){
        cout<<"objekMati1 == objekMati2"<<endl;  
    } else {
        cout<<"objekMati1 != objekMati2"<<endl;
    }
    
    if (objekMati1 != objekMati2){
        cout<<"objekMati1 != objekMati2"<<endl;  
    } else {
        cout<<"objekMati1 == objekMati2"<<endl;
    }

    // check getter id
    cout<<"ID objekMati1 = "<<objekMati1.getId()<<endl;
    cout<<"ID objekMati2 = "<<objekMati2.getId()<<endl;

    // check getter jenis
    cout<<"Jenis objekMati1 = "<<objekMati1.getJenis()<<endl;
    cout<<"Jenis objekMati2 = "<<objekMati2.getJenis()<<endl;

    // check getter posisi
    Point point1 = objekMati1.getPosisi();
    Point point2 = objekMati2.getPosisi();
    cout<<"Objek Mati 1 pada = ("<<point1.getAbsis()<<","<<point1.getOrdinat()<<")"<<endl;
    cout<<"Objek Mati 2 pada = ("<<point2.getAbsis()<<","<<point2.getOrdinat()<<")"<<endl;

    // check getter speed
    cout<<"Speed objekMati1 = "<<objekMati1.getSpeed()<<endl;
    cout<<"Speed objekMati2 = "<<objekMati2.getSpeed()<<endl;

    // check setter id
    objekMati1.setId(3);
    cout<<"ID objekMati1 = "<<objekMati1.getId()<<endl;

    // check setter jenis
    objekMati1.setJenis("Koin");
    cout<<"Jenis objekMati1 = "<<objekMati1.getJenis()<<endl;

    // check setter Posisi
    Point point3(2,2);
    objekMati1.setPosisi(point3);
    point1 = objekMati1.getPosisi();
    cout<<"Objek Mati 1 pada = ("<<point1.getAbsis()<<","<<point1.getOrdinat()<<")"<<endl;
    
    // check setter jenis
    objekMati1.setSpeed(20);
    cout<<"Speed objekMati1 = "<<objekMati1.getSpeed()<<endl;
}