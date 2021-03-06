import java.awt.*;
import java.awt.BorderLayout;
import java.util.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class DrawFish extends JLabel{

    private JPanel panel ;
    private LinkedList<Fish> listIkan;
    private Fish fish;
    private ImageIcon[] leftI;
    private ImageIcon[] rightI; 
    private ImageIcon[] hungryLeftI;
    private ImageIcon[] hungryRightI;   
    private int NOT_FOUND = -1;
    public DrawFish(JPanel tempP,LinkedList<Fish> tempLI,Fish tempF,ImageIcon[] left,ImageIcon[] right,ImageIcon[] hungryLeft,ImageIcon[]hungryRight){
        panel = tempP;
        listIkan = tempLI;
        fish = tempF;
        leftI = left;
        rightI = right;
        hungryLeftI = hungryLeft;
        hungryRightI = hungryRight; 
    }   

    @Override
    public void paintComponent(Graphics g){

        int cari = listIkan.find(fish);
        if(cari!=NOT_FOUND){
            Point p = new Point();
            Guppy temp = (Guppy)listIkan.get(cari);
            p.setAbsis( temp.getPosisi().getAbsis());
            p.setOrdinat(temp.getPosisi().getOrdinat());
            this.setLocation(p.getAbsis(),p.getOrdinat());
            
        
            
            if(temp.isFaceRight()){
                if(temp.isStarving()){
                    this.setIcon(hungryRightI[temp.getGrowthStep()-1]);
                } else{
                    this.setIcon(rightI[temp.getGrowthStep()-1]);
                }
            } else{
                if(temp.isStarving()){
                    this.setIcon(hungryLeftI[temp.getGrowthStep()-1]);
                } else{
                    this.setIcon(leftI[temp.getGrowthStep()-1]);
                }

            }
        } else{
            System.out.println("ikan mati");
            fish = null;
            listIkan = null;
            panel.remove(this);
            panel = null;
        }
        super.paintComponent(g);
    }
}