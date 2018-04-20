/**
 * Generic LinkedList class
 * @param <T> : class
 * @return Nothing
 */
public class LinkedList<T extends Comparable>{
    private class ElmtList<T extends Comparable>{
        public ElmtList(T info){
            this.info = info;
        }
        public T info;
        public ElmtList<T> next;
    }

    private ElmtList<T> First;
    private ElmtList<T> Last;

    /**
     * Construct the First and Last menjadi null
     */
    public LinkedList() {
        First = null;
        Last = null;
    }

    /**
     *
     * @return boolean if list is empty
     */
    public Boolean isEmpty(){
        return First==null;
    }

    /**
     *
     * @param elmt elemen yang infin dimasukkan
     */
    public void add(T elmt){
        if(isEmpty()){
            First = new ElmtList<T>(elmt);
            Last = First;
        }
        else{
            Last.next = new ElmtList<T>(elmt);
            Last = Last.next;
        }
>>>>>>> ffd7373bd1c0368f1de7e687eb10830278feaf52
    }
  }

<<<<<<< HEAD
  public void remove(T elmt) {
    if (isEmpty()) {
=======
    /**
     *
     * @param elmt elemen yang ingin diremove
     */
    public void remove(T elmt){
        if(isEmpty()){
>>>>>>> ffd7373bd1c0368f1de7e687eb10830278feaf52

    } else {
      ElmtList<T> P = First;
      ElmtList<T> Prev = null;
      while (P.info.compareTo(elmt) != 0) {
        Prev = P;
        P = P.next;
      }
      if (P == First) {
        if (P == Last) {
          First = Last = null;
        } else {
          First = P.next;
        }
      } else if (P == Last) {
        Prev.next = null;
        Last = Prev;
      } else {
        Prev.next = P.next;
      }
    }
  }

<<<<<<< HEAD
  public int find(T elmt) {
    if (isEmpty()) {
      return -1;
    } else {
      ElmtList<T> P = First;
      int idx = 0;
      while (P != null) {
        if (P.info.compareTo(elmt) == 0) {
          return idx;
        } else {
          idx++;
          P = P.next;
=======
    /**
     *
     * @param elmt elemen yang ingin dicari dalam list
     * @return
     */
    public int find(T elmt){
        if(isEmpty()){
            return -1;
>>>>>>> ffd7373bd1c0368f1de7e687eb10830278feaf52
        }
      }
    }
    return -1;
  }

<<<<<<< HEAD
  public T get(int idx) {
    int x = 0;
    ElmtList<T> P = First;
    while (x < idx) {
      P = P.next;
      x++;
=======
    /**
     *
     * @param idx indeks elemen dalam list, dimulai dari 0
     * @return objek pada indeks ke idx
     */
    public T get(int idx){
        int x = 0;
        ElmtList<T> P = First;
        while(x < idx){
            P = P.next;
            x++;
        }
        return P.info;
>>>>>>> ffd7373bd1c0368f1de7e687eb10830278feaf52
    }
    return P.info;
  }

<<<<<<< HEAD
  public void PrintAllElement() {
    if (isEmpty()) {
      System.out.println("List Empty !");
    } else {
      ElmtList<T> P = First;
      while (P != null) {
        System.out.println(P.info);
        P = P.next;
      }
    }
  }

  public int totalElmt() {
    int countElmt = 0;
    ElmtList<T> P = First;
    while (P != null) {
      countElmt++;
      P = P.next;
=======
    /**
     * Print semua elemen yang ada pada list
     */
    public void PrintAllElement(){
        if(isEmpty()){
            System.out.println("List Empty !");
        }
        else{
            ElmtList<T> P = First;
            while(P != null){
                System.out.println(P.info);
                P = P.next;
            }
        }
    }

    /**
     *
     * @return total elemen di dalam list
     */
    public int totalElmt(){
        int countElmt = 0;
        ElmtList<T> P = First;
        while(P != null){
            countElmt++;
            P = P.next;
        }
        return countElmt;
>>>>>>> ffd7373bd1c0368f1de7e687eb10830278feaf52
    }
    return countElmt;
  }
}