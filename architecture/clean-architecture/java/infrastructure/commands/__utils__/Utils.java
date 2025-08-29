package infrastructure.commands.__utils__;

import java.util.Map;
import java.util.Scanner;

import core.entities.Filter;
import shared.__utils__.XMLToMapParser;

public class Utils {
    public static String getId(Scanner scanner) {
        String question = "Input id: \n";
        System.out.print(question);
        String answer = scanner.nextLine();
        return answer;
    }
    public static Map<String, Object> getData(Scanner scanner) {
        String question = "Input data (must be valid xml):\n";
        System.out.print(question);
        String answer = scanner.nextLine();

        Map<String, Object> data = null;
        try {
            data = XMLToMapParser.parseXML(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    public static Filter getFilter(Scanner scanner) {
        String question = "Filter (must be valid xml):\n";
        System.out.print(question);
        String answer = scanner.nextLine();

        Map<String, Object> data = null;
        try {
            data = XMLToMapParser.parseXML(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Filter(data);
    }
}
