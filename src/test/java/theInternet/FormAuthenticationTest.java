package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.FormAuthenticationPage;

public class FormAuthenticationTest {
    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
    void shouldBeSuccessfullyWithValidCredentials() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(formAuthenticationPage.isLoggedIn());
    }

    @Test
    void loginUnsuccessfulWhenEnteringWrongUsername() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("a", "SuperSecretPassword!");

        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(formAuthenticationPage.isNotLoggedInWhenWrongUsername());
    }

    @Test
    void loginUnsuccessfulWhenEnteringWrongPassword() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "a");

        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(formAuthenticationPage.isNotLoggedInWhenWrongPassword());
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
