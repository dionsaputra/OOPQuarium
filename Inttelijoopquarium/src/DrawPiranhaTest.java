import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawPiranhaTest {
    @Test
    void testCreateObject(){
        System.out.print("DrawPet Test : ");
        try {
            DrawPiranha temp = new DrawPiranha(new JPanel(),new LinkedList<Fish>(),new Piranha(),new ImageIcon(),new ImageIcon(),new ImageIcon(),new ImageIcon());
        } catch (Exception e){
            assertTrue(false);
        }
        System.out.println("Create Object Success");
    }

}