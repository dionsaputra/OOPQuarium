import static model.ResourcesKt.BACKGROUND;

import javax.swing.ImageIcon;

public class Main {

  public static void main(String[] args) {
    ImageIcon backgroundImage = new ImageIcon(Main.class.getResource(BACKGROUND));
    Aquarium aquarium = new Aquarium(backgroundImage.getIconHeight(),
        backgroundImage.getIconWidth());
    MachineDriverAquarium driverAquarium = new MachineDriverAquarium(aquarium);
    driverAquarium.execute();
  }
}
