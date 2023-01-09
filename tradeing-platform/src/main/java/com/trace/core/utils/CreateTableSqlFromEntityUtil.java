package com.trace.core.utils;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.StrUtil;


import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * java实体转为数据库建表语句
 * @author fangdy
 * @date 2022-11-25 10:17
 */
public class CreateTableSqlFromEntityUtil {
    public static void main(String[] a) {
        // 实体类的位置
        List<Class> classList = Arrays.asList(
                User.class
        );
        // 生成的sql语句的位置
        String outputPath = "D:\\excel\\user.txt";
        StrBuilder sb = new StrBuilder();
        classList.forEach(x->{
            String sql = generateTableSql(x, null);
            sb.append(sql);
            sb.append("\n");
        });
        writeFile(sb.toString(), outputPath);

        System.out.println("生成结束");
    }

    public static void writeFile(String content, String outputPath) {
        File file = new File(outputPath);
        System.out.println("文件路径: " + file.getAbsolutePath());
        // 输出文件的路径
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter out = null;

        try {
            // 如果文件存在，就删除
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fos = new FileOutputStream(file, true);
            osw = new OutputStreamWriter(fos);
            out = new BufferedWriter(osw);
            out.write(content);
            // 清空缓冲流，把缓冲流里的文本数据写入到目标文件里
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String generateTableSql(Class obj,  String tableName) {
        // tableName 如果是 null，就用类名做表名
        if (tableName == null || tableName.equals("")) {
            tableName = obj.getName();
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
            tableName = StrUtil.toUnderlineCase(tableName);
        }
        // 表名用大写字母
//        tableName = tableName.toUpperCase();

        Field[] fields = obj.getDeclaredFields();

        String column;

        StringBuilder sb = new StringBuilder();

        sb.append("drop table if exists ").append(tableName).append(";\r\n");

        sb.append("\r\n");

        sb.append("create table ").append(tableName).append("(\r\n");

        System.out.println(tableName);


        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];

            column = f.getName();

            Class<?> type = f.getType();
            System.out.println(column + ", " + type.getSimpleName());
            String typeName = type.getTypeName();
            sb.append( StrUtil.toUnderlineCase(column)); // 一般第一个是主键

            if (typeName.equals("java.lang.Integer")) {
                sb.append(" int(11) ");
            } else if (typeName.equals("java.lang.Long")) {
                sb.append(" bigint(20) ");
            } else if (typeName.equals("java.lang.Float")) {
                sb.append(" float(11,5) ");
            } else if (typeName.equals("java.time.LocalDate")) {
                sb.append(" date ");
            } else if (typeName.equals("java.time.LocalDateTime") || typeName.equals("java.util.Date")) {
                sb.append(" datetime ");
            } else {
                // 注意：根据需要，自行修改 varchar 的长度。这里设定为长度等于 50
                sb.append(" varchar(" + 50 + ") " );
            }
            if (column.equals("id")){
                if (StrUtil.equalsAny(tableName,"java.lang.Integer","java.lang.Long")){
                    sb.append(" not null AUTO_INCREMENT ");
                }else {
                    sb.append(" not null ");
                }
            }
            // todo 增加对字段的注解的处理
            sb.append(", ");

            sb.append("\n");
        }
        sb.append(" PRIMARY KEY (`id`) USING BTREE");
        String sql = sb.toString();

        sql = sb.substring(0, sql.length()) + "\n) " + "ENGINE = INNODB DEFAULT CHARSET = utf8mb4;";
        return sql;
    }
}


class User{
    private String id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

