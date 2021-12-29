INSERT INTO USERS(id, username,password)
VALUES ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', 'user', '{bcrypt}$2a$10$jYIbAef1H7S.womsk7MRtOCSEx/DgM7CZ1nNeLLzoZ/OPs0a25DV2'), /*pass->user*/
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', 'admin','{bcrypt}$2a$10$VylYhXDaKC7W28tQTvYYkOdZIj2pnPVIobXOConbXy3xeBcF6Xuni'); /*pass->user*/

INSERT INTO ROLES(id, name)
VALUES ('60dbb7bb-99a0-42eb-a837-8be6b697c074', 'USER'),
       ('3906c549-44bf-494b-9537-5e1658a029a8', 'ADMIN');

INSERT INTO USERS_ROLES(user_id, roles_id)
VALUES ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '3906c549-44bf-494b-9537-5e1658a029a8');
