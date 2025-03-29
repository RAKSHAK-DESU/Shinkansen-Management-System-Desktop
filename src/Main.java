import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        ArrayList<Trip> trips= new ArrayList<>();
        for (int i=0;i<4;i++){
            Trip t= new Trip();
            t.setArrivalTime("00:00");
            t.setDepartureTime("00:00");
            t.setDate("2025-10-02");
            t.setDestination("Destination");
            t.setStartStation("Start");
            Train tr=new Train();
            tr.setDescription("Train 1 VIP");
            t.setTrain(tr);
            t.setPrice(50);
            trips.add(t);

        }
        refreshTable(trips);

        JScrollPane sp= new JScrollPane(table);
        panel.add(sp,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.CENTER);


        frame.setVisible(true);
    }
    private static void refreshTable(ArrayList<Trip> trips){
        int rows= trips.size()+1;
        if(rows<6) rows=6;
        gridLayout.setRows(rows);
        table.add(row(0,null));
        for (int i=0;i<trips.size();i++){
            JPanel trip=row(i+1,trips.get(i));
            table.add(trip);
        }
    }

    private static JPanel row(int index,Trip trip){
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        if (index%2==0) row.setBackground(Color.decode("#e5e5e5"));
        else row.setBackground(Color.decode("#EEEEEE"));

        String trainS,startS,destS,dateS,deptS,arrS,priceS,statusS;

        if (trip!=null){
            trainS= trip.getTrain().getDescription();
            startS=trip.getStartStation();
            destS=trip.getDestination();
            dateS=trip.getDate();
            deptS=trip.getDepartureTime();
            arrS=trip.getArrivalTime();
            priceS= trip.getPrice()+"$";
            statusS="Booked";
            if(trip.getTrain().getCapacity()>trip.getbookedSeats()) statusS="Available";
        }else {
            trainS="Train";
            startS="Form";
            destS="To";
            dateS="Date";
            deptS="Dept";
            arrS="Arr";
            priceS="Price";
            statusS="Status";
        }

        JLabel train= JLabel(trainS,100);
        row.add(train);

        JLabel start = JLabel(startS,100);
        row.add(start);

        JLabel dest= JLabel(destS,100);
        row.add(dest);

        JLabel date = JLabel(dateS,150);
        row.add(date);

        JLabel deptTime = JLabel(deptS, 65);
        row.add(deptTime);

        JLabel arrTime= JLabel(arrS,65);
        row.add(arrTime);

        JLabel price = JLabel(priceS,50);
        row.add(price);



        JLabel status = JLabel(statusS,100);
        row.add(status);

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