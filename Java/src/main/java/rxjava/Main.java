package rxjava;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import org.postgresql.geometric.PGpoint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    
    public static void main(String... args) throws IOException, SQLException {
        Connection connection = connection();
        Arrays.stream(args)
                .forEach(arg -> {
                    try {
                        insert(connection, arg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        connection.close();
    }

    private static void insert(Connection connection, String arg) throws IOException, SQLException {
        Path aqPath = Paths.get(arg);
        CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAwareBuilder(Files.newBufferedReader(aqPath)).build();
        String[] parsedValues;
        while ((parsedValues = csvReaderHeaderAware.readNext("location",
                "city", "country", "utc",
                "local", "parameter", "value", "unit",
                "latitude", "longitude")) != null) {
            java.util.Date from = Date.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(parsedValues[3])));
            TemporalAccessor localTime = DateTimeFormatter.ISO_DATE_TIME.parse(parsedValues[4]);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO aq(location, city, country, utc_time, local_time, " +
                            "parameter, value, unit, geo) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, parsedValues[0]);
            statement.setString(2, parsedValues[1]);
            statement.setString(3, parsedValues[2]);
            statement.setDate(4, new Date(from.getTime()));
            statement.setObject(5, LocalDateTime.from(localTime));
            statement.setString(6, parsedValues[5]);
            statement.setDouble(7, Double.parseDouble(parsedValues[6]));
            statement.setString(8, (parsedValues[7]));
            double latitude = Double.parseDouble(parsedValues[8]);
            double longtitude = Double.parseDouble(parsedValues[9]);
            PGpoint point = new PGpoint(latitude, longtitude);
            statement.setObject(9, point);
            statement.execute();
            statement.close();
        }

        csvReaderHeaderAware.close();
    }

    private static Connection connection() throws SQLException {
        String url = "jdbc:postgresql://172.17.8.101:5432/maxxdb";
        Properties props = new Properties();
        props.setProperty("user","maxxsys");
        props.setProperty("password","Flex123!");
        return DriverManager.getConnection(url, props);
    }
}
