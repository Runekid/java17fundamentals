package be.onurbugdayci.junit.exercise08;

import be.onurbugdayci.junit.exercise05.Heating;
import be.onurbugdayci.junit.exercise05.Sensor;
import be.onurbugdayci.junit.exercise05.Temperature;
import be.onurbugdayci.junit.exercise05.Thermostat;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
public class ThermostatTest {
   private final static int INTERVAL = 10;
   private final static int SLEEP_TIME = INTERVAL * 3;
   private Thermostat thermostat;
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
      thermostat.setTargetTemperature(new Temperature(20));
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
      Temperature target = new Temperature(20);
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
      Temperature target = new Temperature(0);
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

   @RepeatedTest(10)
   public void testThermostatInterval(RepetitionInfo info, TestReporter reporter) {
      reporter.publishEntry("Current test", Integer.toString(info.getCurrentRepetition()));
      Temperature target = new Temperature(20F);
      thermostat.setTargetTemperature(target);
      thermostat.setInterval(10);
      heatingMock.setHeating(false);
      sensorMock.setTemp(15);
      Assertions.assertTimeoutPreemptively(Duration.ofMillis(20), new Executable() {
         @Override
         public void execute() throws Throwable {
            while (!heatingMock.isHeating()) {
               Thread.sleep(1);
            }
         }
      });
   }

   @ParameterizedTest
   @CsvFileSource(resources = "/data.csv")
   @Tag("parameterized")
   public void paramTest(float target, float current, boolean status) throws InterruptedException {
      thermostat.setTargetTemperature(new Temperature(target));
      sensorMock.setTemp(current);
      Thread.sleep(INTERVAL * 3);
      assertEquals(status, thermostat.isHeating());
   }

   private void sleep() {
      try {
         Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}
