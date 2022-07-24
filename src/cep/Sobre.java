package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 /**
	 * Create the dialog.
	 */
	public Sobre() {
	 	setModal(true);
		getContentPane().setBackground(SystemColor.menu);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Cep - Ver 1.0");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(45, 66, 364, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAuthorMarcosMacdo_1 = new JLabel("Author Marcos Macêdo");
		lblAuthorMarcosMacdo_1.setForeground(Color.BLACK);
		lblAuthorMarcosMacdo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthorMarcosMacdo_1.setBounds(45, 107, 364, 39);
		getContentPane().add(lblAuthorMarcosMacdo_1);
		
		JLabel lblAuthorMarcosMacdo_1_1 = new JLabel("Web Service:");
		lblAuthorMarcosMacdo_1_1.setForeground(Color.BLACK);
		lblAuthorMarcosMacdo_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthorMarcosMacdo_1_1.setBounds(45, 146, 111, 39);
		getContentPane().add(lblAuthorMarcosMacdo_1_1);
		
		JLabel labelWebService = new JLabel("www.republicavirtual.com.br");
		labelWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br/");
			}
		});
		labelWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelWebService.setForeground(SystemColor.textHighlight);
		labelWebService.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelWebService.setBounds(165, 146, 213, 39);
		getContentPane().add(labelWebService);
		
		JButton btnBuscar_1_1 = new JButton("");
		btnBuscar_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar_1_1.setIcon(new ImageIcon(Sobre.class.getResource("/img/github-sign (1).png")));
		btnBuscar_1_1.setToolTipText("GitHub");
		btnBuscar_1_1.setForeground(SystemColor.menu);
		btnBuscar_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnBuscar_1_1.setBorder(null);
		btnBuscar_1_1.setBackground(Color.LIGHT_GRAY);
		btnBuscar_1_1.setBounds(230, 107, 32, 32);
		getContentPane().add(btnBuscar_1_1);

	}
	
	private void link(String site) {
		
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
