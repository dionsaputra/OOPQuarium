import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestJunit {
	
   String message = "Hello World";	
   TestMessageUtil messageUtil = new TestMessageUtil(message);

   @Test
   public void testPrintMessage() {
      assertEquals(message,messageUtil.printMessage());
   }
   @Test
   public void testPrintMessage2() {
      assertEquals(message,messageUtil.printMessage());
   }
}