
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class MouseButtonGuppy implements MouseListener,PriceList {

  private MachineDriverAquarium aq;

  public MouseButtonGuppy(MachineDriverAquarium temp) {
    aq = temp;
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Guppy Clicked: (" + e.getX() + ", " + e.getY() + ")");
    if(aq.getMoney()>=guppyPrice){
      Random r = new Random(System.currentTimeMillis());
      int randomX = r.nextInt(800)+66;
      aq.addGuppy(randomX,50,(JPanel) aq.getContentPane());
      aq.addMoney(-guppyPrice);
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