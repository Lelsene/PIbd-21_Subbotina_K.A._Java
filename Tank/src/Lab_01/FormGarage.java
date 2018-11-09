package Lab_01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
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

public class FormGarage extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;

	private ITransport tank;
	
	private MultiLevelGarage garage;

	private final int countLevel = 5;

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
	public FormGarage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanelGarage panelGarage = new JPanelGarage();
		panelGarage.setBounds(10, 11, 627, 483);
		contentPane.add(panelGarage);
		
		DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < countLevel; i++) {
            listModel.addElement("\u0423\u0440\u043E\u0432\u0435\u043D\u044C " + Integer.toString(i + 1));
        }
         JList list = new JList(listModel);
        list.setBounds(668, 11, 206, 107);
        contentPane.add(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setSelectedIndex(0);
        
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                panelGarage.repaint();
            }
        };
        list.addListSelectionListener(listSelectionListener);

        garage = new MultiLevelGarage(countLevel, panelGarage.getWidth(), panelGarage.getHeight());
		panelGarage.setGarage(garage);
		panelGarage.setList(list);

		
		JButton buttonSetHeavyTank = new JButton("\u0422\u0430\u043D\u043A");
		buttonSetHeavyTank.setFont(new Font("Verdana", Font.ITALIC, 13));
		buttonSetHeavyTank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
				Color secondColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
				tank = new HeavyTank(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), firstColor,
						secondColor, true, true);
				int place = garage.getGarage(list.getSelectedIndex()).addTank(tank);
                if (place == -1) {
                    JOptionPane.showMessageDialog(null, "��� ��������� ����");
                }
				panelGarage.repaint();
			}
		});
		buttonSetHeavyTank.setBounds(668, 204, 206, 40);
		contentPane.add(buttonSetHeavyTank);

		JButton buttonSetLightTank = new JButton(
				"\u0411\u0440\u043E\u043D\u0438\u0440\u043E\u0432\u0430\u043D\u043D\u0430\u044F \u043C\u0430\u0448\u0438\u043D\u0430");
		buttonSetLightTank.setFont(new Font("Verdana", Font.ITALIC, 13));
		buttonSetLightTank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
				tank = new LightTank(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
						firstColor);
				int place = garage.getGarage(list.getSelectedIndex()).addTank(tank);
                if (place == -1) {
                    JOptionPane.showMessageDialog(null, "��� ��������� ����");
                }
				panelGarage.repaint();
			}
		});
		buttonSetLightTank.setBounds(668, 129, 206, 68);
		contentPane.add(buttonSetLightTank);

		JPanel panelGroupElements = new JPanel();
		panelGroupElements.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGroupElements.setBackground(new Color(250, 235, 215));
		panelGroupElements.setBounds(668, 304, 206, 190);
		contentPane.add(panelGroupElements);
		panelGroupElements.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
		lblNewLabel.setBounds(10, 14, 50, 14);
		panelGroupElements.add(lblNewLabel);

		JPanelDraw panelTakeTank = new JPanelDraw();
		panelTakeTank.setBounds(20, 73, 165, 103);
		panelGroupElements.add(panelTakeTank);

		JButton buttonTakeTank = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
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
	}
}