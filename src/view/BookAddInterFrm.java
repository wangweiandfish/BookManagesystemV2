package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Util.StringUtil;
import Util.dBUtil;
import dao.BookDao;
import dao.bookInfoDao;
import model.Book;
import model.BookInfo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameText;
	private JTextField isbnText;
	private JTextField priceText;
private dBUtil dbutil=new dBUtil();
private bookInfoDao bookinfodao=new bookInfoDao();
private BookDao  bookdao=new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u5165\u5E93");
		setBounds(100, 100, 594, 306);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0");
		label.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/bookName.png")));
		
		bookNameText = new JTextField();
		bookNameText.setEditable(false);
		bookNameText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u7248\u53F7");
		label_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/isbn.png")));
		
		isbnText = new JTextField();
		isbnText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C");
		label_2.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/rmb.png")));
		
		priceText = new JTextField();
		priceText.setColumns(10);
		
		JButton button = new JButton("\u5165\u5E93");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue();
			}
		});
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findBookName();
			}
		});
		button_2.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/search.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(button)
							.addComponent(label)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(label_1)
									.addGap(37)
									.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_2))
								.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(button_1)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 添加事件处理
	 * @param e
	 */
	private void bookAddActionPerformed(ActionEvent e) {
		String bookName=this.bookNameText.getText();
		String price=this.priceText.getText().trim();
		String isbn=this.isbnText.getText();
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名不能为空!");
			return;
		}
		if(StringUtil.isEmpty(isbn)) {
			JOptionPane.showMessageDialog(null, "出版号不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空!");
			return;
		}
		
		Book book=new Book(bookName,Double.parseDouble(price),isbn);
		Connection con=null;
		try {
			con=dbutil.getCon();
			int addNum=bookdao.add(con, book);
			if(addNum==1) {
				AutoaddStoreCount(isbn);
				
				int optNum=JOptionPane.showConfirmDialog(null, "是否继续要入库此本书?");
				if(optNum==0) {
					
				}else {
					resetValue();
				}
			}else {
				JOptionPane.showMessageDialog(null, "图书入库失败!");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书入库失败!");
		}finally {
			dbutil.closeDbCon(con);
		}
		
	}
/**
 * 根据出版号来查找书名
 */
	private void findBookName() {
		Connection con=null;
		BookInfo bookinfo=null;
		try {
			con=dbutil.getCon();
			ResultSet set=bookinfodao.list(con, new BookInfo());//得到所有的bookinfo
			while(set.next()) {
				bookinfo=new BookInfo();
				bookinfo.setIsbn(set.getString("isbn"));
				if(bookinfo.getIsbn().equals(isbnText.getText().trim()))
				{
					bookinfo.setBookName(set.getString("bookName"));
					bookNameText.setText(bookinfo.getBookName());
					return;
				}
//				if(set.getString("isbn").equals(isbnText.getText())) {
//					bookinfo=(BookInfo) set;
//					bookNameText.setText(bookinfo.getBookName());
//				}
				
			}
			JOptionPane.showMessageDialog(null, "并未有此图书!");
			bookNameText.setText("");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbutil.closeDbCon(con);
		}
	}
	/**
	 * 在添加book成功后,该类书的库存要++
	 */
	private void AutoaddStoreCount(String isbn){
		Connection con=null;
		BookInfo bookinfo=null;
		try {
			con=dbutil.getCon();
			ResultSet set=bookinfodao.list(con, new BookInfo());//得到所有的bookinfo
			while(set.next()) {
				bookinfo=new BookInfo();
				bookinfo.setIsbn(set.getString("isbn"));
				if(isbn.equals(bookinfo.getIsbn())) {
					bookinfo.setInStoreCount(set.getInt("inStoreCount")+1);
					int modNum=bookinfodao.updateCount(con, bookinfo);
					if(modNum==1) {
						JOptionPane.showMessageDialog(null, "图书入库成功!");
						return;
					}else {
						JOptionPane.showMessageDialog(null, "图书入库失败!");
					}
				}
				
			}
			JOptionPane.showMessageDialog(null, "图书入库失败!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "图书入库失败!");
		}finally {
			dbutil.closeDbCon(con);
		}
	}
	
	
	/**
	 * 重置事件
	 */
	private void resetValue() {
		this.priceText.setText("");
		this.bookNameText.setText("");
		this.isbnText.setText("");
	}
}
