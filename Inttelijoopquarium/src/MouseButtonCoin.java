import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MouseButtonCoin implements MouseListener {

  private int id;
  private DrawCoin objlabel;
  private MachineDriverAquarium aq;

  /**
   * Constructor.
   * @param temp machinenya
   */
  public MouseButtonCoin(MachineDriverAquarium temp, JLabel templabel) {
    aq = temp;
    objlabel = (DrawCoin)templabel;
  }

  /**
   * kalo ke klik.
   * @param e mouseevent
   */
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Coin Clicked: (" + e.getX() + ", " + e.getY() + ")");
    aq.addMoney(objlabel.getKoin().getNilaiKoin());
    aq.getAquarium().getListObjekMati().remove(objlabel.getKoin());
  }

  /**
   * kalo ke presed.
   * @param e mouseevent
   */
  public void mousePressed(MouseEvent e) {
  }

  /**
   * kalo ke released.
   * @param e mouseevent
   */
  public void mouseReleased(MouseEvent e) {
  }

  /**
   * kalo ke entered.
   * @param e mouseevent
   */
  public void mouseEntered(MouseEvent e) {
  }

  /**
   * kalo ke exeited.
   * @param e mouseevent
   */
  public void mouseExited(MouseEvent e) {
  }
}