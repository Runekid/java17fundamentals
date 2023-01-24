package exercise07_05;

public class StatisticsApp {
    public static void main(String[] args) {
        int[] nums = {5,2,2,8,1,48,47,10};
        System.out.println(Statistics.average(nums));
        System.out.println(Statistics.min(nums));
        System.out.println(Statistics.max(nums));
    }
}
