class Examples3 {
    int numberOfStaff = 14;         //14 - integer literal, integer value
    //String name = "Greg Miranda";   //"Greg Miranda" - string literal, string value


    String firstname = "Greg";
    String lastname = "Miranda";
    String space = " ";

    String fullName1 = "Greg " + "Miranda";

    // + concatenates (or appends) strings
    String fullName2 = this.firstname + this.space + this.lastname;

    String str  = this.firstname + 2;
    String str1  = this.firstname + "2";

    //String className = "CSE11";
    //String className1 = "11";
    //String className2 = 11;   //type error
    //int klassName = 11;
    //int klassName1 = "11";    //type error

    String className = "11" + 200;
    //int klassName = 11 + "200";
    String klassName = 11 + "200";

    String value1 = 1 + 2 + 3 + " 11 " + 4 + 5 + 6;
    String value2 = 1 + 2 + 3 + " 11 " + (4 + 5 + 6);
}
