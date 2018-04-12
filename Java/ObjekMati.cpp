#include <bits/stdc++.h>
#include "ObjekMati.hpp"
#include "Point.hpp"
#include "Aquarium.hpp"

int ObjekMati::counter = 0;

ObjekMati::ObjekMati(double newSpeed) : posisi(){
    id = counter++;
    jenis = "undefine";
    speed = newSpeed;
}

bool ObjekMati::operator==(const ObjekMati& other){
    return id == other.id;
}

bool ObjekMati::operator!=(const ObjekMati& other){
    return id != other.id;
}

int ObjekMati::getId(){
    return id;
}

string ObjekMati::getJenis(){
    return jenis;
}

Point ObjekMati::getPosisi(){
    return posisi;
}

double ObjekMati::getSpeed(){
    return speed;
}

void ObjekMati::setId(int newId){
    id = newId;
}

void ObjekMati::setJenis(string newJenis){
    jenis = newJenis;
}

void ObjekMati::setPosisi(Point newPosisi){
    posisi = newPosisi;
}

void ObjekMati::setSpeed(double newSpeed){
    speed = newSpeed;
}

bool ObjekMati::isDasar(Aquarium& aq){
    return this->getPosisi().getOrdinat() >= 600;
}

void ObjekMati::turun(Aquarium& aq){
    if (!isDasar(aq)){
      Point point = this->getPosisi();
      point.setOrdinat(this->getPosisi().getOrdinat() + this->getSpeed());
      this->setPosisi(point);
    } else {
      if (this->getJenis() == "Makanan Ikan"){
        aq.RemoveObject(this);
      }
    }
}
