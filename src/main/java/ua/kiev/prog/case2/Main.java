package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;
import ua.kiev.prog.shared.Good;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION =
            "jdbc:mysql://localhost:3306/mydb001?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "password";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        ConnectionFactory factory = new ConnectionFactory(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );

        Connection conn = factory.getConnection();
        try {
            ClientDAOEx dao = new ClientDAOEx(conn, "clients");
            GoodDAOEx dao1 = new GoodDAOEx(conn, "goods");
            OrderDAOEx dao2 = new OrderDAOEx(conn, "orders");

            Client c = new Client("test", 1);
            Client c1 = new Client("test1", 2);
            Client c2 = new Client("test2",3);

            dao.add(c);
            dao.add(c1);
            dao.add(c2);

            Good g = new Good("goodtest",01);
            Good g1 = new Good("goodtest1",02);
            Good g2 = new Good("goodtest1",03);

            dao1.add(g);
            dao1.add(g1);
            dao1.add(g2);


            List<Client> list = dao.getAll(Client.class);
            for (Client cli : list)
                System.out.println(cli);

        /*
            List<Good> list1 = dao1.getAll(Good.class);
            for (Good good : list1)
                System.out.println(good);
        */

            //Client c1 = list.get(0);
            //c1.setAge(44);
            //dao.update(c1);

             //List<Object[]> res1 = dao.getAll(Client.class);

            dao.delete(list.get(0));
        } finally {
            sc.close();
            if (conn != null) conn.close();
        }
    }
}
