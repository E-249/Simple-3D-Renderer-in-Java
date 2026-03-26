package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Logic;
import model.Cube;
import model.Point;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Logic logic;
	private Renderer renderer;

	/**
	 * Create the frame.
	 */
	public Frame(int size, Logic logic) {
		this.logic = logic;
		this.renderer = new Renderer(size);
		
		Keyboard keyboard = new Keyboard();
		Mouse mouse = new Mouse();
		
		JPanel contentPane = new JPanel();
		contentPane.addMouseMotionListener(new Mouse());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.addKeyListener(keyboard);
		contentPane.addMouseListener(mouse);
		contentPane.addMouseMotionListener(mouse);
		contentPane.addMouseWheelListener(mouse);
		setContentPane(contentPane);
		
		JLabel screen = new JLabel(new ImageIcon(renderer.getImage()));
		contentPane.add(screen);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void update() {
		renderer.clear();
		perFrame();
		this.repaint();
	}
	
	private void drawLine(Point a, Point b) {
		
		double fov = 1.0;
		
		double xa = a.x() / a.z() * fov;
		double ya = a.y() / a.z() * fov;
		double xb = b.x() / b.z() * fov;
		double yb = b.y() / b.z() * fov;
		
		renderer.virtualDrawLineAt(xa, ya, xb, yb);
	}
	
	private void drawCube(Cube cube) {
		drawLine(cube.getFarLowerLeft(), cube.getFarLowerRight());
		drawLine(cube.getFarLowerLeft(), cube.getFarUpperLeft());
		drawLine(cube.getFarLowerLeft(), cube.getNearLowerLeft());
		
		drawLine(cube.getFarLowerRight(), cube.getNearLowerRight());
		drawLine(cube.getFarLowerRight(), cube.getFarUpperRight());
		
		drawLine(cube.getNearUpperRight(), cube.getNearUpperLeft());
		drawLine(cube.getNearUpperRight(), cube.getNearLowerRight());
		drawLine(cube.getNearUpperRight(), cube.getFarUpperRight());
		
		drawLine(cube.getNearUpperLeft(), cube.getNearLowerLeft());
		drawLine(cube.getNearUpperLeft(), cube.getFarUpperLeft());
		
		drawLine(cube.getFarUpperLeft(), cube.getFarUpperRight());
		drawLine(cube.getNearLowerLeft(), cube.getNearLowerRight());
	}
	
	private void perFrame() {
		logic.forEachInWorld((p) -> renderer.virtualFillSquareAt(
			p.x() / p.z(),
			p.y() / p.z(),
			0.02 / p.z()
		));
		logic.forEachCubeInWorld(this::drawCube);
	}
	
	private class Keyboard implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			final double distance = 0.04;
			
			switch (e.getKeyCode()) {
			
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W: {
				logic.moveCube(0, +distance, 0);
			} break;
			
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S: {
				logic.moveCube(0, -distance, 0);
			} break;
			
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D: {
				logic.moveCube(+distance, 0, 0);
			} break;
			
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A: {
				logic.moveCube(-distance, 0, 0);
			} break;
			
			case KeyEvent.VK_Q: {
				logic.moveCube(0, 0, +distance);
			} break;
			
			case KeyEvent.VK_E: {
				logic.moveCube(0, 0, -distance);
			} break;
			
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
		
		/* MouseListener */
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		/* MouseMotionListener */

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		/* MouseWheelListener */

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}


}
