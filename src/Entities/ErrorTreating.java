package Entities;

public class ErrorTreating extends Exception{
    private String error;

    public ErrorTreating(String message, String error) {
        super(message);
        this.error = error;
    }

    public String getError() {
        return this.error + " - " + this.getMessage();
    }


}
