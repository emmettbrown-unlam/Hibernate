package base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends javax.swing.JDialog  {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsuario;
	private JTextField textFieldNick;
	private JPasswordField passwordFieldContraseña;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Registro dialog = new Registro();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Registro(javax.swing.JDialog loguearse,Usuario usuario,GestionBD gestionBD) {
		super(loguearse);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Usuario");
			lblNewLabel.setBounds(28, 11, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldUsuario = new JTextField();
			textFieldUsuario.setBounds(218, 8, 86, 20);
			contentPanel.add(textFieldUsuario);
			textFieldUsuario.setColumns(10);
		}
		{
			textFieldNick = new JTextField();
			textFieldNick.setColumns(10);
			textFieldNick.setBounds(218, 103, 86, 20);
			contentPanel.add(textFieldNick);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_1.setBounds(28, 58, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setBounds(220, 55, 86, 20);
		contentPanel.add(passwordFieldContraseña);
		
		JLabel lblMail = new JLabel("nick");
		lblMail.setBounds(28, 111, 46, 14);
		contentPanel.add(lblMail);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						usuario.setContraseña(passwordFieldContraseña.getSelectedText());
						usuario.setUsuario(textFieldUsuario.getText());
						gestionBD.insertarRegistro(usuario);
						//loguearse.dispose();
						//loguearse.setModal(false);
						//usuario.setNick(textFieldNick.getText());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
