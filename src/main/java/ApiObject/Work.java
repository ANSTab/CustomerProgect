package ApiObject;

import lombok.Data;

import java.util.List;

@Data
public class Work {
    private String key;
    private String title;
    private int editionCount;
    private String coverEditionKey;
    private List<String> subjects;
    private List<String> iaCollection;
    private boolean lendingLibrary;
    private boolean printDisabled;
    private String lendingEdition;
    private String lendingIdentifier;
    private List<String> authors;
    private int firstPublishYear;
    private String ia;
    private boolean publicScan;
    private boolean hasFullText;
}
