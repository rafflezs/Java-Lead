import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

class CreateLoginForm extends JFrame implements ActionListener
{
    JButton loginBotao;
    JPanel newPanel;
    JLabel loginLabel, senhaLabel;
    final JTextField  loginText, senhaText;

    CreateLoginForm()
    {

        loginLabel = new JLabel();
        loginLabel.setText("Login");

        loginText = new JTextField(15);

        senhaLabel = new JLabel();
        senhaLabel.setText("Senha");

        senhaText = new JPasswordField(15);

        loginBotao = new JButton("Login");

        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(loginLabel);
        newPanel.add(loginText);
        newPanel.add(senhaLabel);
        newPanel.add(senhaText);
        newPanel.add(loginBotao);

        add(newPanel, BorderLayout.CENTER);

        loginBotao.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String userValue = loginText.getText();
        String passValue = senhaText.getText();

        if (userValue != null && passValue != null ) {

            NewPage page = new NewPage();
            page.setVisible(true);
            JLabel wel_label = new JLabel("Login com sucesso: "+userValue);
            page.getContentPane().add(wel_label);
        }
        else{
            System.out.println("Credenciais Inválidas");
        }
    }
}
class LoginForm
{
    public static void main(String arg[])
    {
        try
        {
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(300,100);
            form.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}  