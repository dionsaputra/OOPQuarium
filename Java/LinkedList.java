/**
 * Kelas Generik LinkedList, untuk elemen yang merupakan turunan dari kelas Comparable.
 * @param <T> Kelas yang diinginkan oleh elemen
 */

public class LinkedList<T extends Comparable> {
  private class ElmtList<T extends Comparable> {
    public ElmtList(T info) {
      this.info = info;
    }

    public T info;

    public ElmtList<T> next;
  }

  private ElmtList<T> first;

  private ElmtList<T> last;

  /**
   * Konstruktor dasar LinkedList
   * mengassign nilai First dan Last menjadi null.
   */

  public LinkedList() {
    first = null;
    last = null;
  }

  /**
   * Mengecek apakah LinkedList kosong.
   * @return True jika LinkedList kosong
   */

  public Boolean isEmpty() {
    return first == null;
  }

  /**
   * Memasukkan sebuah elemen ke dalam LinkedList.
   * @param elmt elemen yang ingin dimasukkan ke dalam LinkedList
   */

  public void add(T elmt) {
    if (isEmpty()) {
      first = new ElmtList<T>(elmt);
      last = first;
    } else {
      last.next = new ElmtList<T>(elmt);
      last = last.next;
    }
  }


  /**
   * Menghapus sebuah elemen dari LinkedList.
   * @param elmt elemen yang ingin diremove
   */

  public void remove(T elmt) {
    if (! isEmpty()) {
      ElmtList<T> p = first;
      ElmtList<T> prev = null;
      while (p.info.compareTo(elmt) != 0) {
        prev = p;
        p = p.next;
      }
      if (p == first) {
        if (p == last) {
          first = last = null;
        } else {
          first = p.next;
        }
      } else if (p == last) {
        prev.next = null;
        last = prev;
      } else {
        prev.next = p.next;
      }
    }
  }

  /**
   * Mencari sebuah elemen di indeks ke berapa pada list.
   * @param elmt elemen yang ingin dicari dalam list
   * @return indeks pada list, -1 jika tidak ketemu
   */

  public int find(T elmt) {
    if (isEmpty()) {
      return -1;
    } else {
      ElmtList<T> p = first;
      int idx = 0;
      while (p != null) {
        if (p.info.compareTo(elmt) == 0) {
          return idx;
        } else {
          idx++;
          p = p.next;
        }
      }
    }
    return -1;
  }

  /**
   * Mengambil sebuah objek dari indeks tertentu.
   * @param idx indeks elemen dalam list, dimulai dari 0
   * @return objek pada indeks ke idx
   */

  public T get(int idx) {
    int x = 0;
    ElmtList<T> p = first;
    while (x < idx) {
      p = p.next;
      x++;
    }
    return p.info;
  }

  /**
   * Print semua elemen yang ada pada list.
   */
  public void printAllElement() {
    if (isEmpty()) {
      System.out.println("List Empty !");
    } else {
      ElmtList<T> p = first;
      while (p != null) {
        System.out.println(p.info);
        p = p.next;
      }
    }
  }

  /**
   * Menghitung jumlah elemen dalam LinkedList.
   * @return jumlah elemen
   */

  public int totalElmt() {
    int countElmt = 0;
    ElmtList<T> p = first;
    while (p != null) {
      countElmt++;
      p = p.next;
    }
    return countElmt;
  }
}