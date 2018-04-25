import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawPetTest {
    @Test
    void testCreateObject(){
        System.out.print("DrawPet Test : ");
        try {
            DrawPet temp = new DrawPet(new JPanel(),
                    new LinkedList<Pet>(),new Pet(2, 5,
                    new Point(1,2)),new ImageIcon(),
                    new ImageIcon());
        } catch (Exception e){
            assertTrue(false);
        }
        System.out.println("Create Object Success");
    }
}