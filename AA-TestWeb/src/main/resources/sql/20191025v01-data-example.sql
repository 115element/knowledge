
-- 菜单及相关表测试数据初始化
-- 主键序列：2000000, table: ctr_product_category
-- 主键序列：2100000, table: ctr_product
-- 主键序列：2300000, table: ctr_commodity
-- 主键序列：2400000, table: ctr_material
-- 主键序列：2500000, table: ctr_commodity_material
-- 主键序列：2600000, table: ctr_product_choice
-- 主键序列：2700000, table: ctr_product_option
-- --------
-- 主键序列：2800000， table ctr_store
-- 主键序列：3100000， table ctr_scenario
-- 主键序列：4000000， table ctr_scenario_region
-- 主键序列：3200000， table ctr_scenario_store
-- 主键序列：3300000， table ctr_proposal
-- 主键序列：3500000， table ctr_proposal_commodity
-- 主键序列：3600000， table ctr_proposal_option
-- 主键序列：3700000， table ctr_scenario_menu
-- 主键序列：3800000， table ctr_proposal_menu
-- 主键序列：3900000， ctr_proposal_bundle

TRUNCATE TABLE `ctr_product_category`;
INSERT INTO `ctr_product_category`(`id`,`parent_id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`)
VALUES(2000001, 0, now(), now(), '1000-01-01', 0, '卷饼类', 3020102),
      (2000002, 0, now(), now(), '1000-01-01', 0, '蛋饼', 3020102),
      (2000003, 0, now(), now(), '1000-01-01', 0, '早点', 3020102),
      (2000004, 0, now(), now(), '1000-01-01', 0, '粥', 3020102),
      (2000005, 0, now(), now(), '1000-01-01', 0, '热饮', 3020102),
      (2000006, 0, now(), now(), '1000-01-01', 0, '饭', 3020102),
      (2000007, 0, now(), now(), '1000-01-01', 0, '汤', 3020102),
      (2000008, 0, now(), now(), '1000-01-01', 0, '小食', 3020102),
      (2000009, 0, now(), now(), '1000-01-01', 0, '冷饮（奶盖茶）', 3020102),
      (2000010, 0, now(), now(), '1000-01-01', 0, '冷饮（气泡水）' ,3020102)
;

TRUNCATE TABLE `ctr_product`;
INSERT INTO `ctr_product`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`prodcate_id`,`img_icon`,`img_mini`,`img_face`,`send_out`,`status`,`name`,`alias`,`desc`)
VALUES(2100001, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '酸辣土豆丝脆饼卷', 'Hot & Sour Potato',''),
      (2100002, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '孜然烤鸡肉脆饼卷', 'Chicken Cumin',''),
      (2100003, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '德式古堡烤鸡肉脆饼卷', 'German BBQ Chicken',''),
      (2100004, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '酸甜港式叉烧脆饼卷', 'Chinese BBQ Pork',''),
      (2100005, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '日式蟹柳芝士脆饼卷', 'Crab Cheese Wasabe',''),
      (2100006, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '韩国泡菜五花肉脆饼卷', 'Pork Kimchi',''),
      (2100007, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '老坛酸菜肥牛脆饼卷', 'Sichuan Beef Pickled Veggie',''),
      (2100008, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '椒麻三文鱼脆饼卷🌶', 'Salmon Mala',''),
      (2100009, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '美国安格斯牛排脆饼卷', 'Angus Beef Black Pepper',''),
      (2100010, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '酸辣土豆丝蛋饼卷', 'Hot & Sour Potato',''),
      (2100011, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '鸡肉紫薯蛋饼卷', 'Chicken Sweet Potato',''),
      (2100012, now(), now(), '1000-01-01', 0, 2000003, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '菌菇三鲜脆饺', 'Mushroom Dumplings',''),
      (2100013, now(), now(), '1000-01-01', 0, 2000003, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '猪肉荠菜脆饺', 'Pork Dumplings',''),
      (2100014, now(), now(), '1000-01-01', 0, 2000004, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '营养南瓜粥', 'Pumpkin Porridge',''),
      (2100015, now(), now(), '1000-01-01', 0, 2000004, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '冬笋鲜鲍粥', 'Abalony Porridge',''),
      (2100016, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '原味豆浆', 'Soya Bean',''),
      (2100017, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '黑豆芝麻饮', 'Black Bean & Sesame',''),
      (2100018, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '玫瑰乌龙茶', 'Rose Oolong Tea',''),
      (2100019, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '港式奶茶', 'HK Style Milk Tea',''),
      (2100020, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '时蔬炒饭', 'Veggie Fried Rice',''),
      (2100021, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '德式古堡烤鸡肉炒饭', 'German BBQ Chicken Fried Rice',''),
      (2100022, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '咖喱鸡肉炒饭🌶', 'Curry Chicken Rice',''),
      (2100023, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '烟熏三文鱼炒饭', 'Smoked Salmon Fried Rice',''),
      (2100024, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '德式古堡烤鸡肉饭', 'German BBQ Chicken Rice',''),
      (2100025, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '澳洲和牛黑松露炒饭', 'Aussie Beef Truffle Fried Rice',''),
      (2100026, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '草原牛杂汤', 'Beef Offal',''),
      (2100027, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '松茸菌菇汤', 'Mushroom Truffle',''),
      (2100028, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '巴蜀酸辣粉🌶🌶🌶', 'Sichuan Hot & Sour Vermicelli',''),
      (2100029, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '咖喱馋嘴翅🌶', 'Curry Chickn Wings',''),
      (2100030, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '荆楚馋嘴翅🌶🌶', 'Jingzhou Chciken Wings',''),
      (2100031, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '馋嘴翅双拼🌶', 'Combo Chicken Wings',''),
      (2100032, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '黑沙流心酥', 'Black Sesame Puff',''),
      (2100033, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '黄金甲🌶', 'Tepanyaki Tofu',''),
      (2100034, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '日式蟹柳芝士吐司', 'Crab Cheese Toast',''),
      (2100035, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '蜜桃乌龙奶盖', 'Peach Oolong',''),
      (2100036, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '草莓茉莉奶盖', 'Vanila Jasmin',''),
      (2100037, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '青提茉莉奶盖', 'Jasmin Grape',''),
      (2100038, now(), now(), '1000-01-01', 0, 2000010, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '小桃气', 'Peach Soda',''),
      (2100039, now(), now(), '1000-01-01', 0, 2000010, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '小美莓', 'Blueberry Soda',''),
      -- 测试数据
      (2100040, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', true, 3010101, '原味奶茶', 'Milk Tea','')
;

TRUNCATE TABLE `ctr_product_choice`;
INSERT INTO `ctr_product_choice`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`name`,`status`,`ranking`,`skuclass`,`required`,`multiple`)
VALUES(2600001, now(), now(), '1000-01-01', 0, 2100040, "杯型", 3110102, 1, true, true, false),
      (2600002, now(), now(), '1000-01-01', 0, 2100040, "温度", 3110102, 2, false, true, false),
      (2600003, now(), now(), '1000-01-01', 0, 2100040, "糖度", 3110102, 3, false, true, false),
      (2600004, now(), now(), '1000-01-01', 0, 2100040, "加料", 3110102, 4, false, false, true)
;

TRUNCATE TABLE `ctr_product_option`;
INSERT INTO `ctr_product_option`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`choice_id`,`name`,`away_opts`,`ranking`)
VALUES(2700001, now(), now(), '1000-01-01', 0, 2100040, 2600001,"中杯","",1),
      (2700002, now(), now(), '1000-01-01', 0, 2100040, 2600001,"大杯","",2),
      (2700003, now(), now(), '1000-01-01', 0, 2100040, 2600002,"常温","2700013",1),
      (2700004, now(), now(), '1000-01-01', 0, 2100040, 2600002,"去冰","",2),
      (2700005, now(), now(), '1000-01-01', 0, 2100040, 2600002,"少冰","2700013",3),
      (2700006, now(), now(), '1000-01-01', 0, 2100040, 2600002,"加冰","2700013",4),
      (2700007, now(), now(), '1000-01-01', 0, 2100040, 2600003,"正常","",1),
      (2700008, now(), now(), '1000-01-01', 0, 2100040, 2600003,"无糖","",2),
      (2700009, now(), now(), '1000-01-01', 0, 2100040, 2600003,"少糖","",3),
      (2700010, now(), now(), '1000-01-01', 0, 2100040, 2600003,"多糖","",4),
      (2700011, now(), now(), '1000-01-01', 0, 2100040, 2600004,"红豆","",1),
      (2700012, now(), now(), '1000-01-01', 0, 2100040, 2600004,"仙草","",2),
      (2700013, now(), now(), '1000-01-01', 0, 2100040, 2600004,"冰淇淋","2700003,2700005,2700006",3)
;


TRUNCATE TABLE `ctr_commodity`;
INSERT INTO `ctr_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`status`,`img_icon`,`img_mini`,`img_face`,`name`)
VALUES(2300001, now(), now(), '1000-01-01', 0, 2100001, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '酸辣土豆丝脆饼卷'),
      (2300002, now(), now(), '1000-01-01', 0, 2100002, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '孜然烤鸡肉脆饼卷'),
      (2300003, now(), now(), '1000-01-01', 0, 2100003, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '德式古堡烤鸡肉脆饼卷'),
      (2300004, now(), now(), '1000-01-01', 0, 2100004, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '酸甜港式叉烧脆饼卷'),
      (2300005, now(), now(), '1000-01-01', 0, 2100005, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '日式蟹柳芝士脆饼卷'),
      (2300006, now(), now(), '1000-01-01', 0, 2100006, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '韩国泡菜五花肉脆饼卷'),
      (2300007, now(), now(), '1000-01-01', 0, 2100007, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '老坛酸菜肥牛脆饼卷'),
      (2300008, now(), now(), '1000-01-01', 0, 2100008, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '椒麻三文鱼脆饼卷🌶'),
      (2300009, now(), now(), '1000-01-01', 0, 2100009, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '美国安格斯牛排脆饼卷'),
      (2300010, now(), now(), '1000-01-01', 0, 2100010, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '酸辣土豆丝蛋饼卷'),
      (2300011, now(), now(), '1000-01-01', 0, 2100011, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '鸡肉紫薯蛋饼卷'),
      (2300012, now(), now(), '1000-01-01', 0, 2100012, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '菌菇三鲜脆饺'),
      (2300013, now(), now(), '1000-01-01', 0, 2100013, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '猪肉荠菜脆饺'),
      (2300014, now(), now(), '1000-01-01', 0, 2100014, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '营养南瓜粥'),
      (2300015, now(), now(), '1000-01-01', 0, 2100015, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '冬笋鲜鲍粥'),
      (2300016, now(), now(), '1000-01-01', 0, 2100016, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '原味豆浆'),
      (2300017, now(), now(), '1000-01-01', 0, 2100017, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '黑豆芝麻饮'),
      (2300018, now(), now(), '1000-01-01', 0, 2100018, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '玫瑰乌龙茶'),
      (2300019, now(), now(), '1000-01-01', 0, 2100019, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '港式奶茶'),
      (2300020, now(), now(), '1000-01-01', 0, 2100020, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '时蔬炒饭'),
      (2300021, now(), now(), '1000-01-01', 0, 2100021, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '德式古堡烤鸡肉炒饭'),
      (2300022, now(), now(), '1000-01-01', 0, 2100022, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '咖喱鸡肉炒饭🌶'),
      (2300023, now(), now(), '1000-01-01', 0, 2100023, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '烟熏三文鱼炒饭'),
      (2300024, now(), now(), '1000-01-01', 0, 2100024, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '德式古堡烤鸡肉饭'),
      (2300025, now(), now(), '1000-01-01', 0, 2100025, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '澳洲和牛黑松露炒饭'),
      (2300026, now(), now(), '1000-01-01', 0, 2100026, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '草原牛杂汤'),
      (2300027, now(), now(), '1000-01-01', 0, 2100027, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '松茸菌菇汤'),
      (2300028, now(), now(), '1000-01-01', 0, 2100028, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '巴蜀酸辣粉🌶🌶🌶'),
      (2300029, now(), now(), '1000-01-01', 0, 2100029, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '咖喱馋嘴翅🌶'),
      (2300030, now(), now(), '1000-01-01', 0, 2100030, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '荆楚馋嘴翅🌶🌶'),
      (2300031, now(), now(), '1000-01-01', 0, 2100031, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '馋嘴翅双拼🌶'),
      (2300032, now(), now(), '1000-01-01', 0, 2100032, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '黑沙流心酥'),
      (2300033, now(), now(), '1000-01-01', 0, 2100033, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '黄金甲🌶'),
      (2300034, now(), now(), '1000-01-01', 0, 2100034, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '日式蟹柳芝士吐司'),
      (2300035, now(), now(), '1000-01-01', 0, 2100035, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '蜜桃乌龙奶盖'),
      (2300036, now(), now(), '1000-01-01', 0, 2100036, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '草莓茉莉奶盖'),
      (2300037, now(), now(), '1000-01-01', 0, 2100037, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '青提茉莉奶盖'),
      (2300038, now(), now(), '1000-01-01', 0, 2100038, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '小桃气'),
      (2300039, now(), now(), '1000-01-01', 0, 2100039, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '小美莓'),
      -- 测试数据
      (2300040, now(), now(), '1000-01-01', 0, 2100040, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '原味奶茶（中杯）'),
      (2300041, now(), now(), '1000-01-01', 0, 2100040, 2530103, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', '原味奶茶（大杯）')
;

TRUNCATE TABLE `ctr_material`;
INSERT INTO `ctr_material`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`keeping_id`,`name`,`one_unit`,`use_unit`,`use_rate`)
VALUES(2400000, now(), now(), '1000-01-01', 0, 0, "示例原物料", 'KL','ML',100),
      -- 测试数据
      (2400001, now(), now(), '1000-01-01', 0, 0, "红豆", 'KG','MG',100),
      (2400002, now(), now(), '1000-01-01', 0, 0, "仙草", 'KG','MG',100),
      (2400003, now(), now(), '1000-01-01', 0, 0, "冰淇淋", 'KG','MG',100)
;


TRUNCATE TABLE `ctr_commodity_material`;
INSERT INTO `ctr_commodity_material`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`commodity_id`,`choice_id`,`option_id`,`material_id`,`material_dosage`)
VALUES(2500001, now(), now(), '1000-01-01', 0, 2300001, 0, 0, 2400000, 10),
      (2500002, now(), now(), '1000-01-01', 0, 2300002, 0, 0, 2400000, 10),
      (2500003, now(), now(), '1000-01-01', 0, 2300003, 0, 0, 2400000, 10),
      (2500004, now(), now(), '1000-01-01', 0, 2300004, 0, 0, 2400000, 10),
      (2500005, now(), now(), '1000-01-01', 0, 2300005, 0, 0, 2400000, 10),
      (2500006, now(), now(), '1000-01-01', 0, 2300006, 0, 0, 2400000, 10),
      (2500007, now(), now(), '1000-01-01', 0, 2300007, 0, 0, 2400000, 10),
      (2500008, now(), now(), '1000-01-01', 0, 2300008, 0, 0, 2400000, 10),
      (2500009, now(), now(), '1000-01-01', 0, 2300009, 0, 0, 2400000, 10),
      (2500010, now(), now(), '1000-01-01', 0, 2300010, 0, 0, 2400000, 10),
      (2500011, now(), now(), '1000-01-01', 0, 2300011, 0, 0, 2400000, 10),
      (2500012, now(), now(), '1000-01-01', 0, 2300012, 0, 0, 2400000, 10),
      (2500013, now(), now(), '1000-01-01', 0, 2300013, 0, 0, 2400000, 10),
      (2500014, now(), now(), '1000-01-01', 0, 2300014, 0, 0, 2400000, 10),
      (2500015, now(), now(), '1000-01-01', 0, 2300015, 0, 0, 2400000, 10),
      (2500016, now(), now(), '1000-01-01', 0, 2300016, 0, 0, 2400000, 10),
      (2500017, now(), now(), '1000-01-01', 0, 2300017, 0, 0, 2400000, 10),
      (2500018, now(), now(), '1000-01-01', 0, 2300018, 0, 0, 2400000, 10),
      (2500019, now(), now(), '1000-01-01', 0, 2300019, 0, 0, 2400000, 10),
      (2500020, now(), now(), '1000-01-01', 0, 2300020, 0, 0, 2400000, 10),
      (2500021, now(), now(), '1000-01-01', 0, 2300021, 0, 0, 2400000, 10),
      (2500022, now(), now(), '1000-01-01', 0, 2300022, 0, 0, 2400000, 10),
      (2500023, now(), now(), '1000-01-01', 0, 2300023, 0, 0, 2400000, 10),
      (2500024, now(), now(), '1000-01-01', 0, 2300024, 0, 0, 2400000, 10),
      (2500025, now(), now(), '1000-01-01', 0, 2300025, 0, 0, 2400000, 10),
      (2500026, now(), now(), '1000-01-01', 0, 2300026, 0, 0, 2400000, 10),
      (2500027, now(), now(), '1000-01-01', 0, 2300027, 0, 0, 2400000, 10),
      (2500028, now(), now(), '1000-01-01', 0, 2300028, 0, 0, 2400000, 10),
      (2500029, now(), now(), '1000-01-01', 0, 2300029, 0, 0, 2400000, 10),
      (2500030, now(), now(), '1000-01-01', 0, 2300030, 0, 0, 2400000, 10),
      (2500031, now(), now(), '1000-01-01', 0, 2300031, 0, 0, 2400000, 10),
      (2500032, now(), now(), '1000-01-01', 0, 2300032, 0, 0, 2400000, 10),
      (2500033, now(), now(), '1000-01-01', 0, 2300033, 0, 0, 2400000, 10),
      (2500034, now(), now(), '1000-01-01', 0, 2300034, 0, 0, 2400000, 10),
      (2500035, now(), now(), '1000-01-01', 0, 2300035, 0, 0, 2400000, 10),
      (2500036, now(), now(), '1000-01-01', 0, 2300036, 0, 0, 2400000, 10),
      (2500037, now(), now(), '1000-01-01', 0, 2300037, 0, 0, 2400000, 10),
      (2500038, now(), now(), '1000-01-01', 0, 2300038, 0, 0, 2400000, 10),
      (2500039, now(), now(), '1000-01-01', 0, 2300039, 0, 0, 2400000, 10),
      -- 测试数据-杯型
      (2500040, now(), now(), '1000-01-01', 0, 2300040, 2600001, 2700001, 0, 10),
      (2500041, now(), now(), '1000-01-01', 0, 2300041, 2600001, 2700002, 0, 10),
      -- 测试数据-温度
      (2500042, now(), now(), '1000-01-01', 0, 2300040, 2600002, 2700003, 0, 10),
      (2500043, now(), now(), '1000-01-01', 0, 2300040, 2600002, 2700004, 0, 10),
      (2500044, now(), now(), '1000-01-01', 0, 2300040, 2600002, 2700005, 0, 10),
      (2500045, now(), now(), '1000-01-01', 0, 2300040, 2600002, 2700006, 0, 10),
      (2500046, now(), now(), '1000-01-01', 0, 2300041, 2600002, 2700003, 0, 10),
      (2500047, now(), now(), '1000-01-01', 0, 2300041, 2600002, 2700004, 0, 10),
      (2500048, now(), now(), '1000-01-01', 0, 2300041, 2600002, 2700005, 0, 10),
      (2500049, now(), now(), '1000-01-01', 0, 2300041, 2600002, 2700006, 0, 10),
      -- 测试数据-加料
      (2500050, now(), now(), '1000-01-01', 0, 2300040, 2600004, 2700011, 2400001, 10),
      (2500051, now(), now(), '1000-01-01', 0, 2300040, 2600004, 2700012, 2400002, 10),
      (2500052, now(), now(), '1000-01-01', 0, 2300040, 2600004, 2700013, 2400003, 10),
      (2500053, now(), now(), '1000-01-01', 0, 2300041, 2600004, 2700011, 2400001, 10),
      (2500054, now(), now(), '1000-01-01', 0, 2300041, 2600004, 2700012, 2400002, 10),
      (2500055, now(), now(), '1000-01-01', 0, 2300041, 2600004, 2700013, 2400003, 10)
;


TRUNCATE TABLE `ctr_store`;
INSERT INTO `ctr_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`,`region_id`,`timezone`,`position`,`map_type`,`address`,`store_type`,`place_type`,`union_type`,`square`,`square_unit`,`seat_count`,`manager_name`,`manager_phone`,`photo1`,`photo2`,`photo3`,`photo4`,`photo5`,`opening_ldt`,`expired_ldt`,`inner_only`,`eat_inside`,`sell_mode`,`send_area_gmap`,`send_area_json`,`tax_rate`,`sendouter_id`,`scenario_id`, `store_num`)
VALUES(2800001,now(),now(),'1000-01-01',0,'虹桥天街店',4010102,1000900,10100,'','','',4010201,4010304,4010401,'120','平方米','20','J','15994234567','','','','','','2019-10-01','2029-10-01',true,true,'自提,外送','','',0,0,'3100001', '2800001');

TRUNCATE TABLE `ctr_scenario`;
INSERT INTO `ctr_scenario`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`desc`,`img_advt`,`currency`,`status`)
VALUES(3100001, now(), now(), '1000-01-01', 0, '上海地区通用方案', '', 'http://static.lianglife.com/HomePage/homePage.png', 'CNY', 3710102);

TRUNCATE TABLE `ctr_scenario_region`;
INSERT INTO `ctr_scenario_region`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`region_id`,`store_type`,`place_type`)
VALUES(4000000, now(), now(), '1000-01-01', 0, 3100001, 1000900, 4010201, 4010304);

TRUNCATE TABLE `ctr_scenario_store`;
INSERT INTO `ctr_scenario_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`store_id`)
VALUES(3200001, now(), now(), '1000-01-01', 0,3100001,2800001);

TRUNCATE TABLE `ctr_proposal`;
INSERT INTO `ctr_proposal`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`img_icon`,`img_mini`,`img_face`,`timezone`,`open_ldt`,`shut_ldt`,`price_list`,`price_sell`,`price_rule`,`status`,`ranking`,`sell_time`,`name`,`alias`,`desc`)
VALUES(3300001, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  1, '1200106', '酸辣土豆丝脆饼卷', 'Hot & Sour Potato',''),
      (3300002, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  2, '1200106', '孜然烤鸡肉脆饼卷', 'Chicken Cumin',''),
      (3300003, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  3, '1200106', '德式古堡烤鸡肉脆饼卷', 'German BBQ Chicken',''),
      (3300004, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  4, '1200106', '酸甜港式叉烧脆饼卷', 'Chinese BBQ Pork',''),
      (3300005, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  5, '1200106', '日式蟹柳芝士脆饼卷', 'Crab Cheese Wasabe',''),
      (3300006, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  6, '1200106', '韩国泡菜五花肉脆饼卷', 'Pork Kimchi',''),
      (3300007, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  7, '1200106', '老坛酸菜肥牛脆饼卷', 'Sichuan Beef Pickled Veggie',''),
      (3300008, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  8, '1200106', '椒麻三文鱼脆饼卷🌶', 'Salmon Mala',''),
      (3300009, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  9, '1200106', '美国安格斯牛排脆饼卷', 'Angus Beef Black Pepper',''),
      (3300010, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 10, '1200101', '酸辣土豆丝蛋饼卷', 'Hot & Sour Potato',''),
      (3300011, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 11, '1200101', '鸡肉紫薯蛋饼卷', 'Chicken Sweet Potato',''),
      (3300012, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 12, '1200101', '菌菇三鲜脆饺', 'Mushroom Dumplings',''),
      (3300013, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 13, '1200101', '猪肉荠菜脆饺', 'Pork Dumplings',''),
      (3300014, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 14, '1200101,1200102,1200104', '营养南瓜粥', 'Pumpkin Porridge',''),
      (3300015, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 15, '1200101,1200102,1200104', '冬笋鲜鲍粥', 'Abalony Porridge',''),
      (3300016, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 16, '1200101,1200102,1200103,1200104', '原味豆浆', 'Soya Bean',''),
      (3300017, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 17, '1200101,1200102,1200103,1200104', '黑豆芝麻饮', 'Black Bean & Sesame',''),
      (3300018, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 18, '1200101,1200102,1200103,1200104', '玫瑰乌龙茶', 'Rose Oolong Tea',''),
      (3300019, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 19, '1200101,1200102,1200103,1200104', '港式奶茶', 'HK Style Milk Tea',''),
      (3300020, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 20, '1200102,1200104', '时蔬炒饭', 'Veggie Fried Rice',''),
      (3300021, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 21, '1200102,1200104', '德式古堡烤鸡肉炒饭', 'German BBQ Chicken Fried Rice',''),
      (3300022, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 22, '1200102,1200104', '咖喱鸡肉炒饭🌶', 'Curry Chicken Rice',''),
      (3300023, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 23, '1200102,1200104', '烟熏三文鱼炒饭', 'Smoked Salmon Fried Rice',''),
      (3300024, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 24, '1200102,1200104', '德式古堡烤鸡肉饭', 'German BBQ Chicken Rice',''),
      (3300025, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 25, '1200102,1200104', '澳洲和牛黑松露炒饭', 'Aussie Beef Truffle Fried Rice',''),
      (3300026, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 26, '1200102,1200104', '草原牛杂汤', 'Beef Offal',''),
      (3300027, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 27, '1200102,1200104', '松茸菌菇汤', 'Mushroom Truffle',''),
      (3300028, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 28, '1200101,1200104', '巴蜀酸辣粉🌶🌶🌶', 'Sichuan Hot & Sour Vermicelli',''),
      (3300029, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 29, '1200103', '咖喱馋嘴翅🌶', 'Curry Chickn Wings',''),
      (3300030, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 30, '1200103', '荆楚馋嘴翅🌶🌶', 'Jingzhou Chciken Wings',''),
      (3300031, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 31, '1200103', '馋嘴翅双拼🌶', 'Combo Chicken Wings',''),
      (3300032, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 32, '1200103', '黑沙流心酥', 'Black Sesame Puff',''),
      (3300033, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 33, '1200103', '黄金甲🌶', 'Tepanyaki Tofu',''),
      (3300034, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 34, '1200103', '日式蟹柳芝士吐司', 'Crab Cheese Toast',''),
      (3300035, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 35, '1200102,1200103,1200104', '蜜桃乌龙奶盖', 'Peach Oolong',''),
      (3300036, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 36, '1200102,1200103,1200104', '草莓茉莉奶盖', 'Vanila Jasmin',''),
      (3300037, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 37, '1200102,1200103,1200104', '青提茉莉奶盖', 'Jasmin Grape',''),
      (3300038, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 38, '1200102,1200103,1200104', '小桃气', 'Peach Soda',''),
      (3300039, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 39, '1200102,1200103,1200104', '小美莓', 'Blueberry Soda',''),
      -- 单品测试数据
      (3300040, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 40, '1200101,1200102,1200103,1200104', '原味奶茶', 'Milk Tea',''),
      -- 套餐
      (3300041, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 'http://static.lianglife.com/demo.png', 10100, '2019-10-1', '2029-10-1', 28, 18, 3510202, 3510101, 41, '1200106', '双人脆饼卷(套餐）', 'Hot & Sour Potato Package','')
;


TRUNCATE TABLE `ctr_proposal_commodity`;
INSERT INTO `ctr_proposal_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`bundle_id`,`product_id`,`commodity_id`,`price_list`,`price_sell`,`buy_min`,`buy_max`,`show_price`,`selected`,`ranking`,`name`)
VALUES(3500001, now(), now(), '1000-01-01', 0, 3300001 ,0, 2100001, 2300001, 14, 12, 1, 1, true, true,  1, '酸辣土豆丝脆饼卷'),
      (3500002, now(), now(), '1000-01-01', 0, 3300002 ,0, 2100002, 2300002, 20, 17, 1, 1, true, true,  2, '孜然烤鸡肉脆饼卷'),
      (3500003, now(), now(), '1000-01-01', 0, 3300003 ,0, 2100003, 2300003, 20, 17, 1, 1, true, true,  3, '德式古堡烤鸡肉脆饼卷'),
      (3500004, now(), now(), '1000-01-01', 0, 3300004 ,0, 2100004, 2300004, 22, 19, 1, 1, true, true,  4, '酸甜港式叉烧脆饼卷'),
      (3500005, now(), now(), '1000-01-01', 0, 3300005 ,0, 2100005, 2300005, 22, 19, 1, 1, true, true,  5, '日式蟹柳芝士脆饼卷'),
      (3500006, now(), now(), '1000-01-01', 0, 3300006 ,0, 2100006, 2300006, 22, 19, 1, 1, true, true,  6, '韩国泡菜五花肉脆饼卷'),
      (3500007, now(), now(), '1000-01-01', 0, 3300007 ,0, 2100007, 2300007, 22, 19, 1, 1, true, true,  7, '老坛酸菜肥牛脆饼卷'),
      (3500008, now(), now(), '1000-01-01', 0, 3300008 ,0, 2100008, 2300008, 28, 24, 1, 1, true, true,  8, '椒麻三文鱼脆饼卷🌶'),
      (3500009, now(), now(), '1000-01-01', 0, 3300009 ,0, 2100009, 2300009, 44, 38, 1, 1, true, true,  9, '美国安格斯牛排脆饼卷'),
      (3500010, now(), now(), '1000-01-01', 0, 3300010 ,0, 2100010, 2300010, 14, 12, 1, 1, true, true, 10, '酸辣土豆丝蛋饼卷'),
      (3500011, now(), now(), '1000-01-01', 0, 3300011 ,0, 2100011, 2300011, 20, 17, 1, 1, true, true, 11, '鸡肉紫薯蛋饼卷'),
      (3500012, now(), now(), '1000-01-01', 0, 3300012 ,0, 2100012, 2300012, 14, 12, 1, 1, true, true, 12, '菌菇三鲜脆饺'),
      (3500013, now(), now(), '1000-01-01', 0, 3300013 ,0, 2100013, 2300013, 14, 12, 1, 1, true, true, 13, '猪肉荠菜脆饺'),
      (3500014, now(), now(), '1000-01-01', 0, 3300014 ,0, 2100014, 2300014,  8,  7, 1, 1, true, true, 14, '营养南瓜粥'),
      (3500015, now(), now(), '1000-01-01', 0, 3300015 ,0, 2100015, 2300015, 17, 15, 1, 1, true, true, 15, '冬笋鲜鲍粥'),
      (3500016, now(), now(), '1000-01-01', 0, 3300016 ,0, 2100016, 2300016,  7,  6, 1, 1, true, true, 16, '原味豆浆'),
      (3500017, now(), now(), '1000-01-01', 0, 3300017 ,0, 2100017, 2300017, 12, 11, 1, 1, true, true, 17, '黑豆芝麻饮'),
      (3500018, now(), now(), '1000-01-01', 0, 3300018 ,0, 2100018, 2300018, 12, 11, 1, 1, true, true, 18, '玫瑰乌龙茶'),
      (3500019, now(), now(), '1000-01-01', 0, 3300019 ,0, 2100019, 2300019, 12, 11, 1, 1, true, true, 19, '港式奶茶'),
      (3500020, now(), now(), '1000-01-01', 0, 3300020 ,0, 2100020, 2300020, 18, 16, 1, 1, true, true, 20, '时蔬炒饭'),
      (3500021, now(), now(), '1000-01-01', 0, 3300021 ,0, 2100021, 2300021, 22, 19, 1, 1, true, true, 21, '德式古堡烤鸡肉炒饭'),
      (3500022, now(), now(), '1000-01-01', 0, 3300022 ,0, 2100022, 2300022, 22, 19, 1, 1, true, true, 22, '咖喱鸡肉炒饭🌶'),
      (3500023, now(), now(), '1000-01-01', 0, 3300023 ,0, 2100023, 2300023, 26, 23, 1, 1, true, true, 23, '烟熏三文鱼炒饭'),
      (3500024, now(), now(), '1000-01-01', 0, 3300024 ,0, 2100024, 2300024, 26, 23, 1, 1, true, true, 24, '德式古堡烤鸡肉饭'),
      (3500025, now(), now(), '1000-01-01', 0, 3300025 ,0, 2100025, 2300025, 34, 29, 1, 1, true, true, 25, '澳洲和牛黑松露炒饭'),
      (3500026, now(), now(), '1000-01-01', 0, 3300026 ,0, 2100026, 2300026, 18, 16, 1, 1, true, true, 26, '草原牛杂汤'),
      (3500027, now(), now(), '1000-01-01', 0, 3300027 ,0, 2100027, 2300027, 18, 16, 1, 1, true, true, 27, '松茸菌菇汤'),
      (3500028, now(), now(), '1000-01-01', 0, 3300028 ,0, 2100028, 2300028, 18, 16, 1, 1, true, true, 28, '巴蜀酸辣粉🌶🌶🌶'),
      (3500029, now(), now(), '1000-01-01', 0, 3300029 ,0, 2100029, 2300029, 12, 11, 1, 1, true, true, 29, '咖喱馋嘴翅🌶'),
      (3500030, now(), now(), '1000-01-01', 0, 3300030 ,0, 2100030, 2300030, 12, 11, 1, 1, true, true, 30, '荆楚馋嘴翅🌶🌶'),
      (3500031, now(), now(), '1000-01-01', 0, 3300031 ,0, 2100031, 2300031, 12, 11, 1, 1, true, true, 31, '馋嘴翅双拼🌶'),
      (3500032, now(), now(), '1000-01-01', 0, 3300032 ,0, 2100032, 2300032, 12, 11, 1, 1, true, true, 32, '黑沙流心酥'),
      (3500033, now(), now(), '1000-01-01', 0, 3300033 ,0, 2100033, 2300033, 12, 11, 1, 1, true, true, 33, '黄金甲🌶'),
      (3500034, now(), now(), '1000-01-01', 0, 3300034 ,0, 2100034, 2300034, 22, 19, 1, 1, true, true, 34, '日式蟹柳芝士吐司'),
      (3500035, now(), now(), '1000-01-01', 0, 3300035 ,0, 2100035, 2300035, 18, 16, 1, 1, true, true, 35, '蜜桃乌龙奶盖'),
      (3500036, now(), now(), '1000-01-01', 0, 3300036 ,0, 2100036, 2300036, 18, 16, 1, 1, true, true, 36, '草莓茉莉奶盖'),
      (3500037, now(), now(), '1000-01-01', 0, 3300037 ,0, 2100037, 2300037, 18, 16, 1, 1, true, true, 37, '青提茉莉奶盖'),
      (3500038, now(), now(), '1000-01-01', 0, 3300038 ,0, 2100038, 2300038, 18, 16, 1, 1, true, true, 38, '小桃气'),
      (3500039, now(), now(), '1000-01-01', 0, 3300039 ,0, 2100039, 2300039, 18, 16, 1, 1, true, true, 39, '小美莓'),
      -- 单品测试数据
      (3500040, now(), now(), '1000-01-01', 0, 3300040, 0, 2100040, 2300040, 16, 14, 1, 1, true, true, 40, '原味奶茶（中杯）'),
      (3500041, now(), now(), '1000-01-01', 0, 3300040, 0, 2100040, 2300041, 18, 20, 1, 1, true, false, 41, '原味奶茶（大杯）'),
      -- 套餐测试数据
      (3500042, now(), now(), '1000-01-01', 0, 3300041 ,3900001, 2100001, 2300001, 0, 0, 1, 2, false, true,  1, '酸辣土豆丝脆饼卷'),
      (3500043, now(), now(), '1000-01-01', 0, 3300041 ,3900001, 2100002, 2300002, 0, 0, 1, 2, false, true,  2, '孜然烤鸡肉脆饼卷'),
      (3500044, now(), now(), '1000-01-01', 0, 3300041 ,3900002, 2100030, 2300030, 0, 0, 0, 2, false, false, 1, '荆楚馋嘴翅🌶🌶'),
      (3500045, now(), now(), '1000-01-01', 0, 3300041 ,3900002, 2100029, 2300029, 0, 0, 0, 2, false, false, 2, '咖喱馋嘴翅🌶'),

      (3500046, now(), now(), '1000-01-01', 0, 3300041 ,3900002, 2100028, 2300028, 0, 0, 0, 2, false, false, 3, '巴蜀酸辣粉🌶🌶🌶'),
      (3500047, now(), now(), '1000-01-01', 0, 3300041 ,3900002, 2100027, 2300027, 0, 0, 0, 2, false, false, 4, '松茸菌菇汤'),
      (3500048, now(), now(), '1000-01-01', 0, 3300041 ,3900002, 2100026, 2300026, 0, 0, 0, 2, false, false, 5, '草原牛杂汤'),

      (3500049, now(), now(), '1000-01-01', 0, 3300041 ,3900003, 2100016, 2300016, 0, 0, 0, 2, false, false, 1, '原味豆浆'),
      (3500050, now(), now(), '1000-01-01', 0, 3300041, 3900003, 2100040, 2300040, 0, 0, 0, 2, false, false, 2, '原味奶茶（中杯）')
;

TRUNCATE TABLE `ctr_proposal_option`;
INSERT INTO `ctr_proposal_option`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`commodity_id`,`option_id`,`price_list`,`price_sell`,`show_price`,`show_this`,`selected`,`ranking`)
      -- 单品测试数据-杯型
VALUES(3600001, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700001, 0, 0, true, true, true, 1),
      (3600002, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700002, 0, 0, true, true, true, 2),

      -- 单品测试数据-温度
      (3600003, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700003, 0, 0, false, true, true, 1),
      (3600004, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700004, 0, 0, false, true, false, 2),
      (3600005, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700005, 0, 0, false, true, false, 3),
      (3600006, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700006, 0, 0, false, true, false, 4),
      (3600007, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700003, 0, 0, false, true, true, 1),
      (3600008, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700004, 0, 0, false, true, false, 2),
      (3600009, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700005, 0, 0, false, true, false, 3),
      (3600010, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700006, 0, 0, false, true, false, 4),
      -- 单品测试数据-加料
      (3600011, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700011, 1, 1, true, true, false, 1),
      (3600012, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700012, 2, 2, true, true, false, 2),
      (3600013, now(), now(), '1000-01-01', 0, 3300040, 2300040, 2700013, 3, 3, true, true, false, 3),
      (3600014, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700011, 2, 2, true, true, false, 1),
      (3600015, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700012, 3, 3, true, true, false, 2),
      (3600016, now(), now(), '1000-01-01', 0, 3300040, 2300041, 2700013, 4, 4, true, true, false, 3),

      -- 套餐测试数据-杯型
      (3600017, now(), now(), '1000-01-01', 0, 3300041, 2300040, 2700001, 0, 0, true, true, true, 1),
      -- 套餐测试数据-温度
      (3600018, now(), now(), '1000-01-01', 0, 3300041, 2300040, 2700003, 0, 0, false, true, true, 1)
;


TRUNCATE TABLE `ctr_scenario_menu`;
INSERT INTO `ctr_scenario_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`name`,`img_icon`,`desc`,`visible`,`topmenu`,`ranking`)
VALUES(3700001, now(), now(), '1000-01-01', 0, 3100001, '卷饼类', 'http://static.lianglife.com/BroadSideIcon/crispyRoll.png', '', true, false, 1),
      (3700002, now(), now(), '1000-01-01', 0, 3100001, '蛋饼', 'http://static.lianglife.com/BroadSideIcon/eggCake.png', '', true, false, 2),
      (3700003, now(), now(), '1000-01-01', 0, 3100001, '早点', 'http://static.lianglife.com/BroadSideIcon/breakfast.png', '', true, false, 3),
      (3700004, now(), now(), '1000-01-01', 0, 3100001, '粥', 'http://static.lianglife.com/BroadSideIcon/soup.png', '', true, false, 4),
      (3700005, now(), now(), '1000-01-01', 0, 3100001, '热饮', 'http://static.lianglife.com/BroadSideIcon/hotDrinks.png', '', true, false, 5),
      (3700006, now(), now(), '1000-01-01', 0, 3100001, '饭', 'http://static.lianglife.com/BroadSideIcon/meal.png', '', true, false, 6),
      (3700007, now(), now(), '1000-01-01', 0, 3100001, '汤', 'http://static.lianglife.com/BroadSideIcon/conjee.png', '', true, false, 7),
      (3700008, now(), now(), '1000-01-01', 0, 3100001, '小食', 'http://static.lianglife.com/BroadSideIcon/charge.png', '', true, false, 8),
      (3700009, now(), now(), '1000-01-01', 0, 3100001, '冷饮（奶盖茶)', 'http://static.lianglife.com/BroadSideIcon/coldDrinkMilkCover.png', '', true, false, 9),
      (3700010, now(), now(), '1000-01-01', 0, 3100001, '冷饮（气泡水)', 'http://static.lianglife.com/BroadSideIcon/coldAirBubles.png', '', true, false, 10),
      (3700011, now(), now(), '1000-01-01', 0, 3100001, '人气热销', 'http://static.lianglife.com/BroadSideIcon/hotSell.png', '', true, true, 11),
      (3700012, now(), now(), '1000-01-01', 0, 3100001, '精选套餐', 'http://static.lianglife.com/BroadSideIcon/support.png', '', true, true, 12)
;


TRUNCATE TABLE `ctr_proposal_menu`;
INSERT INTO `ctr_proposal_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`scenmenu_id`)
VALUES(3800001, now(), now(), '1000-01-01', 0, 3300001, 3700001),
      (3800002, now(), now(), '1000-01-01', 0, 3300002, 3700001),
      (3800003, now(), now(), '1000-01-01', 0, 3300003, 3700001),
      (3800004, now(), now(), '1000-01-01', 0, 3300004, 3700001),
      (3800005, now(), now(), '1000-01-01', 0, 3300005, 3700001),
      (3800006, now(), now(), '1000-01-01', 0, 3300006, 3700001),
      (3800007, now(), now(), '1000-01-01', 0, 3300007, 3700001),
      (3800008, now(), now(), '1000-01-01', 0, 3300008, 3700001),
      (3800009, now(), now(), '1000-01-01', 0, 3300009, 3700001),
      (3800010, now(), now(), '1000-01-01', 0, 3300010, 3700002),
      (3800011, now(), now(), '1000-01-01', 0, 3300011, 3700002),
      (3800012, now(), now(), '1000-01-01', 0, 3300012, 3700003),
      (3800013, now(), now(), '1000-01-01', 0, 3300013, 3700003),
      (3800014, now(), now(), '1000-01-01', 0, 3300014, 3700004),
      (3800015, now(), now(), '1000-01-01', 0, 3300015, 3700004),
      (3800016, now(), now(), '1000-01-01', 0, 3300016, 3700005),
      (3800017, now(), now(), '1000-01-01', 0, 3300017, 3700005),
      (3800018, now(), now(), '1000-01-01', 0, 3300018, 3700005),
      (3800019, now(), now(), '1000-01-01', 0, 3300019, 3700005),
      (3800020, now(), now(), '1000-01-01', 0, 3300020, 3700006),
      (3800021, now(), now(), '1000-01-01', 0, 3300021, 3700006),
      (3800022, now(), now(), '1000-01-01', 0, 3300022, 3700006),
      (3800023, now(), now(), '1000-01-01', 0, 3300023, 3700006),
      (3800024, now(), now(), '1000-01-01', 0, 3300024, 3700006),
      (3800025, now(), now(), '1000-01-01', 0, 3300025, 3700006),
      (3800026, now(), now(), '1000-01-01', 0, 3300026, 3700007),
      (3800027, now(), now(), '1000-01-01', 0, 3300027, 3700007),
      (3800028, now(), now(), '1000-01-01', 0, 3300028, 3700007),
      (3800029, now(), now(), '1000-01-01', 0, 3300029, 3700008),
      (3800030, now(), now(), '1000-01-01', 0, 3300030, 3700008),
      (3800031, now(), now(), '1000-01-01', 0, 3300031, 3700008),
      (3800032, now(), now(), '1000-01-01', 0, 3300032, 3700008),
      (3800033, now(), now(), '1000-01-01', 0, 3300033, 3700008),
      (3800034, now(), now(), '1000-01-01', 0, 3300034, 3700008),
      (3800035, now(), now(), '1000-01-01', 0, 3300035, 3700009),
      (3800036, now(), now(), '1000-01-01', 0, 3300036, 3700009),
      (3800037, now(), now(), '1000-01-01', 0, 3300037, 3700009),
      (3800038, now(), now(), '1000-01-01', 0, 3300038, 3700010),
      (3800039, now(), now(), '1000-01-01', 0, 3300039, 3700010),
      -- 单品测试数据
      (3800040, now(), now(), '1000-01-01', 0, 3300040, 3700009),
      (3800041, now(), now(), '1000-01-01', 0, 3300040, 3700011),
      -- 套餐测试数据
      (3800042, now(), now(), '1000-01-01', 0, 3300041, 3700011),
      (3800043, now(), now(), '1000-01-01', 0, 3300041, 3700012)

;

TRUNCATE TABLE `ctr_proposal_bundle`;
INSERT INTO `ctr_proposal_bundle`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`name`,`buy_num`,`ranking`)
VALUES(3900001, now(), now(), '1000-01-01', 0, 3300041, '主食', '2', 1),
      (3900002, now(), now(), '1000-01-01', 0, 3300041, '配菜', '2', 2),
      (3900003, now(), now(), '1000-01-01', 0, 3300041, '饮品', '3', 3)
;

TRUNCATE TABLE `ctr_account_balance`;
INSERT INTO `ctr_account_balance`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`account_id`,`money_type`,`currency`,`balance`,`credit`,`status`)
VALUES('0',now(), now(), '1000-01-01', 0, 0, 5510101, 'CNY', 0, 2147483647, 5520201),
      ('1',now(), now(), '1000-01-01', 0, 1, 5510101, 'CNY', 0, 2147483647, 5520201)
;

-- Finish
