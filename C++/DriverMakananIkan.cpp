#include <bits/stdc++.h>
#include "MakananIkan.hpp"
using namespace std;

int main(){
    MakananIkan mi1;      // check ctor default
    MakananIkan mi2(6);   // check ctor user-define

    /*******************    CHECK FUNGSI INDUK    ******************/
    // check operator overloading
    if (mi1 == mi2){
        cout<<"mi1 == mi2"<<endl;  
    } else {
        cout<<"mi1 != mi2"<<endl;
    }
    
    if (mi1 != mi2){
        cout<<"mi1 != mi2"<<endl;  
    } else {
        cout<<"mi1 == mi2"<<endl;
    }

    // check getter id
    cout<<"ID mi1 = "<<mi1.getId()<<endl;
    cout<<"ID mi2 = "<<mi2.getId()<<endl;

    // check getter jenis
    cout<<"Jenis mi1 = "<<mi1.getJenis()<<endl;
    cout<<"Jenis mi2 = "<<mi2.getJenis()<<endl;

    // check getter posisi
    Point point1 = mi1.getPosisi();
    Point point2 = mi2.getPosisi();
    cout<<"Makanan Ikan 1 pada = ("<<point1.getAbsis()<<","<<point1.getOrdinat()<<")"<<endl;
    cout<<"Makanan Ikan 2 pada = ("<<point2.getAbsis()<<","<<point2.getOrdinat()<<")"<<endl;

    // check getter speed
    cout<<"Speed mi1 = "<<mi1.getSpeed()<<endl;
    cout<<"Speed mi2 = "<<mi2.getSpeed()<<endl;

    // check setter id
    mi1.setId(3);
    cout<<"ID mi1 = "<<mi1.getId()<<endl;

    // check setter jenis
    mi1.setJenis("Koin");
    cout<<"Jenis mi1 = "<<mi1.getJenis()<<endl;

    // check setter Posisi
    Point point3(2,2);
    mi1.setPosisi(point3);
    point1 = mi1.getPosisi();
    cout<<"Objek Mati 1 pada = ("<<point1.getAbsis()<<","<<point1.getOrdinat()<<")"<<endl;
    
    // check setter jenis
    mi1.setSpeed(20);
    cout<<"Speed mi1 = "<<mi1.getSpeed()<<endl;
    
    /*******************    CHECK FUNGSI INDUK    ******************/
    
    // check getter price
    cout<<"Price Makanan Ikan 1 = "<<mi1.getPrice()<<endl;       

    // check setter price
    mi1.setPrice(12);
    cout<<"Price Makanan Ikan 1 = "<<mi1.getPrice()<<endl;       
}