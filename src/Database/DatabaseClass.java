package Database;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DatabaseClass {
    private Connection connection;
    private static  Statement statement;
    private enum Enemies { Juaquim, Canonball};
    private static final String url = "jdbc:sqlite:JamalLoadingSave.db";

    public boolean isEmpty() {
        try {
            ResultSet rs = statement.executeQuery("select count(*) from GAME_INFO");
            int rez = rs.getInt(1);
            if (rez > 0)
                return false;
            if (rez == 0)
                return true;
            connection.commit();
        } catch (Exception e) {
            System.out.println("ERROR DATABASE! isEmpty Problem!");
        }
        return false;
    }

    public void create_table() {
        try {
            Class.forName("org.sqlite.JDBC");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        }

        String url = "jdbc:sqlite:JamalScore.db";


        try (Connection Database_connection = DriverManager.getConnection(url)) {
            String sql = "CREATE TABLE IF NOT EXISTS SCORE1 (\n"
                    + "	ID integer PRIMARY KEY,\n"
                    + " SCORE integer NOT NULL\n"
                    + ");";

            Statement stmt = Database_connection.createStatement();

            // create a new table
            stmt.execute(sql);
            sql = "INSERT OR IGNORE INTO SCORE1(ID,SCORE) " + "VALUES (1,0);";
            stmt.execute(sql);
            stmt.close();
            Database_connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    public int getScore() {
        String url = "jdbc:sqlite:JamalScore.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT SCORE FROM SCORE1 WHERE ID=1;");
            int score = rs.getInt("score");
            rs.close();
            stmt.close();
            conn.close();
            return score;


        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public void setScore(int score) {
        String url = "jdbc:sqlite:JamalScore.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);

            String sql = "UPDATE SCORE1 set SCORE =" + score + " where ID=1;";
            stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
/*

    ////////////////////////////        Save Entity as LoadGame           ////////////////////////////////
    public static void create_table_for_Load() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        }

        String url = "jdbc:sqlite:JamalLoadingSave.db";

        try (Connection databaseConnection = DriverManager.getConnection(url)) {
            String sql = "CREATE TABLE IF NOT EXISTS Player (\n"
                    + "    ID INTEGER PRIMARY KEY,\n"
                    + "    Health INTEGER NOT NULL,\n"
                    + "    XPosition INTEGER NOT NULL,\n"
                    + "    YPosition INTEGER NOT NULL\n"
                    + ");";

            Statement stmt = databaseConnection.createStatement();

            // Create a new table
            stmt.execute(sql);
            stmt.close();
            databaseConnection.close();
           // System.out.println("Player table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void savePlayerPosition(int health, float xPosition, float yPosition) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO Player (Health, XPosition, YPosition) VALUES (?, ?, ?);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, health);
            pstmt.setFloat(2, xPosition);
            pstmt.setFloat(3, yPosition);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            //System.out.println("Player data saved successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static float getPlayerX() {
        float x = 0;
        try {
            // Retrieve the player's x-coordinate from the database
            String query = "SELECT x FROM player_position";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                x = resultSet.getFloat("x");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
    public static int getPlayerDatabaseHp() {
        int x = 0;
        String query = "SELECT x FROM player_position";

        try (Connection connection = DriverManager.getConnection(url)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                x = resultSet.getInt("x");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return x;
    }

    public static float getPlayerY() {
        float y = 0;
        try {
            // Retrieve the player's y-coordinate from the database
            String  query= "SELECT y FROM player_position";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                y = resultSet.getFloat("y");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return y;
    }

    public static  void setPlayerHealth(float health) {
        String url = "jdbc:sqlite:JamalPlayerData.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);

            String sql = "UPDATE player_data SET health = " + health + " WHERE player_id = 1;";
            stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void setPlayerPosition(float x, float y) {
        String url = "jdbc:sqlite:JamalPlayerData.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);

            String sql = "UPDATE player_data SET x_position = " + x + ", y_position = " + y + " WHERE player_id = 1;";
            stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static boolean savedGameExists() {
        String url = "jdbc:sqlite:JamalLoadingSave.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();

            // Check if the 'Player' table exists in the database
            ResultSet tables = conn.getMetaData().getTables(null, null, "Player", null);
            boolean playerTableExists = tables.next();
            tables.close();

            stmt.close();
            conn.close();

            return playerTableExists;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public float getEnemyX(int enemyId) {
        float x = 0;
        try {
            // Retrieve the enemy's x-coordinate from the database
            String query = "SELECT x FROM enemy_position WHERE enemy_id = " + enemyId;
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                x = resultSet.getFloat("x");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public float getEnemyY(int enemyId) {
        float y = 0;
        try {
            // Retrieve the enemy's y-coordinate from the database
            String query = "SELECT y FROM enemy_position WHERE enemy_id = " + enemyId;
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                y = resultSet.getFloat("y");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return y;
    }*/
}



