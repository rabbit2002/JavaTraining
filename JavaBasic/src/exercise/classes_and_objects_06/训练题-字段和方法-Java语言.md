## 训练题-字段和方法( Java语言 )


### 1、摇钱树

定义一个 CashCow 类，并在其中定义以下 私有 ( private ) 字段 ( 即字段的修饰符是
private )

- height 表示摇钱树的高度，采用 int 即可
- goldPiece 表示金币数量，采用 int 类型即可
- wormy 表示摇钱树上是否有虫子，采用 boolean 类型即可 ( true 表示有虫子
  、false 表示没有虫子 )
- pesticide 表示杀虫剂数量，采用 int 类型即可


在 CashCow 类中添加以下方法:

- 成长

```java
public void grow() {
    // 方法执行一次，摇钱树成长一次，高度增加 2 ，金币数量增加 10
}
```


- 购买杀虫剂

```java
public void buy() {
    // 当有金币时，从树上采摘金币购买农药
    // 每购买一次农药，金币减少 1 个，杀虫剂增加 100
}
```


- 杀虫

```java
public void kill() {
    // 当有虫子时，执行杀虫操作
    // 每执行一次杀虫操作，杀虫剂减少 50 ， 金币增加 5 个
}
```


- 浇水

```java
public void watering() {
    // 每次浇水，金币数量增加 5 个，高度增加 1
    // 每次浇水都会导致虫子增加 ( 即 wormy 变为 true )
}
```


- 查询状态

```java
public void show() {
    // 通过 show 方法显示 摇钱树的高度 、摇钱树上的金币数量 、是否用虫子 、杀虫剂数量
}
```


### 2、测试

定义一个 CashCowTest 类，并在其中添加 main 方法:

```java
import java.util.Random ;

public class CashCowTest {
    
    public static void main(String[] args) {
        // 创建一个随机数生成器
        Random random = new Random();
        // 创建摇钱树实例(该实例内部包含4个字段)
        ExerciseCashCow cc = new ExerciseCashCow();

        for (int i = 0; i < 10; i++) {
            // 随机产生一个 [ 0 , 4 ) 之间的整数,除了 show 仅有 4 个操作
            int x = random.nextInt(4);
            switch (x) {
                case 0:
                    cc.grow();
                    break;
                case 1:
                    cc.buy();
                    break;
                case 2:
                    cc.kill();
                    break;
                case 3:
                    cc.watering();
                    break;
            }
        }
        cc.show(); // 查询状态
    }
    
}
```


