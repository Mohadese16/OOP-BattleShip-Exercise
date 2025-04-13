public class InputValidator {

    // اعتبارسنجی مختصات مثل A5، C9 و ...
    public static boolean isValidCoordinate(String input) {
        if (input == null || input.length() != 2) return false;

        char col = Character.toUpperCase(input.charAt(0));
        char row = input.charAt(1);

        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');
    }

    // اعتبارسنجی جهت افقی یا عمودی
    public static boolean isValidOrientation(String input) {
        if (input == null) return false;
        input = input.toUpperCase();
        return input.equals("H") || input.equals("V");
    }
}
