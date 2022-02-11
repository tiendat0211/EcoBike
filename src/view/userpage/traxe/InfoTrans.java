package view.userpage.traxe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.userpage.traxe.InfoTransController;
import model.Bike;
import model.Transaction;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class InfoTrans extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public InfoTrans(Transaction trans, int idstation, String hours, int money) {
		
		InfoTransController controller = new InfoTransController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin giao dịch");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(122, 10, 260, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên người thuê:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 75, 149, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên xe:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 145, 136, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã số thẻ:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(44, 110, 136, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số tiền:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(44, 289, 149, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Loại xe");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(44, 180, 149, 25);
		contentPane.add(lblNewLabel_5);
		
		JButton btnPay = new JButton("Thanh toán");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.getPay(idstation, trans,hours,money);
			}
		});
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPay.setBounds(44, 337, 149, 44);
		contentPane.add(btnPay);
		
		JButton btnReturn = new JButton("Quay lại");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.getReturnBike(trans.getUsername());
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setBounds(367, 337, 149, 44);
		contentPane.add(btnReturn);
		
		JLabel lblUserName = new JLabel();
		lblUserName.setText(trans.getUsername());
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setBounds(203, 73, 313, 25);
		contentPane.add(lblUserName);
		
		JLabel lblCardNumber = new JLabel();
		lblCardNumber.setText(String.valueOf(trans.getCard()));
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCardNumber.setBounds(203, 110, 318, 25);
		contentPane.add(lblCardNumber);
		
		JLabel lblBikeName = new JLabel();
		lblBikeName.setText(trans.getBikeName());
		lblBikeName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBikeName.setBounds(203, 145, 313, 25);
		contentPane.add(lblBikeName);
		
		JLabel lblTypeBike = new JLabel();
		lblTypeBike.setText(trans.getType());
		lblTypeBike.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTypeBike.setBounds(203, 180, 313, 25);
		contentPane.add(lblTypeBike);
		
		JLabel lblMonney = new JLabel();
		lblMonney.setText(String.valueOf(money)+" VND");
		lblMonney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMonney.setBounds(203, 289, 313, 25);
		contentPane.add(lblMonney);
		
		JLabel lblNewLabel_6 = new JLabel("Bãi xe :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(44, 215, 136, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblStation = new JLabel();
		lblStation.setText("Bãi xe số " + String.valueOf(idstation));
		lblStation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStation.setBounds(203, 215, 313, 30);
		contentPane.add(lblStation);
		
		JLabel lblNewLabel_7 = new JLabel("Số giờ thuê : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(44, 254, 136, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblHours= new JLabel();
		lblHours.setText(hours);
		lblHours.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHours.setBounds(203, 255, 313, 24);
		contentPane.add(lblHours);
		
		this.setVisible(true);
	}
}
