package enums;

public enum BrowseMenuItem {
    SUBJECTS("Subjects"),
    TRENDING("Trending"),
    LIBRARY_EXPLORER("Library Explorer"),
    LISTS("Lists"),
    COLLECTIONS("Collections"),
    K_12_STUDENT_LIBRARY("K-12 Student Library"),
    BOOK_TALKS("Book Talks"),
    RANDOM_BOOK("Random Book"),
    ADVANCED_SEARCH("Advanced Search");

    final String name;

    public String getName() {
        return name;
    }

    BrowseMenuItem(String name) {
        this.name = name;
    }

}
