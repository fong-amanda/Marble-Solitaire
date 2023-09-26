package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;
import java.util.Arrays;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * EnglishSolitaireModel class implements MarbleSolitaireModel
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel{
  protected ArrayList<ArrayList<Slot>> boardList;
  protected boolean gameOver;
  protected boolean won;
  protected int score;
  protected int armthickness;
  protected int boardSize;
  protected final int middleSlot;
  protected final int invalidSlot;

  /**
   * Constructor 1 for EnglishSolitaireModel taking in no parameters
   */
  public EnglishSolitaireModel() {
    this.gameOver = false;
    this.won = false;
    this.armthickness = 3;
    this.boardSize = 7;
    this.middleSlot = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    this.invalidSlot = (this.armthickness - 1) / 2;
    this.boardList = initialBoard(3, 3, 3);
    this.score = score;
  }


  /**
   * Constructor 2 for EnglishSolitaireModel taking in where empty slot is
   * @param sRow x coordinate of empty slot
   * @param sCol y coordinate of empty slot
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this.gameOver = false;
    this.won = false;
    this.armthickness = 3;
    this.boardSize = 7;
    this.middleSlot = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    this.invalidSlot = (this.armthickness - 1) / 2;
    if (sRow < 2 && sCol < 2 ||
            sRow < 2 && sCol > 5 ||
            sRow > 5 && sCol < 2  ||
            sRow > 5 && sCol > 5) {
      throw new IllegalArgumentException("Invalid Empty Cell Position (" + sRow + "," + sCol + ")");
    }
    else {
      this.boardList = initialBoard(this.armthickness, sRow, sCol);
    }
    this.score = this.score;
  }

  /**
   * constructor 3 for EnglishSolitaireModel takes in arm thickness of board
   * @param armthickness arm thickness of board
   */
  public EnglishSolitaireModel(int armthickness) {
    this.gameOver = false;
    this.won = false;
    if (armthickness % 2 == 0 || armthickness < 0) {
      throw new IllegalArgumentException("Arm thickness must be an odd number!");
    }
    else {
      this.armthickness = armthickness;
    }
    this.middleSlot = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    this.invalidSlot = (this.armthickness - 1) / 2;
    this.boardSize = this.middleSlot * 2 + 1;
    this.boardList = this.initialBoard(armthickness, middleSlot, middleSlot);
    this.score = this.score;

  }

  /**
   * constructor 4 for EnglishSolitaireModel takes in arm thickness of board
   * @param armthickness arm thickness of board
   * @param row x coordinate of empty slot
   * @param column y coordinate of empty slot
   */
  public EnglishSolitaireModel(int armthickness, int row, int column) {
    this.gameOver = false;
    this.won = false;
    if (armthickness % 2 == 0 || armthickness < 0) {
      throw new IllegalArgumentException("Arm thickness must be an odd number");
    }
    else {
      this.armthickness = armthickness;
    }
    this.middleSlot = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    this.invalidSlot = (armthickness - 1) / 2;
    if (row < this.middleSlot - this.invalidSlot && column < this.middleSlot - this.invalidSlot || // top left
            row > this.middleSlot + this.invalidSlot && column > this.middleSlot + this.invalidSlot || // bottom right
            row < this.middleSlot - this.invalidSlot && column > this.middleSlot + this.invalidSlot || // bottom left
            row > this.middleSlot + this.invalidSlot && column < this.middleSlot - this.invalidSlot) {  // top right
      throw new IllegalArgumentException("Invalid Empty Position");
    }
    this.boardSize = this.middleSlot * 2 + 1;
    this.boardList = this.initialBoard(armthickness, row, column);
    this.score = this.score;

  }

  /** creates 2D Array that represents the playing board
   *
   * @param armthickness desired arm thickness that is greater than 0
   * @param sRow row of empty slot starting from 0
   * @param sCol column of empty slot starting from 0
   * @return ArrayList<ArrayList<Slot>>
   */

  public ArrayList<ArrayList<Slot>> initialBoard(int armthickness, int sRow, int sCol) {
    ArrayList<ArrayList<Slot>> board = new ArrayList<ArrayList<Slot>>();
    int middle = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    int invalidSlot = (armthickness - 1) / 2;

    if (this.armthickness < 1) {
      throw new IllegalArgumentException("Invalid arm thickness");
    } else {

      for (int r = 0; r < (armthickness + 2 * (armthickness - 1)) ; r++) {
        board.add(new ArrayList<Slot>());
        for (int c = 0; c < (armthickness + 2 * (armthickness - 1)) ; c++) {
          if (this.isInvalid(r, c)) {
            board.get(r).add(new Slot(SlotState.Invalid, new Posn(r, c)));

          }
          else if ( r == sRow && c == sCol) {
            board.get(r).add(new Slot(SlotState.Empty, new Posn(r, c)));

          }
          else {
            board.get(r).add(new Slot(SlotState.Marble, new Posn(r, c)));

          }
        }
      }
    }
    return board;
  }

  ///////// GAME PLAY METHODS //////////////////////////////////////////////////////

  /** changes the SlotState of 3 marbles on the board
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {

    int middle = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    int invalid = (armthickness - 1) / 2;

    // invalid from and to positions
    if (this.isInvalid(fromRow, fromCol) || this.isInvalid(toRow, toCol)) { // top right
      throw new IllegalArgumentException("Invalid Position");
    }
    // check if from slot has a marble
    else if (this.getSlotAt(fromRow, fromCol) == SlotState.Empty) {
      throw new IllegalArgumentException("From Slot is Empty");
    }
    // check if to position is empty
    else if (this.getSlotAt(toRow, toCol) == SlotState.Marble) {
      throw new IllegalArgumentException("To Slot has a Marble");
    }
    // check if to and from are two positions away
    else if (!(fromRow - toRow == 0 || fromRow - toRow == 2 || toRow - fromRow == -2 ||
            fromCol - toCol == 0 || fromCol - toCol == 2 || toCol - fromCol == -2)) {
      throw new IllegalArgumentException("To slot must be 2 positions away");
    }
    //check if there is a marble between from and to position
    if( //moving right
            toCol > 0 && fromCol < this.boardSize && toRow == fromRow && fromCol - toCol < 0 && this.getSlotAt(fromRow, fromCol + 1) == SlotState.Empty &&
                    this.getSlotAt(toRow, toCol - 1) == SlotState.Empty ||
                    // moving left
                    fromCol > 0 && toCol < this.boardSize && toRow == fromRow && fromCol - toCol > 0 && this.getSlotAt(fromRow, fromCol - 1) == SlotState.Empty &&
                            this.getSlotAt(toRow, toCol + 1) == SlotState.Empty ||
                    // moving down
                    fromRow < this.boardSize - 1 && toRow > 0 && toCol == fromCol && fromRow < toRow && this.getSlotAt(fromRow + 1, fromCol ) == SlotState.Empty &&
                            this.getSlotAt(toRow - 1, toCol) == SlotState.Empty ||
                    // moving up
                    fromRow > 0 && fromCol < this.boardSize && toRow < this.boardSize - 1 && toCol > 0 && toCol == fromCol && fromRow > toRow && this.getSlotAt(fromRow - 1, fromCol ) == SlotState.Empty &&
                            this.getSlotAt(toRow + 1, toCol) == SlotState.Empty) {
      throw new IllegalArgumentException("Must be a marble in slot between to and from slots");
    }
    // change from, to, and middle state
    else {
      if (fromRow == toRow) {

        if (fromCol - 1 == toCol + 1) {

          this.score = this.getScore() - 1;
          this.boardList.get(fromRow).get(fromCol).setCurState(SlotState.Empty);
          this.boardList.get(toRow).get(toCol).setCurState(SlotState.Marble);
          //middle marble
          this.boardList.get(fromRow).get(fromCol - 1).setCurState(SlotState.Empty);
        }
        else if (fromCol + 1 == toCol - 1) {

          this.score = this.getScore() - 1;
          this.boardList.get(fromRow).get(fromCol).setCurState(SlotState.Empty);
          this.boardList.get(toRow).get(toCol).setCurState(SlotState.Marble);
          //middle marble
          this.boardList.get(fromRow).get(fromCol + 1).setCurState(SlotState.Empty);
        } else {throw new IllegalArgumentException("Invalid Move");}
      }
      // same columns to remove middle
      else if (fromCol == toCol) {

        if (fromRow - 1 == toRow + 1) {

          this.score = this.getScore() - 1;
          this.boardList.get(fromRow).get(fromCol).setCurState(SlotState.Empty);
          this.boardList.get(toRow).get(toCol).setCurState(SlotState.Marble);
          //middle marble
          this.boardList.get(fromRow - 1).get(fromCol).setCurState(SlotState.Empty);
        }
        else if (fromRow + 1 == toRow - 1) {

          this.score = this.getScore() - 1;
          this.boardList.get(fromRow).get(fromCol).setCurState(SlotState.Empty);
          this.boardList.get(toRow).get(toCol).setCurState(SlotState.Marble);
          //middle marble
          this.boardList.get(fromRow + 1).get(fromCol).setCurState(SlotState.Empty);
        }

      }
    }
  }

  /**
   * checks if the given row and column position has a SlotState of Invalid
   * @param r row of slot
   * @param c column of slot
   * @return boolean
   */
  public boolean isInvalid(int r, int c) {
    return r < this.middleSlot - this.invalidSlot && c < this.middleSlot - this.invalidSlot || // top left
            r > this.middleSlot + this.invalidSlot && c > this.middleSlot + this.invalidSlot || // bottom right
            r < this.middleSlot - this.invalidSlot && c > this.middleSlot + this.invalidSlot || // top right
            r > this.middleSlot + this.invalidSlot && c < this.middleSlot - this.invalidSlot;
  }

  /**
   * Checks if the game is over depending on the state of the slots.
   * If a slot isn't a marble and none of the n + 1 slots surrounding it doesn't have a marble and
   * none of the n + 2 slots surrounding it arent empty, 1 is added to the cantMove variable
   * @return boolean
   */
  public boolean isGameOver() {
    int cantMove = 0;
    // winner if score is 1 and middle slot has a marble
    if (this.score == 1 && this.getSlotAt(this.middleSlot, this.middleSlot) == SlotState.Marble) {
      this.won = true;
      return true;
    }
    // game over if score is 1
    else if (this.score == 1) {
      return true;
    }
    else {
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
            }
            else {
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
          } else if (c == 1 ) {
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
      return cantMove == this.boardSize * this.boardSize;
    }
  }

  // GETTERS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * returns the longest dimension of the board
   * @return int
   */
  public int getBoardSize() {
    return this.boardSize;
  }

  /**
   * return slot state of the given position
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return SlotState
   * @throws IllegalArgumentException
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    Slot slot = this.boardList.get(row).get(col);
    if (row < 0 || row > this.getBoardSize() * 2 || col < 0 || col > this.getBoardSize() * 2) {
      throw new IllegalArgumentException("Invalid column or row");
    } else {
      if (slot.getState() == SlotState.Invalid) {
        return SlotState.Invalid;
      } else if (!(slot.getState() == SlotState.Marble)) {
        return SlotState.Empty;
      } else {
        return SlotState.Marble;
      }
    }
  }

  /**
   * retrieve current score
   * @return int
   */
  public int getScore() {
    /*
    int score = 0;
    for(ArrayList<Slot> r : this.boardList) {
      for(Slot slot : r) {
        if (slot.getState() == SlotState.Marble) {
          score = score + 1;
        }
        else {
          this.score = score;
        }
      }
    }

     */
    return score;
  }

  /**
   * grants access to gameOver field
   * @return boolean
   */
  public boolean getGameOver() {
    return  this.gameOver;
  }

  /**
   * grants access to private field won
   * @return boolean
   */
  public boolean getWon() {
    return this.won;
  }

  /**
   * grants access to private field boardList
   * @return ArrayList<ArrayList<Slot>>
   */
  public ArrayList<ArrayList<Slot>> getBoard() {
    return this.boardList;
  }

  /**
   * grants access to private field armthickness
   * @return int
   */
  public int getArmthickness() {
    return this.armthickness;
  }

  /**
   * grants access to private field middleSlot
   * @return int
   */
  public int getMiddle() {
    return this.middleSlot;
  }

  /**
   * grants access to private field invalidSlot
   * @return int
   */
  public int getInvalid() {
    return this.invalidSlot;
  }

  // SETTERS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * set score to given int
   * @param newScore new integer the score field will be set to
   */
  public void setScore(int newScore) {
    this.score = newScore;
  }

  /**
   * set won field to given boolean
   * @param w new boolean the won field will be set to
   */
  public void setWon(boolean w) {
    this.won = w;
  }

  /**
   * set boardList field to given 2D ArrayList
   * @param newB new ArrayList<ArrayList<Slot>> this boardList will be set to
   */
  public void setBoardList(ArrayList<ArrayList<Slot>> newB) {
    this.boardList = newB;
  }

  /**
   * set gameOver field to given boolean
   * @param over
   */
  public void setGameOver(boolean over) {
    this.gameOver = over;
  }

  /**
   * set boardSize field to given int
   * @param newS new integer the board size will be set to
   */
  public void setBoardSize(int newS) {
    this.boardSize = newS;
  }

  /**
   * set armthickness field to given int
   * @param newA new integer the armthickness will be set to
   */
  public void setArmthickness(int newA) {
    this.armthickness = newA;
  }
}
