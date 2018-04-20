
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonStart implements MouseListener {

  private MachineDriverAquarium aq;

  public MouseButtonStart(MachineDriverAquarium temp) {
    aq = temp;
  }

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