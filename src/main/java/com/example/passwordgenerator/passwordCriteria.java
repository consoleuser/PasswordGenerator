package com.example.passwordgenerator;

public class passwordCriteria {
    private int length;
    private boolean isUpper;
    private boolean includeNumbers;
    private boolean includeSpecial;
    private boolean StartWithLetter;
    private boolean hasDuplicates;

    public passwordCriteria() {
        this.length = 0;
        this.isUpper = false;
        this.includeNumbers = false;
        this.includeSpecial = false;
        this.StartWithLetter = false;
        this.hasDuplicates = false;
    }
    public passwordCriteria(int length, boolean isUpper, boolean includeNumbers,
                            boolean includeSpecial, boolean StartWithLetter, boolean hasDuplicates) {
        this.length = length;
        this.isUpper = isUpper;
        this.includeNumbers = includeNumbers;
        this.includeSpecial = includeSpecial;
        this.StartWithLetter = StartWithLetter;
        this.hasDuplicates = hasDuplicates;
    }
    //standart setters and getters

    public void setLength(int length) {this.length = length;}
    public void setIsUpper(boolean isUpper) {this.isUpper = isUpper;}
    public void setIncludeNumbers(boolean includeNumbers) {this.includeNumbers = includeNumbers;}
    public void setIncludeSpecial(boolean includeSpecial) {this.includeSpecial = includeSpecial;}
    public void setStartWithLetter(boolean StartWithLetter) {this.StartWithLetter = StartWithLetter;}
    public void setHasDuplicates(boolean hasDuplicates) {this.hasDuplicates = hasDuplicates;}


    public int getLength() {return this.length;}
    public boolean getisUpper(){return this.isUpper;};
    public boolean getincludeNumbers(){return this.includeNumbers;}
    public boolean getincludeSpecial(){return this.includeSpecial;};
    public boolean getStartWithLetter(){return this.StartWithLetter;};
    public boolean gethasDuplicates(){return this.hasDuplicates;};


}
