public class Main {

    public static void main(String[] args) {

        AppiumCourse appiumCourse = new AppiumCourse("iTexico");
        /*appiumCourse.hello();
        System.out.println("the company name is: " + appiumCourse.getCompanyName());*/

        Foreach forEach = new Foreach();
        //forEach.foreachSyntax();
        appiumCourse.StringWorking("Equals");
        appiumCourse.StringWorking("EqualsIgnoreCase");
        appiumCourse.StringWorking("CompareTo");
        appiumCourse.StringWorking("compareToIgnoreCase");
    }


}
