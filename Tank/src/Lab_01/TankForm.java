package Lab_01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TankForm extends JFrame {

	private JPanel contentPane;
	private ITransport tank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TankForm frame = new TankForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			if (tank != null) {
				tank.DrawTank(g);
			}
		} catch (Exception ex) {

		}
	}

	public void moveButton(JButton sender) {
		try {
			String name = sender.getToolTipText();
			switch (name) {
			case "Up":
				tank.MoveTank(Direction.Up);
				break;
			case "Down":
				tank.MoveTank(Direction.Down);
				break;
			case "Left":
				tank.MoveTank(Direction.Left);
				break;
			case "Right":
				tank.MoveTank(Direction.Right);
				break;
			}
			this.repaint();
		} catch (Exception ex) {
			System.out.print("Draw first! \n");
		}
	}

	/**
	 * Create the frame.
	 */

	public TankForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton buttonCreate = new JButton("Draw HeavyTank");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tank = new HeavyTank(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
							new Color(135, 192, 0), new Color(85, 107, 47), true, true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					tank.SetPosition(70 + (int) (Math.random() * 60), 70 + (int) (Math.random() * 160),
							TankForm.this.getWidth(), TankForm.this.getHeight());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				TankForm.this.repaint();

			}
		});
		buttonCreate.setBounds(10, 11, 150, 42);
		contentPane.add(buttonCreate);

		JButton buttonCreateBase = new JButton("Draw LightTank");
		buttonCreateBase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tank = new LightTank(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
							new Color(135, 192, 0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					tank.SetPosition(70 + (int) (Math.random() * 160), 70 + (int) (Math.random() * 160),
							TankForm.this.getWidth(), TankForm.this.getHeight());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				TankForm.this.repaint();
			}
		});
		buttonCreateBase.setBounds(170, 11, 150, 42);
		contentPane.add(buttonCreateBase);

		JButton buttonUp = new JButton("");
		buttonUp.setToolTipText("Up");
		buttonUp.setIcon(new ImageIcon(TankForm.class.getResource("/up.png")));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonUp);
			}
		});
		buttonUp.setBounds(515, 215, 65, 65);
		contentPane.add(buttonUp);

		JButton buttonLeft = new JButton("");
		buttonLeft.setToolTipText("Left");
		buttonLeft.setIcon(new ImageIcon(TankForm.class.getResource("/left.png")));
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonLeft);
			}
		});
		buttonLeft.setBounds(440, 291, 65, 65);
		contentPane.add(buttonLeft);

		JButton buttonDown = new JButton("");
		buttonDown.setToolTipText("Down");
		buttonDown.setIcon(new ImageIcon(TankForm.class.getResource("/down.png")));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonDown);
			}
		});
		buttonDown.setBounds(515, 291, 65, 65);
		contentPane.add(buttonDown);

		JButton buttonRight = new JButton("");
		buttonRight.setToolTipText("Right");
		buttonRight.setIcon(new ImageIcon(TankForm.class.getResource("/right.png")));
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonRight);
			}
		});
		buttonRight.setBounds(590, 291, 65, 65);
		contentPane.add(buttonRight);
	}
}