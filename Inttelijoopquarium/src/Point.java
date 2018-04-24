import java.lang.Math;

public class Point implements Comparable {
  private int absis;
  private int ordinat;

  public Point() {
    absis = 0;
    ordinat = 0;
  }

  public Point(int absis, int ordinat) {
    this.absis = absis;
    this.ordinat = ordinat;
  }

  public int getAbsis() {
    return absis;
  }

  public void setAbsis(int absis) {
    this.absis = absis;
  }

  public int getOrdinat() {
    return ordinat;
  }

  public void setOrdinat(int ordinat) {
    this.ordinat = ordinat;
  }

  public double hitungJarak(Point point) {
    int dx = this.absis - point.absis;
    int dy = this.ordinat - point.ordinat;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public void printInfo() {
    System.out.println("(" + absis + "," + ordinat + ")");
  }

  @Override
  public int compareTo(Object object) {
    Point point = (Point) object;
    if (absis == point.absis && ordinat == point.ordinat) {
      return 0;
    } else if (absis < point.absis && ordinat < point.ordinat) {
      return -1;
    } else {
      return 1;
    }
  }

  @Override
  public String toString() {
    return ("X = " + absis + " Y = " + ordinat);
  }
}