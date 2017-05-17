package sudoku.gui;

import java.awt.BorderLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import sudoku.scores.Rezultat;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Klasa koja predstavlja okvir sa tabelom koja prikazuje 10 najboljih igraca.
 * @author Team4-2017
 *
 */
public class Highscore extends JFrame {

	private static final long serialVersionUID = 2350636351509336387L;
	
	/**
	 * Glavni okvir klase koji sadrzi sve ostale atribute.
	 */
	private JPanel contentPane;
	/**
	 * Okvir koji sadrzi tabelu.
	 */
	private JPanel centralPanel;
	/**
	 * Okvir koji sadrzi btnClose.
	 */
	private JPanel southPanel;
	/**
	 * Dugme koje zatvara prozor sa tabelom.
	 */
	private JButton btnClose;
	/**
	 * Tabela sa najboljih 10 rezultata
	 */
	private JTable table;
	
	/**
	 * Javni konstruktor koja prikazuje listu 10 najboljih igraca sa njihovim vremenima.
	 * @param lista 
	 */
	public Highscore(LinkedList<Rezultat> lista) {
		setResizable(false);
		setTitle("Highscore");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getCentralPanel(), BorderLayout.CENTER);
		contentPane.add(getSouthPanel(), BorderLayout.SOUTH);
		for (int i = 0; i < lista.size(); i++) {
			Rezultat rez = lista.get(i);
			String vreme = rez.getSati() + ":" + rez.getMinuti() + ":" + rez.getSekunde();
			Object[] row = {i+1, rez.getIme(), vreme};
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.addRow(row);
		    table.setModel(model);
		}
	}

	private JPanel getCentralPanel() {
		if (centralPanel == null) {
			centralPanel = new JPanel();
			centralPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
			centralPanel.add(getTable(), "cell 0 0,grow");
		}
		return centralPanel;
	}
	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setLayout(new MigLayout("", "[grow][][30.00]", "[]"));
			southPanel.add(getBtnClose(), "cell 1 0");
		}
		return southPanel;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.nastavi();
					dispose();
				}
			});
		}
		return btnClose;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"#", "Name", "Time"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(49);
			table.getColumnModel().getColumn(1).setPreferredWidth(339);
			table.getColumnModel().getColumn(2).setPreferredWidth(95);
		}
		return table;
	}
}
