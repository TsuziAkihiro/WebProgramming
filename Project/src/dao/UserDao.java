package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user WHERE 2 <= id";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }
    /**
     * 新規登録
     */
    public void InsertUserDao (String loginId,String password,String name,String birthday){
    	Connection conn = null;
        try {
            // データベースへ接続
        	conn = DBManager.getConnection();
            String sql = "INSERT INTO user(login_id, name, birth_date, password, create_date, update_date) VALUES (?, ?, ?, ?, now(),now())";
            // INSERTを実行
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, loginId);
            stmt.setString(2, name);
            stmt.setString(3, birthday);
            stmt.setString(4, password);
            int result = stmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 詳細
     */
    public User detailDao(String id){
    	Connection conn = null;
    	 try {
             // データベースへ接続
             conn = DBManager.getConnection();
             String sql = "SELECT * FROM user WHERE id = ?";
             // SELECTを実行し、結果表を取得
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            if(rs.next()){
                int ida = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                return  new User(ida, loginId, name, birthDate, password, createDate, updateDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    	 return null;
    }
    public void deleteDao(String id){
    	Connection conn = null;
    	 try {
             // データベースへ接続
             conn = DBManager.getConnection();
             String sql = "DELETE FROM user WHERE id = ?";
             // SELECTを実行し、結果表を取得
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            int result = stmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void upDateUserDao (String id,String password,String name,String birthday){
    	Connection conn = null;
        try {
            // データベースへ接続
        	conn = DBManager.getConnection();
            String sql = "UPDATE user SET name = ?,birth_date = ?,password = ?,update_date = now() WHERE id = ?";
            // INSERTを実行
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, birthday);
            stmt.setString(3, password);
            stmt.setString(4, id);
            int result = stmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 入力された条件に合う情報を取得する
     * @return
     */
    public List<User> findByInput(String loginID,String name1,String birthday1,String birthday2) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user WHERE 2 <= id and login_id = ? and name LIKE '%?%' and birth_date >= '?' and birth_date <= '?'";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, loginID);
            stmt.setString(2, name1);
            stmt.setString(3, birthday1);
            stmt.setString(4, birthday2);

            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

}