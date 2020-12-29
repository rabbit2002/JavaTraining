## 训练题-封装 <b style="font-size:20px;">( Java语言 )</b>



### 1、Decimal



#### 1.1、套娃

创建一个 Decimal 类，其实例用来表示十进制**整数**:

```java
public class Decimal {

    // 声明一个用来保存整数的字段
    private final long value ; // 注意这里封装的是 long 类型的数值

    // 声明一个可以接受单个整数值的构造方法
    public Decimal( long value ) {
        this.value = value ;
    }

}
```



#### 1.2、二进制

在 Decimal 类声明一个名称为 toBinaryString 的**实例方法**:

```java
    public String toBinaryString () {
        
    }
```

该方法用于将当前Decimal实例中封装的十进制整数，转换为 **二进制形式**。

比如:

```java
	Decimal d = new Decimal( 9 );
	String s = d.toBinaryString();
	System.out.println( s );
```

最后一行的输出结果为 `00000000000000000000000000001001` 。



> 需要自己实现 十进制 整数 转 二进制形式的完整过程，不能直接使用 Java 提供的包装类中的方法。



#### 1.3、十六进制

在 Decimal 类声明一个名称为 toHexString 的**实例方法**:

```java
    public String toHexString () {
        
    }
```

该方法用于将当前Decimal实例中封装的十进制整数，转换为 **二进制形式**。

比如:

```java
	Decimal d = new Decimal( 2147483647 );
	String s = d.toHexString();
	System.out.println( s );
```

最后一行的输出结果为 `7FFFFFFF` 。

> 需要自己实现 十进制 整数 转 二进制形式的完整过程，不能直接使用 Java 提供的包装类中的方法。