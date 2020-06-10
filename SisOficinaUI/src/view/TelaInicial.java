package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Oficina;
import model.Carro;
import model.Moto;
import utilitarios.LtpLib;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPaneOficina;
	private JTextField textFieldPlaca;
	private JTextField textFieldChassi;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldAnoModelo;
	private JTextField textFieldAnoFabricao;
	private JTextField textFieldNomeMotoboy;
	private JTextField textFieldTelefoneMotoboy;
	private JTextField textFieldModeloCapaceteMotoboy;
	private JTextField textFieldCilindradas;
	private JTextField textFieldCpfDono;
	private JTextField textFieldTelefoneDono;
	private JTextField textFieldQuilometragem;
	private JTextField textFieldCavalos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Gerenciamento de Oficina");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPaneOficina = new JPanel();
		contentPaneOficina.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneOficina);
		contentPaneOficina.setLayout(new BorderLayout(0, 0));

		JPanel panelOficinaNorth = new JPanel();
		contentPaneOficina.add(panelOficinaNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelOficinaNorth = new GridBagLayout();
		gbl_panelOficinaNorth.columnWidths = new int[]{0, 0};
		gbl_panelOficinaNorth.rowHeights = new int[]{0, 0, 0};
		gbl_panelOficinaNorth.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelOficinaNorth.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelOficinaNorth.setLayout(gbl_panelOficinaNorth);

		JLabel lblGerenciamentoOficina = new JLabel("Gerenciamento de Oficina");
		lblGerenciamentoOficina.setFont(new Font("Arial", Font.PLAIN, 30));
		GridBagConstraints gbc_lblGerenciamentoOficina = new GridBagConstraints();
		gbc_lblGerenciamentoOficina.insets = new Insets(0, 0, 5, 0);
		gbc_lblGerenciamentoOficina.gridx = 0;
		gbc_lblGerenciamentoOficina.gridy = 0;
		panelOficinaNorth.add(lblGerenciamentoOficina, gbc_lblGerenciamentoOficina);

		JPanel panelOficinaCenter = new JPanel();
		contentPaneOficina.add(panelOficinaCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelOficinaCenter = new GridBagLayout();
		gbl_panelOficinaCenter.columnWidths = new int[]{49, 93, 0};
		gbl_panelOficinaCenter.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelOficinaCenter.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelOficinaCenter.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelOficinaCenter.setLayout(gbl_panelOficinaCenter);

		JLabel labelPlaca = new JLabel("Placa:");
		labelPlaca.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_labelPlaca = new GridBagConstraints();
		gbc_labelPlaca.anchor = GridBagConstraints.EAST;
		gbc_labelPlaca.fill = GridBagConstraints.VERTICAL;
		gbc_labelPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_labelPlaca.gridx = 0;
		gbc_labelPlaca.gridy = 0;
		panelOficinaCenter.add(labelPlaca, gbc_labelPlaca);

		textFieldPlaca = new JTextField();
		textFieldPlaca.setEnabled(false);
		textFieldPlaca.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldPlaca.setColumns(10);
		GridBagConstraints gbc_textFieldPlaca = new GridBagConstraints();
		gbc_textFieldPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPlaca.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPlaca.gridx = 1;
		gbc_textFieldPlaca.gridy = 0;
		panelOficinaCenter.add(textFieldPlaca, gbc_textFieldPlaca);

		JLabel labelChassi = new JLabel("Cassi:");
		labelChassi.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_labelChassi = new GridBagConstraints();
		gbc_labelChassi.anchor = GridBagConstraints.EAST;
		gbc_labelChassi.fill = GridBagConstraints.VERTICAL;
		gbc_labelChassi.insets = new Insets(0, 0, 5, 5);
		gbc_labelChassi.gridx = 0;
		gbc_labelChassi.gridy = 1;
		panelOficinaCenter.add(labelChassi, gbc_labelChassi);

		textFieldChassi = new JTextField();
		textFieldChassi.setEnabled(false);
		textFieldChassi.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldChassi.setColumns(10);
		GridBagConstraints gbc_textFieldChassi = new GridBagConstraints();
		gbc_textFieldChassi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldChassi.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldChassi.gridx = 1;
		gbc_textFieldChassi.gridy = 1;
		panelOficinaCenter.add(textFieldChassi, gbc_textFieldChassi);

		JLabel labelMarca = new JLabel("Marca:");
		labelMarca.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_labelMarca = new GridBagConstraints();
		gbc_labelMarca.anchor = GridBagConstraints.EAST;
		gbc_labelMarca.fill = GridBagConstraints.VERTICAL;
		gbc_labelMarca.insets = new Insets(0, 0, 5, 5);
		gbc_labelMarca.gridx = 0;
		gbc_labelMarca.gridy = 2;
		panelOficinaCenter.add(labelMarca, gbc_labelMarca);

		textFieldMarca = new JTextField();
		textFieldMarca.setEnabled(false);
		textFieldMarca.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldMarca.setColumns(10);
		GridBagConstraints gbc_textFieldMarca = new GridBagConstraints();
		gbc_textFieldMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMarca.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMarca.gridx = 1;
		gbc_textFieldMarca.gridy = 2;
		panelOficinaCenter.add(textFieldMarca, gbc_textFieldMarca);

		JLabel labelModelo = new JLabel("Modelo:");
		labelModelo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_labelModelo = new GridBagConstraints();
		gbc_labelModelo.anchor = GridBagConstraints.EAST;
		gbc_labelModelo.fill = GridBagConstraints.VERTICAL;
		gbc_labelModelo.insets = new Insets(0, 0, 5, 5);
		gbc_labelModelo.gridx = 0;
		gbc_labelModelo.gridy = 3;
		panelOficinaCenter.add(labelModelo, gbc_labelModelo);

		textFieldModelo = new JTextField();
		textFieldModelo.setEnabled(false);
		textFieldModelo.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldModelo.setColumns(10);
		GridBagConstraints gbc_textFieldModelo = new GridBagConstraints();
		gbc_textFieldModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldModelo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldModelo.gridx = 1;
		gbc_textFieldModelo.gridy = 3;
		panelOficinaCenter.add(textFieldModelo, gbc_textFieldModelo);

		JLabel labelAnoModelo = new JLabel("Ano do Modelo:");
		labelAnoModelo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_labelAnoModelo = new GridBagConstraints();
		gbc_labelAnoModelo.anchor = GridBagConstraints.EAST;
		gbc_labelAnoModelo.fill = GridBagConstraints.VERTICAL;
		gbc_labelAnoModelo.insets = new Insets(0, 0, 5, 5);
		gbc_labelAnoModelo.gridx = 0;
		gbc_labelAnoModelo.gridy = 4;
		panelOficinaCenter.add(labelAnoModelo, gbc_labelAnoModelo);

		textFieldAnoModelo = new JTextField();
		textFieldAnoModelo.setEnabled(false);
		textFieldAnoModelo.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldAnoModelo.setColumns(10);
		GridBagConstraints gbc_textFieldAnoModelo = new GridBagConstraints();
		gbc_textFieldAnoModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAnoModelo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAnoModelo.gridx = 1;
		gbc_textFieldAnoModelo.gridy = 4;
		panelOficinaCenter.add(textFieldAnoModelo, gbc_textFieldAnoModelo);

		JLabel labelAnoFabricacao = new JLabel("Ano de Fabrica\u00E7\u00E3o:");
		labelAnoFabricacao.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_labelAnoFabricacao = new GridBagConstraints();
		gbc_labelAnoFabricacao.anchor = GridBagConstraints.EAST;
		gbc_labelAnoFabricacao.fill = GridBagConstraints.VERTICAL;
		gbc_labelAnoFabricacao.insets = new Insets(0, 0, 5, 5);
		gbc_labelAnoFabricacao.gridx = 0;
		gbc_labelAnoFabricacao.gridy = 5;
		panelOficinaCenter.add(labelAnoFabricacao, gbc_labelAnoFabricacao);

		textFieldAnoFabricao = new JTextField();
		textFieldAnoFabricao.setEnabled(false);
		textFieldAnoFabricao.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldAnoFabricao.setColumns(10);
		GridBagConstraints gbc_textFieldAnoFabricao = new GridBagConstraints();
		gbc_textFieldAnoFabricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAnoFabricao.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAnoFabricao.gridx = 1;
		gbc_textFieldAnoFabricao.gridy = 5;
		panelOficinaCenter.add(textFieldAnoFabricao, gbc_textFieldAnoFabricao);

		JLabel lblInformacoesMoto = new JLabel("Informa\u00E7\u00F5es para Moto");
		lblInformacoesMoto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInformacoesMoto = new GridBagConstraints();
		gbc_lblInformacoesMoto.gridwidth = 2;
		gbc_lblInformacoesMoto.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformacoesMoto.gridx = 0;
		gbc_lblInformacoesMoto.gridy = 8;
		panelOficinaCenter.add(lblInformacoesMoto, gbc_lblInformacoesMoto);

		JLabel lblNomeMotoboy = new JLabel("Nome do Motoboy:");
		lblNomeMotoboy.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNomeMotoboy = new GridBagConstraints();
		gbc_lblNomeMotoboy.anchor = GridBagConstraints.EAST;
		gbc_lblNomeMotoboy.fill = GridBagConstraints.VERTICAL;
		gbc_lblNomeMotoboy.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeMotoboy.gridx = 0;
		gbc_lblNomeMotoboy.gridy = 9;
		panelOficinaCenter.add(lblNomeMotoboy, gbc_lblNomeMotoboy);

		textFieldNomeMotoboy = new JTextField();
		textFieldNomeMotoboy.setEnabled(false);
		textFieldNomeMotoboy.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldNomeMotoboy = new GridBagConstraints();
		gbc_textFieldNomeMotoboy.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNomeMotoboy.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomeMotoboy.gridx = 1;
		gbc_textFieldNomeMotoboy.gridy = 9;
		panelOficinaCenter.add(textFieldNomeMotoboy, gbc_textFieldNomeMotoboy);
		textFieldNomeMotoboy.setColumns(10);

		JLabel lblTelefoneMotoboy = new JLabel("Telefone do Motoboy:");
		lblTelefoneMotoboy.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefoneMotoboy = new GridBagConstraints();
		gbc_lblTelefoneMotoboy.anchor = GridBagConstraints.EAST;
		gbc_lblTelefoneMotoboy.fill = GridBagConstraints.VERTICAL;
		gbc_lblTelefoneMotoboy.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefoneMotoboy.gridx = 0;
		gbc_lblTelefoneMotoboy.gridy = 10;
		panelOficinaCenter.add(lblTelefoneMotoboy, gbc_lblTelefoneMotoboy);

		textFieldTelefoneMotoboy = new JTextField();
		textFieldTelefoneMotoboy.setEnabled(false);
		textFieldTelefoneMotoboy.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldTelefoneMotoboy = new GridBagConstraints();
		gbc_textFieldTelefoneMotoboy.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefoneMotoboy.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefoneMotoboy.gridx = 1;
		gbc_textFieldTelefoneMotoboy.gridy = 10;
		panelOficinaCenter.add(textFieldTelefoneMotoboy, gbc_textFieldTelefoneMotoboy);
		textFieldTelefoneMotoboy.setColumns(10);

		JLabel lblModeloCapaceteMotoboy = new JLabel("Modelo do Capacete do Motoboy:");
		lblModeloCapaceteMotoboy.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblModeloCapaceteMotoboy = new GridBagConstraints();
		gbc_lblModeloCapaceteMotoboy.anchor = GridBagConstraints.EAST;
		gbc_lblModeloCapaceteMotoboy.fill = GridBagConstraints.VERTICAL;
		gbc_lblModeloCapaceteMotoboy.insets = new Insets(0, 0, 5, 5);
		gbc_lblModeloCapaceteMotoboy.gridx = 0;
		gbc_lblModeloCapaceteMotoboy.gridy = 11;
		panelOficinaCenter.add(lblModeloCapaceteMotoboy, gbc_lblModeloCapaceteMotoboy);

		textFieldModeloCapaceteMotoboy = new JTextField();
		textFieldModeloCapaceteMotoboy.setEnabled(false);
		textFieldModeloCapaceteMotoboy.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldModeloCapaceteMotoboy = new GridBagConstraints();
		gbc_textFieldModeloCapaceteMotoboy.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldModeloCapaceteMotoboy.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldModeloCapaceteMotoboy.gridx = 1;
		gbc_textFieldModeloCapaceteMotoboy.gridy = 11;
		panelOficinaCenter.add(textFieldModeloCapaceteMotoboy, gbc_textFieldModeloCapaceteMotoboy);
		textFieldModeloCapaceteMotoboy.setColumns(10);

		JLabel lblCilindradas = new JLabel("Cilindradas:");
		lblCilindradas.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCilindradas = new GridBagConstraints();
		gbc_lblCilindradas.anchor = GridBagConstraints.EAST;
		gbc_lblCilindradas.insets = new Insets(0, 0, 5, 5);
		gbc_lblCilindradas.gridx = 0;
		gbc_lblCilindradas.gridy = 12;
		panelOficinaCenter.add(lblCilindradas, gbc_lblCilindradas);

		textFieldCilindradas = new JTextField();
		textFieldCilindradas.setEnabled(false);
		textFieldCilindradas.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldCilindradas = new GridBagConstraints();
		gbc_textFieldCilindradas.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCilindradas.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCilindradas.gridx = 1;
		gbc_textFieldCilindradas.gridy = 12;
		panelOficinaCenter.add(textFieldCilindradas, gbc_textFieldCilindradas);
		textFieldCilindradas.setColumns(10);

		JLabel lblInformaesCarro = new JLabel("Informa\u00E7\u00F5es para Carro");
		lblInformaesCarro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInformaesCarro = new GridBagConstraints();
		gbc_lblInformaesCarro.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformaesCarro.gridwidth = 2;
		gbc_lblInformaesCarro.gridx = 0;
		gbc_lblInformaesCarro.gridy = 14;
		panelOficinaCenter.add(lblInformaesCarro, gbc_lblInformaesCarro);

		JLabel lblCpfDono = new JLabel("CPF do Dono:");
		lblCpfDono.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCpfDono = new GridBagConstraints();
		gbc_lblCpfDono.anchor = GridBagConstraints.EAST;
		gbc_lblCpfDono.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpfDono.gridx = 0;
		gbc_lblCpfDono.gridy = 15;
		panelOficinaCenter.add(lblCpfDono, gbc_lblCpfDono);

		textFieldCpfDono = new JTextField();
		textFieldCpfDono.setEnabled(false);
		textFieldCpfDono.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldCpfDono.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textFieldCpfDono = new GridBagConstraints();
		gbc_textFieldCpfDono.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCpfDono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCpfDono.gridx = 1;
		gbc_textFieldCpfDono.gridy = 15;
		panelOficinaCenter.add(textFieldCpfDono, gbc_textFieldCpfDono);
		textFieldCpfDono.setColumns(10);

		JLabel lblTelefoneDono = new JLabel("Telefone do Dono:");
		lblTelefoneDono.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefoneDono = new GridBagConstraints();
		gbc_lblTelefoneDono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefoneDono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefoneDono.gridx = 0;
		gbc_lblTelefoneDono.gridy = 16;
		panelOficinaCenter.add(lblTelefoneDono, gbc_lblTelefoneDono);

		textFieldTelefoneDono = new JTextField();
		textFieldTelefoneDono.setEnabled(false);
		textFieldTelefoneDono.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldTelefoneDono = new GridBagConstraints();
		gbc_textFieldTelefoneDono.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefoneDono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefoneDono.gridx = 1;
		gbc_textFieldTelefoneDono.gridy = 16;
		panelOficinaCenter.add(textFieldTelefoneDono, gbc_textFieldTelefoneDono);
		textFieldTelefoneDono.setColumns(10);

		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblQuilometragem = new GridBagConstraints();
		gbc_lblQuilometragem.anchor = GridBagConstraints.EAST;
		gbc_lblQuilometragem.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuilometragem.gridx = 0;
		gbc_lblQuilometragem.gridy = 17;
		panelOficinaCenter.add(lblQuilometragem, gbc_lblQuilometragem);

		textFieldQuilometragem = new JTextField();
		textFieldQuilometragem.setEnabled(false);
		textFieldQuilometragem.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldQuilometragem = new GridBagConstraints();
		gbc_textFieldQuilometragem.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldQuilometragem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuilometragem.gridx = 1;
		gbc_textFieldQuilometragem.gridy = 17;
		panelOficinaCenter.add(textFieldQuilometragem, gbc_textFieldQuilometragem);
		textFieldQuilometragem.setColumns(10);

		JLabel lblCavalos = new JLabel("Cavalos:");
		lblCavalos.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCavalos = new GridBagConstraints();
		gbc_lblCavalos.anchor = GridBagConstraints.EAST;
		gbc_lblCavalos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCavalos.gridx = 0;
		gbc_lblCavalos.gridy = 18;
		panelOficinaCenter.add(lblCavalos, gbc_lblCavalos);

		textFieldCavalos = new JTextField();
		textFieldCavalos.setEnabled(false);
		textFieldCavalos.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldCavalos = new GridBagConstraints();
		gbc_textFieldCavalos.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCavalos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCavalos.gridx = 1;
		gbc_textFieldCavalos.gridy = 18;
		panelOficinaCenter.add(textFieldCavalos, gbc_textFieldCavalos);
		textFieldCavalos.setColumns(10);

		JPanel panelOficinaSouth = new JPanel();
		contentPaneOficina.add(panelOficinaSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_panelOficinaSouth = new GridBagLayout();
		gbl_panelOficinaSouth.columnWidths = new int[]{181, 0, 0, 81, 75, 0};
		gbl_panelOficinaSouth.rowHeights = new int[]{0, 23, 0};
		gbl_panelOficinaSouth.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelOficinaSouth.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelOficinaSouth.setLayout(gbl_panelOficinaSouth);

		JRadioButton rdbtnCadastrarMoto = new JRadioButton("Cadastrar Moto");
		rdbtnCadastrarMoto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textFieldPlaca.setEnabled(true);
				textFieldChassi.setEnabled(true);
				textFieldMarca.setEnabled(true);
				textFieldModelo.setEnabled(true);
				textFieldAnoModelo.setEnabled(true);
				textFieldAnoFabricao.setEnabled(true);

				textFieldNomeMotoboy.setEnabled(true);
				textFieldTelefoneMotoboy.setEnabled(true);
				textFieldModeloCapaceteMotoboy.setEnabled(true);
				textFieldCilindradas.setEnabled(true);

				textFieldCpfDono.setEnabled(false);
				textFieldTelefoneDono.setEnabled(false);
				textFieldQuilometragem.setEnabled(false);
				textFieldCavalos.setEnabled(false);
			}
		});
		rdbtnCadastrarMoto.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonGroup.add(rdbtnCadastrarMoto);
		GridBagConstraints gbc_rdbtnCadastrarMoto = new GridBagConstraints();
		gbc_rdbtnCadastrarMoto.anchor = GridBagConstraints.EAST;
		gbc_rdbtnCadastrarMoto.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnCadastrarMoto.gridx = 0;
		gbc_rdbtnCadastrarMoto.gridy = 1;
		panelOficinaSouth.add(rdbtnCadastrarMoto, gbc_rdbtnCadastrarMoto);

		JRadioButton rdbtnCadastrarCarro = new JRadioButton("Cadastrar Carro");
		rdbtnCadastrarCarro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textFieldPlaca.setEnabled(true);
				textFieldChassi.setEnabled(true);
				textFieldMarca.setEnabled(true);
				textFieldModelo.setEnabled(true);
				textFieldAnoModelo.setEnabled(true);
				textFieldAnoFabricao.setEnabled(true);

				textFieldNomeMotoboy.setEnabled(false);
				textFieldTelefoneMotoboy.setEnabled(false);
				textFieldModeloCapaceteMotoboy.setEnabled(false);
				textFieldCilindradas.setEnabled(false);

				textFieldCpfDono.setEnabled(true);
				textFieldTelefoneDono.setEnabled(true);
				textFieldQuilometragem.setEnabled(true);
				textFieldCavalos.setEnabled(true);
			}
		});
		rdbtnCadastrarCarro.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonGroup.add(rdbtnCadastrarCarro);
		GridBagConstraints gbc_rdbtnCadastrarCarro = new GridBagConstraints();
		gbc_rdbtnCadastrarCarro.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCadastrarCarro.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnCadastrarCarro.gridx = 1;
		gbc_rdbtnCadastrarCarro.gridy = 1;
		panelOficinaSouth.add(rdbtnCadastrarCarro, gbc_rdbtnCadastrarCarro);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
				JButton btnCadastrar = new JButton("Cadastrar");
				btnCadastrar.addActionListener(new ActionListener() {
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0) {
						Oficina objOficina = new Oficina();

						if (new File("Veiculos.obj").exists()) {
							try {
								objOficina.setVeiculos(LtpLib.lerArquivoObjetosArray("Veiculos.obj"));
							} catch (Exception e) {
								System.out.println(e.getMessage());
								System.exit(1);
							}
						}

						// CODIFICAR CADASTRO
						if (!rdbtnCadastrarMoto.isSelected() && !rdbtnCadastrarCarro.isSelected()) {
							JOptionPane.showMessageDialog(null, "Escolha uma moto ou um carro para cadastrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
						} else {
							if(rdbtnCadastrarMoto.isSelected()) {
								try {
									Moto moto = new Moto();
	
									moto.setPlaca(textFieldPlaca.getText());
									moto.setChassi(textFieldChassi.getText());
									moto.setMarca(textFieldMarca.getText());
									moto.setModelo(textFieldModelo.getText());
									moto.setAnoModelo(Integer.parseInt(textFieldAnoModelo.getText()));
									moto.setAnoFabricacao(Integer.parseInt(textFieldAnoFabricao.getText()));
									moto.setDataEntrada(new Date());
									moto.setDataSaida(null);
									moto.setNomeMotoboy(textFieldNomeMotoboy.getText());
									moto.setTelefoneMotoboy(textFieldTelefoneMotoboy.getText());
									moto.setModeloCapacete(textFieldModeloCapaceteMotoboy.getText());
									moto.setCilindradas(Integer.parseInt(textFieldCilindradas.getText()));
									moto.setMotoNaOficina(false);

									objOficina.cadastrarVeiculo(moto);

									JOptionPane.showMessageDialog(null, "Cadastro de moto realizado.", "CADASTRO REALIZADO", JOptionPane.DEFAULT_OPTION);
								} catch (Exception exception) {
									JOptionPane.showMessageDialog(null, "Erro ao cadastrar moto.", "ERRO DE CADASTRO", JOptionPane.ERROR_MESSAGE);
								}
							}

							if (rdbtnCadastrarCarro.isSelected()) {
								try {
									Carro carro = new Carro();
	
									carro.setPlaca(textFieldPlaca.getText());
									carro.setChassi(textFieldChassi.getText());
									carro.setMarca(textFieldMarca.getText());
									carro.setModelo(textFieldModelo.getText());
									carro.setAnoModelo(Integer.parseInt(textFieldAnoModelo.getText()));
									carro.setAnoFabricacao(Integer.parseInt(textFieldAnoFabricao.getText()));
									carro.setDataEntrada(new Date());
									carro.setDataSaida(null);
									carro.setCpfDono(textFieldCpfDono.getText());
									carro.setTelefoneDono(textFieldTelefoneDono.getText());
									carro.setQuilometragem(textFieldQuilometragem.getText());
									carro.setCavalos(Integer.parseInt(textFieldCavalos.getText()));
									carro.setCarroNaOficina(false);

									objOficina.cadastrarVeiculo(carro);

									JOptionPane.showMessageDialog(null, "Cadastro de carro realizado.", "CADASTRO REALIZADO", JOptionPane.DEFAULT_OPTION);
								} catch (Exception exception) {
									JOptionPane.showMessageDialog(null, "Erro ao cadastrar carro.", "ERRO DE CADASTRO", JOptionPane.ERROR_MESSAGE);
								}
							}
						}

						try {
							LtpLib.gravarArquivoObjetosArray("Veiculos.obj", objOficina.getVeiculos());
						} catch (Exception e) {
							System.out.println(e.getMessage());
							System.exit(2);
						}
					}
				});
				btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 16));
				GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
				gbc_btnCadastrar.anchor = GridBagConstraints.NORTHEAST;
				gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
				gbc_btnCadastrar.gridx = 2;
				gbc_btnCadastrar.gridy = 1;
				panelOficinaSouth.add(btnCadastrar, gbc_btnCadastrar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExibicao telaExibicao = new TelaExibicao();
				telaExibicao.setVisible(true);
				telaExibicao.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVisualizar.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_btnVisualizar = new GridBagConstraints();
		gbc_btnVisualizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnVisualizar.gridx = 3;
		gbc_btnVisualizar.gridy = 1;
		panelOficinaSouth.add(btnVisualizar, gbc_btnVisualizar);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 1;
		panelOficinaSouth.add(btnCancelar, gbc_btnCancelar);
	}
}
