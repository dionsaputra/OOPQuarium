import sun.awt.image.ImageWatched;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

  @org.junit.jupiter.api.Test
  void isEmpty() {
    LinkedList<Integer> LLI = new LinkedList<Integer>();
    assertEquals(true, LLI.isEmpty());
    System.out.println("isEmpty success");
  }

  @org.junit.jupiter.api.Test
  void add() {
    LinkedList<Integer> LLI = new LinkedList<Integer>();
    LLI.add(5);
    assertEquals(1,LLI.totalElmt());
    System.out.println("Add success");
  }

  @org.junit.jupiter.api.Test
  void remove() {
    LinkedList<Integer> LLI = new LinkedList<Integer>();
    LLI.add(6);
    assertEquals(1,LLI.totalElmt());
    LLI.remove(6);
    assertEquals(0,LLI.totalElmt());
    System.out.println("Remove success");
  }

  @org.junit.jupiter.api.Test
  void find() {
    LinkedList<Integer> LLI = new LinkedList<Integer>();
    LLI.add(6);
    LLI.add(8);
    LLI.add(9);
    assertEquals(-1,LLI.find(12));
    assertEquals(1,LLI.find(8));
    System.out.println("Find success");
  }

  @org.junit.jupiter.api.Test
  void get() {
    LinkedList<Integer> LLI = new LinkedList<Integer>();
    LLI.add(9);
    LLI.add(4);
    assertEquals(new Integer(4),LLI.get(1));
    assertEquals(new Integer(9),LLI.get(0));
    System.out.println("Get success");

  }

  @org.junit.jupiter.api.Test
  void totalElmt() {
    LinkedList<Integer> LLI = new LinkedList<Integer>();
    LLI.add(5);
    LLI.add(9);
    assertEquals(2,LLI.totalElmt());
    LLI.add(10);
    assertEquals(3,LLI.totalElmt());
    System.out.println("totalElmt success");
  }
}