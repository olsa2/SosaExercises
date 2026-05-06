import java.util.Arrays;

public class NumberProcessor {
    private int[] values;

    public NumberProcessor(int[] values) {
        this.values = values.clone();
    }


    public void printGreaterThan(int threshold) {
        class FilterArray {
            private int amountGreaterThan() {
                int count = 0;
                for (int i = 0; i < values.length; i++) {
                    if (values[i] > threshold) {
                        count++;
                    }
                }
                return count;
            }

            int[] filter() {
                int[] result = new int[amountGreaterThan()];
                int resultIndex = 0;
                for (int i = 0; i < values.length; i++) {
                    if (values[i] > threshold) {
                        result[resultIndex] = values[i];
                        resultIndex++;
                    }
                }
                return result;
            }

        }

        FilterArray filterArray = new FilterArray();
        System.out.println(Arrays.toString(filterArray.filter()));
    }

    public void printInRange(int min, int max) {
        class RangeFilter {
            boolean matches(int value) {
                return value >= min && value <= max;
            }
        }
        RangeFilter rangeFilter = new RangeFilter();
        for(int i=0; i<values.length; i++){
            if (rangeFilter.matches(values[i])) {
                System.out.print(values[i] + " ");
            }
        }
    }

    public void printEvenNumbers() {
        class EvenFilter{
            boolean checkIfEven(int value){
                return value%2==0;
            }

        }
        EvenFilter evenFilter = new EvenFilter();
        for(int i=0; i<values.length; i++){
            if(evenFilter.checkIfEven(values[i])){
                System.out.print(values[i]+ " ");
            }
        }
    }
    public void printStatistsics(){
        class Stats{
            int getSum(){
                int sum = 0;
                for (int i=0; i<values.length; i++){
                    sum += values[i];
                }
                return sum;
            }

            int getAverage(){
                int average = 0;
                for(int i=0; i<values.length; i++){
                    average += values[i];
                    //average /= values.length;
                }
                return average / values.lenght;
            }

            int getMin(){
                int min = Integer.MAX_VALUE;
                for(int i=0; i<values.length; i++){
                    if(values[i] < min){
                        min = values[i];
                    }
                }
                return min;
            }

            int getMax(){
                int max = Integer.MIN_VALUE;
                for(int i=0; i<values.length; i++){
                    if(values[i] > max){
                        max = values[i];
                    }
                }
                return max;
            }
        }
        Stats stats = new Stats();
        System.out.println("sum: " + stats.getSum());
        System.out.println("average: " + stats.getAverage());
        System.out.println("min: " + stats.getMin());
        System.out.println("max: " + stats.getMax());
    }

}
