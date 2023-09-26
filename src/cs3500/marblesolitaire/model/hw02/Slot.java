package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import java.util.ArrayList;

/**
 * Represents a slot on the board
 */
public class Slot {
  private SlotState curState;
  private Posn xy;

  /**
   * Slot constructor
   */
  public Slot() {
    this.curState = SlotState.Empty;
    this.xy = new Posn(0, 0);
  }

  /**
   * Slot constructor taking in slotstate and position
   * @param curState current state of slot
   * @param xy position of slot
   */
  public Slot(SlotState curState, Posn xy) {
    this.curState = curState;
    this.xy = xy;
  }

  /**
   * Slot constructor taking in slotstate, position, and neighbors
   * @param curState current state of slot
   * @param xy position of slot
   * @param left left neighbor
   * @param right right neighbor
   * @param top top neighbor
   * @param bottom bottom neighbor
   */
  public Slot(SlotState curState, Posn xy, Slot left, Slot right, Slot top, Slot bottom) {
    this.curState = curState;
    this.xy = xy;
  }

  /** comparing this posn to the given posn
   *
   * @param other given Posn to compare this slot's posn to
   * @return boolean
   */
  public boolean samePosn(Posn other) {
    return this.xy.x == other.x &&
            this.xy.y == other.y;
  }

  // GETTER METHODS ////////////////////////////////////////////////////////////

  /** get this slot's current state
   *
   * @return SlotState
   */
  public SlotState getState() {
    return this.curState;
  }

  /** retrieve this slot's position
   *
   * @return Posn
   */
  public Posn getPosn() {
    return this.xy;
  }

  // SETTER METHODS /////////////////

  /** set this.curState to the given SlotState
   *
   * @param newState SlotState that this.curState will be set to
   */
  public void setCurState(SlotState newState) {
    this.curState = newState;
  }

  /** set this.xy to the given Posn
   *
   * @param newXY Posn that this.xy will be set to
   */
  public void setXy(Posn newXY) {
    this.xy = newXY;
  }
}
