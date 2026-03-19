package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public Frame(Screen screen, Mouse mouse) {
		
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new Mouse());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.addMouseListener(mouse);
		contentPane.addMouseMotionListener(mouse);
		contentPane.addMouseWheelListener(mouse);
		setContentPane(contentPane);
		
		label = new JLabel(new ImageIcon(screen.image));
		contentPane.add(label);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

}
