package view.adminpage.manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.adminpage.AdminPageController;
import controller.adminpage.managebike.ManageController;
import controller.userpage.xemthongtin.ViewBikeListController;
import model.Bike;
import model.EBike;
import model.Station;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManageBike extends JFrame {

	private JPanel contentPane;
	private JTextField BikeName;
	private JTextField BikeType;
	private JTextField StaionName;
	private JTextField StaionAdd;
	private JTable table;
	
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();
	
	private ArrayList<Bike> listsearch = new ArrayList<Bike>();
	/**
	 * Create the frame.
	 */
	public ManageBike() {
		int stt = 1;
		
		ManageController controller = new ManageController(this);
		
		listb = controller.getlistbike();
		liste = controller.getlistebike();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setBounds(317, 44, 347, 72);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.RED);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên xe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 140, 69, 23);
		contentPane.add(lblNewLabel_1);
		
		BikeName = new JTextField();
		BikeName.setBounds(90, 140, 86, 20);
		contentPane.add(BikeName);
		BikeName.setColumns(10);

		JButton btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bikename = getBikeName();
				String biketype = getBikeType();
				listsearch = controller.searchBike(bikename,biketype);
				updateData(listsearch);
			
			}


	}) ;
		btnSearch.setBounds(196, 175, 117, 23);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(23, 219, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EAn", "Lo\u1EA1i xe", "M\u00F4 t\u1EA3"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0 ;i<listb.size();i++) {
				stt++;
			model.addRow(new Object[]{
					listb.get(i).getIdbike(),
					listb.get(i).getBikename(),
					"Bike",
					listb.get(i).getDescription()});
		}
		for(int i=0 ;i<liste.size();i++) {
				stt++;
			model.addRow(new Object[]{
					liste.get(i).getIdbike(),
					liste.get(i).getBikename(),
					"EBike",
					liste.get(i).getDescription()});
		}
		
			table.setFont(new Font("Tahoma", Font.PLAIN,20 ));
			table.setRowHeight(30);
		
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(33, 244, 644, 216);
			contentPane.add(scrollPane);
			
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
			JButton btnNewButton_1 = new JButton("Thêm");
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAddBike();
			}
		});
			btnNewButton_1.setBounds(712, 261, 117, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Xem");
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String bikename = getname();
				controller.getShowBike(bikename);
				}
			});
			btnNewButton_2.setBounds(712, 313, 117, 23);
			contentPane.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Sửa");
			btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String bikename = getname();
					controller.getEditBike(bikename);
				}
			});
			btnNewButton_3.setBounds(712, 368, 117, 23);
			contentPane.add(btnNewButton_3);
			
			JButton btnNewButton_4 = new JButton("Xóa");
			btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.getDeleteBike();
				}
			});
			btnNewButton_4.setBounds(712, 418, 117, 23);
			contentPane.add(btnNewButton_4);
			
			JButton btnNewButton_5 = new JButton("Quay lại");
			btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				controller.getAdminPage(); 
				}
			});
			btnNewButton_5.setBounds(33, 485, 117, 23);
			contentPane.add(btnNewButton_5);
			
			JLabel lblNewLabel_3 = new JLabel("Loại xe");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_3.setBounds(23, 174, 69, 29);
			contentPane.add(lblNewLabel_3);
			
			BikeType = new JTextField();
			BikeType.setBounds(90, 176, 86, 20);
			contentPane.add(BikeType);
			BikeType.setColumns(10);
			
			
	
			this.setVisible(true);
		}
	public String getBikeName() {
		return BikeName.getText();
	}
	
	public String getBikeType() {
		return BikeType.getText();
	}
	
	public void updateData(ArrayList<Bike> listsearch2) {
		int stt = 1;
		DefaultTableModel model = (DefaultTableModel) table.getModel() ;
		int countRow = model.getRowCount();
		System.out.println(countRow);
		for (int i=countRow-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(int i=0 ;i<listsearch2.size();i++) {
				model.addRow(new Object[]{
				stt++,
				listsearch2.get(i).getBikename(),
				listsearch2.get(i).getType(),
				listsearch2.get(i).getDescription()});
			}
	}
	
	public String getname() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String name = model.getValueAt(row,1)+"";
		return name;
	}
	
	
}