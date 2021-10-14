package util;

import exception.Exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//1º Criar obj Connection
//2° Criar método auxiliar para retornar tipo Properties
//3° Criar método getConnection

public class Conexao {

    private static Connection cnn = null;

    public static Properties carregarArquivoProperties(){
        try(FileInputStream arquivo = new FileInputStream("arquivoBd.properties")){

            Properties prop = new Properties();
            prop.load(arquivo);//faz a leitura e guarda dentro de prop
            return prop;

        }catch(IOException e){
            throw new Exception(e.getMessage());
        }

    }

    public static Connection getConnection(){
        if(cnn == null){
            try{
                Properties prop = carregarArquivoProperties();
                String url = prop.getProperty("url");
                cnn = DriverManager.getConnection(url,prop);
                if(cnn!= null){
                    System.out.println("Connected!!");
                }else
                    System.out.println("Error!!!");
            }catch(SQLException e){
                throw new Exception(e.getMessage());
            }
        }
        return cnn;
    }


    //MÉTODO PARA FECHAR CONEXAO
    public static void closeConnection(){
        if(cnn != null){
            try {
                cnn.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement s){
        if(s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet s){
        if(s != null){
            try {
                s.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

}
