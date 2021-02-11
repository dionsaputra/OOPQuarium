import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

class DrawPiranhaTest {

  @Test
  void testCreateObject() {
    System.out.print("DrawPet Test : ");
    try {
      DrawPiranha temp = new DrawPiranha(new JPanel(), new ArrayList<>(), new Piranha(),
          new ImageIcon(), new ImageIcon(), new ImageIcon(), new ImageIcon());
    } catch (Exception e) {
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }

}