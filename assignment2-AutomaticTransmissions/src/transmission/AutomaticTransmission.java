package transmission;
public class AutomaticTransmission implements Transmission{
  private int firstGearSpeed;
  private int secondGearSpeed;
  private int thirdGearSpeed;
  private int forthGearSpeed;
  private int fifthGearSpeed;
  private int gear;
  private int speed;
  public AutomaticTransmission(int a, int b, int c, int d, int e){
    this.firstGearSpeed = a;
    this.secondGearSpeed = b;
    this.thirdGearSpeed = c;
    this.forthGearSpeed = d;
    this.fifthGearSpeed = e;
    this.speed = 0;
    if (firstGearSpeed<=0 || secondGearSpeed<=0 || thirdGearSpeed<=0 || forthGearSpeed<=0 || fifthGearSpeed<=0){
      throw new IllegalArgumentException("Gear speed can't be zero or negative");
    }
    if(firstGearSpeed>=secondGearSpeed){
      throw new IllegalArgumentException("Higher gear speed can't be lower than lower gear speed");
    }
    if(secondGearSpeed>=thirdGearSpeed){
      throw new IllegalArgumentException("Higher gear speed can't be lower than lower gear speed");
    }
    if(thirdGearSpeed>=forthGearSpeed){
      throw new IllegalArgumentException("Higher gear speed can't be lower than lower gear speed");
    }
    if(forthGearSpeed>=fifthGearSpeed){
      throw new IllegalArgumentException("Higher gear speed can't be lower than lower gear speed");
    }
  }
  public void setGear(int speed){
    if( 0<=speed && speed<this.firstGearSpeed){
      this.gear = 1;
    }
    else if (this.firstGearSpeed<=speed && this.speed <this.secondGearSpeed) {
      this.gear = 2;
    }
    else if (this.secondGearSpeed<=speed && this.speed <this.thirdGearSpeed) {
      this.gear = 3;
    }
    else if (this.thirdGearSpeed<=speed && this.speed <this.forthGearSpeed) {
      this.gear = 4;
    }
    else if (this.forthGearSpeed<=speed && this.speed <this.fifthGearSpeed) {
      this.gear = 5;
    }else{
      this.gear = 6;
    }
  }
  @Override
  public int getGear(){
    return this.gear;
  }
  @Override
  public int getSpeed(){
    return  this.speed;
  }

  @Override
  public Transmission increaseSpeed(){
    this.speed += 2;
    setGear(this.speed);
    return (Transmission) this;
  }

  @Override
  public Transmission decreaseSpeed(){
    if (this.speed-2<0){
      throw new IllegalStateException("Speed can't be lower than 0");
    }
    this.speed -= 2;
    setGear(this.speed);
    return (Transmission) this;
  }

  @Override
  public String toString(){
    String str = "Transmission (speed = " + this.speed + ", gear = " + this.gear + ")";
    return str;
  }
}
