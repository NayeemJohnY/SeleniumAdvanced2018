package module1;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestClassTwo {

	@Test
    public void testMethodPass()
    {
     Assert.assertFalse(false);
    }
     
    @Test
    public void testMethodFail()
    {
     Assert.assertFalse(true);
    }
     
    @Test
    public void testMethodSkip()
    {
     throw new SkipException("Skipped Intentionally");
    }
}
