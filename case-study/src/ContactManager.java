import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_PATH = "data/contacts.csv";


    public void addContact(Contact contact) {
        if(contact.isValidPhoneNumber() && contact.isValidGroup() && contact.isValidFullName() &&
                contact.isValidGender() && contact.isValidAddress() && contact.isValidBirthDate() &&
                contact.isValidEmail()){
            contacts.add(contact);
            System.out.println("Thêm danh bạ thành công!");
        }else {
            System.out.println("Thêm danh bạ không thành công");
        }
    }


    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }


    public Contact searchContact(String number) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(number)) {
                return contact;
            }
        }
        return null;
    }


    public void updateContact(String phoneNumber, Contact newContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                if (newContact.isValidPhoneNumber() && newContact.isValidGroup() &&
                        newContact.isValidFullName() && newContact.isValidGender() &&
                        newContact.isValidAddress() && newContact.isValidBirthDate() &&
                        newContact.isValidEmail()) {
                    contacts.set(i, newContact);
                    System.out.println("Cập nhật thành công!");
                } else {
                    System.out.println("Cập nhật không thành ");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ.");
    }


    public void deleteContact(String phoneNumber) {
        for (Contact contact : contacts)
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(contact);
            }
        System.out.println("Xóa thành công!");
    }

    public void writeToCSV() {
        File file = new File(FILE_PATH);

        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        boolean fileExists = file.exists() && file.length() > 0;

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if(!fileExists){
                bw.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
                bw.newLine();
            }

            for (Contact contact : contacts) {
                bw.write("\"" + contact.getPhoneNumber() + "\",\"" + contact.getGroup() + "\",\"" +
                        contact.getFullName() + "\",\"" + contact.getGender() + "\",\"" +
                        contact.getAddress() + "\",\"" + contact.getBirthDate() + "\",\"" +
                        contact.getEmail() + "\"");
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readCSV() {
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            System.out.println("File không tồn tại hoặc trống.");
            return;
        }

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 7) {
                    Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                    contacts.add(contact);
                }
            }
            br.close();
            fr.close();

            System.out.println("Dữ liệu đã được đọc thành công từ file CSV!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortContactsByName() {
        Collections.sort(contacts, (a, b) -> a.getFullName().compareToIgnoreCase(b.getFullName()));
        System.out.println("Danh bạ đã được sắp xếp theo tên!");
    }


}
