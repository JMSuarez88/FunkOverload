package FrontEnd;

import javax.swing.*;

import BackEnd.Servidor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener,WindowListener{
	
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu accion;
	private JMenuItem create,exit;
	private Servidor s;
	
	private JTextArea areaLogs;
	
	public JTextArea getAreaLogs() {
		return areaLogs;
	}

	private JTextField text;
	private JButton send;
	private JScrollPane scroll;
	
	public MainWindow(){
		super("Server");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,600);
		this.addWindowListener(this);
		this.setComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		s = Servidor.getInstance();
		s.setMw(this);
	}
	
	public void setComponents(){
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		accion = new JMenu("Acci�n");
		menuBar.add(accion);
		create = new JMenuItem("Crear Servidor");
		create.addActionListener(this);
		accion.add(create);
		exit = new JMenuItem("Salir");
		exit.addActionListener(this);
		accion.add(exit);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		areaLogs = new JTextArea();
		areaLogs.setEditable(false);
		scroll = new JScrollPane(areaLogs);
		this.add(scroll,gbc);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==create){
			s.StartServer();
			Thread t = new Thread(s);
			t.start();
		}else if(ae.getSource()==exit){
			this.dispose();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		s.closeServer();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



}
