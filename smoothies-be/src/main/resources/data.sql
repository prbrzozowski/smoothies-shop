
INSERT INTO smoothies(id,name, description) VALUES (1,'Strawberry Banana Smoothie','Great one 1');
INSERT INTO smoothies(id,name, description) VALUES (2,'Tropical Smoothie','Great one 2');
INSERT INTO smoothies(id,name, description) VALUES (3,'Peach Smoothie','Great one 3');
INSERT INTO smoothies(id,name, description) VALUES (4,'Raspberry Smoothie','Great one 4');
INSERT INTO smoothies(id,name, description) VALUES (5,'Pina Colada Oat Breakfast Smoothie','Great one 5');

INSERT INTO smoothie_details(id,smoothie_id, name, description) VALUES (1,1,'Abc1','Test description1');
INSERT INTO smoothie_details(id,smoothie_id, name, description) VALUES (2,1,'Abc2','Test description2');

INSERT INTO smoothie_details(id,smoothie_id, name, description) VALUES (3,2,'Abc1','Test description1');
INSERT INTO smoothie_details(id,smoothie_id, name, description) VALUES (4,2,'Abc2','Test description2');

COMMIT;

