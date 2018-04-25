import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawFishFoodTest {
    @Test
    void testCreateObject(){
        System.out.print("DrawFishFood Test : ");
        try {
            DrawFishFood temp = new DrawFishFood(new JPanel(),
                    new LinkedList<ObjekMati>(),new MakananIkan());
        } catch (Exception e){
            assertTrue(false);
        }
        System.out.println("Create Object Success");
    }
}