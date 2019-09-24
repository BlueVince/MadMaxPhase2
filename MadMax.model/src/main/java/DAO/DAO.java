package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>The Class ObjectDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class DAO extends AbstractDAO {

    /** The sql Object by id. */
    private static String sqlObjectById   = "{call findObjectById(?)}";

    /** The sql Object by name. */
    private static String sqlObjectByName = "{call findObjectByName(?)}";

    /** The sql all Objects. */
    private static String sqlAllObjects   = "{call findAllObjects()}";

    /** The id column index. */
    private static int    idColumnIndex    = 1;

    /** The name column index. */
    private static int    nameColumnIndex  = 2;

    /**
     * Gets the Object by id.
     *
     * @param id
     *            the id
     * @return the Object by id
     * @throws SQLException
     *             the SQL exception
     */
    public static Object getObjectById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlObjectById);
        Object obj = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                //obj = new Object(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return obj;
    }

    /**
     * Gets the Object by name.
     *
     * @param name
     *            the name
     * @return the Object by name
     * @throws SQLException
     *             the SQL exception
     */
    public static Object getObjectByName(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlObjectByName);
        Object obj = null;

        callStatement.setString(1, name);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                Object = new Object(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return obj;
    }

    /**
     * Gets the all Objects.
     *
     * @return the all Objects
     * @throws SQLException
     *             the SQL exception
     */
    public static List<Object> getAllObjects() throws SQLException {
        final ArrayList<Object> Objects = new ArrayList<Object>();
        final CallableStatement callStatement = prepareCall(sqlAllObjects);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                Objects.add(new Object(result.getInt(idColumnIndex), result.getString(nameColumnIndex)));
            }
            result.close();
        }
        return obj;
    }
}
