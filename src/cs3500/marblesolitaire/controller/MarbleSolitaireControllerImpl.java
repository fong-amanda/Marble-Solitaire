package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.TriangularMarbleSolitaire;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
/*import static java.lang.StringUTF16.charAt;*/

/**
 * Represents a controller for the Marble Solitaire game. Takes in a model and a view and
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable rd;
  private Boolean gameOver;

  /**
   * Constructs a MarbleSolitaireControllerImpl object
   * @param model the model for the game
   * @param view the view for the game
   * @param rd the readable object for the game
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view, Readable rd) {
    if (model == null || view == null || rd == null) {
      throw new IllegalArgumentException("Model, View, or Readable is null");
    }
    this.model = model;
    this.view = view;
    this.rd = rd;
    this.gameOver = false;
  }

  /**
   *  checks if an input is a negative number or a letter that isn't q/Q.
   *  If the input is a q, the game is ended. If the input is a letter that
   *  is not q/Q or is negative, method returns true
   *
   * @param c input to be checked if valid
   * @return boolean determining whether input is invalid
   */
  private boolean isInvalid(String c) throws IOException{
    if (c.equalsIgnoreCase("q")) {
      this.view.renderMessage("Game Quit!" + "\n");
      this.view.renderMessage("State of game when quit: " + "\n" );
      this.view.renderBoard();
      this.view.renderMessage("Score: " + model.getScore() + "\n");
      this.view.renderMessage("Thanks for playing!");
      System.exit(0); // end the program
    }
    return !isDigit(c.charAt(0)) || Integer.parseInt(c) < 0;
  }


  /** checks user input to make sure a negative number or letter that isn't q
   * does not pass through the move method. Keeps asking for input until valid
   * answer is entered. Quits program if input is q/Q
   *
   * @param i String, user input
   * @return String, user input if it passes constraints
   * @throws IOException if quit attempt is not transmitted
   */
  private String checkInput(String i) throws IOException {
    Scanner sc = new Scanner(rd);

    // user quits
    if (i.equalsIgnoreCase("q")) {
      this.gameOver = true;
      try {
        this.view.renderMessage("Game Quit!" + "\n");
        this.view.renderMessage("State of game when quit: " + "\n");
        this.view.renderBoard();
        this.view.renderMessage("Score: " + model.getScore() + "\n");
        this.view.renderMessage("Thanks for playing!");
      }
      catch (IOException e) {
       throw new IllegalArgumentException("Message Not Transmitted");
      }
    }

    // input is negative number or letter that isn't q
    else if ( !(isDigit(i.charAt(0))) || Integer.parseInt(i) <= 0) {
      // keep asking for input until it is correct
      while (this.isInvalid(i)) {
        this.view.renderMessage("Invalid Input. Please re-enter" + "\n");
        i = sc.next();
        if (!this.isInvalid(i)) {
          i = i;
          break;
        }
      }
      // if the next input is correct, set i to the input
      i = i;
    }
    return i;
    }


  /**
   * play english marble solitaire. Accepts inputs from a user
   * and modifies the Marble Solitaire Model for each move
   *
   * @throws IllegalStateException, IOException
   */
  @Override
  public void playGame() throws IllegalStateException, IOException {
    Scanner sc = new Scanner(rd); // taking user input1
    // welcome message
    view.renderMessage("Welcome to the Marble Solitaire Game!" + "\n" +
            "Enter Any Key to Begin" + "\n" +
            "Enter q at anytime to quit" + "\n");

    // begin game
    while (!gameOver) {
        int score = model.getScore(); // retrieve score from model
        view.renderMessage("Score: " + score + "\n"); // render score
        view.renderBoard(); // render the current state of the game

        // player enters an int
        int fromRow, fromCol, toRow, toCol;
        try {
          // take from position
          view.renderMessage("Slot to move from: " + "\n");
          fromRow = Integer.parseInt(checkInput(sc.next())); // fromRow input
          fromCol = Integer.parseInt(checkInput(sc.next())); // fromCol input

          // take to position
          view.renderMessage("Slot to move to: " + "\n");
          toRow = Integer.parseInt(checkInput(sc.next()));  // toRow input
          toCol = Integer.parseInt(checkInput(sc.next())); // toCol input

          // make a move
          System.out.println("Moving marble from (" + fromRow + ", " + fromCol + ")" +
                  " to (" + toRow + ", " + toCol + ")");

          // make a move and catch any mistakes made
          try {
            this.model.move(fromRow - 1, fromCol -1 , toRow - 1, toCol - 1);
            if (model.isGameOver()) {
              this.gameOver = true;
              break;
            }
          }
          // move exceptions
          catch (IllegalArgumentException e) {
            this.view.renderMessage("Invalid Move Made. Play Again." + e);
          }
          catch (IndexOutOfBoundsException e) {
            if (model instanceof TriangularMarbleSolitaire) {
              ;
            }
            else {
              this.view.renderMessage("Invalid Move Made, Index out of Bounds. Play Again." + e);
            }
          }
        }
        // quiting
        catch (IllegalArgumentException e) {
          break;
        }

      } // end of while

    } // end of playGame()

// GETTERS AND SETTERS /////////////////////////////////////////////////////////////
  /**
   * getter methods for the controller
   * @return model, view, rd, gameOver
   */
  public MarbleSolitaireModel getModel() {
    return model;
  }

  /**
   * getter methods for the controller
   * @return model, view, rd, gameOver
   */
  public MarbleSolitaireView getView() {
    return view;
  }

  /**
   * getter methods for the controller
   * @return model, view, rd, gameOver
   */
  public Readable getRd() {
    return rd;
  }

  /**
   * getter methods for the controller
   * @return model, view, rd, gameOver
   */
  public Boolean getGameOver() {
    return gameOver;
  }

  /**
   * setter methods for the controller
   * @param m model, view, rd, gameOver
   */
  public void setModel(MarbleSolitaireModel m) {
    this.model = m;
  }

  /**
   * setter methods for the controller
   * @param v model, view, rd, gameOver
   */
  public void setView(MarbleSolitaireView v) {
    this.view = v;
  }

  /**
   * setter methods for the controller
   * @param r model, view, rd, gameOver
   */
  public void setRd(Readable r) {
    this.rd = r;
  }

  /**
   * setter methods for the controller
   * @param g model, view, rd, gameOver
   */
  public void setGameOver(Boolean g) {
    this.gameOver = g;
  }
}
