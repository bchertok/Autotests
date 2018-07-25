package sberoad.learning;

class ParamObject {
    int i;

    ParamObject(int a) {
        i = a;
    }

    ParamObject increment() {
        return new ParamObject(i + 10);
    }
}

class ParamObjectTest {
    public static void main(String[] args) {
        ParamObject po = new ParamObject(10);
        ParamObject po1;

        po1 = po.increment();
        System.out.println(po1.i);
        System.out.println(po.i);
        po1 = po1.increment();
        System.out.println(po1.i);
        System.out.println(po.i);
    }
}