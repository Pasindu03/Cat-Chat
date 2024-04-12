package dao.custom.impl;

import dao.custom.UserDao;
import entity.User;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User search(String username) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM user WHERE username = ? ", username);
        resultSet.next();
        return new User(
                resultSet.getString("userID"),
                resultSet.getString("username"),
                resultSet.getString("password")
        );
    }

    @Override
    public boolean add(String username, String pass) throws SQLException {
        int nextID = getNextID();
        return SQLUtil.execute("INSERT INTO user VALUES()",nextID,username, pass);
    }

    private int getNextID() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user");
        rst.next();
        return rst.getInt(1)+1;
    }
}
