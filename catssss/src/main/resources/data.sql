INSERT INTO users (id, active, email, first_name, last_name, password)
VALUES
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (2, 1, 'user@example.com', 'User', 'Userov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');

--
INSERT INTO roles (`id`, `role`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');
--
-- -- INSERT INTO users_roles(`user_id`, `role_id`)
-- -- VALUES
-- --     (1, 1),
-- --     (1, 2),
-- --     (2, 2);
--
--
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

-- -- INSERT INTO `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `uuid`, `year`, `model_id`, `seller_id`)
-- -- VALUES
-- --     (1, 'Top Trabi 1!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2223, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db7c', 1985, 5, 1),
-- --     (2, 'Top Trabi 1!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2225, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db71', 1986, 5, 1),
-- --     (3, 'Top Trabi 2!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2227, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db72', 1987, 5, 2),
-- --     (4, 'Top Trabi 2!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2221, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db73', 1988, 5, 2),
-- --     (5, 'Top Trabi 2!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2220, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db74', 1989, 5, 2);