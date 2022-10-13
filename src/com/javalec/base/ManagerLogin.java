package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.dao.ManagerLoginDao;
import com.javalec.dao.ManagerLoginDao;
import com.javalec.dto.ManagerLoginDto;
import com.javalec.util.ManagerloginEmployeeid;
import com.javalec.dto.ManagerLoginDto;
import javax.swing.JPasswordField;

public class ManagerLogin {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfEmployeeid;
	private JButton btnLogin;
	private JLabel lblNewLabel_2;
	private JPasswordField tfEmployeepassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogin window = new ManagerLogin();
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
	public ManagerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("관리자로그인");
		frame.setBounds(100, 100, 450, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getTfEmployeeid());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfEmployeepassword());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID : ");
			lblNewLabel.setBounds(44, 416, 47, 35);
		}
		return lblNewLabel;
	}

	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW : ");
			lblPw.setBounds(44, 463, 47, 35);
		}
		return lblPw;
	}

	private JTextField getTfEmployeeid() {
		if (tfEmployeeid == null) {
			tfEmployeeid = new JTextField();
			tfEmployeeid.setBounds(80, 413, 295, 40);
			tfEmployeeid.setColumns(10);
		}
		return tfEmployeeid;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginAction();
				}
			});
			btnLogin.setBounds(0, 563, 450, 48);
		}
		return btnLogin;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("관리자페이지");
			lblNewLabel_2.setBounds(182, 38, 88, 48);
		}
		return lblNewLabel_2;
	}

	private void loginAction() {
		ManagerLoginDao logindao = new ManagerLoginDao();
		ArrayList<ManagerLoginDto> dtoList = logindao.loginAction(tfEmployeeid.getText());
		String id = tfEmployeeid.getText();
		String password = tfEmployeepassword.getText();
		int confirm = 0;

		for (int index = 0; index < dtoList.size(); index++) {
			if (dtoList.get(index).getEmployeeid().equals(id)
					&& dtoList.get(index).getEmployeepassword().equals(password)) {

				JOptionPane.showMessageDialog(null, "로그인하였습니다.");
				ManagerLogin.setEmployeeid(tfEmployeeid.getText());
				ManagerMenu.main(null);
				frame.setVisible(false);
				break;
			}
			confirm += 1;

		}
		if (confirm == dtoList.size()) {
			JOptionPane.showMessageDialog(null, "잘못 입력했거나 탈퇴한 회원입니다. 다시 로그인해주세요");
			tfEmployeeid.setText("");
			tfEmployeepassword.setText("");
		}
		ManagerloginEmployeeid.setEmployeeid(id); // util에 있는 ManagerloginEmployeeid 클라스로 아디를 저장
	}

	private static void setEmployeeid(String text) {
		// TODO Auto-generated method stub

	}

	private JPasswordField getTfEmployeepassword() {
		if (tfEmployeepassword == null) {
			tfEmployeepassword = new JPasswordField();
			tfEmployeepassword.setBounds(80, 463, 295, 40);
		}
		return tfEmployeepassword;
	}
}
