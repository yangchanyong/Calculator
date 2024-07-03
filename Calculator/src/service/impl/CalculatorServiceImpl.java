package service.impl;

import java.util.Scanner;

import io.History;
import operator.Addition;
import operator.Divide;
import operator.Multiplication;
import operator.Operator;
import operator.Subtraction;
import service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("메뉴를 선택하세요:");
      System.out.println("1. 계산");
      System.out.println("2. 계산 내역 보기");
      System.out.println("3. 종료");

      String choice = scanner.nextLine();
      if (choice.equals("3")) {
        System.out.println("계산기가 종료됩니다.");
        break;
      } else if (choice.equals("2")) {
        History.readHistory();
        continue;
      } else if (!choice.equals("1")) {
        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
        continue;
      }

      System.out.println("첫 번째 숫자를 입력하세요 (종료하려면 'exit' 입력):");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("exit")) {
        System.out.println("계산기가 종료됩니다.");
        break;
      }

      double a = 0, b = 0;
      try {
        a = Double.parseDouble(input);
      } catch (NumberFormatException e) {
        System.err.println("유효하지 않은 입력입니다. 숫자를 입력하세요.");
        continue;
      }

      System.out.println("연산자를 입력하세요 (+, -, *, /):");
      String operator = scanner.nextLine();

      System.out.println("두 번째 숫자를 입력하세요:");
      try {
        b = Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.err.println("유효하지 않은 입력입니다. 숫자를 입력하세요.");
        continue;
      }

      Operator operation = null;
      switch (operator) {
        case "+":
          operation = new Addition(a, b);
          break;
        case "-":
          operation = new Subtraction(a, b);
          break;
        case "*":
          operation = new Multiplication(a, b);
          break;
        case "/":
          operation = new Divide(a, b);
          break;
        default:
          System.err.println("유효하지 않은 연산자입니다. +, -, *, / 중 하나를 입력하세요.");
          continue;
      }

      try {
        double result = operation.calculate();
        String history = a + " " + operator + " " + b + " = " + result;
        System.out.println(history);
        History.saveHistory(history);
      } catch (ArithmeticException e) {
        System.err.println("오류: " + e.getMessage());
      }
    }
    scanner.close();
  }
}
