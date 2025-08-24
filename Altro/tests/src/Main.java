public class Main {
    public static void main(String[] args) {

    }

    public class JavaLC8 {

        public void process(int[] array) {
            throw new UnsupportedOperationException();//replace with your solution
        }

        public void arraySort(int[] array) {
            int left = 0, right = array.length - 1;

            while (left < right) {
                if (array[left] == 0) {
                    left++;
                } else if (array[right] == 1) {
                    right--;
                } else {
                    // Swap array[left] and array[right]
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                    left++;
                    right--;
                }
            }
        }

    }
}