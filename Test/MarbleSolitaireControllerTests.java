import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MockEnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.MockView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the MarbleSolitaireController class
 */
public class MarbleSolitaireControllerTests {

  MarbleSolitaireModelState model = new EnglishSolitaireModel();
  StringBuilder out = new StringBuilder();
  StringReader rd = new StringReader("q");
  MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
  StringBuilder output = new StringBuilder();
  String text [] = output.toString().split("\n");
  MarbleSolitaireController controller = new MarbleSolitaireControllerImpl((MarbleSolitaireModel) model, view, rd);

  /**
   * Test Constructors
   */
  @Test
  public void testMarbleSolitaireControllerImplTestConstructor() {
    try {
      MarbleSolitaireControllerImpl nullModel =
              new MarbleSolitaireControllerImpl(null, view, rd);
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException because of null model");
    }
    try {
      MarbleSolitaireControllerImpl nullView =
              new MarbleSolitaireControllerImpl((MarbleSolitaireModel) model, null, rd);
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException because of null view");
    }
    try {
      MarbleSolitaireControllerImpl nullReader =
              new MarbleSolitaireControllerImpl((MarbleSolitaireModel) model, view, null);
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException because of null reader");
    }
  }

  /**
   * Test when user types "q" during playGame program
   * @throws IOException
   */
  @Test
  public void testPlayGameQuitq() throws IOException {
    Readable r = new StringReader("q"); // user move
    ArrayList<String> log = new ArrayList<String>();
    MockEnglishSolitaireModel mock = new MockEnglishSolitaireModel(log);
    controller = new MarbleSolitaireControllerImpl((MarbleSolitaireModel) mock, view, r);
    controller.playGame();

    ArrayList<String> logExpected = new ArrayList<>();
    logExpected.add("getScore()");
    logExpected.add("getScore()");


    assertEquals(logExpected, log);

  }

  /**
   * Test when user types "Q" during playGame program
   * @throws IOException
   */
  @Test
  public void testPlayGameQuitQ() throws IOException {
    Readable r = new StringReader("Q"); // user move
    ArrayList<String> log = new ArrayList<String>();
    MockEnglishSolitaireModel mock = new MockEnglishSolitaireModel(log);
    controller = new MarbleSolitaireControllerImpl((MarbleSolitaireModel) mock, view, r);
    controller.playGame();

    ArrayList<String> logExpected = new ArrayList<>();
    logExpected.add("getScore()");
    logExpected.add("getScore()");


    assertEquals(logExpected, log);

  }

  /** tests when user makes a move then quits the game
   *
   * @throws IOException
   */
  @Test
  public void testPlayGameMoveAndQuit() throws IOException {
    Readable r = new StringReader("2 4 4 4 q"); // user move
    ArrayList<String> log = new ArrayList<String>();
    MockEnglishSolitaireModel mock = new MockEnglishSolitaireModel(log);
    controller = new MarbleSolitaireControllerImpl((MarbleSolitaireModel) mock, view, r);
    controller.playGame();

    ArrayList<String> logExpected = new ArrayList<>();
    logExpected.add("getScore()");
    logExpected.add("move(1, 3, 3, 3)"); // actual move (subtracting 1 from each input to run properly through move)
    logExpected.add("isGameOver()");
    logExpected.add("getScore()");
    logExpected.add("getScore()");


    assertEquals(logExpected, log);

  }

  /** Test passing invalid number through playGame()
   *
   * @throws IOException
   */
  @Test
  public void testPlayGameInvalidNumber() throws IOException {
    Readable r = new StringReader("-2 2 4 4 4 q"); // user move
    ArrayList<String> log = new ArrayList<String>();
    MockEnglishSolitaireModel mock = new MockEnglishSolitaireModel(log);
    controller = new MarbleSolitaireControllerImpl((MarbleSolitaireModel) mock, view, r);

    try {
      controller.playGame();
    }
    catch (NoSuchElementException e) {
      System.out.println(e);
    }

    ArrayList<String> logExpected = new ArrayList<>();
    logExpected.add("getScore()");

    assertEquals(logExpected, log);

  }

  /** Test passing invalid letter through playGame()
   *
   * @throws IOException
   */
  @Test
  public void testPlayGameInvalidLetter() throws IOException {
    Readable r = new StringReader("a 2 4 4 4 q"); // user move
    ArrayList<String> log = new ArrayList<String>();
    MockEnglishSolitaireModel mock = new MockEnglishSolitaireModel(log);
    controller = new MarbleSolitaireControllerImpl((MarbleSolitaireModel) mock, view, r);

    try {
      controller.playGame();
    }
    catch (NoSuchElementException e) {
      System.out.println(e);
    }

    ArrayList<String> logExpected = new ArrayList<>();
    logExpected.add("getScore()");

    assertEquals(logExpected, log);

  }

  /**
   * Test the MockEnglishSolitaireModel Class and its methods
   * @throws IOException
   */
  @Test
  public void testMockEnglishSolitaireModel() throws IOException {
    ArrayList<String> log = new ArrayList<String>();
    MarbleSolitaireModel mockModel = new MockEnglishSolitaireModel(log);

    ArrayList<String> expectedLog  = new ArrayList<String>();
    mockModel.getScore();
    mockModel.isGameOver();
    mockModel.getSlotAt(1, 2);
    mockModel.getBoardSize();
    mockModel.move(1, 2, 3, 4);

    expectedLog.add("getScore()");
    expectedLog.add("isGameOver()");
    expectedLog.add("getSlotAt(1, 2)");
    expectedLog.add("getBoardSize()");
    expectedLog.add("move(1, 2, 3, 4)");

    assertEquals(expectedLog, log);
    assertEquals(mockModel.isGameOver(), false);
    assertEquals(mockModel.getSlotAt(1, 2), null);
    assertEquals(mockModel.getScore(), 0);
    assertEquals(mockModel.getBoardSize(), 0);
  }


}
