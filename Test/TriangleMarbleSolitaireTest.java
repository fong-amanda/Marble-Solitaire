import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EuropeanMarbleSolitaire;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.Posn;
import cs3500.marblesolitaire.model.hw02.TriangularMarbleSolitaire;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangularSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the TriangleMarbleSolitaire Class
 */
public class TriangleMarbleSolitaireTest {
  TriangularMarbleSolitaire triangle = new TriangularMarbleSolitaire(1, 1);
  TriangularMarbleSolitaire triangularMarbleSolitaire1  = new TriangularMarbleSolitaire();
  TriangularMarbleSolitaire triangularMarbleSolitaire2 = new TriangularMarbleSolitaire(3, 3);
  TriangularMarbleSolitaire triangularMarbleSolitaire3 = new TriangularMarbleSolitaire(3);
  TriangularMarbleSolitaire triangularMarbleSolitaire4 = new TriangularMarbleSolitaire(3, 1, 1);
  TriangularMarbleSolitaire triangularMarbleSolitaire5 = new TriangularMarbleSolitaire(5);
  TriangularMarbleSolitaire triangularMarbleSolitaire6 = new TriangularMarbleSolitaire(1, 1);
  TriangularMarbleSolitaire triangularMarbleSolitaire7 = new TriangularMarbleSolitaire(5, 2, 2);
  MarbleSolitaireView tView = new TriangularSolitaireTextView(triangle);
  MarbleSolitaireView text1 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire1);
  MarbleSolitaireView text2 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire1);
  MarbleSolitaireView text3 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire3);
  MarbleSolitaireView text4 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire4);
  MarbleSolitaireView text5 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire5);
  MarbleSolitaireView text6 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire6);
  MarbleSolitaireView text7 = new TriangularSolitaireTextView(this.triangularMarbleSolitaire7);


  /**
   * Tests the first constructor
   */
  @Test
  public void testTriangleSolitaireModelFirstConstructor() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire1.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire1.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire1.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire1.getBoardSize(), 5);
  }

  /**
   * Tests the second constructor
   */
  @Test
  public void testTriangleSolitaireModelSecondConstructor() {
    assertEquals(this.triangularMarbleSolitaire2.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire2.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire2.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire2.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire2.getBoardSize(), 5);

    assertEquals(this.triangularMarbleSolitaire6.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire6.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire6.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire6.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire6.getBoardSize(), 5);
  }

  /**
   * Tests the third constructor
   */
  @Test
  public void testTriangleSolitaireModelFourthConstructor() {
    assertEquals(this.triangularMarbleSolitaire4.getBoard().size(), 3);
    assertEquals(this.triangularMarbleSolitaire4.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire4.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire4.getScore(), 5);
    assertEquals(this.triangularMarbleSolitaire4.getBoardSize(), 3);

    assertEquals(this.triangularMarbleSolitaire7.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire7.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire7.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire7.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire7.getBoardSize(), 5);
  }

  /**
   * Tests the fourth constructor
   */
  @Test
  public void testTriangleSolitaireModelThirdConstructor() {
    assertEquals(this.triangularMarbleSolitaire3.getBoard().size(), 3);
    assertEquals(this.triangularMarbleSolitaire3.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire3.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire3.getScore(), 5);
    assertEquals(this.triangularMarbleSolitaire3.getBoardSize(), 3);

    assertEquals(this.triangularMarbleSolitaire5.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire5.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire5.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire5.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire5.getBoardSize(), 5);
  }

  /**
   * tests the initial board method of all 4 constructor
   */
  @Test
  public void testInitialBoard() {
    assertEquals(triangularMarbleSolitaire1.initialBoard( 3, 3).size(), 5);
    assertEquals(triangularMarbleSolitaire2.initialBoard( 3, 3).size(), 5);
    assertEquals(triangularMarbleSolitaire3.initialBoard( 3, 3).size(), 3);
    assertEquals(triangularMarbleSolitaire4.initialBoard(3, 3).size(), 3);
    assertEquals(triangularMarbleSolitaire6.initialBoard(5, 4).size(), 5);
    assertEquals(triangle.initialBoard(1, 1).size(), 5);
    assertEquals(triangularMarbleSolitaire1.initialBoard( 3, 3).get(1).size(), 2);
    assertEquals(triangularMarbleSolitaire2.initialBoard(3, 3).get(1).size(), 2);
    assertEquals(triangularMarbleSolitaire3.initialBoard(3, 3).get(1).size(), 2);
    assertEquals(triangularMarbleSolitaire4.initialBoard(3, 3).get(1).size(), 2);
    assertEquals(triangularMarbleSolitaire6.initialBoard(5, 4).get(1).size(), 2);
    assertEquals(triangle.initialBoard(1, 1).get(1).size(), 2);
  }

  /**
   * Tests the calcScore method
   */
  @Test
  public void testCalcScore() {
    assertEquals(triangularMarbleSolitaire1.calcScore(), 14);
    assertEquals(triangularMarbleSolitaire2.calcScore(), 14);
    assertEquals(triangularMarbleSolitaire3.calcScore(), 5);
    assertEquals(triangularMarbleSolitaire4.calcScore(), 5);
    assertEquals(triangularMarbleSolitaire5.calcScore(), 14);
    assertEquals(triangularMarbleSolitaire6.calcScore(), 14);
    assertEquals(triangularMarbleSolitaire7.calcScore(), 14);
    assertEquals(triangle.calcScore(), 14);
  }

  /**
   * Tests the getBoard method
   */
  @Test
  public void getBoard() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().size(), 3);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().size(), 3);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().size(), 5);
    assertEquals(this.triangle.getBoard().size(), 5);
  }

  /**
   * Tests the move and isGameOver method
   */
  @Test
  public void testMoveAndIsGameOver() {
/*
    assertEquals(this.triangularMarbleSolitaire1.isGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire2.isGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire3.isGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire4.isGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire5.isGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire6.isGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire7.isGameOver(), false);
    assertEquals(this.triangle.isGameOver(), false);
 */
    assertEquals(this.triangle.getScore(), 14);
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    0 _\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
    this.triangle.move(3,3, 1, 1);
    assertEquals(this.triangle.getScore(), 13);
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    0 0\n" +
            "   0 0 _\n" +
            "  0 0 0 _\n" +
            " 0 0 0 0 0");
    this.triangle.move(0,0, 2, 2);
    assertEquals(this.triangle.getScore(), 12);
    assertEquals(tView.toString(), "\n" +
            "     _\n" +
            "    0 _\n" +
            "   0 0 0\n" +
            "  0 0 0 _\n" +
            " 0 0 0 0 0");
    assertEquals(triangle.getGameOver(), false);
    this.triangle.move(3,1, 3, 3);
    assertEquals(this.triangle.getScore(), 11);
    assertEquals(tView.toString(), "\n" +
            "     _\n" +
            "    0 _\n" +
            "   0 0 0\n" +
            "  0 _ _ 0\n" +
            " 0 0 0 0 0");
    this.triangle.move(3,3, 1, 1);
    assertEquals(this.triangle.getScore(), 10);
    assertEquals(tView.toString(), "\n" +
            "     _\n" +
            "    0 0\n" +
            "   0 0 _\n" +
            "  0 _ _ _\n" +
            " 0 0 0 0 0");
    assertEquals(triangle.getGameOver(), false);
    this.triangle.move(2,0, 0, 0);
    assertEquals(this.triangle.getScore(), 9);
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    _ 0\n" +
            "   _ 0 _\n" +
            "  0 _ _ _\n" +
            " 0 0 0 0 0");

    this.triangle.move(4,0, 2, 0);
    assertEquals(this.triangle.getScore(), 8);
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    _ 0\n" +
            "   0 0 _\n" +
            "  _ _ _ _\n" +
            " _ 0 0 0 0");

    this.triangle.move(4,2, 4, 0);
    assertEquals(this.triangle.getScore(), 7);
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    _ 0\n" +
            "   0 0 _\n" +
            "  _ _ _ _\n" +
            " 0 _ _ 0 0");
    assertEquals(triangle.getGameOver(), false);
    this.triangle.move(4,4, 4, 2);
    assertEquals(this.triangle.getScore(), 6);
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    _ 0\n" +
            "   0 0 _\n" +
            "  _ _ _ _\n" +
            " 0 _ 0 _ _");

    this.triangle.move(0,0, 2, 2);
    assertEquals(this.triangle.getScore(), 5);
    assertEquals(tView.toString(), "\n" +
            "     _\n" +
            "    _ _\n" +
            "   0 0 0\n" +
            "  _ _ _ _\n" +
            " 0 _ 0 _ _");
    triangle.setGameOver(true);
    // assertEquals(triangle.isGameOver(), true);
    assertEquals(triangle.getGameOver(), true);
  }

  /**
   * Tests the getGameOver method
   */
  @Test
  public void testGetGameOver() {
    assertEquals(this.triangularMarbleSolitaire1.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire2.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire3.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire4.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire5.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire6.getGameOver(), false);
    assertEquals(this.triangularMarbleSolitaire7.getGameOver(), false);
    assertEquals(this.triangle.getGameOver(), false);
  }

  /**
   * Tests the getWon method
   */
  @Test
  public void testGetWon() {
    assertEquals(this.triangularMarbleSolitaire1.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire2.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire3.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire4.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire5.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire6.getGameWon(), false);
    assertEquals(this.triangularMarbleSolitaire7.getGameWon(), false);
    assertEquals(this.triangle.getGameWon(), false);
  }

  /**
   * Tests the getBoard method
   */
  @Test
  public void testGetBoard() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().size(), 3);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().size(), 3);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().size(), 5);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().size(), 5);
    assertEquals(this.triangle.getBoard().size(), 5);
  }

  /**
   * Tests the getScore method
   */
  @Test
  public void testGetScore() {
    assertEquals(this.triangularMarbleSolitaire1.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire2.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire3.getScore(), 5);
    assertEquals(this.triangularMarbleSolitaire4.getScore(), 5);
    assertEquals(this.triangularMarbleSolitaire5.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire6.getScore(), 14);
    assertEquals(this.triangularMarbleSolitaire7.getScore(), 14);
    assertEquals(this.triangle.getScore(), 14);
  }

  /**
   * Tests the getBoardSize method
   */
  @Test
  public void testGetBoardSize() {
    assertEquals(this.triangularMarbleSolitaire1.getBoardSize(), 5);
    assertEquals(this.triangularMarbleSolitaire2.getBoardSize(), 5);
    assertEquals(this.triangularMarbleSolitaire3.getBoardSize(), 3);
    assertEquals(this.triangularMarbleSolitaire4.getBoardSize(), 3);
    assertEquals(this.triangularMarbleSolitaire5.getBoardSize(), 5);
    assertEquals(this.triangularMarbleSolitaire6.getBoardSize(), 5);
    assertEquals(this.triangularMarbleSolitaire7.getBoardSize(), 5);
    assertEquals(this.triangle.getBoardSize(), 5);
  }

  /**
   * Tests the getSlotAt method
   */
  @Test
  public void testGetSlotAt() {
    assertEquals(this.triangularMarbleSolitaire1.getSlotAt(2, 2), null);
    assertEquals(this.triangularMarbleSolitaire2.getSlotAt(2, 2), null);
    assertEquals(this.triangularMarbleSolitaire3.getSlotAt(2, 2), null);
    assertEquals(this.triangularMarbleSolitaire4.getSlotAt(2, 2), null);
    assertEquals(this.triangularMarbleSolitaire5.getSlotAt(2, 2), null);
    assertEquals(this.triangularMarbleSolitaire6.getSlotAt(2, 2), null);
    assertEquals(this.triangularMarbleSolitaire7.getSlotAt(2, 2), null);
    assertEquals(this.triangle.getSlotAt(2, 2), null);
  }

/**
 * Tests the setScore method
 */

  @Test
  public void testSetScore() {
    this.triangularMarbleSolitaire1.setScore(20);
     assertEquals(this.triangularMarbleSolitaire1.getScore(), 20);
    this.triangularMarbleSolitaire2.setScore(78);
    assertEquals(this.triangularMarbleSolitaire2.getScore(), 78);
    this.triangularMarbleSolitaire3.setScore(50);
    assertEquals(this.triangularMarbleSolitaire3.getScore(), 50);
    this.triangularMarbleSolitaire4.setScore(39);
    assertEquals(this.triangularMarbleSolitaire4.getScore(), 39);
    this.triangularMarbleSolitaire5.setScore(12);
    assertEquals(this.triangularMarbleSolitaire5.getScore(), 12);
    this.triangularMarbleSolitaire6.setScore(24);
    assertEquals(this.triangularMarbleSolitaire6.getScore(), 24);
    this.triangularMarbleSolitaire7.setScore(100);
    assertEquals(this.triangularMarbleSolitaire7.getScore(), 100);
  }


  /**
   * Tests the setWon method
   */
  @Test
  public void testSetWon() {
    assertEquals(this.triangularMarbleSolitaire1.getGameWon(), false);
    this.triangularMarbleSolitaire1.setWon(true);
    assertEquals(this.triangularMarbleSolitaire1.getGameWon(), true);

    assertEquals(this.triangularMarbleSolitaire2.getGameWon(), false);
    this.triangularMarbleSolitaire2.setWon(true);
    assertEquals(this.triangularMarbleSolitaire2.getGameWon(), true);

    assertEquals(this.triangularMarbleSolitaire3.getGameWon(), false);
    this.triangularMarbleSolitaire3.setWon(true);
    assertEquals(this.triangularMarbleSolitaire3.getGameWon(), true);

    assertEquals(this.triangularMarbleSolitaire4.getGameWon(), false);
    this.triangularMarbleSolitaire4.setWon(true);
    assertEquals(this.triangularMarbleSolitaire4.getGameWon(), true);

    assertEquals(this.triangularMarbleSolitaire5.getGameWon(), false);
    this.triangularMarbleSolitaire5.setWon(true);
    assertEquals(this.triangularMarbleSolitaire5.getGameWon(), true);

    assertEquals(this.triangularMarbleSolitaire6.getGameWon(), false);
    this.triangularMarbleSolitaire6.setWon(true);
    assertEquals(this.triangularMarbleSolitaire6.getGameWon(), true);

    assertEquals(this.triangularMarbleSolitaire7.getGameWon(), false);
    this.triangularMarbleSolitaire7.setWon(true);
    assertEquals(this.triangularMarbleSolitaire7.getGameWon(), true);
  }

  /**
   * Tests the setBoardListMethod
   */
  @Test
  public void testSetBoardList() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().size(), 5);
    this.triangularMarbleSolitaire1.setBoardList(this.triangularMarbleSolitaire3.getBoard());
    assertEquals(this.triangularMarbleSolitaire1.getBoard().size(), 3);

    assertEquals(this.triangularMarbleSolitaire2.getBoard().size(), 5);
    this.triangularMarbleSolitaire2.setBoardList(this.triangularMarbleSolitaire3.getBoard());
    assertEquals(this.triangularMarbleSolitaire2.getBoard().size(), 3);

    assertEquals(this.triangularMarbleSolitaire3.getBoard().size(), 3);
    this.triangularMarbleSolitaire3.setBoardList(this.triangularMarbleSolitaire7.getBoard());
    assertEquals(this.triangularMarbleSolitaire3.getBoard().size(), 5);

    assertEquals(this.triangularMarbleSolitaire4.getBoard().size(), 3);
    this.triangularMarbleSolitaire4.setBoardList(this.triangularMarbleSolitaire7.getBoard());
    assertEquals(this.triangularMarbleSolitaire4.getBoard().size(), 5);

    assertEquals(this.triangularMarbleSolitaire5.getBoard().size(), 5);
    this.triangularMarbleSolitaire5.setBoardList(triangularMarbleSolitaire2.getBoard());
    assertEquals(this.triangularMarbleSolitaire5.getBoard().size(), 3);

    assertEquals(this.triangularMarbleSolitaire2.getBoard().size(), 3);
    this.triangularMarbleSolitaire6.setBoardList(this.triangularMarbleSolitaire4.getBoard());
    assertEquals(this.triangularMarbleSolitaire6.getBoard().size(), 5);

    assertEquals(this.triangularMarbleSolitaire7.getBoard().size(), 5);
    this.triangularMarbleSolitaire7.setBoardList(triangularMarbleSolitaire5.getBoard());
    assertEquals(this.triangularMarbleSolitaire7.getBoard().size(), 3);
  }

  /**
   * Tests the setGameOver method
   */
  @Test
  public void testSetGameOver() {
    assertEquals(this.triangularMarbleSolitaire1.getGameOver(), false);
    this.triangularMarbleSolitaire1.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire1.getGameOver(), true);

    assertEquals(this.triangularMarbleSolitaire2.getGameOver(), false);
    this.triangularMarbleSolitaire2.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire2.getGameOver(), true);

    assertEquals(this.triangularMarbleSolitaire3.getGameOver(), false);
    this.triangularMarbleSolitaire3.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire3.getGameOver(), true);

    assertEquals(this.triangularMarbleSolitaire4.getGameOver(), false);
    this.triangularMarbleSolitaire4.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire4.getGameOver(), true);

    assertEquals(this.triangularMarbleSolitaire5.getGameOver(), false);
    this.triangularMarbleSolitaire5.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire5.getGameOver(), true);

    assertEquals(this.triangularMarbleSolitaire6.getGameOver(), false);
    this.triangularMarbleSolitaire6.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire6.getGameOver(), true);

    assertEquals(this.triangularMarbleSolitaire7.getGameOver(), false);
    this.triangularMarbleSolitaire7.setGameOver(true);
    assertEquals(this.triangularMarbleSolitaire7.getGameOver(), true);
  }


  /**
   * Tests the setBoardSize method
   */
  @Test
  public void testSetBoardSize() {
    assertEquals(this.triangularMarbleSolitaire1.getBoardSize(), 5);
    this.triangularMarbleSolitaire1.setBoardSize(4);
    assertEquals(this.triangularMarbleSolitaire1.getBoardSize(), 4);

    assertEquals(this.triangularMarbleSolitaire2.getBoardSize(), 5);
    this.triangularMarbleSolitaire2.setBoardSize(100);
    assertEquals(this.triangularMarbleSolitaire2.getBoardSize(), 100);

    assertEquals(this.triangularMarbleSolitaire3.getBoardSize(), 3);
    this.triangularMarbleSolitaire3.setBoardSize(500);
    assertEquals(this.triangularMarbleSolitaire3.getBoardSize(), 500);

    assertEquals(this.triangularMarbleSolitaire4.getBoardSize(), 3);
    this.triangularMarbleSolitaire4.setBoardSize(32);
    assertEquals(this.triangularMarbleSolitaire4.getBoardSize(), 32);

    assertEquals(this.triangularMarbleSolitaire5.getBoardSize(), 5);
    this.triangularMarbleSolitaire5.setBoardSize(45);
    assertEquals(this.triangularMarbleSolitaire5.getBoardSize(), 45);

    assertEquals(this.triangularMarbleSolitaire6.getBoardSize(), 5);
    this.triangularMarbleSolitaire6.setBoardSize(3);
    assertEquals(this.triangularMarbleSolitaire6.getBoardSize(), 3);

    assertEquals(this.triangularMarbleSolitaire7.getBoardSize(), 5);
    this.triangularMarbleSolitaire7.setBoardSize(3);
    assertEquals(this.triangularMarbleSolitaire7.getBoardSize(), 3);
  }

  /**
   * Test the samePosn method and getPosn
   */
  @Test
  public void testSamePosn() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).samePosn(new Posn(0, 0)), true);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(2).get(1).samePosn(new Posn(2, 1)), true);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(2).get(2).samePosn(new Posn(2, 2)), true);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(1).get(1).samePosn(new Posn(1, 1)), true);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(3).get(3).samePosn(new Posn(3, 3)), true);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(4).get(0).samePosn(new Posn(4, 0)), true);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(1).get(0).samePosn(new Posn(1, 0)), true);
  }

  /**
   * Tests the getState method
   */
  @Test
  public void testGetState() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(1).get(1).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(1).get(1).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(2).get(0).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(1).get(1).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(2).get(0).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(3).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(4).get(4).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(1).get(0).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(4).get(4).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(4).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
  }

    /**
     * Test the setCurState method
     */
  @Test
  public void testSetCurState() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Empty);
    this.triangularMarbleSolitaire1.getBoard().get(0).get(0).setCurState(MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    this.triangularMarbleSolitaire2.getBoard().get(3).get(3).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.triangularMarbleSolitaire3.getBoard().get(2).get(2).setCurState(MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Empty);

    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.triangularMarbleSolitaire4.getBoard().get(2).get(2).setCurState(MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Empty);

    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.triangularMarbleSolitaire5.getBoard().get(3).get(3).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.triangularMarbleSolitaire6.getBoard().get(0).get(0).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.triangularMarbleSolitaire7.getBoard().get(3).get(3).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Invalid);
  }

  /**
   * Test the setXY method
   */
  @Test
  public void testSetXY () {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire1.getBoard().get(0).get(0).setXy(new Posn(1,1));
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).getPosn().getx(), 1);
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).getPosn().gety(), 1);

    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire2.getBoard().get(0).get(0).setXy(new Posn(2,5));
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(0).get(0).getPosn().getx(), 2);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(0).get(0).getPosn().gety(), 5);

    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire3.getBoard().get(0).get(0).setXy(new Posn(3,3));
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(0).get(0).getPosn().getx(), 3);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(0).get(0).getPosn().gety(), 3);

    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire4.getBoard().get(0).get(0).setXy(new Posn(4,2));
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(0).get(0).getPosn().getx(), 4);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(0).get(0).getPosn().gety(), 2);

    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire5.getBoard().get(0).get(0).setXy(new Posn(5,5));
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(0).get(0).getPosn().getx(), 5);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(0).get(0).getPosn().gety(), 5);

    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire6.getBoard().get(0).get(0).setXy(new Posn(2,1));
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(0).get(0).getPosn().getx(), 2);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(0).get(0).getPosn().gety(), 1);

    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.triangularMarbleSolitaire7.getBoard().get(0).get(0).setXy(new Posn(3,5));
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(0).get(0).getPosn().getx(), 3);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(0).get(0).getPosn().gety(), 5);
  }

  /**
   * Tests the getX and getY method
   * Along with the setters for these
   */
  @Test
  public void testGetXAndGetY() {
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(1).get(0).getPosn().getx(), 1);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(2).get(0).getPosn().getx(), 2);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(2).get(0).getPosn().getx(), 2);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(1).get(0).getPosn().getx(), 1);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(2).get(0).getPosn().getx(), 2);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(1).get(0).getPosn().getx(), 1);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(0).get(0).getPosn().getx(), 0);

    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.triangularMarbleSolitaire5.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.triangularMarbleSolitaire6.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.triangularMarbleSolitaire7.getBoard().get(0).get(0).getPosn().gety(), 0);

    this.triangularMarbleSolitaire1.getBoard().get(1).get(0).getPosn().setX(2);
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(1).get(0).getPosn().getx(), 2);
    this.triangularMarbleSolitaire2.getBoard().get(1).get(0).getPosn().setX(7);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(1).get(0).getPosn().getx(), 7);
    this.triangularMarbleSolitaire3.getBoard().get(1).get(0).getPosn().setX(4);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(1).get(0).getPosn().getx(), 4);
    this.triangularMarbleSolitaire4.getBoard().get(1).get(0).getPosn().setX(3);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(1).get(0).getPosn().getx(), 3);

    this.triangularMarbleSolitaire1.getBoard().get(1).get(0).getPosn().setY(2);
    assertEquals(this.triangularMarbleSolitaire1.getBoard().get(1).get(0).getPosn().getx(), 2);
    this.triangularMarbleSolitaire2.getBoard().get(1).get(0).getPosn().setY(7);
    assertEquals(this.triangularMarbleSolitaire2.getBoard().get(1).get(0).getPosn().getx(), 7);
    this.triangularMarbleSolitaire3.getBoard().get(1).get(0).getPosn().setY(4);
    assertEquals(this.triangularMarbleSolitaire3.getBoard().get(1).get(0).getPosn().getx(), 4);
    this.triangularMarbleSolitaire4.getBoard().get(1).get(0).getPosn().setY(3);
    assertEquals(this.triangularMarbleSolitaire4.getBoard().get(1).get(0).getPosn().getx(), 3);


  }


  /**
     * Tests the toString method
     */
  @Test
  public void testToString() {
    assertEquals(tView.toString(), "\n" +
            "     0\n" +
            "    0 _\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
    assertEquals(this.text1.toString(), "\n" +
            "     _\n" +
            "    0 0\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
    assertEquals(this.text2.toString(), "\n" +
            "     _\n" +
            "    0 0\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
    assertEquals(this.text3.toString(), "\n" +
            "   _\n" +
            "  0 0\n" +
            " 0 0 0");
    assertEquals(this.text4.toString(), "\n" +
            "   0\n" +
            "  0 _\n" +
            " 0 0 0");
    assertEquals(this.text5.toString(), "\n" +
            "     _\n" +
            "    0 0\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
    assertEquals(this.text6.toString(), "\n" +
            "     0\n" +
            "    0 _\n" +
            "   0 0 0\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
    assertEquals(this.text7.toString(), "\n" +
            "     0\n" +
            "    0 0\n" +
            "   0 0 _\n" +
            "  0 0 0 0\n" +
            " 0 0 0 0 0");
  }
}
