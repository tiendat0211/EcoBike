package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.ApiBike;
import api.ApiStation;
import api.ApiTrans;
import api.ApiUser;
import api.test.ApiStationTest;
import controller.EcoBikeController;
import controller.userpage.UserPageController;
import model.ATMCard;
import model.Bike;
import model.Station;
import model.Transaction;
import model.User;

import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

public class EcoBike extends JFrame {

	private JPanel contentPane;
	public JTextField UsernameField;
	public JTextField PasswordField;

	
	/**
	 * Create the frame.
	 */
	
	public EcoBike() {

		EcoBikeController controller = new EcoBikeController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(279, 44, 353, 57);
		contentPane.add(lblNewLabel);
		
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = getUser();
				controller.getUserPage(user);
			}
		}) ;
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(319, 347, 237, 68);
		
		
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Đăng ký");
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSignup.setBounds(319, 448, 237, 68);
		contentPane.add(btnSignup);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(118, 183, 152, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(118, 247, 152, 44);
		contentPane.add(lblNewLabel_2);
		
		UsernameField = new JTextField();
		UsernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsernameField.setBounds(297, 183, 429, 44);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		PasswordField = new JTextField();
		PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordField.setBounds(297, 247, 429, 44);
		contentPane.add(PasswordField);
		PasswordField.setColumns(10);
		
		this.setVisible(true);
	}

	
	public User getUser() {
		return new User(UsernameField.getText(),PasswordField.getText());
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new EcoBike();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
