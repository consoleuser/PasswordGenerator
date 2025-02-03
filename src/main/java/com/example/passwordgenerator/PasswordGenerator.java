package com.example.passwordgenerator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class PasswordGenerator {

    Random random = new Random(getSeed());
    private ArrayList<String> password;
    String letters = "abcdefghijklmnopqrstuvwxyz";
    String UpperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numbers = "0123456789";
    String Special = "!@#$%^&*()_+-=[]{}|;':,./<>?";

    private void addchar(){
        password.add(letters.charAt(random.nextInt(letters.length())) + "");
    }
    private void addupper(){
        password.add(UpperLetters.charAt(random.nextInt(UpperLetters.length())) + "");
    }
    private void addnum (){password.add(numbers.charAt(random.nextInt(numbers.length())) + "");}
    private void addSpecial(){password.add(Special.charAt(random.nextInt(Special.length()) )+ "");}



    public String generatePassword(passwordCriteria criteria) {
        int count = 1;
        password = new ArrayList<>();
        if (criteria.getStartWithLetter() && count == 1) {
            password.add(letters.charAt(random.nextInt(letters.length())) + "");
            count++;
        }


        while(count <= criteria.getLength()){
            int randomNumber = random.nextInt(4);
            switch (randomNumber){
                case 0:
                    addchar();
                    break;
                case 1:
                    if(criteria.getisUpper()){addupper();}
                    break;
                case 2:
                    if(criteria.getincludeNumbers()){addnum();}
                    break;
                case 3:
                    if(criteria.getincludeSpecial()){addSpecial();}
                    break;
            }
            if(!criteria.gethasDuplicates()) {
                if (password.size() >= 1) {
                    HashSet<String> check = new HashSet<>(password);
                    if (check.size() != password.size()) {
                        count--;

                    }
                }
            }


            count++;
        }
        return String.join("", password);
    }

    public int getSeed() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int result = year + month + day + (int) System.nanoTime();;
        return result;
    }

}

