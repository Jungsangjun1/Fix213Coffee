package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectStore {

	private JFrame frame;
	private JComboBox comboBox;
	private JButton btn;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectStore window = new SelectStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("지점명");
		frame.setBounds(100, 100, 450, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getBtn());
		frame.getContentPane().add(getBtnGoBack());
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			comboBox.addItem("강남점");
			comboBox.addItem("역삼점");
			comboBox.addItem("언주점");
			comboBox.setBounds(18, 58, 413, 40);
		}
		return comboBox;
	}
	private JButton getBtn() {
		if (btn == null) {
			btn = new JButton("이동하기");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem() == "강남점") {
					EmployeeSales.main(null);
					frame.setVisible(false);
					}else if(comboBox.getSelectedItem() == "역삼점") {
					JOptionPane.showMessageDialog(null, "오픈 전 지점입니다.", "알림", JOptionPane.WARNING_MESSAGE);
					}else { JOptionPane.showMessageDialog(null, "오픈 전 지점입니다.", "알림", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btn.setBounds(327, 134, 117, 29);
		}
		return btn;
	}
	
	private JButton getBtnGoBack() {
		if (btnGoBack == null) {
			btnGoBack = new JButton("뒤로 가기");
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerMenu.main(null);
					frame.setVisible(false);
				}
			});
			btnGoBack.setBounds(6, 6, 117, 29);
		}
		return btnGoBack;
	}
}
