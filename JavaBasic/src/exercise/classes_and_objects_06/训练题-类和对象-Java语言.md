# 训练题-类和对象 <b style="font-size:20px;">( Java语言 )</b>


## 1、求三角形面积


定义一个名称为 Triangle
的类用来表示任意三角形，其中采用三个字段来描述三角形三边的长度:

- firstEdge
- secondEdge
- thirdEdge

要求在 Triangle 类中定义一个名称为 squaring 的方法来计算该三角形的面积。


将 Triangle 类开发好后，直接在 Triangle 类中通过 main 方法来测试:

```java
Triangle t = new Triangle();
t.firstEdge = 30;
t.secondEdge = 40;
t.thirdEdge = 50;
// 计算面积并在控制台输出面积
t.squaring(); 
```


>  在设置 三角形三边的长度时，必须保证 其中一边之长 小于 另外两边长度之和。


## 2、求圆柱体的表面积和体积


定义一个名称为 Cylinder 的类用来表示任意圆柱体，其中包含两个字段:

- radius 表示圆柱体底面的半径
- height 表示圆柱体的高度

要求在 Cylinder 类中增加以下方法并实现相应功能

- squaring 方法用于计算圆柱体的表面积
- cube 方法用于计算圆柱体的体积


将 Cylinder 类开发好后，通过以下程序来测试:

```java
Cylinder  c = new Cylinder();
c.radius = 20;
c.height = 20;
// 计算圆柱体表面积并在控制台输出面积
c.squaring();        
// 计算圆柱体体积并在控制台输出体积
c.cube();
```


