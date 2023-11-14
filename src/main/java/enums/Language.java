package enums;

public enum Language {

    CS("cs", "Czech"),
    DE("de", "German"),
    EN("en", "English"),
    ES("es", "Spanish"),
    FR("fr", "French"),
    HR("hr", "Croatian"),
    IT("it", "Italian"),
    PT("pt", "Portuguese"),
    TE("te", "Telugu"),
    UK("uk", "Ukrainian"),
    ZH("zh", "Chinese");

    String label, name;

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    Language(String label, String name) {
        this.label = label;
        this.name = name;
    }


}
