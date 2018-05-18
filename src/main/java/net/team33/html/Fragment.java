package net.team33.html;

public abstract class Fragment {

    static String escaped(final String content) {
        //noinspection DynamicRegexReplaceableByCompiledPattern
        return content
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    @Override
    public abstract String toString();
}
