package Lab_01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class TankConfig extends JDialog {

	ITransport tank;
	JPanel panel;
	boolean r;

	Color color;
	Color dopColor;
	int maxSpeed;

	public TankConfig(JFrame parent) {
		super(parent, true);
		initialize();
	}

	public boolean res() {
		setVisible(true);
		return r;
	}

	private void initialize() {
		this.getContentPane().setBackground(SystemColor.controlHighlight);
		this.setBounds(100, 100, 470, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);

		JLabel lblLightTank = new JLabel("LightTank");
		lblLightTank.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLightTank.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLightTank.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightTank.setBounds(27, 29, 96, 24);
		this.getContentPane().add(lblLightTank);

		JLabel lblHeavyTank = new JLabel("HeavyTank");
		lblHeavyTank.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHeavyTank.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeavyTank.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeavyTank.setBounds(27, 64, 96, 24);
		this.getContentPane().add(lblHeavyTank);

		MouseListener mouseL = new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JComponent jc = (JComponent) e.getSource();
				TransferHandler th = jc.getTransferHandler();
				th.exportAsDrag(jc, e, TransferHandler.COPY);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		};

		lblLightTank.addMouseListener(mouseL);
		lblHeavyTank.addMouseListener(mouseL);
		lblHeavyTank.setTransferHandler(new TransferHandler("text"));
		lblLightTank.setTransferHandler(new TransferHandler("text"));

		JPanel panelYellow = new JPanel();
		panelYellow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelYellow.setName("yellow");
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(329, 29, 35, 34);
		this.getContentPane().add(panelYellow);

		JPanel panelBlue = new JPanel();
		panelBlue.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlue.setName("blue");
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(374, 29, 35, 34);
		this.getContentPane().add(panelBlue);

		JPanel panelRed = new JPanel();
		panelRed.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRed.setName("red");
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(329, 74, 35, 34);
		this.getContentPane().add(panelRed);

		JPanel panelGreen = new JPanel();
		panelGreen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGreen.setName("green");
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(374, 74, 35, 34);
		this.getContentPane().add(panelGreen);

		JPanel panelBlack = new JPanel();
		panelBlack.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlack.setName("black");
		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBounds(329, 116, 35, 34);
		this.getContentPane().add(panelBlack);

		JPanel panelPink = new JPanel();
		panelPink.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPink.setName("pink");
		panelPink.setBackground(Color.PINK);
		panelPink.setBounds(374, 116, 35, 34);
		this.getContentPane().add(panelPink);

		JPanel panelMagenta = new JPanel();
		panelMagenta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMagenta.setName("magenta");
		panelMagenta.setBackground(Color.MAGENTA);
		panelMagenta.setBounds(329, 161, 35, 34);
		this.getContentPane().add(panelMagenta);

		JPanel panelCyan = new JPanel();
		panelCyan.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCyan.setName("cyan");
		panelCyan.setBackground(Color.CYAN);
		panelCyan.setBounds(374, 161, 35, 34);
		this.getContentPane().add(panelCyan);

		panelYellow.addMouseListener(mouseL);
		panelYellow.setTransferHandler(new TransferHandler("name"));

		panelBlue.addMouseListener(mouseL);
		panelBlue.setTransferHandler(new TransferHandler("name"));

		panelRed.addMouseListener(mouseL);
		panelRed.setTransferHandler(new TransferHandler("name"));

		panelGreen.addMouseListener(mouseL);
		panelGreen.setTransferHandler(new TransferHandler("name"));

		panelBlack.addMouseListener(mouseL);
		panelBlack.setTransferHandler(new TransferHandler("name"));

		panelPink.addMouseListener(mouseL);
		panelPink.setTransferHandler(new TransferHandler("name"));

		panelMagenta.addMouseListener(mouseL);
		panelMagenta.setTransferHandler(new TransferHandler("name"));

		panelCyan.addMouseListener(mouseL);
		panelCyan.setTransferHandler(new TransferHandler("name"));

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = true;
				dispose();
			}
		});
		btnAdd.setBounds(27, 161, 90, 24);
		this.getContentPane().add(btnAdd);

		JButton btnNO = new JButton("Cancel");
		btnNO.setBounds(59, 187, 89, 23);
		this.getContentPane().add(btnNO);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(158, 11, 146, 216);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 11, 126, 90);
		panel_1.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setDropTarget(new DropTarget() {
			public void drop(DropTargetDropEvent e) {
				try {
					for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
						if (e.getTransferable().getTransferData(df) == "LightTank") {
							tank = new LightTank(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
									Color.WHITE);
						} else if (e.getTransferable().getTransferData(df) == "HeavyTank") {
							tank = new HeavyTank(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
									Color.WHITE, Color.BLACK, true, true);
						}
						draw(panel, tank);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel lblMainColor = new JLabel("Main Color");
		lblMainColor.setBounds(25, 122, 90, 27);
		panel_1.add(lblMainColor);
		lblMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainColor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblMainColor.setDropTarget(new DropTarget() {
			public void drop(DropTargetDropEvent e) {
				if (tank != null) {
					try {
						for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
							tank.setMainColor((selectColor(e.getTransferable().getTransferData(df).toString())));
							draw(panel, tank);
						}
					} catch (Exception ex) {
						System.out.println(ex + "FF");
					}
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel lblDopColor = new JLabel("Dop Color");
		lblDopColor.setBounds(25, 160, 90, 27);
		panel_1.add(lblDopColor);
		lblDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDopColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDopColor.setDropTarget(new DropTarget() {
			public void drop(DropTargetDropEvent e) {
				if (tank != null) {
					try {
						for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
							((HeavyTank) tank)
									.setDopColor((selectColor(e.getTransferable().getTransferData(df).toString())));
							draw(panel, tank);
						}
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNO.addActionListener((ActionEvent e) -> {
			r = false;
			dispose();
		});
	}

	public ITransport getTank() {
		return tank;
	}

	public void draw(JPanel panel, ITransport tank) {
		if (tank != null) {
			Graphics gr = panel.getGraphics();
			gr.clearRect(0, 0, panel.getWidth(), panel.getHeight());
			tank.SetPosition(5, 5, panel.getWidth(), panel.getHeight());
			tank.DrawTank(gr);
		}
	}

	public static Color selectColor(String s) {
		switch (s) {
		case "yellow":
			return Color.yellow;
		case "blue":
			return Color.blue;
		case "red":
			return Color.red;
		case "green":
			return Color.green;
		case "black":
			return Color.black;
		case "pink":
			return Color.pink;
		case "magenta":
			return Color.magenta;
		case "cyan":
			return Color.cyan;
		}
		return null;
	}
}