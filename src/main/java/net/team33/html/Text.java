package net.team33.html;

public class Text extends Fragment {

    private final String content;

    public Text(final String content) {
        this.content = (null == content) ? "<null>" : content;
    }

    @Override
    public final String toString() {
        return escaped(content);
    }
}
