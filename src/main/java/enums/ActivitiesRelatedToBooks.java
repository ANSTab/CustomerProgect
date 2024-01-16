package enums;

public enum ActivitiesRelatedToBooks {

    MY_LOANS("My Loans"),
    CURRENTLY_READING("Currently Reading"),
    WANT_TO_READ("Want to Read"),
    ALREADY_READ("Already Read");

    final String name;

    public String getName() {
        return name;
    }

    ActivitiesRelatedToBooks(String name) {
        this.name = name;
    }

}
