#ifndef PIRANHA_HPP
#define PIRANHA_HPP
#include "Fish.hpp"
#include "Koin.hpp"
#include "Point.hpp"
class Aquarium;
class Piranha : public Fish{
	private :
		int latest_food;

	public :
		//constructor
		//setID, position, starvation period etc.
		Piranha();	
		//calls when starving == 0
		void eat(Aquarium&);
		void produce(Aquarium&);
		int getProduceTime();
		int getMaxProduceTime();
		void setProduceTime(int);

		//setter getter
		int getLast();
		void setLast(int);
};

#endif
