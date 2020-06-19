package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.StringUtil;
import Util.dBUtil;
import dao.userDao;
import model.userModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginOnFrm extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5092677588137682374L;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private dBUtil dbutil=new dBUtil();
	private userDao userdao=new userDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginOnFrm frame = new LoginOnFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginOnFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/logo.png")));
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/userName.png")));
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/password.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/login.png")));
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetElementActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordTxt)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.UNRELATED, 60, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(228, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(184))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnNewButton)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * 登录事件
	 * @param e
	 */
private void loginActionPerformed(ActionEvent e) {
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword()); 
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空!");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}
		userModel user=new userModel(userName,password);
		Connection con=null;
		try {
			con=dbutil.getCon();
			userModel curruser=userdao.login(con, user);
			if(curruser!=null) {
				JOptionPane.showMessageDialog(null, "登陆成功!");
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误!");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

/**
 * 重置事件
 * @param e
 */
	private void resetElementActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
