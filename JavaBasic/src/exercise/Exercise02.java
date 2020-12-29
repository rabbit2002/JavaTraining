package exercise;

/**
 * 训练题-多态
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class Exercise02 {
    public static void main(String[] args) {
        Animal a = null;
        a = new Phoenix("Phoenix", "Phoenix", 10);
        System.out.println(a.toString());
        a.eat("meat");

        //        a = enw Eagle( ........ );
        //        System.out.println( a.toString() );
        //        a.eat( ..... );
        //
        a = new Bear("Bear", "Bear", 20);
        System.out.println(a.toString());
        a.eat("honey");
        //
        //        a = enw Lion( ........ );
        //        System.out.println( a.toString() );
        //        a.eat( ..... );
    }
}

class Animal {
    private final String type; // 某个个体对应的动物种类
    protected String name; // 某个个体的名称
    protected int age; // 某个个体的年龄

    // public Animal(String type) {
    //     this.type = type;
    // }

    public Animal(String type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public void eat(String food) {
        System.out.println("动物可以吃" + food);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Birds extends Animal {
    public Birds(String type, String name, int age) {
        super(type, name, age);
    }

    @Override
    public void eat(String food) {
        System.out.println("禽类可以吃" + food);
    }
}

class Beast extends Animal {
    public Beast(String type, String name, int age) {
        super(type, name, age);
    }

    @Override
    public void eat(String food) {
        System.out.println("兽类可以吃" + food);
    }
}

class Phoenix extends Birds {
    public Phoenix(String type, String name, int age) {
        super(type, name, age);
    }
}

class Bear extends Beast {
    public Bear(String type, String name, int age) {
        super(type, name, age);
    }
}
