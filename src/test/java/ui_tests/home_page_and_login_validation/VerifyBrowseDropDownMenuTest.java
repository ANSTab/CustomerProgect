package ui_tests.home_page_and_login_validation;

import enums.BrowseMenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static enums.BrowseMenuItem.values;

public class VerifyBrowseDropDownMenuTest extends PrepareTestDataForLogin {

    @Test
    public void verifyBrowseMenuItems() {
        List<String> expectedItemsList = Arrays.stream(values()).map(BrowseMenuItem::getName).collect(Collectors.toList());
        List<String> actualBrowseItems = homePage.getBrowseMenuItemsList();

        Assertions.assertEquals(actualBrowseItems, expectedItemsList,
                String.format("'%s' List should be equal '%s'", actualBrowseItems, expectedItemsList));
    }
}
