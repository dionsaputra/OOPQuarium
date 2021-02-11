import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFishFood extends JLabel {

  private JPanel panel;
  private ArrayList<ObjekMati> list;
  private ObjekMati objDead;
  private int notFound = -1;

  /**
   * Drawfishfood gambar.
   *
   * @param tempP panel
   * @param tempL listnya
   * @param od objeknya yang dicheck
   */
  public DrawFishFood(JPanel tempP, ArrayList<ObjekMati> tempL, ObjekMati od) {
    panel = tempP;
    list = tempL;
    objDead = od;
  }

  /**
   * gambarr.
   *
   * @param g yang digambar
   */
  @Override
  public void paintComponent(Graphics g) {
    int cari = list.indexOf(objDead);
    if (cari != notFound) {
      Point p = new Point();
      p.setAbsis(list.get(cari).getPosisi().getAbsis());
      p.setOrdinat(list.get(cari).getPosisi().getOrdinat());
      this.setLocation(p.getAbsis(), p.getOrdinat());
    } else {
      objDead = null;
      list = null;
      panel.remove(this);
      panel = null;
    }
    super.paintComponent(g);
  }
}