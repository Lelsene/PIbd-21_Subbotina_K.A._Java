package Lab_01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FormGarage extends JFrame {

	JFrame frame;

	private JPanel contentPane;

	private JTextField textField;

	private static ITransport tank;

	private static JList list;

	private static MultiLevelGarage garage;

	private final int countLevel = 5;

	private TankConfig select;

	private String[] elements = new String[6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormGarage frame = new FormGarage();
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
	@SuppressWarnings("unchecked")
	public FormGarage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 561);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filesave = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
				filesave.setFileFilter(filter);
				if (filesave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = filesave.getSelectedFile();
					String path = file.getAbsolutePath();
					if (garage.save(path)) {
						JOptionPane.showMessageDialog(null, "Saved");
						return;
					} else {
						JOptionPane.showMessageDialog(null, "Save failed", "", 0, null);
					}
				}
			}
		});
		menuFile.add(menuSave);

		JMenuItem menuLoad = new JMenuItem("Load");
		menuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						if (garage.load(file.getAbsolutePath())) {
							JOptionPane.showMessageDialog(null, "Loaded");
						} else {
							JOptionPane.showMessageDialog(null, "Load failed", "", 0, null);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "", 0, null);
					}
					contentPane.repaint();
				}
			}
		});
		menuFile.add(menuLoad);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanelGarage panelGarage = new JPanelGarage();
		panelGarage.setBounds(10, 11, 634, 483);
		contentPane.add(panelGarage);

		list = new JList(elements);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(665, 8, 206, 107);
		contentPane.add(list);

		JButton btnLevelDown = new JButton("Down");
		btnLevelDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				garage.levelDown();
				list.setSelectedIndex(garage.getCurrentLevel());
				panelGarage.repaint();
			}
		});
		btnLevelDown.setBounds(716, 126, 96, 32);
		contentPane.add(btnLevelDown);

		JButton btnLevelUp = new JButton("Up");
		btnLevelUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				garage.levelUp();
				list.setSelectedIndex(garage.getCurrentLevel());
				panelGarage.repaint();
			}
		});
		btnLevelUp.setBounds(716, 163, 96, 34);
		contentPane.add(btnLevelUp);

		for (int i = 0; i < 5; i++) {
			elements[i] = "Level " + (i + 1);
		}

		garage = new MultiLevelGarage(countLevel, panelGarage.getWidth(), panelGarage.getHeight());
		panelGarage.setGarage(garage);
		panelGarage.setList(list);

		JPanel panelGroupElements = new JPanel();
		panelGroupElements.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGroupElements.setBackground(new Color(250, 235, 215));
		panelGroupElements.setBounds(668, 304, 206, 190);
		contentPane.add(panelGroupElements);
		panelGroupElements.setLayout(null);

		JLabel lblPlace = new JLabel("Place:");
		lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlace.setBounds(10, 8, 50, 23);
		panelGroupElements.add(lblPlace);

		JPanelDraw panelTakeTank = new JPanelDraw();
		panelTakeTank.setBounds(20, 73, 165, 103);
		panelGroupElements.add(panelTakeTank);

		JButton buttonTakeTank = new JButton("Take");
		buttonTakeTank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonTakeTank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() == -1) {
					return;
				}
				int numberOfPlace = 0;
				try {
					numberOfPlace = Integer.parseInt(textField.getText());
				} catch (Exception ex) {
					textField.setText("Invalid input");
					return;
				}
				if (numberOfPlace >= garage.getGarage(list.getSelectedIndex()).places.size() || numberOfPlace < 0) {
					textField.setText("Invalid input");
					return;
				}
				tank = garage.getGarage(list.getSelectedIndex()).removeTank(numberOfPlace);
				if (tank != null) {
					tank.SetPosition(5, 5, panelTakeTank.getWidth(), panelTakeTank.getHeight());
				}
				panelTakeTank.setTransport(tank);
				panelTakeTank.repaint();
				panelGarage.repaint();
			}
		});
		buttonTakeTank.setBounds(20, 39, 176, 23);
		panelGroupElements.add(buttonTakeTank);

		textField = new JTextField();
		textField.setBounds(60, 11, 136, 20);
		panelGroupElements.add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTank();
			}
		});
		btnAdd.setBounds(668, 255, 206, 38);
		contentPane.add(btnAdd);
	}

	public void getTank() {
		select = new TankConfig(frame);
		if (select.res()) {
			ITransport tank = select.getTank();
			int place = garage.getGarage(list.getSelectedIndex()).addTank(tank);
			if (place < 0) {
				JOptionPane.showMessageDialog(null, "No free place");
			}
			contentPane.repaint();
		}
	}
}