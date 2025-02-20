package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class InfoReceiver {

    @Autowired
    private OwnerInfoViewer ownerInfoViewer;

    @KafkaListener(topics = {"tofasttopic"})
    public void receive(@Payload SpeedRecord message) {
        ownerInfoViewer.handleRecord(message);
//        System.out.println("Receiver Cam 1 received message= "+ message);
    }

}