
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class MouseButtonBackground implements MouseListener,PriceList {

  private MachineDriverAquarium aq;

  public MouseButtonBackground(MachineDriverAquarium temp) {
    aq = temp;
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Background Clicked: (" + e.getX() + ", " + e.getY() + ")");
    if(aq.getMoney()>=foodPrice){
      Random r = new Random(System.currentTimeMillis());
      int randomX = r.nextInt(800)+66;
      aq.addFood(aq.getLeftTopFoodX(e.getX()) ,aq.getLeftTopFoodY(e.getY()) ,(JPanel) aq.getContentPane());
      aq.addMoney(-foodPrice);
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