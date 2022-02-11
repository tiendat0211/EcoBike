package view.adminpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.adminpage.AdminPageController;
import controller.userpage.UserPageController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AdminPage(String name) {
		
		AdminPageController controller = new AdminPageController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel lblNewLabel = new JLabel("EcoBikeRentl");
		lblNewLabel.setBounds(317, 44, 347, 72);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.RED);
		contentPane.add(lblNewLabel);
		
		JButton btnManageUser = new JButton("Quản lý Người dùng");
		btnManageUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Vui lòng thử lại sau");
				}
			
	});
		btnManageUser.setBounds(317, 152, 364, 45);
		btnManageUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btnManageUser);
		
		JButton btnManageBike = new JButton("Quản lý thông tin xe");
		btnManageBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.manageBike();
			}
		});
		btnManageBike.setBounds(317, 223, 364, 45);
		btnManageBike.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btnManageBike);
		
		JButton btnManageStation = new JButton("Quản lý bãi xe");
		btnManageStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Vui lòng thử lại sau");
			}
		});
		btnManageStation.setBounds(317, 297, 364, 55);
		btnManageStation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btnManageStation);
		
		JButton btnSignOut = new JButton("Đăng xuất");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getEcoBike();
			}
		});
		btnSignOut.setBounds(687, 443, 200, 45);
		btnSignOut.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btnSignOut);
		
		JButton btnManageService = new JButton("Quản lý dịch vụ");
		btnManageService.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnManageService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Vui lòng thử lại sau");
			}
		});
		btnManageService.setBounds(317, 379, 364, 45);
		contentPane.add(btnManageService);
		
		this.setVisible(true);
	}
		
	}

