import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Contact {
    private String phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDate;
    private String email;


    public Contact(String phoneNumber, String group, String fullName, String gender, String address, String birthDate, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }


    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }



    public boolean isValidPhoneNumber() {
        String regex = "^(?:\\d{10}|\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}|\\(\\d{3}\\)\\d{3}[-.\\s]?\\d{4})$";
        return this.phoneNumber.matches(regex);
    }

    public boolean isValidGroup() {
        String regex = "^[a-zA-Z0-9 ]+$";
        return this.group.matches(regex);
    }

    public boolean isValidFullName() {
        String regex = "^[a-zA-Z-' ]+$";
        return this.fullName.matches(regex);
    }

    public boolean isValidGender() {
        String regex = "^(?i)(male|female)$";
        return this.gender.matches(regex);
    }

    public boolean isValidAddress() {
        String regex = "^[\\p{L}0-9\\s,.-]+$";
        return this.address.matches(regex);
    }

    public boolean isValidBirthDate() {
        String regex = "^(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[0-2])[-/](\\d{4})$";
        return this.birthDate.matches(regex);
    }

    public boolean isValidEmail() {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return this.email.matches(regex);
    }

    @Override
    public String toString() {
        return phoneNumber + ", " + group + ", " + fullName + ", " + gender + ", " + address + ", " + birthDate + ", " + email;
    }
}
