package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

/**
 * EuropeanMarbleSolitaire Model implementing MarbleSolitaireModel
 */

public class EuropeanMarbleSolitaire extends EnglishSolitaireModel {

  /**
   * Constructor 1 for EuropeanMarbleSolitaire taking in no parameters
   */
  public EuropeanMarbleSolitaire() {
    super();
    this.score = ((this.getBoardSize() * this.getArmthickness()) + 2 *
            (((this.getArmthickness() + (this.getBoardSize() - 2)) / 2) * (this.getArmthickness() - 1))) - 1;
  }

  /**
   * Constructor 2 for EuropeanMarbleSolitaire taking coordinates for empty slot
   * @param row x coordinate of empty slot
   * @param col y coordinate of empty slot
   */
  public EuropeanMarbleSolitaire(int row, int col) {
    super(row, col);
    this.score = ((this.getBoardSize() * this.getArmthickness()) + 2 *
            (((this.getArmthickness() + (this.getBoardSize() - 2)) / 2) * (this.getArmthickness() - 1))) - 1;
  }

  /**
   * Constructor 3 for EuropeanMarbleSolitaire taking in armthickness
   * @param armthickness armthickness of board
   */
  public EuropeanMarbleSolitaire(int armthickness) {
    super(armthickness);
    this.score = ((this.getBoardSize() * this.getArmthickness()) + 2 *
            (((this.getArmthickness() + (this.getBoardSize() - 2)) / 2) * (this.getArmthickness() - 1))) - 1;
  }

  /**
   * Constructor 1 for EuropeanMarbleSolitaire taking in no parameters
   * @param armthickness armthickness of board
   * @param row x coordinate of empty slot
   * @param col y coordinate of empty slot
   */
  public EuropeanMarbleSolitaire(int armthickness, int row, int col) {
    super(armthickness, row, col);
    this.score = ((this.getBoardSize() * this.getArmthickness()) + 2 *
            (((this.getArmthickness() + (this.getBoardSize() - 2)) / 2) * (this.getArmthickness() - 1))) - 1;
  }


  @Override
  /** checks if the given row and column position has a SlotState of Invalid
   *
   * @param r row of slot
   * @param c column of slot
   * @return boolean
   */
  public boolean isInvalid(int r, int c) {
    return r + c < this.middleSlot - this.invalidSlot || // top left
            c - r > this.middleSlot + this.invalidSlot || // bottom right
            r - c > this.middleSlot + this.invalidSlot || // top right
            r + c > (3 * this.middleSlot) + this.invalidSlot; // bottom left
  }

  /**
   * Checks if the game is over depending on the state of the slots.
   * If a slot isn't a marble and none of the n + 1 slots surrounding it doesn't have a marble and
   * none of the n + 2 slots surrounding it arent empty, 1 is added to the cantMove variable
   * @return boolean
   */
  @Override
  public boolean isGameOver() {
    int cantMove = 0;
    // winner if score is 1 and middle slot has a marble
    if (this.score == 1 && this.getSlotAt(this.middleSlot, this.middleSlot) == SlotState.Marble) {
      this.won = true;
      this.gameOver = true;
      return true;
    }
    // game over if score is 1
    else if (this.score == 1) {
      this.gameOver = true;
      return true;
    } else {
      for (int r = 0; r < this.boardSize; r++) {
        for (int c = 0; c < this.boardSize; c++) {
          // add invalid slots to number of slots that cant move
          if (this.isInvalid(r, c)) {
            cantMove = cantMove + 1;
          }
          // for slots in the 0th column, you cannot subtract from the column. checks for top, bottom, and right slots
          else if (c == 0) {
            if ((this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {

              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
            // for slots in the 0th row, you cannot subtract from the row. checks for the bottom, left, and right slots
          } else if (r == 0) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {

              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
            // for slots in the n - 1 (last) row, you cannot add to the row. checks for the top, right, and left slots
          } else if (r == this.getBoardSize() - 1) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
            // for slots in the n - 1 (last) column, you cannot add to the column index. checks for the top, bottom, and left slots
          } else if (c == this.getBoardSize() - 1) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
            // for slots in the 1st column, you cannot subtract 2 from the column index. checks for the top, right, and bottom slots
          } else if (c == 1) {
            if ((this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
          }
          // for slots in the n - 2 (2nd to last column), you cannot add 2 to the column index. checks for the top, bottom, and left slots
          else if (c == this.boardSize - 2) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
          }
          // for slots in the 2nd row, you cannot subtract 2 from the row index. checks for the left, right, and bottom slots
          else if (r == 1) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {

              cantMove = cantMove + 1;
            }

          }
          // for slots in the second to last row, you cannot add 2 to the row index. checks for the left, bottom, and top slots
          else if (r == this.boardSize - 2) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {

              cantMove = cantMove + 1;
            }
          }
          // for slots that are not in the 0th, n-1, or n-2 rows or columns
          else {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
          }
        }
      }
      if (cantMove == this.boardSize * this.boardSize) {
        this.gameOver = true;
      } else {
        this.gameOver = false;
      }
      return cantMove == this.boardSize * this.boardSize;
    }
  }
}



