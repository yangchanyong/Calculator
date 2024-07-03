package operator;

public class Addition extends Operator{
  public Addition(double a, double b) {
    super(a, b);
  }

  @Override
  public double calculate() {
      return a + b;
  }
}
