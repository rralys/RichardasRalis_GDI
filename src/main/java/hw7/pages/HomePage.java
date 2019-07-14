package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import hw7.entities.Users;
import hw7.forms.LoginForm;

public class HomePage extends WebPage {

    private LoginForm loginForm;

    @XPath("//img[@id='user-icon']")
    private Button userIcon;

    @XPath("//span[@id='user-name']")
    private Label userName;

    @XPath("//ul[contains(@class,'uui-navigation')]//a[@href='metals-colors.html']")
    private Button metalsAndColors;

    public void loginUser(Users user) {
        userIcon.click();
        loginForm.loginUser(user);
    }

    public Label getUserName() {
        return userName;
    }

    public void openMetalsAndColorsPage() {
        metalsAndColors.click();
    }
}
