import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static JFrame frame;
    private static JPanel table;
    private static GridLayout gridLayout;
    public static void main(String[] args) {
        frame = new JFrame("新幹線管理システム");
        frame.setLocationRelativeTo(null);
        frame.setSize(1050,650);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.decode("#B3FFFF"));
        JPanel panel = new JPanel(new BorderLayout(20,20));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,30,50));

        JLabel title = new JLabel("新幹線管理システムへようこそ");
        title.setForeground(Color.decode("#012010"));
        title.setFont(new Font(null,Font.BOLD,35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title,BorderLayout.NORTH);

        gridLayout= new GridLayout(6,1);
        table = new JPanel(gridLayout);
        table.setBackground(Color.decode("#EBFFD8"));

        frame.setVisible(true);
    }

    private static JPanel row(int index,Trip trip){
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        if (index%2==0) row.setBackground(Color.decode("#e5e5e5"));
        else row.setBackground(Color.decode("#EEEEEE"));
        JLabel train= JLabel(trip.getTrain().getDescription(),100);
        row.add(train);

        JLabel start = JLabel(trip.getStartStation(),100);
        row.add(start);

        JLabel dest= JLabel(trip.getDestination(),100);
        row.add(dest);

        JLabel date = JLabel(trip.getDate(),150);
        row.add(date);

        JLabel deptTime = JLabel(trip.getDepartureTime(), 65);
        row.add(deptTime);

        JLabel arrTime= JLabel(trip.getArrivalTime(),65);
        row.add(arrTime);

        JLabel price = JLabel(trip.getPrice()+"$",50);
        row.add(price);

        String st="Booked";
        if(trip.getTrain().getCapacity()>trip.getbookedSeats()) st="Available";

        JLabel status = JLabel(st,100);
        return row;
    }
    private static JLabel JLabel(String text,int width){
        JLabel label= new JLabel(text);
        label.setPreferredSize(new Dimension(width,20));
        label.setFont(new Font(null,Font.PLAIN,20));
        label.setForeground(Color.decode("#13678A"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;

    }
}