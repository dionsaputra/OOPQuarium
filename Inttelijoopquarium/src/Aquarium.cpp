#include "Aquarium.hpp"
#include "Fish.hpp"
#include "ObjekMati.hpp"
#include "Pet.hpp"
#include <bits/stdc++.h>
using namespace std;

#define DEBUG_START cout<<"DEBUG_START\n";
#define DEBUG_END   cout<<"DEBUG_END\n";

//ctor
Aquarium::Aquarium():LENGTH(100),WIDTH(100){
}
//ctor with set the LENGTH and WIDTH
Aquarium::Aquarium(int length,int width):LENGTH(length),WIDTH(width){
}

//ctor with LENGTH and WIDTH and defined list
Aquarium::Aquarium(int length,int width,const LinkedList<ObjekMati*>& ListObjekMati,
 const LinkedList<Fish*>& ListIkan, const LinkedList<Pet*>& ListPet):LENGTH(length),WIDTH(width){
     List_Objek_Mati = ListObjekMati;
     List_Ikan = ListIkan;
     List_Pet = ListPet;
}
//dtor
Aquarium::~Aquarium(){
    delete[] &List_Objek_Mati;
    delete[] &List_Ikan;
    delete[] &List_Pet;
}

//add an object to list
void Aquarium::AddObject(Fish* fish){
    List_Ikan.add(fish);
}
void Aquarium::AddObject(ObjekMati* objekMati){
    List_Objek_Mati.add(objekMati);
}
void Aquarium::AddObject(Pet* pet){
    List_Pet.add(pet);
}

//remove an object from list
void Aquarium::RemoveObject(Fish* fish){
    List_Ikan.remove(fish);
}

void Aquarium::RemoveObject(ObjekMati* objekMati){
    List_Objek_Mati.remove(objekMati);
}
void Aquarium::RemoveObject(Pet* pet){
    List_Pet.remove(pet);
}

//Make all of the instances in the do something
void Aquarium::Action(){
    for(int i=0;i<List_Ikan.totalElmt();i++){
        Fish *temp = List_Ikan.get(i);
        if(temp->getStarving()<=0){
            this->RemoveObject(List_Ikan.get(i));
        }
        else{
            int count=0,countguppy=0;
            for(int j=0;j<List_Objek_Mati.totalElmt();j++){
                if(List_Objek_Mati.get(j)->getJenis()=="Makanan Ikan"){
                    count++;
                }
            }
            for(int j=0;j<List_Ikan.totalElmt();j++){
                if(List_Ikan.get(j)->getJenis()=="Guppy"){
                    countguppy++;
                }
            }
            if(temp->getJenis()=="Guppy"){
                if(temp->getStarvationPeriod() > 0 || count==0){
                    temp->setStarvationPeriod(temp->getStarvationPeriod()-1);
                    if(temp->getMoveTime()<=0){
                        //srand(time(NULL));
                        int randoms = (rand() % 40);
                        cout<<randoms<<" haha\n";
                        int directions = (rand()%2);
                        if(directions){
                            randoms*=-1;
                        }
                        temp->setDegree((temp->getDegree()+randoms)%360);
                        temp->setMoveTime(temp->getMAXMOVE());
                    }
                    temp->swim(temp->getDegree(),temp->getSpeed());
                    temp->setStarving(temp->getStarving()-1);
                }
                else{
                    temp->eat(*this);
                }
            }
            else{
                if(temp->getStarvationPeriod() > 0 || countguppy==0){
                    temp->setStarvationPeriod(temp->getStarvationPeriod()-1);
                    if(temp->getMoveTime()<=0){
                        //srand(time(NULL));
                        int randoms = (rand() % 360);

                        int directions = (rand()%2);
                        if(directions){
                            randoms*=-1;
                        }
                        cout<<randoms<<" haha\n";
                        temp->setDegree((temp->getDegree()+randoms)%360);
                        temp->setMoveTime(temp->getMAXMOVE());
                    }
                    temp->swim(temp->getDegree(),temp->getSpeed());
                    temp->setStarving(temp->getStarving()-1);
                }
                else{
                    temp->eat(*this);
                }
            }
            temp->setMoveTime(temp->getMoveTime()-1);

            //produce
            if(temp->getJenis() == "Guppy"){
                if(temp->getProduceTime() < 0){
                    temp->produce(*this);
                    temp->setProduceTime(temp->getMaxProduceTime());
                }
                //cout<<temp->getProduceTime()<<" ampun\n";
                temp->setProduceTime(temp->getProduceTime()-1);
            }
        }
    }
    for(int i=0;i<List_Pet.totalElmt();i++){
        List_Pet.get(i)->eat(*this);
        //cout<<"EAT TELAH DIJALANKAN\n";
    }
    for(int i=0;i<List_Objek_Mati.totalElmt();i++){
        List_Objek_Mati.get(i)->turun(*this);
    }
}

//Check whether a point is an edge or not in a radius
//RETURN :
//0 Not Edge 1 UP      2 RIGHT     3 DOWN      4 LEFT
int Aquarium::IsEdge(Point& P, double radius){
    if(abs(P.getOrdinat() - WIDTH) < radius){
        return 2;
    }
    else if(P.getOrdinat() < radius){
        return 4;
    }
    else if(abs(P.getAbsis() - LENGTH) < radius){
        return 1;
    }
    else if(P.getAbsis() < radius){
        return 3;
    }
    else{
        return 0;
    }
}
LinkedList<ObjekMati*>& Aquarium::getListObjekMati(){return List_Objek_Mati;}
LinkedList<Fish*>& Aquarium::getListIkan(){return List_Ikan;}
LinkedList<Pet*>& Aquarium::getListPet(){return List_Pet;}
int Aquarium::getLength(){return LENGTH;}
int Aquarium::getWidth(){return WIDTH;}
int Aquarium::getTime(){return time;}
