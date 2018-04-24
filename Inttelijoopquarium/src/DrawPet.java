import java.awt.*;
import java.awt.BorderLayout;
import java.util.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class DrawPet extends JLabel{

    private JPanel panel ;
    private LinkedList<Pet> list;
    private Pet obj;
    private int NOT_FOUND = -1;
    private ImageIcon leftSnail;
    private ImageIcon rightSnail;
    public DrawPet(JPanel tempP,LinkedList<Pet> tempL,Pet od,ImageIcon l, ImageIcon r){
        panel = tempP;
        list = tempL;
        obj = od;
        leftSnail = l;
        rightSnail = r;
    }   

    @Override
    public void paintComponent(Graphics g){
        int cari = list.find(obj);
        if(cari!=NOT_FOUND){
            Point p = new Point();
            Pet temp = list.get(cari);
            p.setAbsis( temp.getPosisi().getAbsis());
            p.setOrdinat(temp.getPosisi().getOrdinat());
            this.setLocation(p.getAbsis(),p.getOrdinat());
            if(temp.getFaceRight()){
                this.setIcon(rightSnail);
            } else{
                this.setIcon(leftSnail);
            }
        } else{
            obj = null;
            list = null;
            panel.remove(this);
            panel = null;
        }
        super.paintComponent(g);
    }
}