import java.sql.SQLException;

interface CRUD {
    void add() throws SQLException;
    void dataParkir() throws SQLException;
    void update() throws SQLException;
    void delete() throws SQLException;
}