import java.util.Collection;
import java.util.List;

public class TestClass {
    @MyAnnotation(value = 2)
    public void method1(String str) {
        System.out.println(str + " first");
    }

    @MyAnnotation(4)
    public void method2(Collection<Integer> l) {
        System.out.println(l.contains(2));
    }

    @MyAnnotation(5)
    protected void method3(String str) {
        System.out.println(str);
    }

    @MyAnnotation(value = 1)
    protected void method4(int a, double b) {
        System.out.println(a + b);
    }

    @MyAnnotation(value = 2)
    private void method5(String str, List<String> l) {
        System.out.println(l.contains(str));
    }

    @MyAnnotation(value = 3)
    private void method6(int y) {
        System.out.println(y);
    }
}
