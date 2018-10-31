package com.mapr.demo.mqtt.simple;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.Random;

public class Publisher {


  public static void main(String[] args) throws MqttException {

    MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.connect();
    MqttMessage message = new MqttMessage();
    Random rand = new Random();

    for(int i = 0; i <= 10000; i++) {

      int messageInt = rand.nextInt(2);
      String messageString = Integer.toString(messageInt);
      message.setPayload(messageString.getBytes());
      client.publish("iot_data", message);

      System.out.println(messageString);
    }

    client.disconnect();

    System.out.println("== END PUBLISHER ==");

  }


}
