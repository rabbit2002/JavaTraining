/**
 * 类的组成
 * <p>
 * The Java® Language Specification
 * 8.1.6 Class Body and Member Declarations 类的主体和成员声明
 * ClassBody:                   // 类主体:
 * { {ClassBodyDeclaration} }   // 类主体声明
 * <p>
 * ClassBodyDeclaration:        // 类主体声明:
 * ClassMemberDeclaration       // 类成员声明
 * InstanceInitializer          // 实例初始化器
 * StaticInitializer            // 类初始化器
 * ConstructorDeclaration       // 构造函数声明
 * <p>
 * ClassMemberDeclaration:      // 类成员声明:
 * FieldDeclaration             // 字段声明
 * MethodDeclaration            // 方法声明
 * ClassDeclaration             // 类声明: 成员类 (枚举 Enum 是特殊的类)
 * InterfaceDeclaration         // 接口声明: 成员接口 (注解 Annotation 是特殊的接口)
 * ;
 * <p>
 * The Java® Language Specification
 * 8.1.3 Inner Classes and Enclosing Instances 内部类和封闭实例
 * 嵌套类(Nested Class)共有两种:
 * 1. 静态成员类(Static Member Class)
 * 2. 内部类(Inner Class):
 * 2.1. 非静态成员类(Non-static Member Class)
 * 2.2. 局部类(Local Class)
 * 2.3. 匿名类(Anonymous Class)
 * 注意: 匿名类 属于 局部类, 二者均不属于 成员类 !!!
 * <p>
 * <p>
 * 字节码命名规则:
 * 宿主类: 宿主类名.class
 * 成员类:
 * . 静态成员类: 宿主类名$静态成员类名.class
 * . 非静态成员类：宿主类名$成员类名.class
 * . 局部类: 宿主类名$1局部类名.class
 * . 匿名类: 宿主类名$1.class
 * 成员接口: 宿主类名$接口名.class
 * <p>
 * 声明及实例化
 * 对于 成员接口 和 成员类, 声明 引用变量类型 时, 使用 "宿主类.成员类"
 * 对于 成员接口 和 静态成员类, 创建实例 时, 使用 "new 宿主类.成员接口/静态成员类()"
 * ClassesConstitution.Interface anInterface =new ClassesConstitution.Interface() {};
 * ClassesConstitution.StaticMemberClass staticMemberClass =new ClassesConstitution.StaticMemberClass();
 * 对于 非静态成员类, 创建实例时, 使用 "new 宿主类().new 非静态成员类()",
 * 即: 先创建宿主类, 在创建非静态成员类
 * ClassesConstitution.MemberClass memberClass =new ClassesConstitution().new MemberClass();
 * <p>
 * 在 嵌套类中 访问 宿主类变量:
 * 在 静态成员类中,
 * 只能访问 宿主类的静态成员, 通过 宿主类名.静态成员 访问
 * 在 内部类中,
 * 访问 宿主类的静态成员, 通过 宿主类名.静态成员 访问
 * 访问 宿主类的实例成员, 通过宿主类名.this.实例成员 访问
 * <p>
 * 注意: 在 局部类 中(局部类 和 匿名类), 在使用 实例属性 或者 类属性 时均没有问题, 但对于 临时变量 则会被 隐式final修饰
 * <p>
 * <p>
 * // TODO 应该要迁移
 * 初始化调用顺序
 * 1. 对于类成员
 * 初始化 类变量 为默认值 -> 赋值 -> 调用 类初始化器
 * 2. 对于实例成员
 * 类成员初始化 -> 初始化 实例变量 为默认值 -> 赋值 -> 调用实例初始化器 -> 调用构造函数
 * <p>
 * 初始化规则
 * 类初始化器: 仅当类首次 被主动使用时, 完成类初始化, 此时执行类初始化 (仅调用一次)
 * 注意: 声明 某个类的类型的引用变量 属于对类的被动使用, 不会导致该类被初始化
 * 调用 某个类的 类成员 或 类方法 属于对类的主动使用, 会导致类被初始化
 * 实例初始化器: 每当 类的实例 被创建时, 实例初始化 都会执行 (每次都会调用)
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class ClassesConstitution {

    // 类成员声明

    // 字段声明
    static int anStaticInt = 10;
    int anInt;

    // 方法声明
    static void funcStatic() {
    }

    void func() {}

    // 类声明
    // 静态成员类
    static class StaticMemberClass {
        static int anStaticInt = 10;
    }

    // 非静态成员类
    class MemberClass {
        int x = 0;
    }

    void funcX() {
        // 在局部类中使用时, 临时变量会被隐式final修饰
        int tempInt = 10;
        // 局部类
        class LocalClass {
            public void func() {
                // 类属性
                System.out.println(anStaticInt++);
                // 实例属性
                System.out.println(anInt);
                // 其他的属性等
                System.out.println(StaticMemberClass.anStaticInt++);

                // 临时变量
                System.out.println(tempInt);
                // Variable 'tempInt' is accessed from within inner class, needs to be final or effectively final
                // tempInt++;
            }
        }

        // 匿名类
        new Object() {
        };
    }

    // 接口声明
    interface Interface {
    }

    //////////

    // 实例初始化器
    {
    }

    // 类初始化器
    static {
    }

    // 构造函数声明
    public ClassesConstitution() {
        ClassesConstitution.Interface anInterface = new ClassesConstitution.Interface() {};
        ClassesConstitution.StaticMemberClass staticMemberClass = new ClassesConstitution.StaticMemberClass();
        ClassesConstitution.MemberClass memberClass = new ClassesConstitution().new MemberClass();
    }
}
