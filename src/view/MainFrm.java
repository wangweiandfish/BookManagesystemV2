package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1153059976319818155L;
	private JDesktopPane table=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1922, 1080);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6DFB\u52A0\u65B0\u56FE\u4E66\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInfoAddInterFrm add=new BookInfoAddInterFrm();
				add.setVisible(true);//可见
				table.add(add);
				
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u4FE1\u606F\u7BA1\u7406");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookNameManageInterFrm manage=new BookNameManageInterFrm();
				manage.setVisible(true);
				table.add(manage);
				
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u5165\u5E93");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm add=new BookAddInterFrm();
				add.setVisible(true);
				table.add(add);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/enter.png")));
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u66F4\u65B0");
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_1.add(menuItem_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u51FA\u5E93");
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/outCount.png")));
		menu_1.add(mntmNewMenuItem);
		
		JMenu menu_2 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		//menu_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
		//});
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统?");
				if(result==0) {
					dispose();
			
				}
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu_2.add(menuItem_5);
		
		JMenu menu_3 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC\u7EC4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutMyTeam my=new AboutMyTeam();
				my.setVisible(true);
				table.add(my);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menu_3.add(mntmNewMenuItem_1);
		
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		 table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		getContentPane().add(table, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainFrm.class.getResource("/images/school.jpg")));
		
		JLabel label_1 = new JLabel("\u7EC4\u957F\uFF1A17052173\u6C6A\u709C");
		label_1.setFont(new Font("楷体", Font.PLAIN, 17));
		
		JLabel label_2 = new JLabel("\u7EC4\u5458\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 17));
		
		JLabel label_3 = new JLabel("17052111\u8C2D\u690D\u534E");
		label_3.setFont(new Font("楷体", Font.PLAIN, 17));
		
		JLabel label_4 = new JLabel("17052030\u9648\u4FCA\u6210");
		label_4.setFont(new Font("楷体", Font.PLAIN, 17));
		
		JLabel label_5 = new JLabel("17052090\u5F20\u7D2B\u5C55");
		label_5.setFont(new Font("楷体", Font.PLAIN, 17));
		
		JLabel lblNewLabel = new JLabel("17052087\u9093\u6EE1\u6DF1");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_table.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addGroup(gl_table.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_table.createSequentialGroup()
							.addGroup(gl_table.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(284))
						.addGroup(gl_table.createSequentialGroup()
							.addGroup(gl_table.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_3)
								.addComponent(label_5)
								.addComponent(lblNewLabel))
							.addGap(274)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addContainerGap(547, Short.MAX_VALUE))
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_table.createSequentialGroup()
					.addGroup(gl_table.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_table.createSequentialGroup()
							.addGap(304)
							.addComponent(label_1)
							.addGap(26)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_3)
							.addGap(29)
							.addComponent(label_4)
							.addGap(27)
							.addComponent(label_5)
							.addGap(26)
							.addComponent(lblNewLabel))
						.addGroup(gl_table.createSequentialGroup()
							.addGap(164)
							.addComponent(label)))
					.addContainerGap(229, Short.MAX_VALUE))
		);
		table.setLayout(gl_table);
	}
}
