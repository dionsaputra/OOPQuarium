import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MouseButtonEggTest {
  @Test
  void testCreateObject(){
    System.out.print("MouseButtonEgg Test : ");
    try {
      MouseButtonEgg temp = new MouseButtonEgg(new MachineDriverAquarium());
    } catch (Exception e){
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}