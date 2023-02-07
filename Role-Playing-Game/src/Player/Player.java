package Player;

import java.util.ArrayList;
import java.util.List;

import Equipment.Equipment;

/**
 * This interface is design for the Player
 */
public interface Player {
  void choseEquipment(ArrayList<Equipment> equipmentlist);

  int getFinalAttack();

  int getFinalDefense();


}
