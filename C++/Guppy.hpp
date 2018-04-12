#ifndef GUPPY_HPP
#define GUPPY_HPP
#include "Fish.hpp"
#include "Koin.hpp"

class Aquarium;
class Guppy : public Fish{
	private :
		int growth_step;  // Sekarang ada di step berapa
		int produce_time; //periode mencetak koin
		int food_capacity; //periode ikan tumbuh ke tahap selanjutnya
		const int growth_timer; // setelah makan 6 kali
		const int produce_timer; //setelah 10 iterasi

	public :
		//constructor
		// setID, position etc.
		Guppy();

		//called if starving == 0
		void eat(Aquarium&);

		//Produce when produce time == 0
		void produce(Aquarium&);

		//Growing
		void Next_Growth();

		//Getter Setter
		int getGrowthStep();
		int getFoodCapaty();
		int getProduceTime();
		int getMaxProduceTime();
		void setProduceTime(int);
		void setFoodCapacity(int);
		
};

#endif
