package com.tracersoft.util.reflection;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.Set;

/**
 * (c) Alex Tracer, 2009
 *
 * @author Alex Tracer
 */
public class ReflectionUtilsTest extends TestCase {

    static class A<K, L> {
        // String, Integer
    }

    static class B<P, Q, R extends Collection> extends A<Q, P> {
        // Integer, String, Set
    }

    static class C<X extends Comparable<String>, Y, Z> extends B<Z, X, Set<Long>> {
        // String, Double, Integer
    }

    static class D<M, N extends Comparable<Double>> extends C<String, N, M> implements H<N, M> {
        // Integer, Double
    }

    static class E extends D<Integer, Double> {
        //
    }

    static class F<T, S> extends E {
        // Byte, Long
    }

    static class G extends F<Byte, Long> {
        //
    }

    static interface H<H1, H2> extends L<H2> {
        // Double, Integer
    }

    static interface L<L1> {
        // Integer
    }

    @Override
    protected void setUp() throws Exception {
        x = new G();
        super.setUp();
    }

    private Object x;

    public void testGetTypeClassA0() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), A.class, 1);
        assertNotSame(result, String.class);
    }

    public void testGetTypeClassA1() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), A.class, 0);
        assertEquals(result, String.class);
    }

    public void testGetTypeClassA2() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), A.class, 1);
        assertEquals(result, Integer.class);
    }

    public void testGetTypeClassB0() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), B.class, 0);
        assertEquals(result, Integer.class);
    }

    public void testGetTypeClassB1() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), B.class, 1);
        assertEquals(result, String.class);
    }

    public void testGetTypeClassB2() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), B.class, 2);
        assertEquals(result, Set.class);
    }

    public void testGetTypeClassF0() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), F.class, 0);
        assertEquals(result, Byte.class);
    }

    public void testGetTypeClassF1() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), F.class, 1);
        assertEquals(result, Long.class);
    }

    public void testGetTypeClassFromInterface() throws Exception {
        Class result = ReflectionUtils.getGenericParameterClass(x.getClass(), L.class, 0);
        assertEquals(result, Integer.class);
    }


    public void testGetTypeClassSelf() throws Exception {
        try {
            ReflectionUtils.getGenericParameterClass(A.class, A.class, 0);
            fail();
        } catch (IllegalArgumentException e) {
            // Do nothing
        }
    }
}
