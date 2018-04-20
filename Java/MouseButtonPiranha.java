
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonPiranha implements MouseListener {

  private MachineDriverAquarium aq;

  public MouseButtonPiranha(MachineDriverAquarium temp) {
    aq = temp;
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Piranha Clicked: (" + e.getX() + ", " + e.getY() + ")");
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