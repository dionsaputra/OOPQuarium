import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MouseButtonGuppyTest {
  @Test
  void testCreateObject(){
    System.out.print("MouseButtonGuppy Test : ");
    try {
      MouseButtonGuppy temp = new MouseButtonGuppy(new MachineDriverAquarium());
    } catch (Exception e){
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}