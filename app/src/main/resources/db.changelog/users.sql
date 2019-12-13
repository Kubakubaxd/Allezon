INSERT INTO userspsqla
VALUES ('admin', '$2a$10$HyIpLY/Ul.Zg1NjEWaGF0uCBqJ1e7vTVCf4ss9kclroZd1KrD7Qhe', 'Kuba', 'Kuba', 'admin@allezon.pl',
        '11/11/1111', true);
INSERT INTO userspsqla
VALUES ('grazyna', '$2a$10$HyIpLY/Ul.Zg1NjEWaGF0uCBqJ1e7vTVCf4ss9kclroZd1KrD7Qhe', 'Janusz', 'Bonk', 'janusz@wp.pl',
        '11/11/1111', false);
INSERT INTO userspsqla
VALUES ('janusz', '$2a$10$HyIpLY/Ul.Zg1NjEWaGF0uCBqJ1e7vTVCf4ss9kclroZd1KrD7Qhe', 'Janusz', 'Bonk', 'janusz@wp.pl',
        '11/11/1111', false);
INSERT INTO userspsqla
VALUES ('spejson', '$2a$10$HyIpLY/Ul.Zg1NjEWaGF0uCBqJ1e7vTVCf4ss9kclroZd1KrD7Qhe', 'Janusz', 'Bonk', 'janusz@wp.pl',
        '11/11/1111', false);

INSERT INTO section
VALUES (1, 'Osobowe');
INSERT INTO section
VALUES (2, 'Ciężarowe');
INSERT INTO section
VALUES (3, 'Motocykle');
INSERT INTO section
VALUES (4, 'Skutery');
INSERT INTO section
VALUES (5, 'Przyczepy');

INSERT INTO parameter
VALUES (1, 'Kolor');
INSERT INTO parameter
VALUES (2, 'Pojemność');
INSERT INTO parameter
VALUES (3, 'Masa');
INSERT INTO parameter
VALUES (4, 'Bagażnik');
INSERT INTO parameter
VALUES (5, 'Napęd');

INSERT INTO auction
VALUES (1, 'VW Passat', 1, 120000, 'janusz');
INSERT INTO auction
VALUES (2, 'VW Passat RS', 1, 250000, 'admin');
INSERT INTO auction
VALUES (3, 'VW Golf', 1, 40000, 'grazyna');
INSERT INTO auction
VALUES (4, 'Audi A3', 1, 200000, 'spejson');

INSERT INTO photo
VALUES (991, 1,
        'https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_900/https://reginatour.pl/wp-content/uploads/2016/02/volkswagen-passat-b7-1.jpg');
INSERT INTO photo
VALUES (992, 1,
        'https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_900/https://reginatour.pl/wp-content/uploads/2016/02/volkswagen-passat-b7-3.jpg');
INSERT INTO photo
VALUES (993, 2,
        'https://www.forumsamochodowe.pl/galeria/wojna-polnoc-poludnie-a124/volkswagen-passat-kombi-tuning-skaryszew-2012-m10065.jpg');
INSERT INTO photo
VALUES (994, 2,
        'https://www.forumsamochodowe.pl/galeria/wojna-polnoc-poludnie-a124/vw-golf-iii-tuning-zabudowa-car-audio-skaryszew-2012-m10062.jpg');
INSERT INTO photo
VALUES (995, 3,
        'https://s7g10.scene7.com/is/image/volkswagenag/Golf_Small_fleet_1920x1080?Zml0PWNyb3AsMSZmbXQ9d2VicCZxbHQ9Nzkmd2lkPTgwMCZoZWk9NDUwJmFsaWduPTAuMDAsMC4wMCYwYmQw');
INSERT INTO photo
VALUES (996, 3,
        'https://s7g10.scene7.com/is/image/volkswagenag/golf3?Zml0PWNyb3AsMSZmbXQ9d2VicCZxbHQ9Nzkmd2lkPTgwMCZoZWk9NDUwJmFsaWduPTAuMDAsMC4wMCYwYmQw');
INSERT INTO photo
VALUES (997, 4,
        'https://scontent-waw1-1.xx.fbcdn.net/v/t1.15752-9/p1080x2048/78879048_525287041395692_5467133136015982592_n.jpg?_nc_cat=100&_nc_ohc=6ooKNYXPVV0AQniVbwqGdjZkPVkqPDqf8PJlSzRGsfuOspR4H7-E828HA&_nc_ht=scontent-waw1-1.xx&oh=151a8e3fc5d044aa21a017e2e20978f5&oe=5EB2096F');
INSERT INTO photo
VALUES (998, 4,
        'https://scontent-waw1-1.xx.fbcdn.net/v/t1.15752-9/78381910_449448495965877_8070631908716838912_n.jpg?_nc_cat=105&_nc_ohc=dzuJka8AaXIAQmI_ls5C6NnsnuKkJloJBPA4W8nyF3KMERXXyq62twi_w&_nc_ht=scontent-waw1-1.xx&oh=2bb2aabc616a137948500ff87917bdeb&oe=5E740BDB');

INSERT INTO auction_parameter
VALUES (1, 2, '1.9');
INSERT INTO auction_parameter
VALUES (2, 2, '3.0');
INSERT INTO auction_parameter
VALUES (3, 2, '1.6');
INSERT INTO auction_parameter
VALUES (4, 2, '2.0');
INSERT INTO auction_parameter
VALUES (1, 5, 'FWD');
INSERT INTO auction_parameter
VALUES (2, 5, 'AWD');
INSERT INTO auction_parameter
VALUES (3, 5, 'FWD');
INSERT INTO auction_parameter
VALUES (4, 5, 'FWD');


