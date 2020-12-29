## 训练题-多态 <b style="font-size:20px;">( Java语言 )</b>



### 1、定义 Animal 类

定义一个用来表示动物的类:

```java
public class Animal {
    
    private final String type ; // 某个个体对应的动物种类
    protected String name ; // 某个个体的名称
    protected int age ; // 某个个体的年龄
    
    public Animal( String type ) {
        this.type = type ;
    }
    
    public Animal( String type ， int age ) {
        this.type = type ;
        this.age = age ;
    }
    
    public void eat( String food ) {
        System.out.println( "动物可以吃" + food );
    }
    
    @Override
    public String toString(){
        // 返回 Animal 对象的字符串形式
    }
    
} 
```



### 2、定义 Birds 类

按照以下要求定义 Birds 类:

- 继承 Animal 类
- 在Birds类的构造方法中调用父类构造时，需要为父类中的 type指定为 "禽类"
- 重写从 Animal 类中继承的 eat(String) 方法，在其中输出禽类吃食物的方式



### 3、定义 Beast类

按照以下要求定义 Beast 类:

- 继承 Beast 类
- 在Beast类的构造方法中调用父类构造时，需要为父类中的 type指定为 "兽类"
- 重写从 Animal 类中继承的 eat(String) 方法，在其中输出兽类吃食物的方式



### 4、定义禽兽子类



#### 4.1、定义禽类子类

为Birds类定义以下子类:

- `Phoenix`
- `Eagle`

不必再重写从父类继承的 eat 和 toString 方法，只需要解决调用父类构造方法的问题。



#### 4.2、定义兽类子类

为Beast类定义以下子类:

- `Bear`
- `Lion`

不必再重写从父类继承的 eat 和 toString 方法，只需要解决调用父类构造方法的问题。



### 5、测试多态



定义一个 AnimalTest 类，并在其中定义 main 方法，其中包含以下内容:

```java
Animal a = null ;
a = enw Phoenix( ........ );
System.out.println( a.toString() );
a.eat( ..... );

a = enw Eagle( ........ );
System.out.println( a.toString() );
a.eat( ..... );

a = enw Bear( ........ );
System.out.println( a.toString() );
a.eat( ..... );

a = enw Lion( ........ );
System.out.println( a.toString() );
a.eat( ..... );
```



### 6、排序

定义一个 SortAnimalTest 类，并在其中定义 main 方法，其中包含以下内容:

```java
Animal[] animals = new Animal[ 10 ] ; 

animals[ 0 ] = enw Eagle( ........ );
...... // 在 animals 数组中放入不同的动物

// 在这里遍历 animals 数组，输出其中所包含的动物们的信息(排序前)
    
// 在这里通过冒泡方式完成对animals数组的排序，要求按照动物们的age从小到大排列

// 在这里遍历 animals 数组，输出其中所包含的动物们的信息(排序后)
```





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





