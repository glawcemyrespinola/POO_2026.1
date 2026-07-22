package ClassesAuxiliares;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ConexaoBD {
    String driver = "com.mysql.cj.jdbc.Driver";
    String host = "localhost";
    String str_conn = "jdbc:mysql://"+host+":3306/?useSSL=false";
    String usuario = "root";
    String senha = "mgg12mip";

    Connection conexao;
    Statement estado;
    ResultSet resultado;

    public void conectar(){
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(str_conn, usuario, senha);
            estado = conexao.createStatement();

            // Garante que o banco e as tabelas essenciais existem
            estado.executeUpdate("CREATE DATABASE IF NOT EXISTS farmacia;");
            estado.executeUpdate("USE farmacia;");

            estado.executeUpdate("CREATE TABLE IF NOT EXISTS Funcionario (" +
                    "login VARCHAR(45) NOT NULL, " +
                    "nome VARCHAR(45) NOT NULL, " +
                    "senha VARCHAR(45) NOT NULL, " +
                    "PRIMARY KEY (login)) ENGINE = InnoDB;");

            estado.executeUpdate("CREATE TABLE IF NOT EXISTS Telefone (" +
                    "cod INT NOT NULL AUTO_INCREMENT, " +
                    "numero INT NOT NULL, " +
                    "PRIMARY KEY (cod)) ENGINE = InnoDB;");

            // CORREÇÃO AUTOMÁTICA DA COLUNA NÚMERO PARA ACEITAR ESPAÇOS E TEXTO
            try {
                estado.executeUpdate("ALTER TABLE Telefone MODIFY COLUMN numero VARCHAR(45) NOT NULL;");
            } catch (SQLException e) {
                // Já alterado
            }

            estado.executeUpdate("CREATE TABLE IF NOT EXISTS Cidade (" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "Cidade VARCHAR(45) NOT NULL, " +
                    "PRIMARY KEY (id)) ENGINE = InnoDB;");

            estado.executeUpdate("CREATE TABLE IF NOT EXISTS Fornecedor (" +
                    "cnpj CHAR(18) NOT NULL, " +
                    "nome VARCHAR(45) NOT NULL, " +
                    "Telefone INT NOT NULL, " +
                    "Cidade INT NOT NULL, " +
                    "PRIMARY KEY (cnpj), " +
                    "CONSTRAINT `fk_Fornecedor_Telefone` FOREIGN KEY (`Telefone`) REFERENCES `Telefone` (`cod`), " +
                    "CONSTRAINT `fk_Fornecedor_Cidade1` FOREIGN KEY (`Cidade`) REFERENCES `Cidade` (`id`)) ENGINE = InnoDB;");

            estado.executeUpdate("CREATE TABLE IF NOT EXISTS Medicamento (" +
                    "cod VARCHAR(45) NOT NULL, " +
                    "nome VARCHAR(45) NULL, " +
                    "valor DOUBLE NULL, " +
                    "quantidade INT NULL, " +
                    "Fornecedor CHAR(18) NOT NULL, " +
                    "PRIMARY KEY (cod)) ENGINE = InnoDB;");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar driver");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar");
            ex.printStackTrace();
        }
    }

    public void fecharConexao(){
        try {
            if (estado != null) estado.close();
            if (conexao != null) conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar conexao");
        }
    }

    public void inserirFuncionario(String nome, String login, String senha){
        String strInserir = "insert into Funcionario (login,nome,senha) values('"+login+"','"+nome+"','"+senha+"');";
        try {
            estado.executeUpdate(strInserir);
            JOptionPane.showMessageDialog(null,"Funcionário cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir funcionário");
        }
    }

    public void removerFuncionario(String login){
        String strRemoer = "delete from Funcionario where login = '"+login+"';";
        try {
            estado.executeUpdate(strRemoer);
            JOptionPane.showMessageDialog(null,"Funcionario removido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao remover funcionário");
        }
    }

    public void atualizarFuncionario(String login, String nome){
        String strUpdate = "update Funcionario set nome='"+nome+"' where login='"+login+"';";
        try {
            estado.executeUpdate(strUpdate);
            JOptionPane.showMessageDialog(null,"Funcionário atualizado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar nome");
        }
    }

    public ArrayList<Funcionario> consultaFuncionario(){
        ArrayList<Funcionario> lista = new ArrayList<>();
        String sqlConsulta = "select * from Funcionario;";
        try {
            resultado = estado.executeQuery(sqlConsulta);
            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setLogin(resultado.getString("login"));
                f.setSenha(resultado.getString("senha"));
                f.setNome(resultado.getString("nome"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return lista;
    }

    public void inserirFornecedor(String cnpj, String nome, String telefone, String cidade) {
        try {
            int cidadeId = -1;

            String sqlCheckCidade = "SELECT id FROM Cidade WHERE Cidade = ?";
            try (PreparedStatement stmtCidade = conexao.prepareStatement(sqlCheckCidade)) {
                stmtCidade.setString(1, cidade);
                try (ResultSet rs = stmtCidade.executeQuery()) {
                    if (rs.next()) {
                        cidadeId = rs.getInt("id");
                    }
                }
            }

            if (cidadeId == -1) {
                String sqlInsCidade = "INSERT INTO Cidade (Cidade) VALUES (?)";
                try (PreparedStatement stmtInsCid = conexao.prepareStatement(sqlInsCidade, Statement.RETURN_GENERATED_KEYS)) {
                    stmtInsCid.setString(1, cidade);
                    stmtInsCid.executeUpdate();
                    try (ResultSet rsKeys = stmtInsCid.getGeneratedKeys()) {
                        if (rsKeys.next()) {
                            cidadeId = rsKeys.getInt(1);
                        }
                    }
                }
            }

            int telefoneCod = -1;
            String sqlInsTel = "INSERT INTO Telefone (numero) VALUES (?)";
            try (PreparedStatement stmtInsTel = conexao.prepareStatement(sqlInsTel, Statement.RETURN_GENERATED_KEYS)) {
                stmtInsTel.setString(1, telefone);
                stmtInsTel.executeUpdate();
                try (ResultSet rsTelKeys = stmtInsTel.getGeneratedKeys()) {
                    if (rsTelKeys.next()) {
                        telefoneCod = rsTelKeys.getInt(1);
                    }
                }
            }

            String sqlForn = "INSERT INTO Fornecedor (cnpj, nome, Telefone, Cidade) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmtForn = conexao.prepareStatement(sqlForn)) {
                stmtForn.setString(1, cnpj);
                stmtForn.setString(2, nome);
                stmtForn.setInt(3, telefoneCod);
                stmtForn.setInt(4, cidadeId);
                stmtForn.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void atualizarFornecedor(String cnpj, String nome, String telefone, String cidadeNome) {
        try {
            // 1. Descobre o ID do telefone atual do fornecedor
            String sqlBuscaIDs = "SELECT Telefone FROM fornecedor WHERE cnpj = ?";
            PreparedStatement stmtBusca = conexao.prepareStatement(sqlBuscaIDs);
            stmtBusca.setString(1, cnpj);
            var rs = stmtBusca.executeQuery();

            int idTelefone = 0;
            if (rs.next()) {
                idTelefone = rs.getInt("Telefone");
            }
            rs.close();
            stmtBusca.close();

            // 2. Atualiza o número de telefone
            if (idTelefone > 0) {
                String sqlTel = "UPDATE telefone SET numero = ? WHERE cod = ?";
                PreparedStatement stmtTel = conexao.prepareStatement(sqlTel);
                stmtTel.setString(1, telefone);
                stmtTel.setInt(2, idTelefone);
                stmtTel.execute();
                stmtTel.close();
            }

            // 3. Verifica se a cidade digitada já existe ou cadastra caso seja nova
            int cidadeId = -1;
            String sqlCheckCidade = "SELECT id FROM Cidade WHERE Cidade = ?";
            try (PreparedStatement stmtCidade = conexao.prepareStatement(sqlCheckCidade)) {
                stmtCidade.setString(1, cidadeNome);
                try (ResultSet rsCid = stmtCidade.executeQuery()) {
                    if (rsCid.next()) {
                        cidadeId = rsCid.getInt("id");
                    }
                }
            }

            if (cidadeId == -1) {
                String sqlInsCidade = "INSERT INTO Cidade (Cidade) VALUES (?)";
                try (PreparedStatement stmtInsCid = conexao.prepareStatement(sqlInsCidade, Statement.RETURN_GENERATED_KEYS)) {
                    stmtInsCid.setString(1, cidadeNome);
                    stmtInsCid.executeUpdate();
                    try (ResultSet rsKeys = stmtInsCid.getGeneratedKeys()) {
                        if (rsKeys.next()) {
                            cidadeId = rsKeys.getInt(1);
                        }
                    }
                }
            }

            // 4. Atualiza o nome e o ID da cidade do fornecedor
            String sqlForn = "UPDATE fornecedor SET nome = ?, Cidade = ? WHERE cnpj = ?";
            PreparedStatement stmtForn = conexao.prepareStatement(sqlForn);
            stmtForn.setString(1, nome);
            stmtForn.setInt(2, cidadeId);
            stmtForn.setString(3, cnpj);
            stmtForn.execute();
            stmtForn.close();

            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar fornecedor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void removerFornecedor(String cnpj){
        String strRemoer = "delete from Fornecedor where cnpj = '"+cnpj+"';";
        try {
            estado.executeUpdate(strRemoer);
            JOptionPane.showMessageDialog(null,"Fornecedor removido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Remova todos os medicamentos cadastrados com esse fornecedor");
        }
    }

    public ArrayList<Fornecedor> consultarFornecedor(){
        ArrayList<Fornecedor> lista = new ArrayList<>();
        String sqlConsulta = "SELECT f.cnpj, f.nome, c.Cidade as cidade_nome, t.numero as telefone_num " +
                "FROM Fornecedor f " +
                "JOIN Cidade c ON f.Cidade = c.id " +
                "JOIN Telefone t ON f.Telefone = t.cod;";
        try {
            resultado = estado.executeQuery(sqlConsulta);
            while (resultado.next()) {
                Fornecedor f = new Fornecedor();
                f.setCnpj(resultado.getString("cnpj"));
                f.setNome(resultado.getString("nome"));
                f.setCidade(resultado.getString("cidade_nome"));
                f.setTelefone(resultado.getString("telefone_num"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar fornecedor");
            ex.printStackTrace();
        }
        return lista;
    }

    public void inserirMedicamento(String cod, String nome, String fornecedor){
        String strInserir = "insert into Medicamento (cod,nome,valor,quantidade,Fornecedor) values('"+cod+"','"+nome+"',0,0,'"+fornecedor+"');";
        try {
            estado.executeUpdate(strInserir);
            JOptionPane.showMessageDialog(null,"Medicamento inserido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir medicamento");
        }
    }

    public ArrayList<Medicamento> consultarMedicamento(){
        ArrayList<Medicamento> lista = new ArrayList<>();
        String sqlConsultaMedicamento = "select * from Medicamento;";
        try {
            resultado = estado.executeQuery(sqlConsultaMedicamento);
            while (resultado.next()) {
                Medicamento m = new Medicamento();
                m.setCod(resultado.getString("cod"));
                m.setDescricao(resultado.getString("nome"));
                m.setQuantidadeEstoque(resultado.getInt("quantidade"));
                m.setValorUnitario(resultado.getDouble("valor"));
                m.setFornecedor(resultado.getString("Fornecedor"));
                lista.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        return lista;
    }

    public void atualizarQV(String cod, double valor, double quantidade){
        String strAtualizar = "update Medicamento set valor = "+valor+", quantidade = "+quantidade+" where cod = '"+cod+"';";
        try {
            estado.executeUpdate(strAtualizar);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de atualização");
        }
    }
}