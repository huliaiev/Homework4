package ua.kiev.prog.case2;


import ua.kiev.prog.shared.Good;
import ua.kiev.prog.shared.Order;

import java.sql.Connection;

public class OrderDAOEx extends AbstractDAO<Integer, Order> {
    public OrderDAOEx(Connection conn, String table) {
        super(conn, table);
    }
}



