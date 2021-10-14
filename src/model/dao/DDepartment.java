package model.dao;

import exception.Exception;
import model.entity.EDepartment;
import model.entity.ESeller;
import util.Conexao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DDepartment {

    Connection cnn = null;
    PreparedStatement prds = null;
    ResultSet rs = null;
    Statement st = null;

    public DDepartment() {
        cnn = Conexao.getConnection();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");




    public List<EDepartment> listarDepartment(){
        List<EDepartment> lista = new ArrayList<>();

        try{

            String sql = "SELECT * FROM department;";
            st = cnn.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("===== LISTANDO Direto do Dao    =======");
            while(rs.next()){
                EDepartment department= new EDepartment();
                department.setId(rs.getInt("id"));
                department.setNome(rs.getString("name"));
                lista.add(department);
                //LISTA DIRETO
                System.out.println("ID: " + rs.getInt("id") + " NOME: " + rs.getString("name"));
            }
            System.out.println("=======END LIST =======");


        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        //OU CRIA UMA LISTA QUE RECEBE ESSA FUNÇÃO QUE RETORNA EM 'LISTA'
        return lista;
    }
    public void inserir(EDepartment department){
        try {
            String sql = "INSERT INTO department (name) values (?);";
            prds = cnn.prepareStatement(sql);
            prds.setString(1, department.getNome());
            prds.executeUpdate();

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }


    }
    public void inserirMostrarIdInserido(EDepartment department){
        try {
            String sql = "INSERT INTO department (name) values (?);";
            prds = cnn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


            prds.setString(1, department.getNome());
            int linhaAfetada = prds.executeUpdate();
            if(linhaAfetada >0){
                rs = prds.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Id = " + id);
                }
            }else{
                System.out.println("nenhuma Linha afetada!");
            }


        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }finally{
            Conexao.closeStatement(st);
            Conexao.closeResultSet(rs);
            Conexao.closeConnection();
        }


    }
}
