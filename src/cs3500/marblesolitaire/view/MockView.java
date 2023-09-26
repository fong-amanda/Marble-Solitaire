package cs3500.marblesolitaire.view;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is strictly used for testing purposes. Has a log
 * (list of strings) of which keeps track of which methods were transmitted to the
 * appendable properly
 */
public class MockView implements MarbleSolitaireView{

  private ArrayList<String> log ;

  public MockView(ArrayList<String> log) {
    this.log = log;
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * In this class, if the method call to "toString()" is transmitted properly to
   * the appendable, a string with the name of the method is added to the log
   *
   * @return the game state as a string
   */
  public String toString() {
    log.add("toString()");
    return "";
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * In this class, if the method call to "renderBoard()" is transmitted properly to
   * the appendable, a string with the name of the method is added to the log
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  public void renderBoard() throws IOException {
    log.add("renderBoard()");
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * In this class, if the method call to "renderMessage(String message)" is transmitted properly to
   * the appendable, a string with the name of the method and its input is added to the log
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  public void renderMessage(String message) throws IOException {
    log.add(String.format("renderMessage(%s)", message));
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
