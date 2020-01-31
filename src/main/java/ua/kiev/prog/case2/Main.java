package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;
import ua.kiev.prog.shared.Good;
import ua.kiev.prog.shared.Order;

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
            ClientDAOEx dao = new ClientDAOEx(conn, "Clients");
            dao.init();

            GoodDAOEx dao1 = new GoodDAOEx(conn, "Goods");
            dao1.init();

            OrderDAOEx dao2 = new OrderDAOEx(conn, "Orders");
            dao2.init();


            Client c = new Client("test1", 1);
            Client c1 = new Client("test2", 2);
            Client c2 = new Client("test3",3);
            Client c3 = new Client("test4",4);
            Client c4 = new Client("test5", 5);

            dao.add(c);
            dao.add(c1);
            dao.add(c2);
            dao.add(c3);
            dao.add(c4);


            Good g = new Good("goodtest1",1.5);
            Good g1 = new Good("goodtest2",5.8);
            Good g2 = new Good("goodtest3",3.89);
            Good g3 = new Good("goodtest4",4.76);

            dao1.add(g);
            dao1.add(g1);
            dao1.add(g2);
            dao1.add(g3);

            Order ord = new Order("ordertest1",01);
            Order ord1 = new Order("ordertest2",02);
            Order ord2 = new Order("ordertest3",03);
            Order ord3 = new Order("ordertest4",04);

            dao2.add(ord);
            dao2.add(ord1);
            dao2.add(ord2);
            dao2.add(ord3);

            List<Client> list = dao.getAll(Client.class);
            for (Client cli : list)
                System.out.println(cli);

            List<Good> list1 = dao1.getAll(Good.class);
            for (Good good : list1)
                System.out.println(good);

            List<Order> list2 = dao2.getAll(Order.class);
            for (Order order : list2)
                System.out.println(order);

        } finally {
            sc.close();
            if (conn != null) conn.close();
        }
    }
}
