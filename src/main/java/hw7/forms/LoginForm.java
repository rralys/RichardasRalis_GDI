package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import hw7.entities.Users;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<Users> {

    @FindBy(id = "name")
    private TextField login;

    @FindBy(id = "password")
    private TextField password;

    @FindBy(xpath = "//button[@type='submit']")
    private Button submitLogin;

    public void loginUser(Users user) {
        login.input(user.getLogin());
        password.input(user.getPassword());
        submitLogin.click();
    }
}
