package sudoku.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import sudoku.funkcije.Funkcije;
import sudoku.generator.GeneratorProvera;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * 
 * Ova klasa predstavlja glavni prozor aplikacije.
 * 
 * @author Team4-2017
 *
 */

public class SudokuMainWindow {

	/**
	 * Matrica koja sadrzi sva polja za sudoku tabelu.
	 */
	private JTextField[][] matricaPolja;
	
	/**
	 * Objekat klase GeneratorProvera.
	 */
	GeneratorProvera gen = new GeneratorProvera();
	

	public static int sekunde = 0;
	public static int minuti = 0;
	public static int sati = 0;
	
	public static Timer tajmer = new Timer();
	
	public static TimerTask ispisiVreme = new TimerTask(){
		
		public void run(){
			sekunde++;
			if(sekunde==60){
				sekunde=0;
				minuti++;
			}
			if(minuti==60){
				minuti=0;
				sati++;
			}
			SudokuMainWindow.textTimeField.setText(sati+":"+minuti+":"+sekunde);
		}
		
	};
	
	public static void pokreniTajmer(Timer tajmer){
		tajmer.scheduleAtFixedRate(ispisiVreme,1000,1000);
	}
	
	private JFrame frmSudokuGame;
	private JPanel southPanel;
	private JPanel centralPanel;
	private JPanel eastPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JLabel lblTime;
	public static JTextField textTimeField;
	
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
		pokreniTajmer(tajmer);

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
		frmSudokuGame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==' ')
					Funkcije.pauziraj(tajmer);
			}
		});
		frmSudokuGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==' ')
					Funkcije.pauziraj(tajmer);
			}
		});
		frmSudokuGame.setResizable(false);
		frmSudokuGame.setTitle("Sudoku Game");
		frmSudokuGame.setBounds(100, 100, 564, 500);
		frmSudokuGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSudokuGame.getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
		frmSudokuGame.getContentPane().add(getCentralPanel(), BorderLayout.CENTER);
		frmSudokuGame.getContentPane().add(getEastPanel(), BorderLayout.EAST);
		
		JMenuBar menuBar = new JMenuBar();
		frmSudokuGame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New game");
		mntmNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Funkcije.newGame(matricaPolja, gen);
			}
		});
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmOpenGame = new JMenuItem("Open game");
		mntmOpenGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Funkcije.openGame();
			}
		});
		mnFile.add(mntmOpenGame);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Funkcije.save();
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmPausespace = new JMenuItem("Pause     (Space)");
		mntmPausespace.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Funkcije.pause(tajmer);
			}
		});
		mnFile.add(mntmPausespace);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Funkcije.reset();
			}
		});
		mnFile.add(mntmReset);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHighscore = new JMenu("Highscore");
		mnHighscore.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Funkcije.highScore();
			}
		});
		menuBar.add(mnHighscore);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		
		matricaPolja = new JTextField[][]{{textField, textField_1, textField_2, textField_9, textField_10, textField_11, textField_18, textField_19, textField_20},
									  {textField_3, textField_4, textField_5, textField_12, textField_13, textField_14, textField_21, textField_22, textField_23},
									  {textField_6, textField_7, textField_8, textField_15, textField_16, textField_17, textField_24, textField_25, textField_26},
									  {textField_27, textField_28, textField_29, textField_36, textField_37, textField_38, textField_45, textField_46, textField_47},
									  {textField_30, textField_31, textField_32, textField_39, textField_40, textField_41, textField_48, textField_49, textField_50},
									  {textField_33, textField_34, textField_35, textField_42, textField_43, textField_44, textField_51, textField_52, textField_53},
									  {textField_54, textField_55, textField_56, textField_63, textField_64, textField_65, textField_72, textField_73, textField_74},
									  {textField_57, textField_58, textField_59, textField_66, textField_67, textField_68, textField_75, textField_76, textField_77},
									  {textField_60, textField_61, textField_62, textField_69, textField_70 ,textField_71, textField_78, textField_79, textField_80}
		};
		
		Funkcije.newGame(matricaPolja, gen);
									  
									  
	}

	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					southPanel.grabFocus();
				}
			});
			
			southPanel.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()== ' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			
			southPanel.setLayout(new MigLayout("", "[]", "[]"));
		}
		return southPanel;
	}
	private JPanel getCentralPanel() {
		if (centralPanel == null) {
			centralPanel = new JPanel();
			centralPanel.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			centralPanel.setEnabled(false);
			centralPanel.setFocusCycleRoot(true);
			centralPanel.setToolTipText("");
			
			
			centralPanel.setLayout(new MigLayout("", "[124.00,center][124.00][124.00]", "[124.00][124.00][124.00]"));
			centralPanel.add(getPanel1(), "cell 0 0,grow");
			centralPanel.add(getPanel2(), "cell 1 0,grow");
			centralPanel.add(getPanel3(), "cell 2 0,grow");
			centralPanel.add(getPanel4(), "cell 0 1,grow");
			centralPanel.add(getPanel5(), "cell 1 1,grow");
			centralPanel.add(getPanel6(), "cell 2 1,grow");
			centralPanel.add(getPanel7(), "cell 0 2,grow");
			centralPanel.add(getPanel8(), "cell 1 2,grow");
			centralPanel.add(getPanel9(), "cell 2 2,grow");
		}
		return centralPanel;
	}
	private JPanel getEastPanel() {
		if (eastPanel == null) {
			eastPanel = new JPanel();
			
			eastPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					eastPanel.grabFocus();
				}
			});
			
			eastPanel.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
					if(c == ' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			eastPanel.setLayout(new MigLayout("", "[120.00]", "[][][][][][][][][][][][][]"));
			
			lblTime = new JLabel("Time:");
			lblTime.setAlignmentX(Component.CENTER_ALIGNMENT);
			eastPanel.add(lblTime, "flowx,cell 0 1");
			
			textTimeField = new JTextField();
			textTimeField.setEditable(false);
			eastPanel.add(textTimeField, "cell 0 1");
			textTimeField.setColumns(10);
			
			JButton btnPause = new JButton("Pause");
			btnPause.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Funkcije.pause(tajmer);
				}
			});
			btnPause.setActionCommand("Pause");
			eastPanel.add(btnPause, "cell 0 3");
			
			JButton btnCheck = new JButton("Check");
			btnCheck.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
			});
			eastPanel.add(btnCheck, "cell 0 5");
		}
		return eastPanel;
	}
	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			
			panel1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel1.setLayout(null);
			
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 0);
				}
			});
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField.setSize(new Dimension(40, 40));
			textField.setBounds(2, 2, 40, 40);
			textField.setColumns(10);
			panel1.add(textField);
			
			textField_1 = new JTextField();
			textField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 1);
				}
			});
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_1.setSize(new Dimension(40, 40));
			textField_1.setColumns(10);
			textField_1.setBounds(42, 2, 40, 40);
			panel1.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 2);
				}
			});
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_2.setSize(new Dimension(40, 40));
			textField_2.setColumns(10);
			textField_2.setBounds(82, 2, 40, 40);
			panel1.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 0);
				}
			});
			textField_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_3.setSize(new Dimension(40, 40));
			textField_3.setColumns(10);
			textField_3.setBounds(2, 42, 40, 40);
			panel1.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 1);
				}
			});
			textField_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_4.setSize(new Dimension(40, 40));
			textField_4.setColumns(10);
			textField_4.setBounds(42, 42, 40, 40);
			panel1.add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 2);
				}
			});
			textField_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_5.setSize(new Dimension(40, 40));
			textField_5.setColumns(10);
			textField_5.setBounds(82, 42, 40, 40);
			panel1.add(textField_5);
			
			textField_6 = new JTextField();
			textField_6.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 0);
				}
			});
			textField_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_6.setSize(new Dimension(40, 40));
			textField_6.setColumns(10);
			textField_6.setBounds(2, 82, 40, 40);
			panel1.add(textField_6);
			
			textField_7 = new JTextField();
			textField_7.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 1);
				}
			});
			textField_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_7.setSize(new Dimension(40, 40));
			textField_7.setColumns(10);
			textField_7.setBounds(42, 82, 40, 40);
			panel1.add(textField_7);
			
			textField_8 = new JTextField();
			textField_8.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 2);
				}
			});
			textField_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_8.setSize(new Dimension(40, 40));
			textField_8.setColumns(10);
			textField_8.setBounds(82, 82, 40, 40);
			panel1.add(textField_8);
		}
		return panel1;
	}
	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel2.setLayout(null);
			
			textField_9 = new JTextField();
			textField_9.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 3);
				}
			});
			textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_9.setSize(new Dimension(40, 40));
			textField_9.setColumns(10);
			textField_9.setBounds(2, 2, 40, 40);
			panel2.add(textField_9);
			
			textField_10 = new JTextField();
			textField_10.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 4);
				}
			});
			textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_10.setSize(new Dimension(40, 40));
			textField_10.setColumns(10);
			textField_10.setBounds(42, 2, 40, 40);
			panel2.add(textField_10);
			
			textField_11 = new JTextField();
			textField_11.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0 ,5);
				}
			});
			textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_11.setSize(new Dimension(40, 40));
			textField_11.setColumns(10);
			textField_11.setBounds(82, 2, 40, 40);
			panel2.add(textField_11);
			
			textField_12 = new JTextField();
			textField_12.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 3);
				}
			});
			textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_12.setHorizontalAlignment(SwingConstants.CENTER);
			textField_12.setSize(new Dimension(40, 40));
			textField_12.setColumns(10);
			textField_12.setBounds(2, 42, 40, 40);
			panel2.add(textField_12);
			
			textField_13 = new JTextField();
			textField_13.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 4);
				}
			});
			textField_13.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_13.setHorizontalAlignment(SwingConstants.CENTER);
			textField_13.setSize(new Dimension(40, 40));
			textField_13.setColumns(10);
			textField_13.setBounds(42, 42, 40, 40);
			panel2.add(textField_13);
			
			textField_14 = new JTextField();
			textField_14.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 5);
				}
			});
			textField_14.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_14.setHorizontalAlignment(SwingConstants.CENTER);
			textField_14.setSize(new Dimension(40, 40));
			textField_14.setColumns(10);
			textField_14.setBounds(82, 42, 40, 40);
			panel2.add(textField_14);
			
			textField_15 = new JTextField();
			textField_15.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 3);
				}
			});
			textField_15.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_15.setHorizontalAlignment(SwingConstants.CENTER);
			textField_15.setSize(new Dimension(40, 40));
			textField_15.setColumns(10);
			textField_15.setBounds(2, 82, 40, 40);
			panel2.add(textField_15);
			
			textField_16 = new JTextField();
			textField_16.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 4);
				}
			});
			textField_16.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_16.setHorizontalAlignment(SwingConstants.CENTER);
			textField_16.setSize(new Dimension(40, 40));
			textField_16.setColumns(10);
			textField_16.setBounds(42, 82, 40, 40);
			panel2.add(textField_16);
			
			textField_17 = new JTextField();
			textField_17.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 5);
				}
			});
			textField_17.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_17.setHorizontalAlignment(SwingConstants.CENTER);
			textField_17.setSize(new Dimension(40, 40));
			textField_17.setColumns(10);
			textField_17.setBounds(82, 82, 40, 40);
			panel2.add(textField_17);
		}
		return panel2;
	}
	private JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel3.setLayout(null);
			
			textField_18 = new JTextField();
			textField_18.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 6);
				}
			});
			textField_18.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_18.setHorizontalAlignment(SwingConstants.CENTER);
			textField_18.setSize(new Dimension(40, 40));
			textField_18.setColumns(10);
			textField_18.setBounds(2, 2, 40, 40);
			panel3.add(textField_18);
			
			textField_19 = new JTextField();
			textField_19.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 7);
				}
			});
			textField_19.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_19.setHorizontalAlignment(SwingConstants.CENTER);
			textField_19.setSize(new Dimension(40, 40));
			textField_19.setColumns(10);
			textField_19.setBounds(42, 2, 40, 40);
			panel3.add(textField_19);
			
			textField_20 = new JTextField();
			textField_20.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 0, 8);
				}
			});
			textField_20.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_20.setHorizontalAlignment(SwingConstants.CENTER);
			textField_20.setSize(new Dimension(40, 40));
			textField_20.setColumns(10);
			textField_20.setBounds(82, 2, 40, 40);
			panel3.add(textField_20);
			
			textField_21 = new JTextField();
			textField_21.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 6);
				}
			});
			textField_21.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_21.setHorizontalAlignment(SwingConstants.CENTER);
			textField_21.setSize(new Dimension(40, 40));
			textField_21.setColumns(10);
			textField_21.setBounds(2, 42, 40, 40);
			panel3.add(textField_21);
			
			textField_22 = new JTextField();
			textField_22.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 7);
				}
			});
			textField_22.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_22.setHorizontalAlignment(SwingConstants.CENTER);
			textField_22.setSize(new Dimension(40, 40));
			textField_22.setColumns(10);
			textField_22.setBounds(42, 42, 40, 40);
			panel3.add(textField_22);
			
			textField_23 = new JTextField();
			textField_23.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 1, 8);
				}
			});
			textField_23.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_23.setHorizontalAlignment(SwingConstants.CENTER);
			textField_23.setSize(new Dimension(40, 40));
			textField_23.setColumns(10);
			textField_23.setBounds(82, 42, 40, 40);
			panel3.add(textField_23);
			
			textField_24 = new JTextField();
			textField_24.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 6);
				}
			});
			textField_24.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_24.setHorizontalAlignment(SwingConstants.CENTER);
			textField_24.setSize(new Dimension(40, 40));
			textField_24.setColumns(10);
			textField_24.setBounds(2, 82, 40, 40);
			panel3.add(textField_24);
			
			textField_25 = new JTextField();
			textField_25.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 7);
				}
			});
			textField_25.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_25.setHorizontalAlignment(SwingConstants.CENTER);
			textField_25.setSize(new Dimension(40, 40));
			textField_25.setColumns(10);
			textField_25.setBounds(42, 82, 40, 40);
			panel3.add(textField_25);
			
			textField_26 = new JTextField();
			textField_26.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 2, 8);
				}
			});
			textField_26.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_26.setHorizontalAlignment(SwingConstants.CENTER);
			textField_26.setSize(new Dimension(40, 40));
			textField_26.setColumns(10);
			textField_26.setBounds(82, 82, 40, 40);
			panel3.add(textField_26);
		}
		return panel3;
	}
	private JPanel getPanel4() {
		if (panel4 == null) {
			panel4 = new JPanel();
			panel4.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel4.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), null));
			panel4.setLayout(null);
			
			textField_27 = new JTextField();
			textField_27.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 0);
				}
			});
			textField_27.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_27.setHorizontalAlignment(SwingConstants.CENTER);
			textField_27.setSize(new Dimension(40, 40));
			textField_27.setColumns(10);
			textField_27.setBounds(2, 2, 40, 40);
			panel4.add(textField_27);
			
			textField_28 = new JTextField();
			textField_28.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 1);
				}
			});
			textField_28.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_28.setHorizontalAlignment(SwingConstants.CENTER);
			textField_28.setSize(new Dimension(40, 40));
			textField_28.setColumns(10);
			textField_28.setBounds(42, 2, 40, 40);
			panel4.add(textField_28);
			
			textField_29 = new JTextField();
			textField_29.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 2);
				}
			});
			textField_29.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_29.setHorizontalAlignment(SwingConstants.CENTER);
			textField_29.setSize(new Dimension(40, 40));
			textField_29.setColumns(10);
			textField_29.setBounds(82, 2, 40, 40);
			panel4.add(textField_29);
			
			textField_30 = new JTextField();
			textField_30.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 0);
				}
			});
			textField_30.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_30.setHorizontalAlignment(SwingConstants.CENTER);
			textField_30.setSize(new Dimension(40, 40));
			textField_30.setColumns(10);
			textField_30.setBounds(2, 42, 40, 40);
			panel4.add(textField_30);
			
			textField_31 = new JTextField();
			textField_31.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 1);
				}
			});
			textField_31.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_31.setHorizontalAlignment(SwingConstants.CENTER);
			textField_31.setSize(new Dimension(40, 40));
			textField_31.setColumns(10);
			textField_31.setBounds(42, 42, 40, 40);
			panel4.add(textField_31);
			
			textField_32 = new JTextField();
			textField_32.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 2);
				}
			});
			textField_32.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_32.setHorizontalAlignment(SwingConstants.CENTER);
			textField_32.setSize(new Dimension(40, 40));
			textField_32.setColumns(10);
			textField_32.setBounds(82, 42, 40, 40);
			panel4.add(textField_32);
			
			textField_33 = new JTextField();
			textField_33.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 0);
				}
			});
			textField_33.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_33.setHorizontalAlignment(SwingConstants.CENTER);
			textField_33.setSize(new Dimension(40, 40));
			textField_33.setColumns(10);
			textField_33.setBounds(2, 82, 40, 40);
			panel4.add(textField_33);
			
			textField_34 = new JTextField();
			textField_34.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 1);
				}
			});
			textField_34.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_34.setHorizontalAlignment(SwingConstants.CENTER);
			textField_34.setSize(new Dimension(40, 40));
			textField_34.setColumns(10);
			textField_34.setBounds(42, 82, 40, 40);
			panel4.add(textField_34);
			
			textField_35 = new JTextField();
			textField_35.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 2);
				}
			});
			textField_35.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_35.setHorizontalAlignment(SwingConstants.CENTER);
			textField_35.setSize(new Dimension(40, 40));
			textField_35.setColumns(10);
			textField_35.setBounds(82, 82, 40, 40);
			panel4.add(textField_35);
		}
		return panel4;
	}
	private JPanel getPanel5() {
		if (panel5 == null) {
			panel5 = new JPanel();
			panel5.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel5.setLayout(null);
			
			textField_36 = new JTextField();
			textField_36.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 3);
				}
			});
			textField_36.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_36.setHorizontalAlignment(SwingConstants.CENTER);
			textField_36.setSize(new Dimension(40, 40));
			textField_36.setColumns(10);
			textField_36.setBounds(2, 2, 40, 40);
			panel5.add(textField_36);
			
			textField_37 = new JTextField();
			textField_37.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 4);
				}
			});
			textField_37.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_37.setHorizontalAlignment(SwingConstants.CENTER);
			textField_37.setSize(new Dimension(40, 40));
			textField_37.setColumns(10);
			textField_37.setBounds(42, 2, 40, 40);
			panel5.add(textField_37);
			
			textField_38 = new JTextField();
			textField_38.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 5);
				}
			});
			textField_38.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_38.setHorizontalAlignment(SwingConstants.CENTER);
			textField_38.setSize(new Dimension(40, 40));
			textField_38.setColumns(10);
			textField_38.setBounds(82, 2, 40, 40);
			panel5.add(textField_38);
			
			textField_39 = new JTextField();
			textField_39.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 3);
				}
			});
			textField_39.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_39.setHorizontalAlignment(SwingConstants.CENTER);
			textField_39.setSize(new Dimension(40, 40));
			textField_39.setColumns(10);
			textField_39.setBounds(2, 42, 40, 40);
			panel5.add(textField_39);
			
			textField_40 = new JTextField();
			textField_40.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 4);
				}
			});
			textField_40.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_40.setHorizontalAlignment(SwingConstants.CENTER);
			textField_40.setSize(new Dimension(40, 40));
			textField_40.setColumns(10);
			textField_40.setBounds(42, 42, 40, 40);
			panel5.add(textField_40);
			
			textField_41 = new JTextField();
			textField_41.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 5);
				}
			});
			textField_41.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_41.setHorizontalAlignment(SwingConstants.CENTER);
			textField_41.setSize(new Dimension(40, 40));
			textField_41.setColumns(10);
			textField_41.setBounds(82, 42, 40, 40);
			panel5.add(textField_41);
			
			textField_42 = new JTextField();
			textField_42.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 3);
				}
			});
			textField_42.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_42.setHorizontalAlignment(SwingConstants.CENTER);
			textField_42.setSize(new Dimension(40, 40));
			textField_42.setColumns(10);
			textField_42.setBounds(2, 82, 40, 40);
			panel5.add(textField_42);
			
			textField_43 = new JTextField();
			textField_43.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 4);
				}
			});
			textField_43.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_43.setHorizontalAlignment(SwingConstants.CENTER);
			textField_43.setSize(new Dimension(40, 40));
			textField_43.setColumns(10);
			textField_43.setBounds(42, 82, 40, 40);
			panel5.add(textField_43);
			
			textField_44 = new JTextField();
			textField_44.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 5);
				}
			});
			textField_44.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_44.setHorizontalAlignment(SwingConstants.CENTER);
			textField_44.setSize(new Dimension(40, 40));
			textField_44.setColumns(10);
			textField_44.setBounds(82, 82, 40, 40);
			panel5.add(textField_44);
		}
		return panel5;
	}
	private JPanel getPanel6() {
		if (panel6 == null) {
			panel6 = new JPanel();
			panel6.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel6.setLayout(null);
			
			textField_45 = new JTextField();
			textField_45.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 6);
				}
			});
			textField_45.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_45.setHorizontalAlignment(SwingConstants.CENTER);
			textField_45.setSize(new Dimension(40, 40));
			textField_45.setColumns(10);
			textField_45.setBounds(2, 2, 40, 40);
			panel6.add(textField_45);
			
			textField_46 = new JTextField();
			textField_46.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 7);
				}
			});
			textField_46.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_46.setHorizontalAlignment(SwingConstants.CENTER);
			textField_46.setSize(new Dimension(40, 40));
			textField_46.setColumns(10);
			textField_46.setBounds(42, 2, 40, 40);
			panel6.add(textField_46);
			
			textField_47 = new JTextField();
			textField_47.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 3, 8);
				}
			});
			textField_47.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_47.setHorizontalAlignment(SwingConstants.CENTER);
			textField_47.setSize(new Dimension(40, 40));
			textField_47.setColumns(10);
			textField_47.setBounds(82, 2, 40, 40);
			panel6.add(textField_47);
			
			textField_48 = new JTextField();
			textField_48.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 6);
				}
			});
			textField_48.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_48.setHorizontalAlignment(SwingConstants.CENTER);
			textField_48.setSize(new Dimension(40, 40));
			textField_48.setColumns(10);
			textField_48.setBounds(2, 42, 40, 40);
			panel6.add(textField_48);
			
			textField_49 = new JTextField();
			textField_49.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 7);
				}
			});
			textField_49.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_49.setHorizontalAlignment(SwingConstants.CENTER);
			textField_49.setSize(new Dimension(40, 40));
			textField_49.setColumns(10);
			textField_49.setBounds(42, 42, 40, 40);
			panel6.add(textField_49);
			
			textField_50 = new JTextField();
			textField_50.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 4, 8);
				}
			});
			textField_50.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_50.setHorizontalAlignment(SwingConstants.CENTER);
			textField_50.setSize(new Dimension(40, 40));
			textField_50.setColumns(10);
			textField_50.setBounds(82, 42, 40, 40);
			panel6.add(textField_50);
			
			textField_51 = new JTextField();
			textField_51.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 6);
				}
			});
			textField_51.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_51.setHorizontalAlignment(SwingConstants.CENTER);
			textField_51.setSize(new Dimension(40, 40));
			textField_51.setColumns(10);
			textField_51.setBounds(2, 82, 40, 40);
			panel6.add(textField_51);
			
			textField_52 = new JTextField();
			textField_52.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 7);
				}
			});
			textField_52.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_52.setHorizontalAlignment(SwingConstants.CENTER);
			textField_52.setSize(new Dimension(40, 40));
			textField_52.setColumns(10);
			textField_52.setBounds(42, 82, 40, 40);
			panel6.add(textField_52);
			
			textField_53 = new JTextField();
			textField_53.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 5, 8);
				}
			});
			textField_53.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_53.setHorizontalAlignment(SwingConstants.CENTER);
			textField_53.setSize(new Dimension(40, 40));
			textField_53.setColumns(10);
			textField_53.setBounds(82, 82, 40, 40);
			panel6.add(textField_53);
		}
		return panel6;
	}
	private JPanel getPanel7() {
		if (panel7 == null) {
			panel7 = new JPanel();
			panel7.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel7.setLayout(null);
			
			textField_54 = new JTextField();
			textField_54.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 0);
				}
			});
			textField_54.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_54.setHorizontalAlignment(SwingConstants.CENTER);
			textField_54.setSize(new Dimension(40, 40));
			textField_54.setColumns(10);
			textField_54.setBounds(2, 2, 40, 40);
			panel7.add(textField_54);
			
			textField_55 = new JTextField();
			textField_55.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 1);
				}
			});
			textField_55.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_55.setHorizontalAlignment(SwingConstants.CENTER);
			textField_55.setSize(new Dimension(40, 40));
			textField_55.setColumns(10);
			textField_55.setBounds(42, 2, 40, 40);
			panel7.add(textField_55);
			
			textField_56 = new JTextField();
			textField_56.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 2);
				}
			});
			textField_56.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_56.setHorizontalAlignment(SwingConstants.CENTER);
			textField_56.setSize(new Dimension(40, 40));
			textField_56.setColumns(10);
			textField_56.setBounds(82, 2, 40, 40);
			panel7.add(textField_56);
			
			textField_57 = new JTextField();
			textField_57.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 0);
				}
			});
			textField_57.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_57.setHorizontalAlignment(SwingConstants.CENTER);
			textField_57.setSize(new Dimension(40, 40));
			textField_57.setColumns(10);
			textField_57.setBounds(2, 42, 40, 40);
			panel7.add(textField_57);
			
			textField_58 = new JTextField();
			textField_58.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 1);
				}
			});
			textField_58.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_58.setHorizontalAlignment(SwingConstants.CENTER);
			textField_58.setSize(new Dimension(40, 40));
			textField_58.setColumns(10);
			textField_58.setBounds(42, 42, 40, 40);
			panel7.add(textField_58);
			
			textField_59 = new JTextField();
			textField_59.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 2);
				}
			});
			textField_59.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_59.setHorizontalAlignment(SwingConstants.CENTER);
			textField_59.setSize(new Dimension(40, 40));
			textField_59.setColumns(10);
			textField_59.setBounds(82, 42, 40, 40);
			panel7.add(textField_59);
			
			textField_60 = new JTextField();
			textField_60.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 0);
				}
			});
			textField_60.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_60.setHorizontalAlignment(SwingConstants.CENTER);
			textField_60.setSize(new Dimension(40, 40));
			textField_60.setColumns(10);
			textField_60.setBounds(2, 82, 40, 40);
			panel7.add(textField_60);
			
			textField_61 = new JTextField();
			textField_61.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 1);
				}
			});
			textField_61.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_61.setHorizontalAlignment(SwingConstants.CENTER);
			textField_61.setSize(new Dimension(40, 40));
			textField_61.setColumns(10);
			textField_61.setBounds(42, 82, 40, 40);
			panel7.add(textField_61);
			
			textField_62 = new JTextField();
			textField_62.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 2);
				}
			});
			textField_62.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_62.setHorizontalAlignment(SwingConstants.CENTER);
			textField_62.setSize(new Dimension(40, 40));
			textField_62.setColumns(10);
			textField_62.setBounds(82, 82, 40, 40);
			panel7.add(textField_62);
		}
		return panel7;
	}
	private JPanel getPanel8() {
		if (panel8 == null) {
			panel8 = new JPanel();
			panel8.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' ')
						Funkcije.pauziraj(tajmer);
				}
			});
			panel8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel8.setLayout(null);
			
			textField_63 = new JTextField();
			textField_63.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 3);
				}
			});
			textField_63.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_63.setHorizontalAlignment(SwingConstants.CENTER);
			textField_63.setSize(new Dimension(40, 40));
			textField_63.setColumns(10);
			textField_63.setBounds(2, 2, 40, 40);
			panel8.add(textField_63);
			
			textField_64 = new JTextField();
			textField_64.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 4);
				}
			});
			textField_64.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_64.setHorizontalAlignment(SwingConstants.CENTER);
			textField_64.setSize(new Dimension(40, 40));
			textField_64.setColumns(10);
			textField_64.setBounds(42, 2, 40, 40);
			panel8.add(textField_64);
			
			textField_65 = new JTextField();
			textField_65.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 5);
				}
			});
			textField_65.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_65.setHorizontalAlignment(SwingConstants.CENTER);
			textField_65.setSize(new Dimension(40, 40));
			textField_65.setColumns(10);
			textField_65.setBounds(82, 2, 40, 40);
			panel8.add(textField_65);
			
			textField_66 = new JTextField();
			textField_66.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 3);
				}
			});
			textField_66.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_66.setHorizontalAlignment(SwingConstants.CENTER);
			textField_66.setSize(new Dimension(40, 40));
			textField_66.setColumns(10);
			textField_66.setBounds(2, 42, 40, 40);
			panel8.add(textField_66);
			
			textField_67 = new JTextField();
			textField_67.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 4);
				}
			});
			textField_67.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_67.setHorizontalAlignment(SwingConstants.CENTER);
			textField_67.setSize(new Dimension(40, 40));
			textField_67.setColumns(10);
			textField_67.setBounds(42, 42, 40, 40);
			panel8.add(textField_67);
			
			textField_68 = new JTextField();
			textField_68.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 5);
				}
			});
			textField_68.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_68.setHorizontalAlignment(SwingConstants.CENTER);
			textField_68.setSize(new Dimension(40, 40));
			textField_68.setColumns(10);
			textField_68.setBounds(82, 42, 40, 40);
			panel8.add(textField_68);
			
			textField_69 = new JTextField();
			textField_69.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 3);
				}
			});
			textField_69.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_69.setHorizontalAlignment(SwingConstants.CENTER);
			textField_69.setSize(new Dimension(40, 40));
			textField_69.setColumns(10);
			textField_69.setBounds(2, 82, 40, 40);
			panel8.add(textField_69);
			
			textField_70 = new JTextField();
			textField_70.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 4);
				}
			});
			textField_70.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_70.setHorizontalAlignment(SwingConstants.CENTER);
			textField_70.setSize(new Dimension(40, 40));
			textField_70.setColumns(10);
			textField_70.setBounds(42, 82, 40, 40);
			panel8.add(textField_70);
			
			textField_71 = new JTextField();
			textField_71.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 5);
				}
			});
			textField_71.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_71.setHorizontalAlignment(SwingConstants.CENTER);
			textField_71.setSize(new Dimension(40, 40));
			textField_71.setColumns(10);
			textField_71.setBounds(82, 82, 40, 40);
			panel8.add(textField_71);
		}
		return panel8;
	}
	private JPanel getPanel9() {
		if (panel9 == null) {
			panel9 = new JPanel();
			panel9.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==' '){
						Funkcije.pauziraj(tajmer);
					}
				}
			});
			panel9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel9.setLayout(null);
			
			textField_72 = new JTextField();
			textField_72.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 6);
				}
			});
			textField_72.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_72.setHorizontalAlignment(SwingConstants.CENTER);
			textField_72.setSize(new Dimension(40, 40));
			textField_72.setColumns(10);
			textField_72.setBounds(2, 2, 40, 40);
			panel9.add(textField_72);
			
			textField_73 = new JTextField();
			textField_73.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 7);
				}
			});
			textField_73.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_73.setHorizontalAlignment(SwingConstants.CENTER);
			textField_73.setSize(new Dimension(40, 40));
			textField_73.setColumns(10);
			textField_73.setBounds(42, 2, 40, 40);
			panel9.add(textField_73);
			
			textField_74 = new JTextField();
			textField_74.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 6, 8);
				}
			});
			textField_74.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_74.setHorizontalAlignment(SwingConstants.CENTER);
			textField_74.setSize(new Dimension(40, 40));
			textField_74.setColumns(10);
			textField_74.setBounds(82, 2, 40, 40);
			panel9.add(textField_74);
			
			textField_75 = new JTextField();
			textField_75.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 6);
				}
			});
			textField_75.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_75.setHorizontalAlignment(SwingConstants.CENTER);
			textField_75.setSize(new Dimension(40, 40));
			textField_75.setColumns(10);
			textField_75.setBounds(2, 42, 40, 40);
			panel9.add(textField_75);
			
			textField_76 = new JTextField();
			textField_76.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 7);
				}
			});
			textField_76.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_76.setHorizontalAlignment(SwingConstants.CENTER);
			textField_76.setSize(new Dimension(40, 40));
			textField_76.setColumns(10);
			textField_76.setBounds(42, 42, 40, 40);
			panel9.add(textField_76);
			
			textField_77 = new JTextField();
			textField_77.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 7, 8);
				}
			});
			textField_77.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_77.setHorizontalAlignment(SwingConstants.CENTER);
			textField_77.setSize(new Dimension(40, 40));
			textField_77.setColumns(10);
			textField_77.setBounds(82, 42, 40, 40);
			panel9.add(textField_77);
			
			textField_78 = new JTextField();
			textField_78.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 6);
				}
			});
			textField_78.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_78.setHorizontalAlignment(SwingConstants.CENTER);
			textField_78.setSize(new Dimension(40, 40));
			textField_78.setColumns(10);
			textField_78.setBounds(2, 82, 40, 40);
			panel9.add(textField_78);
			
			textField_79 = new JTextField();
			textField_79.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 7);
				}
			});
			textField_79.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_79.setHorizontalAlignment(SwingConstants.CENTER);
			textField_79.setSize(new Dimension(40, 40));
			textField_79.setColumns(10);
			textField_79.setBounds(42, 82, 40, 40);
			panel9.add(textField_79);
			
			textField_80 = new JTextField();
			textField_80.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					provera(arg0, 8, 8);
				}
			});
			textField_80.setFont(new Font("Times New Roman", Font.PLAIN, 34));
			textField_80.setHorizontalAlignment(SwingConstants.CENTER);
			textField_80.setSize(new Dimension(40, 40));
			textField_80.setColumns(10);
			textField_80.setBounds(82, 82, 40, 40);
			panel9.add(textField_80);
		}
		return panel9;
	}

	/**
	 * Metoda koja za odredjeno polje proverava da li je uneseni karakter dozvoljen i ukoliko nije bice ponisten,
	 * ukoliko je dozvoljen bice unesen u niz brojeva.
	 * @param arg0 argument koji se dobija od actionListener-a, sadrzi karakter koji se proverava.
	 * @param x predstavlja x koordinatu polja.
	 * @param y predstavlja y koordinatu polja.
	 */
	private void provera(KeyEvent arg0, int x, int y) {
		char c = arg0.getKeyChar();
		  if (!((c >= '1') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) || (matricaPolja[x][y].getText().length() >= 1)) {
			  arg0.consume();
		  } else if ((c >= '1') && (c <= '9')) {
			  gen.unesiBroj(Integer.parseInt(arg0.getKeyChar() + ""), x, y);
		  }
		  if(c==' ') {
			  Funkcije.pauziraj(tajmer);
		  }
	}
}
