package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OwnerInfoViewer {

    @Autowired
    private Sender sender;
    private String generateOwnerName() {
        String[] names = {"John Doe", "Jane Smith", "Alice Johnson", "Robert Brown"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    private String generateOwnerAddress() {
        String[] addresses = {"123 Main St", "456 Elm St", "789 Oak St", "101 Maple St"};
        Random random = new Random();
        return addresses[random.nextInt(addresses.length)];
    }

    public void handleRecord(SpeedRecord message) {
        String ownerName = generateOwnerName();
        String ownerAddress = generateOwnerAddress();
        FeeRecord feeRecord = new FeeRecord(ownerName, ownerAddress, message.getLicencePlate(), message.getSpeed());
        String formattedOutput = String.format("Owner: %s, Address: %s",
                ownerName, ownerAddress);
        System.out.println(formattedOutput);
        sender.send("ownertopic",feeRecord);
    }
}
