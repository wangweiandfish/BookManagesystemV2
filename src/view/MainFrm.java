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
		setBounds(100, 100, 718, 542);
		
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
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u4FE1\u606F\u66F4\u65B0");
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u5220\u9664");
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/delete.png")));
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u5165\u5E93");
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
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		 table = new JDesktopPane();
		table.setBackground(Color.CYAN);
		getContentPane().add(table, BorderLayout.CENTER);
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 780, Short.MAX_VALUE)
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 627, Short.MAX_VALUE)
		);
		table.setLayout(gl_table);
	}
}
