## 训练题-Object <b style="font-size:20px;">( Java语言 )</b>


### 求面积


#### 1、定义 Shape 类

定义一个 名称为 Shape 的类，充当各种图形类的父类，其中:

- 包含一个用于记录面积数值的实例变量

```java
protected double area ; // 为了让子类能够访问 area 变量，这里修饰符为 protected
```


- 包含一个用于表示当前图形类型的实例变量

```java
private String type ; // 创建子类对象时通过调用父类构造方法设置图形种类
```

一个图形一经创建，其类型(type)不允许修改，因此该 字段被设计为 private 修饰。


- 包含一个带有参数的构造方法

```java
public Shape( String type ){
    this.type = type ;
}
```

子类可以通过调用父类的构造方法来确定其形状种类。


- 包含一个用于统计当前图形面积的方法

```java
public void calculate() {
    System.out.println( "计算" + this.type + "的面积" );
    // 父类 Shape 的 calculate 中仅仅包含一条输出语句，没有任何计算过程
}
```


- 重写`toString`方法用于返回图形种类和面积等信息

```java
public String toString(){
    return this.type + "的面积为" + this.area ;
}
```


#### 2、定义 Trapezoid 类

定义一个 Trapezoid 类，它继承了 Shape 类:

```java
public class Trapezoid extends Shape {
    
}
```

因为父类中没有无参构造，因此需要在 Trapezoid 类中调用父类的有参构造，请自行设计
Trapezoid 类的构造。

```java
public Trapezoid(){
    // 直接在 Trapezoid 类中书写无参构造是无法编译的，你需要解决这个编译错误
}
```

根据梯形面积计算公式，我们需要在 Trapezoid 类中声明:

- 上底

```java
private double top ;
```

- 下底

```java
private double bottom ;
```

- 高

```java
private double height ;
```

随后，建议通过构造方法直接初始化梯形的上底、下底、高:

```java
public Trapezoid( double top , double bottom , double height ){
    // 直接在 Trapezoid 类中书写该构造方法是无法编译的，你需要解决这个编译错误
}
```

然后，在 Trapezoid 类中重写 calculate 方法并在其中计算当前梯形的面积:

```java
public void calculate() {
  	// 首先调用从父类中继承的、可见的 calculate 方法
    // 然后在这里计算梯形的面积，并将面积存储到 area 变量中 ( 实例变量 area 是从父类继承来的 )
}
```

最后，在 Trapezoid
类中重写`toString`方法用于输出梯形的信息并通过调用父类的`toString`方法输出图形面积:

```java
public String toString() {
    // 先在这里将梯形基本信息(比如 上底、下底、高 等信息)连接成字符串
    // 最后通过调用父类的 toString 方法将 梯形基本信息 和 面积信息予以拼接成字符串后返回
}
```


#### 3、定义 Sector 类


参照 Trapezoid 类的实现过程，按以下要求完成 Sector 类:

- Sector 继承 Shape 类
- Sector 类中有一个表示 圆半径 的 实例变量 ( radius )
- Sector 类中有一个表示 扇形弧长 的 实例变量 ( arcLength )
  - 或者可以在 Sector 类中定义 圆心角的角度 ( degree )
- Sector 类中有一个带参数的构造方法
  - 通过构造方法的参数用来初始化 radius 和 arcLength ( 或 degree )
- Sector 类的构造方法中需要调用父类有参构造设置其类型 ( 将 type 设置为 "扇形"
  即可 )
- 在 Sector 中重写 calculate 方法计算扇形的面积

- 在 Sector 中重写 toString()方法返回扇形信息(比如半径、弧长/角度
  等)和扇形面积


#### 4、测试程序


定义一个 ShapeTest 类，并在其中定义 main 方法，其中包含以下内容

```java
Trapezoid t = new Trapezoid( 30 , 40 , 50 ); // 创建 Trapezoid 实例
t.calculate() ; // 计算梯形面积
System.out.println( t ); // 输出梯形信息和梯形面积

Sector s = new Sector( 5 );
s.calculate() ; // 计算扇形面积
System.out.println( t ); // 输出扇形信息和扇形面积
```


#### 5、hashCode


设某个类中存在以下字段:

```java
    private String name ;
    private int age ;
    private char gender ;
```


在 使用 IDEA 或 Eclipse 等工具创建 equals 和 hashCode
方法时，可能会生成以下代码:

```java
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (int) gender;
        return result;
    }
```


**为什么在 hashCode 方法内部使用 31 ? **


