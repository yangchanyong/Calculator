package operator;

public abstract class Operator {
  protected double a, b;

  public Operator(double a, double b) {
      this.a = a;
      this.b = b;
  }

  public abstract double calculate();
}