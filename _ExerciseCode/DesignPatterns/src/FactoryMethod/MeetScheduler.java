package FactoryMethod;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Classe TimeFactory
class TimeFactory {
    // Método estático para criar um objeto LocalTime a partir de uma string
    public static LocalTime createTime(String timeString) {
        try {
            return LocalTime.parse(timeString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de horário inválido: " + timeString);
        }
    }
}

public class MeetScheduler {

    private static final LocalTime MIN_TIME = LocalTime.of(9, 0);
    private static final LocalTime MAX_TIME = LocalTime.of(18, 0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o horário desejado para a reunião (HH:MM):");
        String desiredTimeInput = scanner.nextLine();
        LocalTime desiredTime = TimeFactory.createTime(desiredTimeInput);

        System.out.println("Digite o horário atual do sistema (HH:MM):");
        String currentTimeInput = scanner.nextLine();
        LocalTime currentTime = TimeFactory.createTime(currentTimeInput);

        if (isMeetingSchedulable(desiredTime)) {
            System.out.println("Reuniao pode ser agendada.");
        } else {
            System.out.println("Reuniao nao pode ser agendada. Horario fora do intervalo permitido.");
        }
    }

    private static boolean isMeetingSchedulable(LocalTime desiredTime) {
        return !desiredTime.isBefore(MIN_TIME) && !desiredTime.isAfter(MAX_TIME);
    }
}

