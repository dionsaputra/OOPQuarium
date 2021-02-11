import model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakananIkanTest {

  @Test
  void getHarga() {
    MakananIkan MI = new MakananIkan(new Point(5,3));
    MI.setHarga(56);
    assertEquals(56,MI.getHarga());
    System.out.println("getHarga success");
  }

  @Test
  void setHarga() {
    MakananIkan MI = new MakananIkan(new Point(5,3));
    MI.setHarga(56);
    assertEquals(56,MI.getHarga());
    System.out.println("setHarga success");
  }
}