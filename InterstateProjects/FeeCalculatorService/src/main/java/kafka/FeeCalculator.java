package kafka;

import org.springframework.stereotype.Component;

@Component
public class FeeCalculator {
    public void calculateFee(FeeRecord message) {
        int fee = getFee(message.getSpeed());

        String formattedOutput = String.format("License Plate: %s, Owner: %s, Address: %s, Speed: %d, Fee: %d",
                message.getLicencePlate(), message.getOwnerName(), message.getOwnerAddress(), message.getSpeed(), fee);
        System.out.println(formattedOutput);

    }

    private int getFee(int speed) {
        int fee;
        if(speed <= 77){
            fee = 25;
        } else if (speed > 77 && speed <=82) {
            fee = 45;
        } else if (speed > 82 && speed <=90) {
            fee = 80;
        }else{
            fee = 125;
        }
        return fee;
    }
}
