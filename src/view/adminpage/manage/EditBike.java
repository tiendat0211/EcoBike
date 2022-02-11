package view.adminpage.manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.adminpage.managebike.EditController;
import model.Bike;
import model.EBike;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditBike extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField BikeName;
	private JTextField Type;
	private JTextField Brand;
	private JTextField Discription;
	private JTextField Status;
	private JTextField Pin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditBike frame = new EditBike();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param bikename 
	 */
	public EditBike(Bike b) {
		
		EditController controller = new EditController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBieRentl");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(207, 27, 196, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông số chi tiết");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(234, 75, 133, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(28, 145, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(28, 176, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Loại xe");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(28, 213, 68, 17);
		contentPane.add(lblNewLabel_4);
		
		ID = new JTextField();
		ID.setText(String.valueOf(b.getIdbike()));
		ID.setBounds(120, 144, 130, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		BikeName = new JTextField();
		BikeName.setText(b.getBikename());
		BikeName.setBounds(120, 175, 130, 20);
		contentPane.add(BikeName);
		BikeName.setColumns(10);
		
		Type = new JTextField();
		Type.setText(b.getType());
		Type.setBounds(120, 213, 130, 20);
		contentPane.add(Type);
		Type.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mô tả");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(282, 145, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Hãng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(282, 181, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pin");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(282, 214, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		
		Brand = new JTextField();
		Brand.setText(b.getBrand());
		Brand.setBounds(348, 175, 130, 20);
		contentPane.add(Brand);
		Brand.setColumns(10);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bike bike = getBike(b);
				//System.out.println(b);
				controller.updateBike(bike,Type.getText());
			}
		});
		btnNewButton.setBounds(81, 296, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 =new JButton("Quay lại");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getManageBike();
			}
		});
		btnNewButton_1.setBounds(345, 296, 133, 23);
		contentPane.add(btnNewButton_1);
		
		Discription = new JTextField();
		Discription.setText(b.getDescription());
		Discription.setBounds(348, 144, 130, 20);
		contentPane.add(Discription);
		Discription.setColumns(10);
		
		Status = new JTextField();
		Status.setText(b.getStatus());
		Status.setBounds(120, 244, 130, 20);
		contentPane.add(Status);
		Status.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Trạng thái");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(28, 243, 82, 14);
		contentPane.add(lblNewLabel_8);
		
		Pin = new JTextField();
		if (b.getType().equals("Bike")) {
			Pin.setText("Không có");
		}else {
			EBike ebike = (EBike)b;
			Pin.setText(String.valueOf(ebike.getPin()));
		}
		Pin.setBounds(348, 213, 130, 20);
		contentPane.add(Pin);
		Pin.setColumns(10);
		
		setVisible(true);
	}
	
	public Bike getBike(Bike bike1) {
		if (Type.getText().equals("Bike")) {
			 Bike bike = new Bike( bike1.getIdbike(),BikeName.getText(),Brand.getText(),Status.getText(),Discription.getText());
			 return bike;
		}else {
			 EBike ebike = new EBike(bike1.getIdbike() ,BikeName.getText(),Brand.getText(),Status.getText(),Discription.getText(), 100);
			 return ebike;
		}
	}

}
