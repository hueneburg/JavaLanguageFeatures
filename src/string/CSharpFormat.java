package string;

import feature_exception.ArgumentNullException;
import feature_exception.FormatException;

/**
 * Created by armin on 30.07.15.
 */
public final class CSharpFormat {
    public static String format(String format, Object... args) throws ArgumentNullException, FormatException {
        State state = State.Normal;
        if (format == null) {
            throw new ArgumentNullException("format");
        } else if (args == null) {
            throw new ArgumentNullException("args");
        }
        StringBuilder index = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        char c;
        for (int i = 0; i < format.length(); i++) {
            c = format.charAt(i);
            switch (c) {
                case '{':
                    if (state == State.Start) {
                        builder.append('{');
                        state = State.Normal;
                    } else if (state == State.Open) {
                        throw new FormatException("Unexpected character '{' at " + index);
                    } else if (state == State.Normal){
                        state = State.Start;
                    } else if (state == State.Closed) {
                        throw new FormatException("Unexpected character '{' at " + index);
                    }
                    break;

                case '}':
                    if (state == State.Closed) {
                        builder.append('}');
                        state = State.Normal;
                    } else if (state == State.Open) {
                        state = State.Normal;
                        int ind = Integer.parseInt(index.toString());
                        index.setLength(0);
                        if (ind < 0 || ind >= args.length) {
                            throw new FormatException("index out of bounds");
                        }
                        builder.append(args[ind]);
                    } else if (state == State.Normal) {
                        state = State.Closed;
                    } else if (state == State.Start) {
                        throw new FormatException("Unexpected character '}' at " + index);
                    }
                    break;

                default:
                    if (state == State.Normal) {
                        builder.append(c);
                    } else if (state == State.Open || state == State.Start) {
                        state = State.Open;
                        if ('0' <= c && c <= '9') {
                            index.append(c);
                        } else {
                            throw new FormatException("Unexpected character '" + c + "'. Number expected at " + index);
                        }
                    } else if (state == State.Closed) {
                        throw new FormatException("Unexpected character '" + c + "' at " + index);
                    }
                    break;
            }
        }
        return builder.toString();
    }

    private enum State {
        Normal, Open, Closed, Start
    }
}
