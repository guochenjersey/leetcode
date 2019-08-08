package rxjava;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import org.postgresql.geometric.PGpoint;

import java.io.BufferedReader;
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
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Properties;

public class PGRowLockMain {

    public static void main(String... args) throws SQLException, IOException {
        Connection connection = connection();
        Files.list(Paths.get(args[0])).forEach(path -> {
            try {
                insert(connection, path);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        connection.close();
    }

    private static Connection connection() throws SQLException {
        String url ="jdbc:postgresql://172.17.8.101:5432/maxxdb";
        Properties props = new Properties();
        props.setProperty("user","maxxsys");
        props.setProperty("password","Flex123!");
        return DriverManager.getConnection(url, props);
    }
    /**
     * VendorID, 1
     * tpep_pickup_datetime, 2018-01-01 00:21:05
     * tpep_dropoff_datetime, 2018-01-01 00:24:23
     * passenger_count,1
     * trip_distance, .50
     * RatecodeID, 1
     * store_and_fwd_flag, N
     * PULocationID, 41
     * DOLocationID, 24
     * payment_type, 2
     * fare_amount, 4.5
     * extra, 0.5
     * mta_tax, 0.5
     * tip_amount, 0
     * tolls_amount, 0
     * improvement_surcharge, 0.3
     * total_amount 5.8
     * */
    private static void insert(Connection connection, Path path) throws IOException, SQLException {
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        bufferedReader.readLine();
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parsedValues = line.split(",");
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime nyPickupTime = LocalDateTime.parse(parsedValues[1], dateTimeFormat);
            LocalDateTime nyDropoffTime = LocalDateTime.parse(parsedValues[2], dateTimeFormat);

            ZonedDateTime pickUpTime = ZonedDateTime.of(nyPickupTime, ZoneId.of("America/New_York"));
            ZonedDateTime dropOffTime = ZonedDateTime.of(nyDropoffTime, ZoneId.of("America/New_York"));
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO yellow_cab_record(vendor_id, " +
                            "tpep_pickup_datetime, tpep_dropoff_datetime, passenger_count, trip_distance, " +
                            "pu_location_id, do_location_id, rate_code_id, store_and_fwd_flag, payment_type," +
                            "fare_amount, extra, mta_tax, improved_surcharge, tip_amount, tolls_amount, total_amount) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, Integer.parseInt(parsedValues[0]));
            statement.setObject(2, pickUpTime.toLocalDateTime());
            statement.setObject(3, dropOffTime.toLocalDateTime());
            statement.setInt(4, Integer.parseInt(parsedValues[3]));
            statement.setDouble(5, Double.parseDouble(parsedValues[4])); // trip distance
            statement.setInt(6, Integer.parseInt(parsedValues[7])); // PU LOCATION ID
            statement.setInt(7, Integer.parseInt(parsedValues[8])); // DU location id
            statement.setInt(8, Integer.parseInt(parsedValues[5])); // rate code id
            statement.setString(9, parsedValues[6]); // store_and fwd flag
            statement.setInt(10, Integer.parseInt(parsedValues[9])); // payment type
            statement.setDouble(11, Double.parseDouble(parsedValues[10])); // fare_amount
            statement.setDouble(12, Double.parseDouble(parsedValues[11])); // extra
            statement.setDouble(13, Double.parseDouble(parsedValues[12])); // mta_tax
            statement.setDouble(14, Double.parseDouble(parsedValues[15])); // improved surcharge
            statement.setDouble(15, Double.parseDouble(parsedValues[13])); // tip amount
            statement.setDouble(16, Double.parseDouble(parsedValues[14])); // tolls amount
            statement.setDouble(17, Double.parseDouble(parsedValues[16]));// total amount
            statement.execute();
            statement.close();
        }

       bufferedReader.close();
    }
}


