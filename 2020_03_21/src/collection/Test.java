package collection;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("及时雨", "松江");
        map.put("玉麒麟", "卢俊义");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        map.put("及时雨", "晁盖");
        System.out.println(map);
        
    }
}
