cubeAna
======

分析摄像头拍摄晶格阵列

整个项目是将文件以8进制的方式读取，并分别用多个8色晶格阵列显示，每个晶格的颜色表示一个位，通过摄像头识别阵列并还原为原文件。

这里是对图片识别的部分，就是自动读取一张图片并获得其记录的数据
图片示例见demo.png，摄像头拍摄的图片情况

主要的方法

- 确定第一个晶格的位置
从左上角向右下角遍历，当遇到可识别的颜色，则分别向左向上识别，直到颜色均无法识别位置，即可确定第一个晶格的左上角，其它3个位置和中点同理

- 颜色适应
因为图片为摄像头拍摄，可能颜色与标准颜色有偏差，开始时应该拿一张包括8种颜色和背景灰色的表格让程序识别出当前环境下各个颜色的RGB值(为了方便观察，9种颜色的RGB分别放在\src\color目录下，txt保存)

- 读取/输出信息
读取出图片晶格颜色，并输出

没怎么整理好，代码有点乱