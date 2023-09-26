package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

/**
 * represents a triangular shaped Marble Solitaire Model, implements
 * MarbleSolitaireModel interface
 */
public class TriangularMarbleSolitaire implements MarbleSolitaireModel {
  private ArrayList<ArrayList<Slot>> boardList;
  private boolean gameOver;
  private boolean won;
  private int score;
  private int bottomWidth;

  /**
   * default constructor creating a 5 row
   * triangle with the empty slot at 0,0
   */
  public TriangularMarbleSolitaire() {
    this.gameOver = false;
    this.won = false;
    this.score = 14;
    this.bottomWidth = 5;
    this.boardList = this.initialBoard(0, 0);
  }

  /**
   * constructor creating triangle with
   * customized empty slot
   * @param row row of empty slot
   * @param col column of empty slot
   */
  public TriangularMarbleSolitaire(int row, int col) {
    this.gameOver = false;
    this.won = false;
    this.score = 14;
    this.bottomWidth = 5;
    if (row < 1 || col < 1) {
      throw new IllegalArgumentException("Invalid row or col value");
    }
    this.boardList = this.initialBoard(row, col);
  }

  /**
   * constructor to create a triangle board at a
   * specified width and the empty slot at 0,0
   *
   * @param bottomWidth number of rows in the model
   */
  public TriangularMarbleSolitaire(int bottomWidth) {
    this.gameOver = false;
    this.won = false;
    if (bottomWidth < 1) {
      throw new IllegalArgumentException("Invalid bottomWidth");
    }
    this.bottomWidth = bottomWidth;
    this.score = this.calcScore();
    this.boardList = this.initialBoard(0, 0);
  }

  /**
   * constructor to create customizable triangle board and
   * empty slot of choice
   *
   * @param row row of empty slot starting from 0
   * @param col col of empty slot starting from 0
   */
  public TriangularMarbleSolitaire(int bottomWidth, int row, int col) {
    this.gameOver = false;
    this.won = false;
    if (bottomWidth < 2) {
      throw new IllegalArgumentException("Invalid bottomWidth");
    }
    this.bottomWidth = bottomWidth;
    this.score = calcScore();
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid row or col value");
    }
    this.boardList = this.initialBoard(row, col);
  }

  /** creates 2D Array that represents the playing board
   *
   * @param row row of empty slot starting from 0
   * @param col column of empty slot starting from 0
   * @return ArrayList<ArrayList<Slot>>
   */
  public ArrayList<ArrayList<Slot>> initialBoard(int row, int col) {
    ArrayList<ArrayList<Slot>> newBoard = new ArrayList<ArrayList<Slot>>();

    for (int r = 0; r < this.bottomWidth ; r ++) {
      newBoard.add(new ArrayList<Slot>());

      for (int c = 0; c < r + 1; c ++) {
        if (r == row && c == col) {
          newBoard.get(r).add(new Slot(SlotState.Empty, new Posn(row, col)));
        }
        else {
          newBoard.get(r).add(new Slot(SlotState.Marble, new Posn(r, c)));
        }
      }
    }
    return newBoard;
  }

  /**
   * using the current board with, calculates the score
   * by adding every number less than and including the board width
   * until 0
   * @return int representing the current score
   */
  public int calcScore() {
    int score = 0;
    for (int s = 0; s <= this.bottomWidth; s ++) {
      score = score + s;
    }
    return score - 1;
  }

  /**
   * gets the board
   * @return
   */
  public ArrayList<ArrayList<Slot>> getBoard() {
    return this.boardList;
  }

  /** set boardList field to given 2D ArrayList
   *
   * @param newB new ArrayList<ArrayList<Slot>> this boardList will be set to
   */
  public void setBoardList(ArrayList<ArrayList<Slot>> newB) {
    this.boardList = newB;
  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    /*int middle = (((armthickness + 2 * (armthickness - 1)) - 1) / 2);
    int invalid = (armthickness - 1) / 2;*/

    // invalid from and to positions
    if (this.getSlotAt(fromRow, fromCol) == SlotState.Invalid || this.getSlotAt(toRow, toCol) == SlotState.Invalid) { // top right
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
    else if (! (fromRow - toRow == 0 || fromRow - toRow == 2 || fromRow - toRow == -2 &&
            fromCol - toCol == 0 || fromCol - toCol == 2 || fromCol - toCol == -2)) {
      throw new IllegalArgumentException("To slot must be 2 positions away");
    }
    //check if there is a marble between from and to position
    if( //moving right
            toCol > 0 && fromCol < this.bottomWidth && toRow == fromRow && fromCol - toCol < 0 && this.getSlotAt(fromRow, fromCol + 1) == SlotState.Empty &&
                    this.getSlotAt(toRow, toCol - 1) == SlotState.Empty ||
                    // moving left
                    fromCol > 0 && toCol < this.bottomWidth && toRow == fromRow && fromCol - toCol > 0 && this.getSlotAt(fromRow, fromCol - 1) == SlotState.Empty &&
                            this.getSlotAt(toRow, toCol + 1) == SlotState.Empty ||
                    // moving down
                    fromRow < this.bottomWidth - 1 && toRow > 0 && toCol == fromCol && fromRow < toRow && this.getSlotAt(fromRow + 1, fromCol ) == SlotState.Empty &&
                            this.getSlotAt(toRow - 1, toCol) == SlotState.Empty ||
                    // moving up
                    fromRow > 0 && fromCol < this.bottomWidth && toRow < this.bottomWidth - 1 && toCol > 0 && toCol == fromCol && fromRow > toRow && this.getSlotAt(fromRow - 1, fromCol ) == SlotState.Empty &&
                            this.getSlotAt(toRow + 1, toCol) == SlotState.Empty  ||
                    // moving diagonally up
                    fromRow - toRow == 2 && fromCol - toCol == 2 && this.getSlotAt(fromRow - 1, fromCol - 1) == SlotState.Empty && this.getSlotAt(toRow + 1, toCol + 1) == SlotState.Empty ||
                    // moving diagonally down
                    fromRow - toRow == -2 && fromCol - toCol == -2 && this.getSlotAt(fromRow + 1, fromCol + 1) == SlotState.Empty && this.getSlotAt(toRow - 1, toCol - 1) == SlotState.Empty) {
      throw new IllegalArgumentException("Must be a marble in slot between to and from slots");
    }
    // change from, to, and middle state
    else {
      // moving left or right
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
      // moving up or down
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
      // moving diagonally up or down
      else if (fromRow - toRow == 2 && fromCol - toCol == 2 ||
               fromRow - toRow == -2 && fromCol - toCol == -2) {

        // moving diagonally up
        if (fromRow - toRow == 2 && fromCol - toCol == 2) {

          this.score = this.getScore() - 1;
          this.boardList.get(fromRow).get(fromCol).setCurState(SlotState.Empty);
          this.boardList.get(toRow).get(toCol).setCurState(SlotState.Marble);
          // make middle empty
          this.boardList.get(fromRow - 1).get(fromCol - 1).setCurState(SlotState.Empty);
        }
        // moving diagonally down
        else if (fromRow - toRow == -2 && fromCol - toCol == -2) {

          this.score = this.getScore() - 1;
          this.boardList.get(fromRow).get(fromCol).setCurState(SlotState.Empty);
          this.boardList.get(toRow).get(toCol).setCurState(SlotState.Marble);
          // make middle empty
          this.boardList.get(fromRow + 1).get(fromCol + 1).setCurState(SlotState.Empty);
        }

      }
    }
  }

  @Override
  public boolean isGameOver() {
    int cantMove = 0;
    // winner if score is 1 and middle slot has a marble
    if (this.score == 1 && this.getSlotAt(0, 0) == SlotState.Marble) {
      this.won = true;
      return true;
    }
    // game over if score is 1
    else if (this.score == 1) {
      return true;
    }
    else {
      for (int r = 0; r < this.bottomWidth; r++) {
        for (int c = 0; c < this.boardList.get(r).size(); c++) {
          // add invalid slots to number of slots that cant move
          if (this.getSlotAt(r, c) == SlotState.Invalid) {
            cantMove = cantMove + 1;
          }
          // for slots in the 0th column, you cannot subtract from the column. checks for top, bottom, and right slots
          else if (c == 0) {
            if (c == 0 && r <= 2) {
              // check specifically for top slot
              if ((this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              }
              else {
                cantMove = cantMove + 1;
              }
            }
            else if (c == 0 && r == bottomWidth - 1 || r == bottomWidth - 2) {
              if ((this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              }
              else {
                cantMove = cantMove + 1;
              }
            }
            else {
              if ((this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {

                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
            // for slots in the 0th row, you cannot subtract from the row. checks for the bottom, left, and right slots
          } else if (r == 0) {
            if ((//this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    //this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty
                    this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty||
                            this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {

              cantMove = cantMove;
            } else {
              cantMove = cantMove + 1;
            }
            // for slots in the n - 1 (last) row, you cannot add to the row. checks for the top, right, and left slots
          } else if (r == this.bottomWidth - 1) {
            try {
              if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
            catch (IndexOutOfBoundsException e) {
              cantMove = cantMove + 1;
            }
            // for slots in the n - 1 (last) column, you cannot add to the column index. checks for the top, bottom, and left slots
          }
          else if (c == this.boardList.get(r).size() - 1) {
            if (r <= 2) {
              if ((this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              }
              else {
                cantMove = cantMove + 1;
              }
            }
            else if (r == this.bottomWidth - 1 || c == this.bottomWidth - 1) {
              if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c - 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              }
              else {
                cantMove = cantMove + 1;
              }
            }
            else {
              if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
            // for slots in the 1st column, you cannot subtract 2 from the column index. checks for the top, right, and bottom slots
          } else if (c == 1 ) {
            if (this.boardList.get(r).size() <= 3) {
              if ((this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c + 2).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
            else if (r == this.bottomWidth - 1 || r == this.bottomWidth - 2) {
              if ((this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
            else{
              if ((this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
          }
          // for slots in the n - 2 (2nd to last column), you cannot add 2 to the column index. checks for the top, bottom, and left slots
          else if (c == this.boardList.get(r).size() - 2) {
            try {
              if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r - 1).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c - 2).getState() == SlotState.Empty ||
                      this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
                cantMove = cantMove;
              } else {
                cantMove = cantMove + 1;
              }
            }
            catch (IndexOutOfBoundsException e) {
              cantMove = cantMove + 1;
            }
          }
          // for slots in the 2nd row, you cannot subtract 2 from the row index. checks for the left, right, and bottom slots
          else if (r == 1) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c).getState() == SlotState.Empty ||
                    this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {

              cantMove = cantMove + 1;
            }

          }
          // for slots in the second to last row, you cannot add 2 to the row index. checks for the left, bottom, and top slots
          else if (r == this.bottomWidth - 2) {
            if ((this.boardList.get(r).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c - 2).getState() == SlotState.Empty ||
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
                    this.boardList.get(r + 1).get(c + 1).getState() == SlotState.Marble && this.boardList.get(r + 2).get(c + 2).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c - 1).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c - 2).getState() == SlotState.Empty ||
                    this.boardList.get(r - 1).get(c).getState() == SlotState.Marble && this.boardList.get(r - 2).get(c).getState() == SlotState.Empty) && this.getSlotAt(r, c) == SlotState.Marble) {
              cantMove = cantMove;
            } else {

              cantMove = cantMove + 1;
            }

          }

        }
      }
      System.out.println(cantMove);
      return cantMove == this.calcScore()/*this.boardSize * this.boardSize*/;
    }
  }

  /**
   * gets the status of gameOver
   * @return
   */
  public boolean getGameOver() {
    return this.gameOver;
  }

  /** set gameOver field to given boolean
   *
   * @param over
   */
  public void setGameOver(boolean over) {
    this.gameOver = over;
  }

  /**
   * gets the status of if the game was won
   * @return
   */
  public boolean getGameWon() {
    return this.won;
  }

  /** set won field to given boolean
   *
   * @param w new boolean the won field will be set to
   */
  public void setWon(boolean w) {
    this.won = w;
  }

  /**
   * gets the score
   * @return int score
   */
  @Override
  public int getScore() {
    return this.score;
  }

  /**
   * set score to given int
   * @param newScore new integer the score field will be set to
   */
  public void setScore(int newScore) {
    this.score = newScore;
  }

  @Override
  public int getBoardSize() {
    return bottomWidth;
  }


  /** set boardSize field to given int
   *
   * @param newS new integer the board size will be set to
   */
  public void setBoardSize(int newS) {
    this.bottomWidth = newS;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }
}
