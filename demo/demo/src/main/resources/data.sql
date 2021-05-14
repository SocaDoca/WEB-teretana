insert into USER (id,username,password,name,surname,phone,email,date_of_birth,role,active) values (1,'losmi11','test','Milos','Rankovic','123456','ranko502@gmail.com','20-01-1999',1,true);
insert into USER (id,username,password,name,surname,phone,email,date_of_birth,role,active) values (2,'evaRas','test4','Eva','Ras','1234','ras@gmail.com','31-06-1997',2,false );
insert into USER (id,username,password,name,surname,phone,email,date_of_birth,role,active) values (3,'BabaRoga','test1','Baba','Roga','1234567','buba@gmail.com','19-07-1997',3,true);

insert into TRAINING (id, name, description, type, duration, rating, trainer_id) values (1,'trening1','trcanje po traci','kardio','1h i 30min','3',2);
insert into TRAINING (id, name, description, type, duration, rating, trainer_id) values (2,'trening2','dizanje tegova','snaga','1h','4.3',2);

insert into GYM (id, name, address, phone_num,email) values (1,'FULL Gym', 'Dr.Sime 24, Novi Sad', '1234567','fullgym@gmail.com');
insert into GYM (id, name, address, phone_num,email) values (2,'OLP', 'Strazilovska 9a, Novi Sad', '14609565','opl@gmail.com');

insert into ROOM(id, capacity, mark, gym_id) values (1,35,'MIA21',2);
insert into ROOM(id, capacity, mark, gym_id) values (2,15,'L13',1);

insert into DONE_TRAINING(id, rating, training_id , member_id, user_id) values (1, 4.52, 2, 1, 2);

insert  into SCHEDULE(id, day, price, room_id) values (1, '2021-05-13', '500din',1);

insert into SCHEDULE_ROOMS (training_schedule_id, rooms_id) values (1,2);

insert into RESERVED_TRAINING(id, training_id, member_id, training_schedule_id, user_id) values(1,2,2,1,1);