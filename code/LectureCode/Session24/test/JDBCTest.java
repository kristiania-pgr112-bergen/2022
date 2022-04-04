package LectureCode.Session24.test;

import LectureCode.Session24.src.JDBCOps;
import LectureCode.Session24.src.equipment.Locker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class JDBCTest {
    JDBCOps jdbcOps = new JDBCOps();
    @BeforeEach
    public void setUp() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?" +
                    "allowPublicKeyRetrieval=true&useSSL=false" +
                    "&allowMultiQueries=true", "user1", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetLockerById_Success(){
        int id = 1;
        assertNotNull(jdbcOps.getLockerById(id));
        assertTrue(jdbcOps.getLockerById(id).getId() == id);
    }

    @Test
    public void testGetLockerById_Fail(){
        int id = 101;
        Optional<Locker> locker = Optional.ofNullable(jdbcOps.getLockerById(id));
        assertTrue(locker.isEmpty());
    }

    @Test
    public void testGetLockerByLocation_Success(){
        int id = 1;
        Locker locker1 = jdbcOps.getLockerById(id);
        jdbcOps.getLockersByLocation(locker1.getLocation()).forEach(locker -> {System.out.println(locker);});
        assertTrue(jdbcOps.getLockersByLocation(locker1.getLocation()).contains(locker1));
        Optional<Locker> firstLocker = jdbcOps.getLockersByLocation(locker1.getLocation()).stream().findFirst();
        assertTrue(firstLocker.isPresent());
    }

    @Test
    public void testGetLockerByLocation_Fail(){
        String location = "test location";
        assertTrue(jdbcOps.getLockersByLocationOptional(location).isEmpty());
    }

    @Test
    public void testGetLockersByLocation2_Success(){
        int id = 1;
        String location = jdbcOps.getLockerById(id).getLocation();
        ArrayList<Locker> lockers = jdbcOps.getAllLockers();
        List<Locker> filteredLockers = lockers.stream()
                .filter(locker -> locker.getLocation().equals(location))
                .collect(Collectors.toList());
        filteredLockers.forEach(locker -> System.out.println(locker));
        Optional<Locker> firstLocker = jdbcOps.getLockersByLocation(location).stream().findFirst();
        assertTrue(firstLocker.isPresent());
    }
}
