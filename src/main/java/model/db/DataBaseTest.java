package model.db;

import utils.baseTest.BaseTest;
import utils.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest extends BaseTest {

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void dbTest(String idRC) {
        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM tipo_rc WHERE ID_TIPORC = " + idRC);

            while (rs.next()) {
                System.out.println(rs.getInt("ID_TIPORC") + ", " + rs.getString("DESCRICAO"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

}
