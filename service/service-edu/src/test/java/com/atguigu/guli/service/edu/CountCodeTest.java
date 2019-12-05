package com.atguigu.guli.service.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zsf
 * @create 2019-12-05 10:19
 */
public class CountCodeTest {

    public static void main(String[] args) {
        //指定统计路径
        String path = "E:/Workspace";//路径需同步修改
        System.out.println(path + "路径下.java文件的行数为" + getFile(path));
    }

    public static long getFile(String path) {

        // 1.创建File对象,表示传入的路径的抽象形式
        File file = new File(path);

        // 2.获取该路径下的所有子文件和子文件夹
        File[] files = file.listFiles();

        // 定义一个变量,用来统计行数
        long lineCount = 0;

        // 3.遍历所有子文件和子文件夹的数组
        for (File file1 : files) {
            // 4.判断是否是文件,并且后缀是以.java结尾,如果是,直接打印输出
            if (file1.isFile() && file1.getName().endsWith(".java")) {
                // 统计每一个.java文件的行数  来到了这里,说明拿到了一个.java文件
                BufferedReader br = null;
                try {
                    // 创建字符缓冲输入流对象,封装数据源文件路径
                    br = new BufferedReader(new FileReader(file1));

                    // 循环读取文件行数据
                    String line;
                    while ((line = br.readLine()) != null) {
                        // 每读取一行就计数+1
                        lineCount++;
                    }

                } catch (Exception e) {
                    System.out.println("出现了异常....");
                } finally {
                    // 关闭流,释放资源
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            // 5.判断是否是文件夹,如果是,就递归
            if (file1.isDirectory()) {
                lineCount += getFile(file1.getAbsolutePath());
            }
        }
        return lineCount;

    }

}
