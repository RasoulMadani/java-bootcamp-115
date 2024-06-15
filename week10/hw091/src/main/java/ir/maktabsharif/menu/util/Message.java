package ir.maktabsharif.menu.util;

public class Message {
    // TODO change this with collections ;

    private static final String inputMessage = "pls enter %S";
    private static final String existMessage = "%S is already exist";
    private static final String invalidInputMessage = "your input values are invalid";
    private static final String successfulMessage = "%s successfully done";
    private static final String notFoundMessage = "%s not found";
    private static final String failedMessage = "%s failed";
    private static final String enterAgain = "Enter again ";


    public  String getInputMessage(String input) {
        return String.format(inputMessage, input);
    }

    public  String getExistMessage(String input) {
        return String.format(existMessage, input);
    }

    public  String getInvalidInputMessage() {
        return invalidInputMessage;
    }

    public  String getSuccessfulMessage(String input) {
        return String.format(successfulMessage, input);
    }

    public  String getNotFoundMessage(String input) {
        return String.format(notFoundMessage, input);
    }

    public  String getFailedMessage(String input) {
        return String.format(failedMessage, input);
    }
    public  String getEnterAgainMessage() {
        return enterAgain;
    }
}
