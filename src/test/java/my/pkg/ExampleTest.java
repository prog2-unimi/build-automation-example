package my.pkg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
