package kafka;

public class FeeRecord {

    private String ownerName;
    private String ownerAddress;
    private String licencePlate;
    private int speed;

    public FeeRecord(String ownerName, String ownerAddress, String licencePlate, int speed) {
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.licencePlate = licencePlate;
        this.speed = speed;
    }

    public FeeRecord(){}
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "FeeRecord{" +
                "licencePlate='" + licencePlate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", speed=" + speed +
                '}';
    }
}