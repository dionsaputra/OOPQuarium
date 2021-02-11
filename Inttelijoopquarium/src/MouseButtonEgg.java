import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ConstantsKt;

public class MouseButtonEgg implements MouseListener {

  private MachineDriverAquarium aq;

  /**
   * Constructor.
   * @param temp machinenya
   */
  public MouseButtonEgg(MachineDriverAquarium temp) {
    aq = temp;
  }

  /**
   * kalo ke klik.
   * @param e mouseevent
   */
  public void mouseClicked(MouseEvent e) {
    if (aq.getMoney() >= ConstantsKt.PRICE_EGG) {

      aq.addEgg();
      aq.addMoney(-ConstantsKt.PRICE_EGG);
    }

    System.out.println("Mouse Egg Clicked: (" + e.getX() + ", " + e.getY() + ")");
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