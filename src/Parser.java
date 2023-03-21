import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Parser {
    private final Scanner scanner;
    private List<Integer> intList;
    private List<Integer> sequence;
    private int curValue;


    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parse() {
        intList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            intList.add(scanner.nextInt());
        }
        //System.out.println(intList);
    }

    private void recurse(int cur, int index) {

        for (int i = index; i < intList.size(); i++) {
            int tmp = intList.get(i) * cur;

            if (tmp < curValue) {
                sequence.add(intList.get(i));
                recurse(tmp, i + 1);
            } else if (tmp == curValue) {

                if (sequence.size() > 0) {
                    sequence.add(intList.get(i));
                    System.out.println(sequence);
                    sequence.remove(sequence.size() - 1);
                }
            }
        }

        if (sequence.size() > 0)
            sequence.remove(sequence.size() - 1);
    }
    public void printSequences() {
        sequence = new ArrayList<>();
        for (Integer value : intList) {
            curValue = value;
            recurse(1, 0);
        }
    }

}
