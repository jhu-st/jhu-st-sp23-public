public class A {
    B b;

    public A(B b) {
        this.b = b;
    }

    public void funA(int a) {
        if (0 <= a && a <= 10) {
            b.funB1();
            b.funB2();
        }
        else if (a > 10) {
            b.funB1();
            b.funB1();
            b.funB1();
        }
    }
}
