package cs3500.marblesolitaire.controller;

import java.io.IOException;

public interface MarbleSolitaireController {

  /**
   * plays new game of Marble Solitaire
   *
   * throws IllegalStateException if controller doese not
   * successfully read input or transmit output
   */
  public void playGame() throws IllegalStateException, IOException;
}
