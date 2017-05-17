import java.util.ArrayList;
import java.util.List;

final class Flattener {

    public List<Object> flatten(List<Object> list) {
        return flatList(new ArrayList<>(), list);
    }

    private List<Object> flatList(List<Object> flat, List<Object> filler) {
        for (Object o : filler) {
            if (o instanceof List) {
                flatList(flat, (List) o);
            } else if(o != null) {
                flat.add(o);
            }
        }
        return flat;
    }
}
