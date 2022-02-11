package view.userpage.xemthongtin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.EcoBikeController;
import controller.userpage.xemthongtin.ViewSationController;
import model.Station;

public class ViewStation extends JFrame {

	private JPanel contentPane;
	private JTextField StaionName;
	private JTextField StaionAdd;
	private JTable table;
	
	private ArrayList<Station> listsation = new ArrayList<Station>();
	private ArrayList<Station> listsearch = new ArrayList<Station>();

	/**
	 * Create the frame.
	 */
	public ViewStation(String name) {
		
		ViewSationController controller = new ViewSationController(this);
		listsation = controller.getListSation();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(317, 10, 343, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bãi xe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(49, 113, 67, 30);
		contentPane.add(lblNewLabel_1);
		
		StaionName = new JTextField();
		StaionName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StaionName.setBounds(136, 113, 228, 30);
		contentPane.add(StaionName);
		StaionName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Khu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(49, 168, 67, 30);
		contentPane.add(lblNewLabel_2);
		
		StaionAdd = new JTextField();
		StaionAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StaionAdd.setBounds(136, 168, 228, 30);
		contentPane.add(StaionAdd);
		StaionAdd.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namestation = getNameStation();
				String addsation = getAddStation();
				listsearch = controller.searchSation(namestation,addsation);
				updateData(listsearch);
			}
		});
		
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(401, 156, 146, 42);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_3 = new JLabel("Danh sách bãi xe");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(49, 248, 176, 30);
		contentPane.add(lblNewLabel_3);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "STT", "Bãi xe", "Khu vực" , "Tổng số chỗ","Tổng số xe"
			}
		));
		
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(int i=0 ;i<listsation.size();i++) {
				model.addRow(new Object[]{listsation.get(i).getIdStaion(),listsation.get(i).getNameStaion(),
						listsation.get(i).getAddres(),listsation.get(i).getTotalDock(),
						listsation.get(i).getTotalBike()});
			}
		table.setFont(new Font("Tahoma", Font.PLAIN,20 ));
		table.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 298, 848, 216);
		contentPane.add(scrollPane);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnXem = new JButton("Xem");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn bãi xe");
				}else {
					int id = getIdStation();
					controller.getViewBikeList(name, id);
				}
			}
		}) ;
		btnXem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXem.setBounds(49, 540, 122, 33);
		contentPane.add(btnXem);
		
		JButton btnReturn = new JButton("Quay lại");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getUserPage(name);
			}
		}) ;
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setBounds(776, 540, 122, 33);
		contentPane.add(btnReturn);
		
		JButton btnReset = new JButton("Tạo mới");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}

		}) ;
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(581, 157, 146, 41);
		contentPane.add(btnReset);
		
		this.setVisible(true);
	}
	
	public int getIdStation() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int id = Integer.valueOf(model.getValueAt(row,0)+"");
		return id;
	}
	
	public String getNameStation() {
		return StaionName.getText();
		
	}
	
	public String getAddStation() {
		return StaionAdd.getText();
	}
	
	
	public void updateData(ArrayList<Station> listsearch) {
		DefaultTableModel model = (DefaultTableModel) table.getModel() ;
		int countRow = model.getRowCount();
		System.out.println(countRow);
		for (int i=countRow-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(int i=0 ;i<listsearch.size();i++) {
			model.addRow(new Object[]{listsearch.get(i).getIdStaion(),listsearch.get(i).getNameStaion(),
					listsearch.get(i).getAddres(),listsearch.get(i).getTotalDock(),
					listsearch.get(i).getTotalBike()});
		}

	}
	public void reset() {
		DefaultTableModel model = (DefaultTableModel) table.getModel() ;
		int countRow = model.getRowCount();
		System.out.println(countRow);
		for (int i=countRow-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(int i=0 ;i<listsation.size();i++) {
			model.addRow(new Object[]{listsation.get(i).getIdStaion(),listsation.get(i).getNameStaion(),
					listsation.get(i).getAddres(),listsation.get(i).getTotalDock(),
					listsation.get(i).getTotalBike()});
		}
	}
}
