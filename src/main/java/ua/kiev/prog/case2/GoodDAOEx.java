package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Good;

import java.sql.Connection;

    public class GoodDAOEx extends AbstractDAO<Integer, Good> {
        public GoodDAOEx(Connection conn, String table) {
            super(conn, table);
        }
    }

