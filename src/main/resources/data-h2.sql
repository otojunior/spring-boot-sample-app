insert into item (versao, codigo, nome, preco) values (0, 100, 'Alicate', 35.20);
insert into item (versao, codigo, nome, preco) values (0, 150, 'Martelo', 40.85);
insert into item (versao, codigo, nome, preco) values (0, 200, 'Parafuso', 1.55);
insert into item (versao, codigo, nome, preco) values (0, 250, 'Furadeira', 89.90);
insert into item (versao, codigo, nome, preco) values (0, 300, 'Serrote', 15.00);
insert into item (versao, codigo, nome, preco) values (0, 350, 'Trena', 22.20);
insert into item (versao, codigo, nome, preco) values (0, 400, 'Estilete', 5.50);
insert into item (versao, codigo, nome, preco) values (0, 450, 'Tesoura', 8.90);
insert into item (versao, codigo, nome, preco) values (0, 500, 'Lanterna', 18.50);
insert into item (versao, codigo, nome, preco) values (0, 550, 'Escada', 32.10);
insert into item (versao, codigo, nome, preco) values (0, 600, 'Durepox', 3.25);
insert into item (versao, codigo, nome, preco) values (0, 650, 'Cola', 4.35);

insert into users (versao, username, password, enabled) values (0, 'admin', '$2a$10$qQsGCq9556LpIYN5pjjJ1OhXgeFbRWPhV3gLgpsbwKUfFWth8xgmO', true);
insert into users (versao, username, password, enabled) values (0, 'user', '$2a$10$qAlEAmBr2bUFqCCbjrXwLuGpqadctWNQ8TgBwGwJ0RKrb/TUx3zeG', true);

insert into authorities (versao, username, authority) values(0, 'admin', 'ROLE_ADMIN');
insert into authorities (versao, username, authority) values(0, 'admin', 'ROLE_USER');
insert into authorities (versao, username, authority) values(0, 'user', 'ROLE_USER');