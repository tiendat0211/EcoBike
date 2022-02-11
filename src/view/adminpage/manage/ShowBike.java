package view.adminpage.manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.adminpage.managebike.ShowController;
import model.Bike;
import model.EBike;

public class ShowBike extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField BikeName;
	private JTextField Type;
	private JTextField Brand;
	private JTextField Pin;
	private JTextField Status;
	private JTextField Discriotion;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowBike frame = new ShowBike();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @return 
	 */
public ShowBike(Bike bikename2) {
		ShowController controller = new ShowController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(201, 25, 230, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông số chi tiết");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(235, 90, 156, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(34, 152, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(34, 192, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Loại");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(34, 229, 46, 27);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				controller.getManageBike();
//				Bike bike = getBike(bikename2);
//				System.out.println(b);
//				controller.updateBike(bike,Type.getText());
				Bike bike = getBike(bikename2);
				//System.out.println(b);
				controller.updateBike(bike,Type.getText());
				controller.getManageBike();
				
			}
			
		});
		btnNewButton.setBounds(54, 314, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quay lại");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getManageBike();
			}
		});
		btnNewButton_1.setBounds(392, 314, 142, 23);
		contentPane.add(btnNewButton_1);
		
		ID = new JTextField();
		ID.setText(String.valueOf(bikename2.getIdbike()));
		ID.setBounds(130, 149, 86, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		BikeName = new JTextField();
		BikeName.setText(bikename2.getBikename());
		BikeName.setBounds(130, 189, 86, 20);
		contentPane.add(BikeName);
		BikeName.setColumns(10);
		
		Type = new JTextField();
			Type.setText(bikename2.getType());
		
		Type.setBounds(130, 234, 86, 20);
		contentPane.add(Type);
		Type.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pin");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(332, 192, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Hãng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(332, 148, 59, 23);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mô tả");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(332, 237, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		Brand = new JTextField();
		Brand.setText(bikename2.getBrand());
		Brand.setBounds(425, 149, 86, 20);
		contentPane.add(Brand);
		Brand.setColumns(10);
		
	
		
		Discriotion = new JTextField();
		Discriotion.setText(bikename2.getDescription());
		Discriotion.setBounds(425, 234, 86, 20);
		contentPane.add(Discriotion);
		Discriotion.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getManageBike();
			}
		});
		btnNewButton_2.setBounds(232, 314, 123, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("Trạng thái");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(34, 269, 86, 23);
		contentPane.add(lblNewLabel_8);
		
		Status = new JTextField();
		Status.setText(bikename2.getStatus());
		Status.setBounds(130, 272, 86, 20);
		contentPane.add(Status);
		Status.setColumns(10);
		
		Pin = new JTextField();
		if (bikename2.getType().equals("Bike")) {
			Pin.setText("Không có");
		}else {
			EBike ebike = (EBike)bikename2;
			Pin.setText(String.valueOf(ebike.getPin()));
		}
		Pin.setBounds(425, 189, 86, 20);
		contentPane.add(Pin);
		Pin.setColumns(10);
		
		this.setVisible(true);
	}
public Bike getBike(Bike bike1) {
	if (Type.getText().equals("Bike")) {
		 Bike bike = new Bike( bike1.getIdbike(),BikeName.getText(),Brand.getText(),Status.getText(),bike1.getDescription());
		 return bike;
	}else {
		 EBike ebike = new EBike(bike1.getIdbike() ,BikeName.getText(),Brand.getText(),Status.getText(),bike1.getDescription(), 100);
		 return ebike;
	}
}
}