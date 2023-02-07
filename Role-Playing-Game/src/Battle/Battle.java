package Battle;

import java.util.ArrayList;

import Equipment.Equipment;
import Player.Player;

/**
 *  driver class for start the game
 */
public class Battle {
  private Player player1;
  private Player player2;
  private static int MAXROUND = 10;
  private ArrayList<Equipment> equipmentList;

  private String Log = "";

  public Battle(Player player1, Player player2, ArrayList<Equipment> equipmentList) {
    this.player1 = player1;
    this.player2 = player2;
    this.equipmentList = equipmentList;
  }

  /**
   * Once fight, it will return a string which print who's the winner
   * @return String
   */
  public String fight() {
    for (int x = 01; x < MAXROUND; x += 2) {
      Log = Log + "Round " + x + "\n";
      player1.choseEquipment(this.equipmentList);
      Log = Log +"player1:\n "+ player1.toString()+"\n";
      Log = Log +"player2:\n "+ player2.toString()+"\n";
      Log = Log + "Round " + (x + 1) + "\n";
      player2.choseEquipment(this.equipmentList);
      Log = Log +"player1:\n "+ player1.toString()+"\n";
      Log = Log +"player2:\n "+ player2.toString()+"\n";
    }
    int attack1 = player1.getFinalAttack();
    int defense1 = player1.getFinalDefense();
    int attack2 = player2.getFinalAttack();
    int defense2 = player2.getFinalDefense();

    if ((attack1 - defense2) == (attack2 - defense1)) {
      Log = Log + "Tie!!!\n";
      return "Tie!!!";
    } else if ((attack1 - defense2) > (attack2 - defense1)) {
      Log = Log + "Player 1 win!!!\n";
      return "Player 1 win!!!";
    } else {
      Log = Log + "Player 2 win!!!\n";
      return "Player 2 win!!!";
    }
  }

  /**
   * get the information for this battle
   * @return
   */
  public String getLog() {
    return this.Log;
  }
}
