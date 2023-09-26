
import org.junit.Test;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.EuropeanMarbleSolitaire;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw02.Posn;
import cs3500.marblesolitaire.model.hw02.Slot;
import cs3500.marblesolitaire.model.hw02.TriangularMarbleSolitaire;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangularSolitaireTextView;

import static org.junit.Assert.*;

/**
 * Tests for the English Marble Solitaire Model
 */
public class EnglishMarbleSolitaireTest {

  EnglishSolitaireModel ems1 = new EnglishSolitaireModel();
  EnglishSolitaireModel ems2 = new EnglishSolitaireModel(2, 2);
  EnglishSolitaireModel ems3 = new EnglishSolitaireModel(5);
  EnglishSolitaireModel ems4 = new EnglishSolitaireModel(7, 9, 9);

  MarbleSolitaireView text1 = new MarbleSolitaireTextView(ems1);
  MarbleSolitaireView text2 = new MarbleSolitaireTextView(ems2);
  MarbleSolitaireView text3 = new MarbleSolitaireTextView(ems3);
  MarbleSolitaireView text4 = new MarbleSolitaireTextView(ems4);



  ArrayList<ArrayList<Slot>> initBoard = ems1.initialBoard(3, 3,3);

  // CONSTRUCTOR TESTS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /** tests the fields of the first constructor
   *
   */
  @Test
  public void testFirstConstructor() {
    assertEquals(ems1.getGameOver(), false);
    assertEquals(ems1.getWon(), false);
    assertEquals(ems1.getScore(), 32);
    assertEquals(ems1.getArmthickness(), 3);
    assertEquals(ems1.getBoardSize(), 7);
    assertEquals(ems1.getMiddle(), 3);
    assertEquals(ems1.getInvalid(), 1);
    assertEquals(ems1.getBoard().size(), 7);
    assertEquals(ems1.getBoard().get(1).size(), 7);
    assertEquals(ems1.getSlotAt(3, 3), SlotState.Empty);
  }

  /**
   *  tests the fields of the second constructor
   */
  @Test
  public void testSecondConstructor() {
    assertEquals(ems2.getGameOver(), false);
    assertEquals(ems2.getWon(), false);
    assertEquals(ems2.getScore(), 32);
    assertEquals(ems2.getArmthickness(), 3);
    assertEquals(ems2.getBoardSize(), 7);
    assertEquals(ems2.getMiddle(), 3);
    assertEquals(ems2.getInvalid(), 1);
    assertEquals(ems2.getBoard().size(), 7);
    assertEquals(ems2.getSlotAt(3, 3), SlotState.Marble);
    assertEquals(ems2.getSlotAt(2, 2), SlotState.Empty);

    try {
      new EnglishSolitaireModel(1, 1);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Invalid empty position exception thrown");
    }
  }

  /** tests the fields of the third constructor & its constructors
   *
   */
  @Test
  public void testThirdConstructor() {
    assertEquals(ems3.getGameOver(), false);
    assertEquals(ems3.getWon(), false);
    assertEquals(ems3.getScore(), 104);
    assertEquals(ems3.getArmthickness(), 5);
    assertEquals(ems3.getBoardSize(), 13);
    assertEquals(ems3.getMiddle(), 6);
    assertEquals(ems3.getInvalid(), 2);
    assertEquals(ems3.getBoard().size(), 13);
    assertEquals(ems3.getSlotAt(6, 6), SlotState.Empty);

    try {
      new EnglishSolitaireModel(2);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Invalid arm thickness exception thrown");
    }
  }

  /** tests the fields of the fourth constructor & its constructors
   *
   */
  @Test
  public void testFourthConstructor() {
    assertEquals(ems4.getGameOver(), false);
    assertEquals(ems4.getWon(), false);
    // assertEquals(ems4.getScore(), 314);
    assertEquals(ems4.getArmthickness(), 7);
    assertEquals(ems4.getBoardSize(), 19);
    assertEquals(ems4.getMiddle(), 9);
    assertEquals(ems4.getInvalid(), 3);
    assertEquals(ems4.getBoard().size(), 19);
    assertEquals(ems4.getSlotAt(9, 9), SlotState.Empty);

    try {
      new EnglishSolitaireModel(2, 1, 1);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Invalid arm thickness exception thrown");
    }
    try {
      new EnglishSolitaireModel(5, 1, 1);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Invalid empty position exception thrown");
    }
  }

  // SLOT CLASS TESTS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /** tests the samePosn method in the Slot Class
   */
  @Test
  public void testSamePosn() {
    Slot s1 = new Slot(SlotState.Empty, new Posn(1, 3));
    Slot s1b = new Slot(SlotState.Marble, new Posn(1, 3));
    Slot s2 = new Slot(SlotState.Invalid, new Posn(2, 3));

    assertEquals(s1.samePosn(s1b.getPosn()), true);
    assertEquals(s2.samePosn(s1.getPosn()), false);
    assertEquals(s1b.samePosn(s2.getPosn()), false);

    s1.setXy(new Posn(2, 3));
    assertEquals(s1.samePosn(s1b.getPosn()), false);
    assertEquals(s2.samePosn(s1.getPosn()), true);

  }

  /**
   * tests the getter methods in the Slot Class
   */
  @Test
  public void testSlotGetters() {
    Slot s1 = new Slot(SlotState.Invalid, new Posn(1, 1));
    Slot s2 = new Slot(SlotState.Marble, new Posn(1, 1));

    assertEquals(s1.getState(), SlotState.Invalid);
    assertEquals(s2.samePosn(s1.getPosn()), true);
  }

  /**
   * tests the setter methods in the Slot class
   */
  @Test
  public void testSlotSetters() {
    Slot s3 = new Slot(SlotState.Invalid, new Posn(1, 1));
    Slot s4 = new Slot();

    s4.setCurState(SlotState.Invalid);
    s4.setXy(new Posn(1, 1));

    assertEquals(s4.getState(), SlotState.Invalid);
    assertTrue(s4.getPosn().equals(s3.getPosn()));

  }

  // POSN CLASS TESTS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * tests the getter and setter methods in the Posn class
   */
  @Test
  public void TestPosnGettersAndSetters() {
    Posn p1 = new Posn(1, 1);

    assertEquals(p1.getx(), 1);
    assertEquals(p1.gety(), 1);

    p1.setX(2);
    p1.setY(2);
    assertEquals(p1.getx(), 2);
    assertEquals(p1.gety(), 2);
  }

  // ENGLISH SOLITAIRE MODEL CLASS TEST ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * tests the initial board method of all 4 constructor
   */
  @Test
  public void testInitialBoard() {
    assertEquals(ems1.initialBoard(3, 3, 3).size(), 7);
    assertEquals(ems2.initialBoard(3, 3, 3).size(), 7);
    assertEquals(ems3.initialBoard(5, 6, 6).size(), 13);
    assertEquals(ems4.initialBoard(7, 9, 9).size(), 19);
    assertEquals(ems1.initialBoard(3, 3, 3).get(1).size(), 7);
    assertEquals(ems2.initialBoard(3, 3, 3).get(1).size(), 7);
    assertEquals(ems3.initialBoard(5, 6, 6).get(1).size(), 13);
    assertEquals(ems4.initialBoard(7, 9, 9).get(1).size(), 19);
  }

  /**
   * tests the isInvalid method
   */
  @Test
  public void testIsInvalid() {
    assertEquals(ems1.isInvalid(0, 0), true);
    assertEquals(ems2.isInvalid(1, 1), true);
    assertEquals(ems3.isInvalid(3,3), true);
    assertEquals(ems4.isInvalid(5, 5), true);

    assertEquals(this.ems1.isInvalid(0, 0), true);
    assertEquals(this.ems1.isInvalid(6, 6), true);
    assertEquals(this.ems1.isInvalid(2, 3), false);
    assertEquals(this.ems1.isInvalid(1, 1), true);
    assertEquals(this.ems1.isInvalid(5, 5), true);

    assertEquals(this.ems2.isInvalid(0, 0), true);
    assertEquals(this.ems2.isInvalid(6, 6), true);
    assertEquals(this.ems2.isInvalid(2, 3), false);
    assertEquals(this.ems2.isInvalid(1, 1), true);
    assertEquals(this.ems2.isInvalid(6, 6), true);

    assertEquals(this.ems3.isInvalid(0, 0), true);
    assertEquals(this.ems3.isInvalid(6, 6), false);
    assertEquals(this.ems3.isInvalid(7, 7), false);
    assertEquals(this.ems3.isInvalid(1, 1), true);
    assertEquals(this.ems3.isInvalid(4, 5), false);

    assertEquals(this.ems4.isInvalid(0, 0), true);
    assertEquals(this.ems4.isInvalid(7, 6), false);
    assertEquals(this.ems4.isInvalid(2, 3), true);
    assertEquals(this.ems4.isInvalid(1, 1), true);
    assertEquals(this.ems4.isInvalid(5, 5), true);
  }


  /**
   * tests the move method of all 4 constructors & its exceptions
   */
  @Test
  public void testMove() {
    ems1.move(1, 3, 3, 3);
    assertEquals(ems1.getSlotAt(1, 3), SlotState.Empty);
    assertEquals(ems1.getSlotAt(2, 3), SlotState.Empty);
    assertEquals(ems1.getSlotAt(3,3), SlotState.Marble);

    // PLAYING ENTIRE GAME IN ISGAMEOVER METHOD ////////////////////////////////////////

    ems2.move(2, 4, 2, 2);
    assertEquals(ems2.getSlotAt(2, 4), SlotState.Empty);
    assertEquals(ems2.getSlotAt(2, 3), SlotState.Empty);
    assertEquals(ems2.getSlotAt(2, 2), SlotState.Marble);

    ems3.move(4, 6, 6, 6);
    assertEquals(ems3.getSlotAt(4, 6), SlotState.Empty);
    assertEquals(ems3.getSlotAt(5, 6), SlotState.Empty);
    assertEquals(ems3.getSlotAt(6, 6), SlotState.Marble);

    ems4.move(7, 9, 9, 9);
    assertEquals(ems4.getSlotAt(7, 9), SlotState.Empty);
    assertEquals(ems4.getSlotAt(8, 9), SlotState.Empty);
    assertEquals(ems4.getSlotAt(9, 9), SlotState.Marble);

    // Invalid Slot Exceptions
    try {
      ems1.move(0, 1, 2, 1);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Tried to move an invalid slot");
    }
    try {
      ems1.move(1, 3, 1, 1);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Tried to move to an invalid slot");
    }

    // Empty From slot Exception
    try{
      ems1.move(3,3, 5, 3);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Empty to slot");
    }
    // Marble To Slot Exception
    try {
      ems1.move(3, 2, 5, 2);
    }
    catch (IllegalArgumentException e) {
      System.out.println("To slot has a marble");
    }
    // 2 positions away exception
    try{
      ems1.move(1, 3, 4, 3);
    }
    catch (IllegalArgumentException e) {
      System.out.println("To slot and from slot are not 2 positions away");
    }
    // marble between to and from exception
    try {
      ems1.move(0, 3, 2, 3);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Slot between to and from does not have a marble");
    }
  }

  /** test the isGameOver method, includes playing the entire game to
   * ensure the move function works properly and isGameOver returns
   * true when applicable
   *
   */
  @Test
  public void testIsGameOver() {
    assertEquals(ems1.isGameOver(), false);

    // PLAYING ENTIRE GAME TO TEST WHEN GAME OVER IS TRUE ///////////////////////////////
    ems1.move(1, 3, 3, 3);
    ems1.move(2, 1, 2, 3);
    ems1.move(0, 2, 2, 2);
    ems1.move(2, 3, 2, 1);
    ems1.move(2, 0, 2, 2); //
    ems1.move(4, 0, 2, 0);
    ems1.move(4, 1, 2, 1);
    assertEquals(ems1.getSlotAt(2, 2), SlotState.Marble);
    assertEquals(ems1.getSlotAt(2, 1), SlotState.Marble);
    assertEquals(ems1.getSlotAt(2, 4), SlotState.Marble);
    assertEquals(ems1.getSlotAt(3, 1), SlotState.Empty);
    assertEquals(ems1.getSlotAt(1, 3), SlotState.Empty);
    System.out.println(text1.toString());
    ems1.move(2, 1, 2, 3);
    ems1.move(2, 4, 2, 2);
    ems1.move(0, 4, 2, 4);
    ems1.move(3, 2, 1, 2);
    ems1.move(2, 5, 2, 3);
    ems1.move(5, 2, 3, 2);
    ems1.move(3, 3, 3, 1);
    ems1.move(4, 4, 4, 2);
    ems1.move(6, 4, 4, 4);
    ems1.move(6, 3, 4, 3);
    assertEquals(ems1.getSlotAt(4, 4), SlotState.Marble);
    ems1.move(3, 4, 5, 4);
    ems1.move(3, 6, 3, 4);
    ems1.move(4, 6, 4, 4);
    ems1.move(4, 3, 4, 5);

    System.out.println(text1.toString());

    assertEquals(ems1.isGameOver(), true);

    ////////////////////////////////////////////////////////////////////////////////////
    assertEquals(ems2.isGameOver(), false);
    // when score is 1
    ems2.move(4, 2, 2, 2);
    ems2.setScore(1);
    // when score is 1 and middle slot has a marble
    assertEquals(ems2.isGameOver(), true);

    // when score is 1
    ems3.move(4, 6, 6, 6);
    ems3.setScore(1);
    // when score is 1 and middle slot has a marble
    assertEquals(ems3.isGameOver(), true);
    assertEquals(ems3.getWon(), true);

    // when score is 1
    ems4.move(7, 9, 9, 9);
    ems4.setScore(1);
    // when score is 1 and middle slot has a marble
    assertEquals(ems4.isGameOver(), true);
    assertEquals(ems4.getWon(), true);

  }

  /**
   *  test the getters of the English Solitaire Model Class
   */
  @Test
  public void testEMSGetters() {
    // 1st constructor
    assertEquals(ems1.getBoardSize(), 7);
    assertEquals(ems1.getSlotAt(3, 3), SlotState.Empty);
    assertEquals(ems1.getSlotAt(0, 0), SlotState.Invalid);
    assertEquals(ems1.getSlotAt(3, 4), SlotState.Marble);
    assertEquals(ems1.getScore(), 32);
    ems1.move(1, 3, 3, 3);
    assertEquals(ems1.getScore(), 31);
    assertEquals(ems1.getBoard().size(), ems1.initialBoard(3, 3, 3).size());
    assertEquals(ems1.getWon(), false);
    assertEquals(ems1.getArmthickness(), 3);

    // 2nd constructor
    assertEquals(ems2.getBoardSize(), 7);
    assertEquals(ems2.getSlotAt(2, 2), SlotState.Empty);
    assertEquals(ems2.getSlotAt(0, 0), SlotState.Invalid);
    assertEquals(ems2.getSlotAt(3, 4), SlotState.Marble);
    assertEquals(ems2.getScore(), 32);
    ems2.move(4, 2, 2, 2);
    assertEquals(ems2.getScore(), 31);
    assertEquals(ems2.getBoard().size(), ems2.initialBoard(3, 3, 3).size());
    assertEquals(ems2.getWon(), false);
    assertEquals(ems2.getArmthickness(), 3);

    // 3rd constructor
    assertEquals(ems3.getBoardSize(), 13);
    assertEquals(ems3.getSlotAt(6, 6), SlotState.Empty);
    assertEquals(ems3.getSlotAt(0, 0), SlotState.Invalid);
    assertEquals(ems3.getSlotAt(3, 4), SlotState.Marble);
    assertEquals(ems3.getScore(), 104);
    ems3.move(4, 6, 6, 6);
    assertEquals(ems3.getScore(), 103);
    assertEquals(ems3.getBoard().size(), ems3.initialBoard(5, 6, 6).size());
    assertEquals(ems3.getWon(), false);
    assertEquals(ems3.getArmthickness(), 5);

    // 4th constructor
    assertEquals(ems4.getBoardSize(), 19);
    assertEquals(ems4.getSlotAt(9, 9), SlotState.Empty);
    assertEquals(ems4.getSlotAt(0, 0), SlotState.Invalid);
    assertEquals(ems4.getSlotAt(10, 10), SlotState.Marble);
    // assertEquals(ems4.getScore(), 314);
    ems4.move(7, 9, 9, 9);
    // assertEquals(ems4.getScore(), 313);
    assertEquals(ems4.getBoard().size(), ems4.initialBoard(7, 9, 9).size());
    assertEquals(ems4.getWon(), false);
    assertEquals(ems4.getArmthickness(), 7);
  }

  /**
   *  test the setter methods of the English Solitaire Model Class
   */
  @Test
  public void testEMSSetters() {

    TriangularMarbleSolitaire triangle = new TriangularMarbleSolitaire(1, 1);
    MarbleSolitaireView tView = new TriangularSolitaireTextView(triangle);

    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    0 _\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");


    // constructor 1 setters
    ems1.setScore(15);
    // assertEquals(ems1.getScore(), 15);
    ems1.setArmthickness(15);
    assertEquals(ems1.getArmthickness(), 15);
    ems1.setBoardList(initBoard);
    assertEquals(ems1.getBoard().size(), 7);
    ems1.setWon(true);
    assertEquals(ems1.getWon(), true);
    ems1.setBoardSize(15);
    //assertEquals(ems1.getBoardSize(), 15);
    ems1.setGameOver(true);
    assertEquals(ems1.getGameOver(), true);


    // constructor 2 setters
    ems2.setScore(20);
    // assertEquals(ems2.getScore(), 20);
    ems2.setArmthickness(20);
    assertEquals(ems2.getArmthickness(), 20);
    ems2.setBoardList(initBoard);
    assertEquals(ems2.getBoard().size(), 7);
    ems2.setWon(true);
    assertEquals(ems2.getWon(), true);
    ems2.setBoardSize(20);
    //assertEquals(ems2.getBoardSize(), 20);
    ems2.setGameOver(true);
    assertEquals(ems2.getGameOver(), true);

    // constructor 3 setters
    ems3.setScore(25);
    assertEquals(ems3.getScore(), 25);
    ems3.setArmthickness(25);
    assertEquals(ems3.getArmthickness(), 25);
    ems3.setBoardList(initBoard);
    assertEquals(ems3.getBoard().size(), 7);
    ems3.setWon(true);
    assertEquals(ems3.getWon(), true);
    ems3.setBoardSize(25);
    //assertEquals(ems3.getBoardSize(), 25);
    ems3.setGameOver(true);
    assertEquals(ems3.getGameOver(), true);

    // constructor 4 setters
    ems4.setScore(30);
    assertEquals(ems4.getScore(), 30);
    ems4.setArmthickness(30);
    assertEquals(ems4.getArmthickness(), 30);
    ems4.setBoardList(initBoard);
    assertEquals(ems4.getBoard().size(), 7);
    ems4.setWon(true);
    assertEquals(ems4.getWon(), true);
    ems4.setBoardSize(30);
    //assertEquals(ems4.getBoardSize(), 30);
    ems4.setGameOver(true);
    assertEquals(ems4.getGameOver(), true);
  }

  /**
   * test the toString method of the MarbleSolitaireTextView Class
   */
  @Test
  public void testTextViewToString() {
    assertEquals(text1.toString(), "     0 0 0    \n" +
            "     0 0 0    \n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 _ 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "     0 0 0    \n" +
            "     0 0 0    \n");

    assertEquals(text2.toString(), "     0 0 0    \n" +
            "     0 0 0    \n" +
            " 0 0 _ 0 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "     0 0 0    \n" +
            "     0 0 0    \n");

    assertEquals(text3.toString(), "         0 0 0 0 0        \n" +
            "         0 0 0 0 0        \n" +
            "         0 0 0 0 0        \n" +
            "         0 0 0 0 0        \n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 _ 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "         0 0 0 0 0        \n" +
            "         0 0 0 0 0        \n" +
            "         0 0 0 0 0        \n" +
            "         0 0 0 0 0        \n");

    assertEquals(text4.toString(), "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 _ 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n" +
            "             0 0 0 0 0 0 0            \n");


  }




}