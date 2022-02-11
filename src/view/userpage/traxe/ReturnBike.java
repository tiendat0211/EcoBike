package view.userpage.traxe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.userpage.traxe.ReturnBikeController;
import controller.userpage.xemthongtin.ViewSationController;
import model.Bike;
import model.Station;
import model.Transaction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBike extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Station> litstation = new ArrayList<Station>();
	private Transaction trans = new Transaction();
	JLabel lblHours =  new JLabel();
		
	/**
	 * Create the frame.
	 */
	public ReturnBike(String name) {
		
		ReturnBikeController controller = new ReturnBikeController(this);
		litstation = controller.getListSation();
		trans = controller.getTransactionByName(name);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(310, 10, 348, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin xe đang thuê");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(67, 111, 280, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên xe:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(77, 159, 94, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Loại xe:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(76, 194, 84, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số giờ thuê:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(77, 229, 110, 25);
		contentPane.add(lblNewLabel_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel
			(
				new Object[][] {
				},
				new String[] {
						 "STT", "Bãi xe", "Khu vực" , "Tổng số chỗ","Tổng số xe"
				}
			));
			displayData(litstation);
			
			table.setFont(new Font("Tahoma", Font.PLAIN,20 ));
			table.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(67, 310, 776, 208);
		contentPane.add(scrollPane);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("Danh sách bãi xe");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(67, 275, 210, 25);
		contentPane.add(lblNewLabel_5);
		
		JButton btnReButton = new JButton("Quay lại");
		btnReButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getUserPage(name);
			}
		}) ;
		btnReButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReButton.setBounds(690, 536, 150, 35);
		contentPane.add(btnReButton);
		
		JButton btnViewMoney = new JButton("Xem số dư");
		btnViewMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getUserMoney(name);
			}
		}) ;
		btnViewMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewMoney.setBounds(388, 536, 150, 35);
		contentPane.add(btnViewMoney);
		
		JButton btnReturnBike = new JButton("Trả xe");
		btnReturnBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					controller.showMessage("Bạn chưa chọn bãi xe");
				}else {
					if (trans.getBike()==null && trans.getEbike() == null) {
						controller.showMessage("Bạn chưa thuê xe");
					}else {
						int id = getIDStation();
						String hour = getHours();
						String cardnumber = JOptionPane.showInputDialog("Nhập mã số thẻ");
						controller.checkCardNumber(cardnumber,trans,id, hour);
					}
				}
			}
		});
		btnReturnBike.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnBike.setBounds(67, 536, 150, 35);
		contentPane.add(btnReturnBike);
		
		JLabel lblBikeName = new JLabel();
		if (trans.getBike()!=null) {
			lblBikeName.setText(trans.getBikeName());
		}else if (trans.getEbike() != null) {
			lblBikeName.setText(trans.getBikeName());
		} else {
			lblBikeName.setText("");
		}
			
		lblBikeName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBikeName.setBounds(162, 159, 185, 23);
		contentPane.add(lblBikeName);
		
		JLabel lblTypeBike = new JLabel();
		if (trans.getType()==null) {
			lblTypeBike.setText(" ");
		}else {
			lblTypeBike.setText(trans.getType());
		}
		lblTypeBike.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTypeBike.setBounds(165, 194, 182, 23);
		contentPane.add(lblTypeBike);
		
		if (trans.getBike()==null && trans.getEbike()== null) {
			lblHours.setText(" ");
		}else {
			lblHours.setText("1 giờ 10 phút");
		}
		lblHours.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHours.setBounds(197, 229, 227, 23);
		contentPane.add(lblHours);
		
		this.setVisible(true);
	}
	
	public int getIDStation() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int id = Integer.valueOf(model.getValueAt(row,0)+"");
		return id;
	}
	
	public void displayData(ArrayList<Station> litstation) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(Station s:litstation ) {
			if (s.getTotalDock()>s.getTotalBike()) {
				model.addRow(new Object[]{s.getIdStaion(),s.getNameStaion(),
						s.getAddres(),s.getTotalDock(),
						s.getTotalBike()});
			}
		}
	}
	
	public String getHours() {
		String hours = lblHours.getText();
		return hours;
	}
	
}
