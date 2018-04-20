
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonCoin implements MouseListener {


  private MachineDriverAquarium aq;
  private int id;
  private JLabel objlabel;

  public MouseButtonCoin(MachineDriverAquarium temp, JLabel templabel) {
    aq = temp;
    objlabel = templabel;
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Coin Clicked: (" + e.getX() + ", " + e.getY() + ")");
  }

}