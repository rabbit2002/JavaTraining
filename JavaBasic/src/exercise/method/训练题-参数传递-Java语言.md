## 训练题-参数传递 <b style="font-size:20px;">( Java语言 )</b>


### 1、遍历数组

定义一个名称为 Sorter 的类:

```java
public class Sorter {
}
```

在 Sorter 类中声明一个用来遍历任意一维int数组的方法:

```java
public void traversal( int[] array ){
}
```

该方法需要考虑:

- array 是否为 null
- array 是否是个空数组 ( 即长度为零 )
- 在同一行输出 array 数组中的各个元素，相邻元素之间使用 逗号 隔开
  (末尾不要有逗号)


### 2、排序数组

为了实现对任意一维 int 数组进行排序，需要在Sorter 类中增加一个名称为 sort
的方法:

```java
public void sort( int[] array ) {
}
```

在 sort 方法内部，将目标数组 array 中的所有元素按照从大到小的顺序排列。

在完成以上 sort 方法后，即可采用以下代码予以测试:

```java
Sorter sorter = new Sorter();

int[] a = { 1 , 100 , -20 , 99 , 1000 , 0 , 30 };
System.out.print( "排序前 : " );
sorter.traversal( a ); // 排序前 : 1 , 100 , -20 , 99 , 1000 , 0 , 30

sorter.sort( a ) ;
System.out.print( "排序后 : " );
sorter.traversal( x ); // 排序后 : -20 , 0 , 1 , 30 , 99 , 100 , 1000
```


