
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonCoin implements MouseListener {

  private int id;
  private DrawCoin objlabel;
  private MachineDriverAquarium aq;

  public MouseButtonCoin(MachineDriverAquarium temp, JLabel templabel) {
    aq = temp;
    objlabel = (DrawCoin)templabel;
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Coin Clicked: (" + e.getX() + ", " + e.getY() + ")");
    aq.addMoney(objlabel.getKoin().getNilaiKoin());
    aq.getAquarium().getListObjekMati().remove(objlabel.getKoin());
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