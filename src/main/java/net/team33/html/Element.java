package net.team33.html;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

public class Element<E extends Element<E>> extends Fragment {

    private final String symbol;
    private final Map<String, String> attributes = new TreeMap<>();
    private final Collection<Fragment> fragments = new LinkedList<>();

    public Element(final String symbol) {
        this.symbol = symbol;
    }

    public final E add(final String text) {
        return add(new Text(text));
    }

    public final E add(final Fragment element) {
        fragments.add(Objects.requireNonNull(element));
        return self();
    }

    public final E set(final String name, final String value) {
        attributes.put(name, value);
        return self();
    }


    public final E setId(final String value) {
        return set("id", value);
    }

    public final E setClass(final String value) {
        return set("class", value);
    }

    public final E setAccesskey(final String value) {
        return set("accesskey", value);
    }

    public final E setContentEditable(final String value) {
        return set("contenteditable", value);
    }

    public final E hidden(final String value) {
        return set("hidden", value);
    }

    public final E spellcheck(final String value) {
        return set("spellcheck", value);
    }


    public final E classAttribute(final String value) {
        return set("class", value);
    }

    public final E align(final String align) {
        return set("align", align);
    }

    public final E border(final int border) {
        return set("border", String.valueOf(border));
    }

    @SuppressWarnings("unchecked")
    private E self() {
        return (E) this;
    }

    @Override
    public final String toString() {
        final StringBuilder result = new StringBuilder("<")
                .append(symbol);
        buildAttributes(result)
                .append(">");
        return buildContent(result)
                .append("</")
                .append(symbol)
                .append(">")
                .toString();
    }

    private StringBuilder buildContent(final StringBuilder result) {
        //noinspection Convert2streamapi
        for (final Fragment fragment : fragments) {
            result.append(fragment);
        }
        return result;
    }

    private StringBuilder buildAttributes(final StringBuilder result) {
        for (final Entry<String, String> entry : attributes.entrySet()) {
            result.append(" ")
                    .append(entry.getKey())
                    .append("=\"")
                    .append(escaped(entry.getValue()))
                    .append("\"");
        }
        return result;
    }
}
