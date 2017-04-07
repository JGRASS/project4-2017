package sudoku.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.border.CompoundBorder;

public class SudokuMainWindow {

	private JFrame frmSudokuGame;
	private JPanel southPanel;
	private JPanel centralPanel;
	private JTable sudokuTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMainWindow window = new SudokuMainWindow();
					window.frmSudokuGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SudokuMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSudokuGame = new JFrame();
		frmSudokuGame.setTitle("Sudoku Game");
		frmSudokuGame.setResizable(false);
		frmSudokuGame.setBounds(100, 100, 564, 500);
		frmSudokuGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSudokuGame.getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
		frmSudokuGame.getContentPane().add(getCentralPanel(), BorderLayout.CENTER);
	}

	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setLayout(new MigLayout("", "[]", "[]"));
		}
		return southPanel;
	}
	private JPanel getCentralPanel() {
		if (centralPanel == null) {
			centralPanel = new JPanel();
			centralPanel.setLayout(new MigLayout("", "[center]", "[grow]"));
			centralPanel.add(getSudokuTable(), "cell 0 0,alignx center,aligny top");
		}
		return centralPanel;
	}
	private JTable getSudokuTable() {
		if (sudokuTable == null) {
			sudokuTable = new JTable();
			sudokuTable.setRowSelectionAllowed(false);
			sudokuTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 3), new LineBorder(new Color(0, 0, 0))));
			sudokuTable.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			sudokuTable.setPreferredSize(new Dimension(360, 360));
			sudokuTable.setModel(new DefaultTableModel(9,9));
			
			sudokuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			sudokuTable.setRowHeight(40);
			
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for (int i = 0; i < 9; i++) {
				sudokuTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
			
			
		}
		return sudokuTable;
	}
}
