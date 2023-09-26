package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

/**
 * This class is strictly used for testing purposes. Has a log
 * (list of strings) of which keeps track of which methods were transmitted to the
 * appendable properly
 */
public class MockEnglishSolitaireModel implements MarbleSolitaireModel{

  private ArrayList<String> log;

  public MockEnglishSolitaireModel(ArrayList<String> log) {
    this.log = log;
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * In this class, if the method call to "move(int, int, int, int)" is transmitted properly to
   * the appendable, a string with the name of the method and its parameters is added to the log
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    log.add(String.format("move(%d, %d, %d, %d)", fromRow, fromCol, toRow, toCol));
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * In this class, if the method call to "isGameOver()" is transmitted properly to
   * the appendable, a string with the name of the method is added to the log
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    log.add("isGameOver()");
    return false;
  }

  /** return the boardSize of this model
   *
   * In this class, if the method call to "getBoardSize()" is transmitted properly to
   * the appendable, a string with the name of the method is added to the log
   *
   * @return int representing boardSize
   */
  @Override
  public int getBoardSize() {
    log.add("getBoardSize()");
    return 0;
  }

  /** return the slot state of the slot at the given
   *  row and column on gameboard
   *
   *  In this class, if the method call to "getSlotAt()" is transmitted properly to
   *  the appendable, a string with the name of the method and its parameters is added to the log
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    log.add(String.format("getSlotAt(%d, %d)", row, col));
    return null;
  }

  /** return the current game score
   *
   * In this class, if the method call to "getScore()" is transmitted properly to
   * the appendable, a string with the name of the method is added to the log
   *
   * @return int representing the current game score
   */
  @Override
  public int getScore() {
    log.add("getScore()");
    return 0;
  }

  /** return this.log
   *
   * @return ArrayList<String>()
   */
  public ArrayList<String> getLog() {
    return this.log;
  }

  /** set this.log to the given array list of string
   *
   * @param log ArrayList of string
   */
  public void setLog(ArrayList<String> log) {
    this.log = log;
  }
}
