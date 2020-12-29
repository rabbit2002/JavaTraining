## 训练题-类继承 <b style="font-size:20px;">( Java语言 )</b>



### 7、求面积



#### 7.1、定义 Shape 类

定义一个 名称为 Shape 的类，充当各种图形类的父类，其中:

- 包含一个用于记录面积数值的实例变量

```java
protected double area ; // 为了让子类能够访问 area 变量，这里修饰符为 protected
```



- 包含一个用于表示当前图形类型的实例变量

```java
protected String type ; // 为了让子类能够访问 area 变量，这里修饰符为 protected
```

可以在子类的实例代码块中或构造方法中直接指定图形种类，比如: `this.type = "三角形"`。

在创建某种图形的实例后，不必再单独为 type 字段赋值。



- 包含一个用于输出图形面积的方法

```java
public void show(){
    // 在 Shape 类中 show 方法除了输出语句外，没有任何其它代码
    System.out.println( this.type + "的面积为" + this.area );
}
```





#### 7.2、定义 Triangle 类

定义一个 Triangle  类，它继承了 Shape 类:

```java
public class Triangle extends Shape {
    
}
```

在子类构造中可以直接为 type 赋值:

```java
public Triangle(){
    // 可以在这里完成对 type 的初始化
}
```

为了能够根据三角形的三边来计算三角形面积，需要在 Triangle  类中声明三角形的三条边:

```java
protected double firstEdge ;
protected double secondEdge ;
protected double thirdEdge ;
```

为 Triangle 类增加 calculate 方法并在其中计算当前三角形的面积

```java
public void calculate() {
    // 在这里计算三角形的面积，并将面积存储到 area 变量中 ( area 是从父类继承的、可见的实例变量 )
}
```

最后，为 Triangle 类增加 description 方法，输出三角形的信息并通过调用父类的show方法输出图形面积:

```java
public void description() {
    // 在这里输出三角形基本信息(比如三边的长度)
    // 最后通过调用从父类继承的、可见的 show 方法输出 三角形的面积
}
```



#### 7.3、定义 Circle 类



参照  Triangle  类的实现过程，按以下要求完成 Circle 类:

- Circle 继承 Shape 类
- Circle 类中有一个表示 圆半径的 实例变量 ( radius )
  - 半径 ( radius ) 是 Circle 中重新声明的实例变量
- Circle 类的构造方法中需要设置图形类型 
  - 将 从父类继承的、可见的实例变量 type 的值设置为 "圆" 即可
- 为 Circle 类增加 calculate 方法并在其中计算圆的面积
  - 使用 Math.pow( radius , 2 ) 可以求 半径的平方 ( 返回值是 double 类型 )
  - 使用 Math.sqrt( x ) 实现开方运算 ( 返回值是 double 类型 )
- 为 Circle 类增加 description 方法并在其中输出圆的半径和圆面积
  - 圆的半径可以在 description 直接输出
  - 圆的面积可以通过调用从父类继承的、可见的 show 方法来实现



#### 7.4、测试程序



定义一个 ShapeTest 类，并在其中定义 main 方法，其中包含以下内容

```java
Triangle t = new Triangle(); // 创建 Triangle 实例
t.firstEdge = 44 ; // 设置边长
t.secondEdge = 49 ; // 设置边长
t.thirdEdge = 52 ; // 设置边长
t.calculate() ; // 计算三角形面积
t.description(); // 输出三角形信息和三角形面积

Circle c = new Circle();
c.radius = 8 ; // 设置半径
c.calculate() ; // 计算圆面积
c.description(); // 输出圆半径和圆面积
```





