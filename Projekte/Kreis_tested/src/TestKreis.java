import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class TestKreis {
	    
   private static Kreis myKreis;
    
   @BeforeAll
   public static void setup() throws Exception {
      // Test-Objekt erschaffen mit den Testwerten (Radius: 10)
      myKreis = new Kreis(10);
      System.out.println("Start!");
   }
    
   @BeforeEach
   public void vorTest() {
      // Diese Methode wird vor jedem Testfall ausgeführt
      System.out.println("vor Test");
   }
   
   @Test
   public void testUmfang() {
      // Testfall 1: Prüfung ob Umfangsberechnung stimmt
	  // Erwartetes Ergebnis: 62.832
      System.out.println("Test Umfang");
      double umfang = myKreis.berechneUmfang();
      assertTrue(63 > umfang && umfang > 62);      
   }
    
   @Test
   public void testVolument() {
      // Testfall 2: Prüfung ob Flächeninhaltsberechnung stimmt
      System.out.println("Test Volume");
      assertNotNull(myKreis.berechneFlaeche());   
   }
   

   @Test
   public void testNegativerRadius() throws Exception
   {
	   System.out.println("Test Negativer Radius");
	   Throwable exception = assertThrows(Exception.class, () -> {
		   Kreis kreis = new Kreis(-4);
       });
	   
	   //Überprüfung der Exception Message auf Grund des generellen Exception Typs
       assertEquals("negativer Wert für Radius nicht erlaubt", exception.getMessage());
   }
   
   @Test
   public void testKreisboegenLaenge()
   {
	   double _kreis_bogen_laenge =  myKreis.berechneKreisbogenlänge(85);
	   assertTrue(14 < _kreis_bogen_laenge && _kreis_bogen_laenge < 15);
   }
    
   @AfterEach
   public void nachTest() {
      // Diese Methode wird nach jedem Testfall ausgeführt z.B. um einen bestimmten Zustand zu erreichen
      System.out.println("nach Test");
   }
    
   @AfterAll
   public static void delete() {
      // Diese Methode wird am Ende der Test-Klasse ausgeführt z.B. zum aufräumen oder löschen von Rückständen
	   myKreis = null;
	   System.out.println("Test Ende!");
   }
}