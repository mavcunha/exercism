public class PhoneNumber {
    private String phone;

    public PhoneNumber(String phone) {
        conformsTo(phone.matches("^[-\\d().\\s]+$"), "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.");

        this.phone = phone.replaceAll("(?:\\D)", "");

        conformsTo(this.phone.matches("^\\d{10,11}$"), "Number must be 10 or 11 digits");
        conformsTo(this.phone.matches("(?:\\d{10}|1\\d{10})"), "Can only have 11 digits if number starts with '1'");

        this.phone = this.phone.replaceFirst("^1(\\d{10})$", "$1");
    }

    private void conformsTo(boolean test, String message) {
        if(!test) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getNumber() {
        return this.phone;
    }
}
