import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ConstantsKt;

public class MouseButtonPiranha implements MouseListener {

  private MachineDriverAquarium aq;

  /**
   * Constructor.
   * @param temp machinenya
   */
  public MouseButtonPiranha(MachineDriverAquarium temp) {
    aq = temp;
  }

  /**
   * kalo ke klik.
   * @param e mouseevent
   */
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Piranha Clicked: (" + e.getX() + ", " + e.getY() + ")");
    if (aq.getMoney() >= ConstantsKt.PRICE_PIRANHA) {
      Random r = new Random(System.currentTimeMillis());
      int randomX = r.nextInt(800) + 66;
      aq.addPiranha(randomX,50,(JPanel) aq.getContentPane());
      aq.addMoney(-ConstantsKt.PRICE_PIRANHA);
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