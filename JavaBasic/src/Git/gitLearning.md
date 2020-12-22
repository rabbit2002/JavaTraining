# Git

## Git 使用

### 初始化本地仓库

``` sh
git init
```

### 添加至缓冲区

``` sh
git add *
```

### 提交

``` sh
git commit -m "注释"
```

### 克隆远程仓库

``` sh
git clone 地址
```

### 添加远程仓库地址

``` sh
git remote add 名称 远程仓库地址
```

### 删除远程仓库地址

### 查看远程仓库地址

``` sh
git config --list
```

### 推送远程仓库

``` sh
git push 地址别名 分支
```

### 拉取远程仓库

``` sh
git pull 地址别名 分支
```

### 生成/添加SSH公钥

https://gitee.com/help/articles/4181

### 添加公钥:

https://gitee.com/profile/sshkeys

### 命令行使用

#### 全局设置(针对所有仓库)

``` sh
git config --global user.email "example@example.com"
git config --global user.name "Example Name"
```

#### 局部设置(针对当前仓库 )

``` sh
git config --local user.email "example@example.com"
git config --local user.name "Example Name"
```

#### 列出当前仓库配置

``` sh
git config --list
```

### GUI使用

## 在线 Git 代码托管平台

### [Gitee.com](https://gitee.com) 使用

### [GitHub](https://github.com) 使用

## 相关学习资源

1. [Git教程 - 廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/896043488029600)
2. [Git 教程 | 菜鸟教程](https://www.runoob.com/git/git-tutorial.html)
3. [Git 大全 - Gitee.com](https://gitee.com/all-about-git)
4. [Gitee 帮助中心 - Gitee.com](https://gitee.com/help)
6. [GitHub Documentation](https://docs.github.com/cn)
7. [Learn Git Branching](https://oschina.gitee.io/learn-git-branching/)

# TODO

- [ ] 待完善本节/Github
- [ ] 补充前4章节
- [ ] 复习Markdown语法
- [ ] Javadoc → markdown
- [ ] 重构结构 按章节 → 按模块
    - [ ] Introduction to Java
        - [ ] Data Types
            - [ ] 基本类型
                - [ ] 类型
                - [ ] 大小/字节
                - [ ] 表示范围
            - [ ] 引用类型
        - [ ] Operators
            - [ ] 基本运算符
            - [ ] 专用运算符
        - [ ] Control Statements
            - [ ] 程序结构
        - [ ] Arrays
            - [ ] 概念
            - [ ] 排序
            - [ ] 查找
            - [ ] 复制
        - [ ] Classes and Objects
            - [ ] 类
            - [ ] 实例化
            - [ ] 对象
        - [ ] Methods
            - [ ] 声明
            - [ ] 成员方法
            - [ ] 参数传递
                - [ ] 值传递
                - [ ] 引用传递
            - [ ] 返回类型
            - [ ] Overload
            - [ ] recursion
            - [ ] 可变长参数
        - [ ] Constructor
        - [ ] Encapsulation
            - [ ] package
                - [ ] run in terminal
            - [ ] Modifiers
            - [ ] Access Modifiers
            - [ ] Encapsulation
            - [ ] this
        - [ ] Inheritance
            - [ ] 概念
            - [ ] 实现
            - [ ] 特点
            - [ ] 构造
            - [ ] super
            - [ ] this
        - [ ] Class Object
            - [ ] 作用
            - [ ] 字段
            - [ ] 方法
            - [ ] 构造
            - [ ] override
            - [ ] 类型类
        - [ ] Polymorphism
            - [ ] 概念
            - [ ] 分类
            - [ ] 实现
            - [ ] 转换
        - [ ] Abstract Class
            - [ ] 概念
            - [ ] 抽象方法
            - [ ] 意义
            - [ ] 声明
            - [ ] 特点
        - [ ] Wrapper Class
            - [ ] 不变模式
            - [ ] 工厂模式
            - [ ] 包装类
            - [ ] 常用方法
            - [ ] 装箱/拆箱
        - [ ] Interfaces
            - [ ] 概念
            - [ ] 实现
            - [ ] 特点
            - [ ] 抽象类与接口的区别
        - [ ] CharSequence
            - [ ] java.lang.CharSequence
            - [ ] java.nio.charset.Charset
            - [ ] java.lang.String
            - [ ] java.lang.AbstractStringBuilder
            - [ ] java.lang.StringBuffer
            - [ ] java.lang.StringBuilder
        - [ ] Comparing Objects
            - [ ] java.lang.Comparable<T>
            - [ ] java.util.Comparator<T>
            - [ ] java.util.Arrays
        - [ ] Date and Time
            - [ ] java.util.Date
            - [ ] java.util.Calendar
            - [ ] java.text.DateFormat
        - [ ] Inner Classes
            - [ ] Static Nested Class
            - [ ] Inner Class
                - [ ] Member inner class
                - [ ] Local inner class
                - [ ] Anonymous inner class
        - [ ] Enumeration
            - [ ] 单例模式
            - [ ] 多例模式
            - [ ] 枚举
            - [ ] java.lang.Enum
        - [ ] Collection Framework
            - [ ] java.lang.Iterable<E>
            - [ ] java.util.Iterator<E>
            - [ ] java.util.Map<K,V>
            - [ ] java.util.Collections
        - [ ] Exception Handling
            - [ ] 概念
            - [ ] 处理机制
                - [ ] 捕获
                - [ ] 抛出
            - [ ] 异常体系
            - [ ] 异常分类
            - [ ] 自定义异常

- [ ] 完善数据结构仓库
    - [ ] 重建项目结构为module
    - [ ] 补充题目说明注释
  