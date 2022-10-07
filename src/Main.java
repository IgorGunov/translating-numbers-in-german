import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число словом");
        int units = 0;
        int unitsEnd = 0;
        int dozens = 0;
        int hundreds = 0;
        int hundredsStart = 0;
        int hundredsEnd = 0;
        int sum = 0;
        String line = scanner.nextLine();
        String text = line.replaceAll("\\s","");
        String text2;


        for (int i = 0; i < text.length() - 7; i ++) {
            int x = i + 7;

            if (text.substring(i,x).equals("hundert")) {
                hundredsStart = i;
                hundredsEnd = x;
                if (hunders(text.substring(0, hundredsStart)) != 10) {
                    hundreds = hunders(text.substring(0, hundredsStart));
                }
            }
            if (text.substring(i + 1).equals("hundert")) {
                hundredsStart = i + 1;
                hundredsEnd = x;
                if (hunders(text.substring(0, hundredsStart)) != 10) {
                    hundreds = hunders(text.substring(0, hundredsStart));
                }
            }
        }


        for (int i = hundredsEnd; i < text.length(); i ++) {

            if (units(text.substring(hundredsEnd, i)) != 10) {
                units = units(text.substring(hundredsEnd, i));
                unitsEnd = i;
            }

            if (units(text.substring(hundredsEnd)) != 10) {
                units = units(text.substring(hundredsEnd));
            }

            if (i == text.length()) {
                units = units(text.substring(hundredsEnd, i + 1));
            }
        }

        for (int i = unitsEnd; i < text.length(); i ++) {
            text2 = text.substring(i);
            if (dozens(text2) != 10) {
                dozens = dozens(text2);
            }
        }

        if (hundreds != 0) {
            sum = sum + hundreds * 100;
        } else {
            System.out.println("Ошибка в сотнях");
            return;
        }

        if (dozens != 0) {
            sum = sum + dozens * 10;;
        } else {
            System.out.println("Ошибка в десятках");
            return;
        }

        if (units != 0) {
            sum = sum + units;;
        } else {
            System.out.println("Ошибка в единицах");
            return;
        }
        System.out.print(sum);
    }

    public static int units(String text) {
        if (text.equals("null")) {
            return(0);
        } else if (text.equals("eins")) {
            return(1);
        } else if (text.equals("zwei")) {
            return(2);
        } else if (text.equals("drei")) {
            return(3);
        } else if (text.equals("vier")) {
            return(4);
        } else if (text.equals("fünf")) {
            return(5);
        } else if (text.equals("sechs")) {
            return(6);
        } else if (text.equals("sieben")) {
            return(7);
        } else if (text.equals("acht")) {
            return(8);
        } else if (text.equals("neun")) {
            return (9);
        } else if (text.equals("elf")) {
            return (11);
        } else if (text.equals("zwölf")) {
            return (12);
        }
        return 10;
    }

    public static int dozens(String text) {
        if (text.equals("zehn")) {
            return(1);
        } else if (text.equals("zwanzig")) {
            return(2);
        } else if (text.equals("dreißig")) {
            return(3);
        } else if (text.equals("vierzig")) {
            return(4);
        } else if (text.equals("fünfzig")) {
            return(5);
        } else if (text.equals("sechzig")) {
            return(6);
        } else if (text.equals("siebzig")) {
            return(7);
        } else if (text.equals("achtzig")) {
            return(8);
        } else if (text.equals("neunzig")) {
            return (9);
        }
        return 10;
    }

    public static int hunders(String text) {
        if (text.equals("null")) {
            return(0);
        } else if (text.equals("ein")) {
            return(1);
        } else if (text.equals("zwei")) {
            return(2);
        } else if (text.equals("drei")) {
            return(3);
        } else if (text.equals("vier")) {
            return(4);
        } else if (text.equals("fünf")) {
            return(5);
        } else if (text.equals("sechs")) {
            return(6);
        } else if (text.equals("sieben")) {
            return(7);
        } else if (text.equals("acht")) {
            return(8);
        } else if (text.equals("neun")) {
            return (9);
        }
        return 10;
    }
}