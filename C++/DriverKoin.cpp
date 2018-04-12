#include "Koin.hpp"
#include "Point.hpp"
#include <bits/stdc++.h>
using namespace std;

int main(){
  Point point1(1,3);
  Koin koin1(2,point1);                                 // test ctor user-define koin
  cout<<"Nilai koin = "<<koin1.getNilaiKoin()<<endl;    // test getter nilai koin

  koin1.setNilaiKoin(3);
  cout<<"Nilai koin = "<<koin1.getNilaiKoin()<<endl;    // test setter nilai koin
}
