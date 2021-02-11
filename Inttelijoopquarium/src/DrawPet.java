import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Point;

public class DrawPet extends JLabel {

  private JPanel panel;
  private ArrayList<Pet> list;
  private Pet obj;
  private int notFound = -1;
  private ImageIcon leftSnail;
  private ImageIcon rightSnail;

  /**
   * Menggambar pet di swing.
   *
   * @param tempP panel
   * @param tempL listnya
   * @param od objek pet yang di check
   * @param l left image
   * @param r right image
   */
  public DrawPet(JPanel tempP, ArrayList<Pet> tempL, Pet od, ImageIcon l, ImageIcon r) {
    panel = tempP;
    list = tempL;
    obj = od;
    leftSnail = l;
    rightSnail = r;
  }

  /**
   * Menggambar component.
   *
   * @param g gambar graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    int cari = list.indexOf(obj);
    if (cari != notFound) {
      Point p = new Point();
      Pet temp = list.get(cari);
      p.setX(temp.getPosisi().getX());
      p.setY(temp.getPosisi().getY());
      this.setLocation(p.getX(), p.getY());
      if (temp.getFaceRight()) {
        this.setIcon(rightSnail);
      } else {
        this.setIcon(leftSnail);
      }
    } else {
      obj = null;
      list = null;
      panel.remove(this);
      panel = null;
    }
    super.paintComponent(g);
  }
}