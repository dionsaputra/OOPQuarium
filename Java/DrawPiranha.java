import java.awt.*;
import java.awt.BorderLayout;
import java.util.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class DrawPiranha extends JLabel{

    private JPanel panel ;
    private LinkedList<Fish> list;
    private Fish fish;
    private int NOT_FOUND = -1;
    private ImageIcon leftI;
    private ImageIcon rightI;
    private ImageIcon hungryLeftI;
    private ImageIcon hungryRightI;
    public DrawPiranha(JPanel tempP,LinkedList<Fish> tempLI,Fish tempF,ImageIcon left,ImageIcon right,ImageIcon hleft,ImageIcon hright){
        panel = tempP;
        list = tempLI;
        fish = tempF;
        leftI = left;
        rightI = right;
        hungryLeftI = hleft;
        hungryRightI = hright;
    }   

    @Override
    public void paintComponent(Graphics g){
        int cari = list.find(fish);
        if(cari!=NOT_FOUND){
            Point p = new Point();
            Fish temp = list.get(cari);
            p.setAbsis( temp.getPosisi().getAbsis());
            p.setOrdinat(temp.getPosisi().getOrdinat());
            this.setLocation(p.getAbsis(),p.getOrdinat());
            if(temp.isFaceRight()){
                if(temp.isStarving()){
                    this.setIcon(hungryRightI);
                } else{
                    this.setIcon(rightI);
                }

            } else{
                if(temp.isStarving()){
                    this.setIcon(hungryLeftI);
                } else{
                    this.setIcon(leftI);
                }
            }
        } else{
            fish = null;
            list = null;
            panel.remove(this);
            panel = null;
        }
        super.paintComponent(g);
    }
}