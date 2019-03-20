
public class Kreis {
		 
   private int radius;
 
   public Kreis(int _radius) throws Exception {
	  if (_radius < 0)
		  throw new Exception("negativer Wert für Radius nicht erlaubt");
      this.radius = _radius;
   }
 
   public double berechneUmfang() {
      return 2 * Math.PI * radius;
   }
 
   public double berechneFlaeche() {
      return Math.PI * Math.pow(radius,2);
   }
   
   public double berechneKreisbogenlänge(float _winkel)
   {
	   return berechneUmfang() * _winkel / 360;
   }
}
