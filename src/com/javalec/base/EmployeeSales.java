package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.EmployeeSalesDao;
import com.javalec.dto.EmployeeSalesDto;
import com.javalec.util.DBConnect;

public class EmployeeSales {

	private JFrame frmEmployeeSales;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JButton btnOk;

	// --Table Definition
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSales window = new EmployeeSales();
					window.frmEmployeeSales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeSales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeSales = new JFrame();
		frmEmployeeSales.getContentPane().setBackground(new Color(255, 255, 255));
		frmEmployeeSales.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frmEmployeeSales.setTitle("직원별 판매현황");
		frmEmployeeSales.setBounds(100, 100, 485, 480);
		frmEmployeeSales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeSales.getContentPane().setLayout(null);
		frmEmployeeSales.getContentPane().add(getTfSelection());
		frmEmployeeSales.getContentPane().add(getBtnQuery());
		frmEmployeeSales.getContentPane().add(getScrollPane());
		frmEmployeeSales.getContentPane().add(getBtnOk());

	}

	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(36, 48, 301, 21);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}

	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnQuery.setBounds(339, 47, 97, 23);
		}
		return btnQuery;
	}

	protected void conditionQuery() {
		// TODO Auto-generated method stub

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 87, 400, 255);
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
						// tableClick();
					}
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}



	// Search
	private void searchAction() {
		EmployeeSalesDao dao = new EmployeeSalesDao();
		ArrayList<EmployeeSalesDto> dtoList = dao.selectList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String[] qTxt = { dtoList.get(index).getEmployeeid(),
					Integer.toString(dtoList.get(index).getSequencenumber()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void tableInit() {

		Outer_Table.addColumn("직원이름");
		Outer_Table.addColumn("판매잔수");

		Outer_Table.setColumnCount(2);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 120;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		

	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("확인");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame jFrame = new JFrame();
					ManagerMenu.main(null);
					jFrame.setVisible(false);
				}
			});
			btnOk.setBounds(319, 368, 117, 45);
		}
		return btnOk;
	}
}