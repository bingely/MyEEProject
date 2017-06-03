package com.bingley.ee.topic.sql.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyResultSetHandler<T> {
	T handle(ResultSet rs) throws SQLException;
}
