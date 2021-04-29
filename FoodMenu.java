import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodMenu implements ActionListener {

    private static JFrame f1;
    private static JPanel p1;

    private static JLabel lhead,lname,lsname,lccno,linfo,lcusAdd,lchMl,lmsp,lorder,lcType;
    private static JTextField tname,tsname,tccno;
    private static  JTextArea tcDetails;
    private static JTable mealTable,orderTable;
    private static JScrollPane sp1,sp2;
    private static JSpinner msp,osp;
    private static JRadioButton yes,no;
    private static JButton addMeal,reset,remove,confirm;

    static DefaultTableModel model = new DefaultTableModel();
    static DefaultTableModel model1 = new DefaultTableModel();

    static double total= 0.0;

    public static void main(String[] args) {

        FoodMenu fm = new FoodMenu();

        //Components of the Frames are assigned here

        f1 = new JFrame();
        f1.setTitle("Food Menu");
        p1 = new JPanel();
        p1.setLayout(null);

        lhead = new JLabel("Food Menu");
        lhead.setFont(new Font("Serif", Font.BOLD, 35));
        lhead.setForeground(Color.red);
        lhead.setBounds(10,10,300,30);
        p1.add(lhead);

        lname = new JLabel("Customer Name");
        lname.setBounds(10,60,100,25);
        p1.add(lname);

        tname = new JTextField();
        tname.setBounds(150,60,200,25);
        p1.add(tname);

        lsname = new JLabel("Customer's Surname");
        lsname.setBounds(10,90,150,25);
        p1.add(lsname);

        tsname = new JTextField();
        tsname.setBounds(150,90,200,25);
        p1.add(tsname);

        lccno = new JLabel("Contact No");
        lccno.setBounds(10,120,100,25);
        p1.add(lccno);

        tccno = new JTextField();
        tccno.setBounds(150,120,200,25);
        p1.add(tccno);

        linfo = new JLabel("Do you order from us before ");
        linfo.setBounds(10,150,200,25);
        p1.add(linfo);

        yes = new JRadioButton("Yes");
        yes.setBounds(210,150,50,25);
        p1.add(yes);

        no = new JRadioButton("No");
        no.setBounds(270,150,50,25);
        p1.add(no);

        ButtonGroup G = new ButtonGroup();
        G.add(yes);
        G.add(no);

        lchMl = new JLabel("Choose Meals");
        lchMl.setFont(new Font("Serif", Font.BOLD, 24));
        lchMl.setForeground(Color.blue);
        lchMl.setBounds(10,200,200,40);
        p1.add(lchMl);

        mealTable = new JTable(model);
        model.addColumn("ITEM");
        model.addColumn("PRICE");
        mealTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        mealTable.getColumnModel().getColumn(1).setPreferredWidth(65);
        mealTable.setBounds(0, 0, 365, 200);

        model.addRow(new Object[]{"Nasi Gorang","600"});
        model.addRow(new Object[]{"Mongolian Rice","550"});
        model.addRow(new Object[]{"Chicken Fried Rice","550"});
        model.addRow(new Object[]{"Egg Fried Rice","500"});
        model.addRow(new Object[]{"Beef Fried Rice","500"});
        model.addRow(new Object[]{"Chicken Noodles","500"});
        model.addRow(new Object[]{"Rice with Curry","400"});
        model.addRow(new Object[]{"Fresh Juice","400"});
        model.addRow(new Object[]{"Milk Shake","400"});
        model.addRow(new Object[]{"Ice Cream","250"});
        model.addRow(new Object[]{"Soft Drinks","150"});


        sp1 = new JScrollPane(mealTable);
        sp1.setBounds(10, 250, 365, 200);
        p1.add(sp1);

        lmsp = new JLabel("Quantity");
        lmsp.setBounds(10,500,80,25);
        p1.add(lmsp);

        msp = new JSpinner();
        msp.setBounds(80,500,50,25);
        p1.add(msp);

        addMeal = new JButton("Add Meal");
        addMeal.setBounds(150,500,120,25);
        addMeal.setBackground(Color.green);
        addMeal.addActionListener(fm);
        p1.add(addMeal);

        lorder = new JLabel("Order Table");
        lorder.setFont(new Font("Serif", Font.BOLD, 24));
        lorder.setForeground(Color.blue);
        lorder.setBounds(420,5,200,40);
        p1.add(lorder);

        orderTable = new JTable(model1);
        model1.addColumn("ITEM");
        model1.addColumn("UNIT PRICE");
        model1.addColumn("QUANTITY");
        model1.addColumn("SUB TOTAL");
        orderTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        orderTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        orderTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        orderTable.getColumnModel().getColumn(3).setPreferredWidth(95);
        orderTable.setBounds(0, 0, 495, 100);

        sp2 = new JScrollPane(orderTable);
        sp2.setBounds(420, 45, 495, 260);
        p1.add(sp2);

        reset = new JButton("Reset");
        reset.addActionListener(fm);
        reset.setBackground(Color.red);
        reset.setBounds(420,320,120,25);
        p1.add(reset);

        remove = new JButton("Remove");
        remove.addActionListener(fm);
        remove.setBackground(Color.yellow);
        remove.setBounds(550,320,120,25);
        p1.add(remove);

        confirm = new JButton("Confirm Order");
        confirm.addActionListener(fm);
        confirm.setBackground(Color.GREEN);
        confirm.setBounds(680,320,120,25);
        p1.add(confirm);

        lcType = new JLabel();
        lcType.setFont(new Font("Serif", Font.BOLD, 20));
        lcType.setForeground(Color.magenta);
        lcType.setBounds(420,350,300,40);
        p1.add(lcType);

        tcDetails = new JTextArea();
        tcDetails.setBounds(420,390,490,150);
        p1.add(tcDetails);

        f1.add(p1);
        f1.setSize(940,600);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);

    }
    // All the button functions using the abstract method of ActionListener Interface
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addMeal){
            int row = mealTable.getSelectedRow();
            String item =(String) model.getValueAt(row,0);
            String uprice = (String) model.getValueAt(row,1);
            String quantity = String.valueOf(msp.getValue());
            float subtotal = (Integer.parseInt(quantity)*Float.parseFloat(uprice));
            total+=subtotal;
            model1.addRow(new Object[]{item,uprice,quantity,String.valueOf(subtotal)});
        }else if(e.getSource() == reset){
            total = 0.0;
            model1.setRowCount(0);
        }else if(e.getSource() == remove) {
            int row = orderTable.getSelectedRow();
            float subtotal = Float.parseFloat((String) model1.getValueAt(row, 3));
            model1.removeRow(row);
            total -= subtotal;
            System.out.println(total);
        }else if (e.getSource()==confirm){
            if((tname.getText()).equals("")&&tsname.getText().equals("")&&tccno.getText().equals("")) {
                tcDetails.setText("Alert!!!\nPlease enter your details");
                tcDetails.setFont(new Font("Serif", Font.BOLD, 20));
                tcDetails.setForeground(Color.red);
            }
            else {
            boolean oldCustomer = yes.isSelected();
            boolean newCustomer = no.isSelected();
            if(oldCustomer){
                lcType.setText("Thank you for choosing us again !!!");
            }else if(newCustomer){
                lcType.setText("Welcome New Customer !!!");
            }
            String customerName = tname.getText();
            char customerInitial =tsname.getText().toUpperCase().charAt(0);
            //Exception handling for getting only numbers as Contact Number
            try {
                long customerNo = Long.parseLong(tccno.getText());
                tcDetails.setText(" Customer Name: "+customerInitial+"."+customerName +"\n\n"+
                                  " Customer Contact No: "+customerNo+"\n\n"+
                                  " Total Amount :"+total);
            }catch(NumberFormatException numberFormatException){
                tcDetails.setText("Alert!!!\nPlease Re-enter your contact number with only numbers");
                tcDetails.setFont(new Font("Serif", Font.BOLD, 20));
                tcDetails.setForeground(Color.red);
            }

            }

        }
    }
}

