package util;

import exception.Exception;
import model.dao.DDepartment;
import model.dao.DSeller;
import model.entity.EDepartment;
import model.entity.ESeller;

import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        operacao(sc);

    }
    public static int menu(Scanner sc){
        System.out.println("0 - sair");
        System.out.println("1 - Listar Departamentos");
        System.out.println("2 - Listar Vendedores");
        System.out.println("3 - Inserir Departamento");
        System.out.println("4 - Inserir Vendedores");
        System.out.print("Informe a Operação: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }
    public static void operacao(Scanner sc){
        int op = -1;


        while(op != 0){

            op = menu(sc);
            switch(op){
                case 1:
                    System.out.println("LISTANDO DEPARTAMENTOS CADASTRADOS");
                    DDepartment dp = new DDepartment();
                    dp.listarDepartment();
                    break;
                case 2:
                    System.out.println("LISTANDO VENDEDORES CADASTRADOS");
                    DSeller sl = new DSeller();
                    sl.listarSeller();
                    break;
                case 3:
                    System.out.println("INSERINDO DEPARTAMENTO");
                    System.out.print("Nome do novo departamento: ");
                    String nome = sc.nextLine();
                    EDepartment eDp = new EDepartment(nome);
                    DDepartment p = new DDepartment();
                    p.inserir(eDp);
                    break;
                case 4:
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    java.util.Date da;
                    System.out.print("Digite o Vendedor: ");
                    String name = sc.nextLine();
                    System.out.println("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Digite data de Nascimento: ");
                    String dat = sc.next();

                    System.out.print("Informe o salario: ");
                    Double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Departamento Filiado: ");
                    Integer id = sc.nextInt();
                    ESeller seller = new ESeller(name,email,dat,salary,id);
                    DSeller d = new DSeller();
                    d.inserir(seller);
                    break;

            }


        }

        Conexao.closeConnection();

    }

}
