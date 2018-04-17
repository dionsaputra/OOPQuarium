public class Fish{
    private final double PI = 3.14159265;
    private final int MAX_STARVING;
    private final int MAX_STARVATION_PERIOD;
    private final int MAX_MOVE_TIME;
    private static int counter = 0;
    private final int id;
    private boolean right_direct;
    private int starvation_period;
    private int speed;
    private int starving;
    private int move_timer;
    private int harga;
    private int degree;
    private Point posisi;
    private String jenis;

    public abstract void eat(Aquarium aquarium);
    public abstract void produce(Aquarium aquarium);
    public abstract int getProduceTime();
    public abstract int getMaxProduceTime();
    public abstract void setProduceTime(int _produce_time);
        
    public void swimto(Point _posisi, int _speed){
        Point temp = this.getPosisi();
        double rad = atan2(x.getOrdinat() - temp.getOrdinat(),
                            x.getAbsis() - temp.getAbsis());
        int deg = (rad * 180) /PI;
        swim(deg,speed);
    }
    public void swim(int _degree, int _speed){
        double rad = (double) degree * PI / 180.0;
        Point temp = getPosisi();
        double absis_new = temp.getAbsis()+(speed*cos(rad)*((MAX_MOVE_TIME)-getMoveTime())/15);
        double ordinat_new = temp.getOrdinat()+(speed*sin(rad)*(MAX_MOVE_TIME-getMoveTime())/15); 
        if(absis_new<temp.getAbsis()){
            right_direct=false;
        } else{
            right_direct=true;
        }
        double absis = absis_new;
        double ordinat = ordinat_new;

        if (absis <= 30) absis = 30;
        if (absis >= 870) absis = 870;
        if (ordinat <= 50) ordinat = 50;
        if (ordinat >= 600) ordinat = 600;

        temp.setAbsis(absis);
        temp.setOrdinat(ordinat);

        setPosisi(temp);
    }

    //Change Direction
    public void change_direction(){
        right_direct = !right_direct;
    }
    //Cek lapar
    public boolean isStarving(){
        return starvation_period <= 0;
    }
    //Cek arah
    public boolean isFaceRight(){
        return right_direct;
    }

    //Setter Getter
    public int getMoveTime(){
        return move_timer;
    }
    public int getID(){
        return id;
    }
    public Point getPosisi(){
        return posisi;
    }
    public int getStarvationPeriod(){
        return starvation_period;
    }
    public int getSpeed(){
        return speed;
    }
    public int getHarga(){
        return harga;
    }
    public int getStarving(){
        return starving;   
    }
    public int getDegree(){
        return degrees;
    }
    public int getMAXMOVE(){
        return MAX_MOVE_TIME;
    }
    public double getRadius(){
        return radius;
    }
    public String getJenis(){
        return jenis;
    }

    public void setDegree(int _degree){
        degree = _degree;
    }
    public void setMoveTime(int _move_timer){
        move_timer = _move_timer;
    }
    public void setHarga(int _harga){  
        harga = _harga;
    }
    public void setRadius(double _radius){
        radius = _radius;
    }
    public void setJenis(String _jenis){
        jenis = _jenis;
    }
    public void setPosisi(Point _posisi){
        posisi = _posisi;
    }
    public void setStarvationPeriod(int _starvation_period){
        starvation_period = _starvation_period
    }
    public void setStarving(int _starving){
 		starving = _starving;										
    }
}