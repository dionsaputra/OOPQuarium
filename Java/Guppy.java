public class Guppy {
    private int growth_step;
    private int food_capacity;
    private int produce_time
    private int growth_timer;
    private int produce_timer;

	public void Guppy(){
		MAX_STARVING = 500;
		MAX_STARVATION_PERIOD = 200;
		MAX_MOVE_TIME = 50;
		growth_timer = 6;
		produce_timer = 100;
		id = counter++;
		speed  = 1;
		harga = 50;
		growth_step = 1;
		food_capacity = 0;
		right_direct = false;
		degrees = 90;
		radius = 20;
		jenis = "Guppy";
		setStarvationPeriod(MAX_STARVATION_PERIOD);
		setStarving(MAX_STARVING);
		setMoveTime(MAX_MOVE_TIME);
		setProduceTime(getMaxProduceTime());
	}

	public void eat(Aquarium aquarium){
		boolean existFood = false;
		boolean eat_food = false;
		double rad_min = 1e7; //untuk nyimpen jarak terdekat
	  	int i=0,idx;
	  	Point idx_guppy = getPosisi();
	  	Point point_kejar;
	  	while (i < aq.getListObjekMati().totalElmt()){
		    if (aq.getListObjekMati().get(i).getJenis() == "Makanan Ikan"){
		    	existFood = true;
		    	Point point_makanan = aq.getListObjekMati().get(i).getPosisi();
		    	double jarak = idx_guppy.hitungJarak(point_makanan);
		    	if(jarak < rad_min){
		    		rad_min = jarak;
		    		idx = i;
		    		point_kejar = point_makanan;
		    	}
		    }
		    i++;
	  	}
	  	// Cek mau dimakan atau dikejar
	  	if(existFood){
	  		if(rad_min <= getRadius()){
	  			eat_food = true;
	  		}
	  		else{
	  			swimto(point_kejar, getSpeed());
				setStarving(getStarving()-1);
	  		}
	  	}

		// Makan makanan
		if(eat_food){
			//printf("makan\n");

			food_capacity = food_capacity + 1;
			//If its a time to growth
			if(food_capacity >= growth_timer){ //next growth
				food_capacity = 0;
				if(growth_step<3){
					growth_step++;
					harga+=harga;
				}
			}
			//Update hungry time
			//real_eat
			setStarvationPeriod(MAX_STARVATION_PERIOD);
			setStarving(MAX_STARVING);
			//ilangin makanan ikan
			aq.RemoveObject(aq.getListObjekMati().get(idx));
		}
		else{
			setStarving(getStarving()-1);
		}
	}

	public void produce(Aquarium aquarium){
		Koin koin = new Koin(50*growth_step,getPosisi());
		aq.AddObject(koin);
	}

	//Growing
	public void Next_Growth(){
		growth_step = growth_step + 1;
	}

	//Getter Setter
	public int getGrowthStep(){
		return growth_step;
	}
	public int getFoodCapaty(){
		return food_capacity;
	}
	public int getProduceTime(){
		return produce_time;
	}
	public int getID(){
		return id;
	}

	public getMaxProduceTime(){
		return produce_timer;
	}

	public void setFoodCapacity(int x){
		food_capacity = x;
	}

	public void setProduceTime(int x){
		produce_time = x;
	}

}