package net.team33.html;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("ClassNamingConvention")
public class ElementTest {

    @Test
    public final void testAddString() {
        Assert.assertEquals("<E1>any string</E1>", new E1().add("any string").toString());
    }

    @Test
    public final void testAddFragment() {
        Assert.assertEquals("<E1><E1>any string</E1></E1>", new E1().add(new E1().add("any string")).toString());
    }

    @Test
    public final void testSet() {
        Assert.assertEquals("<E1 any=\"string\"></E1>", new E1().set("any", "string").toString());
    }

    @Test
    public final void testId() {
        Assert.assertEquals("<E1 id=\"any-id\"></E1>", new E1().setId("any-id").toString());
    }

    @Test
    public final void testClass() {
        Assert.assertEquals("<E1 class=\"any-class\"></E1>", new E1().setClass("any-class").toString());
    }

    @Test
    public final void testAccesskey() {
        Assert.assertEquals("<E1 accesskey=\"any-key\"></E1>", new E1().setAccesskey("any-key").toString());
    }

    private static class E1 extends Element<E1> {
        private E1() {
            super("E1");
        }
    }
}