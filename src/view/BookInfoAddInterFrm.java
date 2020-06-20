package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Util.StringUtil;
import Util.dBUtil;
import dao.bookInfoDao;
import model.BookInfo;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookInfoAddInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6525858389196765179L;
	private JTextField isbnText;
	private JTextField bookNameText;
	private JTextField bookTypeText;
	private JTextField authorText;
	private JTextArea bookDescText;
	
	private dBUtil dbutil=new dBUtil(); //引入数据库工具类
	private bookInfoDao infodao=new bookInfoDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfoAddInterFrm frame = new BookInfoAddInterFrm();
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
	public BookInfoAddInterFrm() {
		setTitle("\u56FE\u4E66\u4FE1\u606F\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 735, 500);
		
		JLabel label = new JLabel("\u65B0\u56FE\u4E66\u540D");
		label.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/bookName.png")));
		
		JLabel label_1 = new JLabel("\u7248\u53F7");
		label_1.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/isbn.png")));
		
		JLabel label_2 = new JLabel("\u4F5C\u8005");
		label_2.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/author.png")));
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		label_4.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/Desc.png")));
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
		label_3.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/bookType.png")));
		
		isbnText = new JTextField();
		isbnText.setColumns(10);
		
		bookNameText = new JTextField();
		bookNameText.setColumns(10);
		
		bookTypeText = new JTextField();
		bookTypeText.setColumns(10);
		
		authorText = new JTextField();
		authorText.setColumns(10);
		
		bookDescText = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookInfoAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_3)
										.addComponent(label_2)
										.addComponent(label_4))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(authorText, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(bookNameText)
										.addComponent(isbnText, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(btnNewButton)
							.addGap(170)
							.addComponent(button)))
					.addContainerGap(714, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	
	
	/**
	 * 添加事件处理
	 */

	protected void bookInfoAddActionPerformed(ActionEvent e) {
		String isbn=this.isbnText.getText();
		String bookName=this.bookNameText.getText();
		String bookType=this.bookTypeText.getText();
		String author=this.authorText.getText();
		String Desc=this.bookDescText.getText();
		
		if(StringUtil.isEmpty(author)|| StringUtil.isEmpty(isbn)||StringUtil.isEmpty(bookName)|| StringUtil.isEmpty(bookType)) {
			JOptionPane.showMessageDialog(null, "图书信息不能为空!");
			return;
		}
		BookInfo info=new BookInfo(isbn, bookName, bookType, author, Desc);
		Connection con=null;
		
		try {
			con=dbutil.getCon();
			int n=infodao.add(con, info);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "新的图书信息已录入!");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书信息添加失败!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "图书信息添加失败!");
		}finally {
			dbutil.closeDbCon(con);
		}
		
	}

	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
	this.resetValue();
		
	}

	/**
	 * 重置功能
	 */
	private void resetValue() {
		this.bookNameText.setText("");
		this.bookTypeText.setText("");
		this.bookDescText.setText("");
		this.authorText.setText("");
		this.isbnText.setText("");
	}
}
