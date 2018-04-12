#include <bits/stdc++.h>
#include "Point.hpp"
using namespace std;

int main(){
    Point point1;         // check ctor default
    Point point2(1.2,2.3);   // check ctor user-define  

    // check getter
    cout<<"Point 1 = ("<<point1.getAbsis()<<","<<point1.getOrdinat()<<")"<<endl;
    cout<<"Point 2 = ("<<point2.getAbsis()<<","<<point2.getOrdinat()<<")"<<endl;

    // check setter
    point1.setAbsis(3.0);
    point1.setOrdinat(4.0);
    cout<<"Point 1 = ("<<point1.getAbsis()<<","<<point1.getOrdinat()<<")"<<endl;

    // check geser
    point2.geser(0.8,0.7);     // expect (2.0,3.0)
    cout<<"Point 2 = ("<<point2.getAbsis()<<","<<point2.getOrdinat()<<")"<<endl;

    // check hitungJarak. expect 1.41
    cout<<"Jarak Point 1 dan 2 = "<<point1.hitungJarak(point2)<<endl;
}   