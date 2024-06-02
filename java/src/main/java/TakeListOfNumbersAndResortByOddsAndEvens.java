import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Take list Of numbers and Resort by Odds and Even
 *
 * Coding challenge for one interview:
 *
 * Take this input: { 1, 6, 5, 7,2, 8, 9, 3 }
 * and get this output: { 1,3,5,7,9,2,6,8 }
 */
public class TakeListOfNumbersAndResortByOddsAndEvens {

    public static void main(String[] args) {
        TakeListOfNumbersAndResortByOddsAndEvens app = new TakeListOfNumbersAndResortByOddsAndEvens();

        List<Integer> sourceList = Arrays.asList(1, 6, 5, 7, 2, 8, 9, 3);
        List<Integer> expectedList = Arrays.asList(1, 3, 5, 7, 9, 2, 6, 8);

        List<Integer> processedList = app.processList(sourceList);

        if (!Arrays.equals(expectedList.toArray(), processedList.toArray())) {
            throw new RuntimeException("Result should have been true");
        }

        System.out.println("Success!!!");
    }

    private List<Integer> processList(List<Integer> sourceList) {
        List<Integer> sourceElements = Arrays.asList(1, 6, 5, 7, 2, 8, 9, 3);
        Collections.sort(sourceElements);

        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        for (Integer sourceElement : sourceElements) {
            if (sourceElement == 1 || (sourceElement % 2 != 0)) {
                odds.add(sourceElement);
            } else {
                evens.add(sourceElement);
            }
        }

        List<Integer> outputList = new ArrayList<>();
        outputList.addAll(odds);
        outputList.addAll(evens);

        return outputList;
    }
}
