package cs3500.marblesolitaire.view;
import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a Marble Solitaire Text View implementing the MarbleSolitaireView interface
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private int armthickness;
  private MarbleSolitaireModelState state;

  private enum SlotStates{Invalid, Empty, Marble}

  private Appendable ap;

  /**
   * Constructs a MarbleSolitaireText View
   * @param state the state of the board
   * @param ap the appendable object
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable ap) {
    if (state == null || ap == null) {
      throw new IllegalArgumentException("Provided state or appendable is null");
    }
    this.state = state;
    this.ap = System.out;
  }

  /**
   * Constructs a MarbleSolitaireText View
   * @param state the state of the board
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) {
    if (state == null) {
      throw new IllegalArgumentException("Invalid State Provided");
    }
    else {
      this.state = state;
    }
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   * @return the game state as a string
   */
  // convert a playing board into a string
  public String toString() {
    String main = "";
    for (int row = 0; row < state.getBoardSize(); row ++) {
      String r = "";
      for (int col = 0; col < state.getBoardSize(); col ++) {

        if(state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
          r = r + " " + "_";
        }
        else if (state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Invalid) {
          r = r + " " + " ";
        }
        else if (state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
          r = r + " " + "0";
        }
        else {
          throw new IllegalArgumentException("Invalid State");
        }
      }
      main = main + r + "\n";
    }
    return main;
  }

  /**
   * transmits state of the board produced by this view
   * to the given appendable object in this constructor
   *
   * @throws IOException if transmission fails
   */
  @Override
  public void renderBoard() throws IOException {
    try {
      this.ap.append(this.toString());
    }
    catch (IOException e) {
      throw new IllegalArgumentException("Transmission Failed");
    }
  }

  /**
   * transmit the given messgae to this.ap (appendable)
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.ap.append(message);
    }
    catch (IOException e) {
      throw new IllegalArgumentException("Transmission Failed");
    }
  }

}
