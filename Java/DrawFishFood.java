import java.awt.*;
import java.awt.BorderLayout;
import java.util.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class DrawFishFood extends JLabel{

    private JPanel panel ;
    private LinkedList<ObjekMati> list;
    private ObjekMati objDead;
    private int NOT_FOUND = -1;
    public DrawFishFood(JPanel tempP,LinkedList<ObjekMati> tempL,ObjekMati od){
        panel = tempP;
        list = tempL;
        objDead = od;
    }   

    @Override
    public void paintComponent(Graphics g){
        int cari = list.find(objDead);
        if(cari!=NOT_FOUND){
            Point p = new Point();
            p.setAbsis( list.get(cari).getPosisi().getAbsis());
            p.setOrdinat(list.get(cari).getPosisi().getOrdinat());
            this.setLocation(p.getAbsis(),p.getOrdinat());
        } else{
            objDead = null;
            list = null;
            panel.remove(this);
            panel = null;
        }
        super.paintComponent(g);
    }
}