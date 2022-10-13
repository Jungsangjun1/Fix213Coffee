package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.UpdateQuantityDao;
import com.javalec.dao.UpdateQuantityDao1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateQuantity {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblProductName;
	private JTextField tfName;
	private JLabel lblproductPrice;
	private JTextField tfPrice;
	private JLabel lblproductInitDate;
	private JTextField tfCategory;
	private JLabel lblEmail;
	private JTextField tfInit;
	private JLabel lblRelation;
	private JTextField tfImage;

	// --Table Definition
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnInsert;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuantity window = new UpdateQuantity();
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
	public UpdateQuantity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("제품 등록 및 수정");
		frame.setBounds(100, 100, 631, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblProductName());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblproductPrice());
		frame.getContentPane().add(gettfPrice());
		frame.getContentPane().add(getLblproductInitDate());
		frame.getContentPane().add(gettfCategory());
		frame.getContentPane().add(getLblEmail());
		frame.getContentPane().add(gettfInit());
		frame.getContentPane().add(getLblRelation());
		frame.getContentPane().add(gettfImage());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtnInsert());
		frame.getContentPane().add(getBtnGoBack());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 6, 619, 194);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						tableClick();// JTable안에서 버튼 클릭이 발생했을 경우에 발생시킨다.
					}
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);// ***********************8
		}
		return Inner_Table;
	}

	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("제품명 :");
			lblProductName.setBounds(16, 240, 105, 15);
		}
		return lblProductName;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBackground(new Color(238, 238, 238));
			tfName.setColumns(10);
			tfName.setBounds(98, 234, 91, 21);
		}
		return tfName;
	}

	private JLabel getLblproductPrice() {
		if (lblproductPrice == null) {
			lblproductPrice = new JLabel("가격 :");
			lblproductPrice.setBounds(16, 268, 105, 15);
		}
		return lblproductPrice;
	}

	private JTextField gettfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setBackground(new Color(238, 238, 238));
			tfPrice.setColumns(10);
			tfPrice.setBounds(98, 262, 91, 21);
		}
		return tfPrice;
	}

	private JLabel getLblproductInitDate() {
		if (lblproductInitDate == null) {
			lblproductInitDate = new JLabel("카테고리 :");
			lblproductInitDate.setBounds(16, 299, 105, 15);
		}
		return lblproductInitDate;
	}

	private JTextField gettfCategory() {
		if (tfCategory == null) {
			tfCategory = new JTextField();
			tfCategory.setBackground(new Color(238, 238, 238));
			tfCategory.setColumns(10);
			tfCategory.setBounds(98, 293, 215, 21);
		}
		return tfCategory;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("등록일자 :");
			lblEmail.setBounds(16, 330, 105, 15);
		}
		return lblEmail;
	}

	private JTextField gettfInit() {
		if (tfInit == null) {
			tfInit = new JTextField();
			tfInit.setEditable(false);
			tfInit.setBackground(new Color(238, 238, 238));
			tfInit.setColumns(10);
			tfInit.setBounds(98, 324, 215, 21);
		}
		return tfInit;
	}

	private JLabel getLblRelation() {
		if (lblRelation == null) {
			lblRelation = new JLabel("이미지");
			lblRelation.setBounds(16, 366, 105, 15);
		}
		return lblRelation;
	}

	private JTextField gettfImage() {
		if (tfImage == null) {
			tfImage = new JTextField();
			tfImage.setEditable(false);
			tfImage.setBackground(new Color(238, 238, 238));
			tfImage.setColumns(10);
			tfImage.setBounds(98, 360, 191, 21);
		}
		return tfImage;
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
			btnGoBack.setBounds(508, 428, 117, 29);
		}
		return btnGoBack;
	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("입력");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
					tableInit();
					searchAction();
					clearColumn();
				}
			});
			btnInsert.setBounds(6, 428, 117, 29);
		}
		return btnInsert;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteAction();
					tableInit();
					searchAction();
					clearColumn();
				}
			});
			btnDelete.setBounds(264, 428, 117, 29);
		}
		return btnDelete;
	}
	
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
					tableInit();
					searchAction();
					clearColumn();
				}
			});
			btnUpdate.setBounds(135, 428, 117, 29);
		}
		return btnUpdate;
	}


	// -----------------------------------------------------------
	// -----------------------------------------------------------
	// -----------------------------------------------------------

	private void tableInit() {

		Outer_Table.addColumn("메뉴");
		Outer_Table.addColumn("가격");
		Outer_Table.addColumn("카테고리");
		Outer_Table.addColumn("등록일자");
		Outer_Table.addColumn("수정일자");


		Outer_Table.setColumnCount(5);
		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);// 0부터 지우니까 계속해서 지우면 0으로 올라가고 0번째로 올라오는 값들을 지워준다.
		}

		Inner_Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;// 배열처럼 0번부터
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 70;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 170;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 170;
		col.setPreferredWidth(width);
		
	}

	// DB to Table
	private String[] searchAction() {
		String whereStatement = "select productid, productprice, productkategorie, productinitdate, productupdatedate, productdeletedate from product";// 해당되는 사항을
																											// 데이터베이스에서																		// 가져옴.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB불러오기
			Connection conn_mysql = DriverManager.getConnection(com.javalec.util.DBConnect.url_mysql,
					com.javalec.util.DBConnect.id_mysql, com.javalec.util.DBConnect.pw_mysql);// 선언
			Statement stmt_mysql = conn_mysql.createStatement();
			// 불러올 때 java.sql을 불러와야함.

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
				
				if (qTxt [5] == null) {
					Outer_Table.addRow(qTxt);// 누적됨.
				}
				}
			
			

			conn_mysql.close();// 불러온 DB를 닫아 줘야함.

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Table click
	private void tableClick() {// 몇번째 줄을 클릭했는지 안려주는 메소드
		int i = Inner_Table.getSelectedRow();// 몇번째 줄인지 알려주는 역할
		String wkSequence = Inner_Table.getValueAt(i, 0).toString();// 그출에 해당되는 값을 가져오기때문에 String
		// Sequence No를 가져와서 보여주는 역할을 함.

		String whereStatement = "select productid, productprice, productkategorie, productinitdate, productupdatedate from product ";
		String whereStatement2 = "where productid = " + "'"+wkSequence+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB불러오기
			Connection conn_mysql = DriverManager.getConnection(com.javalec.util.DBConnect.url_mysql,
					com.javalec.util.DBConnect.id_mysql, com.javalec.util.DBConnect.pw_mysql);// 선언
			Statement stmt_mysql = conn_mysql.createStatement();
			// 불러올 때 java.sql을 불러와야함.

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
//         해당되는 속성을 가져옴+
			while (rs.next()) {// 해당되는 사항들을 그대로 출력해서 보여준다.
				tfName.setText(rs.getString(1));//제품명
				tfPrice.setText(rs.getString(2));//가격
				tfCategory.setText(rs.getString(3));//카테고리
				tfInit.setText(rs.getString(4));//등록일자
				tfImage.setText(rs.getString(5));//이미지
			}

			conn_mysql.close();// 불러온 DB를 닫아 줘야함.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private void clearColumn() {
		tfName.setText("");
		tfPrice.setText("");
		tfCategory.setText("");
		tfInit.setText("");
		tfImage.setText("");
	}
	
	private void updateAction() {
		String productid = tfName.getText();
		int productprice = Integer.parseInt(tfPrice.getText());
		String productkategorie = tfCategory.getText();
		String productimage = tfImage.getText();

		UpdateQuantityDao dao = new UpdateQuantityDao(productid, productprice, productkategorie, productimage);
		Boolean ok = dao.updateAction();

		if (ok == true) {
			JOptionPane.showMessageDialog(null,"정보가 수정되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "작업중 문제가 발생했습니다.");
		}
	}

	private void insertAction() {
		String productid = tfName.getText();
		int productprice = Integer.parseInt(tfPrice.getText());
		String productkategorie = tfCategory.getText();
		

		UpdateQuantityDao dao = new UpdateQuantityDao(productid, productprice, productkategorie);
		Boolean ok = dao.insertAction();

		if (ok == true) {
			JOptionPane.showMessageDialog(null,"정보가 입력되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "메뉴명이 중복되었습니다.");
		}
	}
	
private void deleteAction() {
		String productid = tfName.getText();
		
		UpdateQuantityDao dao = new UpdateQuantityDao(productid);
		Boolean ok = dao.deleteAction();

		if (ok == true) {
			JOptionPane.showMessageDialog(null, "선택하신 메뉴가 삭제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "작업중 문제가 발생했습니다.");
		}
	}


}// end