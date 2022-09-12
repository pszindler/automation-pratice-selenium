import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String gridRadioSexListCSS = ".form-check:nth-child(*) [name='gridRadiosSex']";
        int lol = getRandomValue(1,10);
        String str = String.valueOf(lol);
        char str2 = str.charAt(0);
        System.out.println(randomSelector(gridRadioSexListCSS, str2));

    }
    public static int getRandomValue(int from, int to) {
        return new Random().ints(from, to)
                .findFirst()
                .getAsInt();
    }

    public static String randomSelector(String selector, int numberOfElement) {
        char number = String.valueOf(numberOfElement).charAt(0);
        return selector.replace('*', number);
    }
}
