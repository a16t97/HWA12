package org.example;
import org.example.transport.Bike;
import org.example.transport.Bus;
import org.example.transport.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    private static final String fileName = "resources/transport.csv";

    static String[] readFileUsingBufferedReader(String filename) {

        ArrayList<String> data = new ArrayList<String>();
        FileReader reader;

        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        var br = new BufferedReader(reader);
        String newLine;

        try {
            while ((newLine = br.readLine()) != null) {
                data.add(newLine);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Arrays.copyOf(data.toArray(), data.size(), String[].class);
    }

    private static List<LandTrans> createTransportObject(String[] data) {
        List<LandTrans> trans = new Vector<>();
        getTransportData(data, trans);
        return trans;
    }

    private static void getTransportData (String[] data, List<LandTrans> trans) {
        for (int c = 1; c < data.length; c++) {
            var pieces = data[c].split(";"); // method split - щоб "побити" строку на підстроку
            LandTrans transport = null;
            switch (pieces[1].toLowerCase()) {
                case "bus":
                    transport = new Bus(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5]));
                    break;
                case "car":
                    transport = new Car(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5]));
                    break;
                case "bike":
                    transport = new Bike(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5]));
                    break;
                default:
                    transport = new LandTrans(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5])) {
                    };
                    break;
            }
            trans.add(transport);
        }
    }

    interface MyFunctionalInterface {
        void doSomething();
    }

    static MyFunctionalInterface myFunctionalInterface = () -> {
        System.out.println("Hello!");
    };

    public static void main(String[] args) throws IOException{
        var importStart = System.currentTimeMillis();
        List<LandTrans> trans = new Vector<>();
        String[] data = readFileUsingBufferedReader(fileName);
        var importEnd = System.currentTimeMillis() - importStart;

        var createStart = System.currentTimeMillis();
        trans = createTransportObject(data);
        var createEnd = System.currentTimeMillis() - createStart;

        var actStreamStart = System.currentTimeMillis();
        Stream<LandTrans> stream = trans.stream();
        Stream<LandTrans> stream1 = trans.stream();
        Stream<LandTrans> stream2 = trans.stream();

        stream
                .sorted((d1, d2) -> (int) (d2.getCapacity() - d1.getCapacity()))
                .skip(5)
                .limit(21)
                .forEach(System.out::println);

        System.out.println(" "); // щоб була відстань між даними
        System.out.println("***"); // щоб була відстань між даними

        stream1
                .map(landTrans -> landTrans.getId() + " " + landTrans.getName() + " " + landTrans.getCapacity())
//                .limit(21) // можна розкоментувати, якщо потрібно вивести певну кіл-сть рядків, але в ТЗ не було сказано нічого про ліміт у map
                .forEach(System.out::println);

        System.out.println(" "); // щоб була відстань між даними
        System.out.println("***"); // щоб була відстань між даними

        stream2
                .filter(landTrans -> landTrans.getYearEnding() > 2035)
                .limit(21)
                .forEach(System.out::println);

        var actStreamEnd = System.currentTimeMillis() - actStreamStart;

//        myFunctionalInterface.doSomething();

        // Вимірювання тривалості
        System.out.println(" "); // щоб була відстань між даними
        System.out.println("***"); // щоб була відстань між даними

        Map<String, Long> executionTimes = new LinkedHashMap<>();
        executionTimes.put("Час імпорту даних з файлу", importEnd);
        executionTimes.put("Час обробки даних та створення об'єктів", createEnd);
        executionTimes.put("Час дії з 3 потоками", actStreamEnd);

        executionTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " мілісекунд"));

        // Вимірювання к-сть днів між датами:
        System.out.println(" "); // щоб була відстань між даними
        System.out.println("***"); // щоб була відстань між даними

        LocalDateTime dateBefore = LocalDateTime.of(2023, Month.NOVEMBER, 17, 10, 30);
        LocalDateTime dateAfter = LocalDateTime.of(2024, Month.FEBRUARY, 11, 10, 20);
        long daysBetween = DAYS.between(dateBefore, dateAfter);

        System.out.println("Дата до 1 грудня 2023: " + dateBefore);
        System.out.println("Дата після 1 лютого 2024: " + dateAfter);
        System.out.println("Різниця у днях: " + daysBetween + " днів.");
    }
}