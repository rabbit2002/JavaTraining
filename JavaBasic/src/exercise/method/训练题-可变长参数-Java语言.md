## 训练题-可变长参数 <b style="font-size:20px;">( Java语言 )</b>

定义一个 `MathHelper` 类，用于辅助完成与数学运算有关的操作。

```java
public MathHelper {
}
```

### 1、获取实例

定义一个类方法，用于获取 `MathHelper` 类的实例:

```java
public static MathHelper getInstance(){

}
```

### 2、求最大值

定义一组相互重载的方法，用于求参数中的最大值。

比如对于一组整型数值来说，可以使用:

```java
public long max( long first , long... values ) {
    // 找出参数中的最大值并返回
}
```

比如对于一组浮点型数值来说，可以使用:

```java
public double max( double first , double... values ) {
    // 找出参数中的最大值并返回
}
```

### 3、求最小值

定义一组相互重载的方法，用于求参数中的最小值。

比如对于一组整型数值来说，可以使用:

```java
public long min( long first , long... values ) {
    // 找出参数中的最小值并返回
}
```

比如对于一组浮点型数值来说，可以使用:

```java
public double min( double first , double... values ) {
    // 找出参数中的最小值并返回
}
```

### 4、测试

编写一个 `MathHelperTest` 类并在该类的 main 方法中测试以上方法:

```java
public class MathHelperTest {
    
	public static void main( String[] args ) {
        
        MathHelper mh = MathHelper.getInstance();
        
        long n = 99L ;
        short s = 77 ;
        byte b = 66 ;
        char c = 'x' ;
        long x = mh.max( n , s , b , c ) ;
        System.out.println( x );
        
        // 其它方法请自行测试
    }
    
}
```

