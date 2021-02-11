import model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuppyTest {

  @Test
  void eat() {
    Aquarium aq = new Aquarium();
    Guppy g = new Guppy();
    g.setPosisi(new Point(2,3));
    aq.addObject(new MakananIkan(new Point(5,4)));
    int jumlahAwal = aq.getListObjekMati().size();
    g.hunt(aq);
    assertEquals(jumlahAwal-1, aq.getListObjekMati().size());
    System.out.println("eat success");
  }

  @Test
  void produce() {
    Aquarium aq = new Aquarium();
    Guppy g = new Guppy();
    int nKoinAwal = aq.getListObjekMati().size();
    g.setPosisi(new Point(3,2));
    g.produce(aq);
    int nKoin = aq.getListObjekMati().size();
    assertEquals(nKoinAwal+1, nKoin);
    System.out.println("produce success");
  }

  @Test
  void nextGrowth() {
    Guppy g = new Guppy();
    int prev = g.getGrowthStep();
    g.nextGrowth();
    assertTrue(prev < g.getGrowthStep());
    System.out.println("nextGrowth success");
  }

  @Test
  void getGrowthStep() {
    Guppy g = new Guppy();
    assertEquals(1,g.getGrowthStep());
    System.out.println("getGrowthStep success");
  }

  @Test
  void getFoodCapacity() {
    Guppy g = new Guppy();
    assertEquals(0 , g.getFoodCapacity());
    System.out.println("getFoodCapacity success");
  }

  @Test
  void getProduceTime() {
    Guppy g = new Guppy();
    assertEquals(250, g.getProduceTime());
    System.out.println("getProduceTime success");
  }


  @Test
  void getMaxProduceTime() {
    Guppy g = new Guppy();
    assertEquals(250,g.getMaxProduceTime());
    System.out.println("getMaxProduceTime success");
  }

  @Test
  void setFoodCapacity() {
    Guppy g = new Guppy();
    g.setFoodCapacity(7);
    assertEquals(7,g.getFoodCapacity());
    System.out.println("setFoodCapacity success");
  }

  @Test
  void setProduceTime() {
    Guppy g = new Guppy();
    g.setProduceTime(5);
    assertEquals(5,g.getProduceTime());
    System.out.println("setProduceTime success");
  }
}