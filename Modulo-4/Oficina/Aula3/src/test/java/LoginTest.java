import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginTest {
    @Test
    public void instanciaTest() throws Exception{
        CreateLoginForm c = new CreateLoginForm();
        assertNotEquals(null,c);
    }

    @Test
    public void loginTest() throws Exception {
        CreateLoginForm form = new CreateLoginForm();
        assertNotEquals(null,form.loginText);
    }

    @Test
    public void senhaTest() throws Exception {
        CreateLoginForm form = new CreateLoginForm();
        assertNotEquals(null,form.senhaText);
    }

}
