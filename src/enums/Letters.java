package enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Letters {
    a("a"),b("b"),c("c"),d("d"),e("e"),f("f"),g("g"),h("h"),i("i"),
    j("j"),k("k"),l("l"),m("m"),n("n"),o("o"),p("p"),q("q"),r("r"),
    s("s"),t("t"),u("u"),v("v"),w("w"),x("x"),y("y"),z("z");

    private static final List<String> VALUES;
    private final String value;

    static {
        VALUES = new ArrayList<>();
        for(Letters letter: Letters.values()) VALUES.add(letter.value);
    }

    private Letters(String value) {
        this.value = value;
    }

    public static List<String> getValues(){
        return Collections.unmodifiableList(VALUES);
    }
}
