package Lab_01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTankConfig extends JFrame {

	private FormTankConfig frame;
	private JPanel contentPane;
	private JLabel labelLightTank;
	private JLabel labelHeavyTank;
	private String strType;
	static ITransport tank;
	private JPanel panelTank;
	private JLabel labelMainColor;
	private JLabel labelDopColor;
	private JPanel panelColors;
	private JPanel panelBlack;
	private JPanel panelWhite;
	private JPanel panelGreen;
	private JPanel panelBlue;
	private JPanel panelRed;
	private JPanel panelYellow;
	private JPanel panelPink;
	private JPanel panelCyan;
	private Color color;
	private HeavyTank tunk;
	private String str;
	private JButton buttonOk;
	private JButton buttonCancel;
	static Boolean y = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTankConfig frame = new FormTankConfig();
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
	public FormTankConfig() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTrans = new JPanel();
		panelTrans.setToolTipText("");
		panelTrans.setLayout(null);
		panelTrans.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTrans.setBackground(SystemColor.menu);
		panelTrans.setBounds(10, 11, 188, 92);
		contentPane.add(panelTrans);

		labelLightTank = new JLabel(
				"\u0411\u0440\u043E\u043D\u0438\u0440\u043E\u0432\u0430\u043D\u043D\u0430\u044F \u043C\u0430\u0448\u0438\u043D\u0430");
		labelLightTank.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				strType = labelLightTank.getText();
			}
		});

		labelLightTank.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelLightTank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLightTank.setHorizontalAlignment(SwingConstants.CENTER);
		labelLightTank.setBounds(10, 11, 168, 27);
		panelTrans.add(labelLightTank);

		labelHeavyTank = new JLabel("\u0422\u0430\u043D\u043A");
		labelHeavyTank.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				strType = labelHeavyTank.getText();
			}
		});
		labelHeavyTank.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelHeavyTank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelHeavyTank.setHorizontalAlignment(SwingConstants.CENTER);
		labelHeavyTank.setBounds(10, 49, 168, 27);
		panelTrans.add(labelHeavyTank);

		panelTank = new JPanel();
		panelTank.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTank.setBounds(234, 11, 174, 176);
		contentPane.add(panelTank);
		panelTank.setLayout(null);

		JPanelDraw panelDraw = new JPanelDraw();
		panelDraw.setBounds(32, 11, 103, 81);
		panelTank.add(panelDraw);
		panelDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (strType != null) {
					switch (strType) {
					case "Танк":
						tank = new HeavyTank(panelDraw.getWidth(), panelDraw.getHeight(), Color.WHITE, Color.BLACK,
								true, true);
						break;
					case "Бронированная машина":
						tank = new LightTank(panelDraw.getWidth(), panelDraw.getHeight(), Color.WHITE);
						break;
					}
					panelDraw.setTransport(tank);
					panelDraw.repaint();
					str = strType;
					strType = null;
				}
			}
		});
		panelDraw.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDraw.setDropTarget(getDropTarget());

		labelMainColor = new JLabel("\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442");
		labelMainColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if ((tank != null) && (color != null)) {
					tank.setMainColor(color);
					panelDraw.setTransport(tank);
					panelDraw.repaint();
					color = null;
				}
			}
		});
		labelMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelMainColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainColor.setBounds(10, 114, 154, 19);
		panelTank.add(labelMainColor);

		labelDopColor = new JLabel(
				"\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442");
		labelDopColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if ((tank != null) && (color != null)) {
					if (str == "Танк") {
						tunk = (HeavyTank) tank;
						tunk.setDopColor(color);
						tank = tunk;
						;
						panelDraw.setTransport(tank);
						panelDraw.repaint();
						color = null;
					}
				}
			}
		});
		labelDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDopColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDopColor.setBounds(10, 144, 154, 19);
		panelTank.add(labelDopColor);

		panelColors = new JPanel();
		panelColors.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelColors.setBounds(447, 11, 110, 191);
		contentPane.add(panelColors);
		panelColors.setLayout(null);

		panelBlack = new JPanel();
		panelBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelBlack.getBackground();
			}
		});

		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlack.setBounds(10, 11, 38, 34);
		panelColors.add(panelBlack);

		panelWhite = new JPanel();
		panelWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelWhite.getBackground();
			}
		});
		panelWhite.setBackground(Color.WHITE);
		panelWhite.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelWhite.setBounds(62, 11, 38, 34);
		panelColors.add(panelWhite);

		panelGreen = new JPanel();
		panelGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelGreen.getBackground();
			}
		});
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGreen.setBounds(10, 56, 38, 34);
		panelColors.add(panelGreen);

		panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelBlue.getBackground();
			}
		});
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlue.setBounds(62, 56, 38, 34);
		panelColors.add(panelBlue);

		panelRed = new JPanel();
		panelRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelRed.getBackground();
			}
		});
		panelRed.setBackground(Color.RED);
		panelRed.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRed.setBounds(10, 101, 38, 34);
		panelColors.add(panelRed);

		panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelYellow.getBackground();
			}
		});
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelYellow.setBounds(62, 101, 38, 34);
		panelColors.add(panelYellow);

		panelPink = new JPanel();
		panelPink.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelPink.getBackground();
			}
		});
		panelPink.setBackground(Color.PINK);
		panelPink.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPink.setBounds(10, 146, 38, 34);
		panelColors.add(panelPink);

		panelCyan = new JPanel();
		panelCyan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				color = panelCyan.getBackground();
			}
		});
		panelCyan.setBackground(Color.CYAN);
		panelCyan.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCyan.setBounds(62, 146, 38, 34);
		panelColors.add(panelCyan);

		buttonOk = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				y = true;
			}
			
		});
		buttonOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonOk.setBounds(25, 148, 100, 33);
		contentPane.add(buttonOk);
		buttonOk.addActionListener(e -> this.dispose());

		buttonCancel = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		buttonCancel.addActionListener(e -> this.dispose());

		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonCancel.setBounds(92, 185, 100, 33);
		contentPane.add(buttonCancel);
	}
}
