public class Point {
    private int absis;
    private int ordinat;

    public Point(){
        absis = 0;
        ordinat = 0;
    }

    public Point(int _absis, int _ordinat){
        absis = _absis;
        ordinat = _ordinat;
    }

    public int getAbsis(){
        return absis;
    }

    public void setAbsis(int _absis){
        absis = _absis;
    }

    public int getOrdinat(){
        return ordinat;
    }

    public void setOrdinat(int _ordinat){
        ordinat = _ordinat;
    }

    public double hitungJarak(Point _point){
        int dx = this.absis - _point.absis;
        int dy = this.ordinat - _point.ordinat;
        return sqrt(dx*dx + dy*dy);
    }

    public void PrintInfo(){
        System.out.println("(" + absis.toString() + "," + ordinat.toString() + ")");
    }
}