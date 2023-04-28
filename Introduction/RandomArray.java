import java.util.Random;

class RandomArray {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int arrayLength = random.nextInt(0, 2147483647);

        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; ++i) {
            array[i] = random.nextInt();
        }

        int[] temp = array.clone(); // array::clone is necessary to set temp to the primitive data, not the reference data

        for (int i = 0; i < arrayLength; ++i) {
            array[i] = temp[arrayLength-i-1];
        }
    }
}