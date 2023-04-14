import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TestClass tClass = new TestClass();
        apply(tClass);
    }

    public static void apply(TestClass tClass) {
        try {
        Class<?> clazz = tClass.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            MyAnnotation n = method.getAnnotation(MyAnnotation.class);
            method.setAccessible(true);

            Parameter[] parameters = method.getParameters();
            Object[] objs = new Object[parameters.length];

            for (int j = 0; j < parameters.length; j++) {
                objs[j] = switch (parameters[j].getParameterizedType().getTypeName()) {
                    case "int" -> 239;
                    case "java.lang.String" -> "string";
                    case "double" -> 0.34;
                    case "java.util.Collection<java.lang.Integer>" -> Arrays.asList(2, 3, 5, 7, 8);
                    case "java.util.List<java.lang.String>" -> Arrays.asList("string", "straight");
                    default -> null;
                };
            }

            for (int i = 0; i < (n != null ? n.value() : 0); i++) {
                method.invoke(tClass, objs);
            }
        }
        } catch (IllegalAccessException | InvocationTargetException ex) {
            ex.getCause();
            ex.printStackTrace();

        }
    }
}