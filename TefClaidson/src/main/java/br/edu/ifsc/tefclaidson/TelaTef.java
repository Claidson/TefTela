/*
 que a força esteja com todo mundo! 
 */
package br.edu.ifsc.tefclaidson;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claidson
 */
public class TelaTef extends javax.swing.JFrame {
    
    private String nome, cartaoLinha;
    private int agencia, verificadorAgencia, conta, verificadorConta, titularConta, bandeira;
    private Cartao cartao;
    private CartaoController controle;
    private DefaultTableModel tabelaCartoesModel;
    private DefaultTableModel tabelaCartoesModelPesq;
    private UIManager.LookAndFeelInfo[] looks
            = UIManager.getInstalledLookAndFeels();
    private JRadioButton[] escolha = new JRadioButton[looks.length];
    private ButtonGroup grupoLooks = new ButtonGroup();
    
    public TelaTef() {
        
        initComponents();
        
        try {
            controle = new CartaoController();
        } catch (IOException ex) {
            Logger.getLogger(TelaTef.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaTef.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabelaCartoesModel = (DefaultTableModel) jTableCartoesLista.getModel();
        tabelaCartoesModelPesq = (DefaultTableModel) jTableCartoesListaPesq.getModel();
        preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
        adicionaLookMenu();
        ocultarCamposPesquisa();
        centralizarComponente();
        
        this.setIconImage(new ImageIcon(getClass().getResource("/cartao-de-credito-de-volta_318-62389.png")).getImage());
    }
    
    public void adicionaLookMenu() {
        ItemSelecionado iselect = new ItemSelecionado();
        for (int i = 0; i < looks.length; i++) {
            escolha[i] = new JRadioButton(looks[i].getName());
            escolha[i].addItemListener(iselect);
            grupoLooks.add(escolha[i]);
            jMenuVisualizar.add(escolha[i]);
        }
    }
    
    public void preencherTabelaCartao(DefaultTableModel tabela, ArrayList<Cartao> lista) {
        // tabela.setNumRows(controle.cartoes.size());
        limparTabelaCartao(tabela);
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nada localizado :-(\n", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            /* jListaCartoes.setListData(lista.toArray());
             for (Cartao cart : lista) {
             System.out.println("->" + cart.toString());
             }*/
            for (Cartao c : lista) {
                tabela.addRow(new Object[]{c.getID(), c.getNumero(), c.getNome(), c.getCvv(), c.getAgencia(), c.getVerificadorAgencia(), c.getConta(), c.getVerificadorConta(), c.getTitularConta(), c.getBandeira()});
            }
        }
    }
    
    public void limparTabelaCartao(DefaultTableModel tabela) {
        
        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        
    }
    
    public void limpaTela(JPanel Frame) {
        //limpa os campos     
        for (int i = 0; i < Frame.getComponentCount(); i++) {
            //varre todos os componentes     
            Component c = Frame.getComponent(i);
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            }
        }
        jRadioMasterCad.setVisible(false);
        jRadioVisaCad.setVisible(false);
        jSpinnerDigAgencia.setValue(0);
        jSpinnerDigConta.setValue(0);
        
    }
    
    public void ocultarCamposPesquisa() {
        jButtonPesBuscar.setVisible(true);
        jComboPesBandeira.setVisible(false);
        jLabelPesConta.setVisible(false);
        jLabelPesDigito.setVisible(false);
        jLabelPesNomeCartaoBandeira.setVisible(false);
        jTextPesNomeCartao.setVisible(false);
        jTextPesqContaAgencia.setVisible(false);
        jTextPesqVerificador.setVisible(false);
        jCheckBoxPesTitular.setVisible(false);
        jRadioMaster.setVisible(false);
        jRadioVisa.setVisible(false);
        jButtonPesExcluir.setVisible(false);
    }
    
    public void limparListaPesquisa() {
        //  controle.cartoesPesquisa = null;
        // carregarCartoes(controle.cartoesPesquisa);
        limparTabelaCartao(tabelaCartoesModelPesq);
    }
    
    public void centralizarComponente() {
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jTabbedPaneCartao = new javax.swing.JTabbedPane();
        jPanelCadastro = new javax.swing.JPanel();
        jTextNome = new javax.swing.JTextField();
        jBotaoSalvarCartao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextAgencia = new javax.swing.JTextField();
        jTextConta = new javax.swing.JTextField();
        jComboBandeira = new javax.swing.JComboBox();
        jRadioTitular = new javax.swing.JRadioButton();
        jRadioAdicional = new javax.swing.JRadioButton();
        jBotaoCartaoLinha = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCartaoLinha = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioMasterCad = new javax.swing.JRadioButton();
        jRadioVisaCad = new javax.swing.JRadioButton();
        lmparCamposCad = new javax.swing.JButton();
        jSpinnerDigAgencia = new javax.swing.JSpinner();
        jSpinnerDigConta = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanelPesquisa = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jRadioPesqNCartao = new javax.swing.JRadioButton();
        jRadioPesqBandeira = new javax.swing.JRadioButton();
        jRadioPesqAgencia = new javax.swing.JRadioButton();
        jRadioPesqConta = new javax.swing.JRadioButton();
        jRadioPesqContaTitular = new javax.swing.JRadioButton();
        jLabelPesNomeCartaoBandeira = new javax.swing.JLabel();
        jTextPesNomeCartao = new javax.swing.JTextField();
        jRadioPesqNome = new javax.swing.JRadioButton();
        jLabelPesConta = new javax.swing.JLabel();
        jTextPesqVerificador = new javax.swing.JTextField();
        jComboPesBandeira = new javax.swing.JComboBox();
        jLabelPesDigito = new javax.swing.JLabel();
        jTextPesqContaAgencia = new javax.swing.JTextField();
        jCheckBoxPesTitular = new javax.swing.JCheckBox();
        jButtonPesBuscar = new javax.swing.JButton();
        jRadioVisa = new javax.swing.JRadioButton();
        jRadioMaster = new javax.swing.JRadioButton();
        jScrollPaneTabela1 = new javax.swing.JScrollPane();
        jTableCartoesListaPesq = new javax.swing.JTable();
        jButtonPesExcluir = new javax.swing.JButton();
        jPanelListar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableCartoesLista = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuImportar = new javax.swing.JMenu();
        jMenuImportarTXT = new javax.swing.JMenuItem();
        jMenuImportarJson = new javax.swing.JMenuItem();
        jMenuImportarXml = new javax.swing.JMenuItem();
        jMenuImportarDat = new javax.swing.JMenuItem();
        jMenuExportar = new javax.swing.JMenu();
        jMenuIExportarTXT = new javax.swing.JMenuItem();
        jMenuIExportarJson = new javax.swing.JMenuItem();
        jMenuIExportarXML = new javax.swing.JMenuItem();
        jMenuIExportarDat = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuArquivoSair = new javax.swing.JMenuItem();
        jMenuVisualizar = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kludge TEfControl - Claidson");
        setName("tela"); // NOI18N
        setResizable(false);

        jTabbedPaneCartao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBotaoSalvarCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Programming-Save-As-icon.png"))); // NOI18N
        jBotaoSalvarCartao.setText("Cadastrar");
        jBotaoSalvarCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoSalvarCartaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Agencia:");

        jLabel3.setText("Dig:");

        jLabel4.setText("Bandeira:");

        jLabel5.setText("Titularidade:");

        jLabel6.setText("Dig:");

        jLabel7.setText("Conta:");

        jLabel8.setText("Habilitar Leitura de dados:");

        jComboBandeira.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Visa", "Master" }));
        jComboBandeira.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBandeiraItemStateChanged(evt);
            }
        });

        jRadioTitular.setText("Titular");
        jRadioTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTitularActionPerformed(evt);
            }
        });

        jRadioAdicional.setText("Adicional");
        jRadioAdicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAdicionalActionPerformed(evt);
            }
        });

        jBotaoCartaoLinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Credit-Card-icon.png"))); // NOI18N
        jBotaoCartaoLinha.setText("ok");
        jBotaoCartaoLinha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBotaoCartaoLinhaMouseClicked(evt);
            }
        });

        jTextCartaoLinha.setColumns(20);
        jTextCartaoLinha.setRows(5);
        jTextCartaoLinha.setEnabled(false);
        jScrollPane1.setViewportView(jTextCartaoLinha);

        jLabel9.setText("Codigo:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Cadastro de Cartões Kludge TEFControl");

        jRadioMasterCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Credit-master-card-icon.png"))); // NOI18N

        jRadioVisaCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payment-card-icon.png"))); // NOI18N

        lmparCamposCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui-text-field-clear-button-icon.png"))); // NOI18N
        lmparCamposCad.setText("Limpar Campos");
        lmparCamposCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lmparCamposCadActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/192-credit-card-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioTitular)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioAdicional))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jTextAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerDigAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextConta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1)
                                .addComponent(jSpinnerDigConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextNome)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lmparCamposCad, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBotaoSalvarCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(4, 4, 4)
                                .addComponent(jBotaoCartaoLinha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioMasterCad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioVisaCad)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(55, 55, 55))
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(28, 28, 28)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jTextConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinnerDigAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerDigConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jRadioTitular)
                        .addComponent(jRadioAdicional))
                    .addComponent(jRadioMasterCad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioVisaCad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBotaoCartaoLinha)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lmparCamposCad)
                    .addComponent(jBotaoSalvarCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPaneCartao.addTab("Cadastro", jPanelCadastro);

        jLabel12.setText("Pesquisa por:");

        jRadioPesqNCartao.setText("Numero do cartão");
        jRadioPesqNCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPesqNCartaoActionPerformed(evt);
            }
        });

        jRadioPesqBandeira.setText("Bandeira");
        jRadioPesqBandeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPesqBandeiraActionPerformed(evt);
            }
        });

        jRadioPesqAgencia.setText("Agencia");
        jRadioPesqAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPesqAgenciaActionPerformed(evt);
            }
        });

        jRadioPesqConta.setText("Conta");
        jRadioPesqConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPesqContaActionPerformed(evt);
            }
        });

        jRadioPesqContaTitular.setText("Conta e titular");
        jRadioPesqContaTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPesqContaTitularActionPerformed(evt);
            }
        });

        jLabelPesNomeCartaoBandeira.setText("Nome");

        jRadioPesqNome.setText("Nome");
        jRadioPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPesqNomeActionPerformed(evt);
            }
        });

        jLabelPesConta.setText("Conta:");

        jComboPesBandeira.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Visa", "Master" }));
        jComboPesBandeira.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboPesBandeiraItemStateChanged(evt);
            }
        });

        jLabelPesDigito.setText("Digito:");

        jCheckBoxPesTitular.setText("Titular");

        jButtonPesBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data-Clear-Filters-icon.png"))); // NOI18N
        jButtonPesBuscar.setText("Buscar");
        jButtonPesBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesBuscarActionPerformed(evt);
            }
        });

        jRadioVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payment-card-icon.png"))); // NOI18N

        jRadioMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Credit-master-card-icon.png"))); // NOI18N

        jTableCartoesListaPesq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Número", "Nome", "Cvv", "Agência", "Dig", "Conta", "Dig", "Titular", "Bandeira"
            }
        ));
        jScrollPaneTabela1.setViewportView(jTableCartoesListaPesq);
        if (jTableCartoesListaPesq.getColumnModel().getColumnCount() > 0) {
            jTableCartoesListaPesq.getColumnModel().getColumn(0).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableCartoesListaPesq.getColumnModel().getColumn(1).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(1).setPreferredWidth(110);
            jTableCartoesListaPesq.getColumnModel().getColumn(2).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableCartoesListaPesq.getColumnModel().getColumn(3).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableCartoesListaPesq.getColumnModel().getColumn(4).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTableCartoesListaPesq.getColumnModel().getColumn(5).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTableCartoesListaPesq.getColumnModel().getColumn(6).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTableCartoesListaPesq.getColumnModel().getColumn(7).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(7).setPreferredWidth(15);
            jTableCartoesListaPesq.getColumnModel().getColumn(8).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(8).setPreferredWidth(5);
            jTableCartoesListaPesq.getColumnModel().getColumn(9).setResizable(false);
            jTableCartoesListaPesq.getColumnModel().getColumn(9).setPreferredWidth(5);
        }

        jButtonPesExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-edit-clear-list-icon.png"))); // NOI18N
        jButtonPesExcluir.setText("Excluir ");
        jButtonPesExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPesquisaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPesquisaLayout.createSequentialGroup()
                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioPesqNome)
                            .addComponent(jRadioPesqContaTitular)
                            .addComponent(jRadioPesqAgencia)
                            .addComponent(jRadioPesqConta)
                            .addComponent(jRadioPesqNCartao)
                            .addComponent(jRadioPesqBandeira))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPesNomeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPesNomeCartaoBandeira)
                            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextPesqContaAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPesConta)
                                    .addComponent(jComboPesBandeira, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPesDigito)
                                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                                .addComponent(jTextPesqVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBoxPesTitular))
                                            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                                .addComponent(jRadioMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioVisa)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonPesBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonPesExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPesquisaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 594, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabela1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioPesqNome)
                            .addComponent(jLabelPesNomeCartaoBandeira))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioPesqNCartao)
                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioPesqBandeira)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioPesqAgencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioPesqConta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioPesqContaTitular))
                            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPesConta, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPesDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextPesqContaAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextPesqVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxPesTitular))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboPesBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioVisa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextPesNomeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesExcluir)
                        .addGap(8, 8, 8)))
                .addComponent(jScrollPaneTabela1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
        );

        jTabbedPaneCartao.addTab("Pesquisa", jPanelPesquisa);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Cartões Cadastrados");

        jTableCartoesLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Número", "Nome", "Cvv", "Agência", "Dig", "Conta", "Dig", "Titular", "Bandeira"
            }
        ));
        jScrollPaneTabela.setViewportView(jTableCartoesLista);
        if (jTableCartoesLista.getColumnModel().getColumnCount() > 0) {
            jTableCartoesLista.getColumnModel().getColumn(0).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableCartoesLista.getColumnModel().getColumn(1).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(1).setPreferredWidth(110);
            jTableCartoesLista.getColumnModel().getColumn(2).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableCartoesLista.getColumnModel().getColumn(3).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableCartoesLista.getColumnModel().getColumn(4).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTableCartoesLista.getColumnModel().getColumn(5).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTableCartoesLista.getColumnModel().getColumn(6).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTableCartoesLista.getColumnModel().getColumn(7).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(7).setPreferredWidth(15);
            jTableCartoesLista.getColumnModel().getColumn(8).setPreferredWidth(5);
            jTableCartoesLista.getColumnModel().getColumn(9).setResizable(false);
            jTableCartoesLista.getColumnModel().getColumn(9).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanelListarLayout = new javax.swing.GroupLayout(jPanelListar);
        jPanelListar.setLayout(jPanelListarLayout);
        jPanelListarLayout.setHorizontalGroup(
            jPanelListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelListarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelListarLayout.setVerticalGroup(
            jPanelListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneCartao.addTab("Listar", jPanelListar);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Document-Copy-icon.png"))); // NOI18N
        jMenu1.setText("Arquivo");

        jMenuImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Import-icon.png"))); // NOI18N
        jMenuImportar.setText("Importar");

        jMenuImportarTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files-Txt-icon.png"))); // NOI18N
        jMenuImportarTXT.setText("TXT");
        jMenuImportarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImportarTXTActionPerformed(evt);
            }
        });
        jMenuImportar.add(jMenuImportarTXT);

        jMenuImportarJson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/J-icon.png"))); // NOI18N
        jMenuImportarJson.setText("Json");
        jMenuImportarJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImportarJsonActionPerformed(evt);
            }
        });
        jMenuImportar.add(jMenuImportarJson);

        jMenuImportarXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files-Xml-icon.png"))); // NOI18N
        jMenuImportarXml.setText("XML");
        jMenuImportarXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImportarXmlActionPerformed(evt);
            }
        });
        jMenuImportar.add(jMenuImportarXml);

        jMenuImportarDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dat-16.png"))); // NOI18N
        jMenuImportarDat.setText("DAT");
        jMenuImportarDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImportarDatActionPerformed(evt);
            }
        });
        jMenuImportar.add(jMenuImportarDat);

        jMenu1.add(jMenuImportar);

        jMenuExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Export-icon (1).png"))); // NOI18N
        jMenuExportar.setText("Exportar");

        jMenuIExportarTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files-Txt-icon.png"))); // NOI18N
        jMenuIExportarTXT.setText("TXT");
        jMenuIExportarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIExportarTXTActionPerformed(evt);
            }
        });
        jMenuExportar.add(jMenuIExportarTXT);

        jMenuIExportarJson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/J-icon.png"))); // NOI18N
        jMenuIExportarJson.setText("Json");
        jMenuIExportarJson.setPreferredSize(new java.awt.Dimension(93, 22));
        jMenuIExportarJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIExportarJsonActionPerformed(evt);
            }
        });
        jMenuExportar.add(jMenuIExportarJson);

        jMenuIExportarXML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files-Xml-icon.png"))); // NOI18N
        jMenuIExportarXML.setText("XML");
        jMenuIExportarXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIExportarXMLActionPerformed(evt);
            }
        });
        jMenuExportar.add(jMenuIExportarXML);

        jMenuIExportarDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dat-16.png"))); // NOI18N
        jMenuIExportarDat.setText("DAT");
        jMenuIExportarDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIExportarDatActionPerformed(evt);
            }
        });
        jMenuExportar.add(jMenuIExportarDat);

        jMenu1.add(jMenuExportar);
        jMenu1.add(jSeparator2);

        jMenuArquivoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Finance-Card-Inserting-icon.png"))); // NOI18N
        jMenuArquivoSair.setText("Sair");
        jMenuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArquivoSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuArquivoSair);

        jMenuBar1.add(jMenu1);

        jMenuVisualizar.setText("Visual");
        jMenuBar1.add(jMenuVisualizar);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Very-Basic-About-icon.png"))); // NOI18N
        jMenu2.setText("Versão");
        jMenu2.add(jSeparator1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/C-icon.png"))); // NOI18N
        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneCartao)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jRadioTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTitularActionPerformed
        titularConta = 1;
        jRadioAdicional.setSelected(false);

    }//GEN-LAST:event_jRadioTitularActionPerformed

    private void jBotaoSalvarCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoSalvarCartaoActionPerformed
        if (jBotaoCartaoLinha.isSelected()) {
            try {
                cartaoLinha = jTextCartaoLinha.getText();
                boolean salvo;
                cartao = controle.geraCartao(cartaoLinha);
                salvo = controle.add(cartao);
                if (salvo) {
                    JOptionPane.showMessageDialog(this, "Cartão cadastrado\n" + cartao.getNumero());
                    jTextCartaoLinha.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar cartão\nVerifique dados inseridos\n"
                            + "e se o numero não está duplicado\n", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                limpaTela(jPanelCadastro);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao salvar cartão\nVerifique dados inseridos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                nome = jTextNome.getText().toUpperCase();
                agencia = Integer.parseInt(jTextAgencia.getText());
                conta = Integer.parseInt(jTextConta.getText());
                verificadorAgencia = Integer.parseInt(jSpinnerDigAgencia.getValue().toString());
                verificadorConta = Integer.parseInt(jSpinnerDigConta.getValue().toString());
                if (jComboBandeira.getSelectedItem().equals("Visa")) {
                    bandeira = 1;
                } else if (jComboBandeira.getSelectedItem().equals("Master")) {
                    bandeira = 2;
                }
                cartao = new Cartao();
                cartao.setNome(nome);
                cartao.setAgencia(agencia);
                cartao.setConta(conta);
                cartao.setVerificadorAgencia(verificadorAgencia);
                cartao.setVerificadorConta(verificadorConta);
                cartao.setTitularConta(titularConta);
                cartao.setBandeira(bandeira);
                boolean salvo;
                salvo = controle.add(cartao);
                if (salvo) {
                    JOptionPane.showMessageDialog(this, "Cartão cadastrado\n" + cartao.getNumero());
                    jTextCartaoLinha.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar cartão\nVerifique dados inseridos\n"
                            + "+e se o numero não está duplicado\n", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                limpaTela(jPanelCadastro);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao salvar cartão\nVerifique dados inseridos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
    }//GEN-LAST:event_jBotaoSalvarCartaoActionPerformed

    private void jRadioAdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAdicionalActionPerformed
        titularConta = 2;
        jRadioTitular.setSelected(false);
    }//GEN-LAST:event_jRadioAdicionalActionPerformed
    

    private void jBotaoCartaoLinhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBotaoCartaoLinhaMouseClicked
        if (jBotaoCartaoLinha.isSelected()) {
            jTextNome.setEnabled(false);
            jTextAgencia.setEnabled(false);
            jSpinnerDigAgencia.setEnabled(false);
            jTextConta.setEnabled(false);
            jSpinnerDigConta.setEnabled(false);
            jComboBandeira.setEnabled(false);
            jRadioAdicional.setEnabled(false);
            jRadioTitular.setEnabled(false);
            jTextCartaoLinha.setEnabled(true);
        } else {
            jTextNome.setEnabled(true);
            jTextAgencia.setEnabled(true);
            jSpinnerDigAgencia.setEnabled(true);
            jTextConta.setEnabled(true);
            jSpinnerDigConta.setEnabled(true);
            jComboBandeira.setEnabled(true);
            jRadioAdicional.setEnabled(true);
            jRadioTitular.setEnabled(true);
            jTextCartaoLinha.setEnabled(false);
    }//GEN-LAST:event_jBotaoCartaoLinhaMouseClicked
    }
    private void jMenuArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArquivoSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair ? ", "Sair", JOptionPane.OK_CANCEL_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        

    }//GEN-LAST:event_jMenuArquivoSairActionPerformed

    private void jMenuIExportarJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIExportarJsonActionPerformed
        JFileChooser salvandoArquivo = new JFileChooser();
        salvandoArquivo.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo Json", "json");
        salvandoArquivo.setFileFilter(extensao);
        int resultado = salvandoArquivo.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
            controle.salvarListaJson(salvarArquivoEscolhido);
            JOptionPane.showMessageDialog(this, "Arquivo Json Salvo\n", "Exportação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar\n", "Exportação", JOptionPane.ERROR);
        }
        

    }//GEN-LAST:event_jMenuIExportarJsonActionPerformed

    private void jMenuIExportarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIExportarTXTActionPerformed
        JFileChooser salvandoArquivo = new JFileChooser();
        salvandoArquivo.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo txt", "txt");
        salvandoArquivo.setFileFilter(extensao);
        int resultado = salvandoArquivo.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
            controle.salvarListaTxt(salvarArquivoEscolhido);
            JOptionPane.showMessageDialog(this, "Arquivo TXT salvo\n", "Exportação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar\n", "Exportação", JOptionPane.ERROR);
        }
    }//GEN-LAST:event_jMenuIExportarTXTActionPerformed

    private void jMenuIExportarXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIExportarXMLActionPerformed
        JFileChooser salvandoArquivo = new JFileChooser();
        salvandoArquivo.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo XML", "xml");
        salvandoArquivo.setFileFilter(extensao);
        int resultado = salvandoArquivo.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
            controle.salvarListaXML(salvarArquivoEscolhido);
            JOptionPane.showMessageDialog(this, "Arquivo XML Salvo\n", "Exportação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar\n", "Exportação", JOptionPane.ERROR);
        }
        

    }//GEN-LAST:event_jMenuIExportarXMLActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(this,
                "Kludge TEFControl\nDesenvolvimento de aplicações orientadas a objeto\n"
                + "Aluno: Claidson C. Haidrick Fase:3\n"
                + "Professor: Renato Simões\nVersão 1.0",
                "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jRadioPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPesqNomeActionPerformed
        ocultarCamposPesquisa();
        jRadioPesqNCartao.setSelected(false);
        jRadioPesqBandeira.setSelected(false);
        jRadioPesqAgencia.setSelected(false);
        jRadioPesqConta.setSelected(false);
        jRadioPesqContaTitular.setSelected(false);
        jLabelPesNomeCartaoBandeira.setText("Nome:");
        jLabelPesNomeCartaoBandeira.setVisible(true);
        jTextPesNomeCartao.setVisible(true);
        limparListaPesquisa();

    }//GEN-LAST:event_jRadioPesqNomeActionPerformed

    private void jRadioPesqContaTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPesqContaTitularActionPerformed
        ocultarCamposPesquisa();
        jRadioPesqNome.setSelected(false);
        jRadioPesqNCartao.setSelected(false);
        jRadioPesqBandeira.setSelected(false);
        jRadioPesqAgencia.setSelected(false);
        jRadioPesqConta.setSelected(false);
        jLabelPesConta.setText("Conta:");
        jLabelPesConta.setVisible(true);
        jLabelPesDigito.setVisible(true);
        jLabelPesConta.setVisible(true);
        jTextPesqContaAgencia.setVisible(true);
        jTextPesqVerificador.setVisible(true);
        jCheckBoxPesTitular.setVisible(true);
        limparListaPesquisa();

    }//GEN-LAST:event_jRadioPesqContaTitularActionPerformed

    private void jRadioPesqContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPesqContaActionPerformed
        ocultarCamposPesquisa();
        jRadioPesqNome.setSelected(false);
        jRadioPesqNCartao.setSelected(false);
        jRadioPesqBandeira.setSelected(false);
        jRadioPesqAgencia.setSelected(false);
        jRadioPesqContaTitular.setSelected(false);
        jLabelPesConta.setText("Conta:");
        jLabelPesConta.setVisible(true);
        jLabelPesDigito.setVisible(true);
        jTextPesqContaAgencia.setVisible(true);
        jTextPesqVerificador.setVisible(true);
        limparListaPesquisa();
        

    }//GEN-LAST:event_jRadioPesqContaActionPerformed

    private void jRadioPesqAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPesqAgenciaActionPerformed
        ocultarCamposPesquisa();
        jRadioPesqNome.setSelected(false);
        jRadioPesqNCartao.setSelected(false);
        jRadioPesqBandeira.setSelected(false);
        jRadioPesqConta.setSelected(false);
        jRadioPesqContaTitular.setSelected(false);
        jLabelPesConta.setText("Agência:");
        jLabelPesConta.setVisible(true);
        jLabelPesDigito.setVisible(true);
        jTextPesqContaAgencia.setVisible(true);
        jTextPesqVerificador.setVisible(true);
        limparListaPesquisa();
    }//GEN-LAST:event_jRadioPesqAgenciaActionPerformed

    private void jRadioPesqBandeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPesqBandeiraActionPerformed
        ocultarCamposPesquisa();
        jRadioPesqNome.setSelected(false);
        jRadioPesqNCartao.setSelected(false);
        jRadioPesqAgencia.setSelected(false);
        jRadioPesqConta.setSelected(false);
        jRadioPesqContaTitular.setSelected(false);
        jComboPesBandeira.setVisible(true);
        limparListaPesquisa();
        jRadioMaster.setVisible(true);
        jRadioVisa.setVisible(true);
    }//GEN-LAST:event_jRadioPesqBandeiraActionPerformed

    private void jRadioPesqNCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPesqNCartaoActionPerformed
        ocultarCamposPesquisa();
        jRadioPesqNome.setSelected(false);
        jRadioPesqBandeira.setSelected(false);
        jRadioPesqAgencia.setSelected(false);
        jRadioPesqConta.setSelected(false);
        jRadioPesqContaTitular.setSelected(false);
        jLabelPesNomeCartaoBandeira.setText("Cartão:");
        jLabelPesNomeCartaoBandeira.setVisible(true);
        jTextPesNomeCartao.setVisible(true);
        limparListaPesquisa();
    }//GEN-LAST:event_jRadioPesqNCartaoActionPerformed

    private void jButtonPesBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesBuscarActionPerformed
         jButtonPesBuscar.setVisible(false);  
        jButtonPesExcluir.setVisible(true);
        try {
            if (jRadioPesqNome.isSelected() == true) {
                
                String nom = jTextPesNomeCartao.getText().toUpperCase();
                
                preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByNome(nom));
                limpaTela(jPanelPesquisa);
                
            } else if (jRadioPesqNCartao.isSelected()) {
                String cart = jTextPesNomeCartao.getText();
                
                preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByNumeroCartao(cart));
                
            } else if (jRadioPesqBandeira.isSelected()) {
                
                if (jComboPesBandeira.getSelectedItem().equals("Visa")) {
                    preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByBandeira(CartaoController.Bandeira.VISA));
                    
                } else if (jComboPesBandeira.getSelectedItem().equals("Master")) {
                    
                    preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByBandeira(CartaoController.Bandeira.MASTER));
                    
                }
                
            } else if (jRadioPesqAgencia.isSelected()) {
                int ag = Integer.parseInt(jTextPesqContaAgencia.getText());
                int dig = Integer.parseInt(jTextPesqVerificador.getText());
                preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByAgencia(ag, dig));
                
            } else if (jRadioPesqConta.isSelected()) {
                int cont = Integer.parseInt(jTextPesqContaAgencia.getText());
                int dig = Integer.parseInt(jTextPesqVerificador.getText());
                
                preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByConta(cont, dig));
                
            } else if (jRadioPesqContaTitular.isSelected()) {
                int tit = 1;
                int cont = Integer.parseInt(jTextPesqContaAgencia.getText());
                int dig = Integer.parseInt(jTextPesqVerificador.getText());
                if (jCheckBoxPesTitular.isSelected() == false) {
                    tit = 2;
                }
                preencherTabelaCartao(tabelaCartoesModelPesq, controle.searchByContaTitular(cont, dig, tit));
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar cartão\nVerifique dados inseridos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesBuscarActionPerformed

    private void jComboPesBandeiraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboPesBandeiraItemStateChanged
        if (jComboPesBandeira.getSelectedItem().equals("Visa")) {
            
            jRadioMaster.setVisible(false);
            jRadioVisa.setVisible(true);
            
        } else if (jComboPesBandeira.getSelectedItem().equals("Master")) {
            
            jRadioVisa.setVisible(false);
            jRadioMaster.setVisible(true);
        } else if (jComboPesBandeira.getSelectedItem().equals("-")) {
            
            jRadioVisa.setVisible(false);
            jRadioMaster.setVisible(false);
        }
        limparListaPesquisa();
    }//GEN-LAST:event_jComboPesBandeiraItemStateChanged

    private void jComboBandeiraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBandeiraItemStateChanged
        if (jComboBandeira.getSelectedItem().equals("Visa")) {
            
            jRadioMasterCad.setVisible(false);
            jRadioVisaCad.setVisible(true);
            
        } else if (jComboBandeira.getSelectedItem().equals("Master")) {
            
            jRadioVisaCad.setVisible(false);
            jRadioMasterCad.setVisible(true);
        } else if (jComboBandeira.getSelectedItem().equals("-")) {
            
            jRadioVisaCad.setVisible(false);
            jRadioMasterCad.setVisible(false);
        }

    }//GEN-LAST:event_jComboBandeiraItemStateChanged

    private void lmparCamposCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lmparCamposCadActionPerformed
        limpaTela(jPanelCadastro);
        jTextCartaoLinha.setText("");
    }//GEN-LAST:event_lmparCamposCadActionPerformed

    private void jMenuImportarXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImportarXmlActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo XML", "xml");
        fileChooser.addChoosableFileFilter(extensao);
        int retorno = fileChooser.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controle.lerListaXML(file);
            JOptionPane.showMessageDialog(this, "Arquivo XML importado\n", "Exportação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // dialogo cancelado
        }
        

    }//GEN-LAST:event_jMenuImportarXmlActionPerformed

    private void jMenuImportarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImportarTXTActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo txt", "txt");
        fileChooser.addChoosableFileFilter(extensao);
        int retorno = fileChooser.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controle.lerListaCartoesTxt(file);
            JOptionPane.showMessageDialog(this, "Arquivo TXT importado da pasta do projeto\n", "Exportação", JOptionPane.INFORMATION_MESSAGE);
            preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
        } else {
            // dialogo cancelado
        }
        

    }//GEN-LAST:event_jMenuImportarTXTActionPerformed

    private void jMenuImportarJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImportarJsonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo Json", "json");
        fileChooser.addChoosableFileFilter(extensao);
        int retorno = fileChooser.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controle.lerListaJson(file);
            JOptionPane.showMessageDialog(this, "Arquivo Json importado da pasta do projeto\n", "Importação", JOptionPane.INFORMATION_MESSAGE);
            preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
        } else {
            // dialogo cancelado
        }
        

    }//GEN-LAST:event_jMenuImportarJsonActionPerformed

    private void jMenuIExportarDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIExportarDatActionPerformed
        JFileChooser salvandoArquivo = new JFileChooser();
        salvandoArquivo.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo XML", "xml");
        salvandoArquivo.setFileFilter(extensao);
        int resultado = salvandoArquivo.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
            controle.salvarListaObjeto(salvarArquivoEscolhido);
            JOptionPane.showMessageDialog(this, "Arquivo DAT exportado\n", "Importação", JOptionPane.INFORMATION_MESSAGE);
            preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
        } else {
            // JOptionPane.showMessageDialog(this, "Erro ao salvar\n", "Exportação", JOptionPane.ERROR);
        }
        

    }//GEN-LAST:event_jMenuIExportarDatActionPerformed

    private void jMenuImportarDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImportarDatActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter extensao = new FileNameExtensionFilter("Arquivo DAT", "dat");
        fileChooser.addChoosableFileFilter(extensao);
        int retorno = fileChooser.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                controle.lerListaCartoesObjeto(file);
                JOptionPane.showMessageDialog(this, "Arquivo DAT importado da pasta do projeto\n", "Importação", JOptionPane.INFORMATION_MESSAGE);// TODO add your handling code here:
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaTef.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro na importação do DAT\n", "Importação", JOptionPane.ERROR_MESSAGE);
                preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
            }
        } else {
            // dialogo cancelado
        }
        

    }//GEN-LAST:event_jMenuImportarDatActionPerformed

    private void jButtonPesExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesExcluirActionPerformed
        String numeroCartao = (String) jTableCartoesListaPesq.getValueAt(jTableCartoesListaPesq.getSelectedRow(), 1);
        System.out.println("numero " + numeroCartao);
        controle.removeByNumero(numeroCartao);
        JOptionPane.showMessageDialog(this, "Cartão " + numeroCartao + " removido", "Excluir", JOptionPane.INFORMATION_MESSAGE);
        preencherTabelaCartao(tabelaCartoesModel, (ArrayList<Cartao>) controle.dao.getTodos());
        limparListaPesquisa();
        jButtonPesBuscar.setVisible(true);
        System.out.println("Removido");
    }//GEN-LAST:event_jButtonPesExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
//Metal Nimbus CDE/Motif  GTK+
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaTef.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTef.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTef.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTef.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTef().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JToggleButton jBotaoCartaoLinha;
    private javax.swing.JButton jBotaoSalvarCartao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPesBuscar;
    private javax.swing.JButton jButtonPesExcluir;
    private javax.swing.JCheckBox jCheckBoxPesTitular;
    private javax.swing.JComboBox jComboBandeira;
    private javax.swing.JComboBox jComboPesBandeira;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPesConta;
    private javax.swing.JLabel jLabelPesDigito;
    private javax.swing.JLabel jLabelPesNomeCartaoBandeira;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuArquivoSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuExportar;
    private javax.swing.JMenuItem jMenuIExportarDat;
    private javax.swing.JMenuItem jMenuIExportarJson;
    private javax.swing.JMenuItem jMenuIExportarTXT;
    private javax.swing.JMenuItem jMenuIExportarXML;
    private javax.swing.JMenu jMenuImportar;
    private javax.swing.JMenuItem jMenuImportarDat;
    private javax.swing.JMenuItem jMenuImportarJson;
    private javax.swing.JMenuItem jMenuImportarTXT;
    private javax.swing.JMenuItem jMenuImportarXml;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jMenuVisualizar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelListar;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JRadioButton jRadioAdicional;
    private javax.swing.JRadioButton jRadioMaster;
    private javax.swing.JRadioButton jRadioMasterCad;
    private javax.swing.JRadioButton jRadioPesqAgencia;
    private javax.swing.JRadioButton jRadioPesqBandeira;
    private javax.swing.JRadioButton jRadioPesqConta;
    private javax.swing.JRadioButton jRadioPesqContaTitular;
    private javax.swing.JRadioButton jRadioPesqNCartao;
    private javax.swing.JRadioButton jRadioPesqNome;
    private javax.swing.JRadioButton jRadioTitular;
    private javax.swing.JRadioButton jRadioVisa;
    private javax.swing.JRadioButton jRadioVisaCad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JScrollPane jScrollPaneTabela1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinnerDigAgencia;
    private javax.swing.JSpinner jSpinnerDigConta;
    private javax.swing.JTabbedPane jTabbedPaneCartao;
    private javax.swing.JTable jTableCartoesLista;
    private javax.swing.JTable jTableCartoesListaPesq;
    private javax.swing.JTextField jTextAgencia;
    private javax.swing.JTextArea jTextCartaoLinha;
    private javax.swing.JTextField jTextConta;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextPesNomeCartao;
    private javax.swing.JTextField jTextPesqContaAgencia;
    private javax.swing.JTextField jTextPesqVerificador;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton lmparCamposCad;
    // End of variables declaration//GEN-END:variables

    private class ItemSelecionado implements ItemListener {
        
        public void itemStateChanged(ItemEvent e) {
            for (int i = 0; i < escolha.length; i++) {
                if (escolha[i].isSelected()) {
                    atualiza(i);
                }
            }
        }
    }
    
    public void atualiza(int i) {
        try {
            UIManager.setLookAndFeel(looks[i].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
