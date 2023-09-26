import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.MockView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the MarbleSolitaireView Class
 */
public class MarbleSolitaireViewTests {
  MarbleSolitaireModelState state = new EnglishSolitaireModel();
  Appendable ap = new StringBuilder();
  MarbleSolitaireView view = new MarbleSolitaireTextView(state, ap);


  /** Testing that the renderMessage() method of
   *  view transmits the given string to the appendable
   *  by using a Mock View Class
   *
   * @throws IOException
   */
  @Test
  public void testRenderMessage() throws IOException {
    ArrayList<String> log = new ArrayList<String>();
    MarbleSolitaireView mockView = new MockView(log);

    ArrayList<String> expectedLog  = new ArrayList<String>();
    mockView.renderMessage("Hello");

    expectedLog.add("renderMessage(Hello)");

    assertEquals(expectedLog, log);
  }

  /** Testing that renderBoard transmits the toString()
   *  method of view to the appendable by using a
   *  Mock View Class
   *
   * @throws IOException
   */
  @Test
  public void testRenderBoard() throws IOException {
    ArrayList<String> log = new ArrayList<String>();
    MarbleSolitaireView mockView = new MockView(log);

    ArrayList<String> expectedLog  = new ArrayList<String>();
    mockView.renderBoard();

    expectedLog.add("renderBoard()");

    assertEquals(expectedLog, log);
  }

  /** Test the MockView Class and its methods
   *
   * @throws IOException
   */
  @Test
  public void testMockView() throws IOException {
    ArrayList<String> log = new ArrayList<String>();
    MarbleSolitaireView mockView = new MockView(log);

    ArrayList<String> expectedLog  = new ArrayList<String>();
    mockView.renderBoard();
    mockView.toString();
    mockView.renderMessage("Mock View");

    expectedLog.add("renderBoard()");
    expectedLog.add("toString()");
    expectedLog.add("renderMessage(Mock View)");

    assertEquals(expectedLog, log);
    assertEquals(mockView.toString(), "");
  }

}
