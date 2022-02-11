package view.userpage.xemthongtin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.userpage.xemthongtin.ViewBikeController;
import model.Bike;
import model.EBike;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class ViewBike extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewBike(String namebike, String type, int idsation, String name) {
		EBike ebike = new EBike();
		Bike bike = new Bike();
		ViewBikeController controller = new ViewBikeController(this);
		if (type.equals("Bike")) {
			bike = controller.getBikebyName(namebike); 
		}else if (type.equals("EBike")) {
			ebike = controller.getEBikebyName(namebike);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin xe");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(278, 10, 337, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên xe :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(132, 96, 131, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Loại xe :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(132, 160, 131, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hãng :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(132, 291, 131, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Trạng thái : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(132, 358, 168, 46);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mô tả : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(132, 431, 168, 46);
		contentPane.add(lblNewLabel_5);
		
		JButton btnReturn = new JButton("Quay lại");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getViewBikeList(name,idsation);
			}
		}) ;
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturn.setBounds(354, 515, 168, 46);
		contentPane.add(btnReturn);
		
		JLabel lblBikeName = new JLabel();
		if (type.equals("Bike")) {
			lblBikeName.setText(bike.getBikename());
		}else if (type.equals("EBike")) {
			lblBikeName.setText(ebike.getBikename());
		}
		lblBikeName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikeName.setBounds(326, 95, 477, 39);
		contentPane.add(lblBikeName);
		
		JLabel lblBikeType = new JLabel();
		if (type.equals("Bike")) {
			lblBikeType.setText("Bike");
		}else if (type.equals("EBike")) {
			lblBikeType.setText("EBike");
		}
		lblBikeType.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikeType.setBounds(326, 160, 477, 37);
		contentPane.add(lblBikeType);
		
		JLabel lblBikeBrand = new JLabel();
		if (type.equals("Bike")) {
			lblBikeBrand.setText(bike.getBrand());
		}else if (type.equals("EBike")) {
			lblBikeBrand.setText(ebike.getBrand());
		}
		lblBikeBrand.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikeBrand.setBounds(326, 291, 479, 37);
		contentPane.add(lblBikeBrand);
		
		JLabel lblBikeStatus = new JLabel();
		if (type.equals("Bike")) {
			lblBikeStatus.setText(bike.getStatus());
		}else if (type.equals("EBike")) {
			lblBikeStatus.setText(ebike.getStatus());
		}
		lblBikeStatus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikeStatus.setBounds(326, 358, 479, 37);
		contentPane.add(lblBikeStatus);
		
		JLabel lblBikeDes = new JLabel();
		if (type.equals("Bike")) {
			lblBikeDes.setText(bike.getDescription());
		}else if (type.equals("EBike")) {
			lblBikeDes.setText(ebike.getDescription());
		}
		lblBikeDes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikeDes.setBounds(326, 431, 477, 46);
		contentPane.add(lblBikeDes);
		
		JLabel lblNewLabel_11 = new JLabel("Pin : ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_11.setBounds(132, 230, 113, 37);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblBikePin = new JLabel();
		if (type.equals("Bike")) {
			lblBikePin.setText("Không có");
		}else if (type.equals("EBike")) {
			lblBikePin.setText(String.valueOf(ebike.getPin())+"%");
		}
		lblBikePin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikePin.setBounds(326, 230, 477, 37);
		contentPane.add(lblBikePin);
		
		this.setVisible(true);
	}
}
