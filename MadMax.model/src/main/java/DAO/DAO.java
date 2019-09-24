package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.User;

/**
 * <h1>The Class UserDAO.</h1>
 *
 * @version 1.0
 */
public abstract class DAO extends AbstractDAO {

    /** The sql stored procedure to find a user by id. */
    private static String sqlUserById	= "{call findUserById(?)}";

    /** The sql stored procedure to find a user by name. */
    private static String sqlUserByName	= "{call findUserByName(?)}";

    /** The sql stored procedure to find all users. */
    private static String sqlAllUsers	= "{call findAllUsers()}";

    /** The sql stored procedure to add a user. */
    private static String sqlAddUser	= "{call findAddUser()}";


    /**
     * Gets the User by id.
     *
     * @param id
     *            the id
     * @return the User
     * @throws SQLException
     *             the SQL exception
     */
    public static User getUserById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlUserById);
        User usr = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                usr = new User(result.getInt(1), result.getString(2), result.getString(3));
            }
            result.close();
        }
        return usr;
    }

    /**
     * Gets the User by name.
     *
     * @param name
     *            the name
     * @return the User
     * @throws SQLException
     *             the SQL exception
     */
    public static User getUserByName(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlUserByName);
        User usr = null;

        callStatement.setString(1, name);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                usr = new User(result.getInt(1), result.getString(2), result.getString(3));
            }
            result.close();
        }
        return usr;
    }

    /**
     * Gets all the Users.
     *
     * @return List of User
     * @throws SQLException
     *             the SQL exception
     */
    public static List<User> getAllUsers() throws SQLException {
        final ArrayList<User> users = new ArrayList<User>();
        final CallableStatement callStatement = prepareCall(sqlAllUsers);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
            	users.add(new User(result.getInt(1), result.getString(2), result.getString(2)));
            }
            result.close();
        }
        return users;
    }

    /**
     * Add Users.
     *
     * @return The User Added
     * @throws SQLException
     *             the SQL exception
     */
    public static User addUser(String name, String password) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlAddUser);
        User usr = null;

        callStatement.setString(1, name);
        callStatement.setString(2, password);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                usr = new User(result.getInt(1), result.getString(2), result.getString(3));
            }
            result.close();
        }
        return usr;
    }
}
