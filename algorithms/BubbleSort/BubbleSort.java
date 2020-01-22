import java.util.Arrays;

public class BubbleSort {
    private int[] in;

    BubbleSort(int[] input) {
        this.in = input;
    }

    //public static void main(String[] args) {
    //}

    public int[] sort() {
        boolean sortComplete = true;
        int num1;
        int num2;

        for(int i = 0; i < in.length-1 ; i++) {
            if(in[i] > in[i+1]) {
                sortComplete = false;
                num1 = in[i];
                num2 = in[i+1];

                in[i] = num2;
                in[i+1] = num1;
            }
        }

        if(!sortComplete) {
            sort();
        }

        return this.in;
    }
};
