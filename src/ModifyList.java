import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ModifyList {
    public ModifyList(JFrame oldFrame, Database database){
        JFrame frame= new JFrame("新幹線管理システム");
        frame.setSize(400,600);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(oldFrame);
        frame.getContentPane().setBackground(Color.decode("#EBFFD8"));

        JPanel panel= new JPanel(new GridLayout(8,18,10,10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));


        JButton addTrain= Jbutton("列車を追加");
        addTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTrain(oldFrame, database);
            }
        });
        panel.add(addTrain);
        JButton editTrain= Jbutton("列車を編集");
        panel.add(editTrain);
        JButton addEmployee =Jbutton("従業員を追加");
        panel.add(addEmployee);
        JButton editEmployee= Jbutton("従業員を編集");
        panel.add(editEmployee);

        JButton addPassenger = Jbutton("乗客を追加");
        panel.add(addPassenger);

        JButton editPassenger = Jbutton("乗客を編集");
        panel.add(editPassenger);

        JButton addTrip= Jbutton("旅行を追加");
        panel.add(addTrip);

        JButton editTrip= Jbutton("旅行を編集");
        panel.add(editTrip);


        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.setVisible(true);

    }

    private JButton Jbutton(String text){
        JButton btn= new JButton(text);
        btn.setBackground(Color.decode("#45C4B0"));
        btn.setForeground(Color.white);
        btn.setFont(new Font(null,Font.BOLD,22));
        return btn;
    }
}
