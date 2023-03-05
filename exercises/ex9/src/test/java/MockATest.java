
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MockATest {

    private B bMock;

    @BeforeEach
    public void setUp() throws Exception {
        bMock = mock(B.class);
    }

    @Test
    public void testFunB1FunB2() {
        A a = new A(bMock);
        a.funA(5);
        InOrder inOrder = inOrder(bMock);
        inOrder.verify(bMock, times(1)).funB1();
        inOrder.verify(bMock, times(1)).funB2();
    }

    @Test
    public void testFunB1Multiple() {
        A a = new A(bMock);
        a.funA(15);
        InOrder inOrder = inOrder(bMock);
        inOrder.verify(bMock, atLeast(2)).funB1();
    }

    @Test
    public void testFunB1Never() {
        A a = new A(bMock);
        a.funA(-5);
        InOrder inOrder = inOrder(bMock);
        inOrder.verify(bMock, never()).funB1();
        inOrder.verify(bMock, never()).funB2();

    }
}
