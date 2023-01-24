package be.onurbugdayci.computerstuff;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

@Component
public class Computer {

    private LocalDate purchaseDate;
    private URL vendorURL;
    private double price;
    private int memory;
    private String cpu;
    private int processors;
    private String ownerName;
    private String os;
    private List<String> features;

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Value("#{T(java.time.LocalDate).now()}")
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public URL getVendorURL() {
        return vendorURL;
    }

    @Value("#{new java.net.URL('https://www.bol.com')}")
    public void setVendorURL(URL vendorURL) {
        this.vendorURL = vendorURL;
    }

    public double getPrice() {
        return price;
    }

    @Value("#{1499.22}")
    public void setPrice(double price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    @Value("#{T(Runtime).getRuntime().totalMemory()}")
    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getCpu() {
        return cpu;
    }

    @Value("#{systemEnvironment['PROCESSOR_ARCHITECTURE']}")
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getProcessors() {
        return processors;
    }

    @Value("#{T(Runtime).getRuntime().availableProcessors()}")
    public void setProcessors(int processors) {
        this.processors = processors;
    }


    public String getOwnerName() {
        return ownerName;
    }

    @Value("#{systemProperties['user.name']}")
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOs() {
        return os;
    }

    @Value("#{systemProperties['os.name']}")
    public void setOs(String os) {
        this.os = os;
    }

    public List<String> getFeatures() {
        return features;
    }

    @Value("#{{'very fast', 'not slow'}}")
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "purchaseDate=" + purchaseDate +
                ", vendorURL=" + vendorURL +
                ", price=" + price +
                ", memory=" + memory +
                ", cpu='" + cpu + '\'' +
                ", processors=" + processors +
                ", ownerName='" + ownerName + '\'' +
                ", os='" + os + '\'' +
                ", features=" + features +
                '}';
    }
}
