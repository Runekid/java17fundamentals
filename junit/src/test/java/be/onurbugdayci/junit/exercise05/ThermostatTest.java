package be.onurbugdayci.junit.exercise05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@Disabled
public class ThermostatTest {
   private final static int INTERVAL = 10;
   private final static int SLEEP_TIME = INTERVAL * 3;
   private Thermostat thermostat;
   private HeatingStub heatingStub;
   private SensorStub sensorStub;

   private class HeatingStub implements Heating {
      public void setHeating(boolean status) {
      }
   }

   private class SensorStub implements Sensor {
      private float temp;

      public Temperature getTemperature() {
         return new Temperature(temp);
      }

      public void setTemp(float temp) {
         this.temp = temp;
      }
   }

   @BeforeEach
   public void init() {
      sensorStub = new SensorStub();
      heatingStub = new HeatingStub();
      thermostat = new Thermostat(heatingStub, sensorStub);
      thermostat.setInterval(INTERVAL);
      thermostat.start();
   }

   @AfterEach
   public void destroy() {
      thermostat.stop();
   }

   @Test
   public void testThermostat() throws InterruptedException {
      thermostat.setTargetTemperature(new Temperature(20));
      sensorStub.setTemp(15);
      Thread.sleep(INTERVAL *3);
      assertTrue(thermostat.isHeating());
   }
   
   @Test
   public void testChangeCurrent() {
      Temperature target = new Temperature(20);
      thermostat.setTargetTemperature(target);
      for (float t = 15; t < 20; t += 0.1F) {
         sensorStub.setTemp(t);
         sleep();
         assertTrue(thermostat.isHeating());
      }
      for (float t = 20; t < 25; t += 0.1F) {
         sensorStub.setTemp(t);
         sleep();
         assertFalse(thermostat.isHeating());
      }
      for (float t = 25; t >= 20; t -= 0.1F) {
         sensorStub.setTemp(t);
         sleep();
         assertFalse(thermostat.isHeating());
      }
      for (float t = 19.9F; t >= 15; t -= 0.1F) {
         sensorStub.setTemp(t);
         sleep();
         assertTrue(thermostat.isHeating());
      }
   }

   @Test
   public void testChangeTarget() {
      Temperature target = new Temperature(0);
      sensorStub.setTemp(20F);
      for (float t = 15; t <= 20; t += 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sleep();
         assertFalse(thermostat.isHeating());
      }
      for (float t = 20.01F; t < 25; t += 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sleep();
         assertTrue(thermostat.isHeating());
      }
      for (float t = 25; t > 20; t -= 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sleep();
         assertTrue(thermostat.isHeating());
      }
      for (float t = 20F; t >= 15; t -= 0.1F) {
         target.setValue(t);
         thermostat.setTargetTemperature(target);
         sleep();
         assertFalse(thermostat.isHeating());
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
