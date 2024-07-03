package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class History {
  public static void saveHistory(String history) {
    try (FileWriter writer = new FileWriter("history.txt", true)) {
        writer.write(history + "\n");
    } catch (IOException e) {
        System.err.println("내역 저장 실패: " + e.getMessage());
    }
  }

  public static void readHistory() {
      try (BufferedReader reader = new BufferedReader(new FileReader("history.txt"))) {
          String line;
          System.out.println("계산 내역:");
          while ((line = reader.readLine()) != null) {
              System.out.println(line);
          }
      } catch (IOException e) {
          System.err.println("내역 읽기 실패: " + e.getMessage());
      }
  }
}
