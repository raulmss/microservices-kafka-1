# **Kafka-Based Messaging Systems**

This repository contains multiple Kafka-based applications demonstrating message passing using **KafkaSender**, **KafkaReceiver**, and an **Interstate Traffic Monitoring System**.

---

## **1. Prerequisites**
Ensure you have the following installed:
- **Java 17+**
- **Apache Kafka**
- **Zookeeper**
- **KafkaMagic** (optional for debugging messages)
- **Maven** (for building the project)

---

## **2. Setting Up Kafka**
### **Windows Users**
1. Download Kafka from [here](https://drive.google.com/file/d/1CfrPLthryuvl7iktZYp87w2tuaTjvIFc/view?usp=drive_link).
2. Edit the configuration files:
   - Open `.../kafka_2.11-1.1.0/config/server.properties` and ensure the log directory exists.
   - Open `.../kafka_2.11-1.1.0/config/zookeeper.properties` and ensure the log directory exists.
3. Start Kafka:
   - Run **Zookeeper** by double-clicking `startzookeeper`.
   - Run **Kafka** by double-clicking `startkafka`.

### **Mac Users**
1. Follow [this guide](https://www.tutorialkart.com/apache-kafka/install-apache-kafka-on-mac/) to install Kafka.
2. Install KafkaMagic from [here](https://www.kafkamagic.com/download/).

---

## **3. Running the Kafka Applications**
This repository contains two applications: **KafkaSender** and **KafkaReceiver**.

### **Running KafkaReceiver**
1. Navigate to `KafkaReceiver`.
2. Run the **ReceiverApplication**:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. The receiver will start listening for messages.

### **Running KafkaSender**
1. Navigate to `KafkaSender`.
2. Run the **SenderApplication**:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. The sender will publish messages to Kafka.
4. Check the **ReceiverApplication's console** for received messages.

---

## **4. Verifying Messages in Kafka**
1. Open KafkaMagic and navigate to [http://localhost:5000/](http://localhost:5000/).
2. Click **Launch the Magic!**.
3. Select `TopicA` and click **Run Search**.
4. You will see the messages sent by `KafkaSender`.

---

## **5. Interstate Traffic Monitoring System**
This system simulates two **traffic cameras** publishing data to Kafka.

### **Running the Traffic Simulation**
1. Navigate to `InterstateTrafficSensor` project.
2. Run:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. This will publish vehicle sensor data to `cameratopic1` and `cameratopic2`.

---

## **6. Additional Kafka Services**
### **SpeedService**
- Consumes messages from both camera topics.
- Calculates the speed of vehicles.

### **OwnerService**
- Retrieves owner details of speeding vehicles.

### **FeeCalculatorService**
- Determines the fine for each speeding vehicle based on:
  - **72 – 77 mph** → $25  
  - **77 – 82 mph** → $45  
  - **82 – 90 mph** → $80  
  - **> 90 mph** → $125  

### **Running Additional Services**
Each service runs independently:
```sh
mvn clean install
mvn spring-boot:run
```

---
