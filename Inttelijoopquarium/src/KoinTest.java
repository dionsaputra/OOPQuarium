import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KoinTest {

  @Test
  void getNilaiKoin() {
    Koin K1 = new Koin(5, new Point(3,2));
    assertEquals(5,K1.getNilaiKoin());
    System.out.println("getNilaiKoin success");
  }

  @Test
  void setNilaiKoin() {
    Koin K1 = new Koin(5, new Point(4,3));
    assertEquals(5, K1.getNilaiKoin());
    K1.setNilaiKoin(8);
    assertEquals(8,K1.getNilaiKoin());
    System.out.println("setNilaiKoin success");
  }
}