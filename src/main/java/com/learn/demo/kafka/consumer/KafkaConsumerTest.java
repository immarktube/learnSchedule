package com.learn.demo.kafka.consumer;

import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * @Since 2024/4/8 00:07
 **/
public class KafkaConsumerTest {
    public static void main(String[] args) {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "atguigu");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configMap);
        consumer.subscribe(Collections.singletonList("test"));

        while(true){
            final val duration = Duration.ofMillis(100);
            final val datas = consumer.poll(duration);
            for (ConsumerRecord<String, String> data : datas) {
                System.out.printf(data.value());
            }
        }
        // consumer.close();
    }
}
