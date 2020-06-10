package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Oficina;
import utilitarios.LtpLib;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class TelaExibicao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableVeiculos;
	private JScrollPane scrollPaneVeiculos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibicao frame = new TelaExibicao();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public TelaExibicao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPaneVeiculos = new JScrollPane();
		scrollPaneVeiculos.setBounds(15, 114, 854, 425);
		panel.add(scrollPaneVeiculos);
		
		tableVeiculos = new JTable();
		tableVeiculos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Placa", "Chassi", "Marca", "Modelo", "Ano do Modelo", "Ano de Fabrica\u00E7\u00E3o", "Data de Entrada", "Data de Sa\u00EDda"
			}
		) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableVeiculos.getColumnModel().getColumn(0).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(0).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(1).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(1).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(2).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(2).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(3).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(3).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(4).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(4).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(5).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(5).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(5).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(6).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(6).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(6).setMinWidth(60);
		tableVeiculos.getColumnModel().getColumn(7).setResizable(false);
		tableVeiculos.getColumnModel().getColumn(7).setPreferredWidth(150);
		tableVeiculos.getColumnModel().getColumn(7).setMinWidth(60);
		tableVeiculos.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPaneVeiculos.setViewportView(tableVeiculos);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oficina objOficina = new Oficina();

				if (new File("Veiculos.obj").exists()) {
					try {
						objOficina.setVeiculos(LtpLib.lerArquivoObjetosArray("Veiculos.obj"));
					} catch (Exception exception) {
						System.out.println(exception.getMessage());
						System.exit(1);
					}
				}
				
				DefaultTableModel defaultTableVeiculos = (DefaultTableModel) tableVeiculos.getModel();
				Object rowData[] = new Object[10];

				if (defaultTableVeiculos.getRowCount() == 0) {
					for (int i = 0; i < objOficina.getVeiculos().size(); i++) {
						rowData[0] = objOficina.getVeiculos().get(i).getPlaca();
						rowData[1] = objOficina.getVeiculos().get(i).getChassi();
						rowData[2] = objOficina.getVeiculos().get(i).getMarca();
						rowData[3] = objOficina.getVeiculos().get(i).getModelo();
						rowData[4] = objOficina.getVeiculos().get(i).getAnoModelo();
						rowData[5] = objOficina.getVeiculos().get(i).getAnoFabricacao();
						rowData[6] = objOficina.getVeiculos().get(i).getDataEntrada();
						rowData[7] = objOficina.getVeiculos().get(i).getDataSaida();

						defaultTableVeiculos.addRow(rowData);
					}

					try {
						LtpLib.gravarArquivoObjetosArray("Veiculos.obj", objOficina.getVeiculos());
					} catch (Exception exception) {
						System.out.println(exception.getMessage());
						System.exit(2);
					}
				} else {
					JOptionPane.showMessageDialog(null, "O relatório de conta-clientes já está em exibição.", "Aviso de Busca", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnVisualizar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnVisualizar.setBounds(624, 555, 115, 29);
		panel.add(btnVisualizar);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicial telaInicial  = new TelaInicial();
				telaInicial.setVisible(true);
				telaInicial.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButtonCancelar.setBounds(754, 555, 115, 29);
		panel.add(btnNewButtonCancelar);
		
		JLabel lblVeiculosCadastrados = new JLabel("Ve\u00EDculos Cadastrados");
		lblVeiculosCadastrados.setFont(new Font("Arial", Font.BOLD, 30));
		lblVeiculosCadastrados.setBounds(223, 38, 400, 35);
		panel.add(lblVeiculosCadastrados);
	}
}
