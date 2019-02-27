package app.model;

public class SavedNameException extends Exception {
    private String existingName;
    public SavedNameException(String message) {
        super(message);
    }
    public void setExistingElemtnt(String existingName){
        this.existingName = existingName;
    }
    public String getExistingElement(){
        return existingName;
    }
}
