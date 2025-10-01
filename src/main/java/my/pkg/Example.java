/*

Copyright 2025 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

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
    IO.println(String.format("This is no %s world!", args[0]));
  }
}
