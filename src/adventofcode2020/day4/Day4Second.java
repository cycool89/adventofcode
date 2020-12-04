package src.adventofcode2020.day4;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.lib.FileHandler;

public class Day4Second {

    static class Validator {
        public static boolean checkBirthYear(String byr) {
            return between(1920, 2002, byr);
        }

        public static boolean checkIssueYear(String iyr) {
            return between(2010, 2020, iyr);
        }

        public static boolean checkExpirationYear(String eyr) {
            return between(2020, 2030, eyr);
        }

        public static boolean checkHeight(String hgt) {
            String regex = "^([0-9]+)(cm|in)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(hgt);

            if (matcher.find() && matcher.groupCount() == 2) {
                String value = matcher.group(1);
                if (matcher.group(2).equals("in")) {
                    return between(59, 76, value);
                } else if (matcher.group(2).equals("cm")) {
                    return between(150, 193, value);
                } else {
                    return false;
                }
            }
            return false;
        }

        public static boolean checkHairColor(String hcl) {
            return hcl.matches("^#[0-9a-f]{6}$");
        }

        public static boolean checkEyeColor(String ecl) {
            String regex = "^(amb|blu|brn|gry|grn|hzl|oth){1}$";
            return ecl.matches(regex);
        }

        public static boolean checkPassportId(String pid) {
            return pid.matches("^[0-9]{9}$");
        }

        private static boolean between(int min, int max, String s) {
            if (s.isEmpty())
                return false;

            int value = Integer.parseInt(s);
            return min <= value && value <= max;
        }
    }

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
            return Validator.checkBirthYear(birthYear)
                && Validator.checkIssueYear(issueYear)
                && Validator.checkExpirationYear(expirationYear)
                && Validator.checkHeight(height)
                && Validator.checkHairColor(hairColor)
                && Validator.checkEyeColor(eyeColor)
                && Validator.checkPassportId(passportId);
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