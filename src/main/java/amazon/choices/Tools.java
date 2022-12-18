package amazon.choices;

import java.util.HashMap;
import java.util.Map;

public enum Tools {
    SELENIUM("Selenium");

    public final String label;

    Tools(String label) {
        this.label = label;
    }

    private static final Map<String, Tools> BY_LABEL = new HashMap<>();

    static {
        for (Tools appEnv : values()) {
            BY_LABEL.put(appEnv.label, appEnv);
        }
    }

    // To get enum name from a label (choice specified in application.conf)
    public static Tools parse(String label) {
        if (BY_LABEL.get(label) == null) {
            throw new IllegalStateException(String.format("%s is not a valid tool choice. Pick your tool from %s." +
                    "Check the value of 'Tool' property in amazon.choices.conf; Or in CI, if running from continuous integration.",
                    label, BY_LABEL.keySet()));
        } else {
            return BY_LABEL.get(label);
        }
    }
}
