import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ConstantsKt;

public class MouseButtonGuppy implements MouseListener {

  private MachineDriverAquarium aq;

  /**
   * Constructor.
   * @param temp machinenya
   */
  public MouseButtonGuppy(MachineDriverAquarium temp) {
    aq = temp;
  }

  /**
   * kalo ke klik.
   * @param e mouseevent
   */
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Guppy Clicked: (" + e.getX() + ", " + e.getY() + ")");
    if (aq.getMoney() >= ConstantsKt.PRICE_GUPPY) {
      Random r = new Random(System.currentTimeMillis());
      int randomX = r.nextInt(800) + 66;
      aq.addGuppy(randomX,50,(JPanel) aq.getContentPane());
      aq.addMoney(-ConstantsKt.PRICE_GUPPY);
    }
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }
}