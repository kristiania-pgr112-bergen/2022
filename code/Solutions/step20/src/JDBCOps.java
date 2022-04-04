package Solutions.step20.src;


import LectureCode.Session20.src.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;

public class JDBCOps {
    public JDBCOps(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    public void createTable() {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS authors( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "name VARCHAR(45), "
                    + "nationality VARCHAR(45), "
                    + "primary key (id)) ";
            boolean result = stmt.execute(createTable);
            createTable = "CREATE TABLE IF NOT EXISTS books( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "title VARCHAR(45), "
                    + "authorId INT, "
                    + "pages  INT(11), "
                    + "genre  VARCHAR(45), "
                    + "primary key (id)) ";
            result = stmt.execute(createTable);
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void registerAuthor(Author author) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO authors(name, nationality) VALUES(?,?)");
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getNationality());
            stmt.executeUpdate();
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void registerBook(Book book) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO books(title, pages,genre) VALUES(?,?,?)");
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getNumberOfPages());
            stmt.setString(3, book.getGenre().toString());
            stmt.executeUpdate();
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void updateBook(Book book, Integer authorId) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt = con.prepareStatement("UPDATE books SET authorId = ? WHERE title = ?");
            stmt.setInt(1,authorId);
            stmt.setString(2,book.getTitle());
            stmt.executeUpdate();
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void addBook(Book book) {
        Integer authorId = getIdByAuthor(book.getAuthor().getName());
        System.out.println(authorId);
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {

            con.setAutoCommit(false);
            PreparedStatement stmt=con.prepareStatement("INSERT INTO books(title, authorId, pages,genre) VALUES(?,?,?,?)");
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, authorId);
            stmt.setInt(3, book.getNumberOfPages());
            stmt.setString(4, book.getGenre().toString());
            stmt.executeUpdate();

            if(authorId <= 0) {
                System.out.println("author does not exist. please register author first");
                con.rollback();
            } else {
                con.commit();
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void addBookandAuthor(Book book) {
        Integer authorId = getIdByAuthor(book.getAuthor().getName());
        System.out.println(authorId);
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO books(title, authorId, pages,genre) VALUES(?,?,?,?)");
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, authorId);
            stmt.setInt(3, book.getNumberOfPages());
            stmt.setString(4, book.getGenre().toString());
            stmt.executeUpdate();

            if(authorId <= 0) {
                System.out.println("author does not exist. Register author first");
                registerAuthor(book.getAuthor());
                authorId = getIdByAuthor(book.getAuthor().getName());
                updateBook(book, authorId);
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public ArrayList<Author> getAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt=con.prepareStatement("SELECT * FROM authors");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setName(resultSet.getString("name"));
                author.setNationality(resultSet.getString("nationality"));
                authors.add(author);
            }
            return authors;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            CallableStatement cstmt = con.prepareCall("{call getBooks_byJoin()}");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setNumberOfPages(rs.getInt("pages"));
                book.setGenre(Genre.valueOf(rs.getString("genre")));
                Author author = new Author();
                author.setName(rs.getString("authorName"));
                author.setNationality(rs.getString("authorNationality"));
                book.setAuthor(author);
                books.add(book);
            }
            return books;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> getBooksByAuthor(String authorStr) {
        ArrayList<Book> books = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            CallableStatement cstmt = con.prepareCall("{call getBooks_byAuthor(?)}");
            cstmt.setString(1, authorStr);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setNumberOfPages(rs.getInt("pages"));
                book.setGenre(Genre.valueOf(rs.getString("genre")));
                Author author = new Author();
                author.setName(rs.getString("authorName"));
                author.setNationality(rs.getString("authorNationality"));
                book.setAuthor(author);
                books.add(book);
            }
            return books;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    public Integer getIdByAuthor_join(String authorName) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            CallableStatement cstmt = con.prepareCall("{call getId_byAuthor(?, ?)}");
            cstmt.setString(1, authorName);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();
            Integer authorId = cstmt.getInt(2);
            System.out.println(authorId);
            return authorId;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return -1;
        }

    }

    public Integer getIdByAuthor(String authorName) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM authors WHERE name = ?");
            stmt.setString(1,authorName);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                return resultSet.getInt("id");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return -1;
        }
        return 0;
    }



}
