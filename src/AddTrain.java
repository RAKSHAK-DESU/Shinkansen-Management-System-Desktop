import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import  javax.swing.JButton;

public class AddTrain {
    private Database database;

    public AddTrain(JFrame oldFrame, Database database){
        this.database= database;
        JFrame frame= new JFrame("Add Train");
        frame.setSize(750,400);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(oldFrame);
        frame.getContentPane().setBackground(Color.decode("#EBFFD8"));

        JPanel panel= new JPanel(new GridLayout(5,2,20,20));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        panel.add(JLabel("ID:"));

        JLabel id= JLabel("0");
        panel.add(id);

        panel.add(JLabel("Capacity"));

        JTextField capacity = JTextField();
        panel.add(capacity);

        panel.add(JLabel("Driver"));

        String[] drivers= {"Driver 1","Driver 2", "Driver 3", "Driver 4"};
        JComboBox<String> driver = new JComboBox<>(drivers);
        driver.setBackground(Color.white);
        driver.setFont(new Font(null,Font.BOLD,20));
        panel.add(driver);

        panel.add(JLabel("Description:"));
        JTextField description = JTextField();
        panel.add(description);

        JButton cancel = JButton("Cancle");
        panel.add(cancel);

        JButton submit = JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Train t = new Train();
                t.setId(Integer.parseInt(id.getText()));
                t.setCapacity(Integer.parseInt(capacity.getText()));
                t.setDescription(description.getText());
                try {
                    saveData(t);
                    JOptionPane.showMessageDialog(frame,"Train Added Successfully");
                    frame.dispose();
                } catch (SQLException e1){
                    JOptionPane.showMessageDialog(frame,"Operation Failed");
                }

            }
        });
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
    private void saveData(Train t){
        String insert= "INSERT INTO `trains`(`ID`, `Capacity`, `Description`) VALUES " +
                "('"+t.getID()+"','"+t.getCapacity()+"','"+t.getDescription()+"')";
        database.getStatement().execute(insert);
    }
}
