package ApiObject;

import lombok.Data;

import java.util.List;

@Data
public class Author {
    private String key;
    private String text;
    private String type;
    private String name;
    private List<String> alternateNames;
    private String birthDate;
    private String topWork;
    private int workCount;
    private List<String> topSubjects;
    private long version;

    public String getKey() {
        return this.key.replace("/authors/", "");
    }
}
