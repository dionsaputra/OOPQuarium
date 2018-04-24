import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuppyTest {

  @Test
  void eat() {

  }

  @Test
  void produce() {

  }

  @Test
  void nextGrowth() {
    Guppy g = new Guppy();
    int prev = g.getGrowthStep();
    g.nextGrowth();
    assertTrue(prev < g.getGrowthStep());
  }

  @Test
  void getGrowthStep() {
  }

  @Test
  void getFoodCapaty() {
  }

  @Test
  void getProduceTime() {
  }

  @Test
  void getId() {
  }

  @Test
  void getMaxProduceTime() {
  }

  @Test
  void setFoodCapacity() {
  }

  @Test
  void setProduceTime() {
  }
}