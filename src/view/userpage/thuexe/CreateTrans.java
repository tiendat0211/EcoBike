package view.userpage.thuexe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.userpage.thuexe.CreateTransController;
import model.User;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CreateTrans extends JFrame {

	private JPanel contentPane;
	private User user = new User();
	/**
	 * Create the frame.
	 */
	public CreateTrans(String name, String bikename, int idstation, String type) {
		
		CreateTransController controller = new CreateTransController(this);
		user = controller.getUserbyName(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tạo giao dịch");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(253, 10, 361, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên người thuê :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(77, 115, 249, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel();
		lblUsername.setText(name);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUsername.setBounds(343, 115, 482, 41);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_3 = new JLabel("Mã số thẻ : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(77, 166, 249, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblCardNum = new JLabel();
		lblCardNum.setText(String.valueOf(user.getCardmumber()) );
		lblCardNum.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCardNum.setBounds(343, 166, 482, 41);
		contentPane.add(lblCardNum);
		
		JLabel lblNewLabel_5 = new JLabel("Tên xe : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(77, 217, 249, 37);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblBikeName = new JLabel();
		lblBikeName.setText(bikename);
		lblBikeName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBikeName.setBounds(343, 217, 482, 37);
		contentPane.add(lblBikeName);
		
		JLabel lblNewLabel_7 = new JLabel("Loại xe : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(77, 264, 249, 44);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblType = new JLabel();
		lblType.setText(type);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblType.setBounds(343, 266, 482, 41);
		contentPane.add(lblType);
		
		JLabel lblNewLabel_9 = new JLabel("Bãi xe : ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_9.setBounds(77, 318, 249, 39);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblStation = new JLabel("New label");
		lblStation.setText("Bãi xe " + String.valueOf(idstation));
		lblStation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblStation.setBounds(343, 317, 482, 41);
		contentPane.add(lblStation);
		
		JLabel lblNewLabel_11= new JLabel("Số tiền đặt cọc : ");
		
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_11.setBounds(77, 367, 249, 37);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblTiencoc = new JLabel();
		if (type.equals("Bike")) {
			lblTiencoc.setText("400000 VND");
		}else if (type.equals("EBike")) {
			lblTiencoc.setText("700000 VND");
		}
		lblTiencoc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTiencoc.setBounds(343, 368, 482, 36);
		contentPane.add(lblTiencoc);
		
		JButton btnAccpet = new JButton("Xác nhận");
		btnAccpet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.creatran(user,type,bikename,idstation);
			}
		}) ;
		btnAccpet.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAccpet.setBounds(77, 443, 158, 39);
		contentPane.add(btnAccpet);
		
		JButton btnReturn = new JButton("Quay lại");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getRentBike(name);
			}
		}) ;
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnReturn.setBounds(674, 443, 151, 39);
		contentPane.add(btnReturn);
		
		this.setVisible(true);
	}

}
