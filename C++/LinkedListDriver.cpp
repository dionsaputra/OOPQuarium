#include "LinkedList.hpp"
#include "ObjekMati.hpp"
#include "MakananIkan.hpp"
#include "Koin.hpp"
#include "Point.hpp"
int main(){
    int n;
    MakananIkan mi1;
    MakananIkan mi2(6);
    MakananIkan mi3(8);
    Koin k1(4,Point(3,4));
    Koin k2(7,Point(1,4));
    //cout<<mi2.getPosisi().getAbsis();
    LinkedList<ObjekMati*> L_Objek_Mati;
    L_Objek_Mati.add(&mi1);
    L_Objek_Mati.add(&mi2);
    L_Objek_Mati.add(&mi3);
    L_Objek_Mati.add(&k1);
    L_Objek_Mati.add(&k2);
    
    ObjekMati* ObjMati;
    L_Objek_Mati.remove(&k1);
    n = L_Objek_Mati.totalElmt();
    for(int i=0;i<n;i++){
        ObjMati = L_Objek_Mati.get(i);
        if(ObjMati->getJenis() == "Makanan Ikan"){
            MakananIkan* pmi = (MakananIkan*) ObjMati;
            cout<<"Harga makanan : "<<pmi->getPosisi().getAbsis()<<endl;
        }
        else{// if (ObjMati->getJenis() == "Koin")
            Koin* pk = (Koin*) ObjMati;
            cout<<"Nilai Koin "<<pk->getNilaiKoin()<<endl;
        }
    }
    cout<<L_Objek_Mati.find(&mi3)<<endl;

    /*
    LinkedList<Point> L1;
    L1.add(Point(5,3));
    L1.add(Point(3,2));
    L1.add(Point(3,2));
    for(int i=0;i<L1.totalElmt();i++){
        cout<<"Point "<<i<<" "<<L1.get(i).getAbsis()<<" "<<L1.get(i).getOrdinat()<<endl;
    }
    for(int i=0;i<L1.totalElmt();i++){
        L1.get(i).geser(2,3);
    }
    cout<<endl;
    for(int i=0;i<L1.totalElmt();i++){
        cout<<"Point "<<i<<" "<<L1.get(i).getAbsis()<<" "<<L1.get(i).getOrdinat()<<endl;
    }
    cout<<endl;*/
}