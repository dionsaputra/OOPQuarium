import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseButtonStart implements MouseListener {

  private MachineDriverAquarium aq;

  /**
   * Constructor.
   * @param temp machinenya
   */
  public MouseButtonStart(MachineDriverAquarium temp) {
    aq = temp;
  }

  /**
   * kalo ke klik.
   * @param e mouseevent
   */
  public void mouseClicked(MouseEvent e) {
    aq.setGameStart(true);
    System.out.println("Mouse Start Clicked: (" + e.getX() + ", " + e.getY() + ")");
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