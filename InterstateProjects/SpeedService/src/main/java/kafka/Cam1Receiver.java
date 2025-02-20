package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Cam1Receiver {

    @Autowired
    private SpeedCalculator speedCalculator;

    @KafkaListener(topics = {"cameratopic1"})
    public void receive(@Payload SensorRecord message) {
        speedCalculator.handleRecord(message);
//        System.out.println("Receiver Cam 1 received message= "+ message);
    }

}