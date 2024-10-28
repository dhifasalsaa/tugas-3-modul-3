import java.util.Scanner;

/**
 * ini merupakan kelas TicketBooking yang digunakan untuk memesan tiket kereta
 * program ini meminta input dari pengguna untuk nama penumpang, tujuan, dan jumlah tiket
 * kemudian menampilkan ringkasan tiket yang berhasil dipesan
 */
public class TicketBooking {
    /**
     * metode utama yang memulai program pemesanan tiket kereta api
     * @param args argumen baris yang diteruskan ke program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = getInput(scanner, "Masukkan nama penumpang: ");
        String destination = getDestination(scanner);

        int price = getTicketPrice(destination);
        int ticketCount = Integer.parseInt(getInput(scanner, "Masukkan jumlah tiket: "));

        printTicketSummary(name, destination, ticketCount, price * ticketCount);

        scanner.close();
    }

    /**
     * mendapatkan input dari pengguna sesuai dengan prompt yang di berikan
     * @param scanner objek Scanner untuk membaca input dari pengguna
     * @param prompt  teks yang akan di tampilkan untuk meminta dari pengguna
     * @return input yang diberikan oleh pengguna untuk sebuah string
     */
    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * meminta pengguna muntuk memasukkan tujuan (jakarta, bandung, atau surabaya)
     * @param scanner objek Scanner untuk membaca input dari pengguna
     * @return tujuan yang valid yang dimasukkan oleh pengguna sesuai dengan tujuan yang tersedia
     */
    private static String getDestination(Scanner scanner) {
        String destination;
        while (true) {
            destination = getInput(scanner, "Masukkan tujuan (Jakarta/Bandung/Surabaya): ");
            if (destination.equalsIgnoreCase("Jakarta") ||
                    destination.equalsIgnoreCase("Bandung") ||
                    destination.equalsIgnoreCase("Surabaya")) {
                break;
            }
            System.out.println("Tujuan tidak tersedia. Silakan coba lagi.");
        }
        return destination;
    }

    /**
     * mengembalikan harga tiket berdasarkan tujuan yang diberikab
     * @param destination tujuan perjalanan (Jakarta, Bandung, atau Surabaya)
     * @return akan di exeptionhandling jika tujuan tidak valid
     */
    private static int getTicketPrice(String destination) {
        switch (destination.toLowerCase()) {
            case "jakarta": return 150000;
            case "bandung": return 100000;
            case "surabaya": return 200000;
            default: throw new IllegalArgumentException("Tujuan tidak valid");
        }
    }

    /**
     * menampilkan ringkasan tiket yang telah dioesan, termasuk nama penumpang, tujuan, jumlah harga, dan total harga
     * @param name nama penunmpang
     * @param destination tujuan perjalanan
     * @param ticketCount jumlah tiket yang dipesan
     * @param totalPrice total harga tiket
     */
    private static void printTicketSummary(String name, String destination, int ticketCount, int totalPrice) {
        System.out.println("=== Tiket Berhasil Dipesan ===");
        System.out.println("Nama: " + name);
        System.out.println("Tujuan: " + destination);
        System.out.println("Jumlah Tiket: " + ticketCount);
        System.out.println("Total Harga: Rp" + totalPrice);
    }
}
