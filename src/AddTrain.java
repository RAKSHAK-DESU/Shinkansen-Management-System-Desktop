import javax.swing.*;
import java.awt.*;
import  javax.swing.JButton;

public class AddTrain {
    public AddTrain(JFrame oldFrame){
        JFrame frame= new JFrame("Add Train");
        frame.setSize(750,400);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(oldFrame);
        frame.getContentPane().setBackground(Color.decode("#EBFFD8"));

        JPanel panel= new JPanel(new GridLayout(5,2,20,20));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        panel.add(JLabel("ID:"));

        JTextField id= JTextField();
        panel.add(id);

        panel.add(JLabel("Capacity"));

        JTextField capacity = JTextField();
        panel.add(capacity);

        panel.add(JLabel("Driver"));

        String[] drivers= {"Driver 1","Driver 2", "Driver 3", "Driver 4"};
        JComboBox<String> driver = new JComboBox<>(drivers);
        driver.setBackground(Color.white);
        panel.add(driver);

        panel.add(JLabel("Description:"));
        JTextField description = JTextField();
        panel.add(description);

        JButton cancel = JButton("Cancle");
        panel.add(cancel);

        JButton submit = JButton("Submit");
        panel.add(submit);

        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.setVisible(true);

    }

    private JLabel JLabel(String text){
        JLabel label = new JLabel(text);
        label.setForeground(Color.decode("#012030"));
        label.setFont(new Font(null,Font.BOLD,20));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        return label;

    }

    private JTextField JTextField(){
        JTextField textField= new JTextField();
        textField.setForeground(Color.decode("#012030"));
        textField.setFont(new Font(null,Font.BOLD,20));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        return textField;
    }

    private JButton JButton(String text){
        JButton btn= new JButton(text);
        btn.setBackground(Color.decode("#54C4B0"));
        btn.setForeground(Color.white);
        btn.setFont(new Font(null , Font.BOLD,22));
        return btn;

    }
}
