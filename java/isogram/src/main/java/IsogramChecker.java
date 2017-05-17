public class IsogramChecker {
    public boolean isIsogram(String word) {
        String noSpacesOrHyphens = word.replaceAll("(?:\\s|-)", "").toLowerCase();
        return noSpacesOrHyphens.chars().distinct().count() == noSpacesOrHyphens.length();
    }
}
