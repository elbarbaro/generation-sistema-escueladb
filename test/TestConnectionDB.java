
import com.generation.practica5.util.JDBCUtility;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELBARBARO
 */
public class TestConnectionDB {
    
    @Test
    public void testDB(){
        Connection conn = JDBCUtility.getConnection();
        assertNotNull(conn);
        try {
            JDBCUtility.closeConnection(conn);
            assertTrue(conn.isClosed());
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(TestConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
