package enums;

public enum Language {

    CS("cs", "Czech", "ell"),
    DE("de", "German", "deu"),
    EN("en", "English", "eng"),
    ES("es", "Spanish", "spa"),
    FR("fr", "French", "fra"),
    HR("hr", "Croatian", "hrv"),
    IT("it", "Italian", "ita"),
    PT("pt", "Portuguese", "por"),
    TE("te", "Telugu", "tel"),
    UK("uk", "Ukrainian", "ukr"),
    ZH("zh", "Chinese", "zho");

    String label, name, isoCode;

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getIsoCode() {
        return isoCode;
    }

    Language(String label, String name, String isoCode) {
        this.label = label;
        this.name = name;
        this.isoCode = isoCode;
    }


}
