package cs3500.marblesolitaire.view;

import java.io.IOException;
import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.Slot;
import cs3500.marblesolitaire.model.hw02.TriangularMarbleSolitaire;

/**
 * TriangularSolitaireTextView class that represents the view of the game implementing MarbleSolitaireView
 */
public class TriangularSolitaireTextView implements MarbleSolitaireView {

  private TriangularMarbleSolitaire state;
  private Appendable ap;

  /**
   * Constructor for the TriangularSolitaireTextView class
   * @param state the state of the game
   * @param ap the appendable object
   */
  public TriangularSolitaireTextView(TriangularMarbleSolitaire state, Appendable ap) {
    this.state = state;
    this.ap = ap;
  }

  /**
   * Constructor for the TriangularSolitaireTextView class
   * @param state the state of the game
   */
  public TriangularSolitaireTextView(TriangularMarbleSolitaire state) {
    this.state = state;
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   * @return the game state as a string
   */
  @Override
  public String toString() {
    String board = "";

    for (ArrayList<Slot> row : state.getBoard()) {
      String r = "";

      int spaces = state.getBoardSize() - row.size();

      for (int s = 0; s < spaces; s ++) {
        r = r + " ";
      }

      for (Slot s : row) {
        if (s.getState() == MarbleSolitaireModelState.SlotState.Invalid) {
          r = r + "  ";
        }
        if (s.getState() == MarbleSolitaireModelState.SlotState.Empty) {
          r = r + " _";
        }
        if (s.getState() == MarbleSolitaireModelState.SlotState.Marble) {
          r = r + " 0";
        }
      }
      board = board + "\n" + r;

    }
    return board;
  }

  /** transmits the  toString() method to the terminal
   *
   * @throws IOException
   */
  @Override
  public void renderBoard() throws IOException {
    ap.append(this.toString() + "\n");
  }

  /** attach a message to the appendable to be displayed in the terminal
   *
   * @param message the message to be transmitted
   * @throws IOException
   */
  @Override
  public void renderMessage(String message) throws IOException {
    ap.append(message);
  }
}
