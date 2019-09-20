import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class abc extends Frame implements ActionListener
{
    Frame f;
    Label L1,L2,L3,L4,L5,L6;
    TextField t1,t2,t3,t4,t5,t6;
    Button b1,b2,b3,b4;
    Connection c;
    Statement s;
    ResultSet r;
    abc()
        {
           try
	{
	f=new Frame("Energy Billing System");
	f.setLayout(null);
	f.setVisible(true);
	f.setSize(900,600);

	L1=new Label("SrNo") ;
	L1.setBounds(50,100,100,50);
                   f.setLayout(null);
                   f.setVisible(true);
	f.add(L1);

	L2=new Label("Name");
	L2.setBounds(50,150,100,40);      
	f.add(L2);
                  
                  L3=new Label("Address");
	L3.setBounds(50,200,100,40);      
	f.add(L3);

                  L4=new Label("PhoneNo");
	L4.setBounds(50,250,100,40);      
	f.add(L4);

                  L5=new Label("MeterReading");
	L5.setBounds(50,300,100,40);      
	f.add(L5);
                  
                  L6=new Label("MeterNo");
	L6.setBounds(50,350,100,40);      
	f.add(L6);

	t1=new TextField();
	t1.setBounds(150,100,200,40);
	f.add(t1); 

	t2=new TextField();
	t2.setBounds(150,150,200,40);
	f.add(t2);

	t3=new TextField();
	t3.setBounds(150,200,200,40);
	f.add(t3);

	t4=new TextField();
	t4.setBounds(150,250,200,40);
	f.add(t4);

	t5=new TextField();
	t5.setBounds(150,300,200,40);
	f.add(t5);

	t6=new TextField();
	t6.setBounds(150,350,200,40);
	f.add(t6);

	b1=new Button("Submit");
	b1.setBounds(200,500,75,50);
	f.add(b1);
	b1.addActionListener(this);

                  b2=new Button("UPDATE");
	b2.setBounds(300,500,75,50);
	f.add(b2);
 	b2.addActionListener(this);

                  b3=new Button("DELETE");
	b3.setBounds(400,500,75,50);
	f.add(b3);
                  b3.addActionListener(this);

                  b4=new Button("EXIT");
	b4.setBounds(500,500,75,50);
	f.add(b4);
                  b4.addActionListener(this);
               
                   Class.forName ( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
                   System.out.println("Driver Loaded");
                   String url="jdbc:odbc:insertdata";
                   Connection con = DriverManager.getConnection (url) ;
                   Statement stmt = con.createStatement ( ) ;
                   System.out.println("Connection Created");
                   String sql="select*from data";
                   PreparedStatement ps=con.prepareStatement(sql);
                   ResultSet rs=ps.executeQuery();
	}
          catch(Exception e)
             {
                System.out.println(e);
             }
         }
public void actionPerformed(ActionEvent ae)
    {
       try
           {
             if(ae.getSource()==b1)
             {
              Class.forName ( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
              String url="jdbc:odbc:insertdata";
              Connection con = DriverManager.getConnection (url) ;
              Statement stmt = con.createStatement ( ) ;
              String s1=" INSERT INTO data(SrNo,Name,Address,PhoneNo,MeterReading,MeterNo)VALUES(" +t1.getText()+",' " +t2.getText() +" ',' " +t3.getText() +" ',' " +t4.getText() +" ',' " +t5.getText() +" ',' " +t6.getText() +" ')";
              System.out.println(s1);
              System.out.println("Value inserted Successfull");
              int me= stmt.executeUpdate(s1);
             }
            else if(ae.getSource()==b2)
            {
              Class.forName ( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
              String url="jdbc:odbc:insertdata";
              Connection con = DriverManager.getConnection (url) ;
              Statement stmt = con.createStatement ( ) ;
              String s2="UPDATE data SET NAME=(Account_ID,Name,Address,PhoneNo,MeterReading,MeterNo)VALUES(" +t1.getText()+",' " +t2.getText() +" ',' " +t3.getText() +" ',' " +t4.getText() +" ',' " +t5.getText() +" ',' " +t6.getText() +" ',)";
              System.out.println(s2);
              s.executeUpdate(s2);
              r=s.executeQuery("SELECT*FROM data");
              t1.setText("");
              t2.setText("");
              t3.setText("");
              t4.setText("");
              t5.setText("");
              t6.setText("");
            }
           else if(ae.getSource()==b3)
            {
             Class.forName ( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
             String url="jdbc:odbc:insertdata";
             Connection con = DriverManager.getConnection (url) ;
             Statement stmt = con.createStatement ( ) ;
             int ID = Integer.parseInt(t2.getText());
             PreparedStatement ps=con.prepareStatement("");
             ps.executeUpdate();
             System.out.println();
           
             r=s.executeQuery("SELECT*FROM data");
              t1.setText("");
              t2.setText("");
            }
           else if(ae.getSource()==b4)
            {
             c.close();
             f.dispose();
            }
        }
       catch(Exception e)
          {
            System.out.println(e);
          }
      }
public static void main(String args[])
     {
      new abc();
     }
}