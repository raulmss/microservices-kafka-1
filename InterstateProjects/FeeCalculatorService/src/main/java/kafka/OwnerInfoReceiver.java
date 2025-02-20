package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OwnerInfoReceiver {

    @Autowired
    private FeeCalculator feeCalculator;
    @KafkaListener(topics = {"ownertopic"})
    public void receive(@Payload FeeRecord message) {
        feeCalculator.calculateFee(message);
//        System.out.println("Receiver Cam 1 received message= "+ message);
    }

}