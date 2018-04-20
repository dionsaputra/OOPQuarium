
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseButtonGuppy implements MouseListener{


    private MachineDriverAquarium aq;


    public MouseButtonGuppy(MachineDriverAquarium temp){
      aq =  temp;
    }
    public void mouseClicked(MouseEvent e) {
       System.out.println("Mouse Guppy Clicked: ("+e.getX()+", "+e.getY() +")");
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