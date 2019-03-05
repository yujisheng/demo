package com.yjs.conf;

public class DynamicDataSourceHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSource(String dataSourceName) {
        holder.set(dataSourceName);
    }

    public static String getDataSource() {
        return holder.get();
    }
}
