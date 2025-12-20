package example;

import java.sql.*;
import java.util.Scanner;

public class ReservationSystem {
    public static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    public static final String username = "root";
    public static final String password = "123456";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while (true) {
                System.out.println();
                System.out.println("СИСТЕМА БРОНИРОВАНИЯ ОТЕЛЯ");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Бронирование номера");
                System.out.println("2. Просмотр бронирования");
                System.out.println("3. Уточнить номер комнаты");
                System.out.println("4. Обновить бронирования");
                System.out.println("5. Удалить бронирования");
                System.out.println("0. Выход");
                System.out.print("Выберите опцию: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
                    case 4:
                        updateReservation(connection, scanner);
                        break;
                    case 5:
                        deleteReservation(connection, scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте еще раз.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteReservation(Connection connection, Scanner scanner) {
        System.out.print("Введите идентификатор бронирования для удаления: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();

        if (!reservationExists(connection, reservationId)) {
            System.out.println("Бронирование не найдено для данного идентификатора.");
            return;
        }

        String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;

        try(Statement statement = connection.createStatement()){
            int row = statement.executeUpdate(sql);
            if (row > 0) {
                System.out.println("Бронирование успешно удалено");
            }else {
                System.out.println("Удаление резервирования не удалось");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateReservation(Connection connection, Scanner scanner) {
        System.out.print("Введите идентификатор бронирования для обновления: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();

        if (!reservationExists(connection, reservationId)) {
            System.out.println("Бронирование не найдено для данного идентификатора.");
            return;
        }

        System.out.print("Введите новое имя гостя: ");
        String newGuestName = scanner.nextLine();
        System.out.print("Введите новый номер комнаты: ");
        int newRoomNumber = scanner.nextInt();
        System.out.print("Введите новый контактный номер: ");
        String newContactNumber = scanner.next();

        String sql = "Update reservations SET guest_name = '" + newGuestName + "', room_number = " + newRoomNumber + ", contact_number = '" + newContactNumber + "' WHERE reservation_id = " + reservationId;

        try (Statement statement = connection.createStatement()) {
            int row = statement.executeUpdate(sql);

            if (row > 0) {
                System.out.println("Бронирование успешно обновлено!");
            } else {
                System.out.println("Обновление резервирования не удалось");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean reservationExists(Connection connection, int reservationId) {
        String sql = "select reservation_id from reservations where reservation_id = " + reservationId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void getRoomNumber(Connection connection, Scanner scanner) {
        System.out.print("Введите идентификатор бронирования: ");
        int reservationId = scanner.nextInt();
        System.out.print("Введите имя гостя: ");
        String guestName = scanner.next();

        String sql = "SELECT room_number FROM reservations WHERE reservation_id = " + reservationId + " AND guest_name = '" + guestName + "'";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                int roomNumber = resultSet.getInt("room_number");
                System.out.println("Номер комнаты для идентификатора бронирования " + reservationId + " и гостя " + guestName + " является: " + roomNumber);
            } else {
                System.out.println("Бронирование не найдено для данного идентификатора и имени гостя.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewReservations(Connection connection) {
        String sql = "select * from reservations";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Текущее бронирование:");
            System.out.println("+----------------------------+-------------+---------------+------------------+------------------------+");
            System.out.println("| Идентификатор бронирования | Гость       | Номер комнаты | Контактный номер | Дата бронирования      |");
            System.out.println("+----------------------------+-------------+---------------+------------------+------------------------+");

            while (resultSet.next()) {
                int reservationId = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();
                System.out.printf("| %-26d | %-11s | %-13d | %-16s | %-22s |%n", reservationId, guestName, roomNumber, contactNumber, reservationDate);
            }
            System.out.println("+----------------------------+-------------+---------------+------------------+------------------------+");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reserveRoom(Connection connection, Scanner scanner) {
        System.out.print("Введите имя гостя: ");
        String guestName = scanner.next();
        scanner.nextLine();
        System.out.print("Введите номер комнаты: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Введите контактный номер: ");
        String contactNumber = scanner.next();

        String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) VALUES ('" + guestName + "', " + roomNumber + ", '" + contactNumber + "')";

        try (Statement statement = connection.createStatement()) {
            int row = statement.executeUpdate(sql);
            if (row > 0) {
                System.out.println("Бронирование успешно");
            } else {
                System.out.println("Бронирование не удалось");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void exit() {
        System.out.println("Спасибо за использование системы бронирования отеля!!!");
    }
}
