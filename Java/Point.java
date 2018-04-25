import java.lang.Math;

public class Point implements Comparable {
  private int absis;
  private int ordinat;

  /**
   * konstruktor default dari Point, absis = ordinat = 0.
   */
  public Point() {
    absis = 0;
    ordinat = 0;
  }

  /**
   * konstruktor user defined dari Point.
   * @param absis nilai absis
   * @param ordinat nlai ordinat
   */
  public Point(int absis, int ordinat) {
    this.absis = absis;
    this.ordinat = ordinat;
  }

  /**
   * getter atribut absis.
   * @return absis int
   */
  public int getAbsis() {
    return absis;
  }

  /**
   * setter atribut absis.
   * @param absis nilai absis yang baru
   */
  public void setAbsis(int absis) {
    this.absis = absis;
  }

  /**
   * getter atribut ordinat.
   * @return ordinat int
   */
  public int getOrdinat() {
    return ordinat;
  }

  /**
   * setter atribut ordinat.
   * @param ordinat nilai ordinat yang baru
   */
  public void setOrdinat(int ordinat) {
    this.ordinat = ordinat;
  }

  /**
   * hitung jarak point saat ini dengan point parameter.
   * @param point point yang akan dihitung jaraknya dari point this
   * @return jarak point this dengan point parameter, double
   */
  public double hitungJarak(Point point) {
    int dx = this.absis - point.absis;
    int dy = this.ordinat - point.ordinat;
    return Math.sqrt(dx * dx + dy * dy);
  }

  /**
   * membandingkan point this dengan point object.
   * @param object point yang ingin dijadikan objek uji terhadap point this
   * @return 0 jika point this berimpit dengan point object,
   * -1 jika point this berada di kiri bawah point object,
   * 1 jika tidak berimpit dan tidak berada di kiri bawah point object
   */
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

  /**
   * print point dalam format 'X = absis Y = ordiant "
   * @return
   */
  @Override
  public String toString() {
    return ("(" + absis + ',' + ordinat + ')');
  }
}