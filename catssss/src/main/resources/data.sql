INSERT INTO users (id, active, email, first_name, last_name, password)
VALUES
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (2, 1, 'user@example.com', 'User', 'Userov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');

--
INSERT INTO roles (`id`, `role`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles(`user_id`, `role_id`)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);


INSERT INTO `breeds` (`id`, `name`)
VALUES
    (1, 'Long Haired'),
    (2, 'Semi-Long Haired'),
    (3, 'Short Haired'),
    (4, 'Oriental');

INSERT INTO `models` (`id`, `category`, `breed_id`, `name`)
VALUES
    (1, 'LONG_HAIRED', 1, 'Persian'),
    (2, 'LONG_HAIRED', 1, 'Himalayan'),
    (3, 'SEMI_LONG_HAIRED', 2, 'Maine Coon'),
    (4, 'SEMI_LONG_HAIRED', 2, 'Siberian'),
    (5, 'SHORT_HAIRED', 3, 'Bengal'),
    (6, 'SHORT_HAIRED', 3, 'British'),
    (7, 'ORIENTAL', 4, 'Siamese'),
    (8, 'ORIENTAL', 4, 'Thai');

INSERT INTO `offers` (`id`, `description`,  `image_url`, `price`, `uuid`, `age` ,`gender`, `model_id`, `seller_id`)
VALUES
    (1, 'Big Cat 1!',  'https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg', 240, 'b72e6550-e365-43bf-aab2-b57cafc2db7c', 3,'MALE', 6, 1),
    (2, 'Big Cat 2!',  'https://cdn4.focus.bg/fakti/photos/big/861/jestokost-v-montana-trovat-kotki-s-antifriz-1.jpg', 300, 'b72e6550-e365-43bf-aab2-b57cafc2db71', 4,'MALE', 5, 1),
    (3, 'Big Cat 3!',  'https://trafficnews.bg/news/2022/11/14/nai-skapite-porodi-kotki-sveta-067.jpg', 150, 'b72e6550-e365-43bf-aab2-b57cafc2db72', 1,'MALE', 6, 2),
    (4, 'Big Cat 4!',  'https://vetworld.bg/wp-content/uploads/2023/07/cat1.png', 170, 'b72e6550-e365-43bf-aab2-b57cafc2db73', 2,'FEMALE', 7, 2),
    (5, 'Big Cat 5!',  'https://miau.bg/files/1200x800/persian-cat.webp', 230, 'b72e6550-e365-43bf-aab2-b57cafc2db74', 1,'FEMALE', 1, 2);