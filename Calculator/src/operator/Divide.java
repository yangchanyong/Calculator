package operator;

public class Divide extends Operator {
  public Divide(double a, double b) {
      super(a, b);
  }

  @Override
  public double calculate() {
      if (b == 0) {
          throw new ArithmeticException("0으로 나눌 수 없습니다");
      }
      return a / b;
  }
}
