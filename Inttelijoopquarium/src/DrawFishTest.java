import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

class DrawFishTest {

  @Test
  void testCreateObject() {
    System.out.print("DrawFish Test : ");
    try {
      DrawFish temp = new DrawFish(new JPanel(), new ArrayList<>(),
          new Guppy(), new ImageIcon[5], new ImageIcon[5],
          new ImageIcon[5], new ImageIcon[5]);
    } catch (Exception e) {
      assertTrue(false);
    }
    System.out.println("Create Object DrawFish Success");
  }
}