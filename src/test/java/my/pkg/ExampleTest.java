package my.pkg;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExampleTest {

  @Test
  public void remembersTrue() {
    Example e = new Example(true);
    assertTrue(e.aMethod());
  }

  @Test
  public void remembersFalse() {
    Example e = new Example(false);
    assertFalse(e.aMethod());
  }
}
