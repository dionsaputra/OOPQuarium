import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiranhaTest {

  @Test
  void chaseFood() {
    Piranha p = new Piranha();
    boolean tes = p.chaseFood(5,new Point(1,2));
    assertTrue(tes);
    System.out.println("chase piranha success");
  }

  @Test
  void eat() {
    Aquarium aq = new Aquarium();
    Piranha g = new Piranha();
    Guppy gup = new Guppy();
    gup.setPosisi(new Point(2,1));
    g.setPosisi(new Point(2,3));
    aq.addObject(gup);

    int jumlahAwal = aq.getListIkan().totalElmt();
    g.hunt(aq);
    assertEquals(jumlahAwal-1, aq.getListIkan().totalElmt());
    System.out.println("eat success");
  }

  @Test
  void produce() {
    Aquarium aq = new Aquarium();
    Piranha g = new Piranha();
    int nKoinAwal = aq.getListObjekMati().totalElmt();
    g.setPosisi(new Point(3,2));
    g.produce(aq);
    int nKoin = aq.getListObjekMati().totalElmt();
    assertEquals(nKoinAwal+1, nKoin);
    System.out.println("produce piranha success");
  }

  @Test
  void getProduceTime() {
    Piranha p = new Piranha();
    int N = p.getProduceTime();
    assertEquals(N,1);
    System.out.println("producetime piranha success");
  }

  @Test
  void getMaxProduceTime() {
    Piranha p = new Piranha();
    int N = p.getMaxProduceTime();
    assertEquals(N,1);
    System.out.println("maxproducetime piranha success");
  }

  @Test
  void setProduceTime() {
    Piranha p = new Piranha();
    int N = 1;
    p.setProduceTime(1);
    assertEquals(N,1);
    System.out.println("setproducetime piranha success");
  }

  @Test
  void getLast() {
    Piranha p = new Piranha();
    int N = 25;
    p.setLast(25);
    int M = p.getLast();
    assertEquals(M,N);
    System.out.println("getLast piranha success");
  }

  @Test
  void getId() {
    Piranha p = new Piranha();
    int M = p.getId();
    assertTrue(M>0);
    System.out.println("getId piranha success");
  }

  @Test
  void setLast() {
    Piranha p = new Piranha();
    int N = 25;
    p.setLast(25);
    int M = p.getLast();
    assertEquals(M,N);
    System.out.println("setLast piranha success");
  }
}