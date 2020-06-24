package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Util.StringUtil;
import Util.dBUtil;
import dao.BookDao;
import dao.bookInfoDao;
import model.Book;
import model.BookInfo;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 图书的管理界面
 * @author DELL2017
 *创建时间:2020年6月23日 下午5:42:12
 */
public class BookManageInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6588494275164444479L;
	private JTable bookTable;
	private JTextField bookNameText;
	private JTextField bookisbnText;
	private JTextField BookIdText;
	private dBUtil dbutil=new dBUtil(); //引入数据库工具类
	private bookInfoDao bookinfodao=new bookInfoDao();
	private BookDao bookdao=new BookDao();
	private JTextField idText;
	private JTextField bookNameText2;
	private JTextField authorText;
	private JTextField isbnText;
	private JTextField bookTypeNameText;
	private JTextField priceText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 961, 629);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/bookName.png")));
		
		bookNameText = new JTextField();
		bookNameText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u7248\u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/isbn.png")));
		
		bookisbnText = new JTextField();
		bookisbnText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_2.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/number.png")));
		
		BookIdText = new JTextField();
		BookIdText.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookisbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(label_2)
					.addGap(18)
					.addComponent(BookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bookisbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(BookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u56FE\u4E66\u7C7B\u578B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -6915838405660502995L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(111);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u64CD\u4F5C\u8868\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(58))
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		label_3.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/number.png")));
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_4.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/bookName.png")));
		
		bookNameText2 = new JTextField();
		bookNameText2.setEditable(false);
		bookNameText2.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F5C\u8005\uFF1A");
		label_5.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/author.png")));
		
		authorText = new JTextField();
		authorText.setEditable(false);
		authorText.setColumns(10);
		
		JLabel label_6 = new JLabel("\u51FA\u7248\u53F7\uFF1A");
		label_6.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/isbn.png")));
		
		isbnText = new JTextField();
		isbnText.setEditable(false);
		isbnText.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");
		label_7.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/bookType.png")));
		
		bookTypeNameText = new JTextField();
		bookTypeNameText.setEditable(false);
		bookTypeNameText.setColumns(10);
		
		JLabel label_8 = new JLabel("\u4EF7\u683C\uFF1A");
		label_8.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/rmb.png")));
		
		priceText = new JTextField();
		priceText.setColumns(10);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u51FA\u5E93");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/outCount.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idText, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4)
							.addGap(10)
							.addComponent(bookNameText2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_1)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameText)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(21)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_2)
								.addComponent(label_8))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(priceText)))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNameText2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_6)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_7)
							.addComponent(bookTypeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_8)
							.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);
		this.filllTable(new Book());
	}
	/**
	 * 出库操作
	 * @param e
	 */
	private void bookDeleteActionPerformed(ActionEvent e) {
		String id=idText.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择您要出库的图书对象!");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要出库此图书吗?");
		if(n==0) {
			Connection con=null;
			try {
				con=dbutil.getCon();
				int delNum=bookdao.delete(con, id);
				if(delNum==1) {
					JOptionPane.showMessageDialog(null, "出库成功!");
					this.resetValue();
					//this.filllTable(new BookInfo());
					this.filllTable(new Book());
				}else {
					JOptionPane.showConfirmDialog(null, "出库失败!");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally {
				dbutil.closeDbCon(con);
			}
		}
		
	}

	/**
	 * 更新操作
	 * @param e
	 */
	protected void bookUpdateActionPerformed(ActionEvent e) {
		String id=idText.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "您未选择任何图书对象!");
			return;
		}
		String bookName=bookNameText2.getText();
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "请输入正确的书名!");
			return;
		}
		String price=priceText.getText();
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "请输入正确的价格!");
			return;
		}
		Book book=new Book(Integer.parseInt(id),bookName,Double.parseDouble(price));
		Connection con=null;
		try {
			con=dbutil.getCon();
			int updateNum=bookdao.update(con, book);
			if(updateNum==1) {
				JOptionPane.showMessageDialog(null, "图书信息更新成功!");
				resetValue();
				filllTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "图书信息更新失败!");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书信息更新失败!");
		}finally {
			dbutil.closeDbCon(con);
		}
	}

	/**
	 * 点击表格事件处理
	 */
	private void bookTableMousePressed(MouseEvent e) {
		Book book=null;
		int row=this.bookTable.getSelectedRow();//获取选中的行
		this.idText.setText((int)bookTable.getValueAt(row, 0)+"");
		this.bookNameText2.setText((String) bookTable.getValueAt(row, 1));
		this.authorText.setText((String)bookTable.getValueAt(row, 2));
		this.bookTypeNameText.setText((String)bookTable.getValueAt(row, 3));
		this.priceText.setText((double)bookTable.getValueAt(row, 4)+"");
		book=new Book();
		//book.setId();
		int n=Integer.parseInt(idText.getText().trim());
		try {
			Connection con=dbutil.getCon();
			ResultSet rs=bookdao.list(con, book);
			while(rs.next()) {
				if(rs.getInt("id")==n) {
					this.isbnText.setText(rs.getString("bookisbn"));
				}
				
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}

	/**
	 * 查询事件处理
	 * @param ee
	 */
	private void bookSearchActionPerformed(ActionEvent ee) {
		int newid=0;
		String bookName=this.bookNameText.getText().trim();
		String isbn=this.bookisbnText.getText().trim();
		String id=this.BookIdText.getText().trim();
		if(id==null ||id.equals("")) {
			 newid=0;
		}else {
			newid=Integer.parseInt(id);
		}
		Book book=new Book(newid,bookName,isbn);
		this.filllTable(book);
	}

	/**
	 * 初始化表格数据
	 * @param book
	 */
	private void filllTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		BookInfo bookinfo=null;
		try {
			con=dbutil.getCon();
			ResultSet bookset=bookdao.list(con, book);
			while(bookset.next()) {
				bookinfo=new BookInfo();
				bookinfo.setBookName(bookset.getString("bookName"));
				ResultSet bookinfoset=bookinfodao.list(con, bookinfo);
				while(bookinfoset.next()) {
					bookinfo.setIsbn(bookinfoset.getString("isbn"));
					if(bookinfo.getIsbn().equals(bookset.getString("bookisbn"))) {
					Vector<Object> v=new Vector<Object>();
					
					v.add(bookset.getInt("id"));
					v.add(bookinfoset.getString("bookName"));
					v.add(bookinfoset.getString("author"));
					v.add(bookinfoset.getString("bookTypeName"));
					v.add(bookset.getDouble("price"));
					v.add(bookinfoset.getString("Desc"));
					dtm.addRow(v);
					}
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbutil.closeDbCon(con);
		}
	}
	/*
	 * 重置表单操作
	 */
	private void resetValue(){
		bookNameText.setText("");
		bookNameText2.setText("");
		bookisbnText.setText("");
		BookIdText.setText("");
		authorText.setText("");
		isbnText.setText("");
		priceText.setText("");
		idText.setText("");
		bookTypeNameText.setText("");
	}
	
	
}
