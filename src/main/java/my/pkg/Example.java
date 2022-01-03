package my.pkg;

/**
 * An example class.
 *
 * <p>This is just an example, this class just storese an immutable {@code boolean} value, given at
 * construction time, and returns it,
 */
public class Example {

  /** A constant, just to show that also private fields are included in the docs. */
  public static final String CONST = "This is a class constant";

  /** The representation for this class. */
  private final boolean aField;

  /**
   * Builds an example object.
   *
   * @param aField the value to remember.
   */
  public Example(boolean aField) {
    this.aField = aField;
  }

  /**
   * Returns the value given at build time.
   *
   * <p>You can include also mathematical notation in the docs, for example \( v \implies q \) or
   * \(\int_0^\infty \sin(x)dx \).
   *
   * @return the remembered value.
   */
  public boolean aMethod() {
    return aField;
  }

  /**
   * The main method of this class.
   *
   * @param args the command line arguments.
   */
  public static void main(String[] args) {
    System.out.printf("This is no %s world!\n", args[0]);
  }
}
