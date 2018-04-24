import java.util.*;

public class LinkedListDriver {

  public static void main(String[] args) {
    
    LinkedList<Point> llp = new LinkedList<Point>();
    llp.add(new Point(5, 3));
    llp.add(new Point(3, 4));
    llp.add(new Point(2, 3));
    llp.printAllElement();
    llp.remove(new Point(2, 3));
    System.out.println("Setelah Dihapus");
    llp.printAllElement();
    Point point = llp.get(1);
    point.setAbsis(9);
    System.out.println("Setelah Diganti Absisnya");
    llp.printAllElement();
    llp.add(new Point(8, 9));
    llp.add(new Point(9, 2));
    System.out.println("Contoh untuk iterasi :");
    for (int i = 0; i < llp.totalElmt(); i++) {
      System.out.println(llp.get(i));
    }
  }
}