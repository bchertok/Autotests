package sberoad.learning;

public class BoxDemo3 {
    public static void main(String[] args) {
        Box myBox1 = new Box(12, 156, 15);
        Box myBox2 = new Box(24);
        Box mybox3 = new Box(2.0);
        // передали объект в качестве параметра
        Box myboxclone = new Box(myBox1);
        double box1 = myBox1.volume();
        double box2 = myBox2.volume(54, 12, 78);
        double box3 = mybox3.volume();
        double boxclone = myboxclone.volume();
        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);
        System.out.println(boxclone);
    }

}
