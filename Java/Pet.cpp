#include "Pet.hpp"
#include "Point.hpp"
#include "Aquarium.hpp"
#include <bits/stdc++.h>
using namespace std;

// atribute static
int Pet::counter = 0;

// ctor default
Pet::Pet() : posisi(){
    radius = 0;
    kecepatan = 0;
    id = counter++;
    face = true;
    totalMoney = 0;
}

// ctor user-defined
Pet::Pet(double _radius,double _kecepatan,Point _posisi) : posisi(_posisi.getAbsis(),_posisi.getOrdinat()){
    radius = _radius;
    kecepatan = _kecepatan;
    id = counter++;
    face = true;
    totalMoney = 0;
}

int Pet::getTotalMoney(){
  return totalMoney;
}

void Pet::setTotalMoney(int money){
  totalMoney = money;
}

bool Pet::getFace(){
  return face;
}

void Pet::setFace(bool face){
    this->face = face;
}

// getter posisi
Point Pet::getPosisi() const{
    return posisi;
}

// setter posisi
void Pet::setPosisi(const Point& _posisi){
    posisi = _posisi;
}

// getter radius
double Pet::getRadius() const{
    return radius;
}

// setter radius
void Pet::setRadius(double _radius){
    radius = _radius;
}

// getter kecepatan
double Pet::getKecepatan() const{
    return kecepatan;
}

// setter kecepatan
void Pet::setKecepatan(double _kecepatan){
    kecepatan = _kecepatan;
}

// getter ID
int Pet::getID(){
    return id;
}

void Pet::WalkTo(Point goal){
  double dx = this->getKecepatan();
  face = true;

  if (goal.getAbsis() < posisi.getAbsis()){
    dx = -1.0*dx;
    face = false;
  } else if (goal.getAbsis() == posisi.getAbsis()){
    dx = 0;
  }

  Point point = this->getPosisi();
  point.setAbsis(this->getPosisi().getAbsis() + dx);
  this->setPosisi(point);
}

void Pet::printInfo(){
  cout<<"("<<posisi.getAbsis()<<","<<posisi.getOrdinat()<<") + ";
  cout<<radius<<" + ";
  cout<<kecepatan<<" + ";
  cout<<id<<endl;
}

void Pet::eat(Aquarium& aq){
  bool existCoin = false;
  int i=0;
  while (i < aq.getListObjekMati().totalElmt() &&  !existCoin){
    if (aq.getListObjekMati().get(i)->getJenis() == "Koin"){
      existCoin = true;
    } else {
      i++;
    }
  }

  if (existCoin){
    int i=0;
    bool existCoinOnGround = false;
    while (i < aq.getListObjekMati().totalElmt() && !existCoinOnGround){
      if (aq.getListObjekMati().get(i)->getJenis() == "Koin" && aq.getListObjekMati().get(i)->isDasar(aq)){
        existCoinOnGround = true;
      } else {
        i++;
      }
    }

    if (existCoinOnGround){
      double nearestHorizontally = aq.getWidth() + 1000000;
      int idx;
      for (int i=0; i<aq.getListObjekMati().totalElmt(); i++){
        bool isKoin  = aq.getListObjekMati().get(i)->getJenis() == "Koin";
        bool isDasar = aq.getListObjekMati().get(i)->isDasar(aq);
        bool isLower = getPosisi().hitungJarak(aq.getListObjekMati().get(i)->getPosisi()) < nearestHorizontally;
        if (isKoin && isDasar && isLower){
          nearestHorizontally = getPosisi().hitungJarak(aq.getListObjekMati().get(i)->getPosisi());
          idx = i;
        }
      }

      if (radius >= nearestHorizontally){
        Koin *koin = (Koin *) aq.getListObjekMati().get(idx);
        setTotalMoney(getTotalMoney() + koin->getNilaiKoin());
        aq.RemoveObject(aq.getListObjekMati().get(idx));
      } else {
        Point nearestHorizontalPos(aq.getListObjekMati().get(idx)->getPosisi().getAbsis(),aq.getLength());
        WalkTo(nearestHorizontalPos);
      }

    } else {
      double nearestVertically = aq.getLength() + 1000000;
      int idx;
      for (int i=0; i<aq.getListObjekMati().totalElmt(); i++){
        bool isKoin  = aq.getListObjekMati().get(i)->getJenis() == "Koin";
        bool isLower = aq.getLength() - aq.getListObjekMati().get(i)->getPosisi().getOrdinat() < nearestVertically;
        if (isKoin && isLower){
          nearestVertically = aq.getLength() - aq.getListObjekMati().get(i)->getPosisi().getOrdinat();
          idx = i;
        }
      }

      if (radius >= nearestVertically){
        Koin *koin = (Koin *) aq.getListObjekMati().get(idx);
        setTotalMoney(getTotalMoney() + koin->getNilaiKoin());
        aq.RemoveObject(aq.getListObjekMati().get(idx));
      } else {
        Point nearestHorizontalPos(aq.getListObjekMati().get(idx)->getPosisi().getAbsis(),aq.getLength());
        WalkTo(nearestHorizontalPos);
      }
    }
  }
}
