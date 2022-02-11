package view.userpage.xemthongtin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.userpage.xemthongtin.ViewBikeListController;
import model.Bike;
import model.EBike;
import model.Station;

public class ViewBikeList extends JFrame {

	private JPanel contentPane;
	private JTextField BikeName;
	private JTextField BikeType;
	private JTable table;

	
	private ArrayList<Bike> listsearch = new ArrayList<Bike>();
	private ArrayList<Bike> listbike = new ArrayList<Bike>();
	private ArrayList<EBike> listeBike = new ArrayList<EBike>();
	
	public ViewBikeList(String name, int id) {
		int stt = 1;
		Station station  = new Station();
		ViewBikeListController controller = new ViewBikeListController(this);
		station = controller.getSationByID(id);
		listbike = station.getListbike();
		listeBike = station.getListebike();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh Sach Xe Bai "+ String.valueOf(id));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(177, 10, 451, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên xe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(65, 120, 96, 34);
		contentPane.add(lblNewLabel_1);
		
		BikeName = new JTextField();
		BikeName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BikeName.setBounds(171, 120, 221, 31);
		contentPane.add(BikeName);
		BikeName.setColumns(10);
		
		BikeType = new JTextField();
		BikeType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BikeType.setBounds(171, 161, 221, 29);
		contentPane.add(BikeType);
		BikeType.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Loại xe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(65, 156, 96, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bikename = getBikeName();
				String biketype = getBikeType();
				listsearch = controller.searchBike(bikename,biketype,id);
				updateData(listsearch);
			}

		}) ;
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(421, 156, 139, 34);
		contentPane.add(btnSearch);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Ten xe", "Loai xe", "Trang Thai"
			}
			
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0 ;i<listbike.size();i++) {
			model.addRow(new Object[]{
					stt++,
					listbike.get(i).getBikename(),
					"Bike",
					listbike.get(i).getStatus()});
		}
		for(int i=0 ;i<listeBike.size();i++) {
			model.addRow(new Object[]{
					stt++,
					listeBike.get(i).getBikename(),
					"EBike",
					listeBike.get(i).getStatus()});
		}
		table.setFont(new Font("Tahoma", Font.PLAIN,20 ));
		table.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 267, 848, 246);
		contentPane.add(scrollPane);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnReturn = new JButton("Quay lại");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getViewStation(name);
			}
		}) ;
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setBounds(736, 546, 122, 33);
		contentPane.add(btnReturn);
		
		JLabel lblNewLabel_3 = new JLabel("Danh sách xe");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(361, 225, 146, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnViewBike = new JButton("Xem");
		btnViewBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn xe");
				}else {
					String name1 = getname();
					String type = getype();
					controller.getViewBike(name1,type,id,name);
				}
				
			}
		}) ;
		btnViewBike.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewBike.setBounds(41, 546, 119, 33);
		contentPane.add(btnViewBike);
		
		JButton btnReset = new JButton("Tạo mới");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		}) ;
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(592, 156, 146, 34);
		contentPane.add(btnReset);
		this.setVisible(true);
		
	}
	
	public String getname() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String name = model.getValueAt(row,1)+"";
		return name;
	}
	public String getype() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String type = model.getValueAt(row,2)+"";
		return type;
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
				listsearch2.get(i).getStatus()});
			}
	}
	
	public void reset() {
		int stt = 1;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int countRow = model.getRowCount();
		System.out.println(countRow);
		for (int i=countRow-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(int i=0 ;i<listbike.size();i++) {
			model.addRow(new Object[]{
					stt++,
					listbike.get(i).getBikename(),
					"Bike",
					listbike.get(i).getStatus()});
		}
		for(int i=0 ;i<listeBike.size();i++) {
			model.addRow(new Object[]{
					stt++,
					listeBike.get(i).getBikename(),
					"EBike",
					listeBike.get(i).getStatus()});
		}
	}
}
