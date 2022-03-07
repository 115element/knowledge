
-- 正式门店使用
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
VALUES(2000001, 0, now(), now(), '1000-01-01', 0, '脆饼卷', 3020102),
      (2000002, 0, now(), now(), '1000-01-01', 0, '蛋饼券', 3020102),
      (2000003, 0, now(), now(), '1000-01-01', 0, 'tacco', 3020102),
      (2000004, 0, now(), now(), '1000-01-01', 0, '薄脆',   3020102),
      (2000005, 0, now(), now(), '1000-01-01', 0, '热饮',   3020102),
      (2000006, 0, now(), now(), '1000-01-01', 0, '冷饮',   3020102),
      (2000007, 0, now(), now(), '1000-01-01', 0, '拿破仑', 3020102),
      (2000008, 0, now(), now(), '1000-01-01', 0, '脆饺',   3020102),
      (2000009, 0, now(), now(), '1000-01-01', 0, '饭',     3020102),
      (2000010, 0, now(), now(), '1000-01-01', 0, '汤',     3020102),
      (2000011, 0, now(), now(), '1000-01-01', 0, '点心',   3020102)
;

TRUNCATE TABLE `ctr_product`;
INSERT INTO `ctr_product`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`prodcate_id`,`img_icon`,`img_mini`,`img_face`,`send_out`,`status`,`name`,`alias`,`desc`)
VALUES(2100001, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',                'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', true, 3010101, '(卷饼)酸辣土豆丝', 'Hot & Sour Potato Crispy Roll','经典酸辣的川菜风味，爽口开胃，土豆丝根根分明脆而不生，滑而不腻，搭配严格把控40s煎制的饼皮，使酥脆口感x2。'),
      (2100002, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png',             'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',   'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', true, 3010101, '(卷饼)德式烤鸡肉', 'German BBQ Chicken Crispy Roll','采用进口德式工艺烤肉机，45min猛火炙烤，现烤先削，美味更直接！烤前秘制酱料腌制入味，使恰到好处的肉汁在口中迸发美味。'),
      (2100003, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',               'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',          'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', true, 3010101, '(卷饼)叉烧', 'Chinese BBQ Pork Crispy Roll','选用整块腌制猪颈肉，肥瘦均衡，鲜甜多汁，配以秘制的酸甜酱，搭配爽口紫甘蓝和洋葱，口感鲜脆、刺激食欲。'),
      (2100004, now(), now(), '1000-01-01', 0, 2000001, '','','', true, 3010101, '蟹柳芝士卷', 'Crab Cheese Crispy Roll',''),
      (2100005, now(), now(), '1000-01-01', 0, 2000001, '','','', true, 3010101, '酸菜肥牛卷', 'Beef Pickled Veggie Crispy Roll',''),
      (2100006, now(), now(), '1000-01-01', 0, 2000001, '','','', true, 3010101, '麻辣香锅鸡卷', 'Sichuan Spicy Chicken Crispy Roll',''),
      (2100007, now(), now(), '1000-01-01', 0, 2000001, '','','', true, 3010101, '果木鸭肉卷', 'Peking Duck Crispy Roll',''),
      (2100008, now(), now(), '1000-01-01', 0, 2000001, '','','', true, 3010101, '芝士牛肉肠卷', 'Cheese Beef Sausage Crispy Roll', ''),

      (2100009, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', true, 3010101, '酸辣土豆丝蛋饼', 'Hot & Sour Potato Omelette','经典酸辣的川菜风味，爽口开胃，健康超薄的粗粮蛋饼皮，搭配爽口蔬菜，少油+薄韧+酸爽，满满过瘾回味。'),
      (2100010, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', true, 3010101, '(蛋饼)德式烤鸡肉味', 'German BBQ Chicken Omelette','精选低脂带皮去骨鸡腿肉，反复滚揉入味，德式工艺45min猛火炙烤，保持肉质原有鲜香同时，更加肉汁丰盈。'),
      (2100011, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', true, 3010101, '叉烧蛋饼', 'Roast Pork Omelette','选用整块腌制猪颈肉，肥瘦均衡，秘制酸甜酱，搭配脆爽紫甘蓝，粗粮蛋饼皮搭配，软嫩多汁同时，碰撞鲜甜滋味。'),
      (2100012, now(), now(), '1000-01-01', 0, 2000002, '',        '',        '', true, 3010101, '蟹柳芝士蛋饼',  'Crab Cheese Omelettes',''),
      (2100013, now(), now(), '1000-01-01', 0, 2000002, '',        '',        '', true, 3010101, '酸菜肥牛蛋饼',  'Beef Pickled Veggie Omelettes',''),
      (2100014, now(), now(), '1000-01-01', 0, 2000002, '',        '',        '', true, 3010101, '麻辣香锅鸡蛋饼', 'Sichuan Spicy Chicken Omelettes',''),
      (2100015, now(), now(), '1000-01-01', 0, 2000002, '',        '',        '', true, 3010101, '果木鸭肉蛋饼',  'Peking Duck Omelettes',''),
      (2100016, now(), now(), '1000-01-01', 0, 2000002, '',        '',        '', true, 3010101, '芝士牛肉肠蛋饼', 'Cheese Beef Sausage Omelettes',''),

      (2100017, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)酸辣土豆丝',  'Hot & Sour Potato Tacco',     ''),
      (2100018, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)德式烤鸡肉',  'German BBQ Chicken Tacco',    ''),
      (2100019, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)叉烧卷',     'Chinese BBQ Pork Tacco',      ''),
      (2100020, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)蟹柳芝士',    'Crab Cheese Tacco',          ''),
      (2100021, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)酸菜肥牛',   'Beef Pickled Veggie Tacco',   ''),
      (2100022, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)麻辣香锅鸡',  'Sichuan Spicy Chicken Tacco', ''),
      (2100023, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)果木鸭肉卷',  'Peking Duck Tacco',           ''),
      (2100024, now(), now(), '1000-01-01', 0, 2000003, '',        '',        '', true, 3010101, '(Tacco)芝士牛肉肠',  'Cheese Beef Sausage Tacco',   ''),

      (2100025, now(), now(), '1000-01-01', 0, 2000004, '',        '',        '', true, 3010101, '(薄脆)黑松露鸭肉',   'Truffle duck Papad',''),
      (2100026, now(), now(), '1000-01-01', 0, 2000004, '',        '',        '', true, 3010101, '(薄脆)麻辣香锅烤鸡 ', 'Sichuan Spicy Chicken Papad',''),

      (2100027, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', true, 3010101, '原味豆浆', 'Soya Bean Original','精选优质大豆，颗颗饱满，豆味浓郁。采用先进制浆工艺，脱腥去渣，保留大豆原香。入口浓郁醇厚不甜腻，细腻顺滑。'),
      (2100028, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', true, 3010101, '原味米浆', 'Rice Milk Original','健康谷物大米，冬日温暖饮品，浓郁香醇，香、甜、浓，甘甜不腻，入喉丝滑，满口米香回味。'),
      (2100029, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', true, 3010101, '玫瑰乌龙', 'Rose Oolong Tea','精选食用级重瓣玫瑰，经工艺处理，以净花瓣付窨。搭配台湾洞顶乌龙茶汤，花香茶香呼应，齿颊留香，回味甘鲜。'),
      (2100030, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', true, 3010101, '港式奶茶', 'HK Style Milk Tea','采用斯里兰卡进口红茶，这里出产的红茶香味浓郁，带花香，且涩味少。经撞茶工序，保留茶叶的浓厚，口感爽滑，延绵细密。'),

      (2100031, now(), now(), '1000-01-01', 0, 2000006, '',        '',        '', true, 3010101, '小桃汽', 'Peach Soda',''),
      (2100032, now(), now(), '1000-01-01', 0, 2000006, '',        '',        '', true, 3010101, '小美莓', 'Blueberry Soda',''),

      (2100033, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_d.png', true, 3010101, '鸡肉十分脆', 'German BBQ Chicken Sandwich','滚揉腌制的鲜嫩鸡肉，遇到粮手抓独家“十分脆”酱料，满满芝麻焦香，更有拿破仑松脆饼皮，多层口感，一口入魂。'),
      (2100034, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_d.png', true, 3010101, '叉烧拿破仑', 'Roast Pork Mille-feuille','法式经典甜品拿破仑，有千层酥皮之意，粮手抓拿破仑同样松化酥脆，层次丰盈，内里蜜汁叉烧，肉香缠绕，畅享口腹之欲。'),

      (2100035, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',     'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', true, 3010101, '菌菇三鲜脆饺', 'Mushroom Dumplings','内馅精选猪腿肉，搭配杏鲍菇、茶树菇，饺皮是国内目前最薄面皮之一，皮馅比极高，真正皮薄馅大。用铜板煎制金黄焦脆，喷香诱人。'),
      (2100036, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',     'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', true, 3010101, '猪肉玉米脆饺', 'Pork  and Corn Dumplings','肥瘦均匀肉馅，搭配鲜甜玉米，鲜香爽口，薄韧劲道的小麦粉面皮，包裹满满内馅，煎至酥黄，既薄边足馅，又外脆里嫩。'),

      (2100037, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', true, 3010101, '时蔬蛋炒饭', 'Veggie Fried Rice','蛋香味与时令蔬菜鲜甜融合，大块蛋粒分量十足，让你感受家一样真材实料，色彩搭配令人食欲大开，口感松软，更显家常美味。'),
      (2100038, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', true, 3010101, '(炒饭)德式烤鸡肉味', 'German BBQ Chicken Fried Rice','德式烤肉保持肉质汁香浓厚，猛火翻炒，使搭配蔬菜迸发独有脆爽，大块蛋粒搭配东北稻花香米饭，焦香喷鼻，略带韧性有回甘。'),
      (2100039, now(), now(), '1000-01-01', 0, 2000009, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', true, 3010101, '(饭)德式烤鸡肉味', 'German BBQ Chicken Rice ','由十多种香料调制的拌饭酱汁，搭配稻花香米饭，嫩滑有嚼劲。筋糯米粒+德式烤肉+蒸烤蔬菜，汁香过瘾，食欲大开。'),
      (2100040, now(), now(), '1000-01-01', 0, 2000009, '',        '',        '', true, 3010101, '麻辣香锅鸡肉饭', 'Sichuan Spicy Chicken Rice',''),
      (2100041, now(), now(), '1000-01-01', 0, 2000009, '',        '',        '', true, 3010101, '果木鸭肉饭',   'Beking Duck Rice',''),


      (2100042, now(), now(), '1000-01-01', 0, 2000010, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', true, 3010101, '松茸菌菇汤', 'Mushroom Truffle Soup','精选云南松茸、虎掌菌、七彩菌、雪茸菌四种野生菌菇，菌肉肥厚，质地细腻，文火熬制80min，入口即感受到来自大自然的至鲜之味。'),
      (2100043, now(), now(), '1000-01-01', 0, 2000010, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', true, 3010101, '莲藕排骨汤', 'Lotus Root and Pork Rib Soup','冬季时令汤品，熬至汤汁香浓，莲藕软糯，搭配清甜莲子，爽口不腻，肉的鲜+藕的甜，温润滋补，营养首选。'),

      (2100044, now(), now(), '1000-01-01', 0, 2000011, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',            'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', true, 3010101, '黑沙流心酥', 'Black Sesame Pastry','流沙酥表皮千层金黄脆皮，内馅是黑沙流心，带有芝麻的醇香。清脆起酥的表皮与浓厚软滑的芝麻流心，相得益彰，入口香甜不腻人。'),
      (2100045, now(), now(), '1000-01-01', 0, 2000011, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                 'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', true, 3010101, 'QQ哒', 'Icy Pudding','甜心芒果+烈焰草莓+清新香草，畅享三种口味糯米滋，浓郁椰蓉丝，柔糯饼皮，绵冰雪滋心，三层口感带来奇妙滋味。'),
      (2100046, now(), now(), '1000-01-01', 0, 2000011, 'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',             'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',             'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png', true, 3010101, '鸡蛋十分脆', 'Egg Sandwich','')
;

TRUNCATE TABLE `ctr_commodity`;
INSERT INTO `ctr_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`status`,`img_icon`,`img_mini`,`img_face`,`name`)
VALUES(2300001, now(), now(), '1000-01-01', 0, 2100001, 2530103, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',                'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',         'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', '(卷饼)酸辣土豆丝'),
      (2300002, now(), now(), '1000-01-01', 0, 2100002, 2530103, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png',             'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', '(卷饼)德式烤鸡肉'),
      (2300003, now(), now(), '1000-01-01', 0, 2100003, 2530103, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',               'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',             'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', '(卷饼)叉烧'),
      (2300004, now(), now(), '1000-01-01', 0, 2100004, 2530103, '',               '',             '', '蟹柳芝士卷'),
      (2300005, now(), now(), '1000-01-01', 0, 2100005, 2530103, '',               '',             '', '酸菜肥牛卷'),
      (2300006, now(), now(), '1000-01-01', 0, 2100006, 2530103, '',               '',             '', '麻辣香锅鸡卷'),
      (2300007, now(), now(), '1000-01-01', 0, 2100007, 2530103, '',               '',             '', '果木鸭肉卷'),
      (2300008, now(), now(), '1000-01-01', 0, 2100008, 2530103, '',               '',             '', '芝士牛肉肠卷'),

      (2300009, now(), now(), '1000-01-01', 0, 2100009, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',       'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', '酸辣土豆丝蛋饼'),
      (2300010, now(), now(), '1000-01-01', 0, 2100010, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', '(蛋饼)德式烤鸡肉味'),
      (2300011, now(), now(), '1000-01-01', 0, 2100011, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',           'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', '叉烧蛋饼'),
      (2300012, now(), now(), '1000-01-01', 0, 2100012, 2530103, '',               '',               '', '蟹柳芝士蛋饼'),
      (2300013, now(), now(), '1000-01-01', 0, 2100013, 2530103, '',               '',             '',   '酸菜肥牛蛋饼'),
      (2300014, now(), now(), '1000-01-01', 0, 2100014, 2530103, '',               '',             '',   '麻辣香锅鸡蛋饼'),
      (2300015, now(), now(), '1000-01-01', 0, 2100015, 2530103, '',               '',             '',   '果木鸭肉蛋饼'),
      (2300016, now(), now(), '1000-01-01', 0, 2100016, 2530103, '',               '',               '', '芝士牛肉肠蛋饼'),

      (2300017, now(), now(), '1000-01-01', 0, 2100017, 2530103, '',               '',             '', '(Tacco)酸辣土豆丝'),
      (2300018, now(), now(), '1000-01-01', 0, 2100018, 2530103, '',               '',             '', '(Tacco)德式烤鸡肉'),
      (2300019, now(), now(), '1000-01-01', 0, 2100019, 2530103, '',               '',             '', '(Tacco)叉烧卷'),
      (2300020, now(), now(), '1000-01-01', 0, 2100020, 2530103, '',               '',             '', '(Tacco)蟹柳芝士'),
      (2300021, now(), now(), '1000-01-01', 0, 2100021, 2530103, '',               '',             '', '(Tacco)酸菜肥牛'),
      (2300022, now(), now(), '1000-01-01', 0, 2100022, 2530103, '',               '',             '', '(Tacco)麻辣香锅鸡'),
      (2300023, now(), now(), '1000-01-01', 0, 2100023, 2530103, '',               '',             '', '(Tacco)果木鸭肉卷'),
      (2300024, now(), now(), '1000-01-01', 0, 2100024, 2530103, '',               '',             '', '(Tacco)芝士牛肉肠'),

      (2300025, now(), now(), '1000-01-01', 0, 2100025, 2530103, '',               '',             '', '(薄脆)黑松露鸭肉'),
      (2300026, now(), now(), '1000-01-01', 0, 2100026, 2530103, '',               '',             '', '(薄脆)麻辣香锅烤鸡'),

      (2300027, now(), now(), '1000-01-01', 0, 2100027, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',               'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', '原味豆浆'),
      (2300028, now(), now(), '1000-01-01', 0, 2100028, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',               'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', '原味米浆'),
      (2300029, now(), now(), '1000-01-01', 0, 2100029, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', '玫瑰乌龙'),
      (2300030, now(), now(), '1000-01-01', 0, 2100030, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                      'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', '港式奶茶'),

      (2300031, now(), now(), '1000-01-01', 0, 2100031, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',               'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',             'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_d.png', '小桃汽'),
      (2300032, now(), now(), '1000-01-01', 0, 2100032, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png',               'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png',             'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', '小美莓'),

      (2300033, now(), now(), '1000-01-01', 0, 2100033, 2530103, 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_d.png', '鸡肉十分脆'),
      (2300034, now(), now(), '1000-01-01', 0, 2100034, 2530103, 'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',       'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_d.png', '叉烧拿破仑'),

      (2300035, now(), now(), '1000-01-01', 0, 2100035, 2530103, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',          'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', '菌菇三鲜脆饺'),
      (2300036, now(), now(), '1000-01-01', 0, 2100036, 2530103, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',          'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', '猪肉玉米脆饺'),

      (2300037, now(), now(), '1000-01-01', 0, 2100037, 2530103, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',                 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', '时蔬蛋炒饭'),
      (2300038, now(), now(), '1000-01-01', 0, 2100038, 2530103, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', '(炒饭)德式烤鸡肉味'),
      (2300039, now(), now(), '1000-01-01', 0, 2100039, 2530103, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',            'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', '(饭)德式烤鸡肉味'),
      (2300040, now(), now(), '1000-01-01', 0, 2100040, 2530103, 'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_b.png',               'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_b.png',             'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_d.png', '麻辣香锅鸡肉饭'),
      (2300041, now(), now(), '1000-01-01', 0, 2100041, 2530103, 'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',               'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',             'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_d.png', '果木鸭肉饭'),

      (2300042, now(), now(), '1000-01-01', 0, 2100042, 2530103, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',                 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', '松茸菌菇汤'),
      (2300043, now(), now(), '1000-01-01', 0, 2100043, 2530103, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',         'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', '莲藕排骨汤'),

      (2300044, now(), now(), '1000-01-01', 0, 2100044, 2530103, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',               'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', '黑沙流心酥'),
      (2300045, now(), now(), '1000-01-01', 0, 2100045, 2530103, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                    'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', 'QQ哒'),

      -- 非建议显示商品
      (2300046, now(), now(), '1000-01-01', 0, 2100046, 2530103, 'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',             'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',                'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png', '鸡蛋十分脆'),
      (2300047, now(), now(), '1000-01-01', 0, 2100002, 2530103, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRoll_mn.png',  'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRoll_mn.png',     'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRoll_mn.png', '(卷饼半份)德式烤鸡肉味')
;

TRUNCATE TABLE `ctr_proposal`;
INSERT INTO `ctr_proposal`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`img_icon`,`img_mini`,`img_face`,`timezone`,`open_ldt`,`shut_ldt`,`price_list`,`price_sell`,`price_rule`,`status`,`ranking`,`sell_time`,`name`,`alias`,`desc`)
VALUES(3300001, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',                'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  1, '1200106', '(卷饼)酸辣土豆丝', 'Hot & Sour Potato Crispy Roll','经典酸辣的川菜风味，爽口开胃，土豆丝根根分明脆而不生，滑而不腻，搭配严格把控40s煎制的饼皮，使酥脆口感x2。'),
      (3300002, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png',             'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',   'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  2, '1200106', '(卷饼)德式烤鸡肉', 'German BBQ Chicken Crispy Roll','采用进口德式工艺烤肉机，45min猛火炙烤，现烤先削，美味更直接！烤前秘制酱料腌制入味，使恰到好处的肉汁在口中迸发美味。'),
      (3300003, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',               'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',          'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  3, '1200106', '(卷饼)叉烧', 'Chinese BBQ Pork Crispy Roll','选用整块腌制猪颈肉，肥瘦均衡，鲜甜多汁，配以秘制的酸甜酱，搭配爽口紫甘蓝和洋葱，口感鲜脆、刺激食欲。'),
      (3300004, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/CrabCheeseWasabe_b.png',     'http://static.lianglife.com/Menu_Product/Roll/CrabCheeseWasabe_b.png',    'http://static.lianglife.com/Menu_Product/Roll/CrabCheeseWasabe_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  4, '1200106', '蟹柳芝士卷', 'Crab Cheese Crispy Roll','泰国进口蟹柳，低脂高营养，嫩甜Q弹，与芝士浓香交映，海苔肉松搭配，更加满满鲜味。'),
      (3300005, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/SichuanBeefPickledVeggie_b.png',     'http://static.lianglife.com/Menu_Product/Roll/SichuanBeefPickledVeggie_b.png',    'http://static.lianglife.com/Menu_Product/Roll/SichuanBeefPickledVeggie_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  5, '1200106', '酸菜肥牛卷', 'Beef Pickled Veggie Crispy Roll','精挑雪花肥牛，搭配老卤腌制的酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁。'),
      (3300006, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/SpicyChickenRoll_b.png',     'http://static.lianglife.com/Menu_Product/Roll/SpicyChickenRoll_b.png',    'http://static.lianglife.com/Menu_Product/Roll/SpicyChickenRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  6, '1200106', '麻辣香锅鸡卷', 'Sichuan Spicy Chicken Crispy Roll','经12小时腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！'),
      (3300007, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/PekingDuckCrispyRoll_b.png',     'http://static.lianglife.com/Menu_Product/Roll/PekingDuckCrispyRoll_b.png',    'http://static.lianglife.com/Menu_Product/Roll/PekingDuckCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  7, '1200106', '果木鸭肉卷', 'Peking Duck Crispy Roll','采用秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味。'),
      (3300008, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/CheeseBeefSausageCrispyRoll_b.png',     'http://static.lianglife.com/Menu_Product/Roll/CheeseBeefSausageCrispyRoll_b.png',    'http://static.lianglife.com/Menu_Product/Roll/CheeseBeefSausageCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  8, '1200106', '芝士牛肉肠卷', 'Cheese Beef Sausage Crispy Roll','低脂牛肉制肠，肉质细嫩，与浓香芝士结合，搭配鲜灵蔬菜，体验舌尖上的鲜香爽滑。'),

      (3300009, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  9, '1200106', '酸辣土豆丝蛋饼', 'Hot & Sour Potato Omelette','经典酸辣的川菜风味，爽口开胃，健康超薄的粗粮蛋饼皮，搭配爽口蔬菜，少油+薄韧+酸爽，满满过瘾回味。'),
      (3300010, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  10, '1200106', '(蛋饼)德式烤鸡肉味', 'German BBQ Chicken Omelette','精选低脂带皮去骨鸡腿肉，反复滚揉入味，德式工艺45min猛火炙烤，保持肉质原有鲜香同时，更加肉汁丰盈。'),
      (3300011, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  11, '1200106', '叉烧蛋饼', 'Roast Pork Omelette','选用整块腌制猪颈肉，肥瘦均衡，秘制酸甜酱，搭配脆爽紫甘蓝，粗粮蛋饼皮搭配，软嫩多汁同时，碰撞鲜甜滋味。'),
      (3300012, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/CrabCheeseOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/CrabCheeseOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/CrabCheeseOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  12, '1200106', '蟹柳芝士蛋饼',  'Crab Cheese Omelettes','泰国进口蟹柳，低脂高营养，嫩甜Q弹，与芝士浓香交映，海苔肉松搭配，更加满满鲜味。'),
      (3300013, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/BeefPickledVeggieOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/BeefPickledVeggieOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/BeefPickledVeggieOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  13, '1200106', '酸菜肥牛蛋饼',  'Beef Pickled Veggie Omelettes','精挑雪花肥牛，搭配老卤腌制的酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁。'),
      (3300014, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/SpicyChickenOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/SpicyChickenOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/SpicyChickenOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  14, '1200106', '麻辣香锅鸡蛋饼', 'Sichuan Spicy Chicken Omelettes','经12小时腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！'),
      (3300015, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  15, '1200106', '果木鸭肉蛋饼',  'Peking Duck Crispy Omelettes','采用秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味。'),
      (3300016, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/CheeseBeefSausageOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/CheeseBeefSausageOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/CheeseBeefSausageOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  16, '1200106', '芝士牛肉肠蛋饼', 'Cheese Beef Sausage Omelettes','低脂牛肉制肠，肉质细嫩，与浓香芝士结合，搭配鲜灵蔬菜，体验舌尖上的鲜香爽滑。'),

      (3300017, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  17, '1200106', '(Tacco)酸辣土豆丝', 'Hot & Sour Potato Tacco',        '经典酸辣风味，爽口开胃，土豆丝脆而不生，搭配新鲜蔬菜，满满过瘾回味！'),
      (3300018, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  18, '1200106', '(Tacco)德式烤鸡肉', 'German BBQ Chicken Tacco',       '低脂去骨鸡腿肉，12小时腌制+德式猛火炙烤，肉质鲜香同时，汁香更过瘾！'),
      (3300019, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  19, '1200106', '(Tacco)叉烧卷', 'Chinese BBQ Pork Tacco',            '精选猪颈肉，精心腌制，高温烘焙至肉汁丰盈，搭配脆爽紫甘蓝，酥嫩同时碰撞鲜甜滋味。'),
      (3300020, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  20, '1200106', '(Tacco)蟹柳芝士', 'Crab Cheese Tacco',                '泰国进口蟹柳，低脂高营养，嫩甜Q弹，与芝士浓香交映，海苔肉松搭配，更加满满鲜味。'),
      (3300021, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  21, '1200106', '(Tacco)酸菜肥牛',  'Beef Pickled Veggie Tacco',       '精挑雪花肥牛，搭配老卤腌制的酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁。'),
      (3300022, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  22, '1200106', '(Tacco)麻辣香锅鸡', 'Sichuan Spicy Chicken Tacco',    '经12小时腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！'),
      (3300023, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  23, '1200106', '(Tacco)果木鸭肉卷', 'Peking Duck Tacco',              '采用秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味。'),
      (3300024, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',     'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',    'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  24, '1200106', '(Tacco)芝士牛肉肠', 'Cheese Beef Sausage Tacco',      '低脂牛肉制肠，肉质细嫩，与浓香芝士结合，搭配鲜灵蔬菜，体验舌尖上的鲜香爽滑。'),

      (3300025, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Papad/TruffleDuckPapad_b.png',     'http://static.lianglife.com/Menu_Product/Papad/TruffleDuckPapad_b.png',    'http://static.lianglife.com/Menu_Product/Papad/TruffleDuckPapad_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  25, '1200106', '(薄脆)黑松露鸭肉',  'Truffle duck Papad','“世界三大珍肴”之一黑松露，至鲜之味遇上酥香烤鸭，鲜香过瘾更营养！'),
      (3300026, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Papad/SpicyChickenPapad_b.png',     'http://static.lianglife.com/Menu_Product/Papad/SpicyChickenPapad_b.png',    'http://static.lianglife.com/Menu_Product/Papad/SpicyChickenPapad_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  26, '1200106', '(薄脆)麻辣香锅烤鸡', 'Sichuan Spicy Chicken Papad','巴蜀风味，麻辣鲜香的烤肉汁水丰盈，搭配焦香薄脆饼皮，美味停不下来！'),

      (3300027, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  27, '1200106', '原味豆浆', 'Soya Bean Original','精选优质大豆，颗颗饱满，豆味浓郁。采用先进制浆工艺，脱腥去渣，保留大豆原香。入口浓郁醇厚不甜腻，细腻顺滑。'),
      (3300028, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  28, '1200106', '原味米浆', 'Rice Milk Original','健康谷物大米，冬日温暖饮品，浓郁香醇，香、甜、浓，甘甜不腻，入喉丝滑，满口米香回味。'),
      (3300029, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  29, '1200106', '玫瑰乌龙', 'Rose Oolong Tea','精选食用级重瓣玫瑰，经工艺处理，以净花瓣付窨。搭配台湾洞顶乌龙茶汤，花香茶香呼应，齿颊留香，回味甘鲜。'),
      (3300030, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 30, '1200106', '港式奶茶', 'HK Style Milk Tea','采用斯里兰卡进口红茶，这里出产的红茶香味浓郁，带花香，且涩味少。经撞茶工序，保留茶叶的浓厚，口感爽滑，延绵细密。'),

      (3300031, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',     'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',    'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  31, '1200106', '小桃汽', 'Peach Soda','优选7-8月阳山水蜜桃，浓郁果味碰撞苏打气泡水，层层爆破果香。'),
      (3300032, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  32, '1200106', '小美莓', 'Blueberry Soda','优质蓝莓浆果，果味足且香气浓郁，遇到细腻气泡，清甜饱满，细腻爽口。'),

      (3300033, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 33, '1200101', '鸡肉十分脆', 'German BBQ Chicken Sandwich','滚揉腌制的鲜嫩鸡肉，遇到粮手抓独家“十分脆”酱料，满满芝麻焦香，更有拿破仑松脆饼皮，多层口感，一口入魂。'),
      (3300034, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 34, '1200101', '叉烧拿破仑', 'Roast Pork Mille-feuille','法式经典甜品拿破仑，有千层酥皮之意，粮手抓拿破仑同样松化酥脆，层次丰盈，内里蜜汁叉烧，肉香缠绕，畅享口腹之欲。'),
      (3300035, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',       'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 35, '1200101', '菌菇三鲜脆饺', 'Mushroom Dumplings','内馅精选猪腿肉，搭配杏鲍菇、茶树菇，饺皮是国内目前最薄面皮之一，皮馅比极高，真正皮薄馅大。用铜板煎制金黄焦脆，喷香诱人。'),
      (3300036, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',       'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 36, '1200101', '猪肉玉米脆饺', 'Pork  and Corn Dumplings','肥瘦均匀肉馅，搭配鲜甜玉米，鲜香爽口，薄韧劲道的小麦粉面皮，包裹满满内馅，煎至酥黄，既薄边足馅，又外脆里嫩。'),
      (3300037, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 37, '1200102,1200104', '时蔬蛋炒饭', 'Veggie Fried Rice','蛋香味与时令蔬菜鲜甜融合，大块蛋粒分量十足，让你感受家一样真材实料，色彩搭配令人食欲大开，口感松软，更显家常美味。'),
      (3300038, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 38, '1200102,1200104', '(炒饭)德式烤鸡肉味', 'German BBQ Chicken Fried Rice','由十多种香料调制的拌饭酱汁，搭配稻花香米饭，嫩滑有嚼劲。筋糯米粒+德式烤肉+蒸烤蔬菜，汁香过瘾，食欲大开。'),
      (3300039, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 39, '1200102,1200104', '(饭)德式烤鸡肉味', 'German BBQ Chicken Rice ','由十多种香料调制的拌饭酱汁，搭配稻花香米饭，嫩滑有嚼劲。筋糯米粒+德式烤肉+蒸烤蔬菜，汁香过瘾，食欲大开。'),

      (3300040, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_b.png',     'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  40, '1200102,1200104', '麻辣香锅鸡肉饭', 'Sichuan Spicy Chicken Rice','选用低脂鲜嫩鸡腿肉，结合川渝风味，鲜麻香爽更下饭，搭配稻花香米饭，略带韧性有回甘。'),
      (3300041, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',     'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  41, '1200102,1200104', '果木鸭肉饭', 'Beking Duck Rice','烟熏香味遇上果木清香，香型浓郁清新，搭配筋糯米粒与秘制拌饭汁，喷香撩拨心鼻。'),

      (3300042, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 42, '1200102,1200104', '松茸菌菇汤', 'Mushroom Truffle Soup','精选云南松茸、虎掌菌、七彩菌、雪茸菌四种野生菌菇，菌肉肥厚，质地细腻，文火熬制80min，入口即感受到来自大自然的至鲜之味。'),
      (3300043, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 43, '1200102,1200104', '莲藕排骨汤', 'Lotus Root and Pork Rib Soup','冬季时令汤品，熬至汤汁香浓，莲藕软糯，搭配清甜莲子，爽口不腻，肉的鲜+藕的甜，温润滋补，营养首选。'),
      (3300044, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',            'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 44, '1200103', '黑沙流心酥', 'Black Sesame Puff','流沙酥表皮千层金黄脆皮，内馅是黑沙流心，带有芝麻的醇香。清脆起酥的表皮与浓厚软滑的芝麻流心，相得益彰，入口香甜不腻人。'),
      (3300045, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                 'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 45, '1200103', 'QQ哒', 'Icy Pudding','甜心芒果+烈焰草莓+清新香草，畅享三种口味糯米滋，浓郁椰蓉丝，柔糯饼皮，绵冰雪滋心，三层口感带来奇妙滋味。'),

      -- 套餐1
      (3300046, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/miniGermanBBQChickenCrispyRollMeal_b.png',    'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/miniGermanBBQChickenCrispyRollMeal_b.png', 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/miniGermanBBQChickenCrispyRollMeal_d.png', 10100, '2019-10-1', '2029-10-1', 10, 10, 3510202, 3510101, 46, '1200101', '(卷饼套餐)德式烤鸡肉', 'German BBQ Chicken Crispy Roll Meal',''),
      -- 套餐2
      (3300047, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/EggSandwichMeal_b.png',                       'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/EggSandwichMeal_b.png',                    'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/EggSandwichMeal_d.png', 10100, '2019-10-1', '2029-10-1', 12, 12, 3510202, 3510101, 47, '1200101', '鸡蛋十分脆拿破仑套餐', 'Egg Sandwich Meal',''),
      -- 套餐3
      (3300048, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/RoastPorkOmelettes_b.png',                    'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/RoastPorkOmelettes_b.png',                 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/RoastPorkOmelettes_b.png', 10100, '2019-10-1', '2029-10-1', 14, 14, 3510202, 3510101, 48, '1200101', '叉烧蛋饼套餐', 'Roast Pork Omelettes Meal',''),
      -- 套餐4
      (3300049, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/SpicyChickenRice_b.png',                 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/SpicyChickenRice_b.png',              'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/SpicyChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 28, 28, 3510202, 3510101, 49, '1200102,1200104', '(饭套餐)麻辣香锅鸡肉', 'Sichuan Spicy Chicken Rice Meal',''),
      -- 套餐5
      (3300050, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRiceMeal_b.png',         'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRiceMeal_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRiceMeal_d.png', 10100, '2019-10-1', '2029-10-1', 28, 28, 3510202, 3510101, 50, '1200102,1200104', '德式烤鸡肉饭套餐', 'German BBQ Chicken Fried Rice Meal',''),
      -- 套餐6
      (3300051, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/PekingDuckRice_b.png',                   'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/PekingDuckRice_b.png',                'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/PekingDuckRice_d.png', 10100, '2019-10-1', '2029-10-1', 28, 28, 3510202, 3510101, 51, '1200102,1200104', '果木鸭肉饭套餐', 'Peking Duck Rice Meal',''),
      -- 套餐7
      (3300052, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/BlackSesamePuffSVM_b.png',                 'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/BlackSesamePuffSVM_b.png',              'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/BlackSesamePuffSVM_d.png', 10100, '2019-10-1', '2029-10-1', 16, 16, 3510202, 3510101, 52, '1200103', '黑沙流心酥套餐', 'Black Sesame Pastry Meal',''),
      -- 套餐8
      (3300053, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/IcyPuddingMeal_b.png',                     'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/IcyPuddingMeal_b.png',                  'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/IcyPuddingMeal_d.png', 10100, '2019-10-1', '2029-10-1', 16, 16, 3510202, 3510101, 53, '1200103', 'QQ哒套餐', 'Icy Pudding Meal','')
;

TRUNCATE TABLE `ctr_proposal_commodity`;
INSERT INTO `ctr_proposal_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`bundle_id`,`product_id`,`commodity_id`,`price_list`,`price_sell`,`buy_min`,`buy_max`,`show_price`,`selected`,`ranking`,`name`)
      -- 单品数据
VALUES(3500001, now(), now(), '1000-01-01', 0, 3300001 ,0, 2100001, 2300001, 12, 12, 1, 1, true, true, 1, '(卷饼)酸辣土豆丝'),
      (3500002, now(), now(), '1000-01-01', 0, 3300002 ,0, 2100002, 2300002, 18, 18, 1, 1, true, true, 2, '(卷饼)德式烤鸡肉'),
      (3500003, now(), now(), '1000-01-01', 0, 3300003 ,0, 2100003, 2300003, 20, 20, 1, 1, true, true, 3, '(卷饼)叉烧'),
      (3500004, now(), now(), '1000-01-01', 0, 3300004 ,0, 2100004, 2300004, 20, 20, 1, 1, true, true, 4, '蟹柳芝士卷'),
      (3500005, now(), now(), '1000-01-01', 0, 3300005 ,0, 2100005, 2300005, 20, 20, 1, 1, true, true, 5, '酸菜肥牛卷'),
      (3500006, now(), now(), '1000-01-01', 0, 3300006 ,0, 2100006, 2300006, 18, 18, 1, 1, true, true, 6, '麻辣香锅鸡卷'),
      (3500007, now(), now(), '1000-01-01', 0, 3300007 ,0, 2100007, 2300007, 18, 18, 1, 1, true, true,  7, '果木鸭肉卷'),
      (3500008, now(), now(), '1000-01-01', 0, 3300008 ,0, 2100008, 2300008, 16, 16, 1, 1, true, true,  8, '芝士牛肉肠卷'),
      (3500009, now(), now(), '1000-01-01', 0, 3300009 ,0, 2100009, 2300009, 12, 12, 1, 1, true, true, 9,  '酸辣土豆丝蛋饼'),
      (3500010, now(), now(), '1000-01-01', 0, 3300010 ,0, 2100010, 2300010, 18, 18, 1, 1, true, true, 10, '德式烤鸡肉蛋饼'),
      (3500011, now(), now(), '1000-01-01', 0, 3300011 ,0, 2100011, 2300011, 20, 20, 1, 1, true, true, 11, '叉烧蛋饼'),
      (3500012, now(), now(), '1000-01-01', 0, 3300012 ,0, 2100012, 2300012, 20, 20, 1, 1, true, true, 12, '蟹柳芝士蛋饼'),
      (3500013, now(), now(), '1000-01-01', 0, 3300013 ,0, 2100013, 2300013, 20, 20, 1, 1, true, true, 13, '酸菜肥牛蛋饼'),
      (3500014, now(), now(), '1000-01-01', 0, 3300014 ,0, 2100014, 2300014, 18, 18, 1, 1, true, true, 14, '麻辣香锅鸡蛋饼 '),
      (3500015, now(), now(), '1000-01-01', 0, 3300015 ,0, 2100015, 2300015, 18, 18, 1, 1, true, true, 15, '果木鸭肉蛋饼'),
      (3500016, now(), now(), '1000-01-01', 0, 3300016 ,0, 2100016, 2300016, 16, 16, 1, 1, true, true, 16, '芝士牛肉肠蛋饼'),

      (3500017, now(), now(), '1000-01-01', 0, 3300017 ,0, 2100017, 2300017, 12, 12, 1, 1, true, true, 17, '(Tacco)酸辣土豆丝'),
      (3500018, now(), now(), '1000-01-01', 0, 3300018 ,0, 2100018, 2300018, 18, 18, 1, 1, true, true, 18, '(Tacco)德式烤鸡肉蛋饼'),
      (3500019, now(), now(), '1000-01-01', 0, 3300019 ,0, 2100019, 2300019, 20, 20, 1, 1, true, true, 19, '(Tacco)叉烧卷'),
      (3500020, now(), now(), '1000-01-01', 0, 3300020 ,0, 2100020, 2300020, 20, 20, 1, 1, true, true, 20, '(Tacco)蟹柳芝士'),
      (3500021, now(), now(), '1000-01-01', 0, 3300021 ,0, 2100021, 2300021, 20, 20, 1, 1, true, true, 21, '(Tacco)酸菜肥牛'),
      (3500022, now(), now(), '1000-01-01', 0, 3300022 ,0, 2100022, 2300022, 18, 18, 1, 1, true, true,22,  '(Tacco)麻辣香锅鸡'),
      (3500023, now(), now(), '1000-01-01', 0, 3300023 ,0, 2100023, 2300023, 18, 18, 1, 1, true, true,23,  '(Tacco)果木鸭肉卷'),
      (3500024, now(), now(), '1000-01-01', 0, 3300024 ,0, 2100024, 2300024, 16, 16, 1, 1, true, true, 24, '(Tacco)芝士牛肉肠'),

      (3500025, now(), now(), '1000-01-01', 0, 3300025 ,0, 2100025, 2300025, 22, 22, 1, 1, true, true, 25, '(薄脆)黑松露鸭肉'),
      (3500026, now(), now(), '1000-01-01', 0, 3300026 ,0, 2100026, 2300026, 20, 20, 1, 1, true, true, 26, '(薄脆)麻辣香锅烤鸡'),
      (3500027, now(), now(), '1000-01-01', 0, 3300027 ,0, 2100027, 2300027, 6, 6, 1, 1, true, true,   27, '原味豆浆'),
      (3500028, now(), now(), '1000-01-01', 0, 3300028 ,0, 2100028, 2300028, 6, 6, 1, 1, true, true,   28, '原味米浆'),
      (3500029, now(), now(), '1000-01-01', 0, 3300029 ,0, 2100029, 2300029, 10, 10, 1, 1, true, true,  29, '玫瑰乌龙'),
      (3500030, now(), now(), '1000-01-01', 0, 3300030 ,0, 2100030, 2300030, 10, 10, 1, 1, true, true, 30, '港式奶茶'),
      (3500031, now(), now(), '1000-01-01', 0, 3300031 ,0, 2100031, 2300031, 16, 16, 1, 1, true, true, 31, '小桃汽'),
      (3500032, now(), now(), '1000-01-01', 0, 3300032 ,0, 2100032, 2300032, 16, 16, 1, 1, true, true, 32, '小美莓'),
      (3500033, now(), now(), '1000-01-01', 0, 3300033 ,0, 2100033, 2300033, 20, 20, 1, 1, true, true, 33, '鸡肉十分脆'),
      (3500034, now(), now(), '1000-01-01', 0, 3300034 ,0, 2100034, 2300034, 22, 22, 1, 1, true, true, 34, '叉烧拿破仑'),
      (3500035, now(), now(), '1000-01-01', 0, 3300035 ,0, 2100035, 2300035, 10, 10, 1, 1, true, true, 35, '菌菇三鲜脆饺'),
      (3500036, now(), now(), '1000-01-01', 0, 3300036 ,0, 2100036, 2300036, 10, 10, 1, 1, true, true, 36, '猪肉玉米脆饺'),
      (3500037, now(), now(), '1000-01-01', 0, 3300037 ,0, 2100037, 2300037, 16, 16, 1, 1, true, true, 37, '时蔬蛋炒饭'),
      (3500038, now(), now(), '1000-01-01', 0, 3300038 ,0, 2100038, 2300038, 24, 24, 1, 1, true, true, 38, '德式烤鸡肉蛋炒饭'),
      (3500039, now(), now(), '1000-01-01', 0, 3300039 ,0, 2100039, 2300039, 26, 26, 1, 1, true, true, 39, '德式烤鸡肉饭'),
      (3500040, now(), now(), '1000-01-01', 0, 3300040 ,0, 2100040, 2300040, 26, 26, 1, 1, true, true, 40, '麻辣香锅鸡肉饭'),
      (3500041, now(), now(), '1000-01-01', 0, 3300041 ,0, 2100041, 2300041, 26, 26, 1, 1, true, true, 41, '果木鸭肉饭'),
      (3500042, now(), now(), '1000-01-01', 0, 3300042 ,0, 2100042, 2300042, 12, 12, 1, 1, true, true, 42, '松茸菌菇汤 '),
      (3500043, now(), now(), '1000-01-01', 0, 3300043 ,0, 2100043, 2300043, 16, 16, 1, 1, true, true, 43, '莲藕排骨汤'),
      (3500044, now(), now(), '1000-01-01', 0, 3300044 ,0, 2100044, 2300044, 10, 10, 1, 1, true, true, 44, '黑沙流心酥'),
      (3500045, now(), now(), '1000-01-01', 0, 3300045 ,0, 2100045, 2300045, 10, 10, 1, 1, true, true, 45, 'QQ哒'),

      -- 八个套餐数据

      -- 套餐1
      (3500046, now(), now(), '1000-01-01', 0, 3300046 ,3900001, 2100002, 2300047, 0, 0, 1, 1, true, true, 46, '德式烤鸡肉卷(半份)'),
      (3500047, now(), now(), '1000-01-01', 0, 3300046 ,3900002, 2100027, 2300027, 0, 0, 0, 1, true, false, 47, '原味豆浆'),
      (3500048, now(), now(), '1000-01-01', 0, 3300046 ,3900002, 2100028, 2300028, 0, 0, 0, 1, true, false, 48, '原味米浆'),

      -- 套餐2
      (3500049, now(), now(), '1000-01-01', 0, 3300047 ,3900003, 2100046, 2300046, 0, 0, 1, 1, true, true, 49, '鸡蛋十分脆'),
      (3500050, now(), now(), '1000-01-01', 0, 3300047 ,3900004, 2100027, 2300027, 0, 0, 0, 1, true, false, 50, '原味豆浆'),
      (3500051, now(), now(), '1000-01-01', 0, 3300047 ,3900004, 2100028, 2300028, 0, 0, 0, 1, true, false, 51, '原味米浆'),

      -- 套餐3
      (3500052, now(), now(), '1000-01-01', 0, 3300048 ,3900005, 2100011, 2300011, 0, 0, 0, 1, true, true, 52, '叉烧蛋饼'),
      (3500053, now(), now(), '1000-01-01', 0, 3300048 ,3900006, 2100027, 2300027, 0, 0, 0, 1, true, false, 53, '原味豆浆'),
      (3500054, now(), now(), '1000-01-01', 0, 3300048 ,3900006, 2100028, 2300028, 0, 0, 0, 1, true, false, 54, '原味米浆'),

      -- 套餐4
      (3500055, now(), now(), '1000-01-01', 0, 3300049 ,3900007, 2100040, 2300040, 0, 0, 1, 1, true, true, 55, '麻辣香锅鸡肉饭'),
      (3500056, now(), now(), '1000-01-01', 0, 3300049 ,3900007, 2100042, 2300042, 0, 0, 1, 1, true, true, 56, '松茸菌菇汤'),

      -- 套餐5
      (3500057, now(), now(), '1000-01-01', 0, 3300050 ,3900008, 2100039, 2300039, 0, 0, 1, 1, true, true, 57, '德式烤鸡肉饭'),
      (3500058, now(), now(), '1000-01-01', 0, 3300050 ,3900008, 2100042, 2300042, 0, 0, 1, 1, true, true, 58, '松茸菌菇汤'),

      -- 套餐6
      (3500059, now(), now(), '1000-01-01', 0, 3300051 ,3900009, 2100041, 2300041, 0, 0, 1, 1, true, true, 59, '果木鸭肉饭'),
      (3500060, now(), now(), '1000-01-01', 0, 3300051 ,3900009, 2100042, 2300042, 0, 0, 1, 1, true, true, 60, '松茸菌菇汤'),

      -- 套餐7
      (3500061, now(), now(), '1000-01-01', 0, 3300052 ,3900010, 2100044, 2300044, 0, 0, 1, 1, true, true,  61, '黑沙流心酥'),
      (3500062, now(), now(), '1000-01-01', 0, 3300052 ,3900011, 2100029, 2300029, 0, 0, 0, 1, true, false, 62, '玫瑰乌龙'),
      (3500063, now(), now(), '1000-01-01', 0, 3300052 ,3900011, 2100030, 2300030, 0, 0, 0, 1, true, false, 63, '港式奶茶'),
      -- 套餐8
      (3500064, now(), now(), '1000-01-01', 0, 3300053 ,3900012, 2100045, 2300045, 0, 0, 1, 1, true, true,  64, 'QQ哒'),
      (3500065, now(), now(), '1000-01-01', 0, 3300053 ,3900013, 2100029, 2300029, 0, 0, 0, 1, true, false, 65, '玫瑰乌龙'),
      (3500066, now(), now(), '1000-01-01', 0, 3300053 ,3900013, 2100030, 2300030, 0, 0, 0, 1, true, false, 66, '港式奶茶')
;

TRUNCATE TABLE `ctr_scenario_menu`;
INSERT INTO `ctr_scenario_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`name`,`img_icon`,`desc`,`visible`,`topmenu`,`ranking`)
VALUES(3700001, now(), now(), '1000-01-01', 0, 3100001, '早餐', 'http://static.lianglife.com/BroadSideIcon/breakfast.png', '', true, false, 1),
      (3700002, now(), now(), '1000-01-01', 0, 3100001, '套餐', 'http://static.lianglife.com/BroadSideIcon/comboMeal.png', '', true, false, 2),
      (3700003, now(), now(), '1000-01-01', 0, 3100001, '卷饼', 'http://static.lianglife.com/BroadSideIcon/crispyRoll.png', '', true, false, 3),
      (3700004, now(), now(), '1000-01-01', 0, 3100001, 'Tacco','http://static.lianglife.com/BroadSideIcon/crispCharge.png', '', true, false, 4),
      (3700005, now(), now(), '1000-01-01', 0, 3100001, '薄脆', 'http://static.lianglife.com/BroadSideIcon/singlePie.png', '', true, false, 5),
      (3700006, now(), now(), '1000-01-01', 0, 3100001, '饭',   'http://static.lianglife.com/BroadSideIcon/rice.png', '', true, false, 6),
      (3700007, now(), now(), '1000-01-01', 0, 3100001, '汤',   'http://static.lianglife.com/BroadSideIcon/soup.png', '', true, false, 7),
      (3700008, now(), now(), '1000-01-01', 0, 3100001, '饮品', 'http://static.lianglife.com/BroadSideIcon/hotDrinks.png', '', true, false, 8),
      (3700009, now(), now(), '1000-01-01', 0, 3100001, '点心',  'http://static.lianglife.com/BroadSideIcon/snack.png', '', true, false, 9)
;

TRUNCATE TABLE `ctr_proposal_menu`;
INSERT INTO `ctr_proposal_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`scenmenu_id`)
VALUES(3800001, now(), now(), '1000-01-01', 0, 3300001, 3700003),
      (3800002, now(), now(), '1000-01-01', 0, 3300002, 3700003),
      (3800003, now(), now(), '1000-01-01', 0, 3300003, 3700003),
      (3800004, now(), now(), '1000-01-01', 0, 3300004, 3700003),
      (3800005, now(), now(), '1000-01-01', 0, 3300005, 3700003),
      (3800006, now(), now(), '1000-01-01', 0, 3300006, 3700003),
      (3800007, now(), now(), '1000-01-01', 0, 3300007, 3700003),
      (3800008, now(), now(), '1000-01-01', 0, 3300008, 3700003),
      (3800009, now(), now(), '1000-01-01', 0, 3300009, 3700003),
      (3800010, now(), now(), '1000-01-01', 0, 3300010, 3700003),
      (3800011, now(), now(), '1000-01-01', 0, 3300011, 3700003),
      (3800012, now(), now(), '1000-01-01', 0, 3300012, 3700003),
      (3800013, now(), now(), '1000-01-01', 0, 3300013, 3700003),
      (3800014, now(), now(), '1000-01-01', 0, 3300014, 3700003),
      (3800015, now(), now(), '1000-01-01', 0, 3300015, 3700003),
      (3800016, now(), now(), '1000-01-01', 0, 3300016, 3700003),

      (3800017, now(), now(), '1000-01-01', 0, 3300017, 3700004),
      (3800018, now(), now(), '1000-01-01', 0, 3300018, 3700004),
      (3800019, now(), now(), '1000-01-01', 0, 3300019, 3700004),
      (3800020, now(), now(), '1000-01-01', 0, 3300020, 3700004),
      (3800021, now(), now(), '1000-01-01', 0, 3300021, 3700004),
      (3800022, now(), now(), '1000-01-01', 0, 3300022, 3700004),
      (3800023, now(), now(), '1000-01-01', 0, 3300023, 3700004),
      (3800024, now(), now(), '1000-01-01', 0, 3300024, 3700004),

      (3800025, now(), now(), '1000-01-01', 0, 3300025, 3700005),
      (3800026, now(), now(), '1000-01-01', 0, 3300026, 3700005),

      (3800027, now(), now(), '1000-01-01', 0, 3300027, 3700008),
      (3800028, now(), now(), '1000-01-01', 0, 3300028, 3700008),
      (3800029, now(), now(), '1000-01-01', 0, 3300029, 3700008),
      (3800030, now(), now(), '1000-01-01', 0, 3300030, 3700008),
      (3800031, now(), now(), '1000-01-01', 0, 3300031, 3700008),
      (3800032, now(), now(), '1000-01-01', 0, 3300032, 3700008),

      (3800033, now(), now(), '1000-01-01', 0, 3300033, 3700001),
      (3800034, now(), now(), '1000-01-01', 0, 3300034, 3700001),
      (3800035, now(), now(), '1000-01-01', 0, 3300035, 3700001),
      (3800036, now(), now(), '1000-01-01', 0, 3300036, 3700001),

      (3800037, now(), now(), '1000-01-01', 0, 3300037, 3700006),
      (3800038, now(), now(), '1000-01-01', 0, 3300038, 3700006),
      (3800039, now(), now(), '1000-01-01', 0, 3300039, 3700006),
      (3800040, now(), now(), '1000-01-01', 0, 3300040, 3700006),
      (3800041, now(), now(), '1000-01-01', 0, 3300041, 3700006),

      (3800042, now(), now(), '1000-01-01', 0, 3300042, 3700007),
      (3800043, now(), now(), '1000-01-01', 0, 3300043, 3700007),

      (3800044, now(), now(), '1000-01-01', 0, 3300044, 3700009),
      (3800045, now(), now(), '1000-01-01', 0, 3300045, 3700009),

      -- 八个套餐
      (3800046, now(), now(), '1000-01-01', 0, 3300046, 3700002),
      (3800047, now(), now(), '1000-01-01', 0, 3300047, 3700002),
      (3800048, now(), now(), '1000-01-01', 0, 3300048, 3700002),
      (3800049, now(), now(), '1000-01-01', 0, 3300049, 3700002),
      (3800050, now(), now(), '1000-01-01', 0, 3300050, 3700002),
      (3800051, now(), now(), '1000-01-01', 0, 3300051, 3700002),
      (3800052, now(), now(), '1000-01-01', 0, 3300052, 3700002),
      (3800053, now(), now(), '1000-01-01', 0, 3300053, 3700002)
;


TRUNCATE TABLE `ctr_proposal_bundle`;
INSERT INTO `ctr_proposal_bundle`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`name`,`buy_num`,`ranking`)
VALUES(3900001, now(), now(), '1000-01-01', 0, 3300046, '必选', 1, 1),
      (3900002, now(), now(), '1000-01-01', 0, 3300046, '饮品', 1, 2),

      (3900003, now(), now(), '1000-01-01', 0, 3300047, '必选', 1, 1),
      (3900004, now(), now(), '1000-01-01', 0, 3300047, '饮品', 1, 2),

      (3900005, now(), now(), '1000-01-01', 0, 3300048, '必选', 1, 1),
      (3900006, now(), now(), '1000-01-01', 0, 3300048, '饮品', 1, 2),

      (3900007, now(), now(), '1000-01-01', 0, 3300049, '必选', 1, 1),

      (3900008, now(), now(), '1000-01-01', 0, 3300050, '必选', 1, 1),

      (3900009, now(), now(), '1000-01-01', 0, 3300051, '必选', 1, 1),

      (3900010, now(), now(), '1000-01-01', 0, 3300052, '必选', 1, 1),
      (3900011, now(), now(), '1000-01-01', 0, 3300052, '饮品', 1, 2),

      (3900012, now(), now(), '1000-01-01', 0, 3300053, '必选', 1, 1),
      (3900013, now(), now(), '1000-01-01', 0, 3300053, '饮品', 1, 2)
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


TRUNCATE TABLE `ctr_account_balance`;
INSERT INTO `ctr_account_balance`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`account_id`,`money_type`,`currency`,`balance`,`credit`,`status`)
VALUES('0',now(), now(), '1000-01-01', 0, 0, 5510101, 'CNY', 0, 2147483647, 5520201),
      ('1',now(), now(), '1000-01-01', 0, 1, 5510101, 'CNY', 0, 2147483647, 5520201)
;

-- ok ,well done alex!
