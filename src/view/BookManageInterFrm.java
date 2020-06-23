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

import Util.dBUtil;
import dao.BookDao;
import dao.bookInfoDao;
import model.Book;
import model.BookInfo;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField bookNameText;
	private JTextField bookisbnText;
	private JTextField BookIdText;
	private dBUtil dbutil=new dBUtil(); //引入数据库工具类
	private bookInfoDao bookinfodao=new bookInfoDao();
	private BookDao bookdao=new BookDao();
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
		setBounds(100, 100, 924, 609);
		
		JScrollPane scrollPane = new JScrollPane();
		
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(245))
		);
		getContentPane().setLayout(groupLayout);
		this.filllTable(new Book());
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
}
