public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {
        long milesPerHour = Math.round(kilometersPerHour / 1.609);

        if (kilometersPerHour < 0) {
            return -1;
        }

        return milesPerHour;
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = "
                    + toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }

    public static void main(String[] args) {
        printConversion(75.114);
    }
}
