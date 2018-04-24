/*
* This class prints the given message on console.
*/

public class TestMessageUtil {

   private String message;

   //Constructor
   //@param message to be printed
	
   public TestMessageUtil(String message){
      this.message = message;
   }
      
   // prints the message
   public String printMessage(){
      System.out.println(message);
      return message;
   }   
   
}  