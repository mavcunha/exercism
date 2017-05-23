public class Bob {
    public String hey(String msg) {
        if (msg.matches(".*\\b(?!OK)\\p{javaUpperCase}+\\b.*[^.]")) {
            return "Whoa, chill out!";
        } else if (msg.matches(".*\\?")) {
            return "Sure.";
        }
        return msg.trim().isEmpty() ? "Fine. Be that way!" : "Whatever.";
    }
}
