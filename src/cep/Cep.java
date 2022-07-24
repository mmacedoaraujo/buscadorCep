package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

@SuppressWarnings("serial")
public class Cep extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField textEndereco;
	private JTextField textBairro;
	private JTextField textCidade;
	private JComboBox comboBoxUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
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
	public Cep() {
		setTitle("Buscar CEP");
		setResizable(false);
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/home.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCep = new JTextField();
		txtCep.setBounds(50, 27, 132, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBackground(SystemColor.text);
		textEndereco.setBounds(88, 84, 323, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);

		textBairro = new JTextField();
		textBairro.setBounds(88, 131, 323, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);

		textCidade = new JTextField();
		textCidade.setBounds(88, 182, 223, 20);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblNewLabel_3_3 = new JLabel("CEP");
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3.setBounds(10, 25, 54, 20);
		contentPane.add(lblNewLabel_3_3);

		comboBoxUF = new JComboBox();
		comboBoxUF.setBackground(SystemColor.text);
		comboBoxUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		comboBoxUF.setBounds(348, 181, 54, 22);
		contentPane.add(comboBoxUF);

		JButton btnCEP = new JButton("Buscar");
		btnCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnCEP.setForeground(Color.BLACK);
		btnCEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCEP.setBackground(SystemColor.menu);
		btnCEP.setBounds(232, 25, 89, 20);
		contentPane.add(btnCEP);

		JLabel lblNewLabel_3_3_1 = new JLabel("Endereço");
		lblNewLabel_3_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3_1.setBounds(10, 84, 78, 20);
		contentPane.add(lblNewLabel_3_3_1);

		JLabel lblNewLabel_3_3_2 = new JLabel("Bairro");
		lblNewLabel_3_3_2.setForeground(Color.BLACK);
		lblNewLabel_3_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3_2.setBounds(10, 131, 54, 20);
		contentPane.add(lblNewLabel_3_3_2);

		JLabel lblNewLabel_3_3_3 = new JLabel("Cidade");
		lblNewLabel_3_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3_3.setBounds(10, 182, 54, 20);
		contentPane.add(lblNewLabel_3_3_3);

		JLabel lblNewLabel_3_3_4 = new JLabel("UF");
		lblNewLabel_3_3_4.setForeground(Color.BLACK);
		lblNewLabel_3_3_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3_4.setBounds(321, 182, 37, 18);
		contentPane.add(lblNewLabel_3_3_4);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);

			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/help.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setForeground(SystemColor.control);
		btnSobre.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnSobre.setBackground(SystemColor.menu);
		btnSobre.setBounds(392, 218, 32, 32);
		contentPane.add(btnSobre);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBackground(SystemColor.menu);
		btnLimpar.setBounds(18, 227, 89, 25);
		contentPane.add(btnLimpar);

		/* Uso da biblioteca Atxy2k para validação do campo txtCep */

		RestrictedTextField validar = new RestrictedTextField(txtCep);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	}

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					textCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					textBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					comboBoxUF.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {

					} else {

						JOptionPane.showMessageDialog(null, "CEP não encontrado.");
					}
				}

				textEndereco.setText(tipoLogradouro + " " + logradouro);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	private void limpar() {
		textCidade.setText(null);
		textBairro.setText(null);
		textEndereco.setText(null);
		txtCep.setText(null);
		comboBoxUF.setSelectedItem(null);
		txtCep.requestFocus();

	}
}
