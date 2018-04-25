import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;

public class MouseButtonBackground implements MouseListener,PriceList  {

  private MachineDriverAquarium aq;

  /**
   * Constructor.
   * @param temp machinenya
   */
  public MouseButtonBackground(MachineDriverAquarium temp)  {
    aq = temp;
  }

  /**
   * kalo ke klik.
   * @param e mouseevent
   */
  public void mouseClicked(MouseEvent e)  {
    System.out.println("Mouse Background Clicked: (" + e.getX() + ", " + e.getY() + ")");
    if (aq.getMoney() >= foodPrice)  {
      Random r = new Random(System.currentTimeMillis());
      int randomX = r.nextInt(800) + 66;
      aq.addFood(aq.getLeftTopFoodX(e.getX()),aq.getLeftTopFoodY(e.getY()),
              (JPanel) aq.getContentPane());
      aq.addMoney(-foodPrice);
    }
    
  }

  /**
   * kalo dipencet.
   * @param e mouseevent
   */
  public void mousePressed(MouseEvent e)  {
  }

  /**
   * kalo dipencet.
   * @param e mouseevent
   */
  public void mouseReleased(MouseEvent e)  {
  }

  /**
   * kalo dipencet.
   * @param e mouseevent
   */
  public void mouseEntered(MouseEvent e)  {
  }

  /**
   * kalo dipencet.
   * @param e mouseevent
   */
  public void mouseExited(MouseEvent e)  {
  }
}