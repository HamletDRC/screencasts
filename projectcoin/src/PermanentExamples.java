import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermanentExamples {

    public static void main(String[] args) throws Exception {
        try {
            doSomething();
        } catch (ClassNotFoundException e) {
            handleError(e);
        } catch (NoSuchFieldException e) {
            handleError(e);
        } catch (IllegalAccessException e) {
            handleError(e);
        }


        FileReader reader = new FileReader(args[0]);
        try {
            System.out.println(reader.read());
        } finally {
            reader.close();
        }


        switch (args[0]) {
            case "a":
            case "b":
                System.out.println(args[0]);
            default:
                System.out.println("unknown");
        }

        ArrayList<String> list = new ArrayList<String>();

        long num = 15_000_000_000L;
    }

    static List<List<String>> listOfListOfStrings() {
        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        return Arrays.asList(a, b);
    }

    private static void handleError(Exception e) {

    }

    private static void doSomething() throws ClassNotFoundException,
            NoSuchFieldException,
            IllegalAccessException {

        Class<?> clazz = Class.forName("SomeClass");
        Field field = clazz.getField("field");
        field.set(new Object(), "value");
    }
}
