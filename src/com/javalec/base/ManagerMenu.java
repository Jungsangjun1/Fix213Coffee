package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.javalec.dao.ManagerMenuDao;
import com.javalec.dao.ManagerLoginDao;
import com.javalec.dao.ManagerLoginDao;
import com.javalec.dao.StoreStatusDao;
import com.javalec.dto.ManagerMenuDto;
import com.javalec.dto.ManagerLoginDto;
import com.javalec.dto.StoreStatusDto;
import com.javalec.util.ManagerloginEmployeeid;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManagerMenu {

	private JFrame frmManagerMenu;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JButton btnOrderStatus;
	private JButton btnSalesStatus;
	private JButton btnAddMenu;
	private JButton btnLogout;
	private JLabel tfEmployeepassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMenu window = new ManagerMenu();
					window.frmManagerMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagerMenu = new JFrame();
		frmManagerMenu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
//				searchAction();
			}
		});
		frmManagerMenu.setBackground(new Color(33, 67, 190));
		frmManagerMenu.setFont(new Font("Dialog", Font.BOLD, 12));
		frmManagerMenu.setForeground(new Color(33, 67, 190));
		frmManagerMenu.setTitle("메뉴");
		frmManagerMenu.setBounds(100, 100, 450, 440);
		frmManagerMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagerMenu.getContentPane().setLayout(null);
		frmManagerMenu.getContentPane().add(getLblNewLabel_1());
		frmManagerMenu.getContentPane().add(getTfName());
		frmManagerMenu.getContentPane().add(getBtnOrderStatus());
		frmManagerMenu.getContentPane().add(getBtnSalesStatus());
		frmManagerMenu.getContentPane().add(getBtnAddMenu());
		frmManagerMenu.getContentPane().add(getBtnLogout());
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("님 환영합니다.");
			lblNewLabel_1.setBounds(222, 42, 84, 16);
			
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(143, 37, 79, 26);
			tfName.setText(ManagerloginEmployeeid.getEmployeeid()); //ManagerloginEmployeeid에 저장되어 있는 아이디를 실행
		}
		return tfName;
	}
	private JButton getBtnOrderStatus() {
		if (btnOrderStatus == null) {
			btnOrderStatus = new JButton("매장별 주문현황 및 처리 및 재고현황");
			btnOrderStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StoreStatus.main(null);
					frmManagerMenu.setVisible(false);
				}
			});
			btnOrderStatus.setBounds(58, 107, 335, 40);
		}
		return btnOrderStatus;
	}
	private JButton getBtnSalesStatus() {
		if (btnSalesStatus == null) {
			btnSalesStatus = new JButton("직원별 판매현황");
			btnSalesStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SelectStore.main(null);
					frmManagerMenu.setVisible(false);
				}
			});
			btnSalesStatus.setBounds(58, 184, 335, 40);
		}
		return btnSalesStatus;
	}
	private JButton getBtnAddMenu() {
		if (btnAddMenu == null) {
			btnAddMenu = new JButton("메뉴 등록 및 삭제");
			btnAddMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateQuantity.main(null);
					frmManagerMenu.setVisible(false);
				}
			});
			btnAddMenu.setBounds(58, 264, 335, 40);
		}
		return btnAddMenu;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("로그아웃");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerLogin.main(null);
					frmManagerMenu.setVisible(false);
				}
			});
			btnLogout.setBounds(6, 366, 438, 40);
		}
		return btnLogout;
	}
	

}
