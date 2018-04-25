import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawFishTest {
    @Test
    void testCreateObject(){
        System.out.print("DrawFish Test : ");
        try {
            DrawFish temp = new DrawFish(new JPanel(),new LinkedList<Fish>(),
                    new Guppy(),new ImageIcon[5], new ImageIcon[5],
                    new ImageIcon[5], new ImageIcon[5]);
        } catch (Exception e){
            assertTrue(false);
        }
        System.out.println("Create Object DrawFish Success");
    }
}