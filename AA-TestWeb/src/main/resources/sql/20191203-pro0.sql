
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


INSERT INTO `ctr_product_category`(`id`,`parent_id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`)
VALUES(2000001, 0, now(), now(), '1000-01-01', 0, '脆饼卷', 3020102),
      (2000002, 0, now(), now(), '1000-01-01', 0, '蛋饼券', 3020102),
      (2000003, 0, now(), now(), '1000-01-01', 0, '热饮', 3020102),
      (2000004, 0, now(), now(), '1000-01-01', 0, '拿破仑', 3020102),
      (2000005, 0, now(), now(), '1000-01-01', 0, '脆饺', 3020102),
      (2000006, 0, now(), now(), '1000-01-01', 0, '饭', 3020102),
      (2000007, 0, now(), now(), '1000-01-01', 0, '汤', 3020102),
      (2000008, 0, now(), now(), '1000-01-01', 0, '点心', 3020102)
;

INSERT INTO `ctr_product`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`prodcate_id`,`img_icon`,`img_mini`,`img_face`,`send_out`,`status`,`name`,`alias`,`desc`)
VALUES(2100001, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',                'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', true, 3010101, '酸辣土豆丝卷', 'Hot & Sour Potato Crispy Roll','经典酸辣的川菜风味，爽口开胃，土豆丝根根分明脆而不生，滑而不腻，搭配严格把控40s煎制的饼皮，使酥脆口感x2。'),
      (2100002, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png',             'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',   'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', true, 3010101, '(卷)德式烤鸡肉味', 'German BBQ Chicken Crispy Roll','采用进口德式工艺烤肉机，45min猛火炙烤，现烤先削，美味更直接！烤前秘制酱料腌制入味，使恰到好处的肉汁在口中迸发美味。'),
      (2100003, now(), now(), '1000-01-01', 0, 2000001, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',               'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',          'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', true, 3010101, '叉烧卷', 'Roast Pork Crispy Roll','选用整块腌制猪颈肉，肥瘦均衡，鲜甜多汁，配以秘制的酸甜酱，搭配爽口紫甘蓝和洋葱，口感鲜脆、刺激食欲。'),
      (2100004, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', true, 3010101, '酸辣土豆丝蛋饼', 'Hot & Sour Potato Omelette','经典酸辣的川菜风味，爽口开胃，健康超薄的粗粮蛋饼皮，搭配爽口蔬菜，少油+薄韧+酸爽，满满过瘾回味。'),
      (2100005, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', true, 3010101, '(蛋饼)德式烤鸡肉味', 'German BBQ Chicken Omelette','精选低脂带皮去骨鸡腿肉，反复滚揉入味，德式工艺45min猛火炙烤，保持肉质原有鲜香同时，更加肉汁丰盈。'),
      (2100006, now(), now(), '1000-01-01', 0, 2000002, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', true, 3010101, '叉烧蛋饼', 'Roast Pork Omelette','选用整块腌制猪颈肉，肥瘦均衡，秘制酸甜酱，搭配脆爽紫甘蓝，粗粮蛋饼皮搭配，软嫩多汁同时，碰撞鲜甜滋味。'),
      (2100007, now(), now(), '1000-01-01', 0, 2000003, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', true, 3010101, '原味豆浆', 'Soya Bean Original','精选优质大豆，颗颗饱满，豆味浓郁。采用先进制浆工艺，脱腥去渣，保留大豆原香。入口浓郁醇厚不甜腻，细腻顺滑。'),
      (2100008, now(), now(), '1000-01-01', 0, 2000003, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', true, 3010101, '原味米浆', 'Rice Milk Original','健康谷物大米，冬日温暖饮品，浓郁香醇，香、甜、浓，甘甜不腻，入喉丝滑，满口米香回味。'),
      (2100009, now(), now(), '1000-01-01', 0, 2000003, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', true, 3010101, '玫瑰乌龙', 'Rose Oolong Tea','精选食用级重瓣玫瑰，经工艺处理，以净花瓣付窨。搭配台湾洞顶乌龙茶汤，花香茶香呼应，齿颊留香，回味甘鲜。'),
      (2100010, now(), now(), '1000-01-01', 0, 2000003, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', true, 3010101, '港式奶茶', 'HK Style Milk Tea','采用斯里兰卡进口红茶，这里出产的红茶香味浓郁，带花香，且涩味少。经撞茶工序，保留茶叶的浓厚，口感爽滑，延绵细密。'),
      (2100011, now(), now(), '1000-01-01', 0, 2000004, 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_d.png', true, 3010101, '鸡肉十分脆', 'German BBQ Chicken Sandwich','滚揉腌制的鲜嫩鸡肉，遇到粮手抓独家“十分脆”酱料，满满芝麻焦香，更有拿破仑松脆饼皮，多层口感，一口入魂。'),
      (2100012, now(), now(), '1000-01-01', 0, 2000004, 'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_d.png', true, 3010101, '叉烧拿破仑', 'Roast Pork Mille-feuille','法式经典甜品拿破仑，有千层酥皮之意，粮手抓拿破仑同样松化酥脆，层次丰盈，内里蜜汁叉烧，肉香缠绕，畅享口腹之欲。'),
      (2100013, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',     'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', true, 3010101, '菌菇三鲜脆饺', 'Mushroom Dumplings','内馅精选猪腿肉，搭配杏鲍菇、茶树菇，饺皮是国内目前最薄面皮之一，皮馅比极高，真正皮薄馅大。用铜板煎制金黄焦脆，喷香诱人。'),
      (2100014, now(), now(), '1000-01-01', 0, 2000005, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',     'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', true, 3010101, '猪肉玉米脆饺', 'Pork  and Corn Dumplings','肥瘦均匀肉馅，搭配鲜甜玉米，鲜香爽口，薄韧劲道的小麦粉面皮，包裹满满内馅，煎至酥黄，既薄边足馅，又外脆里嫩。'),
      (2100015, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', true, 3010101, '时蔬蛋炒饭', 'Veggie Fried Rice','蛋香味与时令蔬菜鲜甜融合，大块蛋粒分量十足，让你感受家一样真材实料，色彩搭配令人食欲大开，口感松软，更显家常美味。'),
      (2100016, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', true, 3010101, '(炒饭)德式烤鸡肉味', 'German BBQ Chicken Fried Rice','德式烤肉保持肉质汁香浓厚，猛火翻炒，使搭配蔬菜迸发独有脆爽，大块蛋粒搭配东北稻花香米饭，焦香喷鼻，略带韧性有回甘。'),
      (2100017, now(), now(), '1000-01-01', 0, 2000006, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', true, 3010101, '(饭)德式烤鸡肉味', 'German BBQ Chicken Rice ','由十多种香料调制的拌饭酱汁，搭配稻花香米饭，嫩滑有嚼劲。筋糯米粒+德式烤肉+蒸烤蔬菜，汁香过瘾，食欲大开。'),
      (2100018, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', true, 3010101, '松茸菌菇汤', 'Mushroom Truffle Soup','精选云南松茸、虎掌菌、七彩菌、雪茸菌四种野生菌菇，菌肉肥厚，质地细腻，文火熬制80min，入口即感受到来自大自然的至鲜之味。'),
      (2100019, now(), now(), '1000-01-01', 0, 2000007, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', true, 3010101, '莲藕排骨汤', 'Lotus Root and Pork Rib Soup','冬季时令汤品，熬至汤汁香浓，莲藕软糯，搭配清甜莲子，爽口不腻，肉的鲜+藕的甜，温润滋补，营养首选。'),
      (2100020, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',            'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', true, 3010101, '黑沙流心酥', 'Black Sesame Pastry','流沙酥表皮千层金黄脆皮，内馅是黑沙流心，带有芝麻的醇香。清脆起酥的表皮与浓厚软滑的芝麻流心，相得益彰，入口香甜不腻人。'),
      (2100021, now(), now(), '1000-01-01', 0, 2000008, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                 'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', true, 3010101, 'QQ哒', 'Icy Pudding','甜心芒果+烈焰草莓+清新香草，畅享三种口味糯米滋，浓郁椰蓉丝，柔糯饼皮，绵冰雪滋心，三层口感带来奇妙滋味。'),
      (2100022, now(), now(), '1000-01-01', 0, 2000004, 'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',             'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',             'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png', true, 3010101, '鸡蛋十分脆', 'Egg Sandwich','')
;

INSERT INTO `ctr_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`status`,`img_icon`,`img_mini`,`img_face`,`name`)
VALUES(2300001, now(), now(), '1000-01-01', 0, 2100001, 2530103, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',                'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',         'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', '酸辣土豆丝卷'),
      (2300002, now(), now(), '1000-01-01', 0, 2100002, 2530103, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png',             'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', '(卷)德式烤鸡肉味'),
      (2300003, now(), now(), '1000-01-01', 0, 2100003, 2530103, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',               'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',             'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', '叉烧卷'),
      (2300004, now(), now(), '1000-01-01', 0, 2100004, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',       'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', '酸辣土豆丝蛋饼'),
      (2300005, now(), now(), '1000-01-01', 0, 2100005, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', '(蛋饼)德式烤鸡肉味'),
      (2300006, now(), now(), '1000-01-01', 0, 2100006, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',           'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', '叉烧蛋饼'),
      (2300007, now(), now(), '1000-01-01', 0, 2100007, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',               'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', '原味豆浆'),
      (2300008, now(), now(), '1000-01-01', 0, 2100008, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',               'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', '原味米浆'),
      (2300009, now(), now(), '1000-01-01', 0, 2100009, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', '玫瑰乌龙'),
      (2300010, now(), now(), '1000-01-01', 0, 2100010, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                      'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', '港式奶茶'),
      (2300011, now(), now(), '1000-01-01', 0, 2100011, 2530103, 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_d.png', '鸡肉十分脆'),
      (2300012, now(), now(), '1000-01-01', 0, 2100012, 2530103, 'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',       'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_d.png', '叉烧拿破仑'),
      (2300013, now(), now(), '1000-01-01', 0, 2100013, 2530103, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',          'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', '菌菇三鲜脆饺'),
      (2300014, now(), now(), '1000-01-01', 0, 2100014, 2530103, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',          'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', '猪肉玉米脆饺'),
      (2300015, now(), now(), '1000-01-01', 0, 2100015, 2530103, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',                 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', '时蔬蛋炒饭'),
      (2300016, now(), now(), '1000-01-01', 0, 2100016, 2530103, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', '(炒饭)德式烤鸡肉味'),
      (2300017, now(), now(), '1000-01-01', 0, 2100017, 2530103, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',            'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', '(饭)德式烤鸡肉味'),
      (2300018, now(), now(), '1000-01-01', 0, 2100018, 2530103, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',                 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', '松茸菌菇汤'),
      (2300019, now(), now(), '1000-01-01', 0, 2100018, 2530103, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',         'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', '莲藕排骨汤'),
      (2300020, now(), now(), '1000-01-01', 0, 2100019, 2530103, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',               'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', '黑沙流心酥'),
      (2300021, now(), now(), '1000-01-01', 0, 2100019, 2530103, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                    'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', 'QQ哒'),
      (2300022, now(), now(), '1000-01-01', 0, 2100002, 2530103, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRoll_mn.png',  'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRoll_mn.png',     'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRoll_mn.png', '(卷饼半份)德式烤鸡肉味'),
      (2300023, now(), now(), '1000-01-01', 0, 2100022, 2530103, 'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',             'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png',                'http://static.lianglife.com/Menu_Product/icon/EggSandwichMeal_mn.png', '鸡蛋十分脆')
;


INSERT INTO `ctr_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`,`region_id`,`timezone`,`position`,`map_type`,`address`,`store_type`,`place_type`,`union_type`,`square`,`square_unit`,`seat_count`,`manager_name`,`manager_phone`,`photo1`,`photo2`,`photo3`,`photo4`,`photo5`,`opening_ldt`,`expired_ldt`,`inner_only`,`eat_inside`,`sell_mode`,`send_area_gmap`,`send_area_json`,`tax_rate`,`sendouter_id`,`scenario_id`, `store_num`)
VALUES(2800001,now(),now(),'1000-01-01',0,'虹桥天街店',4010102,1000900,10100,'','','',4010201,4010304,4010401,'120','平方米','20','J','15994234567','','','','','','2019-10-01','2029-10-01',true,true,'自提,外送','','',0,0,'3100001', '2800001');

INSERT INTO `ctr_scenario`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`desc`,`img_advt`,`currency`,`status`)
VALUES(3100001, now(), now(), '1000-01-01', 0, '上海地区通用方案', '', 'http://static.lianglife.com/HomePage/homePage.png', 'CNY', 3710102);

INSERT INTO `ctr_scenario_region`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`region_id`,`store_type`,`place_type`)
VALUES(4000000, now(), now(), '1000-01-01', 0, 3100001, 1000900, 4010201, 4010304);

INSERT INTO `ctr_scenario_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`store_id`)
VALUES(3200001, now(), now(), '1000-01-01', 0,3100001,2800001);

INSERT INTO `ctr_proposal`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`img_icon`,`img_mini`,`img_face`,`timezone`,`open_ldt`,`shut_ldt`,`price_list`,`price_sell`,`price_rule`,`status`,`ranking`,`sell_time`,`name`,`alias`,`desc`)
VALUES(3300001, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',                'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  1, '1200106', '酸辣土豆丝卷', 'Hot & Sour Potato Crispy Roll','经典酸辣的川菜风味，爽口开胃，土豆丝根根分明脆而不生，滑而不腻，搭配严格把控40s煎制的饼皮，使酥脆口感x2。'),
      (3300002, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png',             'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',   'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  2, '1200106', '(卷)德式烤鸡肉味', 'German BBQ Chicken Crispy Roll','采用进口德式工艺烤肉机，45min猛火炙烤，现烤先削，美味更直接！烤前秘制酱料腌制入味，使恰到好处的肉汁在口中迸发美味。'),
      (3300003, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',               'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',          'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  3, '1200106', '叉烧卷', 'Roast Pork Crispy Roll','选用整块腌制猪颈肉，肥瘦均衡，鲜甜多汁，配以秘制的酸甜酱，搭配爽口紫甘蓝和洋葱，口感鲜脆、刺激食欲。'),
      (3300004, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  4, '1200106', '酸辣土豆丝蛋饼', 'Hot & Sour Potato Omelette','经典酸辣的川菜风味，爽口开胃，健康超薄的粗粮蛋饼皮，搭配爽口蔬菜，少油+薄韧+酸爽，满满过瘾回味。'),
      (3300005, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  5, '1200106', '(蛋饼)德式烤鸡肉味', 'German BBQ Chicken Omelette','精选低脂带皮去骨鸡腿肉，反复滚揉入味，德式工艺45min猛火炙烤，保持肉质原有鲜香同时，更加肉汁丰盈。'),
      (3300006, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  6, '1200106', '叉烧蛋饼', 'Roast Pork Omelette','选用整块腌制猪颈肉，肥瘦均衡，秘制酸甜酱，搭配脆爽紫甘蓝，粗粮蛋饼皮搭配，软嫩多汁同时，碰撞鲜甜滋味。'),
      (3300007, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  7, '1200106', '原味豆浆', 'Soya Bean Original','精选优质大豆，颗颗饱满，豆味浓郁。采用先进制浆工艺，脱腥去渣，保留大豆原香。入口浓郁醇厚不甜腻，细腻顺滑。'),
      (3300008, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  8, '1200106', '原味米浆', 'Rice Milk Original','健康谷物大米，冬日温暖饮品，浓郁香醇，香、甜、浓，甘甜不腻，入喉丝滑，满口米香回味。'),
      (3300009, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  9, '1200106', '玫瑰乌龙', 'Rose Oolong Tea','精选食用级重瓣玫瑰，经工艺处理，以净花瓣付窨。搭配台湾洞顶乌龙茶汤，花香茶香呼应，齿颊留香，回味甘鲜。'),
      (3300010, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 10, '1200106', '港式奶茶', 'HK Style Milk Tea','采用斯里兰卡进口红茶，这里出产的红茶香味浓郁，带花香，且涩味少。经撞茶工序，保留茶叶的浓厚，口感爽滑，延绵细密。'),
      (3300011, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/GermanBBQChickenSandwich_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 11, '1200101', '鸡肉十分脆', 'German BBQ Chicken Sandwich','滚揉腌制的鲜嫩鸡肉，遇到粮手抓独家“十分脆”酱料，满满芝麻焦香，更有拿破仑松脆饼皮，多层口感，一口入魂。'),
      (3300012, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_b.png',    'http://static.lianglife.com/Menu_Product/Napoleon/RoastPorkMilleFeuille_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 12, '1200101', '叉烧拿破仑', 'Roast Pork Mille-feuille','法式经典甜品拿破仑，有千层酥皮之意，粮手抓拿破仑同样松化酥脆，层次丰盈，内里蜜汁叉烧，肉香缠绕，畅享口腹之欲。'),
      (3300013, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',       'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 13, '1200101', '菌菇三鲜脆饺', 'Mushroom Dumplings','内馅精选猪腿肉，搭配杏鲍菇、茶树菇，饺皮是国内目前最薄面皮之一，皮馅比极高，真正皮薄馅大。用铜板煎制金黄焦脆，喷香诱人。'),
      (3300014, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',       'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 14, '1200101', '猪肉玉米脆饺', 'Pork  and Corn Dumplings','肥瘦均匀肉馅，搭配鲜甜玉米，鲜香爽口，薄韧劲道的小麦粉面皮，包裹满满内馅，煎至酥黄，既薄边足馅，又外脆里嫩。'),
      (3300015, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 15, '1200102,1200104', '时蔬蛋炒饭', 'Veggie Fried Rice','蛋香味与时令蔬菜鲜甜融合，大块蛋粒分量十足，让你感受家一样真材实料，色彩搭配令人食欲大开，口感松软，更显家常美味。'),
      (3300016, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',    'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 16, '1200102,1200104', '(炒饭)德式烤鸡肉味', 'German BBQ Chicken Fried Rice','由十多种香料调制的拌饭酱汁，搭配稻花香米饭，嫩滑有嚼劲。筋糯米粒+德式烤肉+蒸烤蔬菜，汁香过瘾，食欲大开。'),
      (3300017, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',         'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 17, '1200102,1200104', '(饭)德式烤鸡肉味', 'German BBQ Chicken Rice ','由十多种香料调制的拌饭酱汁，搭配稻花香米饭，嫩滑有嚼劲。筋糯米粒+德式烤肉+蒸烤蔬菜，汁香过瘾，食欲大开。'),
      (3300018, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 18, '1200102,1200104', '松茸菌菇汤', 'Mushroom Truffle Soup','精选云南松茸、虎掌菌、七彩菌、雪茸菌四种野生菌菇，菌肉肥厚，质地细腻，文火熬制80min，入口即感受到来自大自然的至鲜之味。'),
      (3300019, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 19, '1200102,1200104', '莲藕排骨汤', 'Lotus Root and Pork Rib Soup','冬季时令汤品，熬至汤汁香浓，莲藕软糯，搭配清甜莲子，爽口不腻，肉的鲜+藕的甜，温润滋补，营养首选。'),
      (3300020, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',            'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 20, '1200103', '黑沙流心酥', 'Black Sesame Puff','流沙酥表皮千层金黄脆皮，内馅是黑沙流心，带有芝麻的醇香。清脆起酥的表皮与浓厚软滑的芝麻流心，相得益彰，入口香甜不腻人。'),
      (3300021, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                 'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101, 21, '1200103', 'QQ哒', 'Icy Pudding','甜心芒果+烈焰草莓+清新香草，畅享三种口味糯米滋，浓郁椰蓉丝，柔糯饼皮，绵冰雪滋心，三层口感带来奇妙滋味。'),

      -- 套餐1
      (3300022, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/EggSandwichMeal_b.png',                       'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/EggSandwichMeal_b.png',                    'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/EggSandwichMeal_d.png', 10100, '2019-10-1', '2029-10-1', 10, 10, 3510202, 3510101, 22, '1200101', '鸡蛋十分脆套餐', 'Egg Sandwich Meal',''),
      -- 套餐2
      (3300023, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/miniGermanBBQChickenCrispyRollMeal_b.png',    'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/miniGermanBBQChickenCrispyRollMeal_b.png', 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/miniGermanBBQChickenCrispyRollMeal_d.png', 10100, '2019-10-1', '2029-10-1', 10, 10, 3510202, 3510101, 23, '1200101', '(卷饼半份套餐)德式烤鸡肉味', 'German BBQ Chicken Crispy Roll Meal',''),
      -- 套餐3
      (3300024, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/DumplingMeal_b.png',                          'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/DumplingMeal_b.png',                       'http://static.lianglife.com/Menu_Product/comboMeal/Breakfast/DumplingMeal_d.png', 10100, '2019-10-1', '2029-10-1', 12, 12, 3510202, 3510101, 24, '1200101', '脆饺套餐', 'Dumpling Meal',''),
      -- 套餐4
      (3300025, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRollMeal_b.png',         'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRollMeal_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRollMeal_d.png', 10100, '2019-10-1', '2029-10-1', 24, 24, 3510202, 3510101, 25, '1200102,1200104', '(卷饼套餐)德式烤鸡肉味', 'German BBQ Chicken Crispy Roll Meal',''),
      -- 套餐5
      (3300026, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenFriedRiceMeal_b.png',    'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenFriedRiceMeal_b.png', 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenFriedRiceMeal_d.png', 10100, '2019-10-1', '2029-10-1', 28, 28, 3510202, 3510101, 26, '1200102,1200104', '(炒饭套餐)德式烤鸡肉味', 'German BBQ Chicken Fried Rice Meal',''),
      -- 套餐6
      (3300027, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRiceMeal_b.png',         'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRiceMeal_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/LunchandDinner/GermanBBQChickenRiceMeal_d.png', 10100, '2019-10-1', '2029-10-1', 30, 30, 3510202, 3510101, 27, '1200102,1200104', '(饭套餐)德式烤鸡肉味', 'German BBQ Chicken Rice Meal',''),
      -- 套餐7
      (3300028, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/BlackSesamePuffSVM_b.png',                 'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/BlackSesamePuffSVM_b.png',              'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/BlackSesamePuffSVM_d.png', 10100, '2019-10-1', '2029-10-1', 16, 16, 3510202, 3510101, 28, '1200103', '黑沙流心酥套餐', 'Black Sesame Pastry Meal',''),
      -- 套餐8
      (3300029, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/IcyPuddingMeal_b.png',                     'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/IcyPuddingMeal_b.png',                  'http://static.lianglife.com/Menu_Product/comboMeal/AfternoonTea/IcyPuddingMeal_d.png', 10100, '2019-10-1', '2029-10-1', 16, 16, 3510202, 3510101, 29, '1200103', 'QQ哒套餐', 'Icy Pudding Meal','')
;

INSERT INTO `ctr_proposal_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`bundle_id`,`product_id`,`commodity_id`,`price_list`,`price_sell`,`buy_min`,`buy_max`,`show_price`,`selected`,`ranking`,`name`)
VALUES(3500001, now(), now(), '1000-01-01', 0, 3300001 ,0, 2100001, 2300001, 12, 12, 1, 1, true, true, 1, '酸辣土豆丝卷'),
      (3500002, now(), now(), '1000-01-01', 0, 3300002 ,0, 2100002, 2300002, 20, 20, 1, 1, true, true, 2, '德式烤鸡肉卷'),
      (3500003, now(), now(), '1000-01-01', 0, 3300003 ,0, 2100003, 2300003, 22, 22, 1, 1, true, true, 3, '叉烧卷'),
      (3500004, now(), now(), '1000-01-01', 0, 3300004 ,0, 2100004, 2300004, 12, 12, 1, 1, true, true, 4, '酸辣土豆丝蛋饼'),
      (3500005, now(), now(), '1000-01-01', 0, 3300005 ,0, 2100005, 2300005, 20, 20, 1, 1, true, true, 5, '德式烤鸡肉蛋饼'),
      (3500006, now(), now(), '1000-01-01', 0, 3300006 ,0, 2100006, 2300006, 22, 22, 1, 1, true, true, 6, '叉烧蛋饼'),
      (3500007, now(), now(), '1000-01-01', 0, 3300007 ,0, 2100007, 2300007, 6, 6, 1, 1, true, true,  7, '原味豆浆'),
      (3500008, now(), now(), '1000-01-01', 0, 3300008 ,0, 2100008, 2300008, 6, 6, 1, 1, true, true,  8, '原味米浆'),
      (3500009, now(), now(), '1000-01-01', 0, 3300009 ,0, 2100009, 2300009, 10, 10, 1, 1, true, true, 9, '玫瑰乌龙'),
      (3500010, now(), now(), '1000-01-01', 0, 3300010 ,0, 2100010, 2300010, 10, 10, 1, 1, true, true, 10, '港式奶茶'),
      (3500011, now(), now(), '1000-01-01', 0, 3300011 ,0, 2100011, 2300011, 24, 24, 1, 1, true, true, 11, '鸡肉十分脆'),
      (3500012, now(), now(), '1000-01-01', 0, 3300012 ,0, 2100012, 2300012, 26, 26, 1, 1, true, true, 12, '叉烧拿破仑'),
      (3500013, now(), now(), '1000-01-01', 0, 3300013 ,0, 2100013, 2300013, 10, 10, 1, 1, true, true, 13, '菌菇三鲜脆饺'),
      (3500014, now(), now(), '1000-01-01', 0, 3300014 ,0, 2100014, 2300014, 10, 10, 1, 1, true, true, 14, '猪肉玉米脆饺'),
      (3500015, now(), now(), '1000-01-01', 0, 3300015 ,0, 2100015, 2300015, 16, 16, 1, 1, true, true, 15, '时蔬蛋炒蛋'),
      (3500016, now(), now(), '1000-01-01', 0, 3300016 ,0, 2100016, 2300016, 24, 24, 1, 1, true, true, 16, '德式烤鸡肉蛋炒饭'),
      (3500017, now(), now(), '1000-01-01', 0, 3300017 ,0, 2100017, 2300017, 26, 26, 1, 1, true, true, 17, '德式烤鸡肉饭'),
      (3500018, now(), now(), '1000-01-01', 0, 3300018 ,0, 2100018, 2300018, 12, 12, 1, 1, true, true, 18, '松茸菌菇汤'),
      (3500019, now(), now(), '1000-01-01', 0, 3300019 ,0, 2100019, 2300019, 16, 16, 1, 1, true, true, 19, '莲藕排骨汤'),
      (3500020, now(), now(), '1000-01-01', 0, 3300020 ,0, 2100020, 2300020, 10, 10, 1, 1, true, true, 20, '黑沙流心酥'),
      (3500021, now(), now(), '1000-01-01', 0, 3300021 ,0, 2100021, 2300021, 10, 10, 1, 1, true, true, 21, 'QQ哒'),

      -- 八个套餐数据

      -- 套餐1
      (3500022, now(), now(), '1000-01-01', 0, 3300022 ,3900001, 2100022, 2300023, 0, 0, 1, 1, true, true, 22, '鸡蛋十分脆'),
      (3500023, now(), now(), '1000-01-01', 0, 3300022 ,3900002, 2100007, 2300007, 0, 0, 0, 1, true, false, 23, '原味豆浆'),
      (3500024, now(), now(), '1000-01-01', 0, 3300022 ,3900002, 2100008, 2300008, 0, 0, 0, 1, true, false, 24, '原味米浆'),
      -- 套餐2
      (3500025, now(), now(), '1000-01-01', 0, 3300023 ,3900003, 2100002, 2300022, 0, 0, 1, 1, true, true, 25, '德式烤鸡肉卷(半份)'),
      (3500026, now(), now(), '1000-01-01', 0, 3300023 ,3900004, 2100007, 2300007, 0, 0, 0, 1, true, false, 26, '原味豆浆'),
      (3500027, now(), now(), '1000-01-01', 0, 3300023 ,3900004, 2100008, 2300008, 0, 0, 0, 1, true, false, 27, '原味米浆'),
      -- 套餐3
      (3500028, now(), now(), '1000-01-01', 0, 3300024 ,3900005, 2100013, 2300013, 0, 0, 0, 1, true, false, 28, '菌菇三鲜脆饺'),
      (3500029, now(), now(), '1000-01-01', 0, 3300024 ,3900005, 2100014, 2300014, 0, 0, 0, 1, true, false, 29, '猪肉玉米脆饺'),
      (3500030, now(), now(), '1000-01-01', 0, 3300024 ,3900006, 2100007, 2300007, 0, 0, 0, 1, true, false, 30, '原味豆浆'),
      (3500031, now(), now(), '1000-01-01', 0, 3300024 ,3900006, 2100008, 2300008, 0, 0, 0, 1, true, false, 31, '原味米浆'),
      -- 套餐4（含加价购）
      (3500032, now(), now(), '1000-01-01', 0, 3300025 ,3900007, 2100002, 2300002, 0, 0, 1, 1, true, true, 32, '德式烤鸡肉卷'),
      (3500033, now(), now(), '1000-01-01', 0, 3300025 ,3900008, 2100018, 2300018, 0, 0, 0, 1, true, false, 33, '松茸菌菇汤'),
      (3500034, now(), now(), '1000-01-01', 0, 3300025 ,3900008, 2100019, 2300019, 4, 4, 0, 1, true, false, 34, '莲藕排骨汤'),
      -- 套餐5（含加价购）
      (3500035, now(), now(), '1000-01-01', 0, 3300026 ,3900009, 2100016, 2300016, 0, 0, 1, 1, true, true, 35, '德式烤鸡肉蛋炒饭'),
      (3500036, now(), now(), '1000-01-01', 0, 3300026 ,3900010, 2100018, 2300018, 0, 0, 0, 1, true, false, 36, '松茸菌菇汤'),
      (3500037, now(), now(), '1000-01-01', 0, 3300026 ,3900010, 2100019, 2300019, 4, 4, 0, 1, true, false, 37, '莲藕排骨汤'),
      -- 套餐6（含加价购）
      (3500038, now(), now(), '1000-01-01', 0, 3300027 ,3900011, 2100017, 2300017, 0, 0, 1, 1, true, true, 38, '德式烤鸡肉饭'),
      (3500039, now(), now(), '1000-01-01', 0, 3300027 ,3900012, 2100018, 2300018, 0, 0, 0, 1, true, false, 39, '松茸菌菇汤'),
      (3500040, now(), now(), '1000-01-01', 0, 3300027 ,3900012, 2100019, 2300019, 4, 4, 0, 1, true, false, 40, '莲藕排骨汤'),
      -- 套餐7
      (3500041, now(), now(), '1000-01-01', 0, 3300028 ,3900013, 2100020, 2300020, 0, 0, 1, 1, true, true, 41, '黑沙流心酥'),
      (3500042, now(), now(), '1000-01-01', 0, 3300028 ,3900014, 2100009, 2300009, 0, 0, 0, 1, true, false, 42, '玫瑰乌龙'),
      (3500043, now(), now(), '1000-01-01', 0, 3300028 ,3900014, 2100010, 2300010, 0, 0, 0, 1, true, false, 43, '港式奶茶'),
      -- 套餐8
      (3500044, now(), now(), '1000-01-01', 0, 3300029 ,3900015, 2100021, 2300021, 0, 0, 1, 1, true, true, 44, 'QQ哒'),
      (3500045, now(), now(), '1000-01-01', 0, 3300029 ,3900016, 2100009, 2300009, 0, 0, 0, 1, true, false, 45, '玫瑰乌龙'),
      (3500046, now(), now(), '1000-01-01', 0, 3300029 ,3900016, 2100010, 2300010, 0, 0, 0, 1, true, false, 46, '港式奶茶')
;


INSERT INTO `ctr_scenario_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`name`,`img_icon`,`desc`,`visible`,`topmenu`,`ranking`)
VALUES(3700001, now(), now(), '1000-01-01', 0, 3100001, '脆饼卷',   'http://static.lianglife.com/BroadSideIcon/crispyRoll.png', '', true, false, 1),
      (3700002, now(), now(), '1000-01-01', 0, 3100001, '蛋饼卷',   'http://static.lianglife.com/BroadSideIcon/eggPie.png', '', true, false, 2),
      (3700003, now(), now(), '1000-01-01', 0, 3100001, '热饮',     'http://static.lianglife.com/BroadSideIcon/hotDrinks.png', '', true, false, 3),
      (3700004, now(), now(), '1000-01-01', 0, 3100001, '拿破仑',   'http://static.lianglife.com/BroadSideIcon/crispCharge.png', '', true, false, 4),
      (3700005, now(), now(), '1000-01-01', 0, 3100001, '脆饺',     'http://static.lianglife.com/BroadSideIcon/dumplings.png', '', true, false, 5),
      (3700006, now(), now(), '1000-01-01', 0, 3100001, '饭',       'http://static.lianglife.com/BroadSideIcon/rice.png', '', true, false, 6),
      (3700007, now(), now(), '1000-01-01', 0, 3100001, '汤',       'http://static.lianglife.com/BroadSideIcon/soup.png', '', true, false, 7),
      (3700008, now(), now(), '1000-01-01', 0, 3100001, '点心',     'http://static.lianglife.com/BroadSideIcon/snack.png', '', true, false, 8),
      (3700009, now(), now(), '1000-01-01', 0, 3100001, '人气推荐',  'http://static.lianglife.com/BroadSideIcon/recommend.png', '', true, true, 9),
      (3700010, now(), now(), '1000-01-01', 0, 3100001, '精选套餐',  'http://static.lianglife.com/BroadSideIcon/comboMeal.png', '', true, true, 10)
;


INSERT INTO `ctr_proposal_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`scenmenu_id`)
VALUES(3800001, now(), now(), '1000-01-01', 0, 3300001, 3700001),
      (3800002, now(), now(), '1000-01-01', 0, 3300002, 3700001),
      (3800003, now(), now(), '1000-01-01', 0, 3300003, 3700001),
      (3800004, now(), now(), '1000-01-01', 0, 3300004, 3700002),
      (3800005, now(), now(), '1000-01-01', 0, 3300005, 3700002),
      (3800006, now(), now(), '1000-01-01', 0, 3300006, 3700002),
      (3800007, now(), now(), '1000-01-01', 0, 3300007, 3700003),
      (3800008, now(), now(), '1000-01-01', 0, 3300008, 3700003),
      (3800009, now(), now(), '1000-01-01', 0, 3300009, 3700003),
      (3800010, now(), now(), '1000-01-01', 0, 3300010, 3700003),
      (3800011, now(), now(), '1000-01-01', 0, 3300011, 3700004),
      (3800012, now(), now(), '1000-01-01', 0, 3300012, 3700004),
      (3800013, now(), now(), '1000-01-01', 0, 3300013, 3700005),
      (3800014, now(), now(), '1000-01-01', 0, 3300014, 3700005),
      (3800015, now(), now(), '1000-01-01', 0, 3300015, 3700006),
      (3800016, now(), now(), '1000-01-01', 0, 3300016, 3700006),
      (3800017, now(), now(), '1000-01-01', 0, 3300017, 3700006),
      (3800018, now(), now(), '1000-01-01', 0, 3300018, 3700007),
      (3800019, now(), now(), '1000-01-01', 0, 3300019, 3700007),
      (3800020, now(), now(), '1000-01-01', 0, 3300020, 3700008),
      (3800021, now(), now(), '1000-01-01', 0, 3300021, 3700008),

      -- 八个套餐
      (3800022, now(), now(), '1000-01-01', 0, 3300022, 3700010),
      (3800023, now(), now(), '1000-01-01', 0, 3300023, 3700010),
      (3800024, now(), now(), '1000-01-01', 0, 3300024, 3700010),
      (3800025, now(), now(), '1000-01-01', 0, 3300025, 3700010),
      (3800026, now(), now(), '1000-01-01', 0, 3300026, 3700010),
      (3800027, now(), now(), '1000-01-01', 0, 3300027, 3700010),
      (3800028, now(), now(), '1000-01-01', 0, 3300028, 3700010),
      (3800029, now(), now(), '1000-01-01', 0, 3300029, 3700010),

      -- 人气推荐（主推）
      (3800030, now(), now(), '1000-01-01', 0, 3300002, 3700009),
      (3800031, now(), now(), '1000-01-01', 0, 3300017, 3700009),
      (3800032, now(), now(), '1000-01-01', 0, 3300022, 3700009),
      (3800033, now(), now(), '1000-01-01', 0, 3300027, 3700009),
      (3800034, now(), now(), '1000-01-01', 0, 3300028, 3700009)
;


INSERT INTO `ctr_proposal_bundle`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`name`,`buy_num`,`ranking`)
VALUES(3900001, now(), now(), '1000-01-01', 0, 3300022, '必选', 1, 1),
      (3900002, now(), now(), '1000-01-01', 0, 3300022, '饮品', 1, 2),

      (3900003, now(), now(), '1000-01-01', 0, 3300023, '必选', 1, 1),
      (3900004, now(), now(), '1000-01-01', 0, 3300023, '饮品', 1, 2),

      (3900005, now(), now(), '1000-01-01', 0, 3300024, '脆饺', 1, 1),
      (3900006, now(), now(), '1000-01-01', 0, 3300024, '饮品', 1, 2),

      (3900007, now(), now(), '1000-01-01', 0, 3300025, '必选', 1, 1),
      (3900008, now(), now(), '1000-01-01', 0, 3300025, '汤', 1, 2),

      (3900009, now(), now(), '1000-01-01', 0, 3300026, '必选', 1, 1),
      (3900010, now(), now(), '1000-01-01', 0, 3300026, '汤', 1, 2),

      (3900011, now(), now(), '1000-01-01', 0, 3300027, '必选', 1, 1),
      (3900012, now(), now(), '1000-01-01', 0, 3300027, '汤', 1, 2),

      (3900013, now(), now(), '1000-01-01', 0, 3300028, '必选', 1, 1),
      (3900014, now(), now(), '1000-01-01', 0, 3300028, '饮品', 1, 2),

      (3900015, now(), now(), '1000-01-01', 0, 3300029, '必选', 1, 1),
      (3900016, now(), now(), '1000-01-01', 0, 3300029, '饮品', 1, 2)
;


INSERT INTO `ctr_account_balance`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`account_id`,`money_type`,`currency`,`balance`,`credit`,`status`)
VALUES('0',now(), now(), '1000-01-01', 0, 0, 5510101, 'CNY', 0, 2147483647, 5520201),
      ('1',now(), now(), '1000-01-01', 0, 1, 5510101, 'CNY', 0, 2147483647, 5520201)
;

-- Finish
