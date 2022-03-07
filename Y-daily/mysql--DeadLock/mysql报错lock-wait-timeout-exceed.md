select max(id) from `tableName`;

int类型最大值，数据库id用完了; 也会出现lock wait timeout exceeded; try restarting transaction;
+------------+
| max(id)    |
+------------+
| 2147483647 |
+------------+
