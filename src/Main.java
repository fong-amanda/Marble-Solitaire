import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.EuropeanMarbleSolitaire;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.TriangularMarbleSolitaire;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangularSolitaireTextView;

// Start playing the marble solitaire game
public class Main {
  public static void main(String[] args) {
    Appendable ap = System.out;
    Readable rd = new InputStreamReader(System.in);

    // initializes board based on the specified name
    if (args.length == 1) {
      if (args[0].equalsIgnoreCase("english")) {
        EnglishSolitaireModel model = new EnglishSolitaireModel();
        MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else if (args[0].equalsIgnoreCase("european")) {
        EuropeanMarbleSolitaire model = new EuropeanMarbleSolitaire();
        MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else if (args[0].equalsIgnoreCase("triangle")) {
        TriangularMarbleSolitaire model = new TriangularMarbleSolitaire();
        MarbleSolitaireView view = new TriangularSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else {
        System.out.println("Invalid Model Name");
      }
    }

    // creating model that takes in the size of the board
    else if (args.length == 3) {
      int size = Integer.parseInt(args[2]);
      if (args[0].equalsIgnoreCase("english")) {
        EnglishSolitaireModel model = new EnglishSolitaireModel(size);
        MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else if (args[0].equalsIgnoreCase("european")) {
        EuropeanMarbleSolitaire model = new EuropeanMarbleSolitaire(size);
        MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else if (args[0].equalsIgnoreCase("triangle")) {
        TriangularMarbleSolitaire model = new TriangularMarbleSolitaire(size);
        MarbleSolitaireView view = new TriangularSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else {
        System.out.println("Invalid Model Name");
      }
    }

    // creates board that takes in the posn of the empty slot
    else if (args.length == 4) {
      int eRow = Integer.parseInt(args[2]);
      int eCol = Integer.parseInt(args[3]);
      if (args[0].equalsIgnoreCase("english")) {
        EnglishSolitaireModel model = new EnglishSolitaireModel(eRow, eCol);
        MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else if (args[0].equalsIgnoreCase("european")) {
        EuropeanMarbleSolitaire model = new EuropeanMarbleSolitaire(eRow, eCol);
        MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else if (args[0].equalsIgnoreCase("triangle")) {
        TriangularMarbleSolitaire model = new TriangularMarbleSolitaire(eRow, eCol);
        MarbleSolitaireView view = new TriangularSolitaireTextView(model, ap);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, rd);

        try {
          controller.playGame();
        }
        catch (IOException e) {
          System.out.println("Transmission Failed");
        }
      }
      else {
        System.out.println("Invalid Model Name");
      }
    }


  }


}