import service.CalculatorService;
import service.impl.CalculatorServiceImpl;

public class Calculator {

    public static void main(String[] args) {
        CalculatorService CalculatorService = new CalculatorServiceImpl();
        CalculatorService.run();
    }
}
