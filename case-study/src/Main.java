import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            System.out.println("\n--- QUẢN LÝ DANH BẠ ---");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Xóa");
            System.out.println("5. Cập Nhật");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Sắp xếp");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số điện thoại (10 chữ số, ví dụ: 0123456789): ");
                    String phone = scanner.nextLine();

                    System.out.print("Nhập nhóm (chỉ chữ cái và số, ví dụ: Nhom1): ");
                    String group = scanner.nextLine();

                    System.out.print("Nhập họ tên (ví dụ: Nguyen Hoang Lan): ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập giới tính (male/female): ");
                    String gender = scanner.nextLine();

                    System.out.print("Nhập địa chỉ (ví dụ: 123 Đường ABC, Quận 1, TP. Hồ Chí Minh): ");
                    String address = scanner.nextLine();

                    System.out.print("Nhập ngày sinh (dd/MM/yyyy hoặc dd-MM-yyyy, ví dụ: 26/10/2004): ");
                    String birthDate = scanner.nextLine();

                    System.out.print("Nhập email (ví dụ: example@example.com): ");
                    String email = scanner.nextLine();

                    manager.addContact(new Contact(phone, group, name, gender, address, birthDate, email));
                    break;
                case 2:
                    manager.displayContacts();
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại cần tìm: ");
                    String number = scanner.nextLine();
                    Contact found = manager.searchContact(number);

                    System.out.println(found != null ? found : "Không tìm thấy.");
                    break;
                case 4:
                    System.out.print("Nhập số điện thoại cần xóa: ");
                    String phoneDelete = scanner.nextLine();

                    manager.deleteContact(phoneDelete);
                    break;
                case 5:
                    System.out.print("Nhập số điện thoại cần cập nhật (10 chữ số, ví dụ: 0123456789): ");
                    String phoneUpdate = scanner.nextLine();

                    System.out.print("Nhập nhóm mới (chỉ chữ cái và số, ví dụ: Nhom1): ");
                    String groupUpdate = scanner.nextLine();

                    System.out.print("Nhập họ tên mới (ví dụ: Nguyen Hoang Lan): ");
                    String newName = scanner.nextLine();

                    System.out.print("Nhập giới tính mới (male/female): ");
                    String genderUpdate = scanner.nextLine();

                    System.out.print("Nhập địa chỉ mới (ví dụ: 123 Đường ABC, Quận 1, TP. Hồ Chí Minh): ");
                    String addressUpdate = scanner.nextLine();

                    System.out.print("Nhập ngày sinh mới (dd/MM/yyyy hoặc dd-MM-yyyy, ví dụ: 26/10/2004): ");
                    String birthDateUpdate = scanner.nextLine();

                    System.out.print("Nhập email mới (ví dụ: example@example.com): ");
                    String emailUpdate = scanner.nextLine();

                    manager.updateContact(phoneUpdate, new Contact(phoneUpdate, groupUpdate, newName, genderUpdate, addressUpdate, birthDateUpdate, emailUpdate));
                    break;
                case 6:
                    manager.readCSV();
                    break;
                case 7:
                    manager.writeToCSV();
                    break;
                case 8:
                    manager.sortContactsByName();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        scanner.close();
    }
}