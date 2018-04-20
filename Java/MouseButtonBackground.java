
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonBackground implements MouseListener {

  private MachineDriverAquarium aq;

  public MouseButtonBackground(MachineDriverAquarium temp) {
    aq = temp;
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Background Clicked: (" + e.getX() + ", " + e.getY() + ")");
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