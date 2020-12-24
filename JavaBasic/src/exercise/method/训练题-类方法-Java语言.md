## 训练题-类方法 <b style="font-size:20px;">( Java语言 )</b>

### 中国纪年

#### 1、定义 Chronology 类

- 定义一个 Chronology 类，用来表示中国纪年法，其中包括以下字段:

```java
// private 表示私有的
private static final char[] HEAVENLY_STEMS ; // 天干
// static 表示与类相关的、属于类的
private static final char[] EARTHLY_BRANCHES ; // 地支
// final 表示最终的、不可更改的
private static final char[] CHINESE_ZODIAC ; // 生肖
```

- 可以在 Chronology 类中通过 **类初始化器** 对这些字段进行初始化:

```java
  HEAVENLY_STEMS = { '甲' , '乙' , '丙' , '丁' , '戊' , '己' , '庚' , '辛' , '壬' , '癸' };
  EARTHLY_BRANCHES = { '子' , '丑' , '寅' , '卯' , '辰' , '巳' ,  '午' , '未' , '申' , '酉' , '戌' , '亥' };
  CHINESE_ZODIAC = { '鼠','牛','虎','兔','龙','蛇','马','羊','猴','鸡','狗','猪' } ;
```

#### 2、输出六十甲子名称

在 Chronology 类中定义一个 show 方法，用于输出一甲子中六十年每年的名称:

```java
public static void show(){
    
}
```

> 要求每行输出12个，总共输出 5 行

在中国古代的纪年法中，采用天干和地支相组合的方式来表示一个年份，其组合规则为:

```
甲子、乙丑、丙寅、丁卯、戊辰、......、壬申、癸酉、甲戌、乙亥、丙子、丁丑、戊寅、...... 、壬戌、癸亥
```

其中 `甲子` 是第一个组合，也是一个甲子六十年的开始。

十天干与十二地支按顺序两两相配，从甲子到癸亥，共六十个组合，称六十甲子。(
60年一个循环 )


#### 3、求任意年份的名称

- 在 Chronology 类中定义一个参照年份，比如 1984 年 ( 甲子年 ，生肖为 鼠 )

```java
private static final int CONTRAST = 1984 ; // 参照年份
```

- 以参照年份为基础，定义 seek 方法，用以获取任意给定年份对应的名称

```java
public static String seek( int year ) {
    
}
```

比如：

```java
String name = Chronology.seek( 1985 );
System.out.println( name ) ; // 输出 乙丑
```


#### 4、求任意年份对应的生肖

承上题，以 指定参照年份 ( `CONTRAST` ) 为参照，定义 sign
方法，用以获取任意给定年份对应的生肖

```java
public static char sign( int year ) {
    
}
```

比如：

```java
char s = Chronology.sign( 1996 );
System.out.println( s ) ; // 输出 鼠
```

