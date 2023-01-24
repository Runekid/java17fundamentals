package be.onurbugdayci.junit.exercise06;

import be.onurbugdayci.junit.exercise05.Heating;
import be.onurbugdayci.junit.exercise05.Sensor;
import be.onurbugdayci.junit.exercise05.Temperature;
import be.onurbugdayci.junit.exercise05.Thermostat;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class ThermostatTest {
   private final static int INTERVAL = 10;
   private final static int SLEEP_TIME = INTERVAL * 3;
   private be.onurbugdayci.junit.exercise05.Thermostat thermostat;
   private HeatingMock heatingMock;
   private SensorMock sensorMock;

   private class HeatingMock implements Heating {
      private boolean status;

      public boolean isHeating() {
         return status;
      }

      // extra mock method to verify
      public void setHeating(boolean status) {
         this.status = status;
      }
   }

   private class SensorMock implements Sensor {
      private float temp;
      private boolean called;

      public Temperature getTemperature() {
         setCalled(true);
         return new Temperature(temp);
      }

      public void setTemp(float temp) {
         this.temp = temp;
      }

      public boolean isCalled() {
         return called;
      }

      public void setCalled(boolean status) {
         called = status;
      }
   }

   @BeforeEach
   public void init() {
      sensorMock = new SensorMock();
      heatingMock = new HeatingMock();
      thermostat = new Thermostat(heatingMock, sensorMock);
      thermostat.setInterval(INTERVAL);
      thermostat.start();
   }

   @AfterEach
   public void destroy() {
      thermostat.stop();
   }

   @Test
   public void testThermostat() throws InterruptedException {
      thermostat.setTargetTemperature(new be.onurbugdayci.junit.exercise05.Temperature(20));
      sensorMock.setTemp(15);
      sensorMock.setCalled(false);
      heatingMock.setHeating(false);
      Thread.sleep(INTERVAL *3);
      assertTrue(thermostat.isHeating());
      assertTrue(sensorMock.isCalled());
      assertTrue(heatingMock.isHeating());
   }
   
   @Test
   public void testChangeCurrent() {
      be.onurbugdayci.junit.exercise05.Temperature target = new be.onurbugdayci.junit.exercise05.Temperature(20);
      thermostat.setTargetTemperature(target);
      for (float t = 15; t < 20; t += 0.1F) {
         sensorMock.setTemp(t);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertTrue(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertTrue(heatingMock.isHeating());
      }
      for (float t = 20; t < 25; t += 0.1F) {
         sensorMock.setTemp(t);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertFalse(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertFalse(heatingMock.isHeating());
      }
      for (float t = 25; t >= 20; t -= 0.1F) {
         sensorMock.setTemp(t);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertFalse(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertFalse(heatingMock.isHeating());
      }
      for (float t = 19.9F; t >= 15; t -= 0.1F) {
         sensorMock.setTemp(t);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertTrue(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertTrue(heatingMock.isHeating());
      }
   }

   @Test
   public void testChangeTarget() {
      be.onurbugdayci.junit.exercise05.Temperature target = new Temperature(0);
      sensorMock.setTemp(20F);
      for (float t = 15; t <= 20; t += 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertFalse(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertFalse(heatingMock.isHeating());
      }
      for (float t = 20.01F; t < 25; t += 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertTrue(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertTrue(heatingMock.isHeating());
      }
      for (float t = 25; t > 20; t -= 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertTrue(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertTrue(heatingMock.isHeating());
      }
      for (float t = 20F; t >= 15; t -= 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sensorMock.setCalled(false);
         heatingMock.setHeating(false);
         sleep();
         assertFalse(thermostat.isHeating());
         assertTrue(sensorMock.isCalled());
         assertFalse(heatingMock.isHeating());
      }
   }

   private void sleep() {
      try {
         Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}
