//NOME: JOAO GUILHERME DE SOUZA - RA:2479516
//TURMA: ADS 2023/1



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MenuPrincipal extends javax.swing.JFrame {

    private final ArrayList<Banco> bancos = new ArrayList<>();
    private final ArrayList<Pessoa> pessoas = new ArrayList<>();
    Banco bancoAtual = null;
    Agencia agenciaAtual = null;
    Conta armazena;
    
    public MenuPrincipal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   public void menuPrincipal() {
        JFrame frame = new JFrame("Sistema Bancário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(":: S I S T E M A   B A N C A R I O ::");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(3, 1));
        JButton adminButton = new JButton("Administrar o Sistema");
        JButton clienteButton = new JButton("Acessar como Cliente");
        JButton sairButton = new JButton("Sair");
        menuPanel.add(adminButton);
        menuPanel.add(clienteButton);
        menuPanel.add(sairButton);
        frame.add(menuPanel, BorderLayout.CENTER);

        adminButton.addActionListener(e -> menuAdministrarSistema());
        clienteButton.addActionListener(e -> menuCliente());
        sairButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Obrigado por usar o Sistema Bancario");
            System.exit(0);
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
} 
   
   public void menuAdministrarSistema() {
        JFrame frame = new JFrame("Administração do Sistema");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(":: A D M I N I S T R A C A O  D O  S I S T E M A ::");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(5, 1));
        JButton gerenciarBancosButton = new JButton("Gerenciar Bancos");
        JButton gerenciarPessoasButton = new JButton("Gerenciar Pessoas");
        JButton gerenciarAgenciasButton = new JButton("Gerenciar Agencias");
        JButton gerenciarContasButton = new JButton("Gerenciar Contas");
        JButton voltarButton = new JButton("Voltar ao Menu Anterior");
        menuPanel.add(gerenciarBancosButton);
        menuPanel.add(gerenciarPessoasButton);
        menuPanel.add(gerenciarAgenciasButton);
        menuPanel.add(gerenciarContasButton);
        menuPanel.add(voltarButton);
        frame.add(menuPanel, BorderLayout.CENTER);

        gerenciarBancosButton.addActionListener(e -> menuGerenciarBancos());
        gerenciarPessoasButton.addActionListener(e -> menuGerenciarPessoas());
        gerenciarAgenciasButton.addActionListener(e -> menuGerenciarAgencias());
        gerenciarContasButton.addActionListener(e -> menuGerenciarContas());
        voltarButton.addActionListener(e -> frame.dispose());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
}
 
    private void menuGerenciarBancos() {
       
        JFrame frame = new JFrame("Gerenciar Bancos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(":: G E R E N C I A R  B A N C O S ::");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(6, 1));
        JButton novoBancoButton = new JButton("Novo Banco");
        JButton listarBancosButton = new JButton("Listar Bancos");
        JButton pesquisarBancoButton = new JButton("Pesquisar Banco");
        JButton excluirBancoButton = new JButton("Excluir Banco");
        JButton atualizarBancoButton = new JButton("Atualizar Banco");
        JButton voltarButton = new JButton("Voltar ao Menu Anterior");
        menuPanel.add(novoBancoButton);
        menuPanel.add(listarBancosButton);
        menuPanel.add(pesquisarBancoButton);
        menuPanel.add(excluirBancoButton);
        menuPanel.add(atualizarBancoButton);
        menuPanel.add(voltarButton);
        frame.add(menuPanel, BorderLayout.CENTER);

        novoBancoButton.addActionListener(e -> cadastrarBanco());
        listarBancosButton.addActionListener(e -> listarBancos());
        //pesquisarBancoButton.addActionListener(e -> pesquisarBanco());
        pesquisarBancoButton.addActionListener(e -> {
        String pesquisa = JOptionPane.showInputDialog(this, "Digite o ID, número ou nome do banco:");
        Banco bancoEncontrado = pesquisarBanco(pesquisa);
        if (bancoEncontrado != null) {
            // Faça algo com o banco encontrado, como exibir informações em uma caixa de diálogo
            JOptionPane.showMessageDialog(this, "Banco encontrado:\n" +
                    "ID: " + bancoEncontrado.getId() + "\n" +
                    "Número: " + bancoEncontrado.getNumero() + "\n" +
                    "Nome: " + bancoEncontrado.getNome(), "Banco Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Banco não encontrado!", "Pesquisa de Banco", JOptionPane.ERROR_MESSAGE);
             }
        });

        excluirBancoButton.addActionListener(e -> excluirBanco());
        atualizarBancoButton.addActionListener(e -> atualizarBanco());
        voltarButton.addActionListener(e -> frame.dispose());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }

        private void listarBancos() {
            StringBuilder sb = new StringBuilder();
            for (Banco banco : bancos) {
                sb.append("\nId: ").append(banco.getId());
                sb.append("\nNumero: ").append(banco.getNumero());
                sb.append("\nNome: ").append(banco.getNome());
                sb.append("\nQuant Agencias: ").append(banco.getAgencias().size());
                sb.append("\n--------------------------");
            }
            JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Bancos", JOptionPane.INFORMATION_MESSAGE);
        }

        private void cadastrarBanco() {
            String numeroBanco = JOptionPane.showInputDialog(this, "Numero do banco:");
            String nomeBanco = JOptionPane.showInputDialog(this, "Nome do banco:");

            Banco.contadorBancos++;

            Banco b = new Banco(Banco.contadorBancos, nomeBanco, numeroBanco);

            bancos.add(b);

            JOptionPane.showMessageDialog(this, "O banco foi criado com sucesso", "Cadastro de Banco", JOptionPane.INFORMATION_MESSAGE);
        }



        public Banco pesquisarBanco(String pesquisaBanco) {
                Banco b = null;

                for (int i = 0; i < bancos.size(); i++) {
                    if (Integer.toString(bancos.get(i).getId()).equals(pesquisaBanco)) {
                        return bancos.get(i);
                    } else if (bancos.get(i).getNome().contains(pesquisaBanco)) {
                        return bancos.get(i);
                    } else if (bancos.get(i).getNumero().contains(pesquisaBanco)) {
                        return bancos.get(i);
                    }
                }

                return b;
            }

        private void excluirBanco() {
            String pesquisaBanco = JOptionPane.showInputDialog(this, "Informe o ID, número ou nome do Banco a ser excluído:");

            Banco banco = pesquisarBanco(pesquisaBanco);

            if (banco == null) {
                JOptionPane.showMessageDialog(this, "O banco não foi encontrado", "Exclusão de Banco", JOptionPane.ERROR_MESSAGE);
            } else {
                bancos.remove(banco);
                JOptionPane.showMessageDialog(this, "Banco excluído com sucesso", "Exclusão de Banco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void atualizarBanco() {
            String pesquisaBanco = JOptionPane.showInputDialog(this, "Informe o ID, número ou nome do Banco a ser atualizado:");

            Banco banco = pesquisarBanco(pesquisaBanco);

            if (banco == null) {
                JOptionPane.showMessageDialog(this, "O banco não foi encontrado", "Atualização de Banco", JOptionPane.ERROR_MESSAGE);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("\nId: ").append(banco.getId());
                sb.append("\nNumero: ").append(banco.getNumero());
                sb.append("\nNome: ").append(banco.getNome());
                sb.append("\nQuant Agencias: ").append(banco.getAgencias().size());

                sb.append("\n\nInforme os novos dados:");
                String novoNumeroBanco = JOptionPane.showInputDialog(this, "Novo número do banco:", banco.getNumero());
                String novoNomeBanco = JOptionPane.showInputDialog(this, "Novo nome do banco:", banco.getNome());

                banco.setNumero(novoNumeroBanco);
                banco.setNome(novoNomeBanco);

                JOptionPane.showMessageDialog(this, "Banco atualizado com sucesso", "Atualização de Banco", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
     private void menuGerenciarPessoas() {
       
        JFrame frame = new JFrame("Gerenciar Pessoas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(":: G E R E N C I A R  P E S S O A S ::");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(6, 1));
        JButton novoPessoaButton = new JButton("Cadastrar Pessoa");
        JButton listarPessoaButton = new JButton("Listar Pessoas");
        JButton pesquisarPessoaButton = new JButton("Pesquisar Pessoa");
        JButton excluirPessoaButton = new JButton("Excluir Pessoa");
        JButton voltarButton = new JButton("Voltar ao Menu Anterior");
        menuPanel.add(novoPessoaButton);
        menuPanel.add(listarPessoaButton);
        menuPanel.add(pesquisarPessoaButton);
        menuPanel.add(excluirPessoaButton);
        menuPanel.add(voltarButton);
        frame.add(menuPanel, BorderLayout.CENTER);

        novoPessoaButton.addActionListener(e -> cadastrarPessoa());
        listarPessoaButton.addActionListener(e -> listarPessoa());
        pesquisarPessoaButton.addActionListener(e -> pesquisarPessoa());
        excluirPessoaButton.addActionListener(e -> excluirPessoa());
        voltarButton.addActionListener(e -> frame.dispose());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }
     
     
     private void cadastrarPessoa() {
        String[] tipos = { "Pessoa Fisica", "Pessoa Juridica", "Retornar" };
        int tipo = JOptionPane.showOptionDialog(null, "Selecione o tipo de pessoa:", "Cadastro de Pessoa",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);

        if (tipo == 2) {
            return;
        }

        String nome = JOptionPane.showInputDialog(null, "Nome:");
        String endereco = JOptionPane.showInputDialog(null, "Endereço:");
        String contato = JOptionPane.showInputDialog(null, "Contato:");

        switch (tipo) {
            case 0 ->  { // Pessoa Fisica
                String cpf = JOptionPane.showInputDialog(null, "CPF:");
                int rg = Integer.parseInt(JOptionPane.showInputDialog(null, "RG:"));
                String dataNascimentoStr = JOptionPane.showInputDialog(null, "Data de Nascimento (AAAA-MM-DD):");
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
                PessoaFisica pessoaFisica = new PessoaFisica(nome, endereco, contato, cpf, rg, dataNascimento);
                pessoas.add(pessoaFisica);
                JOptionPane.showMessageDialog(null, "Pessoa física cadastrada com sucesso.", "Cadastro de Pessoa",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            case 1 ->  { // Pessoa Juridica
                String cnpj = JOptionPane.showInputDialog(null, "CNPJ:");
                String razaoSocial = JOptionPane.showInputDialog(null, "Razão Social:");
                PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, endereco, contato, cnpj, razaoSocial);
                pessoas.add(pessoaJuridica);
                JOptionPane.showMessageDialog(null, "Pessoa jurídica cadastrada com sucesso.", "Cadastro de Pessoa",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
     
    private void listarPessoa() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa pessoa : pessoas) {
            sb.append("\nNome: ").append(pessoa.getNome());
            sb.append("\nEndereço: ").append(pessoa.getEndereco());
            sb.append("\nContato: ").append(pessoa.getContato());

            if (pessoa instanceof PessoaFisica pessoaFisica) {
                sb.append("\nCPF: ").append(pessoaFisica.getCpf());
                sb.append("\nRG: ").append(pessoaFisica.getRg());
                sb.append("\nData de Nascimento: ").append(pessoaFisica.getDataNascimento());
            } else if (pessoa instanceof PessoaJuridica pessoaJuridica) {
                sb.append("\nCNPJ: ").append(pessoaJuridica.getCnpj());
                sb.append("\nRazão Social: ").append(pessoaJuridica.getSocial());
            }

            sb.append("\n--------------------------");
        }

    JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);
}

    private void pesquisarPessoa() {
    String nomePesquisa = JOptionPane.showInputDialog(this, "Digite o nome da pessoa a ser pesquisada:");

    boolean encontrada = false;
    StringBuilder sb = new StringBuilder();

    for (Pessoa pessoa : pessoas) {
        if (pessoa.getNome().equalsIgnoreCase(nomePesquisa)) {
            encontrada = true;

            sb.append("Nome: ").append(pessoa.getNome()).append("\n");
            sb.append("Endereço: ").append(pessoa.getEndereco()).append("\n");
            sb.append("Contato: ").append(pessoa.getContato()).append("\n");

            if (pessoa instanceof PessoaFisica pessoaFisica) {
                sb.append("CPF: ").append(pessoaFisica.getCpf()).append("\n");
                sb.append("RG: ").append(pessoaFisica.getRg()).append("\n");
                sb.append("Data de Nascimento: ").append(pessoaFisica.getDataNascimento()).append("\n");
            } else if (pessoa instanceof PessoaJuridica pessoaJuridica) {
                sb.append("CNPJ: ").append(pessoaJuridica.getCnpj()).append("\n");
                sb.append("Razão Social: ").append(pessoaJuridica.getSocial()).append("\n");
            }

            sb.append("--------------------------\n");

            break;
        }
    }

    if (!encontrada) {
        sb.append("Pessoa não encontrada.\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString(), "Resultado da Pesquisa", JOptionPane.INFORMATION_MESSAGE);
}
    
    public Pessoa pesquisarPessoa(String pesquisaPessoa) {
        Pessoa p = null;

        // esta pessoa existe?
        for (int i = 0; i < pessoas.size(); i++) {
            // pesquisa pelo id
            if (!(pessoas.get(i).getContato()).equals(pesquisaPessoa)) {
                if (pessoas.get(i).getNome().contains(pesquisaPessoa)) {
                    return pessoas.get(i);
                }
            } // pesquisar por nome
            else {
                return pessoas.get(i);
            }
        }

        return p;
    }

    
    private void excluirPessoa() {
    String nomeExclusao = JOptionPane.showInputDialog(this, "Digite o nome da pessoa a ser excluída:");

    boolean encontrada = false;

    for (int i = 0; i < pessoas.size(); i++) {
        Pessoa pessoa = pessoas.get(i);
        if (pessoa.getNome().equalsIgnoreCase(nomeExclusao)) {
            encontrada = true;

            pessoas.remove(i);

            JOptionPane.showMessageDialog(this, "Pessoa excluída com sucesso.", "Exclusão de Pessoa", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }

    if (!encontrada) {
        JOptionPane.showMessageDialog(this, "Pessoa não encontrada.", "Exclusão de Pessoa", JOptionPane.WARNING_MESSAGE);
    }
}

    public int menuGerenciarAgencias() {
    //Agencia armazena;
    //String pesquisaAgencia;

    while (bancoAtual == null) {
        String pesquisaBanco = JOptionPane.showInputDialog(this, "Informe o ID, número ou nome do banco:");

        Banco b = pesquisarBanco(pesquisaBanco);
        if (b == null) {
            int opcao = JOptionPane.showOptionDialog(this, "O banco não foi encontrado.", "Gerenciar Agências",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    new Object[] { "Pesquisar novamente", "Voltar ao menu anterior" }, null);
            if (opcao == 1) {
                return 1;
            }
        } else {
            bancoAtual = b;
        }
    }

    JFrame frame = new JFrame("Gerenciar Agências");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel(":: G E R E N C I A R  A G Ê N C I A S ::");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    frame.add(titleLabel, BorderLayout.NORTH);

    JPanel menuPanel = new JPanel(new GridLayout(6, 1));
    JButton novaAgenciaButton = new JButton("Nova Agência");
    JButton listarAgenciasButton = new JButton("Listar Agências");
    JButton pesquisarAgenciaButton = new JButton("Pesquisar Agência");
    JButton excluirAgenciaButton = new JButton("Excluir Agência");
    JButton atualizarAgenciaButton = new JButton("Atualizar Agência");
    JButton voltarButton = new JButton("Voltar ao Menu Anterior");
    menuPanel.add(novaAgenciaButton);
    menuPanel.add(listarAgenciasButton);
    menuPanel.add(pesquisarAgenciaButton);
    menuPanel.add(excluirAgenciaButton);
    menuPanel.add(atualizarAgenciaButton);
    menuPanel.add(voltarButton);
    frame.add(menuPanel, BorderLayout.CENTER);

    novaAgenciaButton.addActionListener(e -> cadastrarAgencia());
    listarAgenciasButton.addActionListener(e -> listarAgencia());
    pesquisarAgenciaButton.addActionListener(e -> pesquisarAgencia());
    excluirAgenciaButton.addActionListener(e -> excluirAgencia());
    atualizarAgenciaButton.addActionListener(e -> atualizarAgencia());
    voltarButton.addActionListener(e -> frame.dispose());

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    return 0;
}
    
    private void cadastrarAgencia(){
        
        String numeroAgencia = JOptionPane.showInputDialog(this, "Numero da Agencia:");
        String cidadeAgencia = JOptionPane.showInputDialog(this, "Cidade/Estado da Agencia:");

        Agencia.contadorAgencias++;

        Agencia a = new Agencia(bancoAtual, Agencia.contadorAgencias, numeroAgencia, cidadeAgencia);

        bancoAtual.getAgencias().add(a);

        JOptionPane.showMessageDialog(this, "A Agencia foi criada com sucesso", "Cadastro de Agencia", JOptionPane.INFORMATION_MESSAGE);
}
    
    private void listarAgencia() {
    if (bancoAtual.getAgencias().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nao ha nenhuma agencia cadastrada neste banco.", "Lista de Agencias", JOptionPane.INFORMATION_MESSAGE);
    } else {
        StringBuilder agenciasInfo = new StringBuilder();
        for (Agencia agencia : bancoAtual.getAgencias()) {
            agenciasInfo.append("\nId: ").append(agencia.getId());
            agenciasInfo.append("\nNumero: ").append(agencia.getNumero());
            agenciasInfo.append("\nCidade/Estado: ").append(agencia.getCidade());
            agenciasInfo.append("\nQuant Contas Bancarias: ").append(agencia.getContas().size());
            agenciasInfo.append("\n--------------------------\n");
        }
        JOptionPane.showMessageDialog(this, agenciasInfo.toString(), "Lista de Agencias", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    private void pesquisarAgencia() {
    String pesquisaAgencia = JOptionPane.showInputDialog(this, "Informe o id, numero ou cidade da agencia:");

    Agencia agencia = pesquisarAgencia(bancoAtual, pesquisaAgencia);

    if (agencia == null) {
        JOptionPane.showMessageDialog(this, "A agencia nao foi encontrada.", "Pesquisa de Agencia", JOptionPane.INFORMATION_MESSAGE);
    } else {
        StringBuilder agenciaInfo = new StringBuilder();
        agenciaInfo.append("\nId: ").append(agencia.getId());
        agenciaInfo.append("\nNumero: ").append(agencia.getNumero());
        agenciaInfo.append("\nCidade/Estado: ").append(agencia.getCidade());
        agenciaInfo.append("\nQuant Contas Bancarias: ").append(agencia.getContas().size());
        JOptionPane.showMessageDialog(this, agenciaInfo.toString(), "Pesquisa de Agencia", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    
    private void excluirAgencia() {
        
        String pesquisaAgencia = JOptionPane.showInputDialog(this, "Informe o id, numero ou cidade da agencia:");

        Agencia agencia = pesquisarAgencia(bancoAtual, pesquisaAgencia);

        if (agencia == null) {
            JOptionPane.showMessageDialog(this, "A agencia nao foi encontrada.", "Exclusao de Agencia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            bancoAtual.getAgencias().remove(agencia);
            JOptionPane.showMessageDialog(this, "Agencia excluida com sucesso.", "Exclusao de Agencia", JOptionPane.INFORMATION_MESSAGE);
        }
}
    
    private void atualizarAgencia() {
    
        String pesquisaAgencia = JOptionPane.showInputDialog(this, "Informe o id, numero ou cidade da agencia:");

        Agencia agencia = pesquisarAgencia(bancoAtual, pesquisaAgencia);

        if (agencia == null) {
            JOptionPane.showMessageDialog(this, "A agencia nao foi encontrada.", "Atualizacao de Agencia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String message = "Dados atuais desta agencia:\n\n" +
                    "Id: " + agencia.getId() + "\n" +
                    "Numero: " + agencia.getNumero() + "\n" +
                    "Cidade/Estado: " + agencia.getCidade() + "\n" +
                    "Quant Contas Bancarias: " + agencia.getContas().size() + "\n\n" +
                    "Informe os novos dados:";

            String novoNumeroAgencia = JOptionPane.showInputDialog(this, message + "\nNovo Numero da Agencia:");
            String novaCidadeAgencia = JOptionPane.showInputDialog(this, message + "\nNova cidade/Estado da Agencia:");

            agencia.setNumero(novoNumeroAgencia);
            agencia.setCidade(novaCidadeAgencia);

            JOptionPane.showMessageDialog(this, "Agencia atualizada com sucesso.", "Atualizacao de Agencia", JOptionPane.INFORMATION_MESSAGE);
    }
}

    public Agencia pesquisarAgencia(Banco b, String pesquisaAgencia) {
        Agencia a = null;

        for (int i = 0; i < b.getAgencias().size(); i++) {

            if (Integer.toString(b.getAgencias().get(i).getId()).equals(pesquisaAgencia)) {
                return b.getAgencias().get(i);
            } else if (b.getAgencias().get(i).getNumero().contains(pesquisaAgencia)) {
                return b.getAgencias().get(i);
            } else if (b.getAgencias().get(i).getCidade().contains(pesquisaAgencia)) {
                return b.getAgencias().get(i);
            }
        }

        return a;
    }


    public int menuGerenciarContas() {
    //Agencia armazena;
    //String pesquisaAgencia;

    while (bancoAtual == null) {
        String pesquisaBanco = JOptionPane.showInputDialog(this, "Informe o ID, número ou nome do banco:");

        Banco b = pesquisarBanco(pesquisaBanco);
        if (b == null) {
            int opcao = JOptionPane.showOptionDialog(this, "O banco não foi encontrado.", "Gerenciar Agências",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    new Object[] { "Pesquisar novamente", "Voltar ao menu anterior" }, null);
            if (opcao == 1) {
                return 1;
            }
        } else {
            bancoAtual = b;
        }
    }
    
    while (agenciaAtual == null) {

            String pesquisaAgencia = JOptionPane.showInputDialog(this, "\nInforme o id, numero ou cidade da agencia: ");

            Agencia a = pesquisarAgencia(bancoAtual, pesquisaAgencia);
            if (a == null) {
                    int opcao = JOptionPane.showOptionDialog(this, "A agencia não foi encontrada.", "Gerencias Contas",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    new Object[] { "Pesquisar novamente", "Voltar ao menu anterior" }, null);
                if (opcao == 2) {
                    return 1;
                }
            } else {
                agenciaAtual = a;
            }
        }

            JFrame frame = new JFrame("Gerenciar Contas");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JLabel titleLabel = new JLabel(":: G E R E N C I A R  C O N T A S ::");
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.add(titleLabel, BorderLayout.NORTH);

            JPanel menuPanel = new JPanel(new GridLayout(6, 1));
            JButton novaContaButton = new JButton("Abertura de Nova Conta");
            JButton listarContasButton = new JButton("Listar Contas");
            JButton pesquisarContasButton = new JButton("Pesquisar Conta");
            JButton excluirContasButton = new JButton("Excluir Conta");
            JButton atualizarContasButton = new JButton("Atualizar Conta");
            JButton voltarButton = new JButton("Voltar ao Menu Anterior");
            menuPanel.add(novaContaButton);
            menuPanel.add(listarContasButton);
            menuPanel.add(pesquisarContasButton);
            menuPanel.add(excluirContasButton);
            menuPanel.add(atualizarContasButton);
            menuPanel.add(voltarButton);
            frame.add(menuPanel, BorderLayout.CENTER);

            novaContaButton.addActionListener(e -> cadastrarContas());
            listarContasButton.addActionListener(e -> listarContas());
            pesquisarContasButton.addActionListener(e -> pesquisarContas());
            excluirContasButton.addActionListener(e -> excluirContas());
            atualizarContasButton.addActionListener(e -> atualizarContas());
            voltarButton.addActionListener(e -> frame.dispose());

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            return 0;
        }
 
    private void cadastrarContas() {
        String numeroConta = JOptionPane.showInputDialog(this, "Numero da conta:");
        double limiteConta = Double.parseDouble(JOptionPane.showInputDialog(this, "Limite da Conta:"));

        Pessoa cliente = null;
        while (cliente == null) {
            String pesquisaPessoa = JOptionPane.showInputDialog(this, "Informe nome do cliente:");

            cliente = pesquisarPessoa(pesquisaPessoa);
            if (cliente == null) {
                int opcaoTemp = JOptionPane.showOptionDialog(this, "Cliente nao encontrado.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior:", "Cadastro de Conta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"1", "2"}, "2");

                if (opcaoTemp == 2) {
                    return;
                }
            }
        }

        Conta.contadorContas++;

        Conta conta = new Conta(agenciaAtual, cliente, Conta.contadorContas, numeroConta, 0.0, limiteConta);

        agenciaAtual.getContas().add(conta);

        JOptionPane.showMessageDialog(this, "Uma nova conta foi criada para o cliente: " + cliente.getNome() +
                "\ncom saldo inicial de R$ 0,00 e limite inicial de R$ " + limiteConta, "Cadastro de Conta", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarContas() {
        if (agenciaAtual.getContas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nao ha nenhuma conta cadastrada nesta agencia.", "Lista de Contas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contasInfo = new StringBuilder();
            for (Conta conta : agenciaAtual.getContas()) {
                contasInfo.append("\nId da conta bancaria: ").append(conta.getId())
                        .append("\nNumero da conta: ").append(conta.getNumero())
                        .append("\nCliente: ").append(conta.getCliente().getNome())
                        .append("\nAgencia: ").append(agenciaAtual.getNumero()).append(" - ").append(agenciaAtual.getCidade())
                        .append("\nBanco: ").append(bancoAtual.getNumero()).append(" - ").append(bancoAtual.getNome())
                        .append("\nSaldo atual: ").append(conta.getSaldo())
                        .append("\nLimite atual: ").append(conta.getLimite())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(this, contasInfo.toString(), "Lista de Contas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    private void pesquisarContas() {
        String pesquisaConta = JOptionPane.showInputDialog(this, "Informe o id, o numero ou nome do cliente da conta:");
        armazena = pesquisarConta(agenciaAtual, pesquisaConta);
        if (armazena == null) {
            JOptionPane.showMessageDialog(this, "A conta nao foi encontrada nesta agencia.", "Pesquisar Conta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contaInfo = new StringBuilder();
            contaInfo.append("\nId da conta bancaria: ").append(armazena.getId())
                    .append("\nNumero da conta: ").append(armazena.getNumero())
                    .append("\nCliente: ").append(armazena.getCliente().getNome())
                    .append("\nAgencia: ").append(agenciaAtual.getNumero()).append(" - ").append(agenciaAtual.getCidade())
                    .append("\nBanco: ").append(bancoAtual.getNumero()).append(" - ").append(bancoAtual.getNome())
                    .append("\nSaldo atual: ").append(armazena.getSaldo())
                    .append("\nLimite atual: ").append(armazena.getLimite());
            JOptionPane.showMessageDialog(this, contaInfo.toString(), "Pesquisar Conta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

   
    private void excluirContas() {
        String pesquisaConta = JOptionPane.showInputDialog(this, "Informe o id, numero ou nome do cliente da conta:");
        armazena = pesquisarConta(agenciaAtual, pesquisaConta);
        if (armazena == null) {
            JOptionPane.showMessageDialog(this, "A conta nao foi encontrada nesta agencia.", "Excluir Conta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            agenciaAtual.getContas().remove(armazena);
            JOptionPane.showMessageDialog(this, "Conta excluida com sucesso.", "Excluir Conta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

   
    private void atualizarContas() {
        
        String pesquisaConta = JOptionPane.showInputDialog(this, "Informe o id, numero ou nome do cliente da conta:");
        armazena = pesquisarConta(agenciaAtual, pesquisaConta);
        if (armazena == null) {
            JOptionPane.showMessageDialog(this, "A conta nao foi encontrada.", "Atualizar Conta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("\nDados atuais desta conta:\n");
            mensagem.append("\nId: ").append(armazena.getId());
            mensagem.append("\nNumero da conta: ").append(armazena.getNumero());
            mensagem.append("\nCliente: ").append(armazena.getCliente().getNome());
            mensagem.append("\nAgencia: ").append(agenciaAtual.getNumero()).append(" - ").append(agenciaAtual.getCidade());
            mensagem.append("\nBanco: ").append(bancoAtual.getNumero()).append(" - ").append(bancoAtual.getNome());
            mensagem.append("\nSaldo atual: ").append(armazena.getSaldo());
            mensagem.append("\nLimite atual: ").append(armazena.getLimite());

            JOptionPane.showMessageDialog(this, mensagem.toString(), "Atualizar Conta - Dados Atuais", JOptionPane.INFORMATION_MESSAGE);

            String novoNumeroConta = JOptionPane.showInputDialog(this, "Novo Numero da conta:");
            double novoLimiteConta = Double.parseDouble(JOptionPane.showInputDialog(this, "Novo limite da conta:"));

            armazena.setNumero(novoNumeroConta);
            armazena.setLimite(novoLimiteConta);

            JOptionPane.showMessageDialog(this, "Conta atualizada com sucesso.", "Atualizar Conta", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public Conta pesquisarConta(Agencia agencia, String pesquisaConta) {
        Conta c = null;

        for (int i = 0; i < agencia.getContas().size(); i++) {

            if (Integer.toString(agencia.getContas().get(i).getId()).equals(pesquisaConta)) {
                return agencia.getContas().get(i);
            } else if (agencia.getContas().get(i).getNumero().contains(pesquisaConta)) {
                return agencia.getContas().get(i);
            } else if (agencia.getContas().get(i).getCliente().getNome().contains(pesquisaConta)) {
                return agencia.getContas().get(i);
            }
        }

        return c;
    }

    public Conta pesquisarContaPorId(int id) {
        Conta c = null;

        for (int i = 0; i < bancos.size(); i++) {

            Banco banco = bancos.get(i);
            for (int j = 0; j < banco.getAgencias().size(); j++) {
                Agencia agencia = banco.getAgencias().get(j);
                for (int x = 0; x < agencia.getContas().size(); x++) {
                    Conta conta = agencia.getContas().get(x);
                    if (conta.getId() == id) {
                        return conta;
                    }
                }
            }
        }

        return c;
    }

    

        public int menuCliente() {
            int idConta;
            Conta conta;
            Transacao transacao;
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            Format formato = new SimpleDateFormat("dd/MM/yyyy");

            Pessoa cliente = null;
            while (cliente == null) {
                String pesquisaPessoa = JOptionPane.showInputDialog(null, "Prezado cliente, informe seu nome:");
            cliente = pesquisarPessoa(pesquisaPessoa);
            if (cliente == null) {
                int opcaoTemp = JOptionPane.showOptionDialog(null,
                        "Cliente não encontrado.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior:",
                        "Cliente não encontrado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
                        new Object[]{"Pesquisar novamente", "Voltar"}, "Pesquisar novamente");
                if (opcaoTemp == 1) {
                    return 1;
                }
            }
        }

        while (true) {
            Object[] options = {"Listar Minhas Contas Bancárias", "Efetuar Depósito", "Efetuar Saque",
                    "Efetuar Transferência", "Obter Extrato", "Voltar ao Menu Anterior"};
            int opcao = JOptionPane.showOptionDialog(null, "A C E S S O   D O   C L I E N T E\n\nCliente Selecionado: "
                            + cliente.getNome() + "\n\nEscolha a opção desejada", "Menu Cliente", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (opcao) {
                case 0 -> {
                    StringBuilder contasInfo = new StringBuilder();
                    for (int i = 0; i < cliente.getContas(bancos).size(); i++) {
                        Conta contaAtualTemp = cliente.getContas(bancos).get(i);
                        contasInfo.append("\nId: ").append(contaAtualTemp.getId())
                                .append("\nNumero da conta: ").append(contaAtualTemp.getNumero())
                                .append("\nCliente: ").append(contaAtualTemp.getCliente().getNome())
                                .append("\nAgencia: ").append(contaAtualTemp.getAgencia().getNumero()).append(" - ")
                                .append(contaAtualTemp.getAgencia().getCidade())
                                .append("\nBanco: ").append(contaAtualTemp.getAgencia().getBanco().getNumero()).append(" - ")
                                .append(contaAtualTemp.getAgencia().getBanco().getNome())
                                .append("\nSaldo atual: ").append(contaAtualTemp.getSaldo())
                                .append("\nLimite atual: ").append(contaAtualTemp.getLimite())
                                .append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, contasInfo.toString(), "Minhas Contas Bancárias",
                            JOptionPane.PLAIN_MESSAGE);
                }
                case 1 -> {
                    try {
                        idConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da conta:"));
                        double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito:"));

                        conta = pesquisarContaPorId(idConta);
                        if (conta == null) {
                            throw new MenuException("Conta não encontrada. Não foi possível efetuar o depósito.");
                        }

                        conta.setSaldo(conta.getSaldo() + valorDeposito);

                        Transacao.contadorTransacoes++;
                        transacao = new Transacao(conta, Transacao.contadorTransacoes, new Date(),
                                "DEPÓSITO", valorDeposito, 'C');
                        conta.getTransacoes().add(transacao);

                        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso.", "Depósito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (MenuException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao efetuar depósito: " + e.getMessage(),
                                "Erro de Depósito", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Certifique-se de fornecer um número válido para o ID da conta e o valor do depósito.",
                                "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 2 -> {
                    try {
                        idConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da conta:"));
                        double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));

                        conta = pesquisarContaPorId(idConta);
                        if (conta == null) {
                            JOptionPane.showMessageDialog(null, "Conta não encontrada. Não foi possível efetuar o saque.",
                                    "Conta não encontrada", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (valorSaque > (conta.getSaldo() + conta.getLimite())) {
                                JOptionPane.showMessageDialog(null, "Saldo e limite insuficientes para este saque.",
                                        "Saldo e Limite Insuficientes", JOptionPane.ERROR_MESSAGE);
                            } else {
                                conta.setSaldo(conta.getSaldo() - valorSaque);

                                Transacao.contadorTransacoes++;
                                transacao = new Transacao(conta, Transacao.contadorTransacoes, new Date(),
                                        "SAQUE", valorSaque, 'D');
                                conta.getTransacoes().add(transacao);
                                JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso.", "Saque",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Certifique-se de fornecer um número válido para o ID da conta e o valor do saque.",
                                "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 3 -> {
                    try {
                        idConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da conta do débito:"));
                        int idContaCredito = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da conta do crédito:"));
                        double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência:"));

                        conta = pesquisarContaPorId(idConta);
                        Conta contaCredito = pesquisarContaPorId(idContaCredito);

                        if (conta == null) {
                            JOptionPane.showMessageDialog(null, "Conta de débito não foi encontrada. Não foi possível efetuar a transferência.",
                                    "Conta de Débito Não Encontrada", JOptionPane.ERROR_MESSAGE);
                        } else if (contaCredito == null) {
                            JOptionPane.showMessageDialog(null, "Conta de crédito não foi encontrada. Não foi possível efetuar a transferência.",
                                    "Conta de Crédito Não Encontrada", JOptionPane.ERROR_MESSAGE);
                        } else if (contaCredito.getId() == conta.getId()) {
                            JOptionPane.showMessageDialog(null, "As contas de débito e crédito não podem ser a mesma.",
                                    "Contas Iguais", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (valorTransferencia > (conta.getSaldo() + conta.getLimite())) {
                                JOptionPane.showMessageDialog(null, "Saldo e limite insuficientes para esta transferência.",
                                        "Saldo e Limite Insuficientes", JOptionPane.ERROR_MESSAGE);
                            } else {
                                conta.setSaldo(conta.getSaldo() - valorTransferencia);
                                contaCredito.setSaldo(contaCredito.getSaldo() + valorTransferencia);

                                Transacao.contadorTransacoes++;
                                transacao = new Transacao(conta, Transacao.contadorTransacoes, new Date(),
                                        "TRANSFERÊNCIA", valorTransferencia, 'D');
                                conta.getTransacoes().add(transacao);

                                Transacao.contadorTransacoes++;
                                transacao = new Transacao(contaCredito, Transacao.contadorTransacoes, new Date(),
                                        "TRANSFERÊNCIA", valorTransferencia, 'C');
                                contaCredito.getTransacoes().add(transacao);

                                JOptionPane.showMessageDialog(null, "Transferência efetuada com sucesso.", "Transferência",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Certifique-se de fornecer um número válido para o ID da conta e o valor da transferência.",
                                "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 4 -> {
                    try {
                        idConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da conta:"));

                        conta = pesquisarContaPorId(idConta);
                        if (conta == null) {
                            JOptionPane.showMessageDialog(null, "Conta não encontrada. Não foi possível obter o extrato.",
                                    "Conta não encontrada", JOptionPane.ERROR_MESSAGE);
                        } else {
                            StringBuilder extrato = new StringBuilder();
                            extrato.append("         E X T R A T O   B A N C Á R I O         \n");
                            extrato.append("------------------------------------------------\n");
                            extrato.append("Cliente: ").append(conta.getCliente().getNome()).append("\n");
                            extrato.append("Banco: ").append(conta.getAgencia().getBanco().getNome()).append("\n");
                            extrato.append("Agência: ").append(conta.getAgencia().getNumero()).append(" - ").append(conta.getAgencia().getCidade()).append("\n");
                            extrato.append("Conta: ").append(conta.getNumero()).append("\n");
                            extrato.append("------------------------------------------------\n");
                            extrato.append("DATA        HISTÓRICO           DOC        VALOR\n");
                            extrato.append("------------------------------------------------\n");

                            for (int i = 0; i < conta.getTransacoes().size(); i++) {
                                Transacao t = conta.getTransacoes().get(i);
                                String valorFormatado = nf.format(t.getValor());
                                extrato.append(formato.format(t.getData())).append("  ").append(String.format("%-20s", t.getHistorico()))
                                        .append(String.format("%1$5s", t.getId()).replace(' ', '0'))
                                        .append(String.format("%10s", valorFormatado.replace("R$ ", ""))).append(t.getLetra()).append("\n");
                            }

                            extrato.append("------------------------------------------------\n");
                            String valorFormatado = nf.format((long) conta.getSaldo());
                            extrato.append("SALDO ATUAL:").append(String.format("%36s", valorFormatado.replace("RS ", ""))).append("\n");
                            valorFormatado = nf.format(conta.getLimite());
                            extrato.append("LIMITE:").append(String.format("%41s", valorFormatado.replace("RS ", ""))).append("\n");
                            valorFormatado = nf.format(conta.getSaldo() + conta.getLimite());
                            extrato.append("DISPONÍVEL:").append(String.format("%37s", valorFormatado.replace("RS ", ""))).append("\n");

                            JOptionPane.showMessageDialog(null, extrato.toString(), "Extrato Bancário", JOptionPane.PLAIN_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Certifique-se de fornecer um número válido para o ID da conta.",
                                "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 5 -> {
                    return 1;
                }
            }
        }
    }

    
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.menuPrincipal();;
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
