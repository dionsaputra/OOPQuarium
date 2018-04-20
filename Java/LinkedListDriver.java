import java.util.*;

public class LinkedListDriver {

  public static void main(String[] args) {

        /*
        LinkedList<Integer> LLI = new LinkedList<Integer>();
        LLI.add(6);
        LLI.PrintAllElement();
        LLI.add(5);
        LLI.add(9);
        LLI.PrintAllElement();
        LLI.PrintAllElement();
        LinkedList<String> LLS = new LinkedList<String>();
        LLS.add("Ferdi");
        LLS.add("Anton");
        LLS.PrintAllElement();
        System.out.println();
        LLS.remove("Ferdi");
        LLS.add("Untung");
        LLS.add("Encop");
        LLS.add("Wildan");
        LLS.PrintAllElement();
        System.out.println();
        for(int i=0;i<LLS.totalElmt();i++){
            System.out.println(LLS.get(i));
        }
        System.out.println();
        */

    LinkedList<Point> LLP = new LinkedList<Point>();
    LLP.add(new Point(5, 3));
    LLP.add(new Point(3, 4));
    LLP.add(new Point(2, 3));
    LLP.PrintAllElement();
    LLP.remove(new Point(2, 3));
    System.out.println("Setelah Dihapus");
    LLP.PrintAllElement();
    Point P3 = LLP.get(1);
    P3.setAbsis(9);
    System.out.println("Setelah Diganti Absisnya");
    LLP.PrintAllElement();
    LLP.add(new Point(8, 9));
    LLP.add(new Point(9, 2));
    System.out.println("Contoh untuk iterasi :");
    for (int i = 0; i < LLP.totalElmt(); i++) {
      LLP.get(i).PrintInfo();
    }
  }
}