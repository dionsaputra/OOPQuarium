#ifndef AQUARIUM_HPP
#define AQUARIUM_HPP

#include "LinkedList.hpp"
#include "Point.hpp"
#include "ObjekMati.hpp"
#include "Pet.hpp"
#include "Fish.hpp"
#include "Koin.hpp"
#include "MakananIkan.hpp"
#include "Piranha.hpp"
#include "Guppy.hpp"

/*cara compile : g++ -o app Aquarium.hpp Point.hpp MakananIkan.hpp ObjekMati.hpp Koin.hpp Pet.hpp LinkedList.hpp Fish.hpp Guppy.hpp Piranha.hpp*/
class Aquarium{
    public:
        //ctor
        Aquarium();
        //ctor with set the LENGTH and WIDTH
        Aquarium(int,int);
        //ctor with LENGTH and WIDTH and defined list
        Aquarium(int,int,const LinkedList<ObjekMati*>&, const LinkedList<Fish*>&, const LinkedList<Pet*>&);

        //dtor
        ~Aquarium();

        //add an object to list
        void AddObject(Fish*);
        void AddObject(ObjekMati*);
        void AddObject(Pet*);

        //remove an object from list
        void RemoveObject(Fish*);
        void RemoveObject(ObjekMati*);
        void RemoveObject(Pet*);

        LinkedList<ObjekMati*>& getListObjekMati();
        LinkedList<Fish*>& getListIkan();
        LinkedList<Pet*>& getListPet();
        int getLength();
        int getWidth();
        int getTime();
        //Make all of the instances in the do something
        void Action();

        //Check whether a point is an edge or not
        int IsEdge(Point& P, double radius);
    protected:
        //LENGTH : ATAS - BAWAH
        //WIDTH : KIRI - KANAN
        const int LENGTH;
        const int WIDTH;
        int time;
        LinkedList<ObjekMati*> List_Objek_Mati;
        LinkedList<Fish*> List_Ikan;
        LinkedList<Pet*> List_Pet;
};

#endif
