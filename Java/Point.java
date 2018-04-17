import java.lang.Math;
public class Point implements Comparable{
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
        return Math.sqrt(dx*dx + dy*dy);
    }

    public void PrintInfo(){
        System.out.println("(" + absis + "," + ordinat + ")");
    }
    @Override
    public int compareTo(Object P){
        Point P1 = (Point) P;
        if(absis == P1.absis && ordinat == P1.ordinat){
            return 0;
        }
        else if(absis < P1.absis && ordinat < P1.ordinat){
            return -1;
        }
        else{
            return 1;
        }
    }
    @Override
    public String toString(){
        return ("X = "+absis+" Y = "+ordinat);
    }
}