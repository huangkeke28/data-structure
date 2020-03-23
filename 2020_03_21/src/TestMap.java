import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        map.put("智多星", "吴用");
        map.put("入云龙", "公孙胜");
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("大刀关胜"));
        System.out.println(map.getOrDefault("行者", "武松"));
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("宋江"));
        System.out.println(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
