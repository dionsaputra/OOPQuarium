import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Point;
import org.junit.jupiter.api.Test;

class PointJavaTest {

  @Test
  void getAbsis() {
    Point p1 = new Point();
    System.out.println("cek getX point(0,0)");
    assertEquals(0,p1.getX());
    System.out.println("getX point(0,0) valid");

    Point p2 = new Point(12,13);
    System.out.println("cek getX point(x,y)");
    assertEquals(12,p2.getX());
    System.out.println("getX point(x,y) valid");
  }

  @Test
  void setAbsis() {
    Point p1 = new Point();
    p1.setX(5);
    System.out.println("cek setX point(x,y)");
    assertEquals(5,p1.getX());
    System.out.println("setX point(x,y) valid");
  }

  @Test
  void getOrdinat() {
    Point p1 = new Point();
    System.out.println("cek getY point(0,0)");
    assertEquals(0,p1.getY());
    System.out.println("getY point(0,0) valid");

    Point p2 = new Point(12,13);
    System.out.println("cek getY point(x,y)");
    assertEquals(13, p2.getY());
    System.out.println("getY point(x,y) valid");
  }

  @Test
  void setOrdinat() {
    Point p1 = new Point();
    p1.setY(5);
    System.out.println("cek setY");
    assertEquals(5, p1.getY());
    System.out.println("setY valid");
  }

  @Test
  void hitungJarak() {
    Point p1 = new Point();
    System.out.println("cek distance point this dengan this");
    assertEquals(0, p1.distance(p1));
    System.out.println("distance point this dengan this valid");

    Point p2 = new Point();
    System.out.println("cek distance point berhimpit");
    assertEquals(0,p1.distance(p2));
    System.out.println("distance point berhimpit valid");

    Point p3 = new Point(3,4);
    System.out.println("cek distance point tidak berimpit");
    assertEquals(5, p1.distance(p3));
    System.out.println("distance point tidak berhimpit valid");
  }
}