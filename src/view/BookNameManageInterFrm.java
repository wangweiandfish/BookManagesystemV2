package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.StringUtil;
import Util.dBUtil;
import dao.bookInfoDao;
import model.BookInfo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookNameManageInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7649796285505961042L;
	private JTable bookinfoTable;
	private dBUtil dbutil=new dBUtil(); //�������ݿ⹤����
	private bookInfoDao infodao=new bookInfoDao();
	private JTextField bookNameSearchText;
	private JTextField isbnText;
	private JTextField bookNameText;
	private JTextField bookTypeText;
	private JTextField authorText;
	private JTextArea DescText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookNameManageInterFrm frame = new BookNameManageInterFrm();
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
	public BookNameManageInterFrm() {
		setTitle("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 905, 696);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		bookNameSearchText = new JTextField();
		bookNameSearchText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookNameSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FE1\u606F\u66F4\u65B0", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(265)
							.addComponent(lblNewLabel)
							.addGap(51)
							.addComponent(bookNameSearchText, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, 0, 0, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(bookNameSearchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u7248\u53F7");
		lblNewLabel_1.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/isbn.png")));
		
		isbnText = new JTextField();
		isbnText.setEditable(false);
		isbnText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel_2.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/bookName.png")));
		
		bookNameText = new JTextField();
		bookNameText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
		lblNewLabel_3.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/bookType.png")));
		
		bookTypeText = new JTextField();
		bookTypeText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u8005");
		lblNewLabel_4.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/author.png")));
		
		authorText = new JTextField();
		authorText.setColumns(10);
		
		JLabel label = new JLabel("\u4F5C\u54C1\u7B80\u4ECB");
		label.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/Desc.png")));
		
		 DescText = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookinfoUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookinfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookNameManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_4))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addGap(4)
										.addComponent(DescText))
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addGap(42)
										.addComponent(lblNewLabel_2)
										.addGap(26)
										.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
										.addGap(44)
										.addComponent(lblNewLabel_3)
										.addGap(26)
										.addComponent(bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(155)
					.addComponent(btnNewButton_1)
					.addGap(82)
					.addComponent(btnNewButton_2)
					.addContainerGap(410, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(isbnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(DescText, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(18))
		);
		panel.setLayout(gl_panel);
		
		bookinfoTable = new JTable();
		bookinfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookinfoTableMousePressed(e);
			}
		});
		bookinfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u51FA\u7248\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u7C7B\u578B", "\u4F5C\u8005", "\u5E93\u5B58\u91CF", "                \u56FE\u4E66\u63CF\u8FF0"
			}
		));
		bookinfoTable.getColumnModel().getColumn(5).setPreferredWidth(348);
		scrollPane.setViewportView(bookinfoTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookInfo());

	}
	
	/**
	 * ɾ���¼�����
	 * @param e
	 */
	private void bookinfoDeleteActionPerformed(ActionEvent e) {
		String isbn=isbnText.getText();
		if(StringUtil.isEmpty(isbn)) {
			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ����ͼ����Ϣ!");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ������ͼ����Ϣ��?");
		if(n==0) {
			Connection con=null;
			try {
				con=dbutil.getCon();
				int delNum=infodao.delete(con, isbn);
				if(delNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
					this.resetValue();
					this.fillTable(new BookInfo());
				}else {
					JOptionPane.showConfirmDialog(null, "ɾ��ʧ��!");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally {
				dbutil.closeDbCon(con);
			}
		}
	}

	/**
	 * �����¼�����
	 * @param e
	 */
	private void bookinfoUpdateActionPerformed(ActionEvent e) {
		String isbn=isbnText.getText();
		String bookName=bookNameText.getText();
		String bookType=bookTypeText.getText();
		String author=authorText.getText();
		String desc=DescText.getText();
		if(StringUtil.isEmpty(isbn)) {
			JOptionPane.showMessageDialog(null, "��δѡ���κ�ͼ����Ϣ!");
			return;
		}
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ��!");
			return;
		}
		BookInfo bookinfo=new BookInfo(isbn, bookName, bookType, author, desc);
		Connection con=null;
		try {
			con=dbutil.getCon();
			int modNum=infodao.update(con, bookinfo);
			if(modNum==1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
				resetValue();//�����޸���
				fillTable(new BookInfo());//ˢ��һ����ʾ��
			}else {
				
				JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}finally {
			dbutil.closeDbCon(con);
		}
	}

	/**
	 * ���������¼�����
	 * @param e
	 */
	private void bookinfoTableMousePressed(MouseEvent e) {
		int row=bookinfoTable.getSelectedRow();
		isbnText.setText((String)bookinfoTable.getValueAt(row, 0));
		bookNameText.setText((String)bookinfoTable.getValueAt(row, 1));
		bookTypeText.setText((String)bookinfoTable.getValueAt(row, 2));
		authorText.setText((String)bookinfoTable.getValueAt(row, 3));
		DescText.setText((String)bookinfoTable.getValueAt(row, 5));
	}

	/**
	 * ��ѯ�¼�����
	 * @param evt
	 */
	private void bookNameSearchActionPerformed(ActionEvent evt) {
		//��ȡ�û������ͼ������
		String bookName=this.bookNameSearchText.getText().trim();
		BookInfo bookinfo=new BookInfo();
		bookinfo.setBookName(bookName);
		this.fillTable(bookinfo);
		
	}

	/**
	 * ��ʼ�����
	 * @param bookinfo
	 */
	private void fillTable(BookInfo bookinfo) {
		DefaultTableModel table=(DefaultTableModel) bookinfoTable.getModel();
		table.setRowCount(0);//��ձ��
		Connection con=null;
		try {
			con=dbutil.getCon();
			ResultSet rs=infodao.list(con, bookinfo);
			while(rs.next()) {
				Vector<Object> infolist=new Vector<Object>();
				infolist.add(rs.getString("isbn"));
				infolist.add(rs.getString("bookName"));
				infolist.add(rs.getString("bookTypeName"));
				infolist.add(rs.getString("author"));
				infolist.add(rs.getInt("inStoreCount"));
				infolist.add(rs.getString("Desc"));
				table.addRow(infolist);
				//Vector v=new Vector<E>();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbutil.closeDbCon(con);
		}
		
		
	}
	/**
	 * ���ò���
	 */
	private void resetValue() {
		this.isbnText.setText("");
		this.bookNameText.setText("");
		this.bookTypeText.setText("");
		this.authorText.setText("");
		this.DescText.setText("");
		
	}
	
}
