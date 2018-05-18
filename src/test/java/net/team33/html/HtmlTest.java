package net.team33.html;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTest {

    @Test
    public final void document() {
        assertEquals("<html></html>", Html.document().toString());
    }
}