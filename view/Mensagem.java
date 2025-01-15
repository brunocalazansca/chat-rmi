package view;

import chat.Cliente;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Mensagem extends javax.swing.JFrame {
    public static ArrayList<String> historicoMensagem = new ArrayList<>();
    public static ArrayList<String> nomeEMensagem = new ArrayList<>();
    Cliente cliente = new Cliente();

    public Mensagem() {
        initComponents();
        setLocationRelativeTo(null);
        lblMensagem.setEditable(false);

        clicar();
        setNomeEntrou();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnHistorico = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblConectadas = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMensagemDigitada = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblMensagem = new javax.swing.JTextArea();
        btnSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtNome = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        btnHistorico.setBackground(new java.awt.Color(255, 255, 255));
        btnHistorico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHistorico.setForeground(new java.awt.Color(0, 0, 0));
        btnHistorico.setText("Histórico de Mensagens");
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Pessoas Conectadas:");

        lblConectadas.setBackground(new java.awt.Color(255, 255, 255));
        lblConectadas.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConectadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConectadas, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Digite sua mensagem: ");

        txtMensagemDigitada.setBackground(new java.awt.Color(153, 153, 153));
        txtMensagemDigitada.setForeground(new java.awt.Color(255, 255, 255));
        txtMensagemDigitada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensagemDigitadaActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(255, 255, 255));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 0, 0));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblMensagem.setBackground(new java.awt.Color(204, 204, 204));
        lblMensagem.setColumns(20);
        lblMensagem.setRows(5);
        jScrollPane1.setViewportView(lblMensagem);

        btnSair.setBackground(new java.awt.Color(255, 255, 255));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMensagemDigitada)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMensagemDigitada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnSair))
                .addGap(10, 10, 10))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHistorico))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        getMensagem();
    }

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {
        new Historico().setVisible(true);
        this.dispose();
    }

    private void txtMensagemDigitadaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        // System.exit(0);
        setNomeSaiu();
    }

    private void getMensagem() {
        Cliente cliente = new Cliente();
        String nome = txtNome.getText();
        String mensagem = txtMensagemDigitada.getText();
        ArrayList<String> mensagemRecebida;

        mensagemRecebida = cliente.getMensagem(nome, mensagem);
        if (mensagemRecebida.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma mensagem inserida. \nPor favor, digite uma mensagem!");

        } else {
            String chatFormatado = String.join("\n", mensagemRecebida);
            lblMensagem.setText(chatFormatado);
            historicoMensagem.clear();
            historicoMensagem.add(chatFormatado);

        }
        txtMensagemDigitada.setText("");
    }

    private void clicar() {
        txtMensagemDigitada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnEnviar.doClick();
                }
            }
        });
    }

    private void setNomeEntrou(){
        ArrayList<String> nomeColetado = Entrar.getNomeDigitado();
        String nome = nomeColetado.getLast();
        txtNome.setText(nome);
        lblConectadas.setText(nome);
    }

    private void setNomeSaiu(){
        String nomeSaiu = txtNome.getText();
        ArrayList<String> nomeColetado = cliente.nomeSaiu(nomeSaiu);
        Entrar.getNomeDigitado().remove(nomeColetado.toString());
        String mensagemSaida = nomeColetado.getLast() + " saiu.";
        lblMensagem.setText(mensagemSaida);

        // Remove o noma da lista de pessoas conectadas
        String nomesConectados = lblConectadas.getText();
        ArrayList<String> listaNomes = new ArrayList<>(Arrays.asList(nomesConectados.split(", ")));
        listaNomes.removeIf(nome -> nome.equalsIgnoreCase(nomeSaiu));
        String nomesAtualizados = String.join(", ", listaNomes);
        lblConectadas.setText(nomesAtualizados);

    }

    public static ArrayList<String> getHistoricoMensagem() {
        return historicoMensagem;
    }

    public ArrayList<String> nomeEntrouSaiu (String nome) {
        Cliente cliente = new Cliente();
        ArrayList<String> nomeRecebido = cliente.nomeEntrou(nome);
        return nomeRecebido;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mensagem().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lblConectadas;
    private javax.swing.JTextArea lblMensagem;
    private javax.swing.JTextField txtMensagemDigitada;
    private javax.swing.JLabel txtNome;
}
