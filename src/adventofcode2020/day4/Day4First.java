package src.adventofcode2020.day4;

import java.util.List;

import src.lib.FileHandler;

public class Day4First {

    static class Passport {
        String birthYear = "";
        String issueYear = "";
        String expirationYear = "";
        String height = "";
        String hairColor = "";
        String eyeColor = "";
        String passportId = "";
        String countryId = "";

        public void set(String property, String value) {
            switch (property) {
                case "byr":
                    birthYear = value;
                    break;
                case "iyr":
                    issueYear = value;
                    break;
                case "eyr":
                    expirationYear = value;
                    break;
                case "hgt":
                    height = value;
                    break;
                case "hcl":
                    hairColor = value;
                    break;
                case "ecl":
                    eyeColor = value;
                    break;
                case "pid":
                    passportId = value;
                    break;
                case "cid":
                    countryId = value;
                    break;
                default:
                    break;
            }
        }

        public boolean isValid() {
            return !birthYear.isEmpty() && !issueYear.isEmpty() && !expirationYear.isEmpty() && !height.isEmpty()
                    && !hairColor.isEmpty() && !eyeColor.isEmpty() && !passportId.isEmpty();
        }
    }

    public static void main(String[] args) {
        String[] inputPath = { "day4", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Passport p = new Passport();
        int validPassportCount = 0;

        for (String line : lines) {
            if (line.length() > 0) {
                String[] props = line.split(" ");
                for (int i = 0; i < props.length; i++) {
                    String[] keyvalue = props[i].split(":");
                    p.set(keyvalue[0], keyvalue[1]);
                }
            } else {
                if (p.isValid())
                    validPassportCount++;
                p = new Passport();
            }
        }
        if (p.isValid())
            validPassportCount++;

        System.out.println("Valid passport count: " + validPassportCount);
    }
}