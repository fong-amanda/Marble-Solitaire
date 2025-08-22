# Marble-Solitaire
Overview

Marble Solitaire is a single-player board game implemented in Java, featuring multiple board configurations and a robust Model-View-Controller (MVC) architecture. The game challenges players to remove marbles by jumping over them, with the goal of minimizing the number of marbles on the board.

Features

Multiple board configurations (English and European Solitaire)
Flexible game model with various board sizes
Text-based game interface
Comprehensive move validation
Customizable empty slot positioning

Game Rules

The game starts with marbles filling most of the board, leaving one slot empty
Players can move a marble by jumping over another marble orthogonally
A jump is valid if:

The "from" position has a marble
The "to" position is empty
The "to" and "from" positions are exactly two slots apart
There is a marble between the "from" and "to" positions


Jumped-over marbles are removed from the board
The game ends when no more valid moves are possible
The objective is to minimize the number of marbles remaining

Supported Configurations

English Solitaire: Traditional plus-shaped board
European Solitaire: Octagonal board variant

Prerequisites

Java Development Kit (JDK) 8 or higher
A Java IDE (recommended: IntelliJ IDEA, Eclipse)

Installation

Clone the repository
Open the project in your preferred Java IDE
Ensure all dependencies are resolved

Running the Game
You can run the game with various command-line arguments:
Examples
bash# Default English Solitaire
java MarbleSolitaire english

# English Solitaire with custom board size
java MarbleSolitaire english -size 5

# European Solitaire with custom hole position
java MarbleSolitaire european -hole 1 4
Game Modes

english: Original plus-shaped board
european: Octagonal board variant
Optional parameters:

-size N: Set board size
-hole R C: Set initial empty slot position



Project Structure

model/: Game logic and board representations
view/: Text-based visualization
controller/: Game flow management

Development

Implemented using Object-Oriented Design principles
Follows Model-View-Controller (MVC) architecture
Extensive error handling and input validation
