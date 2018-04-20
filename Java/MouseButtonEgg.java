
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonEgg implements MouseListener{


    private MachineDriverAquarium aq;


    public MouseButtonEgg(MachineDriverAquarium temp){
      aq =  temp;
    }
    public void mouseClicked(MouseEvent e) {
       aq.addEgg();
       System.out.println("Mouse Egg Clicked: ("+e.getX()+", "+e.getY() +")");
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