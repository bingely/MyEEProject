package com.bingley.ee.cookie.example;

import com.bingley.ee.domain.Book;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/5/20.
 */
public class BookDao {
    private static Map<String, Book> bookMap = new LinkedHashMap<>();


    public BookDao() {
    }

    static {
        bookMap.put("1", new Book("1", "三国演义", "99.0", "朴乾", "黑马出版社", "一群男人纠结不清的故事...."));
        bookMap.put("2", new Book("2", "西游记", "10.0", "曹睿", "传智出版社", "一个和尚一个猴子一头猪和一个秃子去西天的故事..."));
        bookMap.put("3", new Book("3", "水浒传", "2.0", "奥巴马", "人民教育出版社", "105个男人和3个女人闯荡江湖的故事"));
        bookMap.put("4", new Book("4", "金瓶梅", "200.0", "哈利波特", "科技出版社", "混乱不堪的故事..."));
    }

    public static Map<String, Book> getBooks() {
        return bookMap;
    }

    public static Book getBook(String id) {
        return bookMap.get(id);
    }

}

