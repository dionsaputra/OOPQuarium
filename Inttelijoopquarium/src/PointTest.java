import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void getAbsis() {
    Point p1 = new Point();
    System.out.println("cek getAbsis point(0,0)");
    assertEquals(0,p1.getAbsis());
    System.out.println("getAbsis point(0,0) valid");

    Point p2 = new Point(12,13);
    System.out.println("cek getAbsis point(x,y)");
    assertEquals(12,p2.getAbsis());
    System.out.println("getAbsis point(x,y) valid");
  }

  @Test
  void setAbsis() {
    Point p1 = new Point();
    p1.setAbsis(5);
    System.out.println("cek setAbsis point(x,y)");
    assertEquals(5,p1.getAbsis());
    System.out.println("setAbsis point(x,y) valid");
  }

  @Test
  void getOrdinat() {
    Point p1 = new Point();
    System.out.println("cek getOrdinat point(0,0)");
    assertEquals(0,p1.getOrdinat());
    System.out.println("getOrdinat point(0,0) valid");

    Point p2 = new Point(12,13);
    System.out.println("cek getOrdinat point(x,y)");
    assertEquals(13, p2.getOrdinat());
    System.out.println("getOrdinat point(x,y) valid");
  }

  @Test
  void setOrdinat() {
    Point p1 = new Point();
    p1.setOrdinat(5);
    System.out.println("cek setOrdinat");
    assertEquals(5, p1.getOrdinat());
    System.out.println("setOrdinat valid");
  }

  @Test
  void hitungJarak() {
    Point p1 = new Point();
    System.out.println("cek hitungJarak point this dengan this");
    assertEquals(0, p1.hitungJarak(p1));
    System.out.println("hitungJarak point this dengan this valid");

    Point p2 = new Point();
    System.out.println("cek hitungJarak point berhimpit");
    assertEquals(0,p1.hitungJarak(p2));
    System.out.println("hitungJarak point berhimpit valid");

    Point p3 = new Point(3,4);
    System.out.println("cek hitungJarak point tidak berimpit");
    assertEquals(5, p1.hitungJarak(p3));
    System.out.println("hitungJarak point tidak berhimpit valid");
  }

  @Test
  void compareTo() {
    Point p1 = new Point();
    Point p2 = new Point();
    System.out.println("cek compareTo point berhimpit");
    assertEquals(0, p1.compareTo(p2));
    System.out.println("compareTo point berhimpit valid");

    Point p3 = new Point(-1,-1);
    System.out.println("cek compareTo point kiri bawah");
    assertEquals(-1, p3.compareTo(p1));
    System.out.println("compareTo point kiri bawah valid");

    Point p4 = new Point(1,1);
    System.out.println("cek compareTo point bukan kanan atas");
    assertEquals(1, p4.compareTo(p1));
    System.out.println("compareTo point kanan atas valid");

    Point p5 = new Point (-1,1);
    System.out.println("cek compareTo point bukan kiri atas");
    assertEquals(1, p5.compareTo(p1));
    System.out.println("compareTo point kiri atas valid");

    Point p6 = new Point(1,-1);
    System.out.println("cek compareTo point bukan kanan bawah");
    assertEquals(1, p6.compareTo(p1));
    System.out.println("compareTo point kanan bawah valid");
  }
}