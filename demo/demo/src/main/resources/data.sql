insert into USER (id,username,password,name,surname,phone_number,email,date_of_birth,role,active) values (1,'losmi11','test','Milos','Rankovic','123456','ranko@gmail.com','20-01-1999',0,true);
insert into USER (id,username,password,name,surname,phone_number,email,date_of_birth,role,active) values (2,'evaRas','test4','Eva','Ras','1234','ras@gmail.com','31-06-1997',2,true);
insert into USER (id,username,password,name,surname,phone_number,email,date_of_birth,role,active) values (3,'BabaRoga','test1','Baba','Roga','1234567','buba@gmail.com','19-07-1997',1,true);

insert into TRAINING (id, name, description, type, duration, rating) values (1,'trening1','running 30km','CARDIO','130','3');
insert into TRAINING (id, name, description, type, duration, rating) values (2,'trening2','WEIGHTs','STRENGHT','100','4.3');
insert into TRAINING (id, name, description, type, duration, rating) values (3,'trening3','Fat burn and strenght','HIIT','20','4.3');
insert into TRAINING (id, name, description, type, duration, rating) values (4,'trening4','Bicyle','SPINNING','100','4.3');


insert into GYM (id, name, address, phone_number,email) values (1,'FULL Gym', 'Dr.Sime 24, Novi Sad', '1234567','full@gmail.com');
insert into GYM (id, name, address, phone_number,email) values (2,'OLIMP', 'Strazilovska 9a, Novi Sad', '14609565','olimp@gmail.com');
insert into GYM (id, name, address, phone_number,email) values (3,'FLEX GYM', 'Bulevar Oslobodjenja 9a, Novi Sad', '14609565','flex@gmail.com');
insert into GYM (id, name, address, phone_number,email) values (4,'MASL ACADAMY', 'Sumadijska 6, Novi Sad', '14609565','masl@gmail.com');
insert into GYM (id, name, address, phone_number,email) values (5,'TOTAL GYM', 'Lovcenska 20, Novi Sad', '14609565','ttlgym@gmail.com');



INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (1,200,'Sala 1',1);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (2,80,'Sala 2',1);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (3,60,'Sala 3',1);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (4,250,'Sala 4',1);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (5,400,'Sala 5',1);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (6,250,'Hala 1',2);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (7,120,'Hala 2',2);
INSERT INTO ROOM(id,capacity,mark,gym_id) VALUES (8,50,'Hala 3',2);


insert into DONE_TRAINING(id, rating, member_id,training_id  ) values (1, 4.52, 2, 1);
insert into DONE_TRAINING(id, rating, member_id,training_id  ) values (2, 4.52, 3, 2);
insert into DONE_TRAINING(id, rating, member_id,training_id  ) values (3, 4.52, 2, 4);
insert into DONE_TRAINING(id, rating, member_id,training_id  ) values (4, 4.52, 2, 3);
insert into DONE_TRAINING(id, rating, member_id,training_id  ) values (5, 4.52, 1, 4);

insert into SCHEDULE(id, day, price, time , gym_id , training_id) values (1, '2021-05-13', '500','19:00' ,1,1) ;
insert into SCHEDULE(id, day, price, time , gym_id , training_id) values (2, '2021-05-15', '500','19:00' ,1,2) ;
insert into SCHEDULE(id, day, price, time , gym_id , training_id) values (3, '2021-05-13', '500','19:00' ,1,3) ;
insert into SCHEDULE(id, day, price, time , gym_id , training_id) values (4, '2021-05-12', '500','19:00' ,1,4) ;
insert into SCHEDULE(id, day, price, time , gym_id , training_id) values (5, '2021-05-16', '500','19:00' ,1,2) ;

insert into ROOM_SCHEDULE  (schedule_id, room_id) values (1,2);
insert into ROOM_SCHEDULE  (schedule_id, room_id) values (3,5);
insert into ROOM_SCHEDULE  (schedule_id, room_id) values (4,8);

insert into RESERVATIONS(member_id, schedule_id) values(1,1);
insert into RESERVATIONS(member_id, schedule_id) values(2,2);
insert into RESERVATIONS(member_id, schedule_id) values(3,4);
insert into RESERVATIONS(member_id, schedule_id) values(1,4);
insert into RESERVATIONS(member_id, schedule_id) values(2,5);
