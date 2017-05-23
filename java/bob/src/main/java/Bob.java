public class Bob {
    public String hey(String msg) {
        if (msg.trim().isEmpty()) {
            return "Fine. Be that way!";
        } else if (msg.equals(msg.toUpperCase()) && !msg.equals(msg.toLowerCase())) {
            return "Whoa, chill out!";
        } else if (msg.endsWith("?")) {
            return "Sure.";
        }
        return "Whatever.";
    }
}
