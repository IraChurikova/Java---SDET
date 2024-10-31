public class Registration {

    public static boolean validateRegistration(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
            return false;
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login.length() >= 20 || !login.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть меньше 20 символов.");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() >= 20 || !password.matches("^[a-zA-Z0-9_]+$") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, быть меньше 20 символов и совпадать с подтверждением пароля.");
        }
    }

    public static void main(String[] args) {
        String login = "user_1";
        String password = "password123";
        String confirmPassword = "password123";

        boolean isValid = validateRegistration(login, password, confirmPassword);
        System.out.println("Регистрация " + (isValid ? "успешна" : "неудачна"));
    }
}

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
