public class SP1Variation4 {

    // =========================
    // INSTANCE FIELDS
    // =========================

    private String bandName;
    private int fans;
    private int maxFans;
    private int fameLevel;
    private int experiencePoints;
    private double money;
    private char genre;
    private String[] repertoire;


    // =========================
    // CONSTRUCTOR
    // =========================

    public SP1Variation4(String bandName, char genre) {

        this.bandName = bandName;
        this.genre = genre;

        fans = 1000;
        maxFans = 5000;
        fameLevel = 1;
        experiencePoints = 0;
        money = 500.00;

        repertoire = new String[]{"Electric Dreams", "Midnight Run", "Broken Strings", "Neon Lights"};
    }


    // =========================
    // PRINT BAND PROFILE
    // =========================

    public void printBandProfile() {

        System.out.println("=== " + bandName + " (" + getGenreName() + ") ===");

        System.out.println("Fame Level: " + fameLevel + " | Fans: " + fans + "/" + maxFans + " | Money: $" + String.format("%.2f", money));

        System.out.println();
    }


    // =========================
    // PLAY GIG
    // =========================

    public void playGig(int venueCapacity, int attendance) {

        int oldFans = fans;
        double oldMoney = money;

        double fillPercentage = (double) attendance / venueCapacity * 100;

        System.out.println(bandName + " plays to " + attendance + " people! (" + (int) fillPercentage + "% full)"
        );

        // More than 80% full = +200 fans
        if (fillPercentage > 80) {
            gainFans(200);
        } else {
            gainFans(50);
        }

        // Concert payout
        earnMoney(3000);

        System.out.println("Fans: " + oldFans + " -> " + fans);

        System.out.printf("Money: $%.2f -> $%.2f%n", oldMoney, money);

        System.out.println();
    }


    // =========================
    // GAIN FANS
    // =========================

    public void gainFans(int amount) {

        fans += amount;

        if (fans > maxFans) {
            fans = maxFans;
        }
    }


    // =========================
    // LOSE FANS
    // =========================

    public void loseFans(int amount) {

        fans -= amount;

        if (fans < 0) {
            fans = 0;
        } else if (fans == 0) {
            System.out.println(bandName + " has broken up!");
        }
    }


    // =========================
    // EARN MONEY
    // =========================

    public void earnMoney(double amount) {

        money += amount;
    }


    // =========================
    // SPEND MONEY
    // =========================

    public boolean spendMoney(double amount) {

        if (money >= amount) {
            money -= amount;
            return true;
        } else {
            return false;
        }
    }


    // =========================
    // ADD XP
    // =========================

    public void addXP(int amount) {

        experiencePoints += amount;

        int xpThreshold = 2000 * fameLevel;

        if (experiencePoints > xpThreshold) {
            System.out.println(bandName + " is ready to level up!");
        }
    }


    // =========================
    // LEVEL UP
    // =========================

    public void levelUp() {

        if (fameLevel < 5) {

            fameLevel++;

            experiencePoints = 0;

            maxFans += 5000;

            System.out.println(bandName + " reached Fame Level " + fameLevel + "!"
            );
        }
    }


    // =========================
    // LOSING RELEVANCE
    // =========================

    public boolean isLosingRelevance() {
        return fans < maxFans * 0.25;
    }


    // =========================
    // ACTIVE
    // =========================

    public boolean isActive() {
        return fans > 0;
    }


    // =========================
    // FAN PERCENTAGE
    // =========================

    public double getFanPercentage() {
        return (double) fans / maxFans * 100;
    }


    // =========================
    // PRINT REPERTOIRE
    // =========================

    public void printRepertoire() {

        System.out.println("Repertoire (" + repertoire.length + " songs):"
        );

        for (String song : repertoire) {
            System.out.println("- " + song);
        }
    }


    // =========================
    // STATUS TITLE
    // =========================

    public String getStatusTitle() {

        if (fameLevel == 1) {
            return "Unknown - Playing in garages";

        } else if (fameLevel == 2) {
            return "Local Hero - Small venues await";

        } else if (fameLevel == 3) {
            return "Rising Star - Festival invitations coming in";

        } else if (fameLevel == 4) {
            return "Mainstream - Arena tours possible";

        } else if (fameLevel == 5) {
            return "Superstar - Stadium glory!";
        }

        return "Unknown status";
    }


    // =========================
    // GET GENRE NAME
    // =========================

    private String getGenreName() {

        if (genre == 'R') {
            return "Rock";

        } else if (genre == 'E') {
            return "Electronic";

        } else if (genre == 'H') {
            return "HipHop";

        } else if (genre == 'P') {
            return "Pop";
        }

        return "Unknown";
    }


    // =========================
    // GETTERS
    // =========================

    public String getBandName() {
        return bandName;
    }

    public int getFans() {
        return fans;
    }

    public int getMaxFans() {
        return maxFans;
    }

    public double getMoney() {
        return money;
    }

    public static void main(String[] args) {

        // =========================
        // CREATE TWO BANDS
        // =========================

        SP1Variation4 SP1Variation41 = new SP1Variation4("The Static Waves", 'R');

        SP1Variation4 SP1Variation42 = new SP1Variation4("Neon Disaster", 'E');


        // =========================
        // INITIAL PROFILES
        // =========================

        SP1Variation41.printBandProfile();
        SP1Variation42.printBandProfile();


        // =========================
        // SUMMER FESTIVAL
        // =========================

        System.out.println("=== SUMMER FESTIVAL ===");

        SP1Variation41.playGig(2000, 2000);

        SP1Variation42.playGig(2000, 1650);


        // =========================
        // COMPARE THE BANDS
        // =========================

        if (SP1Variation41.getFans() > SP1Variation42.getFans()) {

            System.out.println(
                    SP1Variation41.getBandName() + " is dominating the scene!");

        } else if (SP1Variation42.getFans() > SP1Variation41.getFans()) {

            System.out.println(SP1Variation42.getBandName() + " is dominating the scene!");

        } else {

            System.out.println("Both bands have the same number of fans!");
        }

        System.out.println();


        // =========================
        // FINAL PROFILES
        // =========================

        SP1Variation41.printBandProfile();
        SP1Variation42.printBandProfile();
    }
}