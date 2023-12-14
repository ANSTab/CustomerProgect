package ApiObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class Book {
    private Description description;
    @JsonProperty("last_modified")
    private LastModified lastModified;
    private String title;
    private Created created;
    private List<Integer> covers;
    @JsonProperty("subject_places")
    private List<String> subjectPlaces;
    private List<String> subjects;
    @JsonProperty("subject_people")
    private List<String> subjectPeople;
    private String key;
    private List<AuthorRole> authors;
    @JsonProperty("latest_revision")
    private int latestRevision;
    @JsonProperty("subject_times")
    private List<String> subjectTimes;
    private Type type;
    private int revision;

    public String getKey() {
        return this.key.replace("/works/", "");
    }
}

@Data
class Description {
    private String type;
    private String value;
}

@Data
class LastModified {
    private String type;
    private String value;
}

@Data
class Created {
    private String type;
    private String value;
}

@Data
class AuthorRole {
    private Type type;
    private Author author;
}

@Data
class Type {
    private String key;
}
