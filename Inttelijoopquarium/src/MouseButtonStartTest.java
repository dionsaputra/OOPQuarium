import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MouseButtonStartTest {

  @Test
  void testCreateObject(){
    System.out.print("MouseButtonStart Test : ");
    try {
      MouseButtonStart temp = new MouseButtonStart(new MachineDriverAquarium());
    } catch (Exception e){
      assertTrue(false);
    }
    System.out.println("Create Object Success");
  }
}