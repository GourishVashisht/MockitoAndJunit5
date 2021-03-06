package com.nagarro.employeemanaement;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

class A {
    public void a(final List<Integer> list) {
        list.add(1);
        list.add(2);
        System.out.println("=>" + list.toString() + "=>" + list.size());
        list.isEmpty();
    }
}

public class DemoHunitTest {

    // @Test
    public void practise() {
        final A a = new A();
        final List<Integer> list = mock(List.class);
        a.a(list);
        verify(list, times(2)).add(anyInt());
        verify(list).size();
        verifyNoMoreInteractions(list);
    }

}
