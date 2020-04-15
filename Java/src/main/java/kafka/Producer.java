package kafka;

import kafka.tools.ConsoleConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.Callable;

public class Producer implements Callable<Boolean> {
    private static int MAX_MSG = 1000000;
    private final int id;

    public Producer(int i) {
        this.id = i;
    }

    public boolean run() {
        try {
            Properties props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "node1:9092,node2:9092,node3:9092");
            props.put(ProducerConfig.CLIENT_ID_CONFIG, "client" + id);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.put(ProducerConfig.RETRIES_CONFIG, 3); // retry is a must because no one can ensure the sending is successful for sure
            props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip"); // use compression for data
            props.put(ProducerConfig.ACKS_CONFIG, "all"); // 1 means if leaders ack receiving this message, considering successful,
            // if using the default 0, the performance could double

            KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);
            int msgCnt = 0;
            while (msgCnt < MAX_MSG) {
                ProducerRecord<Integer, String> record = new ProducerRecord<>("my-replicated-topic-3",
                        msgCnt % 3, msgCnt,
                        "This is record " + msgCnt);
                producer.send(record);
                ++msgCnt;
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean call() throws Exception {
        return run();
    }
}
