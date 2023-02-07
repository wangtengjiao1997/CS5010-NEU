package dungeon;

import java.util.ArrayList;

public class MedievalLevelBuilder {
  private int roomNum;
  private int monsterNum;
  private int treasureNum;
  private Level level;
  private int roomCount;
  private int monsterCount;
  private int treasureCount;

  /**
   * constructor for MedievalLevelBuilder
   * @param level
   * @param room
   * @param monster
   * @param treasures
   */
  public MedievalLevelBuilder(int level, int room, int monster, int treasures){
    if(level<0 || room<0 || monster<0 || treasures<0){
      throw new IllegalArgumentException("input can't be negative");
    }
    this.roomNum = room;
    this.monsterNum = monster;
    this.treasureNum = treasures;
    this.level=new Level(level);
  }

  /**
   * add a room to the level
   * @param description
   */
  public void addRoom(String description){
    if (this.roomCount>=roomNum){
      throw new IllegalStateException("");
    }
    roomCount++;
    this.level.addRoom(description);
  }

  /**
   * add goblins to target room
   * @param targetRoom
   * @param goblinNum
   */
  public void addGoblins(int targetRoom, int goblinNum){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((goblinNum+monsterCount)>monsterNum){
      throw new IllegalStateException("too many monsters");
    }
    for (int i = 0; i<goblinNum; i++){
      Monster goblin = new Monster("goblin","mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind", 7);
      level.addMonster(targetRoom, goblin);
      monsterCount++;
    }
  }

  /**
   * add orc to target room
   * @param targetRoom
   */
  public void addOrc(int targetRoom){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((1+monsterCount)>monsterNum){
      throw new IllegalStateException("too many monsters");
    }
    Monster orc = new Monster("orc","brutish, aggressive, malevolent being serving evil",20);
    level.addMonster(targetRoom, orc);
    monsterCount++;
  }
  /**
   * add ogre to target room
   * @param targetRoom
   */
  public void addOgre(int targetRoom){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((1+monsterCount)>monsterNum){
      throw new IllegalStateException("too many monsters");
    }
    Monster ogre = new Monster("ogre","large, hideous man-like being that likes to eat humans for lunch",50);
    level.addMonster(targetRoom, ogre);
    monsterCount++;
  }

  /**
   * add human to target room
   * @param targetRoom
   */
  public void addHuman(int targetRoom, String name, String description, int hp){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((1+monsterCount)>monsterNum){
      throw new IllegalStateException("too many monsters");
    }
    Monster human = new Monster(name,description,hp);
    level.addMonster(targetRoom, human);
    monsterCount++;
  }

  /**
   * add potion to target room
   * @param targetRoom
   */
  public void addPotion(int targetRoom){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((1+treasureCount)>treasureNum){
      throw new IllegalStateException("too many treasure");
    }
    Treasure potion = new Treasure("a healing potion",1);
    level.addTreasure(targetRoom,potion);
    treasureCount++;
  }

  /**
   * add gold to target room
   * @param targetRoom
   */
  public void addGold(int targetRoom, int number){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((1+treasureCount)>treasureNum){
      throw new IllegalStateException("too many treasure");
    }
    Treasure gold = new Treasure("pieces of gold",number);
    level.addTreasure(targetRoom,gold);
    treasureCount++;
  }

  /**
   * add weapon to target room
   * @param targetRoom
   */
  public void addWeapon(int targetRoom, String decription){
    if (targetRoom<0){
      throw new IllegalArgumentException ("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalArgumentException ("room haven't created");
    }
    if ((1+treasureCount)>treasureNum){
      throw new IllegalStateException("too many treasure");
    }
    Treasure weapon = new Treasure(decription,10);
    level.addTreasure(targetRoom, weapon);
    treasureCount++;
  }

  /**
   * add special to target room
   * @param targetRoom
   */
  public void addSpecial(int targetRoom, String decription, int number){
    if (targetRoom<0){
      throw new IllegalStateException("room can't be negative");
    }
    if (targetRoom>roomCount){
      throw new IllegalStateException("room haven't created");
    }
    if ((1+treasureCount)>treasureNum){
      throw new IllegalStateException("too many treasure");
    }
    Treasure Special = new Treasure(decription,number);
    level.addTreasure(targetRoom, Special);
    treasureCount++;
  }

  /**
   * build this level
   * @return
   */
 public Level build(){
    if (treasureCount==treasureNum && monsterCount==monsterNum && roomNum==roomCount){
      return this.level;
    }else{
      throw new IllegalStateException("build failed");
    }
 }

}
