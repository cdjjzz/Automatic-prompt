# Automatic-prompt
对单词进行提供提示功能，现在只有动态规划的实现。

例如模版里有java，输入j,J,JA,ja等都是可以提示到java的。模版事先需要导入

```java
  TaskPool.getInstance().setDic(dics);
```
调用代码如下

```java
String matchString = TaskPool.getInstance().matchString(textField.getText());
```



特点如下：

1. 字符匹配不区分大小写
2. 支持部分匹配，要求命中率得在50%以上，例如模版里有java.lang.String。可以使用jsb，jbs匹配到，但是sb就不能了。认为输入时可能会出现手误，所以也可以匹配。但是手误不能超过50%