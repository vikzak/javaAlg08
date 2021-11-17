public class Main {
    public static void main(String[] args) {

        ChainHashMap<Integer, String> map = new ChainHashMap<>(7);
        map.put(1, "a");
        map.put(2, "б");
        map.put(3, "в");
        map.put(4, "г");
        map.put(5, "д");
        map.put(6, "е");
        map.put(7, "ж");
        map.put(8, "и");
        map.put(9, "к");
        map.put(10, "л");
        System.out.println(map);
        map.remove(1);
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
        map.remove(5);
        System.out.println(map);
        map.remove(7);
        System.out.println(map);
        map.remove(10);
        System.out.println(map);
        System.out.println("Размер: " + map.size());

    }
}
