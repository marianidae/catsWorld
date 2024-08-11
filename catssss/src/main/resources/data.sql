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

INSERT INTO `offers` (`id`, `description`,  `image_url`, `price`, `uuid`, `age` , `model_id`, `seller_id`)
VALUES
    (1, 'Big Cat 1!',  'https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg', 24000, 'b72e6550-e365-43bf-aab2-b57cafc2db7c', 3, 5, 1),
    (2, 'Big Cat 2!',  'https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg', 24000, 'b72e6550-e365-43bf-aab2-b57cafc2db71', 4, 5, 1),
    (3, 'Big Cat 3!',  'https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg', 24000, 'b72e6550-e365-43bf-aab2-b57cafc2db72', 1, 5, 2),
    (4, 'Big Cat 4!',  'https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg', 24000, 'b72e6550-e365-43bf-aab2-b57cafc2db73', 2, 5, 2),
    (5, 'Big Cat 5!',  'https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg', 24000, 'b72e6550-e365-43bf-aab2-b57cafc2db74', 1, 5, 2);