package weather;
public class WeatherReading {
  private int airTemperature;
  private int dewPoint;
  private int windSpeed;
  private int totalRain;
  private int relativeHumidity;


  public WeatherReading(int airTemperature, int dewPoint, int windSpeed, int totalRain){
    if (dewPoint>airTemperature){
      throw new IllegalArgumentException("Dew point should be less than temperature");
    }
    if (windSpeed<0){
      throw new IllegalArgumentException("Wind speed is non-negative");
    }
    if (totalRain<0){
      throw new IllegalArgumentException("Total Rain is non-negative");
    }
    this.airTemperature = airTemperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
    this.relativeHumidity = (this.dewPoint - this.airTemperature) * 5 + 100;
  }

  public int getTemperature(){
    return this.airTemperature;
  }

  public int getDewPoint(){
    return this.dewPoint;
  }

  public int getWindSpeed(){
    return this.windSpeed;
  }

  public int getTotalRain(){
    return this.totalRain;
  }

  public int getRelativeHumidity(){
    return this.relativeHumidity;
  }

  public double getHeatIndex(){
    double temp = this.airTemperature;
    double humi = this.relativeHumidity;
    double res = -8.78469475556 + (1.61139411*temp) + (2.33854883889*humi) + (-0.14611605*humi*temp) + (-0.012308094*Math.pow(temp,2))+
            (-0.0164248277778*Math.pow(humi,2)) + (0.002211732*Math.pow(temp,2)*humi) + (0.00072546*temp*Math.pow(humi,2)) + (-0.000003582*Math.pow(temp,2)*Math.pow(humi,2));
    return res;
  }

  public double getWindChill(){
    double wind = this.getWindSpeed();
    double temp_c = this.getTemperature();
    double temp = temp_c * (9.0 / 5.0) +32;
    double res = 35.74 + (0.6215 * temp) - (35.75 * Math.pow(wind,0.16)) + (0.4275 * temp * Math.pow(wind, 0.16));
    return  res;
  }

  public String toString(){
    return "Reading: T = " + this.getTemperature() + ", D = " + this.getDewPoint() +
            ", v = " + this.getWindSpeed() + ", rain = " + this.getTotalRain();
  }
}
