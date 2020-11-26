package mven.com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import mven.com.dao.Dao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class first_ui extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first_ui frame = new first_ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public first_ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(189, 23, 211, 38);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(189, 87, 211, 44);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(29, 28, 95, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(29, 95, 95, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton b1 = new JButton("New button");
		b1.setBounds(83, 184, 168, 38);
		contentPane.add(b1);
		
		String [] com= {"Id","name","last name "};
		 DefaultTableModel dt1=new DefaultTableModel(com,0);
		table = new JTable(dt1);
		JScrollPane jp=new JScrollPane(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int data =(int)dt1.getValueAt(table.getSelectedRow(), 0);
				
				deletes(data,dt1);
				
			}
		});
		
		jp.setBounds(510, 28, 274, 334);
		contentPane.add(jp);
		try {
			ser(dt1 );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println(t1.getText()+ t2.getText());
				Tclear(dt1);
				int i=insert(t1.getText(), t2.getText());
				
				try {
					ser(dt1 );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	}
	
	
	
	private int insert(String a, String b)
	{ 
		 int i=0;
		
		// System.out.println(a+b);
		try (Connection con=Dao.getconnection();){
			
			PreparedStatement ps= con.prepareStatement("insert into user values(?,?,?) ");
			
			ps.setString(1,a);
			ps.setString(2,b);
			ps.setInt(3,i);
			i= ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
			
		return i;
	}
	
	private void ser(DefaultTableModel dt )throws SQLException  {
		
		
		ResultSet a=serch();
		while(a.next())
		{
			dt.addRow(new Object[] {a.getInt(3),a.getString(1),a.getString(2)});
		}
		
		
	}
	
private ResultSet serch()  {
		
		Connection con= Dao.getconnection();
			PreparedStatement ps;
			ResultSet rs=null;
			try {
				ps = con.prepareStatement(" select * from user ");
				rs= ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
	}

private void Tclear(DefaultTableModel dt) {
for(int i=dt.getRowCount()-1;i>=0;i--)
{
	dt.removeRow(i);
}
	
}


private void delete(int data) {
	
	//DELETE FROM table_name WHERE condition;
try (Connection con= Dao.getconnection();){
				
		PreparedStatement ps= con.prepareStatement("delete from user where id=?");
		ps.setInt(1,data);
		ps.executeUpdate();
					
	} catch (Exception e) {
		// TODO: handle exception
	}
}


private void deletes(int data,DefaultTableModel dt) {
	
		
	
	delete(data );
	dt.removeRow(table.getSelectedRow());
	
				
	

}
}

