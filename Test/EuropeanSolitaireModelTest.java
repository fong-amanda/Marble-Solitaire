import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.EuropeanMarbleSolitaire;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.Posn;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Testing the EuropeanSolitaireModel class for EuropeanSolitaireModel
 */
public class EuropeanSolitaireModelTest {
  EuropeanMarbleSolitaire europeanSolitaireModel1 = new EuropeanMarbleSolitaire();
  EuropeanMarbleSolitaire europeanSolitaireModel2 = new EuropeanMarbleSolitaire(3, 3);
  EuropeanMarbleSolitaire europeanSolitaireModel3 = new EuropeanMarbleSolitaire(3);
  EuropeanMarbleSolitaire europeanSolitaireModel4 = new EuropeanMarbleSolitaire(3, 3, 3);
  EuropeanMarbleSolitaire europeanSolitaireModel5 = new EuropeanMarbleSolitaire(5);
  EuropeanMarbleSolitaire europeanSolitaireModel6 = new EuropeanMarbleSolitaire(5, 4);
  EuropeanMarbleSolitaire europeanSolitaireModel7 = new EuropeanMarbleSolitaire(5, 5, 3);
  MarbleSolitaireView text1 = new MarbleSolitaireTextView(this.europeanSolitaireModel1);
  MarbleSolitaireView text2 = new MarbleSolitaireTextView(this.europeanSolitaireModel2);
  MarbleSolitaireView text3 = new MarbleSolitaireTextView(this.europeanSolitaireModel3);
  MarbleSolitaireView text4 = new MarbleSolitaireTextView(this.europeanSolitaireModel4);
  MarbleSolitaireView text5 = new MarbleSolitaireTextView(this.europeanSolitaireModel5);
  MarbleSolitaireView text6 = new MarbleSolitaireTextView(this.europeanSolitaireModel6);
  MarbleSolitaireView text7 = new MarbleSolitaireTextView(this.europeanSolitaireModel7);

  /**
   * Tests the first constructor
   */
  @Test
  public void testEuropeanSolitaireModelFirstConstructor() {
    assertEquals(this.europeanSolitaireModel1.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel1.getWon(), false);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel1.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel1.getScore(), 36);
    assertEquals(this.europeanSolitaireModel1.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel1.getInvalid(), 1);
  }

  /**
   * Tests the second constructor for EuropeanSolitaireModel
   */
  @Test
  public void testEuropeanSolitaireModelSecondConstructor() {
    assertEquals(this.europeanSolitaireModel2.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel2.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel2.getWon(), false);
    assertEquals(this.europeanSolitaireModel2.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel2.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel2.getScore(), 36);
    assertEquals(this.europeanSolitaireModel2.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel1.getInvalid(), 1);

    assertEquals(this.europeanSolitaireModel6.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel6.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel6.getWon(), false);
    assertEquals(this.europeanSolitaireModel6.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel6.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel6.getScore(), 36);
    assertEquals(this.europeanSolitaireModel6.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel6.getInvalid(), 1);
  }

  /**
   * Tests the third constructor for EuropeanSolitaireModel
   */
  @Test
  public void testEuropeanSolitaireModelFourthConstructor() {
    assertEquals(this.europeanSolitaireModel4.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel4.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel4.getWon(), false);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel4.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel4.getScore(), 36);
    assertEquals(this.europeanSolitaireModel4.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel4.getInvalid(), 1);

    assertEquals(this.europeanSolitaireModel7.getBoard().size(), 13);
    assertEquals(this.europeanSolitaireModel7.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel7.getWon(), false);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel7.getArmthickness(), 5);
    assertEquals(this.europeanSolitaireModel7.getScore(), 128);
    assertEquals(this.europeanSolitaireModel7.getMiddle(), 6);
    assertEquals(this.europeanSolitaireModel7.getInvalid(), 2);
  }

  /**
   * Tests the fourth constructor for EuropeanSolitaireModel
   */
  @Test
  public void testEnglishSolitaireModelThirdConstructor() {
    assertEquals(this.europeanSolitaireModel3.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel3.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel3.getWon(), false);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel3.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel3.getScore(), 36);
    assertEquals(this.europeanSolitaireModel3.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel3.getInvalid(), 1);


    assertEquals(this.europeanSolitaireModel5.getBoard().size(), 13);
    assertEquals(this.europeanSolitaireModel5.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel5.getWon(), false);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel5.getArmthickness(), 5);
    assertEquals(this.europeanSolitaireModel5.getScore(), 128);
    assertEquals(this.europeanSolitaireModel5.getMiddle(), 6);
    assertEquals(this.europeanSolitaireModel5.getInvalid(), 2);
  }

  /**
   * Tests the isValid method
   */
  @Test
  public void testIsInvalid() {
    assertEquals(this.europeanSolitaireModel1.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel1.isInvalid(6, 6), true);
    assertEquals(this.europeanSolitaireModel1.isInvalid(2, 3), false);
    assertEquals(this.europeanSolitaireModel1.isInvalid(1, 1), false);
    assertEquals(this.europeanSolitaireModel1.isInvalid(5, 5), false);

    assertEquals(this.europeanSolitaireModel2.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel2.isInvalid(6, 6), true);
    assertEquals(this.europeanSolitaireModel2.isInvalid(2, 3), false);
    assertEquals(this.europeanSolitaireModel2.isInvalid(1, 1), false);
    assertEquals(this.europeanSolitaireModel2.isInvalid(5, 5), false);

    assertEquals(this.europeanSolitaireModel3.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel3.isInvalid(6, 5), true);
    assertEquals(this.europeanSolitaireModel3.isInvalid(2, 3), false);
    assertEquals(this.europeanSolitaireModel3.isInvalid(1, 1), false);
    assertEquals(this.europeanSolitaireModel3.isInvalid(4, 5), false);

    assertEquals(this.europeanSolitaireModel4.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel4.isInvalid(7, 6), true);
    assertEquals(this.europeanSolitaireModel4.isInvalid(2, 3), false);
    assertEquals(this.europeanSolitaireModel4.isInvalid(1, 1), false);
    assertEquals(this.europeanSolitaireModel4.isInvalid(5, 5), false);

    assertEquals(this.europeanSolitaireModel5.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel5.isInvalid(6, 6), false);
    assertEquals(this.europeanSolitaireModel5.isInvalid(4, 3), false);
    assertEquals(this.europeanSolitaireModel5.isInvalid(1, 1), true);
    assertEquals(this.europeanSolitaireModel5.isInvalid(9, 12), true);

    assertEquals(this.europeanSolitaireModel6.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel6.isInvalid(1, 0), true);
    assertEquals(this.europeanSolitaireModel6.isInvalid(2, 3), false);
    assertEquals(this.europeanSolitaireModel6.isInvalid(1, 1), false);
    assertEquals(this.europeanSolitaireModel6.isInvalid(5, 5), false);

    assertEquals(this.europeanSolitaireModel7.isInvalid(0, 0), true);
    assertEquals(this.europeanSolitaireModel7.isInvalid(12, 12), true);
    assertEquals(this.europeanSolitaireModel7.isInvalid(2, 3), false);
    assertEquals(this.europeanSolitaireModel7.isInvalid(8, 9), false);
    assertEquals(this.europeanSolitaireModel7.isInvalid(5, 5), false);
  }

  /**
   * Tests the initialBoard method
   */
  @Test
  public void testInitialBoard() {
    assertEquals(this.europeanSolitaireModel1.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel2.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel3.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel4.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel5.getBoardSize(), 13);
    assertEquals(this.europeanSolitaireModel6.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel7.getBoardSize(), 13);
    assertEquals(this.europeanSolitaireModel1.initialBoard(3, 3, 3).size(), 7);
    assertEquals(this.europeanSolitaireModel2.initialBoard(3, 3, 3).size(), 7);
    assertEquals(this.europeanSolitaireModel3.initialBoard(3, 3, 3).size(), 7);
    assertEquals(this.europeanSolitaireModel4.initialBoard(3, 3, 3).size(), 7);
    assertEquals(this.europeanSolitaireModel5.initialBoard(5, 3, 3).size(), 13);
    assertEquals(this.europeanSolitaireModel6.initialBoard(3, 3, 3).size(), 7);
    assertEquals(this.europeanSolitaireModel7.initialBoard(5, 3, 3).size(), 13);
  }

  /**
   * Tests Move and isGameOver method
   */
  @Test
  public void testMoveAndIsGameOver() {
    try {
      this.europeanSolitaireModel1.move(0, 0, 2, 2);
    } catch (IllegalArgumentException a) {
      System.out.println("Invalid slot exception");
    }

    try {
      this.europeanSolitaireModel1.move(1, 1, 2, 2);
    } catch (IllegalArgumentException a) {
      System.out.println("To slot is not empty");
    }

    try {
      this.europeanSolitaireModel1.move(4, 4, 3, 3);
    } catch (IllegalArgumentException a) {
      System.out.println("Slot it not two spaces away");
    }

    try {
      this.europeanSolitaireModel1.move(2, 3, 4, 3);
    } catch (IllegalArgumentException a) {
      System.out.println("There is no marble in the " +
              "slot between the 'to' and 'from' positions");
    }
    assertEquals(this.europeanSolitaireModel1.isGameOver(), false);
    assertEquals(this.europeanSolitaireModel2.isGameOver(), false);
    assertEquals(this.europeanSolitaireModel3.isGameOver(), false);
    assertEquals(this.europeanSolitaireModel4.isGameOver(), false);
    assertEquals(this.europeanSolitaireModel5.isGameOver(), false);
    // set score to 1
    this.europeanSolitaireModel3.setScore(1);
    assertEquals(this.europeanSolitaireModel3.getScore(), 1);
    // set middle slot MarbleState to contains a marble
    this.europeanSolitaireModel3.getBoard().get(this.europeanSolitaireModel1.getMiddle())
            .get(this.europeanSolitaireModel3.getMiddle()).setCurState(MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(this.europeanSolitaireModel1.getMiddle())
            .get(this.europeanSolitaireModel3.getMiddle()).getState(), MarbleSolitaireModelState.SlotState.Marble);
    // game is over since score is 1 and middle slot has marble
    assertEquals(this.europeanSolitaireModel3.isGameOver(), true);
    assertEquals(this.europeanSolitaireModel3.getGameOver(), true);
    assertEquals(this.europeanSolitaireModel1.getScore(), 36);
    this.europeanSolitaireModel1.move(5, 3, 3, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 35);
    this.europeanSolitaireModel1.move(2, 3, 4, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 34);
    this.europeanSolitaireModel1.move(0, 3, 2, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 33);
    this.europeanSolitaireModel1.move(3, 5, 3, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 32);
    this.europeanSolitaireModel1.move(3, 3, 1, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 31);
    this.europeanSolitaireModel1.move(2, 5, 2, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 30);
    this.europeanSolitaireModel1.move(2, 2, 2, 4);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 29);
    this.europeanSolitaireModel1.move(4, 2, 2, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 28);
    this.europeanSolitaireModel1.move(1, 2, 3, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 27);
    this.europeanSolitaireModel1.move(1, 4, 1, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 26);
    this.europeanSolitaireModel1.move(0, 2, 2, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 25);
    this.europeanSolitaireModel1.move(4, 4, 4, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 24);
    this.europeanSolitaireModel1.move(4, 6, 4, 4);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 23);
    this.europeanSolitaireModel1.move(4, 1, 4, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 22);
    this.europeanSolitaireModel1.move(2, 1, 2, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 21);
    this.europeanSolitaireModel1.move(2, 4, 2, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 20);
    this.europeanSolitaireModel1.move(4, 3, 4, 5);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 19);
    this.europeanSolitaireModel1.move(3, 1, 3, 3);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 18);
    this.europeanSolitaireModel1.move(2, 6, 4, 6);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 17);
    this.europeanSolitaireModel1.move(4, 6, 4, 4);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 16);
    this.europeanSolitaireModel1.move(6, 2, 4, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 15);
    assertEquals(this.europeanSolitaireModel1.isGameOver(), false);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    this.europeanSolitaireModel1.move(6, 4, 6, 2);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 14);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    this.europeanSolitaireModel1.move(4, 4, 6, 4);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getScore(), 13);
    MarbleSolitaireView text1Move = new MarbleSolitaireTextView(this.europeanSolitaireModel1);
    assertEquals(text1Move.toString(),
            "     _ _ 0    \n" +
                    "   0 _ _ _ 0  \n" +
                    " 0 _ 0 _ _ _ _\n" +
                    " 0 _ _ 0 _ _ _\n" +
                    " 0 _ 0 _ _ _ _\n" +
                    "   0 _ _ _ 0  \n" +
                    "     0 _ 0    \n");
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.isGameOver(), true);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), true);
    assertEquals(this.europeanSolitaireModel1.getWon(), false);
    assertEquals(this.europeanSolitaireModel1.initialBoard(3, 3, 3).size(), 7);
  }

  /**
   * Tests the getBoardSize method
   */
  @Test
  public void testGetBoardSize() {
    assertEquals(this.europeanSolitaireModel1.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel2.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel3.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel4.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel5.getBoardSize(), 13);
    assertEquals(this.europeanSolitaireModel6.getBoardSize(), 7);
    assertEquals(this.europeanSolitaireModel7.getBoardSize(), 13);
  }

  /**
   * Tests the getScore method
   */
  @Test
  public void testGetScore() {
    assertEquals(this.europeanSolitaireModel1.getScore(), 36);
    this.europeanSolitaireModel1.move(3, 5, 3, 3);
    assertEquals(this.europeanSolitaireModel1.getScore(), 35);

    assertEquals(this.europeanSolitaireModel2.getScore(), 36);
    this.europeanSolitaireModel2.move(3, 5, 3, 3);
    assertEquals(this.europeanSolitaireModel2.getScore(), 35);

    assertEquals(this.europeanSolitaireModel3.getScore(), 36);
    this.europeanSolitaireModel3.move(1, 3, 3, 3);
    assertEquals(this.europeanSolitaireModel3.getScore(), 35);

    assertEquals(this.europeanSolitaireModel4.getScore(), 36);
    this.europeanSolitaireModel4.move(3, 1, 3, 3);
    assertEquals(this.europeanSolitaireModel4.getScore(), 35);

    assertEquals(this.europeanSolitaireModel5.getScore(), 128);
    this.europeanSolitaireModel5.move(4, 6, 6, 6);
    assertEquals(this.europeanSolitaireModel5.getScore(), 127);

    assertEquals(this.europeanSolitaireModel6.getScore(), 36);
    this.europeanSolitaireModel6.move(3, 4, 5, 4);
    assertEquals(this.europeanSolitaireModel6.getScore(), 35);

    assertEquals(this.europeanSolitaireModel7.getScore(), 128);
    this.europeanSolitaireModel7.move(5, 5, 5, 3);
    assertEquals(this.europeanSolitaireModel7.getScore(), 127);
  }


  /**
   * Tests the getGameOver method
   */
  @Test
  public void getGameOver() {
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel2.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel3.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel4.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel5.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel6.getGameOver(), false);
    assertEquals(this.europeanSolitaireModel7.getGameOver(), false);
  }

  /**
   * Tests the getWon method
   */
  @Test
  public void testGetWon() {
    assertEquals(this.europeanSolitaireModel1.getWon(), false);
    assertEquals(this.europeanSolitaireModel2.getWon(), false);
    assertEquals(this.europeanSolitaireModel3.getWon(), false);
    assertEquals(this.europeanSolitaireModel4.getWon(), false);
    assertEquals(this.europeanSolitaireModel5.getWon(), false);
    assertEquals(this.europeanSolitaireModel6.getWon(), false);
    assertEquals(this.europeanSolitaireModel7.getWon(), false);
  }

  /**
   * Tests the getBoard method
   */
  @Test
  public void testGetBoard() {
    assertEquals(this.europeanSolitaireModel1.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel2.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel3.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel4.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel5.getBoard().size(), 13);
    assertEquals(this.europeanSolitaireModel6.getBoard().size(), 7);
    assertEquals(this.europeanSolitaireModel7.getBoard().size(), 13);
  }

  /**
   * Tests the getArmThickness method
   */
  @Test
  public void testGetArmThickness() {
    assertEquals(this.europeanSolitaireModel1.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel2.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel3.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel4.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel5.getArmthickness(), 5);
    assertEquals(this.europeanSolitaireModel6.getArmthickness(), 3);
    assertEquals(this.europeanSolitaireModel7.getArmthickness(), 5);
  }

  /**
   * Tests the getMiddle method
   */
  @Test
  public void testGetMiddle() {
    assertEquals(this.europeanSolitaireModel1.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel2.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel3.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel4.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel5.getMiddle(), 6);
    assertEquals(this.europeanSolitaireModel6.getMiddle(), 3);
    assertEquals(this.europeanSolitaireModel7.getMiddle(), 6);
  }

  /**
   * Tests the getInvalid method
   */
  @Test
  public void testGetInvalid() {
    assertEquals(this.europeanSolitaireModel1.getInvalid(), 1);
    assertEquals(this.europeanSolitaireModel2.getInvalid(), 1);
    assertEquals(this.europeanSolitaireModel3.getInvalid(), 1);
    assertEquals(this.europeanSolitaireModel4.getInvalid(), 1);
    assertEquals(this.europeanSolitaireModel5.getInvalid(), 2);
    assertEquals(this.europeanSolitaireModel6.getInvalid(), 1);
    assertEquals(this.europeanSolitaireModel7.getInvalid(), 2);
  }


/**
 * Tests the setScore method
 */
  @Test
  public void testSetScore() {
    this.europeanSolitaireModel1.setScore(20);
    assertEquals(this.europeanSolitaireModel1.getScore(), 20);
    this.europeanSolitaireModel2.setScore(78);
    assertEquals(this.europeanSolitaireModel2.getScore(), 78);
    this.europeanSolitaireModel3.setScore(50);
    assertEquals(this.europeanSolitaireModel3.getScore(), 50);
    this.europeanSolitaireModel4.setScore(39);
    assertEquals(this.europeanSolitaireModel4.getScore(), 39);
    this.europeanSolitaireModel5.setScore(12);
    assertEquals(this.europeanSolitaireModel5.getScore(), 12);
    this.europeanSolitaireModel6.setScore(24);
    assertEquals(this.europeanSolitaireModel6.getScore(), 24);
    this.europeanSolitaireModel7.setScore(100);
    assertEquals(this.europeanSolitaireModel7.getScore(), 100);
  }


  /**
   * Tests the setWon method
   */
  @Test
  public void testSetWon() {
    assertEquals(this.europeanSolitaireModel1.getWon(), false);
    this.europeanSolitaireModel1.setWon(true);
    assertEquals(this.europeanSolitaireModel1.getWon(), true);

    assertEquals(this.europeanSolitaireModel2.getWon(), false);
    this.europeanSolitaireModel2.setWon(true);
    assertEquals(this.europeanSolitaireModel2.getWon(), true);

    assertEquals(this.europeanSolitaireModel3.getWon(), false);
    this.europeanSolitaireModel3.setWon(true);
    assertEquals(this.europeanSolitaireModel3.getWon(), true);

    assertEquals(this.europeanSolitaireModel4.getWon(), false);
    this.europeanSolitaireModel4.setWon(true);
    assertEquals(this.europeanSolitaireModel4.getWon(), true);

    assertEquals(this.europeanSolitaireModel5.getWon(), false);
    this.europeanSolitaireModel5.setWon(true);
    assertEquals(this.europeanSolitaireModel5.getWon(), true);

    assertEquals(this.europeanSolitaireModel6.getWon(), false);
    this.europeanSolitaireModel6.setWon(true);
    assertEquals(this.europeanSolitaireModel6.getWon(), true);

    assertEquals(this.europeanSolitaireModel7.getWon(), false);
    this.europeanSolitaireModel7.setWon(true);
    assertEquals(this.europeanSolitaireModel7.getWon(), true);
  }

  /**
   * Tests the setBoardListMethod
   */
  @Test
  public void testSetBoardList() {
    assertEquals(this.europeanSolitaireModel1.getBoard().size(), 7);
    this.europeanSolitaireModel1.setBoardList(this.europeanSolitaireModel7.getBoard());
    assertEquals(this.europeanSolitaireModel1.getBoard().size(), 13);

    assertEquals(this.europeanSolitaireModel2.getBoard().size(), 7);
    this.europeanSolitaireModel2.setBoardList(this.europeanSolitaireModel5.getBoard());
    assertEquals(this.europeanSolitaireModel2.getBoard().size(), 13);

    assertEquals(this.europeanSolitaireModel3.getBoard().size(), 7);
    this.europeanSolitaireModel3.setBoardList(this.europeanSolitaireModel5.getBoard());
    assertEquals(this.europeanSolitaireModel3.getBoard().size(), 13);

    assertEquals(this.europeanSolitaireModel4.getBoard().size(), 7);
    this.europeanSolitaireModel4.setBoardList(this.europeanSolitaireModel7.getBoard());
    assertEquals(this.europeanSolitaireModel4.getBoard().size(), 13);

    EuropeanMarbleSolitaire europeanSolitaireModel1 = new EuropeanMarbleSolitaire();
    assertEquals(this.europeanSolitaireModel5.getBoard().size(), 13);
    this.europeanSolitaireModel5.setBoardList(europeanSolitaireModel1.getBoard());
    assertEquals(this.europeanSolitaireModel5.getBoard().size(), 7);

    assertEquals(this.europeanSolitaireModel6.getBoard().size(), 7);
    this.europeanSolitaireModel6.setBoardList(this.europeanSolitaireModel7.getBoard());
    assertEquals(this.europeanSolitaireModel6.getBoard().size(), 13);

    assertEquals(this.europeanSolitaireModel7.getBoard().size(), 13);
    this.europeanSolitaireModel7.setBoardList(europeanSolitaireModel1.getBoard());
    assertEquals(this.europeanSolitaireModel7.getBoard().size(), 7);
  }

  /**
   * Tests the setGameOver method
   */
  @Test
  public void testSetGameOver() {
    assertEquals(this.europeanSolitaireModel1.getGameOver(), false);
    this.europeanSolitaireModel1.setGameOver(true);
    assertEquals(this.europeanSolitaireModel1.getGameOver(), true);

    assertEquals(this.europeanSolitaireModel2.getGameOver(), false);
    this.europeanSolitaireModel2.setGameOver(true);
    assertEquals(this.europeanSolitaireModel2.getGameOver(), true);

    assertEquals(this.europeanSolitaireModel3.getGameOver(), false);
    this.europeanSolitaireModel3.setGameOver(true);
    assertEquals(this.europeanSolitaireModel3.getGameOver(), true);

    assertEquals(this.europeanSolitaireModel4.getGameOver(), false);
    this.europeanSolitaireModel4.setGameOver(true);
    assertEquals(this.europeanSolitaireModel4.getGameOver(), true);

    assertEquals(this.europeanSolitaireModel5.getGameOver(), false);
    this.europeanSolitaireModel5.setGameOver(true);
    assertEquals(this.europeanSolitaireModel5.getGameOver(), true);

    assertEquals(this.europeanSolitaireModel6.getGameOver(), false);
    this.europeanSolitaireModel6.setGameOver(true);
    assertEquals(this.europeanSolitaireModel6.getGameOver(), true);

    assertEquals(this.europeanSolitaireModel7.getGameOver(), false);
    this.europeanSolitaireModel7.setGameOver(true);
    assertEquals(this.europeanSolitaireModel7.getGameOver(), true);
  }


  /**
   * Tests the setBoardSize method
   */
  @Test
  public void testSetBoardSize() {
    assertEquals(this.europeanSolitaireModel1.getBoardSize(), 7);
    this.europeanSolitaireModel1.setBoardSize(4);
    assertEquals(this.europeanSolitaireModel1.getBoardSize(), 4);

    assertEquals(this.europeanSolitaireModel2.getBoardSize(), 7);
    this.europeanSolitaireModel2.setBoardSize(100);
    assertEquals(this.europeanSolitaireModel2.getBoardSize(), 100);

    assertEquals(this.europeanSolitaireModel3.getBoardSize(), 7);
    this.europeanSolitaireModel3.setBoardSize(500);
    assertEquals(this.europeanSolitaireModel3.getBoardSize(), 500);

    assertEquals(this.europeanSolitaireModel4.getBoardSize(), 7);
    this.europeanSolitaireModel4.setBoardSize(32);
    assertEquals(this.europeanSolitaireModel4.getBoardSize(), 32);

    assertEquals(this.europeanSolitaireModel5.getBoardSize(), 13);
    this.europeanSolitaireModel5.setBoardSize(45);
    assertEquals(this.europeanSolitaireModel5.getBoardSize(), 45);

    assertEquals(this.europeanSolitaireModel6.getBoardSize(), 7);
    this.europeanSolitaireModel6.setBoardSize(3);
    assertEquals(this.europeanSolitaireModel6.getBoardSize(), 3);

    assertEquals(this.europeanSolitaireModel7.getBoardSize(), 13);
    this.europeanSolitaireModel7.setBoardSize(3);
    assertEquals(this.europeanSolitaireModel7.getBoardSize(), 3);
  }

  /**
   * Tests the setArmThickness method
   */
  @Test
  public void testSetArmThickness() {
    assertEquals(this.europeanSolitaireModel1.getArmthickness(), 3);
    this.europeanSolitaireModel1.setArmthickness(4);
    assertEquals(this.europeanSolitaireModel1.getArmthickness(), 4);

    assertEquals(this.europeanSolitaireModel2.getArmthickness(), 3);
    this.europeanSolitaireModel2.setArmthickness(100);
    assertEquals(this.europeanSolitaireModel2.getArmthickness(), 100);

    assertEquals(this.europeanSolitaireModel3.getArmthickness(), 3);
    this.europeanSolitaireModel3.setArmthickness(500);
    assertEquals(this.europeanSolitaireModel3.getArmthickness(), 500);

    assertEquals(this.europeanSolitaireModel4.getArmthickness(), 3);
    this.europeanSolitaireModel4.setArmthickness(32);
    assertEquals(this.europeanSolitaireModel4.getArmthickness(), 32);

    assertEquals(this.europeanSolitaireModel5.getArmthickness(), 5);
    this.europeanSolitaireModel5.setArmthickness(3);
    assertEquals(this.europeanSolitaireModel5.getArmthickness(), 3);

    assertEquals(this.europeanSolitaireModel6.getArmthickness(), 3);
    this.europeanSolitaireModel6.setArmthickness(3);
    assertEquals(this.europeanSolitaireModel6.getArmthickness(), 3);

    assertEquals(this.europeanSolitaireModel7.getArmthickness(), 5);
    this.europeanSolitaireModel7.setArmthickness(3);
    assertEquals(this.europeanSolitaireModel7.getArmthickness(), 3);
  }

  /**
   * Test the samePosn method
   */
  @Test
  public void testSamePosn() {
    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).samePosn(new Posn(0, 0)), true);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(2).get(1).samePosn(new Posn(2, 1)), true);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(6).get(5).samePosn(new Posn(6, 5)), true);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(2).get(4).samePosn(new Posn(2, 4)), true);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(3).get(7).samePosn(new Posn(3, 7)), true);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(4).get(0).samePosn(new Posn(4, 0)), true);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(1).get(5).samePosn(new Posn(1, 5)), true);
  }

  /**
   * Tests the getState method
   */
  @Test
  public void testGetState() {
    assertEquals(this.europeanSolitaireModel1.getBoard().get(1).get(1).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel1.getBoard().get(2).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(6).get(6).getState(), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(5).get(6).getState(), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(6).get(5).getState(), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(5).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(9).get(9).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(6).get(6).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(1).get(0).getState(), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(5).get(4).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(11).get(11).getState(), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(5).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(4).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
  }

  /**
   * Test the setCurState method
   */
  @Test
  public void testSetCurState () {
    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Invalid);
    this.europeanSolitaireModel1.getBoard().get(0).get(0).setCurState(MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).getState(), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(this.europeanSolitaireModel2.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);
    this.europeanSolitaireModel2.getBoard().get(3).get(3).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(this.europeanSolitaireModel3.getBoard().get(5).get(5).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.europeanSolitaireModel3.getBoard().get(5).get(5).setCurState(MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(5).get(5).getState(), MarbleSolitaireModelState.SlotState.Empty);

    assertEquals(this.europeanSolitaireModel4.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.europeanSolitaireModel4.getBoard().get(2).get(2).setCurState(MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(2).get(2).getState(), MarbleSolitaireModelState.SlotState.Empty);

    assertEquals(this.europeanSolitaireModel5.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.europeanSolitaireModel5.getBoard().get(3).get(3).setCurState(MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(3).get(3).getState(), MarbleSolitaireModelState.SlotState.Empty);

    assertEquals(this.europeanSolitaireModel6.getBoard().get(3).get(4).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.europeanSolitaireModel6.getBoard().get(3).get(4).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(3).get(4).getState(), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(this.europeanSolitaireModel7.getBoard().get(6).get(6).getState(), MarbleSolitaireModelState.SlotState.Marble);
    this.europeanSolitaireModel7.getBoard().get(6).get(6).setCurState(MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(6).get(6).getState(), MarbleSolitaireModelState.SlotState.Invalid);
  }

  /**
   * Test the setXY method
   */
  @Test
  public void testSetXY () {
    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel1.getBoard().get(0).get(0).setXy(new Posn(1,1));
    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).getPosn().getx(), 1);
    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).getPosn().gety(), 1);

    assertEquals(this.europeanSolitaireModel2.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel2.getBoard().get(0).get(0).setXy(new Posn(2,5));
    assertEquals(this.europeanSolitaireModel2.getBoard().get(0).get(0).getPosn().getx(), 2);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(0).get(0).getPosn().gety(), 5);

    assertEquals(this.europeanSolitaireModel3.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel3.getBoard().get(0).get(0).setXy(new Posn(3,3));
    assertEquals(this.europeanSolitaireModel3.getBoard().get(0).get(0).getPosn().getx(), 3);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(0).get(0).getPosn().gety(), 3);

    assertEquals(this.europeanSolitaireModel4.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel4.getBoard().get(0).get(0).setXy(new Posn(4,2));
    assertEquals(this.europeanSolitaireModel4.getBoard().get(0).get(0).getPosn().getx(), 4);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(0).get(0).getPosn().gety(), 2);

    assertEquals(this.europeanSolitaireModel5.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel5.getBoard().get(0).get(0).setXy(new Posn(5,5));
    assertEquals(this.europeanSolitaireModel5.getBoard().get(0).get(0).getPosn().getx(), 5);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(0).get(0).getPosn().gety(), 5);

    assertEquals(this.europeanSolitaireModel6.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel6.getBoard().get(0).get(0).setXy(new Posn(2,1));
    assertEquals(this.europeanSolitaireModel6.getBoard().get(0).get(0).getPosn().getx(), 2);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(0).get(0).getPosn().gety(), 1);

    assertEquals(this.europeanSolitaireModel7.getBoard().get(0).get(0).getPosn().getx(), 0);
    this.europeanSolitaireModel7.getBoard().get(0).get(0).setXy(new Posn(3,5));
    assertEquals(this.europeanSolitaireModel7.getBoard().get(0).get(0).getPosn().getx(), 3);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(0).get(0).getPosn().gety(), 5);
  }

  /**
   * Tests the getX and getY method
   * along with the setters
   */
  @Test
  public void testGetXAndGetY() {
    assertEquals(this.europeanSolitaireModel1.getBoard().get(1).get(0).getPosn().getx(), 1);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(2).get(0).getPosn().getx(), 2);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(2).get(0).getPosn().getx(), 2);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(1).get(0).getPosn().getx(), 1);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(2).get(0).getPosn().getx(), 2);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(1).get(0).getPosn().getx(), 1);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(0).get(0).getPosn().getx(), 0);

    assertEquals(this.europeanSolitaireModel1.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(0).get(2).getPosn().gety(), 2);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(0).get(3).getPosn().gety(), 3);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(0).get(0).getPosn().gety(), 0);
    assertEquals(this.europeanSolitaireModel5.getBoard().get(0).get(5).getPosn().gety(), 5);
    assertEquals(this.europeanSolitaireModel6.getBoard().get(0).get(6).getPosn().gety(), 6);
    assertEquals(this.europeanSolitaireModel7.getBoard().get(0).get(7).getPosn().gety(), 7);

    this.europeanSolitaireModel1.getBoard().get(1).get(0).getPosn().setX(2);
    assertEquals(this.europeanSolitaireModel1.getBoard().get(1).get(0).getPosn().getx(), 2);
    this.europeanSolitaireModel2.getBoard().get(1).get(0).getPosn().setX(7);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(1).get(0).getPosn().getx(), 7);
    this.europeanSolitaireModel3.getBoard().get(1).get(0).getPosn().setX(4);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(1).get(0).getPosn().getx(), 4);
    this.europeanSolitaireModel4.getBoard().get(1).get(0).getPosn().setX(3);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(1).get(0).getPosn().getx(), 3);

    this.europeanSolitaireModel1.getBoard().get(1).get(0).getPosn().setY(2);
    assertEquals(this.europeanSolitaireModel1.getBoard().get(1).get(0).getPosn().getx(), 2);
    this.europeanSolitaireModel2.getBoard().get(1).get(0).getPosn().setY(7);
    assertEquals(this.europeanSolitaireModel2.getBoard().get(1).get(0).getPosn().getx(), 7);
    this.europeanSolitaireModel3.getBoard().get(1).get(0).getPosn().setY(4);
    assertEquals(this.europeanSolitaireModel3.getBoard().get(1).get(0).getPosn().getx(), 4);
    this.europeanSolitaireModel4.getBoard().get(1).get(0).getPosn().setY(3);
    assertEquals(this.europeanSolitaireModel4.getBoard().get(1).get(0).getPosn().getx(), 3);
  }


  /**
     * Tests the toString method
     */
  @Test
  public void testToString() {
    assertEquals("     0 0 0    \n" +
            "   0 0 0 0 0  \n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 _ 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "   0 0 0 0 0  \n" +
            "     0 0 0    \n", this.text1.toString());
    assertEquals("     0 0 0    \n" +
            "   0 0 0 0 0  \n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 _ 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "   0 0 0 0 0  \n" +
            "     0 0 0    \n", this.text2.toString());
    assertEquals("     0 0 0    \n" +
            "   0 0 0 0 0  \n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 _ 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "   0 0 0 0 0  \n" +
            "     0 0 0    \n", this.text3.toString());
    assertEquals("     0 0 0    \n" +
            "   0 0 0 0 0  \n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 _ 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "   0 0 0 0 0  \n" +
            "     0 0 0    \n", this.text4.toString());
    assertEquals(
            "         0 0 0 0 0        \n" +
                    "       0 0 0 0 0 0 0      \n" +
                    "     0 0 0 0 0 0 0 0 0    \n" +
                    "   0 0 0 0 0 0 0 0 0 0 0  \n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 _ 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    "   0 0 0 0 0 0 0 0 0 0 0  \n" +
                    "     0 0 0 0 0 0 0 0 0    \n" +
                    "       0 0 0 0 0 0 0      \n" +
                    "         0 0 0 0 0        \n", this.text5.toString());
    assertEquals("     0 0 0    \n" +
            "   0 0 0 0 0  \n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            " 0 0 0 0 0 0 0\n" +
            "   0 0 0 _ 0  \n" +
            "     0 0 0    \n", this.text6.toString());
    assertEquals(
            "         0 0 0 0 0        \n" +
                    "       0 0 0 0 0 0 0      \n" +
                    "     0 0 0 0 0 0 0 0 0    \n" +
                    "   0 0 0 0 0 0 0 0 0 0 0  \n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 _ 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    " 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                    "   0 0 0 0 0 0 0 0 0 0 0  \n" +
                    "     0 0 0 0 0 0 0 0 0    \n" +
                    "       0 0 0 0 0 0 0      \n" +
                    "         0 0 0 0 0        \n", this.text7.toString());

  }


}