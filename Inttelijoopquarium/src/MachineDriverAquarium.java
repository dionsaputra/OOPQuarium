import static model.ResourcesKt.BACKGROUND;
import static model.ResourcesKt.IMG_EGG_1;
import static model.ResourcesKt.IMG_EGG_2;
import static model.ResourcesKt.IMG_EGG_3;
import static model.ResourcesKt.IMG_FOOD;
import static model.ResourcesKt.IMG_COIN_GOLD;
import static model.ResourcesKt.IMG_GUPPY_LEFT_1;
import static model.ResourcesKt.IMG_GUPPY_RIGHT_1;
import static model.ResourcesKt.IMG_GUPPY_LEFT_2;
import static model.ResourcesKt.IMG_GUPPY_RIGHT_2;
import static model.ResourcesKt.IMG_GUPPY_LEFT_3;
import static model.ResourcesKt.IMG_GUPPY_RIGHT_3;
import static model.ResourcesKt.IMG_GUPPY_LEFT_HUNGRY_1;
import static model.ResourcesKt.IMG_GUPPY_RIGHT_HUNGRY_1;
import static model.ResourcesKt.IMG_GUPPY_LEFT_HUNGRY_2;
import static model.ResourcesKt.IMG_GUPPY_RIGHT_HUNGRY_2;
import static model.ResourcesKt.IMG_GUPPY_LEFT_HUNGRY_3;
import static model.ResourcesKt.IMG_GUPPY_RIGHT_HUNGRY_3;
import static model.ResourcesKt.IMG_PIRANHA_LEFT_HUNGRY;
import static model.ResourcesKt.IMG_PIRANHA_RIGHT_HUNGRY;
import static model.ResourcesKt.BTN_LOAD;
import static model.ResourcesKt.ICON_LOSE;
import static model.ResourcesKt.IMG_PIRANHA_LEFT;
import static model.ResourcesKt.IMG_PIRANHA_RIGHT;
import static model.ResourcesKt.BTN_SAVE;
import static model.ResourcesKt.IMG_COIN_SILVER;
import static model.ResourcesKt.IMG_SNAIL_LEFT;
import static model.ResourcesKt.IMG_SNAIL_RIGHT;
import static model.ResourcesKt.BTN_START;
import static model.ResourcesKt.ICON_WIN;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ConstantsKt;
import model.Point;

public class MachineDriverAquarium extends JFrame {

  private JPanel contentPane;
  private JLabel headerLabel = new JLabel();
  private ImageIcon backgroundImage;
  private ImageIcon saveImage;
  private ImageIcon loadImage;
  private ImageIcon startImage;
  private ImageIcon winImage;
  private ImageIcon loseImage;
  private ImageIcon[] guppyLeft = new ImageIcon[3];
  private ImageIcon[] guppyRight = new ImageIcon[3];
  private ImageIcon[] hungryGuppyLeft = new ImageIcon[3];
  private ImageIcon[] hungryGuppyRight = new ImageIcon[3];
  private ImageIcon piranhaLeft;
  private ImageIcon piranhaRight;
  private ImageIcon hungryPiranhaLeft;
  private ImageIcon hungryPiranhaRight;
  private ImageIcon hungryPiranha;
  private ImageIcon snailLeft;
  private ImageIcon snailRight;
  private ImageIcon goldCoin;
  private ImageIcon silverCoin;
  private ImageIcon foodFish;
  private ImageIcon[] eggImage = new ImageIcon[3];
  private Scanner sc = new Scanner(System.in);

  private String jenisGuppy = "Guppy";
  private String jenisFood = "Makanan Ikan";
  private String jenisKoin = "Koin";
  private String jenisPiranha = "Piranha";

  private boolean win;
  private JLabel buttonEgg = new JLabel();
  private JLabel labelMoney = new JLabel();
  private boolean gameStart;
  private int egg;
  private int money;
  private Aquarium aquarium;
  private ArrayList<ObjekMati> listObjekMatiCheck = new ArrayList<>();

  /**
   * Constructor for MachineDriverAquarium.
   */
  public MachineDriverAquarium() {
    gameStart = false;
    money = 1000;
    egg = 1;
    initMediaAll();
    aquarium = new Aquarium(backgroundImage.getIconHeight(), backgroundImage.getIconWidth());
  }

  public static void main(String[] args) {
    MachineDriverAquarium temp = new MachineDriverAquarium();
    temp.execute();
  }

  /**
   * change the value of gameStart with p.
   *
   * @param p boolean
   */
  public void setGameStart(boolean p) {
    gameStart = p;
  }

  /**
   * perform init for media or picture(and animated pictures).
   */
  public void initMediaAll() {

    saveImage = new ImageIcon(this.getClass().getResource(BTN_SAVE));
    loadImage = new ImageIcon(this.getClass().getResource(BTN_LOAD));
    startImage = new ImageIcon(this.getClass().getResource(BTN_START));
    winImage = new ImageIcon(this.getClass().getResource(ICON_WIN));
    loseImage = new ImageIcon(this.getClass().getResource(ICON_LOSE));

    foodFish = new ImageIcon(this.getClass().getResource(IMG_FOOD));

    guppyLeft[0] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_LEFT_1));
    guppyLeft[1] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_LEFT_2));
    guppyLeft[2] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_LEFT_3));

    guppyRight[0] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_RIGHT_1));
    guppyRight[1] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_RIGHT_2));
    guppyRight[2] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_RIGHT_3));

    hungryGuppyLeft[0] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_LEFT_HUNGRY_1));
    hungryGuppyLeft[1] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_LEFT_HUNGRY_2));
    hungryGuppyLeft[2] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_LEFT_HUNGRY_3));

    hungryGuppyRight[0] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_RIGHT_HUNGRY_1));
    hungryGuppyRight[1] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_RIGHT_HUNGRY_2));
    hungryGuppyRight[2] = new ImageIcon(this.getClass().getResource(IMG_GUPPY_RIGHT_HUNGRY_3));

    piranhaLeft = new ImageIcon(this.getClass().getResource(IMG_PIRANHA_LEFT));
    piranhaRight = new ImageIcon(this.getClass().getResource(IMG_PIRANHA_RIGHT));

    hungryPiranhaLeft = new ImageIcon(this.getClass().getResource(IMG_PIRANHA_LEFT_HUNGRY));
    hungryPiranhaRight = new ImageIcon(this.getClass().getResource(IMG_PIRANHA_RIGHT_HUNGRY));

    snailLeft = new ImageIcon(this.getClass().getResource(IMG_SNAIL_LEFT));
    snailRight = new ImageIcon(this.getClass().getResource(IMG_SNAIL_RIGHT));

    goldCoin = new ImageIcon(this.getClass().getResource(IMG_COIN_GOLD));
    silverCoin = new ImageIcon(this.getClass().getResource(IMG_COIN_SILVER));

    eggImage[0] = new ImageIcon(this.getClass().getResource(IMG_EGG_1));
    eggImage[1] = new ImageIcon(this.getClass().getResource(IMG_EGG_2));
    eggImage[2] = new ImageIcon(this.getClass().getResource(IMG_EGG_3));
    backgroundImage = new ImageIcon(this.getClass().getResource(BACKGROUND));
  }

  /**
   * Calculate topleft x piranha coordinate from x center. xcenter
   *
   * @return topleft x piranha
   */
  public int getLeftTopPiranhaX(int x) {
    return x - (piranhaLeft.getIconWidth() / 2);
  }

  /**
   * Calculate topleft y piranha coordinate from y center.
   *
   * @param y ycenter
   * @return toplefty piranha
   */
  public int getLeftTopPiranhaY(int y) {
    return y - (piranhaLeft.getIconHeight() / 2);
  }

  /**
   * Calculate topleft x guppy coordinate from x center. xcenter
   *
   * @return topleft x guppy
   */
  public int getLeftTopGuppyX(int x) {
    return x - (guppyLeft[0].getIconWidth() / 2);
  }

  /**
   * Calculate topleft y guppy coordinate from y center.
   *
   * @param y ycenter
   * @return topleft y guppy
   */
  public int getLeftTopGuppyY(int y) {
    return y - (guppyLeft[0].getIconHeight() / 2);
  }

  /**
   * Calculate topleft x coin coordinate from x center. xcenter
   *
   * @return topleft x coin
   */
  public int getLeftTopCoinX(int x) {
    return x - (goldCoin.getIconWidth() / 2);
  }

  /**
   * Calculate topleft y coin coordinate from y center.
   *
   * @param y ycenter
   * @return topleft y coin
   */
  public int getLeftTopCoinY(int y) {
    return y - (goldCoin.getIconHeight() / 2);
  }

  /**
   * Calculate topleft x food coordinate from x center. xcenter
   *
   * @return topleft x food
   */
  public int getLeftTopFoodX(int x) {
    return x - (foodFish.getIconWidth() / 2);
  }

  /**
   * Calculate topleft y food coordinate from y center.
   *
   * @param y ycenter
   * @return topleft y food
   */
  public int getLeftTopFoodY(int y) {
    return y - (foodFish.getIconHeight() / 2);
  }

  /**
   * Calculate topleft x snail coordinate from x center. xcenter
   *
   * @return topleft x snail
   */
  public int getLeftTopSnailX(int x) {
    return x - (snailLeft.getIconWidth() / 2);
  }

  /**
   * Calculate topleft y snail coordinate from y center.
   *
   * @param y ycenter
   * @return topleft y snail
   */
  public int getLeftTopSnailY(int y) {
    return y - (snailLeft.getIconHeight() / 2);
  }

  /**
   * Calculate topleft x win coordinate from x center. xcenter
   *
   * @return topleft x win
   */
  public int getLeftTopWinX(int x) {
    return x - (winImage.getIconWidth() / 2);
  }

  /**
   * Calculate topleft y winImage coordinate from y center.
   *
   * @param y ycenter
   * @return topleft y winImage
   */
  public int getLeftTopWinY(int y) {
    return y - (winImage.getIconHeight() / 2);
  }

  /**
   * Calculate topleft x lose coordinate from x center. xcenter
   *
   * @return topleft x lose
   */
  public int getLeftTopLoseX(int x) {
    return x - (loseImage.getIconWidth() / 2);
  }

  /**
   * Calculate topleft y loseImage coordinate from y center.
   *
   * @param y ycenter
   * @return topleft y loseImage
   */
  public int getLeftTopLoseY(int y) {
    return y - (loseImage.getIconHeight() / 2);
  }

  /**
   * init button and add to panel.
   *
   * @param panel panel from jframe
   */
  public void initButtonLabel(JPanel panel) {
    //Initialize button and background

    JLabel buttonPiranha = new JLabel();
    buttonPiranha.setIcon(piranhaLeft);

    JLabel buttonGuppy = new JLabel();
    buttonGuppy.setIcon(guppyLeft[2]);

    JLabel buttonFishFood = new JLabel();
    buttonFishFood.setIcon(foodFish);

    buttonEgg.setIcon(eggImage[egg - 1]);
    buttonPiranha.addMouseListener(new MouseButtonPiranha(this));
    buttonGuppy.addMouseListener(new MouseButtonGuppy(this));
    buttonEgg.addMouseListener(new MouseButtonEgg(this));

    JLabel labelGuppy = new JLabel();
    labelGuppy.setFont(new Font("Serif", Font.PLAIN, 20));
    labelGuppy.setText(Integer.toString(ConstantsKt.PRICE_GUPPY));
    labelGuppy.setSize(300, 50);
    labelGuppy.setLocation(backgroundImage.getIconWidth() + guppyLeft[0].getIconWidth(), 0);

    JLabel labelPiranha = new JLabel();
    labelPiranha.setFont(new Font("Serif", Font.PLAIN, 20));
    labelPiranha.setText(Integer.toString(ConstantsKt.PRICE_PIRANHA));
    labelPiranha.setSize(300, 50);
    labelPiranha.setLocation(backgroundImage.getIconWidth() + piranhaLeft.getIconWidth(),
      guppyLeft[0].getIconHeight());

    JLabel labelFishFood = new JLabel();
    labelFishFood.setFont(new Font("Serif", Font.PLAIN, 20));
    labelFishFood.setText(Integer.toString(ConstantsKt.PRICE_FOOD));
    labelFishFood.setSize(300, labelFishFood.getPreferredSize().height);
    labelFishFood.setLocation(backgroundImage.getIconWidth() + foodFish.getIconWidth(),
      guppyLeft[0].getIconHeight() + piranhaLeft.getIconHeight());

    JLabel labelEgg = new JLabel();
    labelEgg.setFont(new Font("Serif", Font.PLAIN, 20));
    labelEgg.setText(Integer.toString(ConstantsKt.PRICE_EGG));
    labelEgg.setSize(300, labelEgg.getPreferredSize().height);
    labelEgg.setLocation(backgroundImage.getIconWidth() + eggImage[0].getIconWidth(),
      guppyLeft[0].getIconHeight() + piranhaLeft.getIconHeight() + foodFish.getIconHeight());

    labelMoney.setFont(new Font("Serif", Font.PLAIN, 20));
    labelMoney.setText("Your money : " + Integer.toString(money));
    labelMoney.setSize(300, labelMoney.getPreferredSize().height);
    labelMoney.setLocation(backgroundImage.getIconWidth(),
      guppyLeft[2].getIconHeight() + piranhaLeft.getIconHeight() + foodFish.getIconHeight()
        + eggImage[0].getIconHeight());

    buttonGuppy.setBounds(backgroundImage.getIconWidth(), 0, buttonGuppy.getPreferredSize().width,
      buttonGuppy.getPreferredSize().height);
    buttonPiranha.setBounds(backgroundImage.getIconWidth(), guppyLeft[2].getIconHeight(),
      buttonPiranha.getPreferredSize().width, buttonPiranha.getPreferredSize().height);
    buttonFishFood.setBounds(backgroundImage.getIconWidth(),
      guppyLeft[2].getIconHeight() + piranhaLeft.getIconHeight(),
      buttonFishFood.getPreferredSize().width, buttonFishFood.getPreferredSize().height);
    buttonEgg.setBounds(backgroundImage.getIconWidth(),
      guppyLeft[2].getIconHeight() + piranhaLeft.getIconHeight() + foodFish.getIconHeight(),
      buttonEgg.getPreferredSize().width, buttonEgg.getPreferredSize().height);
    panel.add(buttonPiranha);
    panel.add(buttonGuppy);
    panel.add(buttonFishFood);
    panel.add(buttonEgg);
    panel.add(labelGuppy);
    panel.add(labelPiranha);
    panel.add(labelFishFood);
    panel.add(labelEgg);
    panel.add(labelMoney);
  }

  /**
   * set the this jframe setting to exit on close , set the width and the height. set the title, and
   * make the windows at center.
   */
  public void initWindowSetting() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(new Dimension(ConstantsKt.SCREEN_WIDTH, ConstantsKt.SCREEN_HEIGHT));
    setTitle("ArkavQuarium");
    setLocationRelativeTo(null);
  }

  /**
   * make start menu.
   *
   * @param panel to add and update
   */
  public void startMenu(JPanel panel) {
    JLabel buttonStart = new JLabel();
    buttonStart.setIcon(startImage);
    buttonStart.addMouseListener(new MouseButtonStart(this));
    buttonStart.setBounds(ConstantsKt.SCREEN_WIDTH / 2, ConstantsKt.SCREEN_HEIGHT / 2,
      buttonStart.getPreferredSize().width,
      buttonStart.getPreferredSize().height);

    panel.add(buttonStart);

    panel.repaint();
    while (!gameStart) {
      if (gameStart) {
        System.out.println("mulai");
      } else {
        System.out.println("belum mulai ");

      }
    }
    panel.remove(buttonStart);
    panel.repaint();
  }

  /**
   * add food at x,y coordinate. ini x
   *
   * @param y this is ordinat
   */
  public void addFood(int x, int y, JPanel jp) {
    MakananIkan temp = new MakananIkan();
    Point p = new Point(x, y);
    temp.setPosisi(p);
    aquarium.addObject(temp);
    DrawFishFood tempG = new DrawFishFood(jp, aquarium.getListObjekMati(), temp);
    tempG.setIcon(foodFish);
    tempG.setBounds(x, y, tempG.getPreferredSize().width,
      tempG.getPreferredSize().height);
    jp.add(tempG);
  }

  /**
   * add guppy at x,y coordinate. ini x
   *
   * @param y ini y
   */
  public void addGuppy(int x, int y, JPanel jp) {
    Fish temp = new Guppy();
    Point p = new Point(x, y);
    temp.setPosisi(p);

    aquarium.addObject(temp);

    DrawFish tempG = new DrawFish(jp, aquarium.getListIkan(), temp, guppyLeft, guppyRight,
      hungryGuppyLeft, hungryGuppyRight);
    tempG.setIcon(guppyLeft[0]);
    tempG.setBounds(x, y, tempG.getPreferredSize().width,
      tempG.getPreferredSize().height);
    jp.add(tempG);
  }

  /**
   * add piranha at x,y coordinate.
   *
   * @param x ini x
   * @param y ini y
   */
  public void addPiranha(int x, int y, JPanel jp) {
    Piranha temp = new Piranha();
    Point p = new Point(x, y);
    temp.setPosisi(p);
    aquarium.addObject(temp);
    DrawPiranha tempG = new DrawPiranha(jp, aquarium.getListIkan(), temp,
      piranhaLeft, piranhaRight, hungryPiranhaLeft, hungryPiranhaRight);
    tempG.setIcon(piranhaLeft);
    tempG.setBounds(x, y, tempG.getPreferredSize().width,
      tempG.getPreferredSize().height);
    jp.add(tempG);
  }

  /**
   * add piranha at x,y coordinate.
   *
   * @param x ini x
   * @param y ini y
   * @param jp ini penggaambar
   */

  public void addPet(int x, int y, JPanel jp) {
    Point p = new Point(x, y);
    Pet temp = new Pet(5, 20, p);
    temp.setPosisi(p);
    aquarium.addObject(temp);
    DrawPet tempG = new DrawPet(jp, aquarium.getListPet(), temp, snailLeft, snailRight);
    tempG.setIcon(piranhaLeft);
    tempG.setBounds(x, y, tempG.getPreferredSize().width,
      tempG.getPreferredSize().height);
    jp.add(tempG);
  }

  /**
   * checking coin in new.
   *
   * @param jp pengammbar
   */
  public void checkingCoin(JPanel jp) {
    ArrayList<ObjekMati> listNowCoin = aquarium.getListObjekMati();
    for (int i = 0; i < listNowCoin.size(); i++) {
      ObjekMati tempObj = listNowCoin.get(i);
      if (tempObj.getJenis().equals(jenisKoin)) {
        int hasilP = listObjekMatiCheck.indexOf(tempObj);
        if (hasilP == -1) {
          //Not found
          DrawCoin tempG = new DrawCoin(jp, aquarium.getListObjekMati(),
            tempObj, goldCoin, silverCoin);
          tempG.setIcon(goldCoin);
          tempG.setBounds(tempObj.getPosisi().getX(), tempObj.getPosisi().getY(),
            tempG.getPreferredSize().width, tempG.getPreferredSize().height);
          tempG.addMouseListener(new MouseButtonCoin(this, tempG));
          jp.add(tempG);
          listObjekMatiCheck.add(tempObj);
        }
      }
    }
    //Hapus koin lama yang sudah tidak ada
    for (int i = 0; i < listObjekMatiCheck.size(); i++) {
      ObjekMati temp = listObjekMatiCheck.get(i);
      if (listNowCoin.indexOf(temp) == -1) {
        listObjekMatiCheck.remove(temp);
      }
    }
  }

  public void addEgg() {
    egg++;
  }

  /**
   * Execute all programm.
   */
  public void execute() {
    try {

      //Initialize Jframe get panel
      initWindowSetting();
      JPanel panel = (JPanel) this.getContentPane();
      //JPanel panel = new JPanel();
      //this.add(panel);
      panel.setLayout(null);
      panel.setLayout(null);
      this.setVisible(true);

      startMenu(panel);

      JLabel imageBg = new JLabel();
      imageBg.setIcon(backgroundImage);
      panel.add(imageBg);
      imageBg.setBounds(0, 0, imageBg.getPreferredSize().width, imageBg.getPreferredSize().height);
      imageBg.addMouseListener(new MouseButtonBackground(this));
      initButtonLabel(panel);

      // EntitasGambar contoh = new EntitasGambar();

      // panel.add(contoh);
      this.addGuppy(backgroundImage.getIconWidth() / 2,
        backgroundImage.getIconHeight() / 2, panel);
      this.addPiranha(backgroundImage.getIconWidth() / 2,
        backgroundImage.getIconHeight() / 2, panel);
      int ordinatDasarAquarium = aquarium.getDasar();
      this.addPet(300, ordinatDasarAquarium, panel);
      panel.repaint();
      //panel.setComponentZOrder(imageBg, panel.getComponentCount() - 1);
      while (true) {
        if (gameStart) {
          //checkingCoin(panel);
          Thread.sleep(40);
          panel.repaint();
          panel.setComponentZOrder(imageBg, panel.getComponentCount() - 1);
          panel.repaint();

          labelMoney.setText("Your money : " + Integer.toString(money));
          aquarium.action();
          checkingCoin(panel);
          Pet tempPet = aquarium.getListPet().get(0);
          addMoney(tempPet.getTotalMoney());
          tempPet.setTotalMoney(0);
          if (egg == 4) {
            gameStart = false;
            win = true;
          } else {
            buttonEgg.setIcon(eggImage[egg - 1]);
            if (aquarium.getListIkan().size() == 0 && money < ConstantsKt.PRICE_GUPPY) {
              gameStart = false;
              win = false;
            }
          }


        } else {
          break;
        }
      }
      //panel.removeAll();
      //panel.repaint();
      panel.repaint();
      System.out.println("keluar dari loop game");
      if (win) {
        JLabel imageWin = new JLabel();
        imageWin.setIcon(winImage);

        imageWin.setBounds(ConstantsKt.SCREEN_WIDTH / 2 - imageWin.getPreferredSize().width / 2,
          ConstantsKt.SCREEN_HEIGHT / 2 - imageWin.getPreferredSize().height / 2,
          imageWin.getPreferredSize().width, imageWin.getPreferredSize().height);
        panel.add(imageWin);

        panel.setComponentZOrder(imageWin, 0);
        panel.repaint();
        while (true) {
          panel.setComponentZOrder(imageWin, 0);

          Thread.sleep(500);
          panel.repaint();
          System.out.println("masuk menang");
        }

      } else {
        JLabel imageLose = new JLabel();
        imageLose.setIcon(loseImage);

        imageLose.setBounds(ConstantsKt.SCREEN_WIDTH / 2 - imageLose.getPreferredSize().width / 2,
          ConstantsKt.SCREEN_HEIGHT / 2 - imageLose.getPreferredSize().height / 2,
          imageLose.getPreferredSize().width, imageLose.getPreferredSize().height);

        panel.add(imageLose);
        panel.setComponentZOrder(imageLose, 0);
        panel.repaint();

        while (true) {
          panel.setComponentZOrder(imageLose, 0);
          panel.repaint();
          Thread.sleep(500);
          System.out.println("masuk kalah");
        }
      }


    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public int getWidthBackground() {
    return backgroundImage.getIconWidth();
  }

  public int getHeightBackground() {
    return backgroundImage.getIconHeight();
  }

  public int getMoney() {
    return money;
  }

  public Aquarium getAquarium() {
    return aquarium;
  }

  /**
   * tambah uang.
   *
   * @param amount baynyaknya uang
   */
  public void addMoney(int amount) {
    money += amount;
    if (money < 0) {
      money = 0;
    }
  }

}


