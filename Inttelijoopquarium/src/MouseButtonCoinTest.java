import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

class MouseButtonCoinTest {

  @Test
  void testCreateObject() {
    System.out.print("MouseButtonCoin Test : ");
    try {
      Koin tempkoin = new Koin(5, new Point(1, 3));
      MouseButtonCoin temp = new MouseButtonCoin(new MachineDriverAquarium(),
          new DrawCoin(new JPanel(), new ArrayList<>(),
              tempkoin, new ImageIcon(), new ImageIcon()));
    } catch (Exception e) {
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}