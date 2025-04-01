import java.util.ArrayList;
import java.util.Collections;

class Date implements Comparable<Date>  {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate() {
        boolean valid = true;

        if (month < 1 || month > 12) {
            valid = false;
        } else {
            int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (month == 2 && isLeapYear(year)) {
                daysInMonth[2] = 29;
            }

            if (day < 1 || day > daysInMonth[month]) {
                valid = false;
            }
        }

        return valid;
    }

    public void updateDate(int d, int m, int y) {
        if (new Date(d, m, y).isValidDate()) {
            this.day = d;
            this.month = m;
            this.year = y;
        } else {
            System.out.println("Invalid date provided.");
        }
    }

    public String getDayOfWeek() {
        int y = year;
        int m = month;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int h = (day + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }

    public int calculateDifference(Date otherDate) {
        int days1 = toDays(this);
        int days2 = toDays(otherDate);
        return Math.abs(days1 - days2);
    }

    private int toDays(Date date) {
        int y = date.year;
        int m = date.month;
        if (m < 3) {
            y -= 1;
            m += 12;
        }
        return 365 * y + y / 4 - y / 100 + y / 400 + (153 * m + 8) / 5 + date.day;
    }

    public void printDate() {
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(months[month] + " " + day + ", " + year);
    }

    private boolean isLeapYear(int year) {
        boolean leap = false;

        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                leap = true;
            }
        }

        return leap;
    }


    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }


        public static void main(String[] args) {
            ArrayList<Date> dates = new ArrayList<>();

            Date date1 = new Date(29, 2, 2024);
            System.out.println("Valid date: " + date1.isValidDate());
            System.out.println("Day of the week: " + date1.getDayOfWeek());
            date1.printDate();

            Date date2 = new Date(29, 2, 2023);
            System.out.println("Valid date: " + date2.isValidDate());

            Date date3 = new Date(1, 1, 2023);
            System.out.println("Difference in days: " + date1.calculateDifference(date3));

            dates.add(date1);
            dates.add(new Date(15, 5, 2022));
            dates.add(new Date(3, 7, 2025));
            dates.add(new Date(10, 10, 2020));



            Collections.sort(dates);

            System.out.println("After sorting:");
            for (Date d : dates) {
                d.printDate();
            }
        }
    }

