public class Piranha{
    private int latest_food;
    public Piranha(){
        MAX_STARVING = 500;
        MAX_STARVATION_PERIOD = 200;
        MAX_MOVE_TIME = 70;
        speed  = 2;
        latest_food = 0;
        right_direct = false;
        degrees = 30;
        radius = 20;
        jenis = "Piranha";
        setStarvationPeriod(MAX_STARVATION_PERIOD);
        setStarving(MAX_STARVING);
        setMoveTime(MAX_MOVE_TIME);
    }
    public void eat(Aquarium aquarium){
        bool existFood = false;
        bool eat_food = false;
        double rad_min = 1e7;
        int i=0,idx;
        Point idx_piranha = getPosisi();
        Point point_kejar;
        while (i < aq.getListIkan().totalElmt()){
            if (aq.getListIkan().get(i).getJenis() == "Guppy"){
                existFood = true;
                Point point_makanan = aq.getListIkan().get(i).getPosisi();
                double jarak = idx_piranha.hitungJarak(point_makanan);
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

        // Makan guppy
        if(eat_food){
            //Update hungry time
            setStarvationPeriod(MAX_STARVATION_PERIOD);
            setStarving(MAX_STARVING);
            //ilangin guppy
            Guppy temp = aq.getListIkan().get(idx);
            setLast(temp.getHarga()*(temp.getGrowthStep()+1)); //untuk makan
            aq.RemoveObject(aq.getListIkan().get(idx));
            produce(aq);
        }
        else{
            setStarving(getStarving()-1);
        }
    }
    public void produce(Aquarium aquarium){
        Koin koin = new Koin(getLast(),getPosisi());
        aq.AddObject(koin);
    }
    public int getProduceTime(){
        return 1;
    }
    public int getMaxProduceTime(){
        return 1;
    }
    public void setProduceTime(int _produce_time){
        // do nothing
    }
    public int getLast(){
        return latest_food;
    }
    public void setLast(int _latest_food){
        latest_food = _latest_food;
    }
}