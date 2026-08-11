package payloads;

public class PayloadData {

    public static String getCreateAccountPayload() {

        return "name=API Test User" +
                "&email=api.test.user.automation@gmail.com" +
                "&password=Test@12345" +
                "&title=Mr" +
                "&birth_date=15" +
                "&birth_month=5" +
                "&birth_year=1998" +
                "&firstname=API" +
                "&lastname=Test" +
                "&company=Automation Project" +
                "&address1=Test Address" +
                "&address2=Test Address 2" +
                "&country=India" +
                "&zipcode=12345" +
                "&state=Test State" +
                "&city=Test City" +
                "&mobile_number=01000000000";
    }
}