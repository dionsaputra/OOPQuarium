import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Point;
import org.junit.jupiter.api.Test;

class DrawCoinTest {

  @Test
  void getKoin() {
    System.out.print("Testing DrawCoin");
    JPanel j = new JPanel();
    Koin tempkoin = new Koin(5, new Point(1, 3));
    DrawCoin temp = new DrawCoin(new JPanel(), new ArrayList<>(),
        tempkoin, new ImageIcon(), new ImageIcon());
    assertTrue(tempkoin == temp.getKoin());
    System.out.println("getKoin Success");
  }
}