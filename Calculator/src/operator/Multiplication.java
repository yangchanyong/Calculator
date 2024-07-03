package operator;

public class Multiplication extends Operator {
  public Multiplication(double a, double b) {
    super(a, b);
  }

  @Override
  public double calculate() {
      return a * b;
  }
}
