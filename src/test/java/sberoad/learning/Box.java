package sberoad.learning;



class Box {
    private double width;
    private double height;
    private double depth;
    // неменяемая константа доступная всем методам класса
private  static final double z24 = 12;
    Box(double w, double h, double d){
        // конструктор
        width = w;
        height = h;
        depth = d;
    }
    Box(double z){
        // перегрузка конструктора
        width  =height =  depth = z;
    }
    Box(Box zz){
        width=zz.width;
        height=zz.height;
        depth=zz.depth;
    }

    double volume(){
        // метод
        return width*height*depth ;
    }
    double volume(double w, double h, double d){
        // перегрузка метода
//        w = width;
//        h = height;
//        d = depth;
        width = w;
        height = h;
        depth = d;

        return width*height*depth ;
    }


}
