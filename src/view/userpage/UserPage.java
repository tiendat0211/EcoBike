package view.userpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EcoBikeController;
import controller.userpage.UserPageController;
import model.Station;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame{
	
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public UserPage(String name) {
		UserPageController controller = new UserPageController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(317, 62, 347, 72);
		contentPane.add(lblNewLabel);
		
		JButton btnViewStaion = new JButton("Xem thông tin");
		btnViewStaion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnViewStaion.setBounds(351, 196, 267, 60);
		btnViewStaion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getViewStaion(name);
			}
		});
		contentPane.add(btnViewStaion);
		
		JButton btnRentlBike = new JButton("Thuê xe");
		btnRentlBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getRentBike(name);
			}
		});
		btnRentlBike.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRentlBike.setBounds(351, 296, 267, 60);
		contentPane.add(btnRentlBike);
		
		JButton btnReturnBike = new JButton("Trả xe");
		btnReturnBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getReturnBike(name);
			}
		});
		btnReturnBike.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturnBike.setBounds(351, 394, 267, 60);
		contentPane.add(btnReturnBike);
		
		JButton btnLogout = new JButton("Đăng xuất");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getEcoBike();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogout.setBounds(351, 489, 267, 60);
		contentPane.add(btnLogout);
		
		this.setVisible(true);
	}


}
