package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a position
 */
public class Posn {
  int x;
  int y;

  /**
   * Posn constructor
   * @param x x coordinate of posn
   * @param y y coordinate of posn
   */
  public Posn(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * checking if this posn and a given posn are the same
   * @param other given posn to compare this posn to
   * @return boolean returns true if posns are equal
   */
  public boolean equals(Posn other) {
    return this.x == other.x &&
            this.y == other.y;
  }

  /**
   * getting x coordinate of posn
   * @return int x coordinate
   */
  public int getx() {
    return this.x;
  }

  /**
   * getting y coordinate of posn
   * @return int y coordinate
   */
  public int gety() {
    return this.y;
  }

  /**
   * setting x coordinate of posn
   * @param newX new x coordinate
   */
  public void setX(int newX) {
    this.x = newX;
  }

  /**
   * setting y coordinate of posn
   * @param newY  new y coordinate
   */
  public void setY(int newY) {
    this.y = newY;
  }
}
