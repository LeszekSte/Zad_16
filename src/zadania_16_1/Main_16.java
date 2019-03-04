package zadania_16_1;

import zadania_16_1.Calc;
import zadania_16_1.InputOutputData;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

public class Main_16 {
    public static void main(String[] args) throws IOException {
        InputOutputData data = new InputOutputData();
        Map<ZonedDateTime, Task> tasks = data.readData();
        data.inputNewDate();
        Calc calc = new Calc();
        calc.printAllData(tasks);
        boolean temrnFuture = true;
        calc.printData(tasks, !temrnFuture);
        calc.printData(tasks, temrnFuture);
    }
}
