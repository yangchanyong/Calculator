package operator;

public class Subtraction extends Operator{
  public Subtraction(double a, double b) {
    super(a, b);
  }

  @Override
  public double calculate() {
      return a - b;
  }
}
