import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Point;

public class DrawFish extends JLabel {

  private JPanel panel;
  private ArrayList<Fish> listIkan;
  private Fish fish;
  private ImageIcon[] leftI;
  private ImageIcon[] rightI;
  private ImageIcon[] hungryLeftI;
  private ImageIcon[] hungryRightI;
  private int notFound = -1;

  /**
   * Gambar ikan.
   *
   * @param tempP panel
   * @param tempLi list
   * @param tempF ikan
   * @param left gambar kiri
   * @param right gambar kanan
   * @param hungryLeft gambar lapar kiri
   * @param hungryRight gambar lapar kanan
   */
  public DrawFish(JPanel tempP, ArrayList<Fish> tempLi, Fish tempF, ImageIcon[] left,
    ImageIcon[] right, ImageIcon[] hungryLeft, ImageIcon[] hungryRight) {
    panel = tempP;
    listIkan = tempLi;
    fish = tempF;
    leftI = left;
    rightI = right;
    hungryLeftI = hungryLeft;
    hungryRightI = hungryRight;
  }

  /**
   * ngegambar.
   *
   * @param g graph gambar
   */
  @Override
  public void paintComponent(Graphics g) {

    int cari = listIkan.indexOf(fish);
    if (cari != notFound) {
      Point p = new Point();
      Guppy temp = (Guppy) listIkan.get(cari);
      p.setX(temp.getPosisi().getX());
      p.setY(temp.getPosisi().getY());
      this.setLocation(p.getX(), p.getY());
      if (temp.isFaceRight()) {
        if (temp.isStarving()) {
          this.setIcon(hungryRightI[temp.getGrowthStep() - 1]);
        } else {
          this.setIcon(rightI[temp.getGrowthStep() - 1]);
        }
      } else {
        if (temp.isStarving()) {
          this.setIcon(hungryLeftI[temp.getGrowthStep() - 1]);
        } else {
          this.setIcon(leftI[temp.getGrowthStep() - 1]);
        }

      }
    } else {
      System.out.println("ikan mati");
      fish = null;
      listIkan = null;
      panel.remove(this);
      panel = null;
    }
    super.paintComponent(g);
  }
}