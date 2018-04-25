import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MouseButtonBackgroundTest {
  @Test
  void testCreateObject(){
    System.out.print("MouseButtonBackground Test : ");
    try {
      MouseButtonBackground temp = new MouseButtonBackground(new MachineDriverAquarium());
    } catch (Exception e){
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}