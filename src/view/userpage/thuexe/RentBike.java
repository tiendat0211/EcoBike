package view.userpage.thuexe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.userpage.thuexe.RentBikeController;
import model.Bike;
import model.EBike;
import model.Station;

public class RentBike extends JFrame {

	private JPanel contentPane;
	private JTextField BikeName;
	private JTable table;
	private ArrayList<Bike> list = new ArrayList<Bike>();
	private ArrayList<Station> lists = new ArrayList<Station>();
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();

	/**
	 * Create the frame.
	 */
	public RentBike(String name) {
		int stt = 1;
		RentBikeController controller = new RentBikeController(this);
		lists = controller.getListStation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(291, 10, 351, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn xe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(83, 116, 87, 30);
		contentPane.add(lblNewLabel_1);
		
		BikeName = new JTextField();
		BikeName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BikeName.setBounds(180, 116, 337, 30);
		contentPane.add(BikeName);
		BikeName.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bikename = getTextSearch();
				list = controller.searchBike(bikename);
				updateData(list);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(569, 116, 134, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Danh s\u00E1ch xe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(383, 187, 134, 25);
		contentPane.add(lblNewLabel_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên xe", "Bãi xe", "Loại xe", "Trạng thái"
			}
		));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(Station sation:lists) {
			listb = sation.getListbike();
			for (Bike bike:listb) {
				model.addRow(new Object[]{
						stt++,
						bike.getBikename(),
						"Bãi xe " + sation.getIdStaion(),
						"Bike",
						bike.getStatus()});
			}
			liste = sation.getListebike();
			for (Bike ebike:liste) {
				model.addRow(new Object[]{
						stt++,
						ebike.getBikename(),
						"Bãi xe " + sation.getIdStaion(),
						"EBike",
						ebike.getStatus()});
			}
		}
		table.setFont(new Font("Tahoma", Font.PLAIN,20 ));
		table.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 222, 832, 214);
		contentPane.add(scrollPane);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRentBike = new JButton("Thuê xe");
		btnRentBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(contentPane,"Hãy ch�?n xe trước");
				}else {
					String bikename = getBikeName();
					int idstation = getIdStation();
					String type = getBikeType();
					String cardnumber = JOptionPane.showInputDialog("Nhập mã số thẻ");
					controller.checkCarNumber(cardnumber,name,bikename,type,idstation);
				}
			}
		}) ;
		btnRentBike.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRentBike.setBounds(38, 462, 132, 30);
		contentPane.add(btnRentBike);
		
		JButton btnReturn = new JButton("Quay lại");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getUserPage(name);
			}
		}) ;
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setBounds(748, 462, 122, 30);
		contentPane.add(btnReturn);
		
		JButton btnReset = new JButton("Tạo mới");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		}) ;
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(722, 116, 148, 30);
		contentPane.add(btnReset);
		
		this.setVisible(true);
	}
	
	public String getBikeName() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String name = model.getValueAt(row,1)+"";
		return name;
	}
	
	public int getIdStation() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String name = model.getValueAt(row,2)+"";
		int id = Integer.valueOf(name.charAt(name.length() - 1)) - 48;
		return id;
	}
	
	public String getBikeType() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String name = model.getValueAt(row,3)+"";
		return name;
	}
	public String getTextSearch() {
		return BikeName.getText();
	}
	
	public void updateData(ArrayList<Bike> list) {
		int stt = 1;
		DefaultTableModel model = (DefaultTableModel) table.getModel() ;
		int countRow = model.getRowCount();
		System.out.println(countRow);
		for (int i=countRow-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(int i=0 ;i<list.size();i++) {
			for(Station s: lists) {
				for (Bike b : s.getListbike()) {
					if (b.getBikename().equals(list.get(i).getBikename())) {
						model.addRow(new Object[]{
								stt++,
								list.get(i).getBikename(),
								list.get(i).getType(),
								"Bãi xe " + s.getIdStaion(),
								list.get(i).getStatus()});
					}
				}
				for (EBike e : s.getListebike()) {
					if (e.getBikename().equals(list.get(i).getBikename())) {
						model.addRow(new Object[]{
								stt++,
								list.get(i).getBikename(),
								list.get(i).getType(),
								"Bãi xe " + s.getIdStaion(),
								list.get(i).getStatus()});
					}
				}
			}
		}
	}
	public void reset() {
		int stt = 1;
		DefaultTableModel model = (DefaultTableModel) table.getModel() ;
		int countRow = model.getRowCount();
		System.out.println(countRow);
		for (int i=countRow-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(Station sation:lists) {
			listb = sation.getListbike();
			for (Bike bike:listb) {
				model.addRow(new Object[]{
						stt++,
						bike.getBikename(),
						"Bãi xe " + sation.getIdStaion(),
						"Bike",
						bike.getStatus()});
			}
			liste = sation.getListebike();
			for (Bike ebike:liste) {
				model.addRow(new Object[]{
						stt++,
						ebike.getBikename(),
						"Bãi xe " + sation.getIdStaion(),
						"EBike",
						ebike.getStatus()});
			}
		}
	}
}
