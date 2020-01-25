package ua.kiev.prog.case2;


import ua.kiev.prog.shared.Good;

import java.sql.Connection;

public class OrderDAOEx extends AbstractDAO<Integer, Good> {
    public OrderDAOEx(Connection conn, String table) {
        super(conn, table);
    }
}



