import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineDriverAquariumTest {

  @Test
  void addMoney() {
    MachineDriverAquarium temp = new MachineDriverAquarium();
    int sebelum = temp.getMoney();
    temp.addMoney(500);
    assertEquals(sebelum+500,temp.getMoney());
  }
}