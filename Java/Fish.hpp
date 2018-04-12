#ifndef FISH_HPP
#define FISH_HPP
#include "Point.hpp"

class Aquarium;

//Abstract Base Class 
class Fish{
	protected :
		int MAX_STARVING; 				//setelah 3 akan mati
		int MAX_STARVATION_PERIOD; 		//setelah 10 akan lapar
		int MAX_MOVE_TIME;
		static int counter;				//buat nomorin ikan
		int id; 						//id ikan sekarang
		Point posisi; 
		bool right_direct; 				//arah kepala ikan sekarang
		int starvation_period; 			//waktu agar dia lapar. ketika == 0 maka ikan akan cari makan
		int speed;						//Kecepatan ikan
		int starving; 					//lama ikan bertahan hidup saat lapar . ketika == 0, ikan mati
		string jenis;					//Jenis ikan
		double radius;					//Radius makan
		int move_timer;					//Lama ikan bergerak ke suatu arah x
		int harga;
		int degrees;

	public :
	 	//if(temp->getJenis() == "Guppy"){ 
        //     Guppy g = (Guppy) List_Ikan.get(i);
        //     if(g.getProduceTime() <= 0){
        //         temp->produce(*this);
        //         g.setProduceTime(g.getMaxProduceTime());
        //     }
        //     g.setProduceTime(g.getProduceTime()+1);
        // } 
		//Berenang ke suatu titik (to_x,to_y) dengan kecepatan sebesar speed
		void swimto(Point, int speed);
		void swim(int,int);
		//eat makananan
		virtual void eat(Aquarium&) = 0; 
		virtual void produce(Aquarium&) = 0;
		virtual int getProduceTime() = 0;
		virtual int getMaxProduceTime() = 0;
		virtual void setProduceTime(int) = 0;
		
		//Change Direction
		void change_direction();
		//Cek lapar
		bool isStarving();

		//Cek arah
		bool isFaceRight();

		//Setter Getter
		int getMoveTime();
		int getID();
		Point getPosisi();
		int getStarvationPeriod();
		int getSpeed();
		int getHarga();
		int getStarving();
		int getDegree();
		int getMAXMOVE();
		double getRadius();
		string getJenis();

		void setDegree(int);
		void setMoveTime(int);
		void setHarga(int);
		void setRadius(double);
		void setJenis(string);
		void setPosisi(Point);
		void setStarvationPeriod(int);
		void setStarving(int);
};

#endif