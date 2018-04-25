import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DrawCoinTest {

    @Test
    void getKoin() {
        System.out.print("Testing DrawCoin");
        JPanel j = new JPanel();
        Koin tempkoin = new Koin(5, new Point(1,3));
        DrawCoin temp = new DrawCoin(new JPanel(), new LinkedList<ObjekMati>(),
                tempkoin,new ImageIcon(), new ImageIcon());
        assertTrue(tempkoin==temp.getKoin());
        System.out.println("getKoin Success");
    }
}