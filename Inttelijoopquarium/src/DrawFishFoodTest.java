import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

class DrawFishFoodTest {

  @Test
  void testCreateObject() {
    System.out.print("DrawFishFood Test : ");
    try {
      DrawFishFood temp = new DrawFishFood(new JPanel(),
          new ArrayList<>(), new MakananIkan());
    } catch (Exception e) {
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}