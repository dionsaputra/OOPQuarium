import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MouseButtonPiranhaTest {
  @Test
  void testCreateObject(){
    System.out.print("MouseButtonPiranha Test : ");
    try {
      MouseButtonPiranha temp = new MouseButtonPiranha(new MachineDriverAquarium());
    } catch (Exception e){
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}